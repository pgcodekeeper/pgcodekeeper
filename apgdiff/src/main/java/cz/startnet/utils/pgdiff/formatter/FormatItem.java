package cz.startnet.utils.pgdiff.formatter;

public class FormatItem {

    private final int start;
    private final int length;
    private final String text;

    public FormatItem(int start, int length, String text) {
        this.start = start;
        this.length = length;
        this.text = text;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public String getText() {
        return text;
    }
}
