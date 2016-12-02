package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.PlatformUI;

public class StringEditorInput implements IStorageEditorInput {

    private final String name;
    private final StringStorage storage;

    public StringEditorInput(String str, String name) {
        this.name = name;
        this.storage = new StringStorage(str, name);
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor("<internal>.sql"); //$NON-NLS-1$
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return name;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public IStorage getStorage() {
        return storage;
    }
}
