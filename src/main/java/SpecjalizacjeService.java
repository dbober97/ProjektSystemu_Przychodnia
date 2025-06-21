import com.mycompany.przychodnia.Specjalizacje;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;

@Stateless
public class SpecjalizacjeService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public Specjalizacje findById(BigDecimal id) {
        if (id == null) {
            return null;
        }
        return em.find(Specjalizacje.class, id);
    }

    // dodatkowe metody, np. listowanie wszystkich
    public java.util.List<Specjalizacje> findAll() {
        return em.createQuery("SELECT s FROM Specjalizacje s", Specjalizacje.class)
                 .getResultList();
    }
}
