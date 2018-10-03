import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    private BufferedReader fileInput;

    private String filename;

    public Parser(String filename) {

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

            while (st.hasMoreTokens()) {

                Station outboundStation;
                Station inboundStation;
                String lineName;
                int outboundID;
                int inboundID;

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

                    if(inboundID == 0 || outboundID == 0 ){
                        line = fileInput.readLine();
                        continue;
                    }
                    Line inbound = new Line(lineName, outboundStation, station);
                    Line outbound = new Line(lineName, station, inboundStation);
                    map.addEdge(outbound);
                    map.addEdge(inbound);

                if(st.hasMoreTokens()){
                    continue;
                }

                line = fileInput.readLine();


            }


        }
        return map;
    }
}










