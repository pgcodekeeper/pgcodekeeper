package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;

// разобраться с вычислением частей документа и выводить части в аутлайн
public final class SQLEditorContentOutlinePage extends ContentOutlinePage {
    private IEditorInput fInput;
    private AbstractDecoratedTextEditor fTextEditor;
    private IDocumentProvider fDocumentProvider;
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
            
            private LocalResourceManager lrm = new LocalResourceManager(
                    JFaceResources.getResources(), getControl());
            
            @Override
            public Image getImage(Object element) {
                if (element instanceof Segments) {
                    Segments seg = (Segments)element;
                    ImageDescriptor iObj = ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    FILE.ICONPGADMIN 
                                    + seg.getType().toString().toLowerCase() 
                                    + ".png")); //$NON-NLS-1$
                    return lrm.createImage(iObj);
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

class Segments extends Position {
    private String name;
    private DbObjType type;
    private StatementActions action;

    /**
     * Creates a new segment covering the given range.
     *
     * @param offset the offset of the segment
     * @param length the length of the segment
     */
    public Segments(PgObjLocation loc) {
        super(loc.getOffset(), loc.getObjLength());
        this.name = loc.getObjName();
        this.type = loc.getObjType();
        this.action = loc.getAction();
    }
    
    public DbObjType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return action.toString() + ' ' + name;
    }
}
