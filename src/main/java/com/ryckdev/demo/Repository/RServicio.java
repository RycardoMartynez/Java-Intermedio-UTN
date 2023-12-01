package com.ryckdev.demo.Repository;

import com.ryckdev.demo.Entity.EServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RServicio extends JpaRepository<EServicio, Long> {
}
