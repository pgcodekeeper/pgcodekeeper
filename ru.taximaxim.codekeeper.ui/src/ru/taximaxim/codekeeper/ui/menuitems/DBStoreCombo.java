package ru.taximaxim.codekeeper.ui.menuitems;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class DBStoreCombo extends WorkbenchWindowControlContribution {
    private IEditorPart editorPart;
    private DbStorePicker storePicker;
    private EditorPartListener editorPartListener;

    @Override
    protected Control createControl(Composite parent) {
        storePicker = new DbStorePicker(parent, SWT.NONE, Activator.getDefault().getPreferenceStore(), false, false, false);

        editorPartListener = new EditorPartListener(storePicker);

        editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        editorPart.getSite().getPage().addPartListener(editorPartListener);

        storePicker.addListenerToCombo(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                if(editorPart instanceof RollOnEditor) {
                    Object selectedObj = event.getStructuredSelection().getFirstElement();
                    DbInfo selectedDB = selectedObj instanceof DbInfo ? (DbInfo)selectedObj : null;
                    ((RollOnEditor)editorPart).setLastDb(selectedDB);
                }
            }
        });

        return storePicker;
    }

    @Override
    protected int computeWidth(Control control) {
        return 200;
    }

    @Override
    public void dispose() {
        editorPart.getSite().getPage().removePartListener(editorPartListener);
        storePicker.dispose();
    }
}

class EditorPartListener implements IPartListener2 {
    private final DbStorePicker storePicker;

    public EditorPartListener(DbStorePicker storePicker) {
        this.storePicker = storePicker;
    }

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
        IWorkbenchPart part = partRef.getPart(false);
        if (part instanceof RollOnEditor) {
            if(((RollOnEditor)part).getLastDb() == null) {
                storePicker.clearSelection();
            } else {
                StructuredSelection selection = new StructuredSelection(((RollOnEditor)part).getLastDb());
                storePicker.setSelection(selection);
            }

        }
    }

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partClosed(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partHidden(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partVisible(IWorkbenchPartReference partRef) {
        // no imp
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) {
        // no imp
    }
}
