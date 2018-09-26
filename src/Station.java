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
}
