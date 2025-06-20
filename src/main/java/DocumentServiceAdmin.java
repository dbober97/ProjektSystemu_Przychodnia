
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@ApplicationScoped
public class DocumentServiceAdmin {

    public TreeNode<Document> createDocuments() {
        TreeNode<Document> root = new DefaultTreeNode(new Document("Files", "-", "Folder"), null);

        TreeNode pracownicy = new DefaultTreeNode(new Document("Pracownicy", "", ""), root);
        TreeNode inne = new DefaultTreeNode(new Document("Pozostałe zadania", "", ""), root);

        
        //Pracownicy
        TreeNode dodajPracownika = new DefaultTreeNode(new Document("Utwórz konto pracownika", "", "-"), pracownicy);
        TreeNode usunPracownika = new DefaultTreeNode(new Document("Zblokuj konto pracownika", "", "-"), pracownicy);
        
        
        //Pozostałe
        TreeNode inneZadanie = new DefaultTreeNode(new Document("Przykładowe inne zadanie", "", "-"), inne);
        return root;
    }

    public TreeNode<Document> createCheckboxDocuments() {
        TreeNode<Document> root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);

        TreeNode pracownicy = new CheckboxTreeNode(new Document("Pracownicy", "", "-"), root);
        TreeNode inne = new CheckboxTreeNode(new Document("Pozostałe zadania", "", "-"), root);
        
        //Pacjenci
        TreeNode dodajPracownika = new CheckboxTreeNode(new Document("Utwórz konto pracownika", "", "-"), pracownicy);
        TreeNode usunPracownika = new CheckboxTreeNode(new Document("Zblokuj konto pracownika", "", "-"), pracownicy);
        
        //Pozostałe
        TreeNode inneZadanie = new CheckboxTreeNode(new Document("Przykładowe inne zadanie", "", "-"), inne);
        return root;

    }
}