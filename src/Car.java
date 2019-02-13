/**
 * Reprezentuje jedno zaparkovanie auta na parkovisku.
 */
public class Car {

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
     * Konstruktor s default hodnotami.
     */
    public Car() {

    }

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

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }
}
