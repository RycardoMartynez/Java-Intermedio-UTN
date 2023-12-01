package com.ryckdev.demo.Interface;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.EIncidente;

import java.util.List;

public interface ICliente {
    public List<ECliente> getCliente();

    public void saveCliente(ECliente cliente);

    public void deleteCliente(long id);

    public ECliente getClienteById(long id);
}
