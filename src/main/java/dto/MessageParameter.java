package dto;

public class MessageParameter {

    public String key;
    public String readableName;
    public String value;

    public MessageParameter(String key, String readableName, String value) {
        this.key = key;
        this.readableName = readableName;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return readableName + " = " + value + "\n";
    }
}
