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

    public MultiGraph createMap() throws BadFileException, IOException {
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String lineName;
        int outboundID, inboundID;
        String stationName;
        MultiGraph map = new MultiGraph();

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
            while (st.hasMoreTokens()) {

                lineName = st.nextToken();

                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD FORMAT");
                }
                outboundID = Integer.parseInt(st.nextToken());

                if (!st.hasMoreTokens()) {
                    fileInput.close();
                    throw new BadFileException("BAD ADJACENCY");
                }

                inboundID = Integer.parseInt(st.nextToken());

                Line outbound = new Line(lineName,inboundID, Integer.parseInt(stationID));
                Line inbound = new Line(lineName,outboundID,Integer.parseInt(stationID));
                map.addEdge(outbound);
                map.addEdge(inbound);



            }

            line = fileInput.readLine();
        }
        fileInput.close();
        return map;
    }
}
