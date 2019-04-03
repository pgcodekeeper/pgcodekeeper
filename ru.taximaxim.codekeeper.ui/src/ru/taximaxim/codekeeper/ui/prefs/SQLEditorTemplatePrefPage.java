package ru.taximaxim.codekeeper.ui.prefs;

import java.util.Arrays;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.templates.TemplatePersistenceData;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateManager;

public class SQLEditorTemplatePrefPage extends TemplatePreferencePage {

    public SQLEditorTemplatePrefPage() {
        try {
            setPreferenceStore(Activator.getDefault().getPreferenceStore());
            setTemplateStore(SQLEditorTemplateManager.getInstance()
                    .getTemplateStore());
            setContextTypeRegistry(SQLEditorTemplateManager.getInstance()
                    .getContextTypeRegistry());
            setFlagsToEnabledTemplates();
        } catch (Exception ex) {
            Log.log(Log.LOG_ERROR, "Cannot get sql templates", ex); //$NON-NLS-1$
        }
    }

    private void setFlagsToEnabledTemplates() {
        Display.getDefault().asyncExec(() -> Arrays
                .stream(((CheckboxTableViewer) getTableViewer()).getTable().getItems())
                .filter(i -> ((TemplatePersistenceData) i.getData()).isEnabled())
                .forEach(i -> i.setChecked(true)));
    }

    @Override
    protected boolean isShowFormatterSetting() {
        return false;
    }
}
