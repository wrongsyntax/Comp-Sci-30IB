import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StoreInventory {
    public int[] storeItem = new int[200];
    public double[] itemPrice = new double[200];
    public int itemCount = 0;

    StoreInventory() {
    }

    public void loadItems() {
        try {
            String filename = "MasterStoreInv.txt";
            Scanner infile = new Scanner(new FileInputStream(filename));

            while (infile.hasNext()) {
                storeItem[itemCount] = infile.nextInt();
                itemPrice[itemCount] = infile.nextDouble();
                itemCount += 1;
            }

            infile.close();

        } catch (IOException ex) {
            itemCount = -1;
            ex.printStackTrace();
        }
    }

    public void removeZeros() {
        int zeroCount = 0;
        for (int value : storeItem) {
            if (value == 0) {
                zeroCount++;
            }
        }
        int[] newArray = new int[storeItem.length - zeroCount];
        int index = 0;
        for (int j = 0; j < newArray.length; j++) {
            if (storeItem[j] != 0) {
                newArray[index] = storeItem[j];
                index++;
            }
        }
        storeItem = newArray;

        zeroCount = 0;
        for (double value : itemPrice) {
            if (value == 0.0) {
                zeroCount++;
            }
        }
        double[] newArray1 = new double[itemPrice.length - zeroCount];
        index = 0;
        for (int j = 0; j < newArray.length; j++) {
            if (itemPrice[j] != 0.0) {
                newArray1[index] = itemPrice[j];
                index++;
            }
        }
        itemPrice = newArray1;
    }

    public double getItemPrice(int item) {
        return itemPrice[item];
    }

    public void bubbleSort() {
        for (int i = 0; i < storeItem.length; i++) {
            for (int x = 1; x < storeItem.length - i; x++) {
                if (storeItem[x - 1] > storeItem[x]) {
                    int temp = storeItem[x - 1];
                    double tempi = itemPrice[x - 1];
                    storeItem[x - 1] = storeItem[x];
                    itemPrice[x - 1] = itemPrice[x];
                    storeItem[x] = temp;
                    itemPrice[x] = tempi;
                }
            }
        }
    }

    public int binSearch(int target) {
        int low = 0;
        int high = itemCount - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (storeItem[mid] == target) {
                return mid;
            }
            if (storeItem[mid] < target) {
                low = mid + 1;
            }
            if (storeItem[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int seqSearch(int target) {
        int ind = 0;
        int found = -1;

        while (ind < itemCount) {
            if (target == storeItem[ind]) {
                found = ind;
                ind = itemCount;
            } else {
                ++ind;
            }
        }
        return found;
    }
}