package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.TEMP_DIR_PATH;

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
        boolean isMsEditor = false;
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (editor instanceof SQLEditor) {
            IResource res = ResourceUtil.getResource(editor.getEditorInput());
            if (res != null) {
                // if in SQLEdotor opened project file
                try {
                    isMsEditor = res.getProject().hasNature(NATURE.MS);
                } catch (CoreException e) {
                    Log.log(Log.LOG_WARNING, "Nature error", e); //$NON-NLS-1$
                }
            } else {
                // if in SQLEdotor opened temp file
                IEditorInput in = editor.getEditorInput();
                if (in instanceof IURIEditorInput) {
                    isMsEditor = Paths.get(((IURIEditorInput) in).getURI()).getParent()
                            .equals(Paths.get(System.getProperty("java.io.tmpdir"), TEMP_DIR_PATH.MS)); //$NON-NLS-1$
                }
            }
        }

        return isMsEditor ? SQLEditorTemplateContextType.CONTEXT_TYPE_MS
                : SQLEditorTemplateContextType.CONTEXT_TYPE_PG;
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
            if (!prefix.equals("") && prefix.charAt(0) == '<') { //$NON-NLS-1$
                prefix = prefix.substring(1);
            }
            if (!prefix.equals("") //$NON-NLS-1$
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

    private SqlEditorTemplateProposal createSqlEditorTemplateProposal(Template template,
            TemplateContext context, IRegion region, int relevance) {
        return new SqlEditorTemplateProposal(template, context, region,
                getImage(template), relevance);
    }
}