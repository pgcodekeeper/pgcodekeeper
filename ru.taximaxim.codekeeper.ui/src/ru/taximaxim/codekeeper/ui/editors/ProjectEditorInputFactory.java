package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInputFactory implements IElementFactory {

    private static final String PROJECT_EDITOR_FACTORY_ID = "ru.taximaxim.codekeeper.ui.editors.ProjectEditorInputFactory"; //$NON-NLS-1$
    private static final String TAG_PROJECT = "project"; //$NON-NLS-1$

    @Override
    public IAdaptable createElement(IMemento memento) {
        String projName = memento.getString(TAG_PROJECT);
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
        return PROJECT_EDITOR_FACTORY_ID;
    }

    static void saveState(IMemento memento, ProjectEditorInput input) {
        memento.putString(TAG_PROJECT, input.getName());
    }
}
