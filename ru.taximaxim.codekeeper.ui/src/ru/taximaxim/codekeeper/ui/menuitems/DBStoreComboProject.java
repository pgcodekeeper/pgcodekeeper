package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DBStoreComboProject extends WorkbenchWindowControlContribution {
    private IEditorPart editorPart;
    private DbStorePicker storePicker;
    private ProjectEditorPartListener projectEditorPartListener;

    @Override
    protected Control createControl(Composite parent) {
        storePicker = new DbStorePicker(parent, SWT.NONE, Activator.getDefault().getPreferenceStore(), true, false, false);

        projectEditorPartListener = new ProjectEditorPartListener(storePicker);

        editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        editorPart.getSite().getPage().addPartListener(projectEditorPartListener);

        storePicker.addListenerToCombo(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                if(editorPart instanceof ProjectEditorDiffer) {
                    Object selectedObj = event.getStructuredSelection().getFirstElement();

                    if(selectedObj != null
                            && (Messages.DbStorePicker_load_from_file.equals(selectedObj.toString()) ||
                                    "".equals(selectedObj.toString()))) {
                        return;
                    }

                    ((ProjectEditorDiffer)editorPart).setLastRemote(selectedObj);
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
        editorPart.getSite().getPage().removePartListener(projectEditorPartListener);
        storePicker.dispose();
    }
}

class ProjectEditorPartListener extends IPartAdapter2 {
    private final DbStorePicker storePicker;

    public ProjectEditorPartListener(DbStorePicker storePicker) {
        this.storePicker = storePicker;
    }

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
        IWorkbenchPart part = partRef.getPart(false);
        if (part instanceof ProjectEditorDiffer) {
            if(((ProjectEditorDiffer)part).getLastDb() == null) {
                storePicker.clearSelection();
            } else {
                StructuredSelection selection = new StructuredSelection(((ProjectEditorDiffer)part).getLastDb());
                storePicker.setSelection(selection);
            }
        }
    }
}
