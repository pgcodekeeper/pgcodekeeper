package ru.taximaxim.codekeeper.core.parsers.antlr.exception;

public final class MonitorCancelledRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1305941709453867664L;

    public MonitorCancelledRuntimeException() {
        super();
    }

    public MonitorCancelledRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonitorCancelledRuntimeException(String message) {
        super(message);
    }

    public MonitorCancelledRuntimeException(Throwable cause) {
        super(cause);
    }
}