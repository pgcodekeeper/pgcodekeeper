package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
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

public class SQLEditor extends AbstractDecoratedTextEditor implements IResourceChangeListener {

    public static final String ID = "ru.taximaxim.codekeeper.ui.SQLEditor"; //$NON-NLS-1$
    static final String CONTENT_ASSIST= "ContentAssist"; //$NON-NLS-1$

    private Composite parentComposite;
    private SQLEditorContentOutlinePage fOutlinePage;
    private IEditorInput input;
    private Image errorTitleImage;

    private final Listener list = new Listener() {

        @Override
        public void handleEvent(Event event) {
            UiSync.exec(parentComposite, new Runnable() {

                @Override
                public void run() {
                    if (fOutlinePage != null) {
                        Control c = fOutlinePage.getControl();
                        if (c != null && !c.isDisposed()) {
                            fOutlinePage.externalRefresh();
                        }
                    }
                }
            });
        }
    };


    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IContentOutlinePage.class.isAssignableFrom(adapter)) {
            if (fOutlinePage != null) {
                return adapter.cast(fOutlinePage);
            }
        }
        return super.getAdapter(adapter);
    }

    @Override
    public void createPartControl(Composite parent) {
        parentComposite = parent;
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
        PgDbParser parser = getParser();
        if (parser != null) {
            parser.addListener(list);
            fOutlinePage= new SQLEditorContentOutlinePage(getDocumentProvider(), this);
            fOutlinePage.setInput(getEditorInput());
        }
        super.createPartControl(parent);
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
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSourceViewerConfiguration(new SQLEditorSourceViewerConfiguration(
                getSharedColors(), getPreferenceStore()));

        this.input = input;
        if (input instanceof IFileEditorInput) {
            setDocumentProvider(new SQLEditorFileDocumentProvider());
        } else if (input instanceof IStorageEditorInput) {
            setDocumentProvider(new SQLEditorStorageDocumentProvider());
        }
        super.init(site, input);
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
                Log.log(e);
            }
        }
        return null;
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        PgDbParser parser = getParser();
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
            IResource file = ResourceUtil.getResource(getEditorInput());
            if (file != null && file.findMarkers(MARKER.ERROR, false, IResource.DEPTH_ZERO).length > 0) {
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
