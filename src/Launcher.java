public class Launcher {

    public static void main(String[] args) {
        CarPark parkovisko = new CarPark(110);

        // toto mi vypise 0
        System.out.println(parkovisko.getNumberOfCars());

        // prislo auto, chlapik to zaregistruje
        parkovisko.checkIn("BJ052AA", false);

        // toto mi vypise 1
        System.out.println(parkovisko.getNumberOfCars());


    }

}
