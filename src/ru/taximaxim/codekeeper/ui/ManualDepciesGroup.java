package ru.taximaxim.codekeeper.ui;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jface.fieldassist.ComboContentAdapter;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class ManualDepciesGroup extends Group{
    
    private final List<Entry<PgStatement, PgStatement>> depcies;
    private final String[] names;
    private final PgStatement[] objects;
    
    private ComboViewer cmbDependants, cmbDependencies;
    private Button btnAdd;
    private ListViewer listDepcies;
    private Button btnRemove;

    public ManualDepciesGroup(Composite parent, int style,
            List<Entry<PgStatement, PgStatement>> dependencies, 
            List<PgStatement> objectsSource, String groupName) {
        super(parent, style);
        
        this.depcies = new LinkedList<>(dependencies);
        this.objects = objectsSource.toArray(new PgStatement[objectsSource.size()]);
        
        Arrays.sort(this.objects, new Comparator<PgStatement>() {

            @Override
            public int compare(PgStatement o1, PgStatement o2) {
                return o1.getQualifiedName().compareTo(o2.getQualifiedName());
            }
        });

        this.names = new String[this.objects.length];
        for (int i = 0; i < this.objects.length; ++i) {
            names[i] = this.objects[i].getQualifiedName();
        }
        
        setLayout(new GridLayout(2, true));
        setLayoutData(new GridData(GridData.FILL_BOTH));
        this.setText(groupName);
        
        Group grpSelectors = new Group(this, SWT.NONE);
        grpSelectors.setLayout(new GridLayout(2, false));
        grpSelectors.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_object);
        
        cmbDependants = new ComboViewer(grpSelectors, SWT.DROP_DOWN);
        cmbDependants.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbDependants.setContentProvider(new ArrayContentProvider());
        cmbDependants.setLabelProvider(new PgStatementLabelProvider());
        
        cmbDependants.getCombo().addListener(SWT.Traverse, new ComboReturnKeyListener());
        cmbDependants.getCombo().addModifyListener(new ComboModifyListener());
        
        new MyAutoCompleteField(cmbDependants.getCombo(), new ComboContentAdapter(), names);
        
        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_depends_on);
        
        cmbDependencies = new ComboViewer(grpSelectors, SWT.DROP_DOWN);
        cmbDependencies.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbDependencies.setContentProvider(new ArrayContentProvider());
        cmbDependencies.setLabelProvider(new PgStatementLabelProvider());
        
        cmbDependencies.getCombo().addListener(SWT.Traverse, new ComboReturnKeyListener());
        cmbDependencies.getCombo().addModifyListener(new ComboModifyListener());
        
        new MyAutoCompleteField(cmbDependencies.getCombo(), new ComboContentAdapter(), names);
        
        btnAdd = new Button(grpSelectors, SWT.PUSH);
        btnAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false, 2, 1));
        btnAdd.setText(Messages.manualDepciesDialog_add);
        btnAdd.setEnabled(false);
        btnAdd.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                depcies.add(getComboSelections());
                setInput();
            }
        });
        
        Group grpList = new Group(this, SWT.NONE);
        grpList.setLayout(new GridLayout());
        grpList.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(grpList, SWT.NONE).setText(Messages.manualDepciesDialog_dependant_dependency);
        
        listDepcies = new ListViewer(grpList);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 200;
        gd.heightHint = 200;
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
                return e.getKey().getQualifiedName() + " \u2192 " //$NON-NLS-1$
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
        
        cmbDependants.setInput(objectsSource);
        cmbDependencies.setInput(objectsSource);
        setInput();
    }

    public List<Entry<PgStatement, PgStatement>> getDepciesList() {
        return depcies;
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
    
    @Override
    protected void checkSubclass() {
        // allow subclassing, we just use Group as a Composite
        // ~should~ be fine
    }
    
    private class ComboModifyListener implements ModifyListener {

        @Override
        public void modifyText(ModifyEvent e) {
            Combo cmb = (Combo) e.widget;
            cmb.select(Arrays.asList(cmb.getItems()).indexOf(cmb.getText()));
            
            Entry<PgStatement, PgStatement> selection = 
                    ManualDepciesGroup.this.getComboSelections();
            btnAdd.setEnabled(
                    selection.getKey() != null 
                    && selection.getValue() != null
                    && !selection.getKey().compare(selection.getValue()));
        }
    }
    
    private class ComboReturnKeyListener implements Listener {
        
        @Override
        public void handleEvent(Event event) {
            if (event.detail == SWT.TRAVERSE_RETURN) {
                if (btnAdd.getEnabled()) {
                    btnAdd.notifyListeners(SWT.Selection, new Event());
                }
                event.doit = false;
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
}

