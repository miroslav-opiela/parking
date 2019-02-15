public class TimeUtils {

    public static int getElapsedTime(long openingTime) {
        long currentTime = currentTime();
        return (int) (currentTime - openingTime) / (1000 * 60);
    }

    public static long currentTime() {
        return System.currentTimeMillis();
    }

}
