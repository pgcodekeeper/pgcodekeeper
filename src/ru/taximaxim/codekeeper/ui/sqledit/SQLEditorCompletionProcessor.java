package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    private SqlPostgresSyntax sqlSyntax;
    private String text = "";

    public SQLEditorCompletionProcessor(SqlPostgresSyntax sqlSyntax) {
        this.sqlSyntax = sqlSyntax;
    }

    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset) {
        IDocument document = viewer.getDocument();
        text = "";
        try {
            int length = 1;
            text = document.get(offset - length, length);
            if (text.getBytes()[0] != '\n') {
                while (Character.isJavaIdentifierPart(document.get(offset - length, length)
                        .getBytes()[0])) {
                    text = document.get(offset - length, length);
                    length++;
                }
            }
            if (length == 1) {
                text = "";
            }
        } catch (BadLocationException e) {
            Log.log(Log.LOG_ERROR, "Document doesn't contain such offset", e);
        }

        List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
        // SQL TEmplates
        if (text.isEmpty()) {
            result.addAll(new SQLEditorTemplateAssistProcessor()
                    .getAllTemplates(viewer, offset));
        } else {
            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            if (templates != null) {
                for (int i = 0; i < templates.length; i++) {
                    result.add(templates[i]);
                }
            }    
        }
        
        IProject proj = null;
        IFile file = null;
        IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (page instanceof SQLEditor) {
            SQLEditor edit = (SQLEditor) page;
            file = ((FileEditorInput) ((edit).getEditorInput())).getFile();
            if (file != null) {
                proj = file.getProject();
            }
        }
        if (proj == null) {
            return result.toArray(new ICompletionProposal[result.size()]);
        }
        LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources());
        for (PgObjLocation obj : PgDbParser.getParser(proj).getObjDefinitions()) {
            ImageDescriptor iObj = ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONPGADMIN 
                            + obj.getObjType().toString().toLowerCase() 
                            + ".png")); //$NON-NLS-1$
            Image img = lrm.createImage(iObj);
            String displayText = obj.getObjName();
            if (!obj.getComment().isEmpty()) {
                displayText += " - " + obj.getComment();
            }
            if (!text.isEmpty()) {
                if (obj.getObjName().contains(text)) {
                    IContextInformation info = new ContextInformation(
                            obj.getObjName(), obj.getComment());
                    result.add(new CompletionProposal(obj.getObjName(), offset
                            - text.length(), text.length(),
                            obj.getObjLength(), img, displayText, info,
                            obj.getObjName()));
                }
            } else {
                IContextInformation info = new ContextInformation(obj.getObjName(),
                        obj.getComment());
                result.add(new CompletionProposal(obj.getObjName(), offset, 0,
                        obj.getObjLength(), img, displayText, info, obj.getObjName()));
            }
        }

        return result.toArray(new ICompletionProposal[result.size()]);
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
        return new char[] { '.', '(' };
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
        return new char[] { '#' };
    }

    @Override
    public String getErrorMessage() {
        return "Error Message";
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        // TODO Auto-generated method stub
        return null;
    }

}
