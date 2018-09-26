import javax.sound.sampled.Line;
import java.util.*;

public class FindRoute {

    private MultiGraph graph;
    private Node srcStation;
    private Node destStation;

    public FindRoute(MultiGraph graph, Node sourceStation, Node destinationStation) {
        this.graph = graph;
        this.srcStation = sourceStation;
        this.destStation = destinationStation;
    }

    private List<Edge> findRoute(Node source, Node destination, MultiGraphADT graph){
        boolean visited[] = new boolean[graph.getNumNodes()];

    return new ArrayList<Edge>();
    }
}
