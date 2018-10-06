import java.util.Scanner;

public class BostonMetro {

    private MultiGraphADT multiGraph;

    public BostonMetro() {
        multiGraph = new MultiGraph();

    }

    public Node handleStPaul(){
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
