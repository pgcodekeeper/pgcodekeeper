package ru.taximaxim.codekeeper.ui.handlers;

import java.util.ArrayList;
import java.util.Arrays;
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
            commands.addAll(Arrays.asList(description.getBuildSpec()));
            commands.add(buildCommand);

            description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
            project.setDescription(description, null);
        } catch (final CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot add builder", e); //$NON-NLS-1$
        }
    }

    public static IProject getProject(final ExecutionEvent event) {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        if (selection instanceof IStructuredSelection) {
            final Object element = ((IStructuredSelection) selection)
                    .getFirstElement();

            return Platform.getAdapterManager().getAdapter(element,
                    IProject.class);
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
