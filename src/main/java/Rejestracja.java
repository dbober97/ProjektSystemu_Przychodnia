
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Rejestracja {

	public String info() {
		return "rejestracja?faces-redirect=true"; 
	}
}
