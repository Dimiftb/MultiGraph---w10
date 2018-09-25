public class LineSegment implements Edge {

    private String color;
    private int sourceStation;
    private int destinationStation;


    public LineSegment(String name, int srcNode, int destNode) {
        this.color = name;
        this.sourceStation = srcNode;
        this.destinationStation = destNode;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getSrcNode() {
        return sourceStation;
    }

    @Override
    public int getDestNode() {
        return destinationStation;
    }
}
