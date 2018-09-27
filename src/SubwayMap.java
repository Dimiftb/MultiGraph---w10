import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubwayMap {

    private MultiGraphADT multiGraph;
    private List<Station> stations;
    private List<Line> lines;
    private Parser p ;

    public SubwayMap( ) {
        stations = new ArrayList<>();
        lines = new ArrayList<>();
        Node source = null;
        Node destination = null;
        p = new Parser("src/bostonmetro.txt");


    }

    public void run() throws IOException, BadFileException {

            MultiGraph map = p.createMap();

    }
    public Node getByID(int id){
        for(Node n : stations){
            if(n.getId() == id){
                return n;
            }
        }
        return null;
    }
    public List<Line> getEdges(){
        return lines;
    }

}
