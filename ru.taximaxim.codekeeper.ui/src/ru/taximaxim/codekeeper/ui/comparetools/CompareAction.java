package ru.taximaxim.codekeeper.ui.comparetools;

import org.eclipse.compare.CompareUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

public class CompareAction {

    public static void openCompareEditor(CompareInput input) {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorPart editor = findEditor(input, page);
        if (editor != null) {
            if (!editor.getEditorInput().equals(input)) {
                CompareUI.reuseCompareEditor(input, (IReusableEditor) editor);
            }
            page.activate(editor);
        } else {
            CompareUI.openCompareEditor(input);
        }
    }

    private static IEditorPart findEditor(CompareInput input, IWorkbenchPage page) {
        IEditorReference[] editorRefs = page.getEditorReferences();
        for (IEditorReference editorRef : editorRefs) {
            IEditorPart part = editorRef.getEditor(false);
            if (part != null && part instanceof IReusableEditor
                    && part.getEditorInput().equals(input)) {
                return part;
            }
        }

        if (Activator.getDefault().getPreferenceStore().getBoolean(PREF.REUSE_OPEN_COMPARE_EDITOR)) {
            for (IEditorReference editorRef : editorRefs) {
                IEditorPart part = editorRef.getEditor(false);
                if (part != null && part.getEditorInput() instanceof CompareInput
                        && part instanceof IReusableEditor) {
                    return part;
                }
            }
        }

        return null;
    }
}
