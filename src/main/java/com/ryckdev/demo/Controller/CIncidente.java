package com.ryckdev.demo.Controller;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Repository.RCliente;
import com.ryckdev.demo.Repository.RIncidente;
import com.ryckdev.demo.Service.SCliente;
import com.ryckdev.demo.Service.SIncidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/incidente")
public class CIncidente {
    private final SIncidente sIncidente;
    private final RIncidente rIncidente;

    @Autowired
    public CIncidente(SIncidente sIncidente, RIncidente rIncidente) {
        this.sIncidente = sIncidente;
        this.rIncidente = rIncidente;
    }
    @GetMapping("/lista")
    public ResponseEntity<List<EIncidente>> obtenerIncidente() {
        List<EIncidente> incidente = rIncidente.findAll();
        return ResponseEntity.ok(incidente);
    }


    @GetMapping("/ver/{id}")
    @ResponseBody
    public EIncidente verIncidente(@PathVariable Long id) {
        return rIncidente.getReferenceById(id);
    }

    @PostMapping("/crear")
    public void agregarIncidente(@RequestBody EIncidente incidente) {
        sIncidente.crearIncidente(incidente);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarIncidente(@PathVariable Long id) {
        sIncidente.borrarIncidente(id);
    }

    @PutMapping("/editar/{id}")
    public void editarIncidente(@RequestBody EIncidente incidente) {
        sIncidente.editarIncidente(incidente);
    }

    @GetMapping("/reportediario")
    public List<EIncidente> getIncidentesResueltosUltimosTresDias() {
        // Obtener la lista de incidentes resueltos hoy

        LocalDate fechaLimite = LocalDate.now().minusDays(1);
        Timestamp fechaLimiteTimestamp = Timestamp.valueOf(fechaLimite.atStartOfDay());
        return rIncidente.findIncidentesResueltosUltimosNDias(fechaLimiteTimestamp);
    }
}

