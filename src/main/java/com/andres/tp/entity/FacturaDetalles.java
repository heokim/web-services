/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andres.tp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author And
 */
@Entity
@Table(name = "factura_detalles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDetalles.findAll", query = "SELECT f FROM FacturaDetalles f")
    , @NamedQuery(name = "FacturaDetalles.findByIdDetalle", query = "SELECT f FROM FacturaDetalles f WHERE f.idDetalle = :idDetalle")
    , @NamedQuery(name = "FacturaDetalles.findByCantidad", query = "SELECT f FROM FacturaDetalles f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "FacturaDetalles.findByPrecioUnitario", query = "SELECT f FROM FacturaDetalles f WHERE f.precioUnitario = :precioUnitario")})
public class FacturaDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private FacturaCabeceras idFactura;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public FacturaDetalles() {
    }

    public FacturaDetalles(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public FacturaDetalles(Integer idDetalle, BigDecimal cantidad, BigDecimal precioUnitario) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public FacturaCabeceras getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(FacturaCabeceras idFactura) {
        this.idFactura = idFactura;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalles)) {
            return false;
        }
        FacturaDetalles other = (FacturaDetalles) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andres.tp.model.FacturaDetalles[ idDetalle=" + idDetalle + " ]";
    }
    
}
