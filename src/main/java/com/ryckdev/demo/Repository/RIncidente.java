package com.ryckdev.demo.Repository;

import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.ETecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RIncidente extends JpaRepository<EIncidente, Long> {
    List<EIncidente> findByTecnicoOrderByFechaIngresoDesc(ETecnico tecnico);

    // Consulta para obtener incidentes resueltos en los últimos N días
    @Query("SELECT i FROM EIncidente i LEFT JOIN FETCH i.tecnico WHERE i.resuelto = true AND i.fechaIngreso >= :fechaLimite")
    List<EIncidente> findIncidentesResueltosUltimosNDias(@Param("fechaLimite") Timestamp fechaLimite);


    // Consulta para obtener el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    @Query("SELECT t FROM ETecnico t WHERE t.especialidades = :especialidad AND t.idTecnico = (SELECT i.tecnico.idTecnico FROM EIncidente i WHERE i.resuelto = true AND i.tecnico.especialidades = :especialidad AND i.fechaIngreso >= :fechaLimite GROUP BY i.tecnico.idTecnico ORDER BY COUNT(i) DESC LIMIT 1)")
    ETecnico findTecnicoConMasIncidentesResueltosPorEspecialidadUltimosNDias(@Param("especialidad") String especialidad, @Param("fechaLimite") Timestamp fechaLimite);

    // Consulta para obtener el técnico que más rápido resolvió los incidentes
    @Query("SELECT t FROM ETecnico t WHERE t.idTecnico = (SELECT i.tecnico.idTecnico FROM EIncidente i WHERE i.resuelto = true ORDER BY i.tiempoResolucion ASC LIMIT 1)")
    ETecnico findTecnicoMasRapidoResolviendo();





}

