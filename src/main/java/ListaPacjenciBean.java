
import com.mycompany.przychodnia.ZarajestrowaniPacjenci;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.primefaces.model.LazyDataModel;

@Named("dtListaPacjenciBean")
@ViewScoped
public class ListaPacjenciBean implements Serializable {
    
    @Inject
    private PacjentService pacjentService;

    private List<ZarajestrowaniPacjenci> pacjenci;

    private LazyDataModel<ZarajestrowaniPacjenci> lazyModel;

    @PostConstruct
    public void init() {
        lazyModel = new PacjentLazyDataModel(pacjentService);
    }

    public LazyDataModel<ZarajestrowaniPacjenci> getLazyModel() {
        return lazyModel;
    }

    public List<ZarajestrowaniPacjenci> getPacjenci() {
        return pacjenci;
    }

    public void setPacjenci(List<ZarajestrowaniPacjenci> pacjenci) {
        this.pacjenci = pacjenci;
    }
}
