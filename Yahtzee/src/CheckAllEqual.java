public class CheckAllEqual {
    // Instance variables
    private int[] arrayToCheck;

    // Constructor
    CheckAllEqual(int[] arrayToCheck) {
        this.arrayToCheck = arrayToCheck;
    }

    // Method to check if all values in the array are equal
    boolean check() {
        for (int value : arrayToCheck) {
            if (value != arrayToCheck[0]) {
                return false;
            }
        }
        return true;
    }
}
