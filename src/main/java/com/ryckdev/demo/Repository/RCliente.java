package com.ryckdev.demo.Repository;

import com.ryckdev.demo.Entity.ECliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCliente extends JpaRepository<ECliente, Long> {

}
