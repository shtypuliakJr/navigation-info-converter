import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class Validator {

    private final Pattern pattern = Pattern.compile("^[$][A-Za-z0-9,.]++[*][A-Z0-9]++$");

    public void validateByPattern(String message) {
        if (!pattern.matcher(message).matches()) {
            throw new RuntimeException("Invalid message");
        }
    }

    public void validateByControlSum(String messageString, String controlSum) {
        int controlSumValue = Integer.parseInt(controlSum, 16);
        messageString = messageString.substring(messageString.indexOf("$") + 1, messageString.indexOf("*"));

        byte[] bytes = messageString.getBytes(StandardCharsets.UTF_8);
        StringBuilder beginWord = new StringBuilder(this.getStringInterpretationOfBinaryFromByte(bytes[0]));

        for (int i = 1; i < bytes.length; i++) {

            String nextWord = this.getStringInterpretationOfBinaryFromByte(bytes[i]);
            StringBuilder newWord = new StringBuilder();
            for (int j = 0; j < beginWord.length(); j++) {
                newWord.append(charOf(bitOf(beginWord.charAt(j)) ^ bitOf(nextWord.charAt(j))));
            }
            beginWord = newWord;
        }
        int controlSumDecimalValue = Integer.parseInt(beginWord.toString(), 2);
        String controlSumHexValue = Integer.toString(controlSumDecimalValue, 16);

        System.out.println("Checking control sum:");
        System.out.println("After XOR operation: " + controlSum);
        System.out.println("\tinitial value after checking: " + controlSum);
        System.out.println("\tbinary value after checking: " + controlSum);
        System.out.println("\thex value after checking: " + controlSumHexValue.toUpperCase());

        if (controlSumHexValue.toUpperCase().equals(controlSum.toUpperCase())) {
            throw new RuntimeException("Wrong control sum: \nInitial = " + controlSum +
                    "; After checking = " + controlSumHexValue.toUpperCase());
        }

    }

    private String getStringInterpretationOfBinaryFromByte(byte unit) {
        return String.format("%8s", Integer.toBinaryString(unit & 0xFF)).replace(' ', '0');
    }

    private static boolean bitOf(char in) {
        return (in == '1');
    }

    private static char charOf(boolean in) {
        return (in) ? '1' : '0';
    }

}

