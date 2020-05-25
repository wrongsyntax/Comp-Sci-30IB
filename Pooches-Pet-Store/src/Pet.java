public class Pet {
    // Instance variables
    String name, eyeColour, location;
    float age, weight;

    // Constructor
    Pet(String name, String eyeColour, float age, float weight, String location) {
        this.name = name;
        this.eyeColour = eyeColour;
        this.age = age;
        this.weight = weight;
        this.location = location;
    }

    // Method to eat
    String eat(String foodType) {
        return String.format("%s just ate %s.", name, foodType);
    }

    // Method to sleep
    String sleep(float time) {
        return String.format("%s has just slept for %s hours.", name, time);
    }
}
