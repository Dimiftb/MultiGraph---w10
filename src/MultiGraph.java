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
        if (e.getSource() == null || e.getDestination() == null) {
            return false;
        } else {
            edges.add(e);
            return true;
        }

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

    public List<Node> successors(Node node) {
        List<Node> successors = new ArrayList<>();
        for (Node n : nodes) {
            if (isEdge(n, node)) {
                successors.add(n);
            }
        }
        return successors;

    }

    public String getLabel(Node n1, Node n2) {
        for (Edge e : edges) {
            if (isEdge(n1, n2)) {
                return e.getLabel();
            }
        }
        return null;
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

    public List<Node> findRoute(Node srcNode, Node desNode) {
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
        Collections.reverse(route);
        //reverse them because theyre backwards
        return  route;
    }

    public List<String> getPath(List<Node> path) {
        String current = "";
        String newLine = "";
        List<String> directions = new ArrayList<>();
        int counter = 0;
        directions.add("Begin at: " + path.get(0).getName());
        current = newLine;
        //For every station
        //ITS 2 AM ON SATURDAY AND IM DOING THIS SORRY FOR BAD COMMENTS
        for (Node station : path) {
            counter++;
            if (counter != path.size()) {

                Node next = path.get(counter);
                List<Edge> edges = this.edges;

                //ULTIMATELY WE'VE NOT ACTUALLY FOUND AN EFFICIENT ROUTE
                // WE'RE JUST PRINTING THE MOST EFFICIENT ONE!!!!!
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
                        System.out.println(e.getLabel());
                    }
                }
                //I ALMOST HAD THIS ABOUT 8 COMMITS AGO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (!current.equals(newLine)) {
                    current = newLine;
                    directions.add("At: " + station.getName() + " change to the " + current + " Line");
                }
            }
        }
        directions.add("After this final change you will arrive at your desired station. " +
                "" +
                "THANKS FOR USING OUR MULTIGRAPH MAP MAP MAP MAPPER MAP");
        return directions;
    }


}

