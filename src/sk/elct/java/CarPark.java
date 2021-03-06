package sk.elct.java;

import java.util.Collections;
import java.util.List;

/**
 * Trieda reprezentuje parkovisko.
 */
public class CarPark {

    /**
     * Data access object na manipulaciu s datami
     */
    private CarParkDAO carParkDAO;

    /**
     * V tomto pripade sa pouziju aktualne data.
     */
    public CarPark() {
        carParkDAO = new FileCarParkDAO();
    }

    /**
     * Vytvara sa nove parkovisko so zadanou kapacitou.
     *
     * @param capacity kapacita parkoviska.
     */
    public CarPark(int capacity) {
        carParkDAO = new FileCarParkDAO(capacity);
    }

    /**
     * Zisti celkovu kapacitu parkoviska.
     */
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
     * @throws CarIdNotExistException vynimka ak auto so zadanou ECV nie je v systeme.
     */
    public double checkOut(String carId) throws CarIdNotExistException {
        // aktualny cas v minutach
        int currentTime = TimeUtils.getElapsedTime(carParkDAO.getOpeningTime());
        Car outcomingCar = carParkDAO.getCarById(carId);
        // ak auto s takou ECV nie je v zozname
        if (outcomingCar == null) {
            throw new CarIdNotExistException(carId);
        }
        // vypocet ceny
        double price = outcomingCar.calculatePrice(currentTime);
        // vyskrtnut zo zoznamu
        carParkDAO.delete(outcomingCar);
        return price;
    }

    /**
     * Vrati zoznam aut zotriedenych podla casu prichodu.
     *
     * @return zoznam vsetkych aut.
     */
    public List<Car> getAllCarsSortedByTime() {
        // auta su triedene podla casu
        List<Car> allCars = carParkDAO.getAllCars();
        Collections.sort(allCars);
        return allCars;
    }


    /**
     * Vrati zoznam aut zotriedenych podla ECV.
     *
     * @return zoznam vsetkych aut.
     */
    public List<Car> getAllCarsSortedById() {
        List<Car> allCars = carParkDAO.getAllCars();
        Collections.sort(allCars, new SorterByCarId());
        return allCars;
    }


}
