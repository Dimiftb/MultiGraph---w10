import java.util.ArrayList;

public interface MultiGraphADT {

   int nNodes();
   int nEdges();
   boolean addEdge(Node node1, Node node2);
   boolean isEdge(Node node1, Node node2);
   ArrayList<Node> successors(Node node);
   ArrayList<Node> predecessors(Node node);
   int inDegree(Node node);
   int outDegree(Node node);
}
