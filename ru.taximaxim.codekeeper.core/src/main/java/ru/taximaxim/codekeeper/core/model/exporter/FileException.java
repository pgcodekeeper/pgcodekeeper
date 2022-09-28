package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;

public class FileException extends IOException {

    private static final long serialVersionUID = -1566472200889278474L;

    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
