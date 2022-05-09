package dto;

import java.util.List;

public class Message {

    public String schemeName;
    public List<String> listMessage;
    public String controlSum;

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public List<String> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<String> listMessage) {
        this.listMessage = listMessage;
    }

    public String getControlSum() {
        return controlSum;
    }

    public void setControlSum(String controlSum) {
        this.controlSum = controlSum;
    }
}
