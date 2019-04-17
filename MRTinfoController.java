import gherkin.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MRTinfoController {
    private HashMap<String,HashMap<String,MRTinfo>> stationmap;

    public MRTinfoController() throws IOException {
        Initialize();
    }

    public void Initialize() throws IOException {
        String path = "src/mrt/";
        BufferedReader bufferedReader;
        String BufferedReaderStr;

        File file = new File(path);
        String[] fileList = file.list();
        stationmap = new HashMap<>();

        for(int i =0; i< fileList.length; i++){
            FileReader fileReader = new FileReader(path+fileList[i]);
            bufferedReader = new BufferedReader(fileReader);
            HashMap<String,MRTinfo> stations = new HashMap<>();

            MRTinfo mrTinfo = null;
            String Mainstation = "";
            int skip =0;

            while ((BufferedReaderStr = bufferedReader.readLine()) != null){
                String[] brsplit = BufferedReaderStr.split(",");
                if(skip++ < 1){
                    continue;
                }
                stations = new HashMap<>();
                mrTinfo = new MRTinfo();
                mrTinfo.autoSet(brsplit);
                stations.put(mrTinfo.getDestination(),mrTinfo);
            }
            Mainstation = mrTinfo.getSource();
            stationmap.put(Mainstation,stations);
            //System.out.println(Mainstation+" added");
        }
    }


    public String getOneWayTicketPrice(String source, String destination){return stationmap.get(source).get(destination).getOneWayPrice();}

    public String getEasyCardPrice(String source, String destination){ return stationmap.get(source).get(destination).getEasyCardPrice();}

    public String getElderlyHeartPrice(String source, String destination){ return stationmap.get(source).get(destination).getEasyCardPrice(); }

    public String getDuration(String source, String destination){  return stationmap.get(source).get(destination).getEasyCardPrice();  }

    public String[] getMRTStationList(){ return (String[]) stationmap.keySet().toArray(); }
}
