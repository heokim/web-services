/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.rest;

import com.andres.tp.controller.ProductosController;
import com.andres.tp.entity.Productos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author And
 */
@RestController
@RequestMapping("producto")
public class ProductosRest {

    // Injecion
    @Autowired
    private ProductosController producto;

    // Metodos HTTP - Solicitud al servidos
    // GET, POST, PUT, DELETE -> 200(Exitoso) - 500(Fallido) - 404(No Encontrado)
    
    /**
     * Metodo para probar que si este funcionando el Web Services
     *
     * @return Retorna un String con el mensaje "Imprimiendo"
     */
    @GetMapping("/imprimir")
    public String imprimir() {
        return "Imprimiendo";
    }

    /**
     *
     * @param producto
     */
    @PostMapping("/guardar") // localhost:9090/usuario/guardar
    public void guardar(@RequestBody Productos producto) {
        this.producto.save(producto);
    }

    /**
     * Lista una toda la tabla de productos
     *
     * @return Lista de Productos
     */
    @GetMapping("/listar")
    public List<Productos> listar() {
        return this.producto.findAll();
    }

    /**
     * Elimina un producto por el ID
     *
     * @param id ID del producto a eliminar
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        this.producto.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Productos producto) {
        this.producto.save(producto);
    }

}
