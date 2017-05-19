package com.ordermeal1.ejb;

import com.ordermeal1.entities.Order1;
import com.ordermeal1.ejb.util.JsfUtil;
import com.ordermeal1.ejb.util.JsfUtil.PersistAction;
import com.ordermeal1.controllers.Order1Facade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("order1Controller")
@SessionScoped
public class Order1Controller implements Serializable {

    @EJB
    private com.ordermeal1.controllers.Order1Facade ejbFacade;
    private List<Order1> items = null;
    private Order1 selected;

    public Order1Controller() {
    }

    public Order1 getSelected() {
        return selected;
    }

    public void setSelected(Order1 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getOrder1PK().setPlatoIdPlato(selected.getPlato().getIdPlato());
        selected.getOrder1PK().setTipoPagoIdTipoPago(selected.getTipoPago().getIdTipoPago());
        selected.getOrder1PK().setBebestibleIdBebestible(selected.getBebestible().getIdBebestible());
        selected.getOrder1PK().setPostreIdPostre(selected.getPostre().getIdPostre());
        selected.getOrder1PK().setEdificioIdEdificio(selected.getEdificio().getIdEdificio());
        selected.getOrder1PK().setClienteIdCliente(selected.getCliente().getIdCliente());
        selected.getOrder1PK().setEnsaladaIdEnsalada(selected.getEnsalada().getIdEnsalada());
        selected.getOrder1PK().setUsuarioIdUsuario(selected.getUsuario().getIdUsuario());
    }

    protected void initializeEmbeddableKey() {
        selected.setOrder1PK(new com.ordermeal1.entities.Order1PK());
    }

    private Order1Facade getFacade() {
        return ejbFacade;
    }

    public Order1 prepareCreate() {
        selected = new Order1();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Order1Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Order1Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Order1Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Order1> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Order1 getOrder1(com.ordermeal1.entities.Order1PK id) {
        return getFacade().find(id);
    }

    public List<Order1> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Order1> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Order1.class)
    public static class Order1ControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Order1Controller controller = (Order1Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "order1Controller");
            return controller.getOrder1(getKey(value));
        }

        com.ordermeal1.entities.Order1PK getKey(String value) {
            com.ordermeal1.entities.Order1PK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.ordermeal1.entities.Order1PK();
            key.setIdOrder(Integer.parseInt(values[0]));
            key.setPlatoIdPlato(Integer.parseInt(values[1]));
            key.setTipoPagoIdTipoPago(Integer.parseInt(values[2]));
            key.setUsuarioIdUsuario(Integer.parseInt(values[3]));
            key.setClienteIdCliente(Integer.parseInt(values[4]));
            key.setEdificioIdEdificio(Integer.parseInt(values[5]));
            key.setPostreIdPostre(Integer.parseInt(values[6]));
            key.setBebestibleIdBebestible(Integer.parseInt(values[7]));
            key.setEnsaladaIdEnsalada(Integer.parseInt(values[8]));
            return key;
        }

        String getStringKey(com.ordermeal1.entities.Order1PK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdOrder());
            sb.append(SEPARATOR);
            sb.append(value.getPlatoIdPlato());
            sb.append(SEPARATOR);
            sb.append(value.getTipoPagoIdTipoPago());
            sb.append(SEPARATOR);
            sb.append(value.getUsuarioIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getClienteIdCliente());
            sb.append(SEPARATOR);
            sb.append(value.getEdificioIdEdificio());
            sb.append(SEPARATOR);
            sb.append(value.getPostreIdPostre());
            sb.append(SEPARATOR);
            sb.append(value.getBebestibleIdBebestible());
            sb.append(SEPARATOR);
            sb.append(value.getEnsaladaIdEnsalada());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Order1) {
                Order1 o = (Order1) object;
                return getStringKey(o.getOrder1PK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Order1.class.getName()});
                return null;
            }
        }

    }

}
