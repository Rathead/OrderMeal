/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordermeal1.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author oscar
 */
@Embeddable
public class Order1PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plato_id_plato")
    private int platoIdPlato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_pago_id_tipo_pago")
    private int tipoPagoIdTipoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id_cliente")
    private int clienteIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edificio_id_edificio")
    private int edificioIdEdificio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postre_id_postre")
    private int postreIdPostre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bebestible_id_bebestible")
    private int bebestibleIdBebestible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ensalada_id_ensalada")
    private int ensaladaIdEnsalada;

    public Order1PK() {
    }

    public Order1PK(int idOrder, int platoIdPlato, int tipoPagoIdTipoPago, int usuarioIdUsuario, int clienteIdCliente, int edificioIdEdificio, int postreIdPostre, int bebestibleIdBebestible, int ensaladaIdEnsalada) {
        this.idOrder = idOrder;
        this.platoIdPlato = platoIdPlato;
        this.tipoPagoIdTipoPago = tipoPagoIdTipoPago;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.clienteIdCliente = clienteIdCliente;
        this.edificioIdEdificio = edificioIdEdificio;
        this.postreIdPostre = postreIdPostre;
        this.bebestibleIdBebestible = bebestibleIdBebestible;
        this.ensaladaIdEnsalada = ensaladaIdEnsalada;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getPlatoIdPlato() {
        return platoIdPlato;
    }

    public void setPlatoIdPlato(int platoIdPlato) {
        this.platoIdPlato = platoIdPlato;
    }

    public int getTipoPagoIdTipoPago() {
        return tipoPagoIdTipoPago;
    }

    public void setTipoPagoIdTipoPago(int tipoPagoIdTipoPago) {
        this.tipoPagoIdTipoPago = tipoPagoIdTipoPago;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public int getEdificioIdEdificio() {
        return edificioIdEdificio;
    }

    public void setEdificioIdEdificio(int edificioIdEdificio) {
        this.edificioIdEdificio = edificioIdEdificio;
    }

    public int getPostreIdPostre() {
        return postreIdPostre;
    }

    public void setPostreIdPostre(int postreIdPostre) {
        this.postreIdPostre = postreIdPostre;
    }

    public int getBebestibleIdBebestible() {
        return bebestibleIdBebestible;
    }

    public void setBebestibleIdBebestible(int bebestibleIdBebestible) {
        this.bebestibleIdBebestible = bebestibleIdBebestible;
    }

    public int getEnsaladaIdEnsalada() {
        return ensaladaIdEnsalada;
    }

    public void setEnsaladaIdEnsalada(int ensaladaIdEnsalada) {
        this.ensaladaIdEnsalada = ensaladaIdEnsalada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrder;
        hash += (int) platoIdPlato;
        hash += (int) tipoPagoIdTipoPago;
        hash += (int) usuarioIdUsuario;
        hash += (int) clienteIdCliente;
        hash += (int) edificioIdEdificio;
        hash += (int) postreIdPostre;
        hash += (int) bebestibleIdBebestible;
        hash += (int) ensaladaIdEnsalada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1PK)) {
            return false;
        }
        Order1PK other = (Order1PK) object;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        if (this.platoIdPlato != other.platoIdPlato) {
            return false;
        }
        if (this.tipoPagoIdTipoPago != other.tipoPagoIdTipoPago) {
            return false;
        }
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if (this.clienteIdCliente != other.clienteIdCliente) {
            return false;
        }
        if (this.edificioIdEdificio != other.edificioIdEdificio) {
            return false;
        }
        if (this.postreIdPostre != other.postreIdPostre) {
            return false;
        }
        if (this.bebestibleIdBebestible != other.bebestibleIdBebestible) {
            return false;
        }
        if (this.ensaladaIdEnsalada != other.ensaladaIdEnsalada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ordermeal1.entities.Order1PK[ idOrder=" + idOrder + ", platoIdPlato=" + platoIdPlato + ", tipoPagoIdTipoPago=" + tipoPagoIdTipoPago + ", usuarioIdUsuario=" + usuarioIdUsuario + ", clienteIdCliente=" + clienteIdCliente + ", edificioIdEdificio=" + edificioIdEdificio + ", postreIdPostre=" + postreIdPostre + ", bebestibleIdBebestible=" + bebestibleIdBebestible + ", ensaladaIdEnsalada=" + ensaladaIdEnsalada + " ]";
    }
    
}
