import java.util.ArrayList;
import java.util.HashMap;

public class MultiGraph implements MultiGraphADT {
    private int nNodes;
    private ArrayList<HashMap<Node, ArrayList<Node>>> AdjacencyNodesList; // not sure if needed since I've used EdgeList Implementation of MultiGraphADT
    private HashMap<Node, Node> edges;

    public MultiGraph(int nodes) {
        nNodes = nodes;
        edges = new HashMap<Node, Node>();
        AdjacencyNodesList = new ArrayList<HashMap<Node, ArrayList<Node>>>(nNodes);
        for(int i = 0; i< AdjacencyNodesList.size(); i++) {
            AdjacencyNodesList.add(new HashMap<>());
        }
    }

    @Override
    public int nNodes() {
        return nNodes;
    }

    @Override
    public int nEdges() {
        return edges.size();
    }

    @Override
    public boolean addEdge(Node node1, Node node2) {
        if(isEdge(node1, node2)) {
            return false;
        }
        else {
            edges.put(node1, node2);
        }
        return true;
    }

    @Override
    public boolean isEdge(Node node1, Node node2) {
           if(edges.containsKey(node1)) {
               if(edges.get(node1).equals(node2)) {
                   return true;
               }
           }
        return false;
    }

    @Override
    public ArrayList<Node> successors(Node node) {
        ArrayList<Node> successors = new ArrayList<Node>();
        for(Node srcStation: edges.keySet()) {
            if( srcStation.equals(node)) {
                successors.add(edges.get(srcStation));
            }
        }
        return successors;
    }

    @Override
    public ArrayList<Node> predecessors(Node node) {
        ArrayList<Node> predecessors = new ArrayList<Node>();
        for(Node destStation: edges.values()) {
            if(destStation.equals(node)){
                for(Node srcStation: edges.keySet()) {
                    if(edges.get(srcStation).equals(destStation)) {
                        predecessors.add(srcStation);
                    }
                }

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
