import java.io.IOException;
public class BostonMetro {

    private MultiGraphADT multiGraph;
    private Parser p ;

    public BostonMetro( ) {
        Node source = null;
        Node destination = null;
        p = new Parser("src/bostonmetro.txt");


    }

    public void run() throws IOException, BadFileException {
        MultiGraph map = p.createMap();




    }



}
