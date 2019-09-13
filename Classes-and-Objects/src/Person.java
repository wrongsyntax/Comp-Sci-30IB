public class Person {
    // Instance variables (private)
    private String name;
    private int age;

    // Constructor (name must match the class name)
    public Person(String initialName) {
        this.age = 0;
        this.name = initialName;
    }

    /* public void printPerson() {
        System.out.println(this.name + ", age: " + this.age);
    } */

    public void becomeOlder() {
        this.age ++;
    }

    // Getter
    public int getAge() {
        return this.age;
    }

    // Getter
    public String getName() {
        return this.name;
    }

    public boolean isAdult() {
        if (this.age < 18) {
            return false;
        } else {
            return true;
        }
    }
}
