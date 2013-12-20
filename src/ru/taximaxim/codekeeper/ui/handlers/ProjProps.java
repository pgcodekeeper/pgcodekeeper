 
package ru.taximaxim.codekeeper.ui.handlers;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePickerDialog;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

public class ProjProps {

	@Execute
	public void execute(
            @Named(UIConsts.PREF_STORE)
            IPreferenceStore mainPrefs,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			PgDbProject proj) {
		
		FakePrefPageExtension[] propPages = {
                new FakePrefPageExtension("projprefs.0.pagesvn", "SVN Settings",
                        new SvnSettingsPage(), null),
                
				new FakePrefPageExtension("projprefs.1.pagedbsouce", "DB Source",
						new DbSrcPage(mainPrefs), null),
						
				new FakePrefPageExtension("projprefs.2.pagemisc", "Miscellaneous",
						new MiscSettingPage(), null)
				};
		
		PrefDialogFactory.show(shell, proj, propPages);
	}
	
	@CanExecute
	public boolean canExecute(PgDbProject proj) {
	    return proj != null;
	}
}

class DbSrcPage extends FieldEditorPreferencePage {
    
    private final IPreferenceStore mainPrefs;
	
	private Group grpSourceDb;
	
	private CLabel lblWarn;
	
	public DbSrcPage(IPreferenceStore mainPrefs) {
		super(GRID);
		
		this.mainPrefs = mainPrefs;
	}
	
	@Override
	protected void createFieldEditors() {
		RadioGroupFieldEditor radio = new RadioGroupFieldEditor(
				UIConsts.PROJ_PREF_SOURCE, "Source of the DB schema", 1,
				new String[][] {
				        {"None", UIConsts.PROJ_SOURCE_TYPE_NONE},
						{"Dump file", UIConsts.PROJ_SOURCE_TYPE_DUMP},
						{"Database", UIConsts.PROJ_SOURCE_TYPE_DB}
				}, getFieldEditorParent(), true);
		addField(radio);
		
		grpSourceDb = new Group(getFieldEditorParent(), SWT.NONE);
		grpSourceDb.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		grpSourceDb.setText("Settings for Database schema source");
		
		final StringFieldEditor sfeName = new StringFieldEditor(
		        UIConsts.PROJ_PREF_DB_NAME, "DB Name:", grpSourceDb);
		addField(sfeName);
		
		final StringFieldEditor sfeUser = new StringFieldEditor(
		        UIConsts.PROJ_PREF_DB_USER, "DB User:", grpSourceDb);
		addField(sfeUser);
		
		final StringFieldEditor sfePass = new StringFieldEditor(
				UIConsts.PROJ_PREF_DB_PASS, "DB Password:", grpSourceDb);
		addField(sfePass);
		sfePass.getTextControl(grpSourceDb).setEchoChar('\u2022'); // •
		
		lblWarn = new CLabel(grpSourceDb, SWT.NONE);
		lblWarn.setImage(ImageDescriptor.createFromURL(
				Activator.getContext().getBundle().getResource(
						UIConsts.FILENAME_ICONWARNING)).createImage());
		lblWarn.setText("Warning:\n"
				+ "Providing password here is insecure!\n"
				+ "Consider using .pgpass file instead.");
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		
		if(getPreferenceStore().getString(UIConsts.PROJ_PREF_DB_PASS).isEmpty()) {
			gd.exclude = true;
			lblWarn.setVisible(false);
		}
		
		lblWarn.setLayoutData(gd);
		
		final StringFieldEditor sfeHost = new StringFieldEditor(
		        UIConsts.PROJ_PREF_DB_HOST, "DB Host:",grpSourceDb);
		addField(sfeHost);
		
		final IntegerFieldEditor ifePort = new IntegerFieldEditor(
		        UIConsts.PROJ_PREF_DB_PORT, "DB Port:", grpSourceDb);
		addField(ifePort);
		
		Button btnStorePick = new Button(grpSourceDb, SWT.PUSH);
		btnStorePick.setText("...");
		btnStorePick.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false, 2, 1));
		btnStorePick.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        DbStorePickerDialog dialog = new DbStorePickerDialog(getShell(), mainPrefs);
		        if(dialog.open() == Dialog.OK) {
		            DbInfo db = dialog.getDbInfo();
		            
		            sfeName.setStringValue(db.dbname);
		            sfeUser.setStringValue(db.dbuser);
		            sfePass.setStringValue(db.dbpass);
		            sfeHost.setStringValue(db.dbhost);
		            ifePort.setStringValue(String.valueOf(db.dbport));
		        }
		    }
        });
		
		if(!UIConsts.PROJ_SOURCE_TYPE_DB.equals(
				getPreferenceStore().getString(UIConsts.PROJ_PREF_SOURCE))) {
			recursiveSetEnabled(grpSourceDb, false);
		}
		
		((GridLayout) grpSourceDb.getLayout()).marginWidth = 5;
		((GridLayout) grpSourceDb.getLayout()).marginHeight = 5;
		
		noDefaultAndApplyButton();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		String prefName = ((FieldEditor) e.getSource()).getPreferenceName();
		
		if(UIConsts.PROJ_PREF_SOURCE.equals(prefName)) {
			if(!e.getNewValue().equals(e.getOldValue())) {
				recursiveSetEnabled(grpSourceDb,
				        UIConsts.PROJ_SOURCE_TYPE_DB.equals(e.getNewValue()));
			}
		} else  if(UIConsts.PROJ_PREF_DB_PASS.equals(prefName)) {
			String oldVal = (String) e.getOldValue();
			String newVal = (String) e.getNewValue();
			
			if(oldVal.isEmpty() != newVal.isEmpty()) {
				GridData gd = (GridData)lblWarn.getLayoutData();
				
				gd.exclude = !gd.exclude;
				lblWarn.setVisible(!lblWarn.getVisible());

				getShell().pack();
				grpSourceDb.getParent().layout(false);
			}
		}
		
		super.propertyChange(e);
	}
	
	private void recursiveSetEnabled(Composite composite, boolean enabled) {
		composite.setEnabled(enabled);
		
		for(Control child : composite.getChildren()) {
			if(child instanceof Composite) {
				recursiveSetEnabled((Composite)child, enabled);
			} else {
				child.setEnabled(enabled);
			}
		}
	}
}

