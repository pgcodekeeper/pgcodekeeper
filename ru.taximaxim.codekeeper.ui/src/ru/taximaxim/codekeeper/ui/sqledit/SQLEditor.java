package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditor extends AbstractDecoratedTextEditor {

    public static final String ID = "ru.taximaxim.codekeeper.ui.SQLEditor"; //$NON-NLS-1$
    static final String CONTENT_ASSIST= "ContentAssist"; //$NON-NLS-1$

    private SQLEditorContentOutlinePage fOutlinePage;
    private IEditorInput input;
    
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
        }
    };

    public SQLEditor() {
        super();
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                getSharedColors(), getPreferenceStore()));
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (IContentOutlinePage.class.equals(adapter)) {
            if (fOutlinePage != null) {
                return fOutlinePage;    
            }
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
        this.input = input;
        if (input instanceof IFileEditorInput) {
            setDocumentProvider(new SQLEditorFileDocumentProvider());
        } else if (input instanceof FileStoreEditorInput){
            super.init(site, input);
            return;
        } else {
            setDocumentProvider(new SQLEditorStorageDocumentProvider());
        }
        super.init(site, input);
        PgDbParser parser = getParser();
        if (parser != null) {
            parser.addListener(list);
            fOutlinePage= new SQLEditorContentOutlinePage(getDocumentProvider(), this);
            fOutlinePage.setInput(getEditorInput());
        }
    }
    
    PgDbParser getParser() {
        if (input instanceof DepcyFromPSQLOutput) {
            return ((DepcyFromPSQLOutput) input).getParser();
        } else if (input instanceof IFileEditorInput) {
            IProject proj = ((IFileEditorInput)input).getFile().getProject();
            try {
                if (proj.hasNature(NATURE.ID)) {
                    return PgDbParser.getParser(proj);
                }
            } catch (CoreException e) {
                // do nothing
            }
        }
        return null;
    }
    
    @Override
    public void dispose() {
        PgDbParser parser = getParser();
        if (parser != null) {
            parser.removeListener(list);
        }
        super.dispose();
    }
}
