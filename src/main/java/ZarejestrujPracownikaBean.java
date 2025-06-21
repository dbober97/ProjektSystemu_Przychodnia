import com.mycompany.przychodnia.Role;
import com.mycompany.przychodnia.Specjalizacje;
import com.mycompany.przychodnia.Uzytkownicy;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("zarejestrujPracownikaBean")
@RequestScoped
public class ZarejestrujPracownikaBean {

    private Uzytkownicy uzytkownik = new Uzytkownicy();

    @Inject
    private PracownikService pracownikService;

    private List<Role> listaRoli;
    private List<Specjalizacje> listaSpecjalizacji;

    @PostConstruct
    public void init() {
        listaRoli = pracownikService.pobierzWszystkieRole();
        listaSpecjalizacji = pracownikService.pobierzWszystkieSpecjalizacje();
    }

    public void zapisz() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (uzytkownik.getRoleId() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wybierz rolę!", null));
            return;
        }

        if (uzytkownik.getSpecjalizacjeId() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wybierz specjalizację!", null));
            return;
        }

        if (pracownikService.czyLoginZajety(uzytkownik.getLogin())) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login jest już zajęty!", null));
            return;
        }

        try {
            pracownikService.zapiszUzytkownika(uzytkownik);
            context.addMessage(null, new FacesMessage("Użytkownik został zarejestrowany"));
            uzytkownik = new Uzytkownicy(); // Reset formularza
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd: " + e.getMessage(), null));
        }
    }

    // Gettery i settery
    public Uzytkownicy getUzytkownik() { return uzytkownik; }
    public void setUzytkownik(Uzytkownicy u) { this.uzytkownik = u; }

    public List<Role> getListaRoli() { return listaRoli; }
    public List<Specjalizacje> getListaSpecjalizacji() { return listaSpecjalizacji; }
}
