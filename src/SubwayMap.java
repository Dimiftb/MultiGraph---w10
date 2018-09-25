import java.util.ArrayList;
import java.util.HashMap;

public class SubwayMap implements MultiGraphADT {

    private int nStations;
    private ArrayList<Station> stationList;
    private ArrayList<HashMap<Station, ArrayList<Station>>> AdjacencyStationsList;// not sure if neeeded EdgeList implementation again
    private HashMap<Station, Station> lines;

    public SubwayMap(int stations ) {
        nStations = stations;
        stationList = new ArrayList<Station>();
        lines = new HashMap<Station, Station>();
        AdjacencyStationsList = new ArrayList<HashMap<Station, ArrayList<Station>>>();
        for(int i = 0; i < AdjacencyStationsList.size(); i++) {
            AdjacencyStationsList.add(new HashMap<>());
        }
    }

    @Override
    public int nNodes() {
        return nStations;
    }

    @Override
    public int nEdges() {
        return lines.size();
    }

    @Override
    public boolean addEdge(Node node1, Node node2) {
        Station station1 = new Station(node1.getId(), node2.getName());
        Station station2 = new Station(node1.getId(), node2.getName());
        if(isEdge(node1, node2)){
            return false;
        }
        else {
            lines.put(station1, station2);
        }
        return true;
    }

    @Override
    public boolean isEdge(Node node1, Node node2) {
        Station station1 = new Station(node1.getId(), node2.getName());
        Station station2 = new Station(node1.getId(), node2.getName());
        if(lines.containsKey(station1)){
            if(lines.get(station1).equals(station2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Node> successors(Node node) {
        Station currentStation = new Station(node.getId(), node.getName());
        ArrayList<Node> successors = new ArrayList<Node>();
        for(Station srcStation: lines.keySet()) {
           if(srcStation.equals(currentStation)) {
                successors.add(lines.get(srcStation));
            }
        }
        return successors;

    }


    @Override
    public ArrayList<Node> predecessors(Node node) {
        ArrayList<Node> predecessors = new ArrayList<Node>();
        Station currentStation = new Station(node.getId(), node.getName());
        for(Station destStation: lines.values()) {
            if(destStation.equals(node)) {
                for(Station srcStation: lines.keySet()) {
                    if(lines.get(srcStation).equals(destStation)) {
                        predecessors.add(srcStation);
                    }
                }
            }
        }

        return predecessors;
    }

    @Override
    public int inDegree(Node node) {
        return predecessors(node).size();
    }

    @Override
    public int outDegree(Node node) {
        return successors(node).size();
    }

    private SubwayMap generateMap() {

        return null;
    }
}
