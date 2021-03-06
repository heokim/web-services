/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author And
 */
@Entity
@Table(name = "factura_cabeceras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCabeceras.findAll", query = "SELECT f FROM FacturaCabeceras f")
    , @NamedQuery(name = "FacturaCabeceras.findByIdFactura", query = "SELECT f FROM FacturaCabeceras f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "FacturaCabeceras.findByFecha", query = "SELECT f FROM FacturaCabeceras f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "FacturaCabeceras.findByNroFactura", query = "SELECT f FROM FacturaCabeceras f WHERE f.nroFactura = :nroFactura")
    , @NamedQuery(name = "FacturaCabeceras.findByTotal", query = "SELECT f FROM FacturaCabeceras f WHERE f.total = :total")
    , @NamedQuery(name = "FacturaCabeceras.findByEstado", query = "SELECT f FROM FacturaCabeceras f WHERE f.estado = :estado")})
public class FacturaCabeceras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "nro_factura")
    private String nroFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal total;
    @Basic(optional = false)
    private String estado;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<FacturaDetalles> facturaDetallesList;

    public FacturaCabeceras() {
    }

    public FacturaCabeceras(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaCabeceras(Integer idFactura, Date fecha, String nroFactura, BigDecimal total, String estado) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nroFactura = nroFactura;
        this.total = total;
        this.estado = estado;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<FacturaDetalles> getFacturaDetallesList() {
        return facturaDetallesList;
    }

    public void setFacturaDetallesList(List<FacturaDetalles> facturaDetallesList) {
        this.facturaDetallesList = facturaDetallesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabeceras)) {
            return false;
        }
        FacturaCabeceras other = (FacturaCabeceras) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andres.tp.model.FacturaCabeceras[ idFactura=" + idFactura + " ]";
    }
    
}
