import java.io.IOException;

public class test {

    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraph m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();

            Node n1 = new Station(1,"Oakgrove");
            Node n2 = new Station(2,"Malden");

        System.out.println(m.isEdge(n1,n2));

    }

}
