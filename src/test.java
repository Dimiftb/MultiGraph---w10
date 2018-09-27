import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraph m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();
           FindRoute f = new FindRoute(m);
        Node test1 = new Station(1,"Oakgrove");
        Node test2 = new Station(30,"DowntownCrossing");
        System.out.println(f.findRoute(test1,test2));
    }

}
