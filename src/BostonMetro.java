import java.io.IOException;
import java.util.Scanner;

public class BostonMetro {


    private Node srcStation;
    private Node desStation;
    private MultiGraphADT multiGraph;
    private Parser p;

    public BostonMetro() throws IOException, BadFileException {
        p = new Parser("src/bostonmetro.txt");
        multiGraph = new MultiGraph();

        p.createMap((MultiGraph) multiGraph);
        run();

    }

    public void run() {
        Node n1 = new Station(25,"asdf1");
        Node n2 = new Station(29,"asdf1");

        System.out.println(multiGraph.isEdge(n1,n2));
        srcStation = null;
        desStation = null;

        Scanner input;
        String stat1;
        String stat2;


        while (srcStation == null) {

            System.out.println("Enter current station");
            input = new Scanner(System.in);
            stat1 = input.next();
            srcStation = multiGraph.getNodeByName(stat1);
            if (srcStation == null) {
                System.out.println(stat1 + " is not a station");
            }
        }

        while (desStation == null) {
            System.out.println("Enter destination station");
            input = new Scanner(System.in);
            stat2 = input.next();
            desStation = multiGraph.getNodeByName(stat2);
            if (desStation == null) {
                System.out.println(stat2 + " is not a station");
            }
        }

        System.out.println(srcStation);
        System.out.println(desStation);
    }
}
