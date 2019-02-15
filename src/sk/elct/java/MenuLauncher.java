package sk.elct.java;

import java.util.Scanner;

public class MenuLauncher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aka je kapacita parkoviska? (Ak 0, tak sa pouzije aktualny subor)");
        int capacity = sc.nextInt();
        CarPark carPark;
        if (capacity == 0) {
            carPark = new CarPark();
        } else {
            carPark = new CarPark(capacity);
        }
        int selection = 0;
        while (selection != 9) {
            System.out.println("****************");
            System.out.println("Stlac 1-checkIn, 2-checkOut, 3-obsadenost, 4-vypis vsetko, 5-vypis podla ECV, 9-exit");
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
                    double price = 0;
                    try {
                        price = carPark.checkOut(sc.next());
                        System.out.println("Zaplat " + price + "€");
                    } catch (CarIdNotExistException e) {
                        System.err.println("Zle cislo auta " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(carPark.getNumberOfCars()
                            + "/" + carPark.getCapacity());
                    break;
                case 4:
                    System.out.println(carPark.getAllCarsSortedByTime());
                    break;
                case 5:
                    System.out.println(carPark.getAllCarsSortedById());
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
