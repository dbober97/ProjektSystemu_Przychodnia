
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@ApplicationScoped
public class DocumentService {

    public TreeNode<Document> createDocuments() {
        TreeNode<Document> root = new DefaultTreeNode(new Document("Files", "-", "Folder"), null);

        TreeNode pacjenci = new DefaultTreeNode(new Document("Pacjenci", "", ""), root);
        TreeNode terminarze = new DefaultTreeNode(new Document("Terminarze", "", ""), root);
        TreeNode inne = new DefaultTreeNode(new Document("Pozostałe zadania", "", ""), root);

        
        //Pacjenci
        TreeNode dodajPacjenta = new DefaultTreeNode(new Document("Zarejestruj pacjenta w przychodni", "", "-"), pacjenci);
        TreeNode zmienDanePacjenta = new DefaultTreeNode(new Document("Zmień dane pacjenta", "", "-"), pacjenci);
        TreeNode przegladajDanePacjenta = new DefaultTreeNode(new Document("Przeglądaj dane pacjenta", "", "-"), pacjenci);
        TreeNode dodajDaneLogowaniaPacjent = new DefaultTreeNode(new Document("Utwórz pacjentowi konto w systemie", "", "-"), pacjenci);  
        TreeNode zapiszWizytaPacjent = new DefaultTreeNode(new Document("Zapisz pacjenta na wizytę", "", "-"), pacjenci);
        
        //Terminarze
        TreeNode utworzTerminarz = new DefaultTreeNode(new Document("Utwórz nowy terminarz lekarza", "", "-"), terminarze);
        TreeNode przeglądajTerminarz = new DefaultTreeNode(new Document("Przeglądaj terminarze lekarza", "", "-"), terminarze);
        TreeNode modyfikujTerminarz = new DefaultTreeNode(new Document("Modyfikuj terminarz lekarza", "", "-"), terminarze);
        
        //Pozostałe
        TreeNode inneZadanie = new DefaultTreeNode(new Document("Przykładowe inne zadanie", "", "-"), inne);
        return root;
    }

    public TreeNode<Document> createCheckboxDocuments() {
        TreeNode<Document> root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);

        TreeNode pacjenci = new CheckboxTreeNode(new Document("Pacjenci", "", "-"), root);
        TreeNode terminarze = new CheckboxTreeNode(new Document("Terminarze", "", "-"), root);
        TreeNode inne = new CheckboxTreeNode(new Document("Pozostałe zadania", "", "-"), root);
        
        //Pacjenci
        TreeNode dodajPacjenta = new CheckboxTreeNode(new Document("Zarejestruj pacjenta w przychodni", "", "-"), pacjenci);
        TreeNode zmienDanePacjenta = new CheckboxTreeNode(new Document("Zmień dane pacjenta", "", "-"), pacjenci);
        TreeNode przegladajDanePacjenta = new CheckboxTreeNode(new Document("Przeglądaj dane pacjenta", "", "-"), pacjenci);
        TreeNode dodajDaneLogowaniaPacjent = new CheckboxTreeNode(new Document("Utwórz pacjentowi konto w systemie", "", "-"), pacjenci);  
        TreeNode zapiszWizytaPacjent = new CheckboxTreeNode(new Document("Zapisz pacjenta na wizytę", "", "-"), pacjenci);
        
        //Terminarze
        TreeNode utworzTerminarz = new CheckboxTreeNode(new Document("Utwórz nowy terminarz lekarza", "", "-"), terminarze);
        TreeNode przeglądajTerminarz = new CheckboxTreeNode(new Document("Przeglądaj terminarze lekarza", "", "-"), terminarze);
        TreeNode modyfikujTerminarz = new CheckboxTreeNode(new Document("Modyfikuj terminarz lekarza", "", "-"), terminarze);
        
        //Pozostałe
        TreeNode inneZadanie = new CheckboxTreeNode(new Document("Przykładowe inne zadanie", "", "-"), inne);
        return root;

    }
}