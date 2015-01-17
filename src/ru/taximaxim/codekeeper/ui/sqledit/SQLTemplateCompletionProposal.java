package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;

public class SQLTemplateCompletionProposal extends TemplateProposal {

    private final Template fTemplate;

    public SQLTemplateCompletionProposal(Template template,
            TemplateContext context, IRegion region, Image image) {
        super(template, context, region, image);
        fTemplate = template;
    }

    public SQLTemplateCompletionProposal(Template template,
            TemplateContext context, IRegion region, Image image, int relevance) {
        super(template, context, region, image, relevance);
        fTemplate = template;
    }

    @Override
    public String getAdditionalProposalInfo() {
        return fTemplate.getPattern();
        // return StringUtils.convertToHTMLContent(fTemplate.getPattern());
    }
}
