import java.io.*;
import java.nio.charset.StandardCharsets;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.data = data;
        this.header = header;
    }

    /*Запись в файл*/
    public void saveHeader() throws IOException {
        FileWriter fileWriter = new FileWriter("hw.csv");
        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < header.length; i++) {
                writer.write(header[i] + ";");
            }
            writer.write("\n");
            for (int t = 0; t < data.length; t++) {
                for (int j = 0; j < data.length + 1; j++) {
                    writer.write(data[t][j] + ";");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
    }

    /*Чтение из файла*/
    public void showDataOfFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("hw.csv"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*Метод для перезаписи всех данных
     *использовать его не стала, но он рабочий*/
    public void save(AppData appData) {
        byte[] z = ";".getBytes();
        byte[] n = "\n".getBytes();
        try (FileOutputStream out = new FileOutputStream("hw.csv")) {
            for (int t = 0; t < header.length; t++) {
                byte[] h = appData.header[t].getBytes();
                out.write(h);
                out.write(z);
            }
            out.write(n);
            for (int i = 0; i < appData.data.length; i++) {
                for (int j = 0; j < appData.data.length + 1; j++) {
                    byte[] d = (String.valueOf(appData.data[i][j])).getBytes();
                    out.write(d);
                    out.write(z);
                }
                out.write(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
