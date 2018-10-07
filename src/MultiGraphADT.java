import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {

    void addEdge(Edge e);

    void addNode(Node n);

    boolean isEdge(Node node1, Node node2);

    List<Node> getNeighbours(Node node);

    Node getNodeByID(int id);

    Node getNodeByName(String name);
}
