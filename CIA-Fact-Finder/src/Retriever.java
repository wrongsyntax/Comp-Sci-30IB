import java.util.Scanner;

public class Retriever {
    // Instance variables
    String[][] data;
    Scanner scanner = new Scanner(System.in);
    int countryIndex;
    int dataIndex;

    // Constructor
    public Retriever(String[][] fullList) {
        data = fullList;
    }

    // Method to ask for which country the user wants to search
    int askForCountry() {
        // Print out all the options the user can choose from
        for (int i = 1; i < data.length; i++) {
            if (i < 10) {
                System.out.println("(" + i + ")" + "  " + data[i][0].replace("_", " "));
            } else {
                System.out.println("(" + i + ")" + " " + data[i][0].replace("_", " "));
            }
        }

        System.out.println();
        System.out.println("Enter the number of one of the countries above: ");
        countryIndex = scanner.nextInt();

        return countryIndex;
    }

    int askForData() {
        for (int i = 1; i < data[0].length; i++) {
            System.out.println("(" + i + ")" + " " + data[0][i].replace("_", " "));
        }

        System.out.println();
        System.out.println("Choose the data you would like from the list above: ");
        dataIndex = scanner.nextInt();

        return dataIndex;
    }
}
