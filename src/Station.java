public class Station implements Node{

    private int id;
    private String name;

    public Station(int stationId, String stationName) {
        this.id = stationId;
        this.name = stationName;
    }

    //All self explanatory


    @Override
    public int getID() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return this.getID() + " " + this.getName();
    }
    @Override
    public final int hashCode() {
        return this.id >> 16;
    }
    @Override
    public boolean equals(Object o){
        return this.id == ((Station) o).getID() && this.name.equals(((Station) o).getName());

    }


}
