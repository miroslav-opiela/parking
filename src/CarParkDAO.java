import java.util.List;

public interface CarParkDAO {

    void delete(Car car);

    Car getCarById(String carId);

    boolean isFull();

    void add(Car car);

    List<Car> getAllCars();

    int getCapacity();

    long getOpeningTime();

}
