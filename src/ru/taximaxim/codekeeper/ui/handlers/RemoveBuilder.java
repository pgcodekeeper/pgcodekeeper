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

import ru.taximaxim.codekeeper.ui.UIConsts.BUILDER;

public class RemoveBuilder extends AbstractHandler implements IHandler {

    public RemoveBuilder() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IProject project = AddBuilder.getProject(event);

        if (project != null) {
            try {
                final IProjectDescription description = project
                        .getDescription();
                final List<ICommand> commands = new ArrayList<ICommand>();
                commands.addAll(Arrays.asList(description.getBuildSpec()));

                for (final ICommand buildSpec : description.getBuildSpec()) {
                    if (BUILDER.ID.equals(buildSpec.getBuilderName())) {
                        // remove builder
                        commands.remove(buildSpec);
                    }
                }

                description.setBuildSpec(commands.toArray(new ICommand[commands
                        .size()]));
                project.setDescription(description, null);
            } catch (final CoreException e) {
                // TODO could not read/write project description
                e.printStackTrace();
            }
        }

        return null;
    }
}
