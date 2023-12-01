package com.ryckdev.demo.Service;

import com.ryckdev.demo.Entity.EServicio;
import com.ryckdev.demo.Entity.ETecnico;
import com.ryckdev.demo.Interface.ITecnico;
import com.ryckdev.demo.Repository.RServicio;
import com.ryckdev.demo.Repository.RTecnico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class STecnico{
    @Autowired
    public RTecnico rTecnico;

    public List<ETecnico > verTecnico () {
        List<ETecnico > listaTecnico = rTecnico.findAll();
        return listaTecnico;
    }

    public void crearTecnico(ETecnico tecnico) {
        rTecnico.save(tecnico);
    }

    public void borrarTecnico(Long id) {
        rTecnico.deleteById(id);
    }

    public ETecnico buscarTecnico(long id) {
        ETecnico tecnico = rTecnico.findById(id).orElse(null);
        return tecnico;
    }
    public void editarTecnico(ETecnico tecnico) {
        rTecnico.save(tecnico);
    }
}
