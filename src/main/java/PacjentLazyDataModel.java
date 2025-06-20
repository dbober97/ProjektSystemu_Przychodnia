
import com.mycompany.przychodnia.ZarajestrowaniPacjenci;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class PacjentLazyDataModel extends LazyDataModel<ZarajestrowaniPacjenci> {

    private final PacjentService pacjentService;

    public PacjentLazyDataModel(PacjentService pacjentService) {
        this.pacjentService = pacjentService;
    }

    @Override
    public List<ZarajestrowaniPacjenci> load(int first, int pageSize,
        Map<String, SortMeta> multiSortMeta, Map<String, FilterMeta> filterBy) {

        // Ustawiamy liczbę rekordów wg aktualnych filtrów (musisz to zaimplementować w serwisie)
        int rowCount = pacjentService.policzPacjentowZFiltrami(filterBy);
        setRowCount(rowCount);

        // Pobierz dane z filtrowaniem i sortowaniem
        return pacjentService.znajdzZakresZFiltrowaniemISortowaniem(
            first, pageSize, multiSortMeta, filterBy);
    }



    @Override
    public int count(Map<String, FilterMeta> map) {
        return pacjentService.policzPacjentow().intValue();
    }
@Override
public String getRowKey(ZarajestrowaniPacjenci pacjent) {
    return pacjent.getId().toString();
}

@Override
public ZarajestrowaniPacjenci getRowData(String rowKey) {
    BigDecimal id = new BigDecimal(rowKey);
    return pacjentService.znajdzPoId(id);
}

}