public class Launcher {

    public static void main(String[] args) {
        String s = new String("abc");
        String t = "efg";

        System.out.println(s);

        Car blueCar = new Car();
        System.out.println(blueCar);
        blueCar.setCarId("KE123BA");
        blueCar.setTimeIn(280);
        blueCar.setHasCard(true);

        Car redCar = new Car("PO111FO", 350, false);

        String carId = blueCar.getCarId();




        CarPark parkovisko = new CarPark(110);

        // toto mi vypise 0
        System.out.println(parkovisko.getNumberOfCars());

        // prislo auto, chlapik to zaregistruje
        parkovisko.checkIn("BJ052AA", false);

        // toto mi vypise 1
        System.out.println(parkovisko.getNumberOfCars());


    }

}
