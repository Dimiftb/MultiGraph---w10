import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraphADT m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();
            FindRoute f = new FindRoute((SubwayMap) m);

        System.out.println(f.findRoute(m.getByID(1),m.getByID(12)));
    }

}
