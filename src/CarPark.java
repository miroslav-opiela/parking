import java.util.ArrayList;
import java.util.List;

public class CarPark {

    /**
     * data access object na manipulaciu s datami
     */
    private CarParkDAO carParkDAO;

    public CarPark(int capacity) {
        carParkDAO = new ListCarParkDAO(capacity);
    }

    public int getCapacity() {
        return carParkDAO.getCapacity();
    }

    /**
     * Vrati to pocet aut, ktore v dany moment parkuju na parkovisku.
     *
     * @return pocet aut.
     */
    public int getNumberOfCars() {
        return carParkDAO.getAllCars().size();
    }

    /**
     * Udalost ked pride nove auto. Zaeviduje sa do systemu.
     *
     * @param carId   ecv auta.
     * @param hasCard ci ma karticku.
     * @return referencia na novovytvoreny objekt triedy Car. null ak je plne parkovisko
     */
    public Car checkIn(String carId, boolean hasCard) {
        int time = TimeUtils.getElapsedTime(carParkDAO.getOpeningTime());
        Car incomingCar = new Car(carId, time, hasCard);
        if (carParkDAO.isFull()) {
            // ak je plne parkovisko, nepridavam do zoznamu
            return null;
        }
        // prida objekt do listu
        carParkDAO.add(incomingCar);
        return incomingCar;
    }

    /**
     * Udalost ked odide auto. Zaplati a je vyskrtnuty zo zoznamu.
     *
     * @param carId ecv auta.
     * @return vrati to sumu na zaplatenie.
     */
    public double checkOut(String carId) {
        // aktualny cas v minutach
        int currentTime = TimeUtils.getElapsedTime(carParkDAO.getOpeningTime());
        Car outcomingCar = carParkDAO.getCarById(carId);
        // vypocet ceny
        double price = outcomingCar.calculatePrice(currentTime);
        // vyskrtnut zo zoznamu
        carParkDAO.delete(outcomingCar);
        return price;
    }


}
