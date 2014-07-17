package ru.taximaxim.codekeeper.ui;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import cz.startnet.utils.pgdiff.schema.PgStatement;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ManualDepciesDialog extends TrayDialog {

    private final List<Entry<PgStatement, PgStatement>> depcies;
    private final PgStatement[] objects;
    private final String[] names;
    
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
        this.objects = objects.toArray(new PgStatement[objects.size()]);
        
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
    
    private class ComboModifyListener implements ModifyListener {

        @Override
        public void modifyText(ModifyEvent e) {
            Combo cmb = (Combo) e.widget;
            cmb.select(Arrays.asList(cmb.getItems()).indexOf(cmb.getText()));
            
            Entry<PgStatement, PgStatement> selection = 
                    ManualDepciesDialog.this.getComboSelections();
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

class MyAutoCompleteField {

    private MyContentProposalProvider proposalProvider;
    private ContentProposalAdapter adapter;

    /**
     * Construct an AutoComplete field on the specified control, whose
     * completions are characterized by the specified array of Strings.
     * 
     * @param control
     *            the control for which autocomplete is desired. May not be
     *            <code>null</code>.
     * @param controlContentAdapter
     *            the <code>IControlContentAdapter</code> used to obtain and
     *            update the control's contents. May not be <code>null</code>.
     * @param proposals
     *            the array of Strings representing valid content proposals for
     *            the field.
     */
    public MyAutoCompleteField(Control control,
            IControlContentAdapter controlContentAdapter, String[] proposals) {
        proposalProvider = new MyContentProposalProvider(proposals);
        proposalProvider.setFiltering(true);
        adapter = new ContentProposalAdapter(control, controlContentAdapter,
                proposalProvider, null, null);
        adapter.setPropagateKeys(true);
        adapter
                .setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    }

    /**
     * Set the Strings to be used as content proposals.
     * 
     * @param proposals
     *            the array of Strings to be used as proposals.
     */
    public void setProposals(String[] proposals) {
        proposalProvider.setProposals(proposals);
    }

}

class MyContentProposalProvider implements IContentProposalProvider {

    /*
     * The proposals provided.
     */
    private String[] proposals;
    
    /*
     * The proposals mapped to IContentProposal. Cached for speed in the case
     * where filtering is not used.
     */
    private IContentProposal[] contentProposals;
    
    /*
     * Boolean that tracks whether filtering is used.
     */
    private boolean filterProposals = false;
    
    public MyContentProposalProvider(String[] proposals) {
        super();
        this.proposals = proposals;
    }
    
    @Override
    public IContentProposal[] getProposals(String contents, int position) {
        if (filterProposals) {
            ArrayList<ContentProposal> list = new ArrayList<ContentProposal>();
            for (int i = 0; i < proposals.length; i++) {
                if (proposals[i].toLowerCase().contains(contents.toLowerCase())) {
                    list.add(new ContentProposal(proposals[i]));
                }
            }
            return list.toArray(new IContentProposal[list
                    .size()]);
        }
        if (contentProposals == null) {
            contentProposals = new IContentProposal[proposals.length];
            for (int i = 0; i < proposals.length; i++) {
                contentProposals[i] = new ContentProposal(proposals[i]);
            }
        }
        return contentProposals;
    }

    /**
     * Set the Strings to be used as content proposals.
     * 
     * @param items
     *            the array of Strings to be used as proposals.
     */
    public void setProposals(String[] items) {
        this.proposals = items;
        contentProposals = null;
    }
    
    public void setFiltering(boolean filterProposals) {
        this.filterProposals = filterProposals;
        // Clear any cached proposals.
        contentProposals = null;
    }
}
