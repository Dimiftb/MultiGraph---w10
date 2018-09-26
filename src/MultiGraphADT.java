import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {

   int nNodes();
   int nEdges();
   boolean addEdge(String label, Node node1, Node node2);
   boolean addNode(int id, String name);
   boolean isEdge(Node node1, Node node2);
   List<Node> successors(Node node);
   Node getByID(int id);
   int getNumNodes();
   List<Edge> getSources(Node source);

}
