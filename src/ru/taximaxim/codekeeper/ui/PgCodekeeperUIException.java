package ru.taximaxim.codekeeper.ui;

public class PgCodekeeperUIException extends Exception {

    private static final long serialVersionUID = -1230666490485802474L;

    public PgCodekeeperUIException() {
        super();
    }

    public PgCodekeeperUIException(String message) {
        super(message);
    }

    public PgCodekeeperUIException(Throwable cause) {
        super(cause);
    }

    public PgCodekeeperUIException(String message, Throwable cause) {
        super(message, cause);
    }

    public PgCodekeeperUIException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
