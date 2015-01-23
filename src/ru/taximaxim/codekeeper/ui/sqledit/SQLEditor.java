package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditor extends AbstractDecoratedTextEditor {

    public static final String ID = "ru.taximaxim.codekeeper.ui.SQLEditor";
    static final String CONTENT_ASSIST= "ContentAssist"; //$NON-NLS-1$

    private SQLEditorContentOutlinePage fOutlinePage;
    
    private Listener list = new Listener() {

        @Override
        public void handleEvent(Event event) {
            Display.getDefault().asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    if (fOutlinePage != null) { 
                        fOutlinePage.externalRefresh();
                    }
                }
            });
        }};

    public SQLEditor() {
        super();
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                getSharedColors(), getPreferenceStore()));
        setDocumentProvider(new SQLEditorDocumentProvider());
        
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (IContentOutlinePage.class.equals(adapter)) {
            if (fOutlinePage == null) {
                fOutlinePage= new SQLEditorContentOutlinePage(getDocumentProvider(), this);
                if (getEditorInput() != null) {
                    fOutlinePage.setInput(getEditorInput());
                }
            }
            return fOutlinePage;
        }
        return super.getAdapter(adapter);
    }
    
    @Override
    protected void createActions() {
        super.createActions();
        
        ResourceBundle bundle= ResourceBundle.getBundle(Messages.BUNDLE_NAME);
        ContentAssistAction action= new ContentAssistAction(bundle, "contentAssist.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction(CONTENT_ASSIST, action);
    }
    
    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        super.init(site, input);
        IFile file = ((FileEditorInput)input).getFile();
        if (file != null) {
            PgDbParser.getParser(file.getProject()).addListener(list);
        }
    }
    
    @Override
    public void dispose() {
        IFile file = ((FileEditorInput)getEditorInput()).getFile();
        if (file != null) {
            PgDbParser.getParser(file.getProject()).removeListener(list);
        }
        super.dispose();
    }
}
