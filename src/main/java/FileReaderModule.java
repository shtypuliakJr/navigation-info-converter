import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderModule {

    private final String path;

    public FileReaderModule(String path) {
        this.path = path;
    }

    public List<String> readMessage() throws IOException {
        List<String> stringList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.ready()) {
            stringList.add(reader.readLine());
        }
        return stringList;
    }
}
