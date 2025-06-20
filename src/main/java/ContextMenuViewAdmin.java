
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import org.primefaces.model.TreeNode;



@Named("ttContextMenuViewAdmin")
@ViewScoped
public class ContextMenuViewAdmin implements Serializable {

    private TreeNode<Document> root;

    private TreeNode<Document> selectedNode;

    @Inject
    private DocumentServiceAdmin service;

    @PostConstruct
    public void init() {
        root = service.createDocuments();
    }

    public TreeNode<Document> getRoot() {
        return root;
    }

    public void setService(DocumentServiceAdmin service) {
        this.service = service;
    }

    public TreeNode<Document> getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode<Document> selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }

    public void viewNode() {
        // no-op
    }
}