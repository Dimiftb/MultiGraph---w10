import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;

public class FindRoute {

    private MultiGraph graph;
    private Node srcStation;
    private Node destStation;

    public FindRoute(MultiGraph graph, Node sourceStation, Node destinationStation) {
        this.graph = graph;
        this.srcStation = sourceStation;
        this.destStation = destinationStation;
    }

    public ArrayList<HashMap<Station, Line>> generateRoute() {
            return null;
    }
}
