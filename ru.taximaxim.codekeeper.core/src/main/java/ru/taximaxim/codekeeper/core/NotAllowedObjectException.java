package ru.taximaxim.codekeeper.core;

public class NotAllowedObjectException extends RuntimeException {

    private static final long serialVersionUID = -283715845801619786L;

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