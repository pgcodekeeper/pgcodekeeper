package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class ProjectEditor extends EditorPart {

    public static final String ID = "ru.taximaxim.codekeeper.ui.projecteditor";
    private ProjectEditorInput input;
    private IProject project;
    private boolean isPageModified;
    
    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        if (!(input instanceof ProjectEditorInput)) {
            throw new RuntimeException("Wrong input");
        }
        this.input = (ProjectEditorInput)input;
        setSite(site);
        setInput(input);
        this.project = ResourcesPlugin.getWorkspace().getRoot()
                .getProject(this.input.getProjectName());
        setPartName("Project: " + project.getName());
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorUpdater);
    }
    
    @Override
    public void createPartControl(Composite parent) {
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        parent.setLayout(layout);
        new Label(parent, SWT.NONE).setText(project.getName());
        IEclipsePreferences prefs = new ProjectScope(project)
                .getNode(UIConsts.PLUGIN_ID.THIS);
        new Label(parent, SWT.NONE).setText("Path to REPO: "
                + prefs.get(UIConsts.PROJ_PREF.REPO_ROOT_PATH, ""));
    }
    
    private IResourceChangeListener editorUpdater = new IResourceChangeListener() {
        public void resourceChanged(IResourceChangeEvent event) {
            switch (event.getType()) {
                case IResourceChangeEvent.PRE_CLOSE:
                case IResourceChangeEvent.PRE_DELETE:
                    handlerCloseProject(event);
                    break;
                case IResourceChangeEvent.POST_CHANGE:
                    handleChangeProject(event);
                    break;
                default:
                    break;
            }
        }
    };
    
    private void handlerCloseProject(IResourceChangeEvent event) {
        final IResource closingProject = event.getResource();
        Display.getDefault().asyncExec(new Runnable(){
            public void run() {
                for (IWorkbenchPage page : getSite().getWorkbenchWindow().getPages()) {
                    ProjectEditorInput editorInput = 
                            (ProjectEditorInput) ProjectEditor.this.getEditorInput();
                    if (editorInput.getName().equals(closingProject.getName()))
                        page.closeEditor(page.findEditor(editorInput), true);
                }
            }
        });
    }
    
    private void handleChangeProject(IResourceChangeEvent event) {
        IResourceDelta rootDelta = event.getDelta();
        IResourceDelta thisproj = rootDelta.findMember(project.getFullPath());
        if (thisproj != null) {
            // update editor somehow
            isPageModified = true;
            firePropertyChange(IEditorPart.PROP_DIRTY);
        }
    }   
    
    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorUpdater);
        super.dispose();
    }
    
    @Override
    public void doSave(IProgressMonitor monitor) {
        isPageModified = false;
        firePropertyChange(IEditorPart.PROP_DIRTY);
    }

    @Override
    public void doSaveAs() {
        // not available
    }

    @Override
    public boolean isDirty() {
        return isPageModified;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }
}
