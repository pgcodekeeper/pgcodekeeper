package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

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

    FileLibrary(AbstractLibrary parent, Path path) {
        super(parent, path);
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
}
