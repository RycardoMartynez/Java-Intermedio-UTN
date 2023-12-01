package com.ryckdev.demo.Interface;

import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.EServicio;
import com.ryckdev.demo.Entity.ETecnico;

import java.util.List;

public interface ITecnico {
    public List<ETecnico> getTecnico();

    public void saveTecnico(ETecnico tecnico);

    public void deleteTecnico(long id);

    public ETecnico getTecnicoById(long id);
}
