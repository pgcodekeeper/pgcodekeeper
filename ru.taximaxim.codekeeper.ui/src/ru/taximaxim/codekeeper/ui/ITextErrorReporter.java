package ru.taximaxim.codekeeper.ui;

public interface ITextErrorReporter {
    /**
     * Set caret in editor to the error position.
     * @param start the offset of the error query
     * @param length the length of the query with error
     */
    void setErrorPosition(int start, int length);
}
