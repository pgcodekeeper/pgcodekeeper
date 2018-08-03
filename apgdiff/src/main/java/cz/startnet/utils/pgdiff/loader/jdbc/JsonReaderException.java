package cz.startnet.utils.pgdiff.loader.jdbc;

public class JsonReaderException extends Exception {

    private static final long serialVersionUID = -3302955275651589283L;

    public JsonReaderException() {
    }

    public JsonReaderException(String message) {
        super(message);
    }

    public JsonReaderException(Throwable cause) {
        super(cause);
    }

    public JsonReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonReaderException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
