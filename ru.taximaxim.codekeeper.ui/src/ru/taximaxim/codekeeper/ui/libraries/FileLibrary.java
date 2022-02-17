package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public class FileLibrary extends AbstractLibrary implements IStorage {

    private final String project;
    private final boolean isMsSql;

    public FileLibrary(Path path, String project, boolean isMsSql) {
        this(null, path, project, isMsSql);
    }

    FileLibrary(AbstractLibrary parent, Path path, String project, boolean isMsSql) {
        super(parent, path);
        this.project = project;
        this.isMsSql = isMsSql;
    }

    public boolean isMsSql() {
        return isMsSql;
    }

    public String getProject() {
        return project;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Image getImage() {
        return Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE);
    }

    @Override
    public InputStream getContents() throws CoreException {
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, PLUGIN_ID.THIS, e.getLocalizedMessage(), e));
        }
    }

    @Override
    public IPath getFullPath() {
        return new org.eclipse.core.runtime.Path(path.toString()).makeAbsolute();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof FileLibrary && super.equals(obj)) {
            FileLibrary lib = (FileLibrary) obj;
            return isMsSql == lib.isMsSql
                    && Objects.equals(project, lib.project);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = super.hashCode();
        result = prime * result + (isMsSql ? itrue : ifalse);
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }
}
