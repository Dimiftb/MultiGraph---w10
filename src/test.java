import java.io.IOException;

public class test {

    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraphADT m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();
            Node n1 = new Station(84,"Oakgrove");
        Node n2 = new Station(79,"Malden");

        System.out.println(m.isEdge(n1,n2));
    }

}
