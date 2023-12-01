package com.ryckdev.demo.Service;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.ETecnico;
import com.ryckdev.demo.Interface.IIncidente;
import com.ryckdev.demo.Repository.RIncidente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SIncidente {

    @Autowired
    public RIncidente rIncidente;

    public List<EIncidente> verIncidente() {
        List<EIncidente> listaIncidente = rIncidente.findAll();
        return listaIncidente;
    }

    public void crearIncidente(EIncidente incidente) {
        rIncidente.save(incidente);
    }

    public void borrarIncidente(Long id) {
        rIncidente.deleteById(id);
    }

    public EIncidente buscarIncidente(long id) {
        EIncidente incidente = rIncidente.findById(id).orElse(null);
        return incidente;
    }
    public void editarIncidente(EIncidente incidente) {
        rIncidente.save(incidente);
    }
}
