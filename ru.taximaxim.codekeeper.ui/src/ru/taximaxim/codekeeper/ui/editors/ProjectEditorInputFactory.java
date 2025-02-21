/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
