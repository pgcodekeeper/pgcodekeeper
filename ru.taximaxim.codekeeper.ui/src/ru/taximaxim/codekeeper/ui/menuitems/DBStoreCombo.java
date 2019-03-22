package ru.taximaxim.codekeeper.ui.menuitems;

import java.util.function.Consumer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
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
                    DefaultToolTip tt = new DefaultToolTip(storePicker, SWT.NONE, true);
                    tt.setText(Messages.DbStoreCombo_db_binding_property);
                    tt.setForegroundColor(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
                    tt.setFont(new Font(null, "Arial", 12, SWT.BOLD)); //$NON-NLS-1$
                    Point storePickerPoint = storePicker.getLocation();
                    tt.show(new Point(storePickerPoint.x + 100, storePickerPoint.y + 20));
                }
            }
        });

        setSelectionFromPart(getWorkbenchWindow().getActivePage().getActiveEditor());

        checkProjBindingToDb();

        return storePicker;
    }

    private void checkProjBindingToDb() {
        IEditorPart ed = getWorkbenchWindow().getActivePage().getActiveEditor();
        DbInfo bindedDb = null;
        if (ed instanceof SQLEditor) {
            SQLEditor sqlEd = (SQLEditor) ed;
            bindedDb = setBindedDbToProj(sqlEd.getProjPrefs(), db -> sqlEd.setCurrentDb(db));
        } else if (ed instanceof ProjectEditorDiffer) {
            ProjectEditorDiffer projEd = (ProjectEditorDiffer) ed;
            bindedDb = setBindedDbToProj(PgDbProject.getPrefs(projEd.getProject()),
                    db -> projEd.setCurrentDb(db));
        }

        boolean isDumpFile = bindedDb == null;
        storePicker.setSelection(isDumpFile ? null : new StructuredSelection(bindedDb));
        storePicker.setComboEnabled(isDumpFile);
    }

    /**
     * Sets binded database to the project as currentDB.
     *
     * @param prefs project preferences
     * @param setDbToEditor consumer for set DB to SQLEditor or to ProjectEditorDiffer
     *
     * @return binded database, If there is no binded database then returns null.
     */
    private DbInfo setBindedDbToProj(IEclipsePreferences prefs,
            Consumer<DbInfo> setDbToEditor) {
        if (prefs == null) {
            return null;
        }
        String nameOfBindedDb = prefs.get(PROJ_PREF.NAME_OF_BINDED_DB, "");  //$NON-NLS-1$
        if (!nameOfBindedDb.isEmpty()) {
            DbInfo dbSource = DbInfo.getLastDb(nameOfBindedDb);
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