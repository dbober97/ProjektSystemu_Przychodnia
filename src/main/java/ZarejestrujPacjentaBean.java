
import com.mycompany.przychodnia.ZarajestrowaniPacjenci;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;

@Named
@RequestScoped
public class ZarejestrujPacjentaBean implements Serializable {

    @Inject
    private PacjentService pacjentService;
    

    private ZarajestrowaniPacjenci pacjent = new ZarajestrowaniPacjenci();

public String zapisz() {
    try {
        pacjent.setId(BigDecimal.valueOf(System.currentTimeMillis()));
        pacjentService.zapisz(pacjent);
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukces", "Pacjent został zarejestrowany."));
    } catch (Exception e) {
        String msg = e.getMessage().contains("PESEL") ?
            "Pacjent z tym numerem PESEL już istnieje." : "Rejestracja nie powiodła się.";

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", msg));
        e.printStackTrace();
    }
    return null;
}

    public ZarajestrowaniPacjenci getPacjent() {
        return pacjent;
    }

    public void setPacjent(ZarajestrowaniPacjenci pacjent) {
        this.pacjent = pacjent;
    }
}
