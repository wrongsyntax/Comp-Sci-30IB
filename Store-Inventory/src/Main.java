import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        Scanner myScanner = new Scanner(System.in);
        int target, item;
        double itemPrice;


        inventory.loadItems();
        inventory.removeZeros();
        inventory.bubbleSort();

        do {
            System.out.println("Which item number do you want to see -->");
            target = myScanner.nextInt();
            /* Sequential Search */
            item = inventory.seqSearch(target);
            if (item >= 0) {
                itemPrice = inventory.getItemPrice(item);
                System.out.print("\nSequential search - Successful!\nID number: " + target + "  Price: $" + itemPrice+ "\n");
            }else {
                System.out.print("\nSequential search - Failed\nID number not found\n\n");
            }
            /* Binary Search */
            inventory.bubbleSort();
            item = inventory.binSearch(target);
            if (item >= 0) {
                itemPrice = inventory.getItemPrice(item);
                System.out.print("\nBinary search - Successful!\nID number: " + target + "  Price: $" + itemPrice+ "\n\n");
            }else {
                System.out.print("\nBinary search - Failed\nID number not found\n\n");
            }

            System.out.print("Enter '1' to make another search\nEnter '0' to quit -->");

        }while (myScanner.nextInt() >= 1);
        myScanner.close();


    }//END main

}
