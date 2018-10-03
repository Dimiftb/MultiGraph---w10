import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    private BufferedReader fileInput;
    private MultiGraph map;
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

    public MultiGraph createMap(MultiGraph map) throws BadFileException, IOException {
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
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

            Station outboundStation;
            Station inboundStation;
            st = new StringTokenizer(line);
            int stationID = Integer.parseInt(st.nextToken());
            Station stationStation = (Station) map.getNode(stationID);
            st.nextToken();

            while (st.hasMoreTokens()) {

                lineName = st.nextToken();
                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD FORMAT");
                }
                outboundID = Integer.parseInt(st.nextToken());
                outboundStation = (Station) map.getNode(outboundID);

                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD ADJACENCY");
                }

                inboundID = Integer.parseInt(st.nextToken());
                inboundStation = (Station) map.getNode(inboundID);

                if(inboundStation == null || outboundStation == null){

                }
                else {

                    Line inbound = new Line(lineName, outboundStation, stationStation);
                    Line outbound = new Line(lineName, stationStation, inboundStation);
                    map.addEdge(outbound);
                    map.addEdge(inbound);
                }




                line = fileInput.readLine();

            }

        }

    }
}

