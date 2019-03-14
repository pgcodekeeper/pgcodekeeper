package ru.taximaxim.codekeeper.ui.menuitems;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.StructuredSelection;
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

        setSelectionFromPart(getWorkbenchWindow().getActivePage().getActiveEditor());

        IEditorPart ed = getWorkbenchWindow().getActivePage().getActiveEditor();
        if (ed instanceof SQLEditor) {

            /// TODO add processing for this case

        } else if (ed instanceof ProjectEditorDiffer) {
            ProjectEditorDiffer projEd = (ProjectEditorDiffer) ed;
            IEclipsePreferences projPref = PgDbProject.getPrefs(projEd.getProject());

            String nameOfBindedDb = projPref.get(PROJ_PREF.NAME_OF_BINDED_DB, "");

            if (!"".equals(nameOfBindedDb)) {
                List<DbInfo> store = DbInfo.readStoreFromXml();
                Object source = store.stream()
                        .filter(dbInf -> dbInf.getName().equals(nameOfBindedDb))
                        .findAny().orElse(null);

                boolean isDumpFile = source == null;

                if (isDumpFile) {
                    File dumpFile = new File(nameOfBindedDb);
                    if (dumpFile.isFile() &&
                            storePicker.checkMatchWith(nameOfBindedDb
                                    .substring(nameOfBindedDb.lastIndexOf(File.separator) + 1))) {
                        source = dumpFile;
                    }
                }

                storePicker.setSelection(new StructuredSelection(source));
                storePicker.setComboEnabled(isDumpFile);
                projEd.setCurrentDb(source);
            }
        }

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