import java.lang.reflect.Array;
import java.util.*;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;

    public MultiGraph() {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();

    }




    public int nNodes() {
        return nodes.size();
    }


    public int nEdges() {
        return edges.size();
    }


    public boolean addEdge(Edge e) {
        edges.add(e);
        return true;
    }
    public int numNodes(){
        return nodes.size();
    }
    public boolean addNode(Node n) {
        nodes.add(n);
        return true;
    }
        /*
         * @params Nodes to check if an edge exists between them
         */


    public boolean isEdge(Node node1, Node node2) {
       for(Edge e : edges){
           if(e.getSrcNode().getId()==0 || e.getDestNode().getId() == 0){
               return false;
           }
           if(e.getSrcNode().getId() == node1.getId() && e.getDestNode().getId() == node2.getId()
                   || e.getDestNode().getId() == node1.getId() && e.getSrcNode().getId() == node2.getId()){
               return true;
           }
       }
       return false;
    }

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
