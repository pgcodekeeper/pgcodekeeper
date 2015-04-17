package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class SQLEditorTemplateManager {
    private static final String CUSTOM_TEMPLATES_KEY = UIConsts.PLUGIN_ID.THIS
            + ".customtemplates"; //$NON-NLS-1$
    private static SQLEditorTemplateManager instance;
    private TemplateStore fStore;
    private ContributionContextTypeRegistry fRegistry;

    public SQLEditorTemplateManager() {
    }

    public static SQLEditorTemplateManager getInstance() {
        if (instance == null) {
            instance = new SQLEditorTemplateManager();
        }
        return instance;
    }

    public TemplateStore getTemplateStore() {

        if (fStore == null) {
            fStore = new ContributionTemplateStore(getContextTypeRegistry(),
                    Activator.getDefault().getPreferenceStore(),
                    CUSTOM_TEMPLATES_KEY);
            try {
                fStore.load();
            } catch (IOException e) {
                Log.log(Log.LOG_ERROR, "Cannot load templates", e);
            }
        }
        return fStore;
    }

    public ContextTypeRegistry getContextTypeRegistry() {
        if (fRegistry == null) {
            fRegistry = new ContributionContextTypeRegistry();
        }
        fRegistry.addContextType(SQLEditorTemplateContextType.CONTEXT_TYPE);
        return fRegistry;
    }

    public IPreferenceStore getPreferenceStore() {
        return Activator.getDefault().getPreferenceStore();
    }
}
