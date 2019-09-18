import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car carOne = new Car(
                "BMW",
                "X3",
                2013,
                58769,
                "blue",
                15590
        );
        Car carTwo = new Car(
                "Honda",
                "Civic",
                2009,
                98047,
                "white",
                9590
        );
        Car carThree = new Car(
                "Toyota",
                "Corolla",
                2004,
                103578,
                "black",
                3498
        );
        Car carFour = new Car(
                "Kia",
                "Sorento",
                2007,
                87908,
                "silver",
                7631
        );
        Car carFive = new Car(
                "Honda",
                "Accord",
                2013,
                56347,
                "black",
                13485
        );
        Car carSix = new Car(
                "Mercedes",
                "GLC",
                2010,
                48781,
                "white",
                18970
        );

        String[] all = carFour.getAll();
        System.out.println(Arrays.toString(all));
    }
}
