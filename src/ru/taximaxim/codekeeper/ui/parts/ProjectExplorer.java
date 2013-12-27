 
package ru.taximaxim.codekeeper.ui.parts;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;


public class ProjectExplorer {
    
    @Inject
    private PgDbProject proj;
    
    @Inject
    private MPart part;
    @Inject
    private EModelService model;
    @Inject
    private EPartService partService;
    @Inject
    private MApplication app;
    
    private TreeViewer treeDb;
    
    @PostConstruct
    private void postConstruct(Composite parent, EMenuService menuService)
            throws IOException {
        parent.setLayout(new FillLayout());
        
        treeDb = new TreeViewer(parent, SWT.BORDER);
        treeDb.setContentProvider(new ITreeContentProvider() {
            
            private final List<String> ignoredFiles = Arrays.asList(
                    new String[] {
                            ".svn",
                            "listing.lst"
                    });
            
            private final FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return !ignoredFiles.contains(name);
                }
            };
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
            
            @Override
            public void dispose() {
            }
            
            @Override
            public boolean hasChildren(Object element) {
                File f = (File) element;
                return f.isDirectory() && (f.list().length != 0);
            }
            
            @Override
            public Object getParent(Object element) {
                return ((File) element).getParentFile();
            }
            
            @Override
            public Object[] getElements(Object inputElement) {
                File[] files = ((File) inputElement).listFiles(filter);
                Arrays.sort(files, new Comparator<File>() {
                    @Override
                    public int compare(File o1, File o2) {
                        if(o1.isDirectory()) {
                            return o2.isDirectory()? o1.compareTo(o2) : -1;
                        } else if(o2.isDirectory()) {
                            return 1;
                        } else {
                            return o1.compareTo(o2);
                        }
                    }
                });
                return files;
            }
            
            @Override
            public Object[] getChildren(Object parentElement) {
                if(((File) parentElement).isDirectory()) {
                    return this.getElements(parentElement);
                }
                
                return null;
            }
        });
        treeDb.setLabelProvider(new LabelProvider() {
            
            private final Image imgFolder = ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            UIConsts.FILENAME_ICONDIR)).createImage();
            
            private final Image imgFile = ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            UIConsts.FILENAME_ICONFILE)).createImage();
            
            @Override
            public String getText(Object element) {
                return ((File) element).getName();
            }
            
            @Override
            public Image getImage(Object element) {
                if(((File) element).isDirectory()) {
                    return imgFolder;
                }

                return imgFile;
            }
        });
        treeDb.addDoubleClickListener(new IDoubleClickListener() {
            
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TreePath path = ((TreeSelection) event.getSelection()).getPaths()[0];
                final File f = (File) path.getLastSegment();
                
                if(f.isDirectory()) {
                    TreeViewer viewer = (TreeViewer)event.getViewer();
                    viewer.setExpandedState(path, !viewer.getExpandedState(path));
                    viewer.refresh();
                } else {
                    SqlEditorDescr.openNew(f, model, partService, app);
                }
            }
        });
        menuService.registerContextMenu(treeDb.getControl(),
                UIConsts.PART_PROJXP_TREE_POPUP);
        
        changeProject(proj);
    }
    
    @Inject
    private void changeProject(PgDbProject proj) throws IOException {
        if(treeDb != null) {
            File treeInput = null;
            
            if(proj != null) {
                proj.load();
                treeInput = proj.getProjectSchemaDir();
            }
            
            treeDb.setInput(treeInput);
        }
        
        String partLabel = "Project Explorer";
        if(proj != null) {
            partLabel += " - " + proj.getProjectName();
        }
        part.setLabel(partLabel);
    }
}