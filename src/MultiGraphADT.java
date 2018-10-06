import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {

   int nNodes();
   int nEdges();
   void addEdge(Edge e);
   void addNode(Node n);
   boolean isEdge(Node node1, Node node2);
   List<Node> successors(Node node);

}
