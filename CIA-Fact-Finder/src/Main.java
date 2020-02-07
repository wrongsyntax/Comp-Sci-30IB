import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();
        csvReader.parseFile();
        String[][] fullList = csvReader.fullList;
    }
}
