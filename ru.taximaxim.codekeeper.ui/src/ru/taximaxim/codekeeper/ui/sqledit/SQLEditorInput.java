package ru.taximaxim.codekeeper.ui.sqledit;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;

public class SQLEditorInput extends PlatformObject implements IURIEditorInput, IPersistableElement {

    private final Path path;
    private final boolean isMsSql;
    private final boolean isTemp;
    private final boolean isReadOnly;
    private final String project;

    public SQLEditorInput(Path path, boolean isMsSql, boolean isReadOnly) {
        this(path, null, isMsSql, isReadOnly);
    }

    public SQLEditorInput(Path path, String project, boolean isMsSql, boolean isReadOnly) {
        this(path, project, isMsSql, isReadOnly, false);
    }

    public SQLEditorInput(Path path, String project, boolean isMsSql, boolean isReadOnly, boolean isTemp) {
        this.path = path;
        this.project = project;
        this.isMsSql = isMsSql;
        this.isReadOnly = isReadOnly;
        this.isTemp = isTemp;
    }

    @Override
    public boolean exists() {
        return Files.exists(path);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(getName());
    }

    @Override
    public String getName() {
        return path.getFileName().toString();
    }

    @Override
    public IPersistableElement getPersistable() {
        return this;
    }

    @Override
    public String getToolTipText() {
        return path.toString();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof SQLEditorInput) {
            SQLEditorInput input = (SQLEditorInput) o;
            return Objects.equals(path, input.path)
                    && Objects.equals(project, input.project)
                    && isMsSql == input.isMsSql
                    && isTemp == input.isTemp
                    && isReadOnly == input.isReadOnly;
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
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + (isMsSql ? itrue : ifalse);
        result = prime * result + (isTemp ? itrue : ifalse);
        result = prime * result + (isReadOnly ? itrue : ifalse);
        return result;
    }

    @Override
    public URI getURI() {
        if (isTemp) {
            try {
                return new URI(EFS.SCHEME_NULL, null, path.toString(), null);
            } catch (URISyntaxException e) {
                //should never happen
                return null;
            }
        }

        return path.toUri();
    }

    @Override
    public String getFactoryId() {
        return SQLEditorInputFactory.ID;
    }

    @Override
    public void saveState(IMemento memento) {
        SQLEditorInputFactory.saveState(memento, this);
    }

    public Path getPath() {
        return path;
    }

    public boolean isMsSql() {
        return isMsSql;
    }

    public boolean isTemp() {
        return isTemp;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public String getProject() {
        return project;
    }
}
