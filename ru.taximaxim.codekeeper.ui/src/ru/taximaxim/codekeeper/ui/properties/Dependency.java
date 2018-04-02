package ru.taximaxim.codekeeper.ui.properties;

public class Dependency {
    private final String path;
    private final DepType type;
    private boolean isIgnorePriv;

    public Dependency(String path, DepType type) {
        this(path, type, true);
    }

    public Dependency(String path, DepType type, boolean hasPriv) {
        this.path = path;
        this.type = type;
        this.isIgnorePriv = hasPriv;
    }

    public String getPath() {
        return path;
    }

    public DepType getType() {
        return type;
    }

    public boolean isIgnorePriv() {
        return isIgnorePriv;
    }

    public void setIgnorePriv(boolean isIgnorePriv) {
        this.isIgnorePriv = isIgnorePriv;
    }

}