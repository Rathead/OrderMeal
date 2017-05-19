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
@Table(name = "ensalada", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ensalada.findAll", query = "SELECT e FROM Ensalada e")
    , @NamedQuery(name = "Ensalada.findByIdEnsalada", query = "SELECT e FROM Ensalada e WHERE e.idEnsalada = :idEnsalada")
    , @NamedQuery(name = "Ensalada.findByEnsNombre", query = "SELECT e FROM Ensalada e WHERE e.ensNombre = :ensNombre")
    , @NamedQuery(name = "Ensalada.findByEnsPrecio", query = "SELECT e FROM Ensalada e WHERE e.ensPrecio = :ensPrecio")})
public class Ensalada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ensalada")
    private Integer idEnsalada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ens_nombre")
    private String ensNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ens_precio")
    private double ensPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ensalada")
    private List<Order1> order1List;

    public Ensalada() {
    }

    public Ensalada(Integer idEnsalada) {
        this.idEnsalada = idEnsalada;
    }

    public Ensalada(Integer idEnsalada, String ensNombre, double ensPrecio) {
        this.idEnsalada = idEnsalada;
        this.ensNombre = ensNombre;
        this.ensPrecio = ensPrecio;
    }

    public Integer getIdEnsalada() {
        return idEnsalada;
    }

    public void setIdEnsalada(Integer idEnsalada) {
        this.idEnsalada = idEnsalada;
    }

    public String getEnsNombre() {
        return ensNombre;
    }

    public void setEnsNombre(String ensNombre) {
        this.ensNombre = ensNombre;
    }

    public double getEnsPrecio() {
        return ensPrecio;
    }

    public void setEnsPrecio(double ensPrecio) {
        this.ensPrecio = ensPrecio;
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
        hash += (idEnsalada != null ? idEnsalada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ensalada)) {
            return false;
        }
        Ensalada other = (Ensalada) object;
        if ((this.idEnsalada == null && other.idEnsalada != null) || (this.idEnsalada != null && !this.idEnsalada.equals(other.idEnsalada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Ensalada[ idEnsalada=" + idEnsalada + " ]";
    }
    
}