class SvnSettingsPage extends FieldEditorPreferencePage {
	
	private CLabel lblWarn;
	
	public SvnSettingsPage() {
		super(GRID);
	}
	
	@Override
	protected void createFieldEditors() {
		StringFieldEditor sfeUrl = new StringFieldEditor(
				UIConsts.PROJ_PREF_SVN_URL, "SVN Repo URL:", getFieldEditorParent());
		addField(sfeUrl);
		sfeUrl.setEmptyStringAllowed(false);
		
		addField(new StringFieldEditor(UIConsts.PROJ_PREF_SVN_USER, "SVN User:",
				getFieldEditorParent()));
		
		StringFieldEditor sfePass = new StringFieldEditor(
				UIConsts.PROJ_PREF_SVN_PASS, "SVN Pass:", getFieldEditorParent());
		addField(sfePass);
		sfePass.getTextControl(getFieldEditorParent()).setEchoChar('\u2022'); // •
		
		lblWarn = new CLabel(getFieldEditorParent(), SWT.NONE);
		lblWarn.setImage(ImageDescriptor.createFromURL(
				Activator.getContext().getBundle().getResource(
						UIConsts.FILENAME_ICONWARNING)).createImage());
		lblWarn.setText("Warning:\n"
				+ "Providing password here is insecure!\n"
				+ "This password WILL show up in logs!\n"
				+ "Consider using SVN password store instead.");
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		
		if(getPreferenceStore().getString(UIConsts.PROJ_PREF_SVN_PASS).isEmpty()) {
			gd.exclude = true;
			lblWarn.setVisible(false);
		}
		
		lblWarn.setLayoutData(gd);
		
		noDefaultAndApplyButton();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		String prefName = ((FieldEditor) e.getSource()).getPreferenceName();
		
		if(UIConsts.PROJ_PREF_SVN_PASS.equals(prefName)) {
			String oldVal = (String) e.getOldValue();
			String newVal = (String) e.getNewValue();
			
			if(oldVal.isEmpty() != newVal.isEmpty()) {
				GridData gd = (GridData)lblWarn.getLayoutData();
				
				gd.exclude = !gd.exclude;
				lblWarn.setVisible(!lblWarn.getVisible());

				getShell().pack();
				lblWarn.getParent().layout(false);
			}
		}
		
		super.propertyChange(e);
	}
}

class MiscSettingPage extends FieldEditorPreferencePage {
    
    private String originalEncoding;
    
    private CLabel lblWarn;
    
	public MiscSettingPage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
	    originalEncoding = getPreferenceStore().getString(UIConsts.PROJ_PREF_ENCODING);
		
		Set<String> charsets  = Charset.availableCharsets().keySet();
		List<String[]> lstCharsets = new ArrayList<>(charsets.size());
		
		for(String charset : charsets) {
			lstCharsets.add(new String[] { charset, charset });
		}
		
		addField(new ComboFieldEditor(UIConsts.PROJ_PREF_ENCODING,
				"Project encoding:",
				lstCharsets.toArray(new String[lstCharsets.size()][]),
				getFieldEditorParent()));

        lblWarn = new CLabel(getFieldEditorParent(), SWT.NONE);
        lblWarn.setImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        UIConsts.FILENAME_ICONWARNING)).createImage());
        lblWarn.setText("Warning:\n"
                + "Encoding of existing files will not be changed!");
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
        gd.exclude = true;
        lblWarn.setVisible(false);
        
        lblWarn.setLayoutData(gd);
        
        noDefaultAndApplyButton();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
	    String prefName = ((FieldEditor) e.getSource()).getPreferenceName();
	    
	    if(UIConsts.PROJ_PREF_ENCODING.equals(prefName)) {
            String oldVal = (String) e.getOldValue();
	        String newVal = (String) e.getNewValue();
	        
	        if(!oldVal.equals(newVal)) {
	            boolean show = !newVal.equals(originalEncoding);
	            
	            GridData gd = (GridData) lblWarn.getLayoutData();
                
                gd.exclude = !show;
                lblWarn.setVisible(show);

                getShell().pack();
                lblWarn.getParent().layout(false);
	        }
	    }

	    super.propertyChange(e);
	}
}