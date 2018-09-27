import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;

public class FindRoute {

    private MultiGraphADT graph;

    public FindRoute(MultiGraphADT graph) {
        this.graph = graph;
    }

    public List<Node> findRoute(Node source, Node destination) {
        Set visited = new HashSet<Node>();
        Queue<Node> queue = new LinkedList();

        if(source.equals(destination)){
            System.out.println("Goal found, ending");

        }


            queue.add(source);
            visited.add(source);
        while(!queue.isEmpty()){

            Node current = queue.remove();
            if(current.equals(destination)){
                return new ArrayList<>(visited);

            }
            else{
                if(graph.successors(current).isEmpty()){
                    continue;
                }
                else{
                    queue.addAll(graph.successors(current));
                }
                visited.add(current);
            }

        }




        return null;
    }

}
