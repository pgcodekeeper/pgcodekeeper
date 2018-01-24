package ru.taximaxim.codekeeper.apgdiff.model.difftree;

public class ElementMetaInfo {
    private String author;
    private boolean isChanged;

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setChanged() {
        isChanged = true;
    }

    public String getAuthorName() {
        return isChanged ?  "*" + author : author;
    }
}
