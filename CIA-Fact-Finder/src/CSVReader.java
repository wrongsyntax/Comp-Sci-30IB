import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    // Instance variables
    BufferedReader reader = new BufferedReader(new FileReader("ciaFactFinder.csv"));
    String line = "";
    String[][] fullList;

    // Constructor
    public CSVReader() throws FileNotFoundException {
    }

    // Method to parse the csv file and compile all the data into a 2D array
    void parseFile() throws IOException {
        int length = -1;
        while (line != null) {
            line = reader.readLine();
            length++;
        }
        fullList = new String[length][];
        reader = new BufferedReader(new FileReader("ciaFactFinder.csv"));
        line = "";
        line = reader.readLine();
        int i = 0;
        while (line != null) {
            String[] country = line.split(",");
            fullList[i] = country;
            i++;
            line = reader.readLine();
        }
        reader.close();
    }
}
