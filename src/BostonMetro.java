import java.io.IOException;
import java.util.Scanner;

public class BostonMetro {


    private Node srcStation;
    private Node desStation;
    private MultiGraph multiGraph;
    private Parser p;

    public BostonMetro() throws IOException, BadFileException {
        p = new Parser("src/bostonmetro.txt");
        multiGraph = new MultiGraph();

        p.createMap((MultiGraph) multiGraph);
        run();

    }

    public void run() {
        srcStation = null;
        desStation = null;

        Scanner input;
        String stat1;
        String stat2;
        int id = 5000;


        while (srcStation == null) {


            System.out.println("Enter current station");
            input = new Scanner(System.in);
            stat1 = input.next();
            if(stat1.equals("St.PaulStreet")){
                while(id != 38 && id != 61) {
                    System.out.println("Do you mean St.PaulStreet with id 38 or 61?");
                    input = new Scanner(System.in);
                    id = input.nextInt();
                    srcStation = multiGraph.getNode(id);

                }

            }else {
                srcStation = multiGraph.getNodeByName(stat1);
                if (srcStation == null) {
                    System.out.println(stat1 + " is not a station");
                }
            }
        }

        while (desStation == null || desStation == srcStation ) {
            id = 5000;
            System.out.println("Enter destination station");
            input = new Scanner(System.in);
            stat2 = input.next();
            if(stat2.equals("St.PaulStreet")){
                while(id != 38 && id != 61) {
                    System.out.println("Do you mean St.PaulStreet with id 38 or 61? ");
                    input = new Scanner(System.in);
                    id = input.nextInt();
                    desStation = multiGraph.getNode(id);
                }

            }else {
                desStation = multiGraph.getNodeByName(stat2);
                if (desStation == null) {
                    System.out.println(stat2 + " is not a station");
                }
            }
        }
    }

}
