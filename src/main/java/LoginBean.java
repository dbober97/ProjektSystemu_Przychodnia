import com.mycompany.przychodnia.Uzytkownicy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String login;
    private String haslo;

    private Uzytkownicy zalogowanyUzytkownik;

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public void login() {
        try {
            TypedQuery<Uzytkownicy> query = em.createQuery(
                "SELECT u FROM Uzytkownicy u WHERE LOWER(u.login) = :login AND u.haslo = :haslo",
                Uzytkownicy.class);
            query.setParameter("login", login.toLowerCase());
            query.setParameter("haslo", haslo);

            Uzytkownicy user = query.getSingleResult();

            if (user != null) {
                this.zalogowanyUzytkownik = user;

                // Zapisz użytkownika do sesji JSF
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getSessionMap()
                            .put("zalogowany", user);

                // Przekierowanie w zależności od roli
                String rola = user.getRoleId().getNazwa(); 
                switch (rola) {
                    case "Lekarz" -> redirect("panelLekarz.xhtml");
                    case "Administrator" -> redirect("panelAdmin.xhtml");
                    case "Recepcjonista" -> redirect("panelRecepcja.xhtml");
                    default -> redirect("brak_uprawnien.xhtml");
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędne dane logowania!", "Błędne dane logowania!"));
        }
    }

        public String logout() {
            FacesContext.getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
            return "index.xhtml?faces-redirect=true";
        }


    private void redirect(String page) throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect(page);
    }

    // Gettery i settery
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getHaslo() { return haslo; }
    public void setHaslo(String haslo) { this.haslo = haslo; }

    public Uzytkownicy getZalogowanyUzytkownik() { return zalogowanyUzytkownik; }
}
