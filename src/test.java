import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraph m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();
           FindRoute f = new FindRoute(m);

        System.out.println(m.getEdges());
    }

}
