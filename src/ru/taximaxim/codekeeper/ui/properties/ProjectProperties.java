package ru.taximaxim.codekeeper.ui.properties;


import java.nio.charset.Charset;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbPicker;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectProperties extends PropertyPage implements
        IWorkbenchPropertyPage {

    private Combo cmbEncoding;
    private Button dumpBtn;
    private Button dbBtn;
    private Button jdbcBtn;
    private DbPicker dbStorePicker;
    private Sources selectedSource;
    private IEclipsePreferences prefs;
    private ModifyListener modListener = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            isValid();
        }
    };
    
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
        
        Group sourceGroup = new Group(panel, SWT.NONE);
        layout = new GridLayout();
        layout.marginHeight = layout.marginWidth = 0;
        sourceGroup.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        sourceGroup.setLayoutData(gd);
        sourceGroup.setText(Messages.projectProperties_project_default_source);
        
        dumpBtn = new Button(sourceGroup, SWT.RADIO);
        dumpBtn.setLayoutData(new GridData());
        dumpBtn.setText(Messages.projectProperties_dump_file);
        dumpBtn.addSelectionListener(new SelectionListener());
        
        dbBtn = new Button(sourceGroup, SWT.RADIO);
        dbBtn.setLayoutData(new GridData());
        dbBtn.setText(Messages.projectProperties_db);
        dbBtn.addSelectionListener(new SelectionListener());
        
        jdbcBtn = new Button(sourceGroup, SWT.RADIO);
        jdbcBtn.setLayoutData(new GridData());
        jdbcBtn.setText(Messages.projectProperties_jdbc);
        jdbcBtn.addSelectionListener(new SelectionListener());
        
        dbStorePicker = new DbPicker(sourceGroup, SWT.FILL,
                Activator.getDefault().getPreferenceStore(), true);
        dbStorePicker.txtDbHost.setText(prefs.get(PROJ_PREF.DB_HOST, ""));
        dbStorePicker.txtDbName.setText(prefs.get(PROJ_PREF.DB_NAME, ""));
        dbStorePicker.txtDbPass.setText(prefs.get(PROJ_PREF.DB_PASS, ""));
        dbStorePicker.txtDbUser.setText(prefs.get(PROJ_PREF.DB_USER, ""));
        dbStorePicker.txtDbPort.setText(Integer.valueOf(
                prefs.getInt(PROJ_PREF.DB_PORT, 0)).toString());
        dbStorePicker.txtDbPort.addModifyListener(modListener);
        dbStorePicker.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                dbStorePicker.txtDbPort.removeModifyListener(modListener);                
            }
        });
        
        String projSource = prefs.get(PROJ_PREF.SOURCE, Sources.DB.toString());
        for (Sources sourse : Sources.values()) {
            if (projSource.equalsIgnoreCase(sourse.name)) {
                selectedSource = sourse;
                break;
            }
        }
        switch (selectedSource) {
        case DB:
            dbBtn.setSelection(true);
            dbBtn.notifyListeners(SWT.Selection, new Event());
            break;
        case DUMP:
            dumpBtn.setSelection(true);
            dumpBtn.notifyListeners(SWT.Selection, new Event());
            break;
        case JDBC:
            jdbcBtn.setSelection(true);
            jdbcBtn.notifyListeners(SWT.Selection, new Event());
            break;
        default:
            break;
        }

        return panel;
    }
    
    void setDbStoreEditMode(boolean hide) {
        if (dbStorePicker != null) {
            dbStorePicker.setVisible(!hide);
        }
    }
    
    @Override
    public boolean isValid() {
        try  {
            Integer.parseInt(dbStorePicker.txtDbPort.getText());
            setErrorMessage(null);
            setValid(true);
        } catch (NumberFormatException e) {
            setErrorMessage(Messages.projectProperties_error_occurs_while_saving_properties
                    + e.getLocalizedMessage());
            setValid(false);
        }
        return super.isValid();
    }
    
    @Override
    protected void performDefaults() {
        cmbEncoding.select(cmbEncoding.indexOf("UTF-8")); //$NON-NLS-1$
        selectedSource = Sources.DB;
        dropDbSettings();
        try {
            fillPrefs();
        } catch (BackingStoreException e) {
            setErrorMessage(Messages.projectProperties_error_occurs_while_saving_properties
                    + e.getLocalizedMessage());
            setValid(false);
        }
    }

    private void dropDbSettings() {
        dbStorePicker.txtDbHost.setText(""); //$NON-NLS-1$
        dbStorePicker.txtDbName.setText(""); //$NON-NLS-1$
        dbStorePicker.txtDbPass.setText(""); //$NON-NLS-1$
        dbStorePicker.txtDbPort.setText("0"); //$NON-NLS-1$
        dbStorePicker.txtDbUser.setText(""); //$NON-NLS-1$
    }
    
    @Override
    public boolean performOk() {
        if (!isValid()) {
            return false;
        }
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
        prefs.put(PROJ_PREF.SOURCE, selectedSource.toString());
        if (selectedSource == Sources.DUMP) {
            dropDbSettings();
        }
        prefs.put(PROJ_PREF.DB_HOST, dbStorePicker.txtDbHost.getText());
        prefs.put(PROJ_PREF.DB_NAME, dbStorePicker.txtDbName.getText());
        prefs.put(PROJ_PREF.DB_PASS, dbStorePicker.txtDbPass.getText());
        prefs.put(PROJ_PREF.DB_USER, dbStorePicker.txtDbUser.getText());
        prefs.putInt(PROJ_PREF.DB_PORT,
                Integer.parseInt(dbStorePicker.txtDbPort.getText())); //$NON-NLS-1$
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
    
    private enum Sources {
        DB(PROJ_PREF.SOURCE_TYPE_DB),
        DUMP(PROJ_PREF.SOURCE_TYPE_DUMP),
        JDBC(PROJ_PREF.SOURCE_TYPE_NONE);
        
        private String name;
        
        private Sources(String value) {
            name = value;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    class SelectionListener extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent e) {
            if (((Button)e.widget) == dumpBtn) {
                changeDbVisible(Sources.DUMP);
            }
            if (((Button)e.widget) == dbBtn) {
                changeDbVisible(Sources.DB);
            }
            if (((Button)e.widget) == jdbcBtn) {
                changeDbVisible(Sources.JDBC);
            }
        }
        void changeDbVisible(Sources source) {
            selectedSource = source;
            switch (source) {
            case DB:
            case JDBC:
                setDbStoreEditMode(false);
                break;
            default:
                setDbStoreEditMode(true);
                break;
                
            }
        }
    }
}
