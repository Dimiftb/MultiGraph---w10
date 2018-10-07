import java.io.IOException;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws BadFileException, IOException {
        BostonMetro metro = new BostonMetro();
        metro.run();
    }

}

