package sk.elct.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileCarParkDAO implements CarParkDAO {

    /**
     * Subor, kde su ulozene udaje.
     * Format suboru - kapacita, cas, zaznamy o autach - v riadkoch.
     * Auto je vo formate id;time;hasCard
     */
    public static final File FILE = new File("parking.txt");

    /**
     * Pouzijeme aktualny subor
     */
    public FileCarParkDAO() {
    }

    /**
     * Chceme vytvorit novy subor
     *
     * @param capacity
     */
    public FileCarParkDAO(int capacity) {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            pw.println(capacity);
            pw.println(TimeUtils.currentTime());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Car carToRemove) {
        // precitame zo suboru vsetky polozky
        int capacity = getCapacity();
        long time = getOpeningTime();
        List<Car> allCars = getAllCars();

        // v zozname vymazeme auto
        allCars.remove(carToRemove);

        // zapiseme aktualny stav do suboru
        try (PrintWriter pw = new PrintWriter(FILE)) {
            pw.println(capacity);
            pw.println(time);
            for (Car car : allCars) {
                pw.println(car.getCarId() + ";" +
                        car.getTimeIn() + ";" + car.isHasCard());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getCarById(String carId) {
        List<Car> allCars = getAllCars();
        for (Car car : allCars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean isFull() {
        return getAllCars().size() == getCapacity();
    }

    @Override
    public void add(Car car) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE, true))) {
            pw.println(car.getCarId() + ";" +
                    car.getTimeIn() + ";" + car.isHasCard());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Scanner sc = new Scanner(FILE)) {
            // kapacita
            sc.nextLine();
            // cas
            sc.nextLine();
            while (sc.hasNextLine()) {
                String carInFile = sc.nextLine();
                // riadok zo suboru sa prevedie na objekt triedy Car
                Car car = carFromString(carInFile);
                cars.add(car);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }

    /**
     * Zo stringu vyrobi novy objekt.
     *
     * @param s string v tvare ecv;cas;karta
     */
    private Car carFromString(String s) {
        Scanner sc = new Scanner(s);
        sc.useDelimiter(";");
        //ak by sme mali v subore desatinne cisla sc.useLocale(Locale.US);
        String carId = sc.next();
        int time = sc.nextInt();
        boolean card = sc.nextBoolean();
        return new Car(carId, time, card);
    }

    @Override
    public int getCapacity() {
        try (Scanner sc = new Scanner(FILE)) {
            return sc.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long getOpeningTime() {
        try (Scanner sc = new Scanner(FILE)) {
            sc.nextInt();
            return sc.nextLong();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
