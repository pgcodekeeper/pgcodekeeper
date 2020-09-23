package ru.taximaxim.codekeeper.ui.fileutils;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class UIProjectUpdater extends ProjectUpdater{

    public UIProjectUpdater(PgDatabase dbNew, PgDbProject proj) throws CoreException {
        this(dbNew, null, null, proj, false);
    }

    public UIProjectUpdater(PgDatabase dbNew, PgDatabase dbOld,
            Collection<TreeElement> changedObjects, PgDbProject proj,
            boolean overridesOnly) throws CoreException {
        super(dbNew, dbOld, changedObjects,
                OpenProjectUtils.checkMsSql(proj.getProject()), proj.getProjectCharset(),
                proj.getPathToProject(), overridesOnly);
    }
}
