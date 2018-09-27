import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubwayMap {

    private MultiGraphADT multiGraph;
    private Parser p ;

    public SubwayMap( ) {
        Node source = null;
        Node destination = null;
        p = new Parser("src/bostonmetro.txt");


    }

    public void run() throws IOException, BadFileException {
        MultiGraph map = p.createMap();




    }



}
