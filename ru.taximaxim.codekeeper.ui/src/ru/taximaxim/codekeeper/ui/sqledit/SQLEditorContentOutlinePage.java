package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public final class SQLEditorContentOutlinePage extends ContentOutlinePage {
    private IEditorInput fInput;
    private final SQLEditor sqlEditor;
    private final IDocumentProvider fDocumentProvider;
    private TreeViewer viewer;

    public SQLEditorContentOutlinePage(IDocumentProvider fDocumentProvider,
            SQLEditor sqlEditor) {
        this.sqlEditor = sqlEditor;
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

    public void update() {
        if (fInput != null) {
            viewer.setInput(fInput);
        }
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        viewer = getTreeViewer();
        viewer.setContentProvider(new ContentProvider());
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

        update();
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        super.selectionChanged(event);

        ISelection selection = event.getSelection();
        if (selection.isEmpty()) {
            sqlEditor.resetHighlightRange();
        } else {
            Segments segment = (Segments) ((IStructuredSelection) selection)
                    .getFirstElement();
            int start = segment.getOffset();
            int length = segment.getLength();
            try {
                sqlEditor.setHighlightRange(start, length, true);
                sqlEditor.selectAndReveal(start, length);
            } catch (IllegalArgumentException x) {
                sqlEditor.resetHighlightRange();
            }
        }
    }

    private class ContentProvider implements ITreeContentProvider {
        private List<Segments> segments;

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            segments = Collections.emptyList();
            if (newInput != null) {
                IDocument document = fDocumentProvider.getDocument(newInput);
                if (document != null) {
                    parse(document);
                }
            }
        }

        private void parse(IDocument document) {
            InputStream stream = new ByteArrayInputStream(document.get().getBytes(StandardCharsets.UTF_8));
            List<PgObjLocation> refs = new ArrayList<>();
            String filename = fInput.getName();
            try {
                PgDbParser parser = sqlEditor.getParser();
                parser.updateRefsFromInputStream(stream, filename);
                refs = parser.getObjReferences().get(filename);
                if (refs == null) {
                    return;
                }
                if (sqlEditor instanceof RollOnEditor) {
                    ((RollOnEditor) sqlEditor).setLineBackground();
                }
            } catch (InterruptedException | IOException | LicenseException e) {
                Log.log(Log.LOG_ERROR, "Error while parse document: " + filename); //$NON-NLS-1$
            }
            segments = new ArrayList<>(refs.size());
            for (PgObjLocation loc : refs) {
                if (loc.getAction() != StatementActions.NONE) {
                    segments.add(new Segments(loc));
                }
            }
        }

        @Override
        public void dispose() {
            // no impl
        }

        @Override
        public Object[] getElements(Object inputElement) {
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
    }
}