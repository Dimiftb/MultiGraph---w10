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
        String line;
        StringTokenizer st;
        int stationID;
        String stationName;
        line = fileInput.readLine();

        while (line != null) {
            st = new StringTokenizer(line);
            stationID = Integer.parseInt(st.nextToken());
            if (!st.hasMoreTokens()) {
                fileInput.close();
                throw new BadFileException("NO STATION NAME");
            }

            stationName = st.nextToken();

            if (!st.hasMoreTokens()) {
                fileInput.close();
                throw new BadFileException("NO LINES FOR THE STATION");
            }

            Station station = new Station(stationID, stationName);

            map.addNode(station);
            line = fileInput.readLine();


        }

            fileInput = new BufferedReader(new FileReader(filename));
            line = fileInput.readLine();

            while (line != null) {
                st = new StringTokenizer(line);
                Station outboundStation;
                Station inboundStation;
                Station homeStation;

                String lineName;
                int outboundID;
                int inboundID;
                int homeStationID;


                homeStationID = Integer.parseInt(st.nextToken());
                homeStation = (Station) map.getNode(homeStationID);
                st.nextToken();
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
                    Line inbound = new Line(lineName, outboundStation, homeStation);
                    Line outbound = new Line(lineName, homeStation, inboundStation);
                    map.addEdge(outbound);
                    map.addEdge(inbound);

                line = fileInput.readLine();




            }



        return map;
    }
}










