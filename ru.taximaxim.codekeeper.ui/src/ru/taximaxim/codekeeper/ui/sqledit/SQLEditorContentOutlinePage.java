package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

// разобраться с вычислением частей документа и выводить части в аутлайн
public final class SQLEditorContentOutlinePage extends ContentOutlinePage {
    private IEditorInput fInput;
    private final AbstractDecoratedTextEditor fTextEditor;
    private final IDocumentProvider fDocumentProvider;
    private TreeViewer viewer;

    public SQLEditorContentOutlinePage(IDocumentProvider fDocumentProvider,
            AbstractDecoratedTextEditor sqlEditor) {
        fTextEditor = sqlEditor;
        this.fDocumentProvider = fDocumentProvider;
    }

    public void externalRefresh() {
        if (viewer != null) {
            viewer.refresh();
        }
    }

    public void setInput(IEditorInput input) {
        this.fInput = input;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        viewer = getTreeViewer();
        viewer.setContentProvider(new ITreeContentProvider() {

            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
                if (newInput != null) {
                    IDocument document = fDocumentProvider.getDocument(newInput);
                    if (document != null) {
                        //document.addPositionCategory("SEGMENTS");
                        // document.addPositionUpdater(fPositionUpdater);
                        // parse(document);
                    }
                }
            }

            @Override
            public void dispose() {

            }

            @Override
            public Object[] getElements(Object inputElement) {
                List<Segments> segments = new ArrayList<>();
                List<PgObjLocation> refs = new ArrayList<>();
                PgDbParser parser = null;
                if (fTextEditor instanceof SQLEditor) {
                    parser  = ((SQLEditor)fTextEditor).getParser();
                }
                if (parser == null) {
                    return segments.toArray();
                }
                if (inputElement instanceof FileEditorInput) {
                    Path inputPath = ((FileEditorInput)inputElement).
                            getFile().getLocation().toFile().toPath();
                    refs = parser.getObjsForPath(inputPath);
                }
                if (inputElement instanceof DepcyFromPSQLOutput) {
                    refs = parser.getAllObjReferences();
                }
                for (PgObjLocation loc : refs) {
                    if (loc.getAction() != StatementActions.NONE) {
                        segments.add(new Segments(loc));
                    }
                }
                return segments.toArray();
            }

            @Override
            public Object[] getChildren(Object parentElement) {
                return null;
            }

            @Override
            public Object getParent(Object element) {
                return null;
            }

            @Override
            public boolean hasChildren(Object element) {
                return false;
            }
        });

        viewer.setLabelProvider(new LabelProvider() {

            @Override
            public Image getImage(Object element) {
                if (element instanceof Segments) {
                    Segments seg = (Segments)element;
                    return Activator.getDbObjImage(seg.getType());
                }
                return super.getImage(element);
            }
        });
        viewer.addSelectionChangedListener(this);

        if (fInput != null) {
            viewer.setInput(fInput);
        }
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        super.selectionChanged(event);

        ISelection selection = event.getSelection();
        if (selection.isEmpty()) {
            fTextEditor.resetHighlightRange();
        }
        else {
            Segments segment = (Segments) ((IStructuredSelection) selection)
                    .getFirstElement();
            int start = segment.getOffset();
            int length = segment.getLength();
            try {
                fTextEditor.setHighlightRange(start, length, true);
                fTextEditor.selectAndReveal(start, length);
            } catch (IllegalArgumentException x) {
                fTextEditor.resetHighlightRange();
            }
        }
    }
}
