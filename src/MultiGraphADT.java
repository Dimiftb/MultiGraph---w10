import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {

   int nNodes();
   int nEdges();
   boolean addEdge(String label, Node node1, Node node2);
   boolean addNode(int id, String name);
   boolean isEdge(Node node1, Node node2);
   List<Node> successors(Node node);
   List<Node> predecessors(Node node);
   int inDegree(Node node);
   int outDegree(Node node);
}
