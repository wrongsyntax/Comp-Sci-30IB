import java.util.Arrays;

public class Sorts {
    // Instance variables
    int[] array = {};
    int[] sortedArray = {};

    // Constructor
    Sorts(int[] arrayToSort, int[] sortedArray) {
        array = arrayToSort;
        this.sortedArray = sortedArray;
    }

    // Bubble sort method
    void doBubbleSort() {
        System.out.println("Bubble sort: ");
        int y;
        int iteration = 1;
        while (!Arrays.equals(array, sortedArray)) {
            for (int x = 0; x < array.length; x++) {
                if (x != array.length - 1) {
                    y = x + 1;
                } else {
                    y = x;
                }

                if (array[x] > array[y]) {
                    int temp = array[x];
                    array[x] = array[y];
                    array[y] = temp;
                }
                System.out.println("Iteration " + iteration + ": " + Arrays.toString(array));
                iteration ++;
            }
        }
    }

    // Selection sort method
    void doSelectionSort() {}
}
