package cz.startnet.utils.pgdiff.schema;

public class PgStatementMeta {
    private PgObjLocation location;
    private String author;
    private String libName;

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
        return libName != null;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public void copy(PgStatementMeta meta) {
        this.location = meta.location;
        this.author = meta.author;
        this.libName = meta.libName;
    }
}