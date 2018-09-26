public class test {
    public static void main(String [] args){
        MultiGraphADT m = new MultiGraph();
            Node n1 = new Station(1,"Red");
            Node n2 = new Station(2,"Red");
            Node n3 = new Station(3,"Red");
            Node n4 = new Station(4,"Red");

            m.addEdge("Line1", n3,n1);
            m.addEdge("Line2",n3,n1);
            System.out.println(m.successors(n1));
    }

}
