/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author And
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuraciones.findAll", query = "SELECT c FROM Configuraciones c")
    , @NamedQuery(name = "Configuraciones.findByIdConfigura", query = "SELECT c FROM Configuraciones c WHERE c.idConfigura = :idConfigura")
    , @NamedQuery(name = "Configuraciones.findByDescripcion", query = "SELECT c FROM Configuraciones c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Configuraciones.findByParametro", query = "SELECT c FROM Configuraciones c WHERE c.parametro = :parametro")
    , @NamedQuery(name = "Configuraciones.findByValor", query = "SELECT c FROM Configuraciones c WHERE c.valor = :valor")})
public class Configuraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_configura")
    private Integer idConfigura;
    private String descripcion;
    private String parametro;
    private String valor;

    public Configuraciones() {
    }

    public Configuraciones(Integer idConfigura) {
        this.idConfigura = idConfigura;
    }

    public Integer getIdConfigura() {
        return idConfigura;
    }

    public void setIdConfigura(Integer idConfigura) {
        this.idConfigura = idConfigura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfigura != null ? idConfigura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuraciones)) {
            return false;
        }
        Configuraciones other = (Configuraciones) object;
        if ((this.idConfigura == null && other.idConfigura != null) || (this.idConfigura != null && !this.idConfigura.equals(other.idConfigura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andres.tp.model.Configuraciones[ idConfigura=" + idConfigura + " ]";
    }
    
}
