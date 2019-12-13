import java.util.Arrays;

public class Sorts {
    // Instance variables
    int[] array;
    int[] sortedArray;

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
    void doSelectionSort() {
        int iteration = 1;
        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int k = j + 1; k < array.length; k++) {
                if (array[k] < array[min]) {
                    min = k;
                }
            }
            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;

            System.out.println("Iteration " + iteration + ": " + Arrays.toString(array));
            iteration ++;
        }
    }

    // Insertion sort method
    void doInsertionSort() {
        int iteration = 1;
        for (int l = 1; l < array.length; l++) {
            int temp = array[l];
            int m = l - 1;
            while ((m >= 0) && (array[m] > temp)) {
                array[m+1] = array[m];
                m--;
            }
            array[m+1] = temp;

            System.out.println("Iteration " + iteration + ": " + Arrays.toString(array));
            iteration ++;
        }
    }
}
