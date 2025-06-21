import com.mycompany.przychodnia.Uzytkownicy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String login;
    private String haslo;

    private Uzytkownicy user;

    @PersistenceContext
    private EntityManager em;

public String login() {
    try {
        user = em.createQuery(
            "SELECT u FROM Uzytkownicy u WHERE u.login = :login AND u.haslo = :haslo",
            Uzytkownicy.class
        ).setParameter("login", login)
         .setParameter("haslo", haslo)
         .getSingleResult();

        // Zapisz bean w sesji pod kluczem "loginBean"
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute("loginBean", this);

        // Przekierowanie na podstawie roli
        String role = user.getRoleId().getNazwa();

        if ("ADMIN".equalsIgnoreCase(role)) {
            return "/admin/panelAdmin.xhtml?faces-redirect=true";
        } else if ("LEKARZ".equalsIgnoreCase(role)) {
            return "/lekarz/panelLekarz.xhtml?faces-redirect=true";
        } else if ("RECEPCJONISTA".equalsIgnoreCase(role)) {
            return "/recepcjonista/panelRecepcja.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Nieznana rola użytkownika", ""));
            return null;
        }

    } catch (NoResultException e) {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                             "Nieprawidłowy login lub hasło", ""));
        return null;
    }}


    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    // Sprawdzenie zalogowania
    public boolean isLoggedIn() {
        return user != null;
    }

    // Sprawdzenie ról
    public boolean isAdmin() {
        return isLoggedIn() && "ADMIN".equalsIgnoreCase(user.getRoleId().getNazwa());
    }

    public boolean isLekarz() {
        return isLoggedIn() && "LEKARZ".equalsIgnoreCase(user.getRoleId().getNazwa());
    }

    public boolean isRecepcjonista() {
        return isLoggedIn() && "RECEPCJONISTA".equalsIgnoreCase(user.getRoleId().getNazwa());
    }

    // Gettery i settery
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Uzytkownicy getUser() {
        return this.user;
    }

    public void setUser(Uzytkownicy user) {
        this.user = user;
    }
    
    public String getRola() {
    return (user != null && user.getRoleId() != null)
        ? user.getRoleId().getNazwa()
        : null;
}
}
