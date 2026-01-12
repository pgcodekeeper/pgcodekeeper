/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.BUILDER;

public class RemoveBuilder extends AbstractHandler implements IHandler {

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IProject project = AddBuilder.getProject(event);

        if (project != null) {
            removeBuilder(project);
        }

        return null;
    }

    public static void removeBuilder(final IProject project) {
        try {
            final IProjectDescription description = project
                    .getDescription();
            final List<ICommand> commands = new ArrayList<>();
            commands.addAll(Arrays.asList(description.getBuildSpec()));

            for (final ICommand buildSpec : description.getBuildSpec()) {
                if (BUILDER.ID.equals(buildSpec.getBuilderName())) {
                    // remove builder
                    commands.remove(buildSpec);
                }
            }

            description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
            project.setDescription(description, null);
        } catch (final CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot remove builder", e); //$NON-NLS-1$
        }
    }
}
