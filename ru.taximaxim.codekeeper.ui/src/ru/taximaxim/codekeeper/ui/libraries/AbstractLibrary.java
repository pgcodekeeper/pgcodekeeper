package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.swt.graphics.Image;

public abstract class AbstractLibrary {

    protected final AbstractLibrary parent;
    protected final Path path;
    protected final String name;
    protected final boolean isMsSql;
    protected final List<AbstractLibrary> children = new ArrayList<>();

    AbstractLibrary(AbstractLibrary parent, Path path) {
        this(parent, path, path.getFileName().toString(), parent.isMsSql());
    }

    AbstractLibrary(AbstractLibrary parent, Path path, String name, boolean isMsSql) {
        this.parent = parent;
        this.path = path;
        this.name = name;
        this.isMsSql = isMsSql;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    private void addChild(AbstractLibrary child) {
        children.add(child);
    }

    public AbstractLibrary getParent() {
        return parent;
    }

    public List<AbstractLibrary> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public boolean isMsSql() {
        return isMsSql;
    }

    public abstract String getLabel();

    public abstract Image getImage();

    @Override
    public String toString() {
        return getLabel();
    }

    public Path getPath() {
        return path;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof AbstractLibrary) {
            AbstractLibrary lib = (AbstractLibrary) obj;
            return Objects.equals(path, lib.path)
                    && Objects.equals(parent, lib.parent)
                    && isMsSql == lib.isMsSql;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        result = prime * result + (isMsSql ? itrue : ifalse);
        return result;
    }
}
