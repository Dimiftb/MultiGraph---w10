import java.lang.reflect.Array;
import java.util.*;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;
    private Map<Node,Node > nodeMap;

    public MultiGraph() {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        nodeMap = new HashMap<>();

    }

    @Override
    public int nNodes() {
        return nodes.size();
    }

    @Override
    public int nEdges() {
        return edges.size();
    }

    @Override
    public boolean addEdge(String label, Node node1, Node node2) {
        if(isEdge(node1, node2)) {
            return false;
        }
        else {
            Edge e = new Line(label,node1,node2);
            edges.add(e);
            nodeMap.put(node1,node2);
        }
        return true;
    }

    @Override
    public boolean addNode(int id, String name) {
        Node node = new Station(id,name);
        nodes.add(node);
        return true;
    }

    @Override
    public boolean isEdge(Node node1, Node node2) {
        return nodeMap.containsKey(node1) && nodeMap.get(node1).equals(node2);
    }

    @Override
    public List<Node> successors(Node node) {
        List<Node> successors = new ArrayList<>();
        for(Edge e : edges){
            if(e.getSrcNode().getId() == node.getId()){
                successors.add(e.getDestNode());
            }
        }
        return successors;

    }

}
