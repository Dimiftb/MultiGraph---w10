import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraphADT m;
           Parser p = new Parser("src/map.txt");
           m = p.createMap();
        System.out.println(m.getByID(2).getName());

    }

}
