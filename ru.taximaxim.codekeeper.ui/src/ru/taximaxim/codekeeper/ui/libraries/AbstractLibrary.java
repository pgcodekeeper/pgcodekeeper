package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
}
