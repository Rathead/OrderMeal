/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordermeal1.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "edificio", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e")
    , @NamedQuery(name = "Edificio.findByIdEdificio", query = "SELECT e FROM Edificio e WHERE e.idEdificio = :idEdificio")
    , @NamedQuery(name = "Edificio.findByEdiDireccion", query = "SELECT e FROM Edificio e WHERE e.ediDireccion = :ediDireccion")
    , @NamedQuery(name = "Edificio.findByEdiNombre", query = "SELECT e FROM Edificio e WHERE e.ediNombre = :ediNombre")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_edificio")
    private Integer idEdificio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "edi_direccion")
    private String ediDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "edi_nombre")
    private String ediNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificio")
    private List<Order1> order1List;

    public Edificio() {
    }

    public Edificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    public Edificio(Integer idEdificio, String ediDireccion, String ediNombre) {
        this.idEdificio = idEdificio;
        this.ediDireccion = ediDireccion;
        this.ediNombre = ediNombre;
    }

    public Integer getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getEdiDireccion() {
        return ediDireccion;
    }

    public void setEdiDireccion(String ediDireccion) {
        this.ediDireccion = ediDireccion;
    }

    public String getEdiNombre() {
        return ediNombre;
    }

    public void setEdiNombre(String ediNombre) {
        this.ediNombre = ediNombre;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdificio != null ? idEdificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.idEdificio == null && other.idEdificio != null) || (this.idEdificio != null && !this.idEdificio.equals(other.idEdificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Edificio[ idEdificio=" + idEdificio + " ]";
    }
    
}
