import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MRTinfoController {
    private HashMap<String,HashMap<String,MRTinfo>> stationmap;

    public MRTinfoController() throws IOException {
        Initialize();
    }

    /**
     * After debugging and adding comments
     * @Author Hank Su
     * @Function My directory would be like the following
     * ├── mrt
     * │   ├── mrt01.csv
     * │   ├── mrt02.csv
     *     .
     *     .
     *     .
     * ├── MRTinfoController.java
     * ├── MRTinfo.java
     * └── MRTSearch.java
     */

    public void Initialize() throws IOException {
        String path = "src/mrt/";
        BufferedReader bufferedReader;
        String BufferedReaderStr;
        HashMap<String,MRTinfo> stations;

        File file = new File(path);
        String[] fileList = file.list();
        stationmap = new HashMap<>();

        for(int i =0; i< fileList.length; i++){
            FileReader fileReader = new FileReader(path+fileList[i]);
            bufferedReader = new BufferedReader(fileReader);
            stations = new HashMap<>();

            MRTinfo mrTinfo = null;
            String Mainstation = "";
            int skip =0;

            while ((BufferedReaderStr = bufferedReader.readLine()) != null){
                String[] brsplit = BufferedReaderStr.split(",");
                if(skip++ < 1){ //第一行不要讀
                    continue;
                }
                mrTinfo = new MRTinfo();
                mrTinfo.autoSet(brsplit);
                stations.put(mrTinfo.getDestination(),mrTinfo);
            }
            Mainstation = mrTinfo.getSource();
            stationmap.put(Mainstation,stations);
        }
        //The Beautiful Json print
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String prettyJson = gson.toJson(stationmap);
//        System.out.println("JSON: "+ prettyJson);
    }


    public String getOneWayTicketPrice(String source, String destination){return stationmap.get(source).get(destination).getOneWayPrice();}

    public String getEasyCardPrice(String source, String destination){ return stationmap.get(source).get(destination).getEasyCardPrice();}

    public String getElderlyHeartPrice(String source, String destination){ return stationmap.get(source).get(destination).getElderlyHeartPrice(); }

    public String getDuration(String source, String destination){  return stationmap.get(source).get(destination).getDuration();  }

    public Object[] getMRTStationList(){ return stationmap.keySet().toArray(); }
}
