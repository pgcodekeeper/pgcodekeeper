package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.UIConsts.COMMIT_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class CommitPrefPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    public CommitPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(UIScopedPreferenceStore.get());
    }

    @Override
    protected void createFieldEditors() {
        BooleanFieldEditor useDepcyCommit = new BooleanFieldEditor(
                COMMIT_PREF.CONSIDER_DEPCY_IN_COMMIT, Messages.generalPrefPage_use_depcy_on_commit_page,
                FileFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
        addField(useDepcyCommit);
    }
}
