import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import java.util.List;

 
@ManagedBean(name="pdccoge")
@ViewScoped
public class pdccoge implements Serializable {
     
    private TreeNode root;
     
    @PostConstruct
    public void init() {
		C002_PDC_COGE_UTILITIES pianodeiconti= new C002_PDC_COGE_UTILITIES();
		List<C002_PDC_COGE> padre = pianodeiconti.get_pdc_padre();
        root = new DefaultTreeNode(padre.get(0).cd_voce_coge  +"=>     "+ padre.get(0).denominazione,null);
        TreeNode node0 = new DefaultTreeNode(padre.get(0).cd_voce_coge,null,root);
        TreeNode node1 = new DefaultTreeNode("Node 1", root);
         
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
         
        node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
        node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
        node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
        root.getChildren().add(new DefaultTreeNode("Node 2"));
    }
     
 
    public TreeNode getRoot() {
        return root;
    }
    
}
