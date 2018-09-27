public class Line implements Edge {

    private String color;
    private int sourceStation;
    private int destinationStation;


    public Line(String name, int srcID, int destID) {
        this.color = name;
        this.sourceStation = srcID;
        this.destinationStation = destID;
    }


    @Override
    public String getLabel() {
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
    @Override
    public final int hashCode() {
        return this.getSrcNode() >> 16 * this.getDestNode();
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
