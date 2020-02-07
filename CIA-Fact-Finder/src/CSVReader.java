import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    // Instance variables
    BufferedReader reader = new BufferedReader(new FileReader("ciaFactFinder.csv"));
    String line = "";
    String[][] fullList = new String[26][];

    // Constructor
    public CSVReader() throws FileNotFoundException {
    }

    // Method to parse the csv file and compile all the data into a 2D array
    void parseFile() throws IOException {
        line = reader.readLine();
        int i = 0;
        while (line != null) {
            String[] country = line.split(",");
            fullList[i] = country;
            i++;
            line = reader.readLine();
        }
    }
}
