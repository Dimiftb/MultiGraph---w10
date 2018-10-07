import java.util.*;

public class MultiGraph implements MultiGraphADT {
    private List<Edge> edges;
    private List<Node> nodes;

    public MultiGraph() {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();

    }

    /*
       Return type is of boolean for the purposes of testing
     */
    public void addEdge(Edge e) {
        if (e.getSource() == null || e.getDestination() == null) {

        } else {
            edges.add(e);

        }
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    /*
     * @params Nodes to check if an edge exists between them
     * @returns True or false if there is an edge between the two nodes
     */
    public boolean isEdge(Node node1, Node node2) {

        for (Edge e : edges) {
            if (e.getSource() == null || e.getDestination() == null) {
                continue;
            }
            if (e.getSource() == node1 && e.getDestination() == node2
                    || e.getDestination() == node1 && e.getSource() == node2) {
                return true;
            }
        }

        return false;
    }
    /*
     * @params Node to get neighbours of
     * @returns A list of potential neighbours to node in multigraph
     */
    public List<Node> getNeighbours(Node node) {
        List<Node> successors = new ArrayList<>();
        for (Node n : nodes) {
            if (isEdge(n, node)) {
                successors.add(n);
            }
        }
        return successors;

    }
    /*
     * @params A name to try and match a node to
     * @returns A node based on the unique name
     */
    public Node getNodeByName(String name) {
        for (Node n : nodes) {
            if (n.getName().toLowerCase().replaceAll(" ", "").equals(name.toLowerCase().replaceAll(" ", ""))) {
                return n;
            }
        }
        return null;
    }
    /*
     * @params An ID to get a node from.
     * @returns A node with that ID.
     */
    public Node getNodeByID(int id) {
        for (Node n : nodes) {
            if (n.getID() == id) {
                return n;
            }
        }
        return null;
    }
    /*
     * @params Two nodes to find a route between
     * @returns A list of nodes indicating the shortest path between them
     */
    public List<Node> findRoute(Node srcNode, Node desNode) {
        List<Node> visited = new ArrayList<>();
        visited.add(srcNode);
        boolean arrived = false;
        Map<Node, Node> edgeMap = new HashMap<>();
        int i = 0;
        while (!arrived) {
            List<Node> m = getNeighbours(visited.get(i));
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
        Collections.reverse(route);
        //reverse them because theyre backwards
        return route;
    }
    /*
     * @params A route between two nodes
     * @returns A list of directions with line changes
     */
    public List<String> getPath(List<Node> route) {
        String current = "";
        String newLine = "";
        List<String> directions = new ArrayList<>();
        int counter = 0;
        directions.add("Begin at: " + route.get(0).getName());
        current = newLine;
        for (Node station : route) {
            counter++;
            if (counter != route.size()) {

                Node next = route.get(counter);
                List<Edge> edges = this.edges;
                for (Edge e : edges) {
                    List<Node> nodes = new ArrayList<>();
                    nodes.add(e.getDestination());
                    nodes.add(e.getSource());
                    boolean node1 = false;
                    boolean node2 = false;
                    for (Node node : nodes) {
                        if (station.equals(node))
                            node1 = true;
                        if (next.equals(node))
                            node2 = true;
                    }
                    if (node1 == true && node2 == true) {
                        newLine = e.getLabel();
                    }
                }
                if (!current.equals(newLine)) {
                    current = newLine;
                    directions.add("At: " + station.getName() + " change to the " + current + " Line");
                }
            }
        }
        directions.add("After this final change you will arrive at your desired station. ");
        return directions;
    }


}

