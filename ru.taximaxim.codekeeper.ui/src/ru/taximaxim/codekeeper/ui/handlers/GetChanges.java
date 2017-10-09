package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorInput;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class GetChanges extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);

        if (part instanceof ProjectEditorDiffer){
            ProjectEditorDiffer differ = (ProjectEditorDiffer) part;
            Object remote = differ.getCurrentDb();

            if (remote != null) {
                differ.getChanges(remote);
            } else {
                MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                mb.setText(Messages.GetChanges_select_source);
                mb.setMessage(Messages.GetChanges_select_source_msg);
                mb.open();
            }
        } else if (part instanceof SQLEditor) {
            SQLEditor sqlEditor = (SQLEditor) part;
            IEditorInput editorInput = sqlEditor.getEditorSite().getPage().getActiveEditor().getEditorInput();

            if(editorInput instanceof IFileEditorInput) {
                try {
                    IProject proj= ((IFileEditorInput)editorInput).getFile().getProject();
                    ProjectEditorInput projectEditorInput = new ProjectEditorInput(proj.getName());

                    DbInfo dbFromSqlEditor = sqlEditor.getCurrentDb();

                    boolean isProjectTabOpen = false;

                    for (IEditorReference ref : PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                            .getActivePage().getEditorReferences()) {
                        IEditorPart editor = ref.getEditor(true);

                        if ((editor != null) && (editor instanceof ProjectEditorDiffer)) {
                            ProjectEditorDiffer projEditor = (ProjectEditorDiffer)editor;

                            if (projEditor.getProject().equals(proj)) {
                                projEditor.setCurrentDb(dbFromSqlEditor);
                                isProjectTabOpen = true;
                                break;
                            }
                        }
                    }

                    if(!isProjectTabOpen) {
                        PgDbProject pgDbProject = new PgDbProject(proj);
                        pgDbProject.getPrefs().put(PROJ_PREF.LAST_DB_STORE,dbFromSqlEditor.toString());
                        pgDbProject.getPrefs().flush();
                    }

                    IEditorPart editor = sqlEditor.getSite().getPage().openEditor(projectEditorInput, UIConsts.EDITOR.PROJECT);
                    ((ProjectEditorDiffer)editor).getChanges(dbFromSqlEditor);
                } catch (BackingStoreException e) {
                    Log.log(Log.LOG_WARNING, "Couldn't flush project properties!", e); //$NON-NLS-1$
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorInput input = editor.getEditorInput();

        boolean isTemporaryMigrationFile = input instanceof FileStoreEditorInput
                && ((FileStoreEditorInput)input).getURI().getPath().contains(System.getProperty("java.io.tmpdir"))
                && ((FileStoreEditorInput)input).getURI().getPath().contains("migration for");

        return !(editor instanceof SQLEditor && isTemporaryMigrationFile);
    }
}