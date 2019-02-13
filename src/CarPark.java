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
     * Udalost ked odide auto. Zaplati a je vyskrtnuty zo zoznamu.
     *
     * @param carId ecv auta.
     * @return vrati to sumu na zaplatenie.
     */
    public double checkOut(String carId) {
        long currentTime = System.currentTimeMillis();
        Car outcomingCar = getByCarId(carId);
        // vypocet ceny
        double price = outcomingCar.calculatePrice();
        // vyskrtnut zo zoznamu
        deleteCar(outcomingCar);
        return price;
    }

    /**
     * Odstrani auto zo zoznamu.
     *
     * @param car auto na odstranienie.
     */
    public void deleteCar(Car car) {

    }

    /**
     * V zozname najde a vrati referenciu na auto podla zadanej ECV.
     *
     * @param carId ecv auta.
     * @return referencia na auto.
     */
    public Car getByCarId(String carId) {
        for (Car car: actualCars) {
            if (carId.equals(car.getCarId())) {
                return car;
            }
        }
        // ak som zadane cislo nenasiel nikde v zozname
        return null;
    }

    /**
     * Vypocita kolko casu preslo od otvorenia parkoviska.
     *
     * @return cas v minutach.
     */
    private int getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        return (int) (currentTime - openingTime) / (1000 * 60);
    }
}
