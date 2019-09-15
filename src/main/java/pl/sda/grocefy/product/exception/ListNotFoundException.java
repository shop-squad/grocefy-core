package pl.sda.grocefy.product.exception;

public class ListNotFoundException extends WebApplicationException {
    public ListNotFoundException(String message) {
        super(message);
    }
}
