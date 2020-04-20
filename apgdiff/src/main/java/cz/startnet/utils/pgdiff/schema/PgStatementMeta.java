package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.ContextLocation;

public class PgStatementMeta {

    private ContextLocation location;
    private String author;
    private boolean isLib;

    public ContextLocation getLocation() {
        return location;
    }

    public void setLocation(ContextLocation location) {
        this.location = location;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isLib() {
        return isLib;
    }

    public void setLib(boolean isLib) {
        this.isLib = isLib;
    }

    public void copy(PgStatementMeta meta) {
        this.location = meta.location;
        this.author = meta.author;
        this.isLib = meta.isLib;
    }
}