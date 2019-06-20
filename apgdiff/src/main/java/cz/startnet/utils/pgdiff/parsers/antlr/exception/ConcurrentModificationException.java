package cz.startnet.utils.pgdiff.parsers.antlr.exception;

public final class ConcurrentModificationException extends RuntimeException {

    private static final long serialVersionUID = -3599345021862321386L;

    public ConcurrentModificationException() {
        super();
    }

    public ConcurrentModificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcurrentModificationException(String message) {
        super(message);
    }

    public ConcurrentModificationException(Throwable cause) {
        super(cause);
    }
}