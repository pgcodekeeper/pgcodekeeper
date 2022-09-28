package ru.taximaxim.codekeeper.core.parsers.antlr.exception;

public final class ConcurrentModificationException extends RuntimeException {

    private static final long serialVersionUID = -6952773835185629552L;

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