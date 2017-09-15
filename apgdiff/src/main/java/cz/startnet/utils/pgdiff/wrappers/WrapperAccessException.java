package cz.startnet.utils.pgdiff.wrappers;

public class WrapperAccessException extends Exception {

    private static final long serialVersionUID = 8973611591544006974L;

    public WrapperAccessException() {
    }

    public WrapperAccessException(String message) {
        super(message);
    }

    public WrapperAccessException(Throwable cause) {
        super(cause);
    }

    public WrapperAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrapperAccessException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
