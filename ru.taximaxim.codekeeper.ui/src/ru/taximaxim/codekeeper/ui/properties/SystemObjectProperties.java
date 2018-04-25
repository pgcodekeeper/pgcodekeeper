package ru.taximaxim.codekeeper.ui.properties;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SystemObjectProperties extends PropertyPage {

    private IEclipsePreferences prefs;

    /**
     * Delimiter for spacing parts of the storages
     */
    private static final String DELIM = "///t"; //$NON-NLS-1$

    private StoragePrefListEditor editor;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        prefs = new ProjectScope(element.getAdapter(IProject.class))
                .getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite ancestor) {
        Composite parent = new Composite(ancestor, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        parent.setLayout(gridLayout);
        parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        editor = new StoragePrefListEditor(parent);

        String storage = prefs.get(PROJ_PREF.STORAGE_LIST, ""); //$NON-NLS-1$

        if (storage.isEmpty()) {
            editor.setInputList(new ArrayList<>());
        } else {
            editor.setInputList(new ArrayList<>(Arrays.asList(storage.split(DELIM))));
        }

        return parent;
    }

    @Override
    protected void performDefaults() {
        try {
            editor.setInputList(new ArrayList<String>());
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
        }
    }

    @Override
    public boolean performOk() {
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void fillPrefs() throws BackingStoreException {
        prefs.put(PROJ_PREF.STORAGE_LIST, String.join(DELIM, editor.getList()));
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}