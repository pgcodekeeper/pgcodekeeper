package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Paths;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class LibraryEditorInputFactory implements IElementFactory {

    private static final String LIBRARY_EDITOR_FACTORY_ID = "ru.taximaxim.codekeeper.ui.libraries.LibraryEditorInputFactory"; //$NON-NLS-1$
    private static final String TAG_PROJECT = "project"; //$NON-NLS-1$
    private static final String TAG_PATH = "path"; //$NON-NLS-1$
    private static final String TAG_MS_SQL = "isMsSql"; //$NON-NLS-1$

    @Override
    public IAdaptable createElement(IMemento memento) {
        String projName = memento.getString(TAG_PROJECT);
        String path = memento.getString(TAG_PATH);
        Boolean isMsSql = memento.getBoolean(TAG_MS_SQL);
        if (projName == null || path == null || isMsSql == null) {
            return null;
        }

        FileLibrary lib = new FileLibrary(null, Paths.get(path));
        lib.setProject(projName);
        lib.setMsSql(isMsSql);

        return new LibraryEditorInput(lib);
    }

    /**
     * Returns the element factory id for this class.
     */
    static String getFactoryId() {
        return LIBRARY_EDITOR_FACTORY_ID;
    }

    static void saveState(IMemento memento, LibraryEditorInput input) {
        AbstractLibrary lib = input.getLib();
        memento.putString(TAG_PROJECT, lib.getProject());
        memento.putString(TAG_PATH, lib.getPath().toString());
        memento.putBoolean(TAG_MS_SQL, lib.isMsSql());
    }
}
