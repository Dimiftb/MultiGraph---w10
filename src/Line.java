public class Line implements Edge {

    private String color;
    private Station sourceStation;
    private Station destinationStation;


    public Line(String name, Station src, Station dest) {
        this.color = name;
        this.sourceStation = src;
        this.destinationStation = dest;
    }

    /*
     * These are all self explanatory
     */
    @Override
    public String getLabel() {
        return color;
    }

    @Override
    public Node getSource() {
        return sourceStation;
    }

    @Override
    public Node getDestination() {
        return destinationStation;
    }

    /*
     * This was used for if we had hashmaps.
     * Don't think we used hashmaps.
     */
    @Override
    public final int hashCode() {
        return this.getSource().getID() >> 16 * this.getDestination().getID();
    }
    @Override
    public boolean equals(Object o){
        return this.getSource() == ((Line) o).getSource()  && this.getDestination() ==(((Line) o).getDestination());
    }
    @Override
    public String toString(){
        return this.sourceStation + " " + this.getDestination();
    }
}
