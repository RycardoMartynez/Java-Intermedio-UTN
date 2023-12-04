package com.ryckdev.demo.Controller;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.ETecnico;
import com.ryckdev.demo.Repository.RCliente;
import com.ryckdev.demo.Repository.RTecnico;
import com.ryckdev.demo.Service.SCliente;
import com.ryckdev.demo.Service.STecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
public class CTecnico {

    private final STecnico sTecnico;
    private final RTecnico rTecnico;

    @Autowired
    public CTecnico(STecnico sTecnico, RTecnico rTecnico) {
        this.sTecnico = sTecnico;
        this.rTecnico = rTecnico;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ETecnico>> obtenerTecnico() {
        List<ETecnico> tecnico = rTecnico.findAll();
        return ResponseEntity.ok(tecnico);
    }


    @GetMapping("/ver/{id}")
    @ResponseBody
    public ETecnico verTecnico(@PathVariable Long id) {
        return sTecnico.buscarTecnico(id);
    }

    @PostMapping("/crear")
    public void agregarTecnico(@RequestBody ETecnico tecnico) {
        sTecnico.crearTecnico(tecnico);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarTecnico(@PathVariable Long id) {
        sTecnico.borrarTecnico(id);
    }

    @PutMapping("/editar/{id}")
    public void editarTecnico(@RequestBody ETecnico tecnico) {
        sTecnico.editarTecnico(tecnico);
    }
}

