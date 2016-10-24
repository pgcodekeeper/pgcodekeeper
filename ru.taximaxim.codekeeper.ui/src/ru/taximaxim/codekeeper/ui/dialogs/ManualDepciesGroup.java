package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ManualDepciesGroup extends Group{

    private final List<Entry<PgStatement, PgStatement>> depcies;
    private final Map<String, PgStatement> objects;

    private final Text txtDependents, txtDependencies;
    private final ListViewer listDepcies;
    private final Button btnAdd;
    private final Button btnRemove;

    public List<Entry<PgStatement, PgStatement>> getDepciesList() {
        return depcies;
    }

    public ManualDepciesGroup(Composite parent, int style,
            List<Entry<PgStatement, PgStatement>> dependencies,
            Map<String, PgStatement> objects, String groupName) {
        super(parent, style);

        this.depcies = new LinkedList<>(dependencies);
        this.objects = objects;

        int i = 0;
        IContentProposal[] prop = new IContentProposal[objects.size()];
        for (String name : objects.keySet()) {
            prop[i++] = new ContentProposal(name);
        }
        Arrays.sort(prop, PgStatementProposalComparator.INSTANCE);
        List<IContentProposal> proposals = Arrays.asList(prop);

        setLayout(new GridLayout(2, true));
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 600;
        setLayoutData(gd);
        this.setText(groupName);

        Composite grpSelectors = new Composite(this, SWT.NONE);
        GridLayout gl = new GridLayout(2, false);
        gl.marginWidth = gl.marginHeight = 0;
        grpSelectors.setLayout(gl);
        grpSelectors.setLayoutData(new GridData(GridData.FILL_BOTH));

        // spacer
        new Label(grpSelectors, SWT.NONE).setLayoutData(
                new GridData(SWT.LEFT, SWT.DEFAULT, true, false, 2, 1));

        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_object);

        txtDependents = new Text(grpSelectors, SWT.BORDER);
        txtDependents.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDependents.addModifyListener(new TextModifyListener());
        new PgStatementAutoCompleteField(txtDependents, new TextContentAdapter(), proposals);

        new Label(grpSelectors, SWT.NONE).setText(Messages.manualDepciesDialog_depends_on);

        txtDependencies = new Text(grpSelectors, SWT.BORDER);
        txtDependencies.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDependencies.addModifyListener(new TextModifyListener());

        new PgStatementAutoCompleteField(txtDependencies, new TextContentAdapter(), proposals);

        btnAdd = new Button(grpSelectors, SWT.PUSH);
        btnAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false, 2, 1));
        btnAdd.setText(Messages.manualDepciesDialog_add);
        btnAdd.setEnabled(false);
        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                depcies.add(getSelectionDepcy());
                listDepcies.refresh();
                txtDependents.setText(""); //$NON-NLS-1$
                txtDependencies.setText(""); //$NON-NLS-1$
            }
        });

        Composite grpList = new Composite(this, SWT.NONE);
        gl = new GridLayout();
        gl.marginWidth = gl.marginHeight = 0;
        grpList.setLayout(gl);
        grpList.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(grpList, SWT.NONE).setText(Messages.manualDepciesDialog_dependant_dependency);

        listDepcies = new ListViewer(grpList);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 100;
        listDepcies.getList().setLayoutData(gd);

        listDepcies.setContentProvider(ArrayContentProvider.getInstance());
        listDepcies.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                @SuppressWarnings("unchecked")
                Entry<PgStatement, PgStatement> e = (Entry<PgStatement, PgStatement>) element;
                return e.getKey().getQualifiedName() + " \u2192 " //$NON-NLS-1$
                        + e.getValue().getQualifiedName();
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
                    removedStuff |= removeDepcy(toRemove, depcies.iterator());
                }
                if (removedStuff) {
                    listDepcies.refresh();
                }
            }
        });
        listDepcies.setInput(depcies);
    }

    private Entry<PgStatement, PgStatement> getSelectionDepcy() {
        return new AbstractMap.SimpleEntry<>(
                objects.get(txtDependents.getText()),
                objects.get(txtDependencies.getText()));
    }

    @Override
    protected void checkSubclass() {
        // allow subclassing, we just use Group as a Composite
        // ~should~ be fine
    }

    private boolean removeDepcy(Entry<PgStatement, PgStatement> toRemove,
            Iterator<Entry<PgStatement, PgStatement>> it) {
        while (it.hasNext()) {
            Entry<PgStatement, PgStatement> el = it.next();
            if (toRemove.getKey().compare(el.getKey())
                    && toRemove.getValue().compare(el.getValue())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private class TextModifyListener implements ModifyListener {

        @Override
        public void modifyText(ModifyEvent e) {
            Entry<PgStatement, PgStatement> selection = getSelectionDepcy();
            btnAdd.setEnabled(
                    selection.getKey() != null
                    && selection.getValue() != null
                    && !selection.getKey().compare(selection.getValue())
                    && !depcies.contains(selection));
        }
    }
}
