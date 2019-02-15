import java.util.Scanner;

public class MenuLauncher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aka je kapacita parkoviska?");
        int capacity = sc.nextInt();
        CarPark carPark = new CarPark(capacity);
        int selection = 0;
        while (selection != 9) {
            System.out.println("****************");
            System.out.println("Stlac 1-checkIn, 2-checkOut, 3-obsadenost, 9-exit");
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Zadaj ECV");
                    String carId = sc.next();

                    System.out.println("Ma karticku? Y/N");
                    String choice = sc.next().toLowerCase();
                    boolean hasCard = choice.equals("y")
                            || choice.equals("yes")
                            || choice.equals("1");

                    Car car = carPark.checkIn(carId, hasCard);
                    System.out.println("Zaparkoval som auto: " + car);
                    break;
                case 2:
                    System.out.println("Zadaj ECV");
                    double price = carPark.checkOut(sc.next());
                    System.out.println("Zaplat " + price + "€");
                    break;
                case 3:
                    System.out.println(carPark.getNumberOfCars()
                            + "/" + carPark.getCapacity());
                    break;
                case 9:
                    System.out.println("Koniec");
                    break;
                default:
                    break;
            }
        }
    }
}
