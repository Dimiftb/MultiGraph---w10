import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.*;

public class FindRoute {

    private SubwayMap graph;

    public FindRoute(SubwayMap graph) {
        this.graph = graph;
    }

    public List<Edge> findRoute(Node source, Node destination) {
        Set visited = new HashSet<Node>();
        Queue<Node> queue = new LinkedList();
        Node startNode = source;

        if(startNode.equals(destination)){
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
                    return null;
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
