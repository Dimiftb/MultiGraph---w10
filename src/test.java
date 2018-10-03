import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException, BadFileException {
        MultiGraph m;
        Parser p = new Parser("src/bostonmetro.txt");

        m = p.createMap();
        Node n1 = new Station(28, "Oakgrove");
        Node n2 = new Station(22, "Malden");

        System.out.println(m.isEdge(n1, n2));
        System.out.println(m.getNodeByName("Downtown Crossing"));

        BostonMetro a = new BostonMetro();
        a.run();
    }

}
