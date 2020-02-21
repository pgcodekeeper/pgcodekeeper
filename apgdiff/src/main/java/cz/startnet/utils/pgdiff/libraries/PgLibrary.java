package cz.startnet.utils.pgdiff.libraries;

public class PgLibrary {

    private final String path;
    private boolean isIgnorePriv;
    private String owner;

    public PgLibrary(String path) {
        this(path, true, "");
    }

    public PgLibrary(String path, boolean hasPriv, String owner) {
        this.path = path;
        this.isIgnorePriv = hasPriv;
        this.owner = owner;
    }

    public String getPath() {
        return path;
    }

    public boolean isIgnorePriv() {
        return isIgnorePriv;
    }

    public void setIgnorePriv(boolean isIgnorePriv) {
        this.isIgnorePriv = isIgnorePriv;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? "" : owner;
    }
}