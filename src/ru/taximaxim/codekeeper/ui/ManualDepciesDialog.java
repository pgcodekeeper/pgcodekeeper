package ru.taximaxim.codekeeper.ui;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class ManualDepciesDialog extends TrayDialog {

    private final List<Entry<PgStatement, PgStatement>> depcies;
    private final List<PgStatement> objects;
    
    private ComboViewer cmbDependants, cmbDependencies;
    private Button btnAdd;
    private ListViewer listDepcies;
    private Button btnRemove;
    
    public List<Entry<PgStatement, PgStatement>> getDepciesList() {
        return depcies;
    }
    
    public ManualDepciesDialog(Shell shell,
            List<Entry<PgStatement, PgStatement>> depcies, List<PgStatement> objects) {
        super(shell);

        this.depcies = new LinkedList<>(depcies);
        this.objects = new ArrayList<>(objects);
        
        Collections.sort(this.objects, new Comparator<PgStatement>() {
            
            @Override
            public int compare(PgStatement o1, PgStatement o2) {
                return o1.getQualifiedName().compareTo(o2.getQualifiedName());
            }
        });
        
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        parent = (Composite) super.createDialogArea(parent);
        
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout(2, true);
        gl.marginHeight = gl.marginWidth = 0;
        container.setLayout(gl);
        
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        Group grpSelectors = new Group(container, SWT.NONE);
        grpSelectors.setLayout(new GridLayout(2, false));
        grpSelectors.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_object);
        
        cmbDependants = new ComboViewer(grpSelectors, SWT.DROP_DOWN | SWT.READ_ONLY);
        cmbDependants.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbDependants.setContentProvider(new ArrayContentProvider());
        cmbDependants.setLabelProvider(new PgStatementLabelProvider());
        cmbDependants.addSelectionChangedListener(new ComboSelectionListener());
        
        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_depends_on);
        
        cmbDependencies = new ComboViewer(grpSelectors, SWT.DROP_DOWN | SWT.READ_ONLY);
        cmbDependencies.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbDependencies.setContentProvider(new ArrayContentProvider());
        cmbDependencies.setLabelProvider(new PgStatementLabelProvider());
        cmbDependencies.addSelectionChangedListener(new ComboSelectionListener());
        
        btnAdd = new Button(grpSelectors, SWT.PUSH);
        btnAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false, 2, 1));
        btnAdd.setText("\u2192"); //$NON-NLS-1$
        btnAdd.setEnabled(false);
        btnAdd.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                depcies.add(getComboSelections());
                setInput();
            }
        });
        
        Group grpList = new Group(container, SWT.NONE);
        grpList.setLayout(new GridLayout());
        grpList.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(grpList, SWT.NONE).setText(Messages.manualDepciesDialog_dependant_dependency);
        
        listDepcies = new ListViewer(grpList);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 200;
        gd.heightHint = 400;
        listDepcies.getList().setLayoutData(gd);
        
        listDepcies.setContentProvider(new IStructuredContentProvider() {
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
            
            @Override
            public void dispose() {
            }
            
            @Override
            public Object[] getElements(Object input) {
                return depcies.toArray();
            }
        });
        listDepcies.setLabelProvider(new ILabelProvider() {
            
            @Override
            public void removeListener(ILabelProviderListener listener) {
            }
            
            @Override
            public boolean isLabelProperty(Object element, String property) {
                return false;
            }
            
            @Override
            public void dispose() {
            }
            
            @Override
            public void addListener(ILabelProviderListener listener) {
            }
            
            @Override
            public String getText(Object element) {
                @SuppressWarnings("unchecked")
                Entry<PgStatement, PgStatement> e = (Entry<PgStatement, PgStatement>) element;
                return e.getKey().getQualifiedName() + " \u2192 "  //$NON-NLS-1$
                        + e.getValue().getQualifiedName();
            }
            
            @Override
            public Image getImage(Object element) {
                return null;
            }
        });
        listDepcies.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                btnRemove.setEnabled(!event.getSelection().isEmpty());
            }
        });
        
        btnRemove = new Button(grpList, SWT.PUSH);
        btnRemove.setText(Messages.manualDepciesDialog_remove);
        btnRemove.setEnabled(false);
        btnRemove.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean removedStuff = false;
                for (Object selectionElement : 
                    ((IStructuredSelection) listDepcies.getSelection()).toList()) {
                    @SuppressWarnings("unchecked")
                    Entry<PgStatement, PgStatement> toRemove = 
                            (Entry<PgStatement, PgStatement>) selectionElement;
                    
                    Iterator<Entry<PgStatement, PgStatement>> it = depcies.iterator();
                    while (it.hasNext()) {
                        Entry<PgStatement, PgStatement> el = it.next();
                        if (toRemove.getKey().compare(el.getKey())
                                && toRemove.getValue().compare(el.getValue())) {
                            it.remove();
                            removedStuff = true;
                        }
                    }
                }
                if (removedStuff) {
                    setInput();
                }
            }
        });
        
        cmbDependants.setInput(objects);
        cmbDependencies.setInput(objects);
        setInput();
        
        return parent;
    }
    
    private void setInput() {
        listDepcies.setInput(depcies);
    }
    
    private Entry<PgStatement, PgStatement> getComboSelections() {
        IStructuredSelection dependantSel, dependencySel;
        dependantSel = (IStructuredSelection) cmbDependants.getSelection();
        dependencySel = (IStructuredSelection) cmbDependencies.getSelection();
        
        return new AbstractMap.SimpleEntry<PgStatement, PgStatement>(
                (PgStatement) dependantSel.getFirstElement(),
                (PgStatement) dependencySel.getFirstElement());
    }
    
    private class ComboSelectionListener implements ISelectionChangedListener {
        
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            Entry<PgStatement, PgStatement> selection = 
                    ManualDepciesDialog.this.getComboSelections();
            btnAdd.setEnabled(
                    selection.getKey() != null 
                    && selection.getValue() != null
                    && !selection.getKey().compare(selection.getValue()));
        }
    }
}

class PgStatementLabelProvider implements ILabelProvider {
    
    @Override
    public void addListener(ILabelProviderListener listener) {
    }
    
    @Override
    public void removeListener(ILabelProviderListener listener) {   
    }
    
    @Override
    public void dispose() {
    }
    
    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }
    
    @Override
    public Image getImage(Object element) {
        return null;
    }
    
    @Override
    public String getText(Object element) {
        return ((PgStatement) element).getQualifiedName();
    }
}
