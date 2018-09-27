import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {

   int nNodes();
   int nEdges();
   boolean addEdge(Edge e);
   boolean addNode(Node n);
   boolean isEdge(Node node1, Node node2);
   List<Node> successors(Node node);
   Node getNode(int id);
   int getNumNodes();

}
