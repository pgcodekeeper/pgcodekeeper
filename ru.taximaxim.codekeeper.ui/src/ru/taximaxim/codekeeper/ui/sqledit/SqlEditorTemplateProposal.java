/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
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

        if (schema != null) {
            tmplPatt = tmplPatt.replace("${schemaName}", schema); //$NON-NLS-1$
        }

        return new SqlEditorTemplateProposal(new Template(tmpl.getName(), tmpl.getDescription(),
                tmpl.getContextTypeId(), tmplPatt, tmpl.isAutoInsertable()),
                getContext(), region, getImage(), getRelevance());
    }

    // This override is necessary for correct filtering the proposed templates
    // while typing text (here used 'contains' method instead of 'startsWith').
    @Override
    public boolean validate(IDocument document, int offset, DocumentEvent event) {
        try {
            int replaceOffset= getReplaceOffset();
            if (offset >= replaceOffset) {
                String content= document.get(replaceOffset, offset - replaceOffset);
                return getTemplate().getName().toLowerCase().contains(content.toLowerCase());
            }
        } catch (BadLocationException e) {
            // concurrent modification - ignore
        }
        return false;
    }
}
