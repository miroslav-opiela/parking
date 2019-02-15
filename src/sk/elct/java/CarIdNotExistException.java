package sk.elct.java;

/**
 * Trieda reprezentujuca vynimku ak neexistuje zadane ECV na parkovisku.
 */
public class CarIdNotExistException extends RuntimeException {

    public CarIdNotExistException() {
    }

    public CarIdNotExistException(String message) {
        // vola sa konstruktor rodicovskej triedy RuntimeException
        super(message);
    }

    public CarIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarIdNotExistException(Throwable cause) {
        super(cause);
    }

    public CarIdNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
