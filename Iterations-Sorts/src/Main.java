import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = {89, 2, 71, 37, 11, 59, 97, 83, 5, 47, 13, 67, 7, 19, 3, 17, 31, 43, 29, 41, 23, 53, 61, 73, 79};
        int[] sortedArray = {89, 2, 71, 37, 11, 59, 97, 83, 5, 47, 13, 67, 7, 19, 3, 17, 31, 43, 29, 41, 23, 53, 61, 73, 79};
        Arrays.sort(sortedArray);
        Sorts sorter = new Sorts(arrayToSort, sortedArray);
        Scanner input = new Scanner(System.in);
        int sortMethod = 0;

        System.out.println("This is the unsorted array: \n" + Arrays.toString(arrayToSort));
        System.out.println("Please enter what sort method you would like to use: ");
        System.out.println("(1) Bubble sort \n(2) Selection sort");
        try {
            sortMethod = input.nextInt();
        } catch (Exception e) {
            System.out.println("Non-integer value as input.");
        }

        if (sortMethod == 1) {
            sorter.doBubbleSort();
        } else if (sortMethod == 2) {
            sorter.doSelectionSort();
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
