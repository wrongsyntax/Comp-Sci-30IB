public class Person {

    // instance variables
    private String name;
    private int age;
    private int weight;
    private int height;

    // constructor (name must match the class name)
    public Person (String initialName){
        this.age = 0;
        this.name = initialName;
        this.weight = 0;
        this.height = 0;
    }

    // getter (return information from the object to the method that called it)
    public int getAge(){
        return this.age;
    }

    // getter
    public String getName(){
        return this.name;
    }

    // setter (passes information from the program into the object)
    public void setHeight (int newHeight){
        this.height = newHeight;
    }

    // setter
    public void setWeight (int newWeight){
        this.weight = newWeight;
    }

    public double bodyMassIndex(){
        double heightDividedByHundred = this.height / 100.0;
        return this.weight / (heightDividedByHundred * heightDividedByHundred);
    }


}