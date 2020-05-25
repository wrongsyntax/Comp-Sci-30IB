public class Fish extends Pet {
    // Instance variables
    boolean jawless, dorsalFin;
    String skeletonType, bodyType;

    Fish(String name, String eyeColour, float age, float weight, String location, boolean jawless, boolean dorsalFin, String skeletonType, String bodyType) {
        super(name, eyeColour, age, weight, location);
        this.jawless = jawless;
        this.dorsalFin = dorsalFin;
        this.skeletonType = skeletonType;
        this.bodyType = bodyType;
    }

    String swim(String direction) {
        return String.format("%s just swam %s.", name, direction);
    }

    String detectLight() {
        return String.format("%s just detected light.", name);
    }
}
