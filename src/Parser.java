import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    private BufferedReader fileInput;
    private MultiGraphADT map;
    private String filename;

    public Parser(String filename) {
        map = new MultiGraph();
        try {
            fileInput = new BufferedReader(new FileReader(filename));
            this.filename = filename;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MultiGraphADT createMap() throws BadFileException, IOException {
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String lineName;
        int outboundID, inboundID;
        String stationName;

        while (line != null) {
            st = new StringTokenizer(line);

            if (!st.hasMoreTokens()) {
                line = fileInput.readLine();
                continue;
            }
            stationID = st.nextToken();
            if (!st.hasMoreTokens()) {
                fileInput.close();
                throw new BadFileException("NO STATION NAME");
            }
            stationName = st.nextToken();
            if (!st.hasMoreTokens()) {
                fileInput.close();
                throw new BadFileException("NO LINES FOR THE STATION");
            }
            Station station = new Station(Integer.parseInt(stationID), stationName);
            map.addNode(station);

            line = fileInput.readLine();
        }

        getEdges();
        return map;
        }

    private void getEdges() throws IOException, BadFileException {
        fileInput = new BufferedReader(new FileReader(filename));

        String line;
        StringTokenizer st;
        String lineName;

        int outboundID;
        int inboundID;

        line = fileInput.readLine();


        while (line != null) {

            st = new StringTokenizer(line);
            int stationID = Integer.parseInt(st.nextToken());
            Node stationStation = map.getNode(stationID);
            st.nextToken();

            lineName = st.nextToken();

            if (!st.hasMoreTokens()) {
                fileInput.close();
                throw new BadFileException("BAD FORMAT");
            }

            outboundID = Integer.parseInt(st.nextToken());

            if(outboundID == 0){
                line = fileInput.readLine();
                continue;
            }

            Node outboundStation = map.getNode(outboundID);

            if (!st.hasMoreTokens()) {
                 fileInput.close();
                throw new BadFileException("BAD ADJACENCY");
            }

            inboundID = Integer.parseInt(st.nextToken());
            Node inboundStation = map.getNode(inboundID);

            if(inboundID == 0){
                fileInput.readLine();
                continue;
            }

            Line outbound = new Line(lineName,inboundStation, stationStation);
            Line inbound = new Line(lineName,outboundStation, stationStation);
            map.addEdge(outbound);
            map.addEdge(inbound);
            line =  fileInput.readLine();



        }

    }


}
