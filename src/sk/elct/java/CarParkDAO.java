package sk.elct.java;

import java.util.List;

/**
 * Interface popisujuci metody na manipulaciu s datami, bez ohladu na sposob ulozenia dat.
 */
public interface CarParkDAO {

    /**
     * Vymaze auto zo systemu.
     *
     * @param car auto na vymazanie.
     */
    void delete(Car car);

    /**
     * Vyhlada a vrati auto podla ECV.
     *
     * @param carId zadane ECV.
     * @return referencia na auto. Ak sa ECV nenachadza v systeme, vrati null.
     */
    Car getCarById(String carId);

    /**
     * Overi ci je parkovisko plne.
     *
     * @return true ak je pocet aut rovny kapacite parkoviska.
     */
    boolean isFull();

    /**
     * Prida auto do systemu.
     *
     * @param car pridavane auto.
     */
    void add(Car car);

    /**
     * Vrati zoznam vsetkych aut v systeme.
     *
     * @return list aut. Prazdny zoznam ak tam ziadne auto nie je.
     */
    List<Car> getAllCars();

    /**
     * Zisti celkovu kapacitu parkoviska.
     *
     * @return celkova kapacita.
     */
    int getCapacity();

    /***
     * Zisti cas otvorenia parkoviska.
     * @return referencny cas v milisekundach kedy sa otvorilo parkovisko.
     */
    long getOpeningTime();

}
