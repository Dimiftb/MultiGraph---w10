import java.lang.reflect.Array;
import java.util.*;

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
    public boolean addEdge(Edge e) {
        edges.add(e);
        return true;
    }
    public int numNodes(){
        return nodes.size();
    }
    @Override
    public boolean addNode(Node n) {
        nodes.add(n);
        return true;
    }
        /*
         * @params Nodes to check if an edge exists between them
         */
    @Override
    public boolean isEdge(Node node1, Node node2) {
       for(Edge e : edges){
           if(e.getSrcNode().getId() == node1.getId() && e.getDestNode().getId() == node2.getId()){
               return true;
           }
       }
       return false;
    }
    @Override
    public List<Node> successors(Node node) {
        List<Node> successors = new ArrayList<>();
        for(Node n : nodes){
            if(isEdge(n,node)){
                successors.add(n);
            }
            else if(isEdge(n,node)){
                successors.add(node);
            }
        }
        return successors;

    }
    public Node getNode(int id){
        if(id == 0){
            return null;
        }
            return nodes.get(id-1);
    }

    public List<Edge> getEdges(){
        return edges;
    }
}
