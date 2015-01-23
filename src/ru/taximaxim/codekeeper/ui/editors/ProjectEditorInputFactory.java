package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInputFactory implements IElementFactory {
    
    @Override
    public IAdaptable createElement(IMemento memento) {
        String projName = memento.getString(EDITOR.PROJECT_EDITOR_FACTORY_TAG_PROJECT);
        ProjectEditorInput input = new ProjectEditorInput(projName);
        
        IProject project = 
                (projName == null) ? null : ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
        if (project == null || !project.exists() || !project.isOpen()) {
            input.setError(new PgCodekeeperUIException(Messages.project_either_closed_or_deleted + projName));
        }
        
        return input;
    }
    
    /**
     * Returns the element factory id for this class.
     */
    static String getFactoryId() {
        return EDITOR.PROJECT_EDITOR_FACTORY_ID;
    }

    static void saveState(IMemento memento, ProjectEditorInput input) {
        String projName = input.getName();
        memento.putString(EDITOR.PROJECT_EDITOR_FACTORY_TAG_PROJECT, projName);
    }
}
