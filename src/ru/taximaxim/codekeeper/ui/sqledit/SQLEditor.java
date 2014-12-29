package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SQLEditor extends AbstractDecoratedTextEditor {

    public static final String ID = "ru.taximaxim.codekeeper.ui.SQLEditor";
    
    static final String CONTENT_ASSIST= "ContentAssist"; //$NON-NLS-1$
    
    // разобраться с вычислением частей документа и выводить части в аутлайн
    private final class MyContentOutlinePage extends ContentOutlinePage {
        private IEditorInput fInput;
        private AbstractDecoratedTextEditor fTextEditor;
        private IDocumentProvider fDocumentProvider;
        private PgDbParser parser;

        public MyContentOutlinePage(IDocumentProvider fDocumentProvider,
                AbstractDecoratedTextEditor sqlEditor) {
            fTextEditor = sqlEditor;
            this.fDocumentProvider = fDocumentProvider;
        }

        public void setInput(IEditorInput input) {
            this.fInput = input;
            IFile file = ((FileEditorInput)input).getFile();
            if (file != null) {
                parser = PgDbParser.getParserFromStore(file.getProject());
            }
        }

        @Override
        public void createControl(Composite parent) {
            super.createControl(parent);
            TreeViewer viewer = getTreeViewer();
            viewer.setContentProvider(new ITreeContentProvider() {

                @Override
                public void inputChanged(Viewer viewer, Object oldInput,
                        Object newInput) {
                    if (newInput != null) {
                        IDocument document = fDocumentProvider
                                .getDocument(newInput);
                        if (document != null) {
                            // document.addPositionCategory(SEGMENTS);
                            // document.addPositionUpdater(fPositionUpdater);
                            // parse(document);
                        }
                    }
                }

                @Override
                public void dispose() {
                    // TODO Auto-generated method stub

                }

                @Override
                public Object[] getElements(Object inputElement) {
                    List<Segments> segments = new ArrayList<>();
                    if (inputElement instanceof FileEditorInput) {
                        FileEditorInput fi = (FileEditorInput)inputElement;
                        for (PgObjLocation loc : parser.getObjectByPath(fi.getFile().getLocation().toFile().toPath())) {
                            segments.add(new Segments(loc.getOffset(), loc.getObjLength(), loc.getObjName()));
                        }
                    }
                    return segments.toArray();
                }

                @Override
                public Object[] getChildren(Object parentElement) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public Object getParent(Object element) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public boolean hasChildren(Object element) {
                    // TODO Auto-generated method stub
                    return false;
                }
            });

            viewer.setLabelProvider(new LabelProvider());
            viewer.addSelectionChangedListener(this);

            if (fInput != null)
                viewer.setInput(fInput);

        }

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            super.selectionChanged(event);

            ISelection selection = event.getSelection();
            if (selection.isEmpty())
                fTextEditor.resetHighlightRange();
            else {
                Segments segment = (Segments) ((IStructuredSelection) selection)
                        .getFirstElement();
                int start = segment.getOffset();
                int length = segment.getLength();
                try {
                    fTextEditor.setHighlightRange(start, length, true);
                } catch (IllegalArgumentException x) {
                    fTextEditor.resetHighlightRange();
                }
            }
        }
    }
    
    private class Segments extends Position {
        private String name;

        /**
         * Creates a new segment covering the given range.
         *
         * @param offset the offset of the segment
         * @param length the length of the segment
         */
        public Segments(int offset, int length, String name) {
            super(offset, length);
            this.name = name;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }

    private MyContentOutlinePage fOutlinePage;

    public SQLEditor() {
        super();
        
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(getSharedColors(), getPreferenceStore()));
        setDocumentProvider(new SQLEditorDocumentProvider());
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (IContentOutlinePage.class.equals(adapter)) {
            if (fOutlinePage == null) {
                fOutlinePage= new MyContentOutlinePage(getDocumentProvider(), this);
                if (getEditorInput() != null)
                    fOutlinePage.setInput(getEditorInput());
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
}
