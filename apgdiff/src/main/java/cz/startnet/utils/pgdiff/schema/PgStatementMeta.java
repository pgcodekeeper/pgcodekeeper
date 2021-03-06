package cz.startnet.utils.pgdiff.schema;

public class PgStatementMeta {
    private PgObjLocation location;
    private String author;
    private boolean isLib;

    public PgObjLocation getLocation() {
        return location;
    }

    public void setLocation(PgObjLocation location) {
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