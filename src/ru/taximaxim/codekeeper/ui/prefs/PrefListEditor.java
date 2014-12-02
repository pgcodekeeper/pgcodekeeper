package ru.taximaxim.codekeeper.ui.prefs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PrefListEditor extends Composite {
    private ListViewer listViewerObjs;
    private List<String> objsList = new LinkedList<>();
    private final boolean doSorting;
    
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
        final Text txtNewValue = new Text(parent, SWT.BORDER);
        txtNewValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        Button btnAdd = new Button(parent, SWT.PUSH);
        btnAdd.setText(Messages.add);
        btnAdd.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                String newValue = txtNewValue.getText().trim();
                if (!newValue.isEmpty() && !objsList.contains(newValue)) {
                    objsList.add(0, newValue);
                    txtNewValue.setText(""); //$NON-NLS-1$
                    listViewerObjs.refresh();
                }
            }
        });
        
        listViewerObjs = new ListViewer(parent);
        listViewerObjs.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        listViewerObjs.setContentProvider(new ArrayContentProvider());
        listViewerObjs.setLabelProvider(new LabelProvider());

        if (doSorting){
            listViewerObjs.setSorter(new ViewerSorter());
        }
        
        Button btnDelete = new Button(parent, SWT.PUSH);
        btnDelete.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false, 2, 1));
        btnDelete.setText(Messages.delete);
        btnDelete.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = 
                        (IStructuredSelection) listViewerObjs.getSelection();
                String objToRemove = (String) selection.getFirstElement();
                if (objToRemove == null) {
                    return;
                }

                objsList.remove(objToRemove);
                listViewerObjs.refresh();
            }
        });
        
    }
    
    public List<String> getList(){
        return objsList;
    }
    
    public void setInputList(List<String> list){
        objsList = list;
        listViewerObjs.setInput(objsList);
        listViewerObjs.refresh();
    }
}
