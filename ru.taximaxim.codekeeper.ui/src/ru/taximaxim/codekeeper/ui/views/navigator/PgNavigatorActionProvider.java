package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class PgNavigatorActionProvider extends CommonActionProvider {

    @Override
    public void init(ICommonActionExtensionSite aSite) {
        aSite.getStructuredViewer().addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {

                Object resource = ((TreeSelection) event.getSelection()).getFirstElement();
                if (resource instanceof SegmentsWithParent) {
                    SegmentsWithParent segment = (SegmentsWithParent) resource;
                    try {
                        ITextEditor editor = (ITextEditor) IDE.openEditor(PlatformUI.getWorkbench()
                                .getActiveWorkbenchWindow().getActivePage(), segment
                                        .getParentFile(), SQLEditor.ID, true);
                            editor.setHighlightRange(segment.offset, segment.length, true);
                            editor.selectAndReveal(segment.offset, segment.length);
                    } catch (PartInitException e) {
                        Log.log(Log.LOG_ERROR, e.getLocalizedMessage(), e.getCause());
                    }
                }
            }
        });
    }
}
