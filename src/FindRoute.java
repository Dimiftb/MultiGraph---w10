import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;

public class FindRoute {

    private MultiGraphADT graph;

    public FindRoute(MultiGraphADT graph) {
        this.graph = graph;
    }

    public List<Node> findRoute(Node source, Node destination) {
        if(source.equals(destination)){
            System.out.println("Errorm: Source is destination, try again");
            return null;
        }

        return null;
    }

}
