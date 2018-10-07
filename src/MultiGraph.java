import java.lang.reflect.Array;
import java.util.*;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;
    private Map<Node, Node> edgeMap;

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
            if (e.getSrcNode() == null || e.getDestNode() == null) {
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
        for (Node n : nodes) {
            if (isEdge(n, node)) {
                successors.add(n);
            }
        }
        return successors;

    }

    public Node getNodeByName(String name) {
        for (Node n : nodes) {
            if (n.getName().toLowerCase().replaceAll(" ", "").equals(name.toLowerCase().replaceAll(" ", ""))) {
                return n;
            }
        }
        return null;
    }

    public Node getNode(int id) {
        for (Node n : nodes) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public List<Edge> getedges() {
        return this.edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void findRoute(Node srcNode, Node desNode) {
        List<Node> visited = new ArrayList<>();
        visited.add(srcNode);
        boolean arrived = false;
        edgeMap = new HashMap<>();
        int i = 0;

        while (!arrived) {
            List<Node> m = successors(visited.get(i));

            for (Node n : m) {
                if (!visited.contains(n)) {
                    visited.add(n);

                    if (n.equals(desNode)) {
                        arrived = true;
                    }
                    edgeMap.put(n, visited.get(i));
                }
            }
            i++;
        }

        boolean test = false;
        Node temp = desNode;

        //In Reverse Order
        List<Node> route = new ArrayList<>();
        route.add(temp);

        while (!test) {
            temp = edgeMap.get(temp);
            route.add(temp);

            if (temp.equals(srcNode)) {
                test = true;
            }
        }

        for (Node n : route) {
            System.out.println(n);
        }
    }
}
