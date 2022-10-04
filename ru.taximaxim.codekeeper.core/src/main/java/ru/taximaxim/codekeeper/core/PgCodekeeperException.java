package ru.taximaxim.codekeeper.core;

public class PgCodekeeperException extends Exception {

    private static final long serialVersionUID = 8958777207045999192L;

    public PgCodekeeperException() {
        super();
    }

    public PgCodekeeperException(String message) {
        super(message);
    }

    public PgCodekeeperException(Throwable cause) {
        super(cause);
    }

    public PgCodekeeperException(String message, Throwable cause) {
        super(message, cause);
    }
}
