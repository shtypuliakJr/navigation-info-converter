import dto.Message;
import scheme.Scheme;
import scheme.SchemeFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Interpretator {

    private final SchemeFactory schemeFactory = new SchemeFactory();
    private final Validator validator = new Validator();

    public String interpretateMessage(String message) {
        Message messageInstance = convertMessage(message);

        try {
            Scheme scheme = schemeFactory.getNewInstance(messageInstance.getSchemeName());
            scheme.setValuesForScheme(messageInstance.getListMessage());
            return scheme.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No appropriate message");
    }

    public Message convertMessage(String messageString) {

        System.out.println("|" + "-".repeat(75) + "|\n");

        validator.validateByPattern(messageString);

        List<String> splitMessage = new LinkedList<>(Arrays.asList(messageString.split("[,*]")));
        String schemeName = splitMessage.remove(0).substring(1);
        String controlSum = splitMessage.remove(splitMessage.size() - 1);

        validator.validateByControlSum(messageString, controlSum);

        Message message = new Message();
        message.setSchemeName(schemeName);
        message.setControlSum(controlSum);
        message.setListMessage(splitMessage);

        return message;
    }

}