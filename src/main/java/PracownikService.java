
import com.mycompany.przychodnia.Role;
import com.mycompany.przychodnia.Specjalizacje;
import com.mycompany.przychodnia.Uzytkownicy;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class PracownikService {

    @PersistenceContext
    private EntityManager em;

public void zapiszUzytkownika(Uzytkownicy uzytkownik) {
    // Generowanie ID na podstawie czasu systemowego
    BigDecimal noweId = BigDecimal.valueOf(System.currentTimeMillis());

    // Ustawienie ID
    uzytkownik.setId(noweId);

    // Zapis do bazy
    em.persist(uzytkownik);
}


    public List<Role> pobierzWszystkieRole() {
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    public List<Specjalizacje> pobierzWszystkieSpecjalizacje() {
        return em.createQuery("SELECT s FROM Specjalizacje s", Specjalizacje.class).getResultList();
    }

    public boolean czyLoginZajety(String login) {
        TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(u) FROM Uzytkownicy u WHERE u.login = :login", Long.class);
        query.setParameter("login", login);
        return query.getSingleResult() > 0;
    }
}
