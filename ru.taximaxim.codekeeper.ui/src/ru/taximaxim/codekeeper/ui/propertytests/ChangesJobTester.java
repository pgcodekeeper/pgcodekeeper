package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ChangesJobTester extends SingletonJobTester {

    private static final String PROP = "isGetChangesRunning"; //$NON-NLS-1$
    public static final String EVAL_PROP = makeEvalProperty(PROP);

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        Object editor = receiver;
        if (editor instanceof SQLEditor) {
            editor = findProjectEditor((SQLEditor) editor);
        }
        return editor == null ? false : super.test(editor, property, args, expectedValue);
    }

    private static ProjectEditorDiffer findProjectEditor(SQLEditor editor) {
        IFile file = ResourceUtil.getFile(editor.getEditorInput());
        return file == null ? null : findProjectEditor(file.getProject());
    }

    public static ProjectEditorDiffer findProjectEditor(IProject proj) {
        for (IWorkbenchWindow w : PlatformUI.getWorkbench().getWorkbenchWindows()) {
            for (IWorkbenchPage p : w.getPages()) {
                for (IEditorReference e : p.getEditorReferences()) {
                    if (EDITOR.PROJECT.equals(e.getId())) {
                        ProjectEditorDiffer projEditor = (ProjectEditorDiffer) e.getEditor(false);
                        if (projEditor != null && projEditor.getProject().equals(proj)) {
                            return projEditor;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getProperty() {
        return PROP;
    }

    @Override
    public String getEvalProperty() {
        return EVAL_PROP;
    }
}
