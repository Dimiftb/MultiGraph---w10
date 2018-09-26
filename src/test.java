import java.io.IOException;

public class test {
    public static void main(String [] args) throws IOException, BadFileException {
        MultiGraphADT m;
           Parser p = new Parser("src/bostonmetro.txt");
            m = p.createMap();
        System.out.println(m.successors(m.getByID(105)));
    }

}
