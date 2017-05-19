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
@Table(name = "bebestible", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bebestible.findAll", query = "SELECT b FROM Bebestible b")
    , @NamedQuery(name = "Bebestible.findByIdBebestible", query = "SELECT b FROM Bebestible b WHERE b.idBebestible = :idBebestible")
    , @NamedQuery(name = "Bebestible.findByBebNombre", query = "SELECT b FROM Bebestible b WHERE b.bebNombre = :bebNombre")
    , @NamedQuery(name = "Bebestible.findByBebPrecio", query = "SELECT b FROM Bebestible b WHERE b.bebPrecio = :bebPrecio")})
public class Bebestible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bebestible")
    private Integer idBebestible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "beb_nombre")
    private String bebNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beb_precio")
    private double bebPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bebestible")
    private List<Order1> order1List;

    public Bebestible() {
    }

    public Bebestible(Integer idBebestible) {
        this.idBebestible = idBebestible;
    }

    public Bebestible(Integer idBebestible, String bebNombre, double bebPrecio) {
        this.idBebestible = idBebestible;
        this.bebNombre = bebNombre;
        this.bebPrecio = bebPrecio;
    }

    public Integer getIdBebestible() {
        return idBebestible;
    }

    public void setIdBebestible(Integer idBebestible) {
        this.idBebestible = idBebestible;
    }

    public String getBebNombre() {
        return bebNombre;
    }

    public void setBebNombre(String bebNombre) {
        this.bebNombre = bebNombre;
    }

    public double getBebPrecio() {
        return bebPrecio;
    }

    public void setBebPrecio(double bebPrecio) {
        this.bebPrecio = bebPrecio;
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
        hash += (idBebestible != null ? idBebestible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bebestible)) {
            return false;
        }
        Bebestible other = (Bebestible) object;
        if ((this.idBebestible == null && other.idBebestible != null) || (this.idBebestible != null && !this.idBebestible.equals(other.idBebestible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Bebestible[ idBebestible=" + idBebestible + " ]";
    }
    
}
