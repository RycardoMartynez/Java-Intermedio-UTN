package com.ryckdev.demo.Repository;

import com.ryckdev.demo.Entity.ETecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RTecnico extends JpaRepository<ETecnico, Long> {
    List<ETecnico> findByEspecialidades(String tipoProblema);
}
