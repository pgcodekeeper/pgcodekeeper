package ru.taximaxim.codekeeper.ui.prefs;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInput;

public class PrePostScriptPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private IWorkbenchPage page;
    private final String postFileName = FILE.POST_SCRIPT;
    private final String preFileName = FILE.PRE_SCRIPT;

    public PrePostScriptPrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        page = workbench.getActiveWorkbenchWindow().getActivePage();
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        BooleanFieldEditor addPrePostScript = new BooleanFieldEditor(
                DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT,
                Messages.DbUpdatePrefPage_add_pre_post_script,
                getFieldEditorParent());
        addField(addPrePostScript);
        addPrePostScript.getDescriptionControl(getFieldEditorParent())
        .setToolTipText(Messages.PrePostScriptPrefPage_pre_post_descr);

        Composite area = new Composite(getFieldEditorParent(), SWT.NONE);
        area.setLayout(new GridLayout(2, true));

        Button btnPreScript = new Button(area, SWT.PUSH);
        btnPreScript.setText(Messages.PrePostScriptPrefPage_pre);

        btnPreScript.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                openEditor(preFileName);
            }
        });

        Button btnPostScript = new Button(area, SWT.PUSH);
        btnPostScript.setText(Messages.PrePostScriptPrefPage_post);
        btnPostScript.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                openEditor(postFileName);
            }
        });
    }

    private void openEditor(String filename) {
        SQLEditorInput input = new SQLEditorInput(getScriptPath(filename), false, false);
        try {
            IDE.openEditor(page, input, EDITOR.SQL);
        } catch (PartInitException ex) {
            ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
        }
    }

    public static Path getScriptPath(String fileName) {
        return Paths.get(Platform.getStateLocation(Activator.getContext().getBundle())
                .append(fileName).toString());
    }
}
