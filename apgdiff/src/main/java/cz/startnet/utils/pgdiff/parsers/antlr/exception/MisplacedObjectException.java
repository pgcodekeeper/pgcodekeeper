package cz.startnet.utils.pgdiff.parsers.antlr.exception;

import org.antlr.v4.runtime.Token;

public class MisplacedObjectException extends UnresolvedReferenceException {

    /**
     * 
     */
    private static final long serialVersionUID = 3752729615239221299L;

    public MisplacedObjectException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace, Token errorToken) {
        super(message, cause, enableSuppression, writableStackTrace, errorToken);
    }

    public MisplacedObjectException(String format, Token errToken) {
        super(format, errToken);
    }

}
