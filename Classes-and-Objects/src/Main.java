public class Main {
    public static void main(String[] args) {
        // Instantiation of the objects
        Person bob = new Person("Bob");
        Person stephanie = new Person("Stephanie");

        int i = 0;
        while (i < 30) {
            bob.becomeOlder();
            i ++;
        }

        stephanie.becomeOlder();

        if (bob.isAdult()) {
            System.out.println(bob.getName() + " is an adult.");
            // bob.printPerson();
        } else {
            System.out.println(bob.getName() + " is an minor.");
            // bob.printPerson();
        }

        if (stephanie.isAdult()) {
            System.out.println(stephanie.getName() + " is an adult.");
            // stephanie.printPerson();
        } else {
            System.out.println(stephanie.getName() + " is an minor.");
            // stephanie.printPerson();
        }
    }
}