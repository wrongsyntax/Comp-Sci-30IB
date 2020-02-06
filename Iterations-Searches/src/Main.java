import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instance variables
        Searches searcher = new Searches();
        int[] array = {15, 12, 39, 29, 89, 91, 44, 16, 97, 18, 93, 10, 52, 23, 74, 83, 77, 6, 26, 25, 36, 4, 19, 41};
        System.out.println("Here is the array of numbers: " + Arrays.toString(array));

        System.out.println("Enter the number you would like to search for: ");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        System.out.println("Enter the search method you would like to use: ");
        System.out.println("(1) Linear search \n(2) Binary Search");
        int type = scanner.nextInt();
        while (!(type == 1 || type == 2)) {
            System.out.println("Please enter a valid method");
            type = scanner.nextInt();
        }

        if (type == 1) {
            // Do a linear search
            System.out.println(searcher.doLinearSearch(array, target));
        } else {
            // Do a binary search
            array = searcher.doInsertionSort(array);
            System.out.println("The array has been sorted so the binary search works properly: ");
            System.out.println(Arrays.toString(array));
            System.out.println(searcher.doBinarySearch(array, target));
        }
    }
}
