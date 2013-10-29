 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.prefs.ExecutableFileFieldEditor;
import ru.taximaxim.codekeeper.ui.prefs.FakePrefPageExtension;
import ru.taximaxim.codekeeper.ui.prefs.PrefDialogFactory;

public class Prefs {
	
	@Execute
	public void execute(
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell) {
		FakePrefPageExtension[] pages = {
				
				new FakePrefPageExtension("ru.taximaxim.codekeeper.ui.prefs.general",
						"General", new GeneralPrefPage(), null),
						
				new FakePrefPageExtension("ru.taximaxim.codekeeper.ui.prefs.generalsub",
						"Sub", new SubPrefPage(), "ru.taximaxim.codekeeper.ui.prefs.general")
		};
		
		PrefDialogFactory.show(shell, prefStore, pages);
	}
}

class GeneralPrefPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public GeneralPrefPage() {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected void createFieldEditors() {
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_SVN_EXE_PATH,
				"svn executable", getFieldEditorParent()));
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH,
				"pg_dump executable", getFieldEditorParent()));
	}
}

class SubPrefPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public SubPrefPage() {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}
	
	@Override
	protected void createFieldEditors() {
	
	}
	
	@Override
	protected Control createContents(Composite parent) {
		new Label(parent, SWT.NONE).setText(
				"This is not the page you are looking for.");
		noDefaultAndApplyButton();
		return super.createContents(parent);
	}
}
