package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class SQLEditorTemplateContextType extends TemplateContextType {

    public static final String CONTEXT_TYPE 
    = UIConsts.PLUGIN_ID.THIS + ".sqlEditorContextType"; //$NON-NLS-1$
    
    public SQLEditorTemplateContextType() {
        addResolver(new GlobalTemplateVariables.Cursor());
        addResolver(new GlobalTemplateVariables.WordSelection());
        addResolver(new GlobalTemplateVariables.LineSelection());
    }
}
