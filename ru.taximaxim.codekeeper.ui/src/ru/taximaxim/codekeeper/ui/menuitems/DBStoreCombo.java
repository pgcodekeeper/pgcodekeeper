package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class DBStoreCombo extends WorkbenchWindowControlContribution {

    private DbStorePicker storePicker;
    private EditorPartListener editorPartListener;

    @Override
    protected Control createControl(Composite parent) {
        IWorkbenchPage page = getWorkbenchWindow().getActivePage();

        IEditorPart editorPart = page.getActiveEditor();
        storePicker = new DbStorePicker(parent, Activator.getDefault().getPreferenceStore(),
                editorPart instanceof ProjectEditorDiffer, false, true);

        editorPartListener = new EditorPartListener();
        page.addPartListener(editorPartListener);

        storePicker.addListenerToCombo(e -> {
            IEditorPart editor = getWorkbenchWindow().getActivePage().getActiveEditor();

            if (editor instanceof SQLEditor) {
                ((SQLEditor) editor).setCurrentDb(storePicker.getDbInfo());
            } else if (editor instanceof ProjectEditorDiffer) {
                Object selection = storePicker.getDbInfo();
                if (selection == null) {
                    selection = storePicker.getPathOfFile();
                }
                ((ProjectEditorDiffer) editor).setCurrentDb(selection);
            }
        });

        setSelectionFromPart(getWorkbenchWindow().getActivePage().getActiveEditor());

        return storePicker;
    }

    @Override
    protected int computeWidth(Control control) {
        return 200;
    }

    @Override
    public void dispose() {
        getWorkbenchWindow().getActivePage().removePartListener(editorPartListener);
        storePicker.dispose();
    }

    private void setSelectionFromPart(IWorkbenchPart part) {
        Object lastDb = null;
        if (part instanceof SQLEditor) {
            lastDb = ((SQLEditor)part).getCurrentDb();
            storePicker.loadStore(false);
        } else if (part instanceof ProjectEditorDiffer) {
            lastDb = ((ProjectEditorDiffer)part).getCurrentDb();
            storePicker.loadStore(true);
        } else {
            return;
        }

        if(lastDb == null) {
            storePicker.clearSelection();
        } else {
            StructuredSelection selection = new StructuredSelection(lastDb);
            storePicker.setSelection(selection);
        }
    }

    private class EditorPartListener extends IPartAdapter2 {

        @Override
        public void partActivated(IWorkbenchPartReference partRef) {
            setSelectionFromPart(partRef.getPart(false));
        }
    }
}