/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordermeal1.controllers;

import com.ordermeal1.entities.Edificio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oscar
 */
@Stateless
public class EdificioFacade extends AbstractFacade<Edificio> {

    @PersistenceContext(unitName = "OrderMeal1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdificioFacade() {
        super(Edificio.class);
    }
    
}
