package cz.startnet.utils.pgdiff.parsers.antlr.exception;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class ObjectCreationException extends RuntimeException {

    private static final String WITHOUT_PARENT = "{0} {1} is already exists"; //$NON-NLS-1$
    private static final String WITH_PARENT = "{0} {1} for {2} {3} is already exists"; //$NON-NLS-1$

    private static final long serialVersionUID = 5311778753075252457L;

    public ObjectCreationException() {
        super();
    }

    public ObjectCreationException(String message) {
        super(message);
    }

    public ObjectCreationException(Throwable cause) {
        super(cause);
    }

    public ObjectCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectCreationException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ObjectCreationException(PgStatement st) {
        super(MessageFormat.format(WITHOUT_PARENT, st.getStatementType(), st.getName()));
    }

    public ObjectCreationException(PgStatement st, PgStatement parent) {
        super(MessageFormat.format(WITH_PARENT, st.getStatementType(), st.getName(),
                parent.getStatementType(), parent.getName()));
    }
}
