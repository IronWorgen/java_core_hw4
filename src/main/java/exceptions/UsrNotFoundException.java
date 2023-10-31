package exceptions;

public class UsrNotFoundException extends RuntimeException {
    public UsrNotFoundException(String message) {
        super(message);
    }
}
