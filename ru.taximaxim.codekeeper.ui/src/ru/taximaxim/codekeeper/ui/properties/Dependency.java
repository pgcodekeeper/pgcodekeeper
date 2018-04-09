package ru.taximaxim.codekeeper.ui.properties;

public class Dependency {
    private final String path;
    private boolean isIgnorePriv;

    public Dependency(String path) {
        this(path, true);
    }

    public Dependency(String path, boolean hasPriv) {
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