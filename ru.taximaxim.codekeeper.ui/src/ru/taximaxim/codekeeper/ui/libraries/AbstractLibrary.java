package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.swt.graphics.Image;

public abstract class AbstractLibrary {

    protected static final String CONCAT_STRING = " - ";  //$NON-NLS-1$

    protected boolean isMsSql;
    protected String project;

    protected final AbstractLibrary parent;
    protected final Path path;
    protected final String name;
    protected final List<AbstractLibrary> children = new ArrayList<>();

    AbstractLibrary(AbstractLibrary parent, Path path) {
        this(parent, path, path.getFileName().toString());
    }

    AbstractLibrary(AbstractLibrary parent, Path path, String name) {
        this.parent = parent;
        this.path = path;
        this.name = name;
        if (parent != null) {
            this.isMsSql = parent.isMsSql;
            this.project = parent.project;
            parent.addChild(this);
        }
    }

    private void addChild(AbstractLibrary child) {
        children.add(child);
    }

    public void setMsSql(boolean isMsSql) {
        this.isMsSql = isMsSql;
    }

    public boolean isMsSql() {
        return isMsSql;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
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

    public abstract Image getImage();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);

        if (parent instanceof RootLibrary) {
            sb.append(CONCAT_STRING).append(getLibPath());
        }

        return sb.toString();
    }

    public String getLibPath() {
        return path.toString();
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractLibrary) {
            AbstractLibrary lib = (AbstractLibrary) obj;
            return Objects.equals(path, lib.path)
                    && Objects.equals(name, lib.name)
                    && isMsSql == lib.isMsSql
                    && Objects.equals(project, lib.project);
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (isMsSql ? itrue : ifalse);
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }
}
