import java.io.IOException;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws BadFileException, IOException {
        var metro = new BostonMetro();
        var multiGraph = new MultiGraph();
        var p = new Parser("src/bostonmetro.txt");
        p.createMap(multiGraph);
        Node srcStation = null;
        Node desStation = null;

        Scanner input = new Scanner(System.in);
        String stat1;
        String stat2;
        int id = 5000;


        while (srcStation == null) {
            System.out.println("Enter current station");
            stat1 = input.nextLine();
            if (stat1.toLowerCase().equals("st.paulstreet")) {
                srcStation = metro.handleStPaul();

            } else {
                srcStation = multiGraph.getNodeByName(stat1);
                if (srcStation == null) {
                    System.out.println(stat1 + " is not a station");
                }

            }
            while (desStation == null || desStation.equals(srcStation)) {
                id = 5000;
                System.out.println("Enter destination station");
                stat2 = input.nextLine();

                if (stat2.toLowerCase().equals("st.paulstreet")) {
                    desStation = metro.handleStPaul();

                } else {
                    desStation = multiGraph.getNodeByName(stat2);
                    if (desStation == null) {
                        System.out.println(stat2 + " is not a station");
                    } else if (desStation.equals(srcStation)) {
                        System.out.println(stat2 + " is the same station as current station, enter a different station");
                    }
                }
            }
            System.out.println("Finding your route!!");
            System.out.println(multiGraph.findRoute(srcStation,desStation));
        }
    }

}

