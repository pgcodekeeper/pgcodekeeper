package cz.startnet.utils.pgdiff.formatter;

import java.util.Arrays;

public class FormatConfiguration {

    public enum IndentType {
        DISABLE, TAB, WHITESPACE
    }

    private boolean addWhitespaceBeforeOp;
    private boolean addWhitespaceAfterOp;
    private boolean removeTrailingWhitespace;

    private IndentType indentType = IndentType.DISABLE;
    private int indentSize;

    public void setAddWhitespaceBeforeOp(boolean addWhitespaceBeforeOp) {
        this.addWhitespaceBeforeOp = addWhitespaceBeforeOp;
    }

    public void setAddWhitespaceAfterOp(boolean addWhitespaceAfterOp) {
        this.addWhitespaceAfterOp = addWhitespaceAfterOp;
    }

    public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace) {
        this.removeTrailingWhitespace = removeTrailingWhitespace;
    }

    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
    }

    public boolean isAddWhitespaceAfterOp() {
        return addWhitespaceAfterOp;
    }

    public boolean isAddWhitespaceBeforeOp() {
        return addWhitespaceBeforeOp;
    }

    public boolean isRemoveTrailingWhitespace() {
        return removeTrailingWhitespace;
    }

    public int getIndentSize() {
        return indentSize;
    }

    public IndentType getIndentType() {
        return indentType;
    }

    public void setIndentType(IndentType indentType) {
        this.indentType = indentType;
    }

    public String createIndent(int length) {
        return createIndent(length, getIndentType() == IndentType.TAB ? '\t' : ' ');
    }

    public static String createIndent(int length, char indentChar) {
        if (length <= 0) {
            return "";
        }

        char [] chars  = new char[length];
        Arrays.fill(chars, indentChar);

        return new String(chars);
    }
}
