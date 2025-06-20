import com.mycompany.przychodnia.ZarajestrowaniPacjenci;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;


@Named
@ApplicationScoped
public class PacjentService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Transactional
    public void zapisz(ZarajestrowaniPacjenci pacjent) throws Exception {
        Long count = em.createQuery(
            "SELECT COUNT(p) FROM ZarajestrowaniPacjenci p WHERE p.pesel = :pesel", Long.class)
            .setParameter("pesel", pacjent.getPesel())
            .getSingleResult();

        if (count != null && count > 0) {
            throw new Exception("Pacjent z tym numerem PESEL już istnieje.");
        }
        em.persist(pacjent);
    }

    public List<ZarajestrowaniPacjenci> findAll() {
        return em.createQuery("SELECT z FROM ZarajestrowaniPacjenci z", ZarajestrowaniPacjenci.class)
                 .getResultList();
    }

    public Long policzPacjentow() {
        return em.createQuery("SELECT COUNT(p) FROM ZarajestrowaniPacjenci p", Long.class)
                 .getSingleResult();
    }

    public ZarajestrowaniPacjenci znajdzPoId(BigDecimal id) {
        return em.find(ZarajestrowaniPacjenci.class, id);
    }

    private Class<?> getFieldType(String fieldName) {
        try {
            Field field = ZarajestrowaniPacjenci.class.getDeclaredField(fieldName);
            return field.getType();
        } catch (NoSuchFieldException | SecurityException e) {
            return null;
        }
    }

    private void dodajWarunkiFiltrowania(StringBuilder sql, List<Object> params, Map<String, FilterMeta> filterBy) {
        if (filterBy == null) return;
        for (Map.Entry<String, FilterMeta> entry : filterBy.entrySet()) {
            String field = entry.getKey();
            FilterMeta filter = entry.getValue();
            Object filterValue = filter.getFilterValue();
            if (filterValue != null && !filterValue.toString().isEmpty()) {
                Class<?> fieldType = getFieldType(field);
                if (fieldType == String.class) {
                    sql.append(" AND LOWER(p.").append(field).append(") LIKE ? ");
                    params.add("%" + filterValue.toString().toLowerCase() + "%");
                } else if (Number.class.isAssignableFrom(fieldType) || fieldType.isPrimitive()) {
                    sql.append(" AND p.").append(field).append(" = ? ");
                    try {
                        if (fieldType == Integer.class || fieldType == int.class) {
                            params.add(Integer.valueOf(filterValue.toString()));
                        } else if (fieldType == Long.class || fieldType == long.class) {
                            params.add(Long.valueOf(filterValue.toString()));
                        } else if (fieldType == Double.class || fieldType == double.class) {
                            boolean add = params.add(Double.parseDouble(filterValue.toString()));
                        } else if (fieldType == BigDecimal.class) {
                            params.add(new BigDecimal(filterValue.toString()));
                        } else {
                            params.add(filterValue);
                        }
                    } catch (NumberFormatException ex) {
                        // Pomijamy filtr, jeśli nie da się przekonwertować
                    }
                }
                // Możesz rozbudować o inne typy, np. daty
            }
        }
    }

    /**
     * Zwraca stronę pacjentów z filtrowaniem i sortowaniem,
     * działając na Oracle starszym niż 12c, z paginacją przez ROWNUM.
     * @param first
     * @param pageSize
     * @param multiSortMeta
     * @param filterBy
     * @return 
     */
    public List<ZarajestrowaniPacjenci> znajdzZakresZFiltrowaniemISortowaniem(
            int first, int pageSize,
            Map<String, SortMeta> multiSortMeta,
            Map<String, FilterMeta> filterBy) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ( ");
        sql.append(" SELECT a.*, ROWNUM rnum FROM ( ");
        sql.append("   SELECT p.* FROM ZARAJESTROWANI_PACJENCI p WHERE 1=1 ");

        List<Object> params = new ArrayList<>();
        dodajWarunkiFiltrowania(sql, params, filterBy);

        // Sortowanie
        if (multiSortMeta != null && !multiSortMeta.isEmpty()) {
            sql.append(" ORDER BY ");
            boolean firstSort = true;
            for (SortMeta sortMeta : multiSortMeta.values()) {
                if (!firstSort) {
                    sql.append(", ");
                }
                sql.append(sortMeta.getField())
                   .append(sortMeta.getOrder() == org.primefaces.model.SortOrder.ASCENDING ? " ASC" : " DESC");
                firstSort = false;
            }
        } else {
            sql.append(" ORDER BY ID ASC ");
        }

        sql.append(" ) a WHERE ROWNUM <= ? "); // max row number (offset + pageSize)
        sql.append(") WHERE rnum > ?");          // offset

        jakarta.persistence.Query query = em.createNativeQuery(sql.toString(), ZarajestrowaniPacjenci.class);

        // Ustaw parametry
        int idx = 1;
        for (Object param : params) {
            query.setParameter(idx++, param);
        }
        query.setParameter(idx++, first + pageSize);  // ROWNUM <= offset+pageSize
        query.setParameter(idx++, first);             // rnum > offset

        return query.getResultList();
    }

    public int policzPacjentowZFiltrami(Map<String, FilterMeta> filterBy) {
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM ZarajestrowaniPacjenci p WHERE 1=1 ");
        Map<String, Object> parameters = new java.util.HashMap<>();

        // Zostawiamy tę metodę po staremu bo nie wpływa na paginację SQL
        // Możesz dodać obsługę typów jak w natywnym zapytaniu jeśli chcesz
        for (Map.Entry<String, FilterMeta> entry : filterBy.entrySet()) {
            String field = entry.getKey();
            FilterMeta filter = entry.getValue();
            Object filterValue = filter.getFilterValue();
            if (filterValue != null && !filterValue.toString().isEmpty()) {
                parameters.put(field, "%" + filterValue.toString().toLowerCase() + "%");
                jpql.append(" AND LOWER(p.").append(field).append(") LIKE :").append(field);
            }
        }

        jakarta.persistence.TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class);
        parameters.forEach(query::setParameter);
        Long count = query.getSingleResult();
        return count != null ? count.intValue() : 0;
    }
}
