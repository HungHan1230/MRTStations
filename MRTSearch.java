import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MRTSearch {

    public static void main(String arg[]) throws IOException {
        MRTinfoController mrTinfoController = new MRTinfoController();

        System.out.println("----功能測試----");
//        //------------------------------------------------------------------
//        //使用範例1
//        String price1 = mrTinfoController.getOneWayTicketPrice("中正紀念堂","頭前庄");
//        System.out.println("單程票="+price1+" 元");
//
//        //------------------------------------------------------------------
//        //使用範例2
//        String price2 = mrTinfoController.getEasyCardPrice("中正紀念堂","頭前庄");
//        System.out.println("悠遊卡="+price2+" 元");
//
//        //------------------------------------------------------------------
//        //使用範例3
//        String time = mrTinfoController.getDuration("中正紀念堂","頭前庄");
//        System.out.println("所需時間="+time+" 分鐘");
//
//        //------------------------------------------------------------------
//        //使用範例4(列印所有捷運站名)
//        String[] stationList = mrTinfoController.getMRTStationList();
//        int ic=0;
//        for(String s: stationList){
//            System.out.println(++ic +": "+s);
//        }
    }

}
