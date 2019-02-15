package sk.elct.java;

import java.util.Objects;

/**
 * Reprezentuje jedno zaparkovanie auta na parkovisku.
 */
public class Car implements Comparable<Car>{

    /**
     * ECV auta.
     */
    private String carId;

    /**
     * Cas prichodu auta. Cas v minutach od nejakeho momentu,
     * napr. otvorenia parkoviska.
     */
    private int timeIn;

    /**
     * Ci vlastni mestsku kartu na zlavu.
     */
    private boolean hasCard;

    /**
     * Cena za hodinu v eurach.
     */
    public static final double PRICE_FOR_HOUR = 10;

    /**
     * Zlava pre drzitela karty.
     */
    public static final double CARD_DISCOUNT = 0.5;

    /**
     * Konstruktor ktory nastavi premenne podla zadanych hodnot.
     *
     * @param carId   ecv auta.
     * @param timeIn  cas prichodu.
     * @param hasCard ci ma karticku.
     */
    public Car(String carId, int timeIn, boolean hasCard) {
        this.carId = carId;
        this.timeIn = timeIn;
        this.hasCard = hasCard;
    }

    public String getCarId() {
        return carId;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public boolean isHasCard() {
        return hasCard;
    }


    /**
     * @param leavingTime cas v minutach
     * @return
     */
    public double calculatePrice(int leavingTime) {
        int totalTime = leavingTime - timeIn;

        // ak totalTime / 60 tak uctujem za kazdu zacatu hodinu, lebo celociselne delenie
        // ak totalTime / 60.0 tak alikvotnu ciastku
        double price = (totalTime / 60.0) * PRICE_FOR_HOUR;
        if (hasCard) {
            price = CARD_DISCOUNT * price;
        }
        // zaokruhlime na 2 desatinne miesta
        price = Math.round(price * 100) / 100.0;
        return price;
    }

    @Override
    public String toString() {
        return "sk.elct.java.Car{" +
                "carId='" + carId + '\'' +
                ", timeIn=" + timeIn +
                ", hasCard=" + hasCard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return timeIn == car.timeIn &&
                hasCard == car.hasCard &&
                Objects.equals(carId, car.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, timeIn, hasCard);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.timeIn, o.timeIn);
    }
}
