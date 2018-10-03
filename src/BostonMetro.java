import java.io.IOException;
import java.util.Scanner;

public class BostonMetro {

    private Node srcStation;
    private Node desStation;
    private MultiGraphADT multiGraph;
    private Parser p;

    public BostonMetro() {
        p = new Parser("src/bostonmetro.txt");
        try {
            multiGraph = p.createMap();
        } catch (BadFileException e) {
            System.out.println("Error, there is issues in the file");
        } catch (IOException e) {
            System.out.println("Error, Input or Output issue");
        }

    }

    public void run() {
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
