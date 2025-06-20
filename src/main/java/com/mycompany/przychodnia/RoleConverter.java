package com.mycompany.przychodnia;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;

@FacesConverter(value = "roleConverter", managed = true)
public class RoleConverter implements Converter<Role> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            BigDecimal id = new BigDecimal(value);
            return em.find(Role.class, id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Role role) {
        if (role == null) {
            return "";
        }
        BigDecimal id = role.getId();
        return (id != null) ? id.toString() : "";
    }
}
