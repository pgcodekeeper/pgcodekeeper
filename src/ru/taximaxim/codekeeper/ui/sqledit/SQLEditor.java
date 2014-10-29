package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.projection.Segment;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class SQLEditor extends AbstractDecoratedTextEditor {

    // разобраться с вычислением частей документа и выводить части в аутлайн
    private final class MyContentOutlinePage extends ContentOutlinePage {
        private IEditorInput fInput;
        private AbstractDecoratedTextEditor fTextEditor;
        private IDocumentProvider fDocumentProvider;

        public MyContentOutlinePage(IDocumentProvider fDocumentProvider,
                AbstractDecoratedTextEditor sqlEditor) {
            fTextEditor = sqlEditor;
            this.fDocumentProvider = fDocumentProvider;
        }

        public void setInput(IEditorInput input) {
            this.fInput = input;
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
                    // TODO Auto-generated method stub
                    return new Segment[] { new Segment(4, 6),
                            new Segment(50, 6) };
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
                Segment segment = (Segment) ((IStructuredSelection) selection)
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

    private MyContentOutlinePage fOutlinePage;

    public SQLEditor() {
        super();
        setSourceViewerConfiguration(new SQLSourceViewerConfiguration(getSharedColors(), getPreferenceStore()));
        setDocumentProvider(new SQLDocumentProvider());
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
}
