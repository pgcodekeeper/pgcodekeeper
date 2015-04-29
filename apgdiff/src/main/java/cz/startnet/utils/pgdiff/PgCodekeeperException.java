package cz.startnet.utils.pgdiff;

public class PgCodekeeperException extends Exception {

    private static final long serialVersionUID = -6736140566263584623L;
    
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
