public class iNode implements Node {
    int id;
    String name;
    public iNode(int id, String name){
      this.id = id;
      this.name = name;
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
        return this.id + "";
    }
}
