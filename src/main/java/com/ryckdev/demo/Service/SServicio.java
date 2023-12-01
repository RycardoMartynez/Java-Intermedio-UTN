package com.ryckdev.demo.Service;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.EServicio;
import com.ryckdev.demo.Interface.IServicio;
import com.ryckdev.demo.Repository.RCliente;
import com.ryckdev.demo.Repository.RIncidente;
import com.ryckdev.demo.Repository.RServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SServicio {
    @Autowired
    public RServicio rServicio;

    public List<EServicio> verServicio() {
        List<EServicio> listaServicio = rServicio.findAll();
        return listaServicio;
    }

    public void crearServicio(EServicio servicio) {
        rServicio.save(servicio);
    }

    public void borrarServicio(Long id) {
        rServicio.deleteById(id);
    }

    public EServicio buscarServicio(long id) {
        EServicio servicio = rServicio.findById(id).orElse(null);
        return servicio;
    }
    public void editarServicio(EServicio servicio) {
        rServicio.save(servicio);
    }
}
