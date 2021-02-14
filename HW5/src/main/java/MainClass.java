import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        String[] header = {"First", "Second", "Third"};
        int[][] data = {{1, 2, 3}, {4, 5, 6}};
        AppData appData = new AppData(header, data);
        appData.saveHeader();
        appData.showDataOfFile();
    }
}
