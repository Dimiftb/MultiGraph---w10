public class Line implements Edge {

    private String color;
    private Station sourceStation;
    private Station destinationStation;


    public Line(String name, Station src, Station dest) {
        this.color = name;
        this.sourceStation = src;
        this.destinationStation = dest;
    }


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
    @Override
    public final int hashCode() {
        return this.getSource().getId() >> 16 * this.getDestination().getId();
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
