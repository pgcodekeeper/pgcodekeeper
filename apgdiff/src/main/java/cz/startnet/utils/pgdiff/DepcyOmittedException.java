package cz.startnet.utils.pgdiff;

public class DepcyOmittedException extends RuntimeException {

    private static final long serialVersionUID = -7279259928676801778L;

    public DepcyOmittedException() {
        super();
    }

    public DepcyOmittedException(String message) {
        super(message);
    }

    public DepcyOmittedException(Throwable cause) {
        super(cause);
    }

    public DepcyOmittedException(String message, Throwable cause) {
        super(message, cause);
    }
}