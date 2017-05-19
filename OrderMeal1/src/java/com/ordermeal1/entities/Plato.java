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
@Table(name = "plato", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato")
    , @NamedQuery(name = "Plato.findByPlaNombre", query = "SELECT p FROM Plato p WHERE p.plaNombre = :plaNombre")
    , @NamedQuery(name = "Plato.findByPlaPrecio", query = "SELECT p FROM Plato p WHERE p.plaPrecio = :plaPrecio")
    , @NamedQuery(name = "Plato.findByPlaDetalles", query = "SELECT p FROM Plato p WHERE p.plaDetalles = :plaDetalles")
    , @NamedQuery(name = "Plato.findByPlaEspecial", query = "SELECT p FROM Plato p WHERE p.plaEspecial = :plaEspecial")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plato")
    private Integer idPlato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pla_nombre")
    private String plaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_precio")
    private double plaPrecio;
    @Size(max = 45)
    @Column(name = "pla_detalles")
    private String plaDetalles;
    @Column(name = "pla_especial")
    private Boolean plaEspecial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plato")
    private List<Order1> order1List;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Plato(Integer idPlato, String plaNombre, double plaPrecio) {
        this.idPlato = idPlato;
        this.plaNombre = plaNombre;
        this.plaPrecio = plaPrecio;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getPlaNombre() {
        return plaNombre;
    }

    public void setPlaNombre(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    public double getPlaPrecio() {
        return plaPrecio;
    }

    public void setPlaPrecio(double plaPrecio) {
        this.plaPrecio = plaPrecio;
    }

    public String getPlaDetalles() {
        return plaDetalles;
    }

    public void setPlaDetalles(String plaDetalles) {
        this.plaDetalles = plaDetalles;
    }

    public Boolean getPlaEspecial() {
        return plaEspecial;
    }

    public void setPlaEspecial(Boolean plaEspecial) {
        this.plaEspecial = plaEspecial;
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
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
