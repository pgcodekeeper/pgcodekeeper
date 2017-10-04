package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class DBStoreCombo extends WorkbenchWindowControlContribution {
    private IEditorPart editorPart;
    private DbStorePicker storePicker;
    private EditorPartListener editorPartListener;
    private boolean activateComboListener;

    @Override
    protected Control createControl(Composite parent) {
        editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

        storePicker = new DbStorePicker(parent, Activator.getDefault().getPreferenceStore(),
                editorPart instanceof ProjectEditorDiffer, false, false);

        editorPartListener = new EditorPartListener(storePicker);
        editorPart.getSite().getPage().addPartListener(editorPartListener);

        storePicker.addListenerToCombo(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                if (!activateComboListener) {
                    return;
                }

                editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                Object selectedObj = event.getStructuredSelection().getFirstElement();

                if(editorPart instanceof SQLEditor) {
                    DbInfo selectedDB = selectedObj instanceof DbInfo ? (DbInfo)selectedObj : null;
                    ((SQLEditor)editorPart).setCurrentDb(selectedDB);
                } else if(editorPart instanceof ProjectEditorDiffer) {
                    if(selectedObj != null
                            && (Messages.DbStorePicker_load_from_file.equals(selectedObj.toString()) ||
                                    selectedObj.toString().isEmpty())) {
                        return;
                    }

                    ((ProjectEditorDiffer)editorPart).setCurrentDb(selectedObj);
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

    private class EditorPartListener extends IPartAdapter2 {
        private final DbStorePicker storePicker;

        public EditorPartListener(DbStorePicker storePicker) {
            this.storePicker = storePicker;
        }

        @Override
        public void partActivated(IWorkbenchPartReference partRef) {
            IWorkbenchPart part = partRef.getPart(false);

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

            activateComboListener = true;

            if(lastDb == null) {
                storePicker.clearSelection();
            } else {
                StructuredSelection selection = new StructuredSelection(lastDb);
                storePicker.setSelection(selection);
            }
        }

        @Override
        public void partDeactivated(IWorkbenchPartReference partRef) {
            IWorkbenchPart part = partRef.getPart(false);
            if ((part instanceof SQLEditor) || (part instanceof ProjectEditorDiffer)) {
                activateComboListener = false;
            }
        }
    }
}