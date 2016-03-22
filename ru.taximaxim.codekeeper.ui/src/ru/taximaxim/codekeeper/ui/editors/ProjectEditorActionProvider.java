package ru.taximaxim.codekeeper.ui.editors;

import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorContentProvider.MyElement;
import ru.taximaxim.codekeeper.ui.handlers.OpenEditor;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorActionProvider extends CommonActionProvider {

    public ProjectEditorActionProvider() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ICommonActionExtensionSite aSite) {

        aSite.getStructuredViewer().addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				Object resource = ((TreeSelection)event.getSelection()).getFirstElement();
				if (!(resource instanceof MyElement)){
					return;
				}
				IProject proj = ((MyElement)resource).getProject();
				try {
					OpenEditor.openEditor(PlatformUI.getWorkbench()
					        .getActiveWorkbenchWindow().getActivePage(), proj);
				} catch (PgCodekeeperUIException e) {
					ExceptionNotifier.notifyDefault(
	                        MessageFormat.format(
	                                Messages.OpenEditor_error_open_project_editor, proj.getName()), e);
				}
			}
		});
    }

}
