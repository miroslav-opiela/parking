import java.util.ArrayList;
import java.util.List;

public class CarPark {

    /**
     * Celkova kapacita parkoviska.
     * Spolu aj volne aj obsadene miesta.
     */
    private int capacity;

    /**
     * Zoznam aut, ktore tam aktualne parkuju.
     */
    private List<Car> actualCars;

    private long openingTime;

    public CarPark(int capacity) {
        this.openingTime = System.currentTimeMillis();
        this.capacity = capacity;
        this.actualCars = new ArrayList<>();
        System.out.println("vyrobil som parkovisko s poctom obsadenych miest "
                + this.actualCars.size() + " s celkovou kapacitou " + this.capacity);
    }

    /**
     * Vrati to pocet aut, ktore v dany moment parkuju na parkovisku.
     *
     * @return pocet aut.
     */
    public int getNumberOfCars() {
        return actualCars.size();
    }

    /**
     * Udalost ked pride nove auto. Zaeviduje sa do systemu.
     *
     * @param carId   ecv auta.
     * @param hasCard ci ma karticku.
     */
    public void checkIn(String carId, boolean hasCard) {
        int time = this.getCurrentTime();
        Car incomingCar = new Car(carId, time, hasCard);

        // prida objekt do listu
        this.actualCars.add(incomingCar);
    }

    /**
     * Vypocita kolko casu preslo od otvorenia parkoviska.
     * @return  cas v minutach.
     */
    private int getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        return (int)(currentTime - openingTime) / (1000 * 60);
    }
}
