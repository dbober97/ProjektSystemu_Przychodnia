
import com.mycompany.przychodnia.Role;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import jakarta.inject.Inject;
import java.math.BigDecimal;

@FacesConverter(value = "roleConverter", managed = true)
@ApplicationScoped
public class RoleConverter implements Converter<Role> {

    @Inject
    private RoleService roleService;

    @Override
    public Role getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            BigDecimal id = new BigDecimal(value);
            return roleService.findById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Role role) {
        if (role == null || role.getId() == null) {
            return "";
        }
        return role.getId().toString();
    }
}
