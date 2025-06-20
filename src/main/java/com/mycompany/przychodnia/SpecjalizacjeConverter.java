package com.mycompany.przychodnia;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;

@FacesConverter(value = "specjalizacjeConverter", managed = true)
public class SpecjalizacjeConverter implements Converter<Specjalizacje> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Specjalizacje getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            BigDecimal id = new BigDecimal(value);
            return em.find(Specjalizacje.class, id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Specjalizacje specjalizacje) {
        if (specjalizacje == null) {
            return "";
        }
        BigDecimal id = specjalizacje.getId();
        return (id != null) ? id.toString() : "";
    }
}

