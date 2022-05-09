import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Interpretator interpretator = new Interpretator();
        FileReaderModule fileReaderModule = new FileReaderModule("src/main/resources/data.txt");
        try {
            List<String> stringList = fileReaderModule.readMessage();
            stringList.stream()
                    .map(interpretator::interpretateMessage)
                    .forEach(message -> {
                        System.out.println("-----------------------------------------------");
                        System.out.println(message);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


