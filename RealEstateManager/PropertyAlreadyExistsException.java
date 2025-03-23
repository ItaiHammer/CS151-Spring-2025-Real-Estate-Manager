package RealEstateManager;

public class PropertyAlreadyExistsException extends Exception {
    public PropertyAlreadyExistsException(String message) {
        super(message);
    }
}
