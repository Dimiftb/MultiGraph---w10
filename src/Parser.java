import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    private BufferedReader fileInput;

    public Parser(String filename) {
        try {
            fileInput = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MultiGraphADT createMap() throws BadFileException, IOException {
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String lineName;
        int outbound, inbound;
        String stationName;
        SubwayMap map = new SubwayMap();

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

            Node newStation = new Station(Integer.parseInt(stationID), stationName);
            map.addNode(Integer.parseInt(stationID), stationName);
            while (st.hasMoreTokens()) {

                lineName = st.nextToken();

                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD FORMAT");
                }
                outbound = Integer.parseInt(st.nextToken());
                Node outboundNode = map.getByID(outbound);

                ///THIS IS INCORRECT///
                if (outboundNode != null) {
                    map.addEdge(lineName, outboundNode, newStation);
                }

                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD ADJACENCY");
                }
                //SAME AGAIN
                inbound = Integer.parseInt(st.nextToken());
                Node inboundNode = map.getByID(inbound);

                if (inboundNode != null) {
                    map.addEdge(lineName, newStation, inboundNode);
                }
            }

            line = fileInput.readLine();
        }
        fileInput.close();
        return map;
    }
}
