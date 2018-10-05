import java.io.IOException;
import java.util.Scanner;

public class BostonMetro {

    private MultiGraphADT multiGraph;
    private Parser p;

    public BostonMetro() throws IOException, BadFileException {
        p = new Parser("src/bostonmetro.txt");
        multiGraph = new MultiGraph();
        p.createMap(multiGraph);
    }

    public void run() {
        Node srcStation = null;
        Node desStation = null;

        Scanner input;
        String stat1;
        String stat2;
        int id = 5000;


        while (srcStation == null) {
            System.out.println("Enter current station");
            input = new Scanner(System.in);
            stat1 = input.next();
            if (stat1.toLowerCase().equals("st.paulstreet")) {
                   srcStation = handleStPaul();

            } else {
                srcStation = multiGraph.getNodeByName(stat1);
                if (srcStation == null) {
                    System.out.println(stat1 + " is not a station");
                }
                else{
                    //FIND ROUTE NOW AND RETURN/PRINT STUFF
                }
            }
        }

        while (desStation == null || desStation.equals(srcStation)) {
            id = 5000;
            System.out.println("Enter destination station");
            input = new Scanner(System.in);

            stat2 = input.next();

            if (stat2.toLowerCase().equals("st.paulstreet")) {
               desStation = handleStPaul();

            } else {
                desStation = multiGraph.getNodeByName(stat2);
                if (desStation == null) {
                    System.out.println(stat2 + " is not a station");
                } else if (desStation.equals(srcStation)) {
                    System.out.println(stat2 + " is the same station as current station, enter a different station");
                }
                else{
                    //FIND ROUTE NOW AND RETURN/PRINT STUFF
                }
            }
        }
    }

    private Node handleStPaul(){
        Scanner s = new Scanner(System.in);

        int id = 0;
        Node station = null;

        while (id != 38 && id != 61) {
            System.out.println("Do you mean St.PaulStreet with id 38 or 61? ");
            id = s.nextInt();
            station = multiGraph.getNode(id);
            if(station == null )
                System.out.println("Station not found, please enter 38 or 61 for either St.Paul Street");
        }


        return station;
    }
}
