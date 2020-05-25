public class Bird extends Pet {
    // Instance variables
    String featherColour, beakType;
    float wingSpan;

    Bird(String name, String eyeColour, float age, float weight, String location, String featherColour, String beakType, float wingSpan) {
        super(name, eyeColour, age, weight, location);
        this.featherColour = featherColour;
        this.beakType = beakType;
        this.wingSpan = wingSpan;
    }

    String squawk() {
        return String.format("%s just squawked.", name);
    }

    String fly() {
        return String.format("%s is now flying.", name);
    }
}
