import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = {89, 2, 71, 37, 11, 59, 97, 83, 5, 47, 13, 67, 7, 19, 3, 17, 31, 43, 29, 41, 23, 53, 61, 73, 79};
        int[] sortedArray = {89, 2, 71, 37, 11, 59, 97, 83, 5, 47, 13, 67, 7, 19, 3, 17, 31, 43, 29, 41, 23, 53, 61, 73, 79};
        Arrays.sort(sortedArray);
        Sorts sorter = new Sorts(arrayToSort, sortedArray);

        // sorter.doBubbleSort();
        sorter.doSelectionSort();
    }
}
