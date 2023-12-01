
package com.ryckdev.demo.Interface;

import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.ETecnico;

import java.util.List;

    public interface IIncidente {


        public List<EIncidente> getIncidente();

        public void saveIncidente(EIncidente incidente);

        public void deleteIncidente(long id);

        public EIncidente getIncidenteById(long id);
    }

