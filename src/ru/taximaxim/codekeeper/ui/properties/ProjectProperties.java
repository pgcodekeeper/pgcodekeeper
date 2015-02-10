package ru.taximaxim.codekeeper.ui.properties;


import java.text.MessageFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectProperties extends PropertyPage implements
        IWorkbenchPropertyPage {

    private static String[] availableTimezones;
    
    private Combo cmbTimezone;
    private CLabel lblWarn;
    
    private LocalResourceManager lrm;
    private IEclipsePreferences prefs;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        prefs = new ProjectScope((IProject) element.getAdapter(IProject.class))
                .getNode(UIConsts.PLUGIN_ID.THIS);
    }
    
    @Override
    protected Control createContents(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        panel.setLayout(layout);
        
        lrm = new LocalResourceManager(JFaceResources.getResources(), panel);
        
        Label label = new Label(panel, SWT.NONE);
        label.setText(Messages.projectProperties_timezone_for_all_db_connections);
        
        cmbTimezone = new Combo(panel, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        cmbTimezone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbTimezone.setItems(getSortedTimezones());
        cmbTimezone.select(cmbTimezone.indexOf(prefs.get(PROJ_PREF.TIMEZONE, UIConsts.UTC)));
        
        ModifyListener ml = new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                checkSwitchWarnLbl();
            }
        };
        cmbTimezone.addModifyListener(ml);
        
        lblWarn = new CLabel(panel, SWT.NONE);
        lblWarn.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONWARNING))));
        lblWarn.setText(Messages.ProjectProperties_change_projprefs_warn);
        GridData gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 2, 1);
        gd.exclude = true;
        lblWarn.setLayoutData(gd);
        lblWarn.setVisible(false);
        
        return panel;
    }
    
    private void checkSwitchWarnLbl() {
        boolean show = 
                !cmbTimezone.getText().equals(prefs.get(PROJ_PREF.TIMEZONE, UIConsts.UTC));
        ((GridData) lblWarn.getLayoutData()).exclude = !show;
        lblWarn.setVisible(show);
        lblWarn.getParent().layout();
    }
    
    @Override
    protected void performDefaults() {
        cmbTimezone.select(cmbTimezone.indexOf(UIConsts.UTC));
        try {
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
        prefs.put(PROJ_PREF.TIMEZONE, cmbTimezone.getText());
        prefs.flush();
        setValid(true);
        setErrorMessage(null);
    }
    
    private String[] getSortedTimezones(){
        if (availableTimezones == null){
            availableTimezones = TimeZone.getAvailableIDs();
            Arrays.sort(availableTimezones);
        }
        return availableTimezones;
    }
}
