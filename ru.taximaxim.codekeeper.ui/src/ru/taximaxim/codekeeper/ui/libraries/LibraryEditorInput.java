package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PlatformUI;

public class LibraryEditorInput implements IStorageEditorInput, IPersistableElement {

    private final FileLibrary lib;

    public LibraryEditorInput(FileLibrary lib) {
        this.lib = lib;
    }

    @Override
    public boolean exists() {
        return lib.exists();
    }

    public boolean isMsSql() {
        return lib.isMsSql();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
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
        return this;
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

    @Override
    public void saveState(IMemento memento) {
        LibraryEditorInputFactory.saveState(memento, this);
    }

    @Override
    public String getFactoryId() {
        return LibraryEditorInputFactory.getFactoryId();
    }
}
