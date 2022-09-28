package ru.taximaxim.codekeeper.core.parsers.antlr.exception;

import org.antlr.v4.runtime.Token;

public class MisplacedObjectException extends UnresolvedReferenceException {

    private static final long serialVersionUID = -8377509522524043609L;

    public MisplacedObjectException(Token errorToken) {
        super(errorToken);
    }

    public MisplacedObjectException(Throwable cause, Token errorToken) {
        super(cause, errorToken);
    }

    public MisplacedObjectException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace, Token errorToken) {
        super(message, cause, enableSuppression, writableStackTrace, errorToken);
    }

    public MisplacedObjectException(String format, Token errToken) {
        super(format, errToken);
    }
}
