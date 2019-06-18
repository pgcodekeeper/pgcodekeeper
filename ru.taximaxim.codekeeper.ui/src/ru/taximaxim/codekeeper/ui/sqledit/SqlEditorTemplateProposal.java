package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;

public class SqlEditorTemplateProposal extends TemplateProposal {

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
            String parent, ITextViewer textViewer, int offset) {
        getFilledTmplPropos(schema, objectName, parent)
        .apply(textViewer, (char) 0, 0, offset);
    }

    private SqlEditorTemplateProposal getFilledTmplPropos(String schema,
            String objectName, String parent) {
        Template tmpl = getTemplate();
        String tmplPatt = tmpl.getPattern();

        // For cases when template is template for subelement.
        if (parent != null) {
            tmplPatt = tmplPatt.replace("${parentName}", parent); //$NON-NLS-1$
        }

        tmplPatt = tmplPatt.replace("${objectName}", objectName); //$NON-NLS-1$
        tmplPatt = tmplPatt.replace("${schemaName}", schema); //$NON-NLS-1$

        return new SqlEditorTemplateProposal(new Template(tmpl.getName(), tmpl.getDescription(),
                tmpl.getContextTypeId(), tmplPatt, tmpl.isAutoInsertable()),
                getContext(), region, getImage(), getRelevance());
    }
}
