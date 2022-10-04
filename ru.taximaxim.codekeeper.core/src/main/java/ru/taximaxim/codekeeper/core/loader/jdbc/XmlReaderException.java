package ru.taximaxim.codekeeper.core.loader.jdbc;

public class XmlReaderException extends Exception {

    private static final long serialVersionUID = 893099268209172548L;

    public XmlReaderException() {
    }

    public XmlReaderException(String message) {
        super(message);
    }

    public XmlReaderException(Throwable cause) {
        super(cause);
    }

    public XmlReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlReaderException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
