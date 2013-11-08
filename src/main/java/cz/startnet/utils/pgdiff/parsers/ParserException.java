/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

/**
 * Thrown if parsing problem occured.
 *
 * @author fordfrog
 */
@SuppressWarnings("serial")
public class ParserException extends RuntimeException {

    /**
     * Creates a new instance of {@code ParserException} without detail message.
     */
    public ParserException() {
    }

    /**
     * Constructs an instance of {@code ParserException} with the specified
     * detail message.
     *
     * @param msg the detail message
     */
    public ParserException(final String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of {@code ParserException} with the specified
     * detail message.
     *
     * @param msg   the detail message
     * @param cause cause of the exception
     */
    public ParserException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
