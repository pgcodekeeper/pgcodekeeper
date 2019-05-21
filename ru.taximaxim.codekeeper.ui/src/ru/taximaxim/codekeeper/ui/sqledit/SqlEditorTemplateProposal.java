package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;

public class SqlEditorTemplateProposal extends TemplateProposal {

    private static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n"; //$NON-NLS-1$

    private final IRegion region;

    public SqlEditorTemplateProposal(Template template, TemplateContext context,
            IRegion region, Image image, int relevance) {
        super(template, context, region, image, relevance);
        this.region = region;
    }

    public Template getTempalteOfProposal() {
        return getTemplate();
    }

    public void fillTmplAndInsertToViewer(String schema, String objectName,
            String parent, String parentCode, ITextViewer textViewer) {
        getFilledTmplPropos(schema, objectName, parent, parentCode)
        .apply(textViewer, Character.MIN_VALUE, 0, 0);
    }

    private SqlEditorTemplateProposal getFilledTmplPropos(String schema,
            String objectName, String parent, String parentCode) {
        Template tmpl = getTemplate();
        String tmplPatt = tmpl.getPattern();
        StringBuilder sbTmplPatt = new StringBuilder();

        // For cases when template is template for subelement.
        if (parent != null) {
            sbTmplPatt.append(parentCode).append(GROUP_DELIMITER);
            tmplPatt = fillPlaceHolder(tmplPatt, "${parentName}", parent); //$NON-NLS-1$
            tmplPatt = fillPlaceHolder(tmplPatt, "${constraintType}", "PRIMARY KEY"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        tmplPatt = fillPlaceHolder(tmplPatt, "${objectName}", objectName); //$NON-NLS-1$
        tmplPatt = fillPlaceHolder(tmplPatt, "${schemaName}", schema); //$NON-NLS-1$
        sbTmplPatt.append(tmplPatt);

        return new SqlEditorTemplateProposal(new Template(tmpl.getName(), tmpl.getDescription(),
                tmpl.getContextTypeId(), sbTmplPatt.toString(), tmpl.isAutoInsertable()),
                getContext(), region, getImage(), getRelevance());
    }

    private String fillPlaceHolder(String template, String placeHolder, String replacement) {
        if (template.contains(placeHolder)) {
            return template.replace(placeHolder, replacement);
        }
        return template;
    }
}
