package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

public class SQLEditor extends AbstractDecoratedTextEditor implements IResourceChangeListener {

    static final String CONTENT_ASSIST = "ContentAssist"; //$NON-NLS-1$

    private Composite parentComposite;
    private SQLEditorContentOutlinePage fOutlinePage;
    private Image errorTitleImage;
    private PgDbParser parser;

    private final Listener list = e -> {
        if (parentComposite == null) {
            return;
        }
        UiSync.exec(parentComposite, () -> {
            if (fOutlinePage != null) {
                Control c = fOutlinePage.getControl();
                if (c != null && !c.isDisposed()) {
                    fOutlinePage.externalRefresh();
                }
            }
        });
    };

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IContentOutlinePage.class.isAssignableFrom(adapter) && fOutlinePage != null) {
            return adapter.cast(fOutlinePage);
        }
        return super.getAdapter(adapter);
    }

    @Override
    public void createPartControl(Composite parent) {
        parentComposite = parent;
        super.createPartControl(parent);
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        IResource res = ResourceUtil.getResource(getEditorInput());
        try {
            if (!isProject(res)) {
                refreshParser(getParser(), res, progressMonitor);
            }
        } catch (IOException | InterruptedException | CoreException ex) {
            Log.log(ex);
        }
    }

    @Override
    protected void createActions() {
        super.createActions();
        ResourceBundle bundle = ResourceBundle.getBundle(Messages.getBundleName());
        ContentAssistAction action = new ContentAssistAction(bundle, "contentAssist.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction(CONTENT_ASSIST, action);
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                getSharedColors(), getPreferenceStore(), this));
        setDocumentProvider(new SQLEditorCommonDocumentProvider());

        super.init(site, input);

        try {
            parser = initParser();
        } catch (InterruptedException | IOException | CoreException ex) {
            throw new PartInitException(ex.getLocalizedMessage(), ex);
        }
        parser.addListener(list);

        fOutlinePage = new SQLEditorContentOutlinePage(this);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
    }

    private PgDbParser initParser() throws InterruptedException, IOException, CoreException {
        IEditorInput in = getEditorInput();

        IResource res = ResourceUtil.getResource(in);
        if (isProject(res)) {
            return PgDbParser.getParser(res.getProject());
        }

        PgDbParser parser = new PgDbParser();
        if (refreshParser(parser, res, null)) {
            return parser;
        }

        throw new PartInitException("Unknown editor input: " + in); //$NON-NLS-1$
    }

    /**
     * Use only for non-project parsers
     * @param {@link IFileEditorInput} {@link IResource} or null
     * @return true if refresh was triggered successfully
     */
    private boolean refreshParser(PgDbParser parser, IResource res, IProgressMonitor monitor)
            throws InterruptedException, IOException, CoreException {
        if (res instanceof IFile) {
            parser.getObjFromProjFile((IFile) res, monitor);
            return true;
        }

        IEditorInput in = getEditorInput();
        if (in instanceof IURIEditorInput) {
            IURIEditorInput uri = (IURIEditorInput) in;
            IDocument document = getDocumentProvider().getDocument(getEditorInput());
            InputStream stream = new ByteArrayInputStream(document.get().getBytes(StandardCharsets.UTF_8));
            parser.fillRefsFromInputStream(stream, uri.getURI().toString(), monitor);
            return true;
        }
        return false;
    }

    /**
     * @param {@link IFileEditorInput} {@link IResource} or null
     * @throws CoreException
     */
    private boolean isProject(IResource res) throws CoreException {
        return res == null ? false : res.getProject().hasNature(NATURE.ID)
                && PgUIDumpLoader.isProjectPath(res.getProjectRelativePath());
    }

    PgDbParser getParser() {
        return parser;
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        if (parser != null) {
            parser.removeListener(list);
        }
        if (errorTitleImage != null) {
            errorTitleImage.dispose();
        }
        super.dispose();
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        IResource file = ResourceUtil.getResource(getEditorInput());
        IResourceDelta delta = event.getDelta();
        if (delta != null && file != null) {
            IResourceDelta child = delta.findMember(file.getFullPath());
            if (child != null && (child.getFlags() & IResourceDelta.MARKERS) != 0) {
                UiSync.exec(parentComposite, new Runnable() {
                    @Override
                    public void run() {
                        if (!parentComposite.isDisposed()) {
                            firePropertyChange(IWorkbenchPart.PROP_TITLE);
                        }
                    }
                });
            }
        }
    }

    @Override
    public Image getTitleImage() {
        Image image = super.getTitleImage();
        try {
            IEditorInput input = getEditorInput();
            IResource file = ResourceUtil.getResource(input);
            if (input.exists() && file != null
                    && file.findMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO).length > 0) {
                if (errorTitleImage == null) {
                    errorTitleImage = new DecorationOverlayIcon(image,
                            PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
                                    ISharedImages.IMG_DEC_FIELD_ERROR), IDecoration.BOTTOM_LEFT)
                            .createImage();
                }
                return errorTitleImage;
            }
        } catch (CoreException e) {
            Log.log(e);
        }
        return image;
    }
}
