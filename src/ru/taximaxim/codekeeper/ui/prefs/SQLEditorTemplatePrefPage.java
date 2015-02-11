package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateManager;

public class SQLEditorTemplatePrefPage extends TemplatePreferencePage implements
        IWorkbenchPreferencePage {

    public SQLEditorTemplatePrefPage() {
        try {
            setPreferenceStore(Activator.getDefault().getPreferenceStore());
            setTemplateStore(SQLEditorTemplateManager.getInstance()
                    .getTemplateStore());
            setContextTypeRegistry(SQLEditorTemplateManager.getInstance()
                    .getContextTypeRegistry());
        } catch (Exception ex) {
            Log.log(Log.LOG_ERROR, "Cannot get sql templates", ex); //$NON-NLS-1$
        }
    }

    protected boolean isShowFormatterSetting() {
        return false;
    }

    @Override
    protected Control createContents(Composite parent) {
        return super.createContents(parent);
    }
}
