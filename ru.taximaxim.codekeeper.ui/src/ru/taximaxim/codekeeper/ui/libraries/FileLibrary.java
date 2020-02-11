package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;

public class FileLibrary extends AbstractLibrary implements IStorage {

    FileLibrary(AbstractLibrary parent, Path path) {
        super(parent, path);
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public String getLabel() {
        StringBuilder sb = new StringBuilder(name);

        if (getParent() instanceof LibraryContainer) {
            sb.append(" - ").append(path.getParent()); //$NON-NLS-1$
        }

        return sb.toString();
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
            Log.log(e);
            return null;
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
}
