package ru.taximaxim.codekeeper.ui.prefs;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class SubPrefPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	@Inject
	@Named(UIConsts.PREF_STORE)
	IPreferenceStore prefStore;

	public SubPrefPage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(prefStore);
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
