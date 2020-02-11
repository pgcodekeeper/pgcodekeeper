package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Files;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PlatformUI;

public class LibraryEditorInput implements IStorageEditorInput {

    private final FileLibrary lib;

    public LibraryEditorInput(FileLibrary lib) {
        this.lib = lib;
    }

    @Override
    public boolean exists() {
        return Files.exists(lib.getPath());
    }

    public boolean isMsSql() {
        return lib.isMsSql();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        IEditorRegistry registry= PlatformUI.getWorkbench().getEditorRegistry();
        return registry.getImageDescriptor(getContentType());
    }

    public String getContentType() {
        return lib.getFullPath().getFileExtension();
    }

    @Override
    public String getName() {
        return lib.getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return lib.getFullPath().toOSString();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public IStorage getStorage() {
        return lib;
    }

    public FileLibrary getLib() {
        return lib;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryEditorInput)) {
            return false;
        }
        LibraryEditorInput other = (LibraryEditorInput) obj;
        return lib.equals(other.lib);
    }

    @Override
    public int hashCode() {
        return lib.hashCode();
    }
}
