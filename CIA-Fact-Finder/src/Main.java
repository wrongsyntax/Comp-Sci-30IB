import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instance variables
        CSVReader csvReader = new CSVReader();
        csvReader.parseFile();
        String[][] fullList = csvReader.fullList;
        Retriever infoRetriever = new Retriever(fullList);

        // Get user's input for country
        int countryIndex = infoRetriever.askForCountry();
        // System.out.println("User chose: " + fullList[countryIndex][0] + "\n");

        // Ask for the data the user wants to retrieve
        int dataIndex = infoRetriever.askForData();
        /*
        if (dataIndex != 5) {
            System.out.println("User asked for: " + fullList[0][dataIndex].replace("_", " ").toLowerCase());
        } else {
            System.out.println("User asked for: " + fullList[0][dataIndex].replace("_", " "));
        } */

        // Print out the result of the search
        if (dataIndex == 1) {
            System.out.println("The rank of " + fullList[countryIndex][0] + " is " + fullList[countryIndex][dataIndex]);
        } else if (dataIndex == 2) {
            System.out.println("The birth rate of " + fullList[countryIndex][0] + " is " + fullList[countryIndex][dataIndex]);
        } else if (dataIndex == 3) {
            System.out.println("The population of " + fullList[countryIndex][0] + " is " + fullList[countryIndex][dataIndex] + " million people");
        } else if (dataIndex == 4) {
            System.out.println("The unemployment rate of " + fullList[countryIndex][0] + " is " + fullList[countryIndex][dataIndex] + "%");
        } else if (dataIndex == 5) {
            System.out.println("The GDP of " + fullList[countryIndex][0] + " is $" + fullList[countryIndex][dataIndex] + " billion");
        }
    }
}
