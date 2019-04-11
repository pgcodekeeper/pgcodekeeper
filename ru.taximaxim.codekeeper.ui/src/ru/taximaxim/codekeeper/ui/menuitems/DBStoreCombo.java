package ru.taximaxim.codekeeper.ui.menuitems;

import java.util.function.Consumer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.IPartAdapter2;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
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

            // Using here the method 'checkProjBindingToDb()' instead of this code,
            // can give as result the endless cycle, because of setting the selection
            // to the StorePicker.
            // Thats why setting the selection to the StorePicker is made in
            // ru.taximaxim.codekeeper.ui.properties.ProjectProperties#performOk()
            // through 'setCurrentDb()' and 'IWorkbenchPage.activate(IEditorPart)'.
            if (editor instanceof SQLEditor) {
                SQLEditor sqlEditor = ((SQLEditor) editor);
                sqlEditor.setCurrentDb(storePicker.getDbInfo());
                setDbComboEnableState(sqlEditor.getProjPrefs());
            } else if (editor instanceof ProjectEditorDiffer) {
                Object selection = storePicker.getDbInfo();
                if (selection == null) {
                    selection = storePicker.getPathOfFile();
                }
                ProjectEditorDiffer projEditor = ((ProjectEditorDiffer) editor);
                projEditor.setCurrentDb(selection);
                setDbComboEnableState(PgDbProject.getPrefs(projEditor.getProject()));
            }
        });

        storePicker.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                if (!storePicker.isComboEnabled()) {
                    MessageDialog.openInformation(parent.getShell(),
                            Messages.DbStoreCombo_db_binding_property_title,
                            Messages.DbStoreCombo_db_binding_property);
                }
            }
        });

        checkProjBindingToDb(editorPart);

        setSelectionFromPart(editorPart);

        checkProjBindingToDb(editorPart);

        return storePicker;
    }

    private void setDbComboEnableState(IEclipsePreferences prefs) {
        storePicker.setComboEnabled(prefs == null ? true :
            prefs.get(PROJ_PREF.NAME_OF_BOUND_DB, "").isEmpty());
    }

    private void checkProjBindingToDb(IEditorPart ed) {
        DbInfo boundDb = null;
        if (ed instanceof SQLEditor) {
            SQLEditor sqlEd = (SQLEditor) ed;
            boundDb = setBoundDbToProj(sqlEd.getProjPrefs(), sqlEd::setCurrentDb);
        } else if (ed instanceof ProjectEditorDiffer) {
            ProjectEditorDiffer projEd = (ProjectEditorDiffer) ed;
            boundDb = setBoundDbToProj(PgDbProject.getPrefs(projEd.getProject()),
                    projEd::setCurrentDb);
        }

        boolean isDumpFile = boundDb == null;
        storePicker.setComboEnabled(isDumpFile);
    }

    /**
     * Sets bound database to the project as currentDB.
     *
     * @param prefs project preferences
     * @param setDbToEditor consumer for set DB to SQLEditor or to ProjectEditorDiffer
     *
     * @return bound database, If there is no bound database then returns null.
     */
    private DbInfo setBoundDbToProj(IEclipsePreferences prefs,
            Consumer<DbInfo> setDbToEditor) {
        if (prefs == null) {
            return null;
        }
        String nameOfBoundDb = prefs.get(PROJ_PREF.NAME_OF_BOUND_DB, "");  //$NON-NLS-1$
        if (!nameOfBoundDb.isEmpty()) {
            DbInfo dbSource = DbInfo.getLastDb(nameOfBoundDb);
            setDbToEditor.accept(dbSource);
            return dbSource;
        }
        return null;
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
        } else if (part instanceof ProjectEditorDiffer) {
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            lastDb = differ.getCurrentDb();
            storePicker.loadStore(true);
            proj = differ.getProject();
        } else {
            return;
        }

        if (proj != null) {
            try {
                storePicker.filter(proj.hasNature(NATURE.MS));
            } catch (CoreException ex) {
                Log.log(ex);
            }
        }

        if (lastDb == null) {
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