package ru.taximaxim.codekeeper.ui.parts;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectPartDescriptor {
	
	private PgDbProject proj;
	
	private Text txt;
	
	private TreeViewer treeDb;
	
	public PgDbProject getProject() {
		return proj;
	}
	
	@PostConstruct
	public void postConstruct(Composite parent, MPart part,
			EMenuService menuService, EPartService partService)
					throws IOException {
		proj = new PgDbProject(part.getPersistedState()
				.get(UIConsts.PROJ_PART_PERSISTED_ID));
		proj.load();
		
		part.setLabel(proj.getProjectName());
		
		SashForm sash = new SashForm(parent, SWT.HORIZONTAL);
		
		Composite containerTree = new Composite(sash, SWT.NONE);
		containerTree.setLayout(new FillLayout());
		
		treeDb = new TreeViewer(containerTree);
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
		treeDb.setInput(proj.getProjectSchemaDir());
		
		treeDb.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				TreePath path = ((TreeSelection) event.getSelection()).getPaths()[0];
				File f = (File) path.getLastSegment();
				
				if(f.isDirectory()) {
					TreeViewer viewer = (TreeViewer)event.getViewer();
					viewer.setExpandedState(path, !viewer.getExpandedState(path));
					viewer.refresh();
					return;
				}
				try {
					txt.setText(new String(Files.readAllBytes(f.toPath()),
							proj.getString(UIConsts.PROJ_PREF_ENCODING)));
				} catch(IOException | UnsupportedCharsetException ex) {
					throw new IllegalStateException("Exception while reading file", ex);
				}
			}
		});
		
		menuService.registerContextMenu(treeDb.getControl(),
				"ru.taximaxim.codekeeper.ui.popupmenu.project");
		
		Composite containerRight = new Composite(sash, SWT.NONE);
		containerRight.setLayout(new FillLayout());
		
		txt = new Text(containerRight, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY
				| SWT.H_SCROLL | SWT.V_SCROLL);
		txt.setFont(new Font(parent.getShell().getDisplay(), new FontData[] {
			new FontData("Monospace", 10, SWT.NORMAL),
			new FontData("Courier New", 10, SWT.NORMAL),
			new FontData("Courier", 10, SWT.NORMAL)
		}));
		
		sash.setWeights(new int[] { 2000, 8000 });
	}
	
	public void reload() {
		treeDb.setInput(proj.getProjectSchemaDir());
		txt.setText("");
	}
}
