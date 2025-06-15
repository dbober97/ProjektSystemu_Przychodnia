
import com.mycompany.przychodnia.ZarajestrowaniPacjenci;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ApplicationScoped
public class PacjentService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
    

    @Transactional
    public void zapisz(ZarajestrowaniPacjenci pacjent) throws Exception {
    TypedQuery<Long> query = em.createQuery(
        "SELECT COUNT(p) FROM ZarajestrowaniPacjenci p WHERE p.pesel = :pesel", Long.class);
    query.setParameter("pesel", pacjent.getPesel());
    Long count = query.getSingleResult();

    if (count > 0) {
        throw new Exception("Pacjent z tym numerem PESEL już istnieje.");
    }

    em.persist(pacjent);
}
    
    
}
