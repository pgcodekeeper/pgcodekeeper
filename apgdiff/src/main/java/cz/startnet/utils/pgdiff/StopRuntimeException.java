package cz.startnet.utils.pgdiff;

public class StopRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -7279259928676801778L;

    public StopRuntimeException() {
        super();
    }

    public StopRuntimeException(String message) {
        super(message);
    }

    public StopRuntimeException(Throwable cause) {
        super(cause);
    }

    public StopRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}