package ru.taximaxim.codekeeper.ui.menuitems;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
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

        storePicker.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                if (!storePicker.isComboEnabled()) {
                    MessageBox mb = new MessageBox(parent.getShell(), SWT.ICON_INFORMATION);
                    mb.setText(Messages.DbStoreCombo_db_binding_property_title);
                    mb.setMessage(Messages.DbStoreCombo_db_binding_property);
                    mb.open();
                }
            }
        });

        setSelectionFromPart(editorPart);

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
        IProject proj = null;

        if (part instanceof SQLEditor) {
            SQLEditor editor = (SQLEditor) part;
            lastDb = editor.getCurrentDb();
            storePicker.loadStore(false);
            IEditorInput input = editor.getEditorInput();
            if (input instanceof FileEditorInput) {
                proj = ((FileEditorInput) input).getFile().getProject();
            }
            setDbComboEnableState(editor.getProjPrefs());
        } else if (part instanceof ProjectEditorDiffer) {
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            lastDb = differ.getCurrentDb();
            storePicker.loadStore(true);
            proj = differ.getProject();
            setDbComboEnableState(PgDbProject.getPrefs(differ.getProject()));
        } else {
            return;
        }

        try {
            storePicker.filter(proj != null && proj.hasNature(NATURE.ID) ?
                    proj.hasNature(NATURE.MS) : null);
        } catch (CoreException ex) {
            Log.log(ex);
        }

        if (lastDb == null) {
            storePicker.clearSelection();
        } else {
            StructuredSelection selection = new StructuredSelection(lastDb);
            storePicker.setSelection(selection);
        }
    }

    private void setDbComboEnableState(IEclipsePreferences prefs) {
        storePicker.setComboEnabled(prefs == null ? true :
            prefs.get(PROJ_PREF.NAME_OF_BOUND_DB, "").isEmpty()); //$NON-NLS-1$
    }

    private class EditorPartListener extends IPartAdapter2 {

        @Override
        public void partActivated(IWorkbenchPartReference partRef) {
            setSelectionFromPart(partRef.getPart(false));
        }
    }
}