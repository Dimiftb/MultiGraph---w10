import java.io.IOException;

public class BostonMetro {

    private MultiGraphADT multiGraph;
    private Parser p;

    public BostonMetro() {
        p = new Parser("src/bostonmetro.txt");
        run();

    }

    private void run() {
        try {
            multiGraph = p.createMap();
        } catch (BadFileException e) {
            System.out.println("Error, there is issues in the file");
        } catch (IOException e){
            System.out.println("Error, Input or Output issue");
        }
    }
}
