package cz.startnet.utils.pgdiff.parsers.antlr.exception;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.schema.PgOverride;

public class LibraryObjectDuplicationException extends RuntimeException {

    private static final String ENTRY = "{0} {1} in {2} conflicts with object in {3}"; //$NON-NLS-1$

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

    public LibraryObjectDuplicationException(Collection<PgOverride> overrides) {
        super("Library conflicts:\n" + overrides.stream() //$NON-NLS-1$
        .map(o -> MessageFormat.format(ENTRY, o.getType(), o.getName(), o.getOldLocation(), o.getNewLocation()))
        .collect(Collectors.joining("\n"))); //$NON-NLS-1$
    }
}