package ru.taximaxim.codekeeper.ui.prefs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PrefListEditor extends Composite {
    private ListViewer listViewerObjs;
    private LinkedList<String> objsList = new LinkedList<>();
    private final boolean doSorting;
    private Button upBtn;
    private Button downBtn;
    private Button btnDelete;
    private Button btnAdd;
    private String newVal = "";
    private List<Listener> listeners = new ArrayList<>();
    
    public PrefListEditor(Composite parent, boolean doSorting) {
        super(parent, SWT.NONE);
        
        this.doSorting = doSorting;
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        this.setLayout(gridLayout);
        this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        populateUiContent(this);
    }
    
    private void populateUiContent(Composite parent){
		LocalResourceManager lrm = new LocalResourceManager(
				JFaceResources.getResources(), this);
		final Text txtNewValue = new Text(parent, SWT.BORDER);
		txtNewValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		btnAdd = new Button(parent, SWT.PUSH);
		btnAdd.setToolTipText(Messages.add);
		btnAdd.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
				.getContext().getBundle().getResource(FILE.ICONADD))));
		btnAdd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String newValue = txtNewValue.getText().trim();
				if (!newValue.isEmpty() && !objsList.contains(newValue)) {
					objsList.add(0, newValue);
					newVal = newValue; 
					txtNewValue.setText(""); //$NON-NLS-1$
					listViewerObjs.refresh();
				} else {
					newVal = "";
				}
			}
		});
        listViewerObjs = new ListViewer(parent);
        listViewerObjs.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        listViewerObjs.setContentProvider(new ArrayContentProvider());
        listViewerObjs.setLabelProvider(new LabelProvider());

        Composite comp = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(3, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        comp.setLayout(gridLayout);
        comp.setLayoutData(new GridData());
        
        btnDelete = new Button(comp, SWT.PUSH);
        btnDelete.setLayoutData(new GridData());
        btnDelete.setToolTipText(Messages.delete);
        btnDelete.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONDEL))));
        btnDelete.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                deleteSelected();
            }
        });
        
        upBtn = new Button(comp, SWT.PUSH);
        upBtn.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONUP))));
        upBtn.setLayoutData(new GridData(GridData.END));
        upBtn.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (listViewerObjs.getSelection().isEmpty()) {
                    return;
                }
                IStructuredSelection selection = (IStructuredSelection) listViewerObjs
                        .getSelection();
                String sel = (String) selection.getFirstElement();
                ListIterator<String> it = objsList.listIterator();
                while (it.hasNext()) {
                    String match = it.next();
                    if (match == sel) {
                        it.previous();
                        if (it.hasPrevious()) {
                            String prev = it.previous();
                            it.set(sel);
                            it.next();
                            it.next();
                            it.set(prev);
                            listViewerObjs.refresh();
                        }
                        return;
                    }
                }
            }
        });
        
        downBtn = new Button(comp, SWT.PUSH);
        downBtn.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONDOWN))));
        downBtn.setLayoutData(new GridData(GridData.END));
        downBtn.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (listViewerObjs.getSelection().isEmpty()) {
                    return;
                }
                IStructuredSelection selection = (IStructuredSelection) listViewerObjs
                        .getSelection();
                String sel = (String) selection.getFirstElement();
                ListIterator<String> it = objsList.listIterator();
                while (it.hasNext()) {
                    String match = it.next();
                    if (match == sel) {
                        if (it.hasNext()) {
                            String next = it.next();
                            it.set(sel);
                            it.previous();
                            it.previous();
                            it.set(next);
                            listViewerObjs.refresh();
                        }
                        return;
                    }
                }
            }
        });
        if (doSorting){
            listViewerObjs.setSorter(new ViewerSorter());
            upBtn.setEnabled(false);
            downBtn.setEnabled(false);
        }
    }
    
    public Object deleteSelected() {
		IStructuredSelection selection = 
                (IStructuredSelection) listViewerObjs.getSelection();
        Object objToRemove = selection.getFirstElement();
        if (objToRemove == null) {
            return null;
        }

        objsList.remove(objToRemove);
        listViewerObjs.refresh();
        return objToRemove;
	}
    
    public Object getSelected() {
    	return ((IStructuredSelection)listViewerObjs.getSelection()).getFirstElement();
    }
    
    public List<String> getList(){
        return objsList;
    }
    
    public ListViewer getListViewer() {
        return listViewerObjs;
    }
    
    public Button getDelDtn() {
    	return btnDelete;
    }
    
    public Button getAddBtn() {
    	return btnAdd;
    }
    
    public void setInputList(LinkedList<String> list){
        objsList = list;
        listViewerObjs.setInput(objsList);
        listViewerObjs.refresh();
    }

	public void select(String name) {
		listViewerObjs.setSelection(new StructuredSelection(name));
	}
	
	public void select(int index) {
		listViewerObjs.setSelection(new StructuredSelection(objsList.get(index)));
	}

	public String getNewEntry() {
		return newVal;
	}
}
