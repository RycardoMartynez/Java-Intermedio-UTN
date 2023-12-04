package com.ryckdev.demo.Controller;

import com.ryckdev.demo.Entity.EServicio;
import com.ryckdev.demo.Entity.ETecnico;
import com.ryckdev.demo.Repository.RServicio;
import com.ryckdev.demo.Repository.RTecnico;
import com.ryckdev.demo.Service.SServicio;
import com.ryckdev.demo.Service.STecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class CServicio {
    private final SServicio sServicio;
    private final RServicio rServicio;

    @Autowired
    public CServicio(SServicio sServicio, RServicio rServicio) {
        this.sServicio = sServicio;
        this.rServicio = rServicio;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<EServicio>> obtenerServicio() {
        List<EServicio> servicio = rServicio.findAll();
        return ResponseEntity.ok(servicio);
    }


    @GetMapping("/ver/{id}")
    @ResponseBody
    public EServicio verServicio(@PathVariable Long id) {
        return sServicio.buscarServicio(id);
    }

    @PostMapping("/crear")
    public void agregarServicio(@RequestBody EServicio servicio) {
        sServicio.crearServicio(servicio);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarServicio(@PathVariable Long id) {
        sServicio.borrarServicio(id);
    }

    @PutMapping("/editar/{id}")
    public void editarServicio(@RequestBody EServicio servicio) {
        sServicio.editarServicio(servicio);
    }
}
