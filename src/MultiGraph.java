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

    @Override
    public boolean isEdge(Node node1, Node node2) {
       for(Edge e : edges){
           if(e.getSrcNode() == node1.getId() && e.getDestNode()== node2.getId()){
               return true;
           }
       }
       return false;
    }
    //Temporary
    public Edge returnEdge(Node n1, Node n2){
        for(Edge e : edges){
            if(e.getSrcNode() == n1.getId() && e.getDestNode() == n2.getId()){
                return e;
            }
        }
        return null;
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
        for(Node n : nodes){
            if(n.getId() == id){
                return n;
            }
        }
        return null;
    }

    }
    public List<Edge> getEdges(){
        return edges;
    }
}
