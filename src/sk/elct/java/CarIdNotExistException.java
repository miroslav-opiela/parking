package sk.elct.java;

public class CarIdNotExistException extends RuntimeException {

    public CarIdNotExistException() {
    }

    public CarIdNotExistException(String message) {
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
