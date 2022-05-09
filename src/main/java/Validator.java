import java.util.regex.Pattern;

public class Validator {

    private final Pattern pattern = Pattern.compile("^[$][A-Za-z0-9,.]++[*][A-Z0-9]++$");

    public void validateByPattern(String message) {
        if (!pattern.matcher(message).matches()) {
            throw new RuntimeException("Invalid message");
        }
    }

//    public void validateByControlSum(String messageString, String controlSum) {
//        int controlSumValue = Integer.parseInt(controlSum, 16);
//        int length = messageString
//                .substring(1, messageString.indexOf('*'))
//                .replaceAll(",", "")
//                .length();
//        System.out.println(controlSumValue + " " + length);
//
//    }
}
