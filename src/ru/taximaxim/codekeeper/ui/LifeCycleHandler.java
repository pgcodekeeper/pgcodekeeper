package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class LifeCycleHandler {

    @PostContextCreate
    private void postContextCreate(IEclipseContext ctx) {
        ctx.declareModifiable(PgDbProject.class);
    }
}
