
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PanelRecepcja {

	public String info() {
		return "panelRecepcja?faces-redirect=true"; 
	}
}
