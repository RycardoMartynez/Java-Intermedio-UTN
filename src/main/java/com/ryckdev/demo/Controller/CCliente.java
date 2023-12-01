package com.ryckdev.demo.Controller;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Interface.ICliente;
import com.ryckdev.demo.Repository.RCliente;
import com.ryckdev.demo.Service.SCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class CCliente {

    private final SCliente sCliente;
    private final RCliente rCliente;

    @Autowired
    public CCliente(SCliente sCliente, RCliente rCliente) {
        this.sCliente = sCliente;
        this.rCliente = rCliente;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ECliente>> obtenerClientes() {
        List<ECliente> clientes = rCliente.findAll();
        return ResponseEntity.ok(clientes);
    }


    @GetMapping("/ver/{id}")
    @ResponseBody
    public ECliente verCliente(@PathVariable Long id) {
        return sCliente.buscarCliente(id);
    }

    @PostMapping("/crear")
    public void agregarCliente(@RequestBody ECliente cliente) {
        sCliente.crearCliente(cliente);
    }

    @DeleteMapping("/borrar/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        sCliente.borrarCliente(id);
    }

    @PutMapping("/editar/{id}")
    public void editarCliente(@RequestBody ECliente cliente) {
        sCliente.editarCliente(cliente);
    }
}

