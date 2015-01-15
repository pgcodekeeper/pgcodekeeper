package ru.taximaxim.codekeeper.ui.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ProjectBuilder extends IncrementalProjectBuilder {

    public ProjectBuilder() {
    }

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
        IProject proj = getProject();
        PgDbParser parser = PgDbParser.getParser(proj);
        if (!proj.hasNature(NATURE.ID)) {
            return null;
        }
        switch (kind) {
        case IncrementalProjectBuilder.AUTO_BUILD:
        case IncrementalProjectBuilder.CLEAN_BUILD:
        case IncrementalProjectBuilder.FULL_BUILD:
        case IncrementalProjectBuilder.INCREMENTAL_BUILD:
            parser.getObjFromProject();
            break;
        }
        List<IProject> list = new ArrayList<>();
        list.add(proj);
        return list.toArray(new IProject[list.size()]);
    }
}
