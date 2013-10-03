package ru.taximaxim.codekeeper.ui.prefs;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class GeneralPrefPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	@Inject
	@Named(UIConsts.PREF_STORE)
	IPreferenceStore prefStore;
	
	public GeneralPrefPage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(prefStore);
	}

	@Override
	protected void createFieldEditors() {
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_SVN_EXE_PATH,
				"svn executable", getFieldEditorParent()));
		addField(new ExecutableFileFieldEditor(UIConsts.PREF_PGDUMP_EXE_PATH,
				"pg_dump executable", getFieldEditorParent()));
	}
}
