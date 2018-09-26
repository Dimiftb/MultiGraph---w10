import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubwayMap implements MultiGraphADT {

    private int nStations;
    private List<Station> stations;
    private List<Line> lines;

    public SubwayMap( ) {
        stations = new ArrayList<>();
        lines = new ArrayList<>();

    }

    @Override
    public int nNodes() {
        return stations.size();
    }

    @Override
    public int nEdges() {
        return lines.size();
    }

    @Override
    public boolean addEdge(String label, Node node1, Node node2) {
        if(isEdge(node1, node2)) {
            return false;
        }
        else {
            Line e = new Line(label,node1,node2);
            lines.add(e);
        }
        return true;
    }

    @Override
    public boolean addNode(int id, String name) {
        Station n = new Station(id,name);
        stations.add(n);
        return true;
    }

    @Override
    public boolean isEdge(Node node1, Node node2) {
        for(Line e : lines){
            if((e.getSrcNode().getId() == node1.getId()) && e.getDestNode().getId() == node2.getId() || (e.getSrcNode().getId() == node2.getId()) && e.getDestNode().getId() == node1.getId()){
                return true;
            }
        }

        return false;

    }

    @Override
    public List<Node> successors(Node node) {

        List<Node> successors = new ArrayList<>();
        for(Line e : lines){
            if(e.getSrcNode().getId() == node.getId()){

                successors.add(e.getDestNode());
            }
        }
        return successors;

    }
    public Node getByID(int id){
        for(Node n : stations){
            if(n.getId() == id){
                return n;
            }
        }
        return null;
    }

    @Override
    public int getNumNodes() {
        return stations.size();
    }

}
