package cz.startnet.utils.pgdiff.parsers.antlr.exception;

public final class MonitorCancelledRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 8530137642762407646L;

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