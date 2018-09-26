import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;

    public MultiGraph() {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();

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
        for(Edge e : edges){
                if((e.getSrcNode().getId() == node1.getId()) && e.getDestNode().getId() == node2.getId() || (e.getSrcNode().getId() == node2.getId()) && e.getDestNode().getId() == node1.getId()){
                    return true;
                }
        }
        return false;
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

    @Override
    public List<Node> predecessors(Node node) {
        List<Node> predecessors = new ArrayList<>();

        for(Edge e : edges){
            if(e.getDestNode().getId() == node.getId()){
                predecessors.add(e.getSrcNode());
            }
        }
        return predecessors;
    }

    @Override
    public int inDegree(Node node) {
        return successors(node).size();
    }

    @Override
    public int outDegree(Node node) {
        return predecessors(node).size();
    }

}
