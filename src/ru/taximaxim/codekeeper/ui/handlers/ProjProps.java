 
package ru.taximaxim.codekeeper.ui.handlers;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.parts.ProjectPartDescriptor;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

public class ProjProps {
	
	@Inject
	@Named(IServiceConstants.ACTIVE_PART)
	MPart part;
	
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell) {
		
		FakePrefPageExtension[] propPages = {
				new FakePrefPageExtension("projprefs.0.pagedbsouce", "DB Source",
						new DbSrcPage(), null),
				
				new FakePrefPageExtension("projprefs.1.pagesvn", "SVN Settings",
						new SvnSettingsPage(), null),
						
				new FakePrefPageExtension("projprefs.2.pagemisc", "Miscellaneous",
						new MiscSettingPage(), null)
				};
		
		IPreferenceStore prefStore = ((ProjectPartDescriptor) part.getObject())
				.getProject();
		PrefDialogFactory.show(shell, prefStore, propPages);
	}
	
	@CanExecute
	public boolean canExecute() {
		if(part.getElementId().equals(UIConsts.PROJ_PART_DESCR_ID)) {
			return true;
		}
		
		return false;
	}
}

class DbSrcPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	private Group grpSourceDb;
	
	private CLabel lblWarn;
	
	public DbSrcPage() {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected void createFieldEditors() {
		RadioGroupFieldEditor radio = new RadioGroupFieldEditor(
				UIConsts.PROJ_PREF_SOURCE, "Source of the DB schema", 1,
				new String[][] {
						{"Dump file", UIConsts.PROJ_SOURCE_TYPE_DUMP},
						{"Database", UIConsts.PROJ_SOURCE_TYPE_DB}
				}, getFieldEditorParent(), true);
		addField(radio);
		
		grpSourceDb = new Group(getFieldEditorParent(), SWT.NONE);
		grpSourceDb.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		grpSourceDb.setText("Settings for Database schema source");
		
		addField(new StringFieldEditor(UIConsts.PROJ_PREF_DB_NAME, "DB Name:",
				grpSourceDb));
		addField(new StringFieldEditor(UIConsts.PROJ_PREF_DB_USER, "DB User:",
				grpSourceDb));
		
		StringFieldEditor sfePass = new StringFieldEditor(
				UIConsts.PROJ_PREF_DB_PASS, "DB Password:", grpSourceDb);
		addField(sfePass);
		sfePass.getTextControl(grpSourceDb).setEchoChar((char)0x2022); // •
		
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
		
		addField(new StringFieldEditor(UIConsts.PROJ_PREF_DB_HOST, "DB Host:",
				grpSourceDb));
		addField(new IntegerFieldEditor(UIConsts.PROJ_PREF_DB_PORT, "DB Port:",
				grpSourceDb));
		
		if(UIConsts.PROJ_SOURCE_TYPE_DUMP.equals(
				getPreferenceStore().getString(UIConsts.PROJ_PREF_SOURCE))) {
			
			recursiveSetEnabled(grpSourceDb, false);
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		String prefName = ((FieldEditor) e.getSource()).getPreferenceName();
		
		if(UIConsts.PROJ_PREF_SOURCE.equals(prefName)) {
			if(!e.getNewValue().equals(e.getOldValue())) {
				recursiveSetEnabled(grpSourceDb, !grpSourceDb.getEnabled());
			}
		} else  if(UIConsts.PROJ_PREF_DB_PASS.equals(prefName)) {
			String oldVal = (String) e.getOldValue();
			String newVal = (String) e.getNewValue();
			
			if(oldVal.isEmpty() != newVal.isEmpty()) {
				GridData gd = (GridData)lblWarn.getLayoutData();
				
				gd.exclude = !gd.exclude;
				lblWarn.setVisible(!lblWarn.getVisible());

				Shell sh =  grpSourceDb.getShell();
				int width = sh.getSize().x;
				int newht = sh.computeSize(width, SWT.DEFAULT).y;
				sh.setSize(width, newht);

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

class SvnSettingsPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	private CLabel lblWarn;
	
	public SvnSettingsPage() {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
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
		sfePass.getTextControl(getFieldEditorParent()).setEchoChar((char)0x2022); // •
		
		lblWarn = new CLabel(getFieldEditorParent(), SWT.NONE);
		lblWarn.setImage(ImageDescriptor.createFromURL(
				Activator.getContext().getBundle().getResource(
						UIConsts.FILENAME_ICONWARNING)).createImage());
		lblWarn.setText("Warning:\n"
				+ "Providing password here is insecure!\n"
				+ "This password WILL show up in logs!\n"
				+ "Consider using SVN password store instead.");
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1);
		
		if(getPreferenceStore().getString(UIConsts.PROJ_PREF_SVN_PASS).isEmpty()) {
			gd.exclude = true;
			lblWarn.setVisible(false);
		}
		
		lblWarn.setLayoutData(gd);
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

				Shell sh =  lblWarn.getShell();
				int width = sh.getSize().x;
				int newht = sh.computeSize(width, SWT.DEFAULT).y;
				sh.setSize(width, newht);

				lblWarn.getParent().layout(false);
			}
		}
		
		super.propertyChange(e);
	}
}

class MiscSettingPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	public MiscSettingPage() {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected void createFieldEditors() {
		
		Set<String> charsets  = Charset.availableCharsets().keySet();
		List<String[]> lstCharsets = new ArrayList<>(charsets.size());
		
		for(String charset : charsets) {
			lstCharsets.add(new String[] { charset, charset });
		}
		
		addField(new ComboFieldEditor(UIConsts.PROJ_PREF_ENCODING,
				"Project encoding:",
				lstCharsets.toArray(new String[lstCharsets.size()][]),
				getFieldEditorParent()));
	}
}