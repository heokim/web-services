/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.rest;

import com.andres.tp.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andres.tp.controller.UsuariosController;

/**
 *
 * @author And
 */
@RestController
@RequestMapping("usuario")
public class UsuarioRest {
    
    @Autowired
    private UsuariosController usuario; 
    
    // Metodos HTTP - Solicitud al servidos
    
    // GET, POST, PUT, DELETE -> 200(Exitoso) - 500(Fallido) - 404(No Encontrado)
    
    @PostMapping("/guardar") // localhost:9090/usuario/guardar
    public void guardar(@RequestBody Usuarios usuario){
        this.usuario.save(usuario);
    }
    
    @PostMapping("/imprimir")
    public String imprimir(){
        return "Imprimmiendo";
    }
}
