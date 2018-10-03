import java.io.IOException;

public class BostonMetro {

    private MultiGraph multiGraph;
    private Parser p;

    public BostonMetro() throws IOException, BadFileException {
        p = new Parser("src/bostonmetro.txt");
        multiGraph = p.createMap(multiGraph);
        run();

    }

    private void run() {
        try {
            multiGraph = p.createMap(multiGraph);
        } catch (BadFileException e) {
            System.out.println("Error, there is issues in the file");
        } catch (IOException e){
            System.out.println("Error, Input or Output issue");
        }
    }
}
