public class Cat extends Pet {
    // Instance variables
    String furColour, whiskerColour, furLength;
    int toeNumber;

    Cat(String name, String eyeColour, float age, float weight, String location, String furColour, String whiskerColour, String furLength, int toeNumber) {
        super(name, eyeColour, age, weight, location);
        this.furColour = furColour;
        this.whiskerColour = whiskerColour;
        this.furColour = furColour;
        this.furLength = furLength;
        this.toeNumber = toeNumber;
    }

    String meow() {
        return String.format("%s just meowed.", name);
    }

    String purr(String soundLevel) {
        return String.format("%s just purred %sly.", name, soundLevel);
    }

    String groom() {
        return String.format("%s has been groomed.", name);
    }
}
