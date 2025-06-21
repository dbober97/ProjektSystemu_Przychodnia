import com.mycompany.przychodnia.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;

@Stateless
public class RoleService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public Role findById(BigDecimal id) {
        if (id == null) {
            return null;
        }
        return em.find(Role.class, id);
    }

    public java.util.List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class)
                 .getResultList();
    }
}
