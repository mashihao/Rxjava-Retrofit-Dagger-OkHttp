package id.co.picklon.model.rest.utils;

public class ErrorResponseException extends RuntimeException {
    public ErrorResponseException() {
        super();
    }

    ErrorResponseException(String detailMessage) {
        super(detailMessage);
    }
}
