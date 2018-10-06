import java.lang.reflect.Array;
import java.util.*;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;
    private Map<Node, List<Node>> edgeMap;
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
    public boolean addNode(Node n) {
        nodes.add(n);
        return true;
    }

        /*
         * @params Nodes to check if an edge exists between them
         */
    public boolean isEdge(Node node1, Node node2) {

            for (Edge e : edges) {
                    if(e.getSrcNode() == null || e.getDestNode() == null){
                        continue;
                    }
                if (e.getSrcNode().getId() == node1.getId() && e.getDestNode().getId() == node2.getId()

                || e.getDestNode().getId() == node1.getId() && e.getSrcNode().getId() == node2.getId()) {
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
        }
        return successors;

    }
    public Node getNodeByName(String name){
        for(Node n : nodes){
            if(n.getName().toLowerCase().replaceAll(" ", "").equals(name.toLowerCase().replaceAll(" ",""))){
                return n;
            }
        }
        return null;
    }
    public Node getNode(int id){
            for(Node n : nodes){
                if(n.getId() == id){
                    return n;
                }
            }
            return null;
    }
    public List<Edge> getedges(){
        return this.edges;
    }
    public List<Node> getNodes(){
        return nodes;
    }




    public List<Edge> findRoute(Node source, Node destination) {
        if(source.equals(destination)){
            System.out.println("Error: Source is destination, try again");
            return null;
        }
        else {
            var edgeList = new ArrayList<Edge>();
            var queue = new LinkedList<Node>();
            List<Node> visited = new ArrayList<>();
            queue.add(source);
            visited.add(source);
            while (!queue.isEmpty()) {
                Node current = queue.remove();
                if (current.getId() == destination.getId()) {
                    visited.add(current);
                    System.out.println("visited nodes" + visited);
                    for(int i = 0; i< visited.size() -1 ; i++) {
                        for(int j = 1; j < visited.size(); j ++) {
                            for (Edge e: edges) {
                                if(e.getSrcNode().equals(visited.get(i)) && e.getDestNode().equals(visited.get(j))) {
                                    if(!edgeList.contains(e)) {
                                        edgeList.add(e);
                                    }
                                }
                            }
                        }

                    }
                    return edgeList;
                }
                else {
                    if (!successors(current).isEmpty()) {
                        List<Node> children = successors(current);
                          for ( int i = 0; i < children.size(); i++) {
                              if(!visited.contains(children.get(i))) {
                                  queue.add(children.get(i));
                              }
                          }



                          /*  else {
                                queue.add(children.get(1));
                            }*/

                    } else {
                        System.out.println("No path");
                    }
                    if(!visited.contains(current)) {
                        visited.add(current);
                    }

                }
            }
        }
        return null;
    }
}
