package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;

public class ProjectEditorInputFactory implements IElementFactory {
    
    @Override
    public IAdaptable createElement(IMemento memento) {
        String projName = memento.getString(EDITOR.PROJECT_EDITOR_FACTORY_TAG_PROJECT);
        if (projName == null) {
            return new ProjectEditorInput(projName)
                    .setError(new PgCodekeeperUIException("Project not found"));
        }
        
        // Get a handle to the IProject
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
        if (project.exists() && project.isOpen()) {
            return new ProjectEditorInput(projName);
        }
        return null;
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
