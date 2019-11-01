public class Frame {
    // Instance variables
    private int pins;
    private int throwsLeft;

    // Constructor
    Frame() {
        pins = 10;
        throwsLeft = 2;
    }

    // Methods to return the values of a new frame
    int getPins() {
        return pins;
    }
    int getThrowsLeft() {
        return throwsLeft;
    }
}
