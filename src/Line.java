public class Line implements Edge {

    private String color;
    private Node sourceStation;
    private Node destinationStation;


    public Line(String name, Node srcNode, Node destNode) {
        this.color = name;
        this.sourceStation = srcNode;
        this.destinationStation = destNode;
    }


    @Override
    public String getLabel() {
        return color;
    }

    @Override
    public Node getSrcNode() {
        return sourceStation;
    }

    @Override
    public Node getDestNode() {
        return destinationStation;
    }
    @Override
    public final int hashCode() {
        return this.getSrcNode().getId() >> 16 * this.getDestNode().getId();
    }
    @Override
    public boolean equals(Object o){
        return this.getSrcNode() == ((Line) o).getSrcNode()  && this.getDestNode().equals((Line)((Line) o).getDestNode());
    }
}
