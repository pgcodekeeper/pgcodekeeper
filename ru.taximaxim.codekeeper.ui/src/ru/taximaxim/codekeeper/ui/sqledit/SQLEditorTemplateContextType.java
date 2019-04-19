package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class SQLEditorTemplateContextType extends TemplateContextType {

    public static final String CONTEXT_TYPE_PG
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypePg"; //$NON-NLS-1$

    public static final String CONTEXT_TYPE_MS
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypeMs"; //$NON-NLS-1$

    public static final String CONTEXT_TYPE_COMMON
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextTypeCommon"; //$NON-NLS-1$

    public SQLEditorTemplateContextType() {
        addResolver(new GlobalTemplateVariables.Cursor());
        addResolver(new GlobalTemplateVariables.WordSelection());
        addResolver(new GlobalTemplateVariables.LineSelection());
    }
}
