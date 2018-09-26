import java.util.HashMap;

public class Station implements Node{

    private int id;
    private String name;

    public Station(int stationId, String stationName) {

        this.id = stationId;
        this.name = stationName;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString(){

        return this.getId() + "";
    }
    @Override
    public final int hashCode() {
        return this.id >> 16;
    }
    @Override
    public boolean equals(Object o){
        Station tempStation = (Station) o;
        return this.id == ((Station) o).getId()  && this.name.equals(((Station) o).getName());
    }


}
