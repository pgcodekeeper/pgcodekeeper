package ru.taximaxim.codekeeper.ui.properties;

public class PgLibrary {
    private final String path;
    private boolean isIgnorePriv;

    public PgLibrary(String path) {
        this(path, true);
    }

    public PgLibrary(String path, boolean hasPriv) {
        this.path = path;
        this.isIgnorePriv = hasPriv;
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

}