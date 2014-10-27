package ru.taximaxim.codekeeper.ui.properties;


import java.nio.charset.Charset;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectProperties extends PropertyPage implements
        IWorkbenchPropertyPage {

    private Combo cmbEncoding;
    private IEclipsePreferences prefs;
    
    public ProjectProperties() {
    }

    @Override
    protected Control createContents(Composite parent) {
        prefs = new ProjectScope((IProject) getElement().getAdapter(
                IResource.class)).getNode(UIConsts.PLUGIN_ID.THIS);
        Composite panel = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        panel.setLayout(layout);
        
        Label label = new Label(panel, SWT.NONE);
        label.setLayoutData(new GridData());
        label.setText(Messages.projectProperties_encoding_for_all_operation_with_project);
        cmbEncoding = new Combo(panel, SWT.BORDER | SWT.DROP_DOWN
                | SWT.READ_ONLY);
        cmbEncoding.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Set<String> charsets = Charset.availableCharsets().keySet();
        cmbEncoding.setItems(charsets.toArray(new String[charsets.size()]));
        cmbEncoding.select(cmbEncoding.indexOf(prefs.get(PROJ_PREF.ENCODING, "UTF-8")));
        
        return panel;
    }
    
    @Override
    protected void performDefaults() {
        cmbEncoding.select(cmbEncoding.indexOf("UTF-8")); //$NON-NLS-1$
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(Messages.projectProperties_error_occurs_while_saving_properties
                    + e.getLocalizedMessage());
            setValid(false);
        }
    }
    
    @Override
    public boolean performOk() {
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(Messages.projectProperties_error_occurs_while_saving_properties
                    + e.getLocalizedMessage());
            setValid(false);
            return false;
        }
        return true;
    }
    
    private void fillPrefs() throws BackingStoreException {
        prefs.put(PROJ_PREF.ENCODING, cmbEncoding.getText());
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
}
