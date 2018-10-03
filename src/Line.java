public class Line implements Edge {

    private String color;
    private Node sourceStation;
    private Node destinationStation;


    public Line(String name, Node src, Node dest) {
        this.color = name;
        this.sourceStation = src;
        this.destinationStation = dest;
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
        return this.getSrcNode() == ((Line) o).getSrcNode()  && this.getDestNode() ==(((Line) o).getDestNode());
    }
    @Override
    public String toString(){
        return this.sourceStation + " " + this.getDestNode();
    }
}
