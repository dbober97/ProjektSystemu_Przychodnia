
import com.mycompany.przychodnia.Specjalizacje;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import jakarta.inject.Inject;
import java.math.BigDecimal;
@FacesConverter(value = "specjalizacjeConverter", managed = true)
@ApplicationScoped
public class SpecjalizacjeConverter implements Converter<Specjalizacje> {

    @Inject
    private SpecjalizacjeService specjalizacjeService;

    @Override
    public Specjalizacje getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            BigDecimal id = new BigDecimal(value);
            return specjalizacjeService.findById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Specjalizacje specjalizacja) {
        if (specjalizacja == null || specjalizacja.getId() == null) {
            return "";
        }
        return specjalizacja.getId().toString();
    }
}
