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
		String stringa_padre = padre.get(0).getdenominazione();
        root = new DefaultTreeNode("Root",null);
        
        TreeNode node0 = new DefaultTreeNode(stringa_padre,root);
       
        TreeNode node1 = new DefaultTreeNode("Attività", root);
        
       /* TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
       
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
        node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));*/
    }
     
 
    public TreeNode getRoot() {
        return root;
    }
    
}
