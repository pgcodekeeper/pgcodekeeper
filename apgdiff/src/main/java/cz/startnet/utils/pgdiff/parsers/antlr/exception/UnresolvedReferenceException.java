package cz.startnet.utils.pgdiff.parsers.antlr.exception;

import org.antlr.v4.runtime.Token;

public class UnresolvedReferenceException extends RuntimeException {

    private static final long serialVersionUID = 9062166166340935325L;

    private Token errorToken;

    public UnresolvedReferenceException(Token errorToken) {
        super();
        this.errorToken = errorToken;
    }

    public UnresolvedReferenceException(String message, Token errorToken) {
        super(message);
        this.errorToken = errorToken;
    }

    public UnresolvedReferenceException(Throwable cause, Token errorToken) {
        super(cause);
        this.errorToken = errorToken;
    }

    public UnresolvedReferenceException(String message, Throwable cause, Token errorToken) {
        super(message, cause);
        this.errorToken = errorToken;
    }

    public UnresolvedReferenceException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace, Token errorToken) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorToken = errorToken;
    }

    public Token getErrorToken() {
        return errorToken;
    }

    public void setErrorToken(Token errorToken) {
        this.errorToken = errorToken;
    }
}
