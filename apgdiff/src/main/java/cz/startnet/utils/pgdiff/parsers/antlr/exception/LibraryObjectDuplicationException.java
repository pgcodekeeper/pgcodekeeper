package cz.startnet.utils.pgdiff.parsers.antlr.exception;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class LibraryObjectDuplicationException extends RuntimeException {

    private static final String MESSAGE = "{0} : Library error - duplicated object : {1} {2}"; //$NON-NLS-1$

    private static final long serialVersionUID = -809049036145802681L;

    public LibraryObjectDuplicationException() {
        super();
    }

    public LibraryObjectDuplicationException(String message) {
        super(message);
    }

    public LibraryObjectDuplicationException(Throwable cause) {
        super(cause);
    }

    public LibraryObjectDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryObjectDuplicationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LibraryObjectDuplicationException(PgStatement st) {
        super(MessageFormat.format(MESSAGE, st.getLocation(), st.getStatementType(), st.getName()));
    }
}
