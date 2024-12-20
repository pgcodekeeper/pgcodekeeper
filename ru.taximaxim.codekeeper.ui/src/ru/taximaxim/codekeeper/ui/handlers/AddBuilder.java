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
package ru.taximaxim.codekeeper.ui.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.BUILDER;

public class AddBuilder extends AbstractHandler implements IHandler {

    @Override
    public Object execute(final ExecutionEvent event) {
        final IProject project = getProject(event);

        if (project != null) {
            addBuilder(project);
        }

        return null;
    }

    public static void addBuilder(final IProject project) {
        try {
            // verify already registered builders
            if (hasBuilder(project)) {
                // already enabled
                return;
            }
            // add builder to project properties
            IProjectDescription description = project.getDescription();
            final ICommand buildCommand = description.newCommand();
            buildCommand.setBuilderName(BUILDER.ID);

            final List<ICommand> commands = new ArrayList<>();
            Collections.addAll(commands, description.getBuildSpec());
            commands.add(buildCommand);

            description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
            project.setDescription(description, null);
        } catch (final CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot add builder", e); //$NON-NLS-1$
        }
    }

    public static IProject getProject(final ExecutionEvent event) {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection ss) {
            return Platform.getAdapterManager().getAdapter(ss.getFirstElement(), IProject.class);
        }

        return null;
    }

    public static final boolean hasBuilder(final IProject project) {
        try {
            for (final ICommand buildSpec : project.getDescription()
                    .getBuildSpec()) {
                if (BUILDER.ID.equals(buildSpec.getBuilderName())) {
                    return true;
                }
            }
        } catch (final CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot determine project builder", e); //$NON-NLS-1$
        }

        return false;
    }
}
