package cz.startnet.utils.pgdiff;

public class NotAllowedObjectException extends RuntimeException {

    private static final long serialVersionUID = -7279259928676801778L;

    public NotAllowedObjectException() {
        super();
    }

    public NotAllowedObjectException(String message) {
        super(message);
    }

    public NotAllowedObjectException(Throwable cause) {
        super(cause);
    }

    public NotAllowedObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}