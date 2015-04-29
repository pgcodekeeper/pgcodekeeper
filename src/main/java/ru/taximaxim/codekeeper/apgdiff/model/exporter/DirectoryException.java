package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;

/**
 * Exception while working with directory.
 * 
 * @author Alexander Levsha
 */
public class DirectoryException extends IOException {
    
    private static final long serialVersionUID = -8464490751188704816L;

    public DirectoryException() {
    }

    public DirectoryException(String message) {
        super(message);
    }

    public DirectoryException(Throwable cause) {
        super(cause);
    }

    public DirectoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
