package com.ryckdev.demo.Interface;

import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.EServicio;

import java.util.List;

public interface IServicio {

    public List<EServicio> getServicio();

    public void saveServicio(EServicio servicio);

    public void deleteServicio(long id);

    public EServicio getServicioById(long id);

}
