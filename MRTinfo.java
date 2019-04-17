public class MRTinfo {
    private String Source;
    private String Destination;
    private String OneWayPrice;
    private String EasyCardPrice;
    private String ElderlyHeartPrice;
    private String Duration;

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getOneWayPrice() {
        return OneWayPrice;
    }

    public void setOneWayPrice(String oneWayPrice) {
        OneWayPrice = oneWayPrice;
    }

    public String getEasyCardPrice() {
        return EasyCardPrice;
    }

    public void setEasyCardPrice(String easyCardPrice) {
        EasyCardPrice = easyCardPrice;
    }

    public String getElderlyHeartPrice() {
        return ElderlyHeartPrice;
    }

    public void setElderlyHeartPrice(String elderlyHeartPrice) {
        ElderlyHeartPrice = elderlyHeartPrice;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void autoSet(String[] SettingArray){
        setSource(SettingArray[0]);
        setDestination(SettingArray[1]);
        setOneWayPrice(SettingArray[2]);
        setEasyCardPrice(SettingArray[3]);
        setElderlyHeartPrice(SettingArray[4]);
        setDuration(SettingArray[5]);
    }
}


