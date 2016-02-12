package ru.taximaxim.codekeeper.apgdiff.licensing;

public class LicenseException extends Exception {

    private static final long serialVersionUID = 1068980074795464668L;

    public LicenseException() {
    }

    public LicenseException(String message) {
        super(message);
    }

    public LicenseException(Throwable cause) {
        super(cause);
    }

    public LicenseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LicenseException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
