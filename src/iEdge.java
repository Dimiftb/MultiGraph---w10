import java.awt.*;

public class iEdge implements Edge
{
    Node Source;
    Node Destination;
    String colour;

    public iEdge(String label, Node n1, Node n2){
        this.colour = label;
        this.Source = n1;
        this.Destination = n2;
    }
    @Override
    public String getLabel() {
        return colour;
    }

    @Override
    public Node getSrcNode() {
        return Source;
    }

    @Override
    public Node getDestNode() {
        return Destination;
    }
}
