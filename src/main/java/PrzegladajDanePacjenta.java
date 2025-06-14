import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PrzegladajDanePacjenta {

	public String info() {
		return "przegladajDanePacjenta?faces-redirect=true"; 
	}
}
