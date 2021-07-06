/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.controller;

import com.andres.tp.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author And
 */
public interface UsuariosController extends JpaRepository<Usuarios, Integer>{
    
}
