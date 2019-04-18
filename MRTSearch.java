import java.io.*;

/**
 * After debugging and adding comments
 * @Author Hank Su
 * @DataStructure: In this work, I combined two HashMaps to build up the custom data structure. The data structure performs in json format would be like the following shape.
 *   stationmaps
 *   {"台電大樓": {
 *        stations
 *        "台大醫院": {
 *            "Source": "台電大樓",
 *            "Destination": "台大醫院",
 *            "OneWayPrice": "20",
 *            "EasyCardPrice": "16",
 *            "ElderlyHeartPrice": "8",
 *            "Duration": "6"
 *        },
 *        "科技大樓": {
 *            "Source": "台電大樓",
 *            "Destination": "科技大樓",
 *            "OneWayPrice": "20",
 *            "EasyCardPrice": "16",
 *            "ElderlyHeartPrice": "8",
 *            "Duration": "18"
 *        },......
 *     },.....
 *   }
 *   I wrote a beautiful json print in the MRTinfoController.Initialize() function. If there's any confusion, try to print it out may help understand it.
 *
 * @LastestModification: 2019/04/18
 */
public class MRTSearch {

    public static void main(String arg[]) throws IOException {
        MRTinfoController mrTinfoController = new MRTinfoController();

        System.out.println("----功能測試----");
        //------------------------------------------------------------------
        //使用範例1
        String price1 = mrTinfoController.getOneWayTicketPrice("新店","新店區公所");
        System.out.println("單程票="+price1+" 元");

        //------------------------------------------------------------------
        //使用範例2
        String price2 = mrTinfoController.getEasyCardPrice("新店","新店區公所");
        System.out.println("悠遊卡="+price2+" 元");

        //------------------------------------------------------------------
        //使用範例3
        String time = mrTinfoController.getDuration("新店","新店區公所");
        System.out.println("所需時間="+time+" 分鐘");

        //------------------------------------------------------------------
        //使用範例4(列印所有捷運站名)
        Object[] stationList = mrTinfoController.getMRTStationList();
        int ic=0;
        for(Object s: stationList){
            System.out.println(++ic +": "+s);
        }
    }

}
