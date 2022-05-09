import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Interpretator interpretator = new Interpretator();
        FileReaderModule fileReaderModule = new FileReaderModule("src/main/resources/data.txt");

        try {
            List<String> stringList = fileReaderModule.readMessage();

            for (String message : stringList) {
                try {
                    String scheme = interpretator.interpretateMessage(message);
                    System.out.println(scheme);
                } catch (RuntimeException runtimeException) {
                    System.out.println(runtimeException.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


