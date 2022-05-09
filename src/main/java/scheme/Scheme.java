package scheme;

import dto.MessageParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Scheme {

    public String schemeName;
    private List<MessageParameter> messageParameterList;

    public void readScheme(String schemeName) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(schemeName));
        messageParameterList = bufferedReader.lines()
                .map(line -> line.split(": "))
                .map(strings -> new MessageParameter(strings[0], strings[1], ""))
                .collect(Collectors.toList());
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public void setValuesForScheme(List<String> listMessage) {
        final int[] index = {0};
        messageParameterList
                .forEach(messageParameter -> messageParameter.value = listMessage.get(index[0]++));

    }

    @Override
    public String toString() {
        StringBuilder schemeValues = new StringBuilder();
        messageParameterList.forEach(messageParameter -> schemeValues
                .append(String.format("%s = %s \n", messageParameter.readableName, messageParameter.value)));
        return "Назва схеми: " + schemeName + '\n' +
                "Параметри: \n" + schemeValues;
    }
}
