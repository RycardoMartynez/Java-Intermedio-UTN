package com.ryckdev.demo.Service;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Interface.ICliente;
import com.ryckdev.demo.Repository.RCliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCliente {

    @Autowired
    public RCliente rCliente;

    public List<ECliente> verCliente() {
        List<ECliente> listaCliente = rCliente.findAll();
        return listaCliente;
    }

    public void crearCliente(ECliente cliente) {
        rCliente.save(cliente);
    }

    public void borrarCliente(Long id) {
        rCliente.deleteById(id);
    }

    public ECliente buscarCliente(Long id) {
        ECliente cliente = rCliente.findById(id).orElse(null);
        return cliente;
    }

    public void editarCliente(ECliente cliente) {
        rCliente.save(cliente);
    }


}
