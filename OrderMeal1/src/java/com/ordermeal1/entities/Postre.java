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
@Table(name = "postre", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postre.findAll", query = "SELECT p FROM Postre p")
    , @NamedQuery(name = "Postre.findByIdPostre", query = "SELECT p FROM Postre p WHERE p.idPostre = :idPostre")
    , @NamedQuery(name = "Postre.findByPosNombre", query = "SELECT p FROM Postre p WHERE p.posNombre = :posNombre")
    , @NamedQuery(name = "Postre.findByPosPrecio", query = "SELECT p FROM Postre p WHERE p.posPrecio = :posPrecio")})
public class Postre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_postre")
    private Integer idPostre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pos_nombre")
    private String posNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pos_precio")
    private double posPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postre")
    private List<Order1> order1List;

    public Postre() {
    }

    public Postre(Integer idPostre) {
        this.idPostre = idPostre;
    }

    public Postre(Integer idPostre, String posNombre, double posPrecio) {
        this.idPostre = idPostre;
        this.posNombre = posNombre;
        this.posPrecio = posPrecio;
    }

    public Integer getIdPostre() {
        return idPostre;
    }

    public void setIdPostre(Integer idPostre) {
        this.idPostre = idPostre;
    }

    public String getPosNombre() {
        return posNombre;
    }

    public void setPosNombre(String posNombre) {
        this.posNombre = posNombre;
    }

    public double getPosPrecio() {
        return posPrecio;
    }

    public void setPosPrecio(double posPrecio) {
        this.posPrecio = posPrecio;
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
        hash += (idPostre != null ? idPostre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postre)) {
            return false;
        }
        Postre other = (Postre) object;
        if ((this.idPostre == null && other.idPostre != null) || (this.idPostre != null && !this.idPostre.equals(other.idPostre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Postre[ idPostre=" + idPostre + " ]";
    }
    
}
