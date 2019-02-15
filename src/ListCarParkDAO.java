import java.util.ArrayList;
import java.util.List;

public class ListCarParkDAO implements CarParkDAO {

    /**
     * Celkova kapacita parkoviska.
     * Spolu aj volne aj obsadene miesta.
     */
    private final int capacity;

    /**
     * Zoznam aut, ktore tam aktualne parkuju.
     */
    private List<Car> actualCars;

    private final long openingTime;

    public ListCarParkDAO(int capacity) {
        this.capacity = capacity;
        this.actualCars = new ArrayList<>();
        openingTime = TimeUtils.currentTime();
    }

    @Override
    public void delete(Car car) {
        actualCars.remove(car);
    }

    @Override
    public Car getCarById(String carId) {
        for (Car car : actualCars) {
            if (carId.equals(car.getCarId())) {
                return car;
            }
        }
        // ak som zadane cislo nenasiel nikde v zozname
        return null;
    }

    @Override
    public boolean isFull() {
        return actualCars.size() >= capacity;
    }

    @Override
    public void add(Car car) {
       actualCars.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        // vytvorim novy zoznam, aby som nenarusil zapuzdrenost
        return new ArrayList<>(actualCars);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public long getOpeningTime() {
        return openingTime;
    }
}
