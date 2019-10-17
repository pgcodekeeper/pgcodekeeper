package cz.startnet.utils.pgdiff.formatter;

import org.antlr.v4.runtime.Token;

public class FormatItem {
    private final int start;
    private int lenght;
    private String text;

    public FormatItem(int start, int lenght, String text) {
        this.start = start;
        this.lenght = lenght;
        this.text = text;
    }

    public int getStart() {
        return start;
    }

    public void appendLenght(int lenght) {
        this.lenght += lenght;
    }

    public int getLenght() {
        return lenght;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void append(Token token) {
        lenght += token.getText().length();
    }

    public void moveEndToStop(int stop) {
        if (stop < start + lenght) {
            lenght = stop - start;
        }
    }
}
