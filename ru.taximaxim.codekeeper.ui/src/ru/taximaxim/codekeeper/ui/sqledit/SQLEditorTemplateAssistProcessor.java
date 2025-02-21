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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorTemplateAssistProcessor extends TemplateCompletionProcessor {

    @Override
    protected Template[] getTemplates(String contextTypeId) {
        return SQLEditorTemplateManager.getInstance().getTemplateStore().getTemplates(contextTypeId);
    }

    @Override
    protected TemplateContextType getContextType(ITextViewer viewer,
            IRegion region) {
        return SQLEditorTemplateManager.getInstance().getContextTypeRegistry()
                .getContextType(getCtxTypeId());
    }

    private String getCtxTypeId() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (editor instanceof SQLEditor sqlEditor) {
            DatabaseType dbType = sqlEditor.getDbType();
            switch (dbType) {
            case PG:
                return SQLEditorTemplateContextType.CONTEXT_TYPE_PG;
            case MS:
                return SQLEditorTemplateContextType.CONTEXT_TYPE_MS;
            case CH:
                return SQLEditorTemplateContextType.CONTEXT_TYPE_CH;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
            }
        }

        return SQLEditorTemplateContextType.CONTEXT_TYPE_PG;
    }

    @Override
    protected Image getImage(Template template) {
        return null;
    }

    @Override
    protected String extractPrefix(ITextViewer viewer, int offset) {
        int i = offset;
        IDocument document = viewer.getDocument();
        if (i > document.getLength()) {
            return ""; //$NON-NLS-1$
        }
        try {
            while (i > 0) {
                char ch = document.getChar(i - 1);
                if (!PgDiffUtils.isValidIdChar(ch)) {
                    break;
                }
                i--;
            }
            if (i > 0) {
                int j = i;
                if (document.getChar(j - 1) == '<') {
                    i--;
                }
            }
            return document.get(i, offset - i);
        } catch (BadLocationException e) {
            return ""; //$NON-NLS-1$
        }
    }

    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset) {
        ITextSelection selection = (ITextSelection) viewer
                .getSelectionProvider().getSelection();
        // adjust offset to end of normalized selection
        if (selection.getOffset() == offset) {
            offset = selection.getOffset() + selection.getLength();
        }
        String prefix = extractPrefix(viewer, offset).toLowerCase(Locale.ROOT);
        Region region = new Region(offset - prefix.length(), prefix.length());
        TemplateContext context = createContext(viewer, region);
        if (context == null) {
            return new ICompletionProposal[0];
        }
        context.setVariable("selection", selection.getText()); // name of the selection variables {line, word_selection //$NON-NLS-1$
        Template[] templates = getTemplatesWithCommonPart(context.getContextType().getId());
        List<ICompletionProposal> matches = new ArrayList<>();
        for (Template template : templates) {
            try {
                context.getContextType().validate(template.getPattern());
            } catch (TemplateException e) {
                continue;
            }
            if (!"".equals(prefix) && prefix.charAt(0) == '<') { //$NON-NLS-1$
                prefix = prefix.substring(1);
            }
            if (!"".equals(prefix) //$NON-NLS-1$
                    && (isPrefixContainedInTmpl(prefix, template, context.getContextType().getId())
                            || isPrefixContainedInTmpl(prefix, template,
                                    SQLEditorTemplateContextType.CONTEXT_TYPE_COMMON))) {
                matches.add(createProposal(template, context, (IRegion) region,
                        getRelevance(template, prefix)));
            }
        }
        return matches.toArray(new ICompletionProposal[matches.size()]);
    }

    /**
     * Returns array which contains the templates of 'contextTypeId' and common templates.
     */
    private Template[] getTemplatesWithCommonPart(String contextTypeId) {
        Template[] ctxTypeIdTmpls = getTemplates(contextTypeId);
        Template[] commonTmpls = getTemplates(SQLEditorTemplateContextType.CONTEXT_TYPE_COMMON);
        Template[] unitedTmpls = Arrays.copyOf(ctxTypeIdTmpls, ctxTypeIdTmpls.length + commonTmpls.length);
        System.arraycopy(commonTmpls, 0, unitedTmpls, ctxTypeIdTmpls.length, commonTmpls.length);
        return unitedTmpls;
    }

    /**
     * Returns true if template is enabled, matches the context and starts with
     * the specified prefix, false otherwise.
     *
     * @param tmpl template for check
     * @param prefix typed word
     * @param ctxId id of templateCtx for check belonging of template to TemplateContext
     * @return true if template is enabled, matches the context and starts with
     * the specified prefix, false otherwise
     */
    private boolean isPrefixContainedInTmpl(String prefix, Template tmpl, String ctxId) {
        return tmpl.getName().toLowerCase(Locale.ROOT).contains(prefix) && tmpl.matches(prefix, ctxId);
    }

    public List<SqlEditorTemplateProposal> getAllTemplates(ITextViewer viewer,
            int offset) {
        List<SqlEditorTemplateProposal> result = new ArrayList<>();
        String prefix = extractPrefix(viewer, offset);
        Region region = new Region(offset - prefix.length(), prefix.length());
        TemplateContext context = createContext(viewer, region);
        Template[] templates = getTemplatesWithCommonPart(getCtxTypeId());
        for (Template template : templates) {
            result.add(createSqlEditorTemplateProposal(template, context, region,
                    getRelevance(template, prefix)));
        }
        return result;
    }

    // This override is necessary for correct filtering of proposals for cases when
    // the text typing starts for pop-up proposals of keys, and then user switched to
    // the pop-up proposals of templates and continues typing.
    @Override
    protected ICompletionProposal createProposal(Template template,
            TemplateContext context, IRegion region, int relevance) {
        return createSqlEditorTemplateProposal(template, context, region, relevance);
    }

    private SqlEditorTemplateProposal createSqlEditorTemplateProposal(Template template,
            TemplateContext context, IRegion region, int relevance) {
        return new SqlEditorTemplateProposal(template, context, region,
                getImage(template), relevance);
    }
}
