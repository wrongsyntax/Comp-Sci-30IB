import java.util.Arrays;

public class Searches {
    // Instance variables
    int index;

    // Constructor
    Searches() {}

    // Linear search
    int doLinearSearch(int[] arrayToSearch, int target) {
        for (int i = 0; i < arrayToSearch.length; i ++) {
            System.out.println("Searching index " + i + "...");
            if (arrayToSearch[i] == target) {
                index = i;
                System.out.println("Target found at index " + i + "!");
                break;
            }
            System.out.println("Target not found. Moving on...");
        }

        return index;
    }

    // Binary search
    int doBinarySearch(int[] arrayToSearch, int target) {
        int low = 0;
        int high = arrayToSearch.length - 1;

        while (high >= low) {
            int newLength = high - low;
            int[] arrayTemp = new int[newLength + 1];
            int tempIndex = 0;
            for (int i = low; i <= high; i++) {
                arrayTemp[tempIndex] = arrayToSearch[i];
                tempIndex++;
            }
            System.out.println("The array has been split in half. Here is the portion being searched: ");
            System.out.println(Arrays.toString(arrayTemp));

            int mid = (low + high) / 2;
            if (arrayToSearch[mid] == target) {
                index = mid;
                break;
            } else if (arrayToSearch[mid] < target) {
                low = mid + 1;
            } else if (arrayToSearch[mid] > target) {
                high = mid - 1;
            }
        }

        return index;
    }

    // Insertion sort method
    int[] doInsertionSort(int[] arrayToSort) {
        for (int l = 1; l < arrayToSort.length; l++) {
            int temp = arrayToSort[l];
            int m = l - 1;
            while ((m >= 0) && (arrayToSort[m] > temp)) {
                arrayToSort[m+1] = arrayToSort[m];
                m--;
            }
            arrayToSort[m+1] = temp;
        }
        return arrayToSort;
    }
}
