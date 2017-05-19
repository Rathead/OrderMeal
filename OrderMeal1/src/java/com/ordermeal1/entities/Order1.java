/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordermeal1.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "order", catalog = "ordermeal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findByIdOrder", query = "SELECT o FROM Order1 o WHERE o.order1PK.idOrder = :idOrder")
    , @NamedQuery(name = "Order1.findByOrdTotalPago", query = "SELECT o FROM Order1 o WHERE o.ordTotalPago = :ordTotalPago")
    , @NamedQuery(name = "Order1.findByPlatoIdPlato", query = "SELECT o FROM Order1 o WHERE o.order1PK.platoIdPlato = :platoIdPlato")
    , @NamedQuery(name = "Order1.findByTipoPagoIdTipoPago", query = "SELECT o FROM Order1 o WHERE o.order1PK.tipoPagoIdTipoPago = :tipoPagoIdTipoPago")
    , @NamedQuery(name = "Order1.findByUsuarioIdUsuario", query = "SELECT o FROM Order1 o WHERE o.order1PK.usuarioIdUsuario = :usuarioIdUsuario")
    , @NamedQuery(name = "Order1.findByClienteIdCliente", query = "SELECT o FROM Order1 o WHERE o.order1PK.clienteIdCliente = :clienteIdCliente")
    , @NamedQuery(name = "Order1.findByEdificioIdEdificio", query = "SELECT o FROM Order1 o WHERE o.order1PK.edificioIdEdificio = :edificioIdEdificio")
    , @NamedQuery(name = "Order1.findByPostreIdPostre", query = "SELECT o FROM Order1 o WHERE o.order1PK.postreIdPostre = :postreIdPostre")
    , @NamedQuery(name = "Order1.findByBebestibleIdBebestible", query = "SELECT o FROM Order1 o WHERE o.order1PK.bebestibleIdBebestible = :bebestibleIdBebestible")
    , @NamedQuery(name = "Order1.findByEnsaladaIdEnsalada", query = "SELECT o FROM Order1 o WHERE o.order1PK.ensaladaIdEnsalada = :ensaladaIdEnsalada")
    , @NamedQuery(name = "Order1.findByOrdFechaRetiro", query = "SELECT o FROM Order1 o WHERE o.ordFechaRetiro = :ordFechaRetiro")
    , @NamedQuery(name = "Order1.findByOrdFechaEmision", query = "SELECT o FROM Order1 o WHERE o.ordFechaEmision = :ordFechaEmision")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Order1PK order1PK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_total_pago")
    private double ordTotalPago;
    @Column(name = "ord_fecha_retiro")
    @Temporal(TemporalType.DATE)
    private Date ordFechaRetiro;
    @Column(name = "ord_fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date ordFechaEmision;
    @JoinColumn(name = "bebestible_id_bebestible", referencedColumnName = "id_bebestible", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bebestible bebestible;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "edificio_id_edificio", referencedColumnName = "id_edificio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Edificio edificio;
    @JoinColumn(name = "ensalada_id_ensalada", referencedColumnName = "id_ensalada", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ensalada ensalada;
    @JoinColumn(name = "plato_id_plato", referencedColumnName = "id_plato", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Plato plato;
    @JoinColumn(name = "postre_id_postre", referencedColumnName = "id_postre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Postre postre;
    @JoinColumn(name = "tipo_pago_id_tipo_pago", referencedColumnName = "id_tipo_pago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPago tipoPago;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Order1() {
    }

    public Order1(Order1PK order1PK) {
        this.order1PK = order1PK;
    }

    public Order1(Order1PK order1PK, double ordTotalPago) {
        this.order1PK = order1PK;
        this.ordTotalPago = ordTotalPago;
    }

    public Order1(int idOrder, int platoIdPlato, int tipoPagoIdTipoPago, int usuarioIdUsuario, int clienteIdCliente, int edificioIdEdificio, int postreIdPostre, int bebestibleIdBebestible, int ensaladaIdEnsalada) {
        this.order1PK = new Order1PK(idOrder, platoIdPlato, tipoPagoIdTipoPago, usuarioIdUsuario, clienteIdCliente, edificioIdEdificio, postreIdPostre, bebestibleIdBebestible, ensaladaIdEnsalada);
    }

    public Order1PK getOrder1PK() {
        return order1PK;
    }

    public void setOrder1PK(Order1PK order1PK) {
        this.order1PK = order1PK;
    }

    public double getOrdTotalPago() {
        return ordTotalPago;
    }

    public void setOrdTotalPago(double ordTotalPago) {
        this.ordTotalPago = ordTotalPago;
    }

    public Date getOrdFechaRetiro() {
        return ordFechaRetiro;
    }

    public void setOrdFechaRetiro(Date ordFechaRetiro) {
        this.ordFechaRetiro = ordFechaRetiro;
    }

    public Date getOrdFechaEmision() {
        return ordFechaEmision;
    }

    public void setOrdFechaEmision(Date ordFechaEmision) {
        this.ordFechaEmision = ordFechaEmision;
    }

    public Bebestible getBebestible() {
        return bebestible;
    }

    public void setBebestible(Bebestible bebestible) {
        this.bebestible = bebestible;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Ensalada getEnsalada() {
        return ensalada;
    }

    public void setEnsalada(Ensalada ensalada) {
        this.ensalada = ensalada;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (order1PK != null ? order1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.order1PK == null && other.order1PK != null) || (this.order1PK != null && !this.order1PK.equals(other.order1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Order1[ order1PK=" + order1PK + " ]";
    }
    
}
