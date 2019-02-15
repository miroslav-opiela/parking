package sk.elct.java;

public class TimeUtils {

    /**
     * Spocita ubehnuty cas od openingTime po aktualny moment.
     *
     * @param openingTime v milisekundach
     * @return cas v minutach
     */
    public static int getElapsedTime(long openingTime) {
        long currentTime = currentTime();
        return (int) (currentTime - openingTime) / (1000 * 60);
    }

    /**
     * Aktualny cas v milisekundach
     */
    public static long currentTime() {
        return System.currentTimeMillis();
    }

}
