import java.io.IOException;

public class Application {


    public static void main(String[] args) throws BadFileException, IOException {
        BostonMetro metro = new BostonMetro();
        metro.run();
    }

}

