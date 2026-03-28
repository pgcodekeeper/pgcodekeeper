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
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import ru.taximaxim.codekeeper.ui.DatabaseType;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.pgcodekeeper.core.database.api.IDatabaseProvider;
import org.pgcodekeeper.core.database.api.loader.ILoader;
import org.pgcodekeeper.core.database.api.schema.IDatabase;
import org.pgcodekeeper.core.settings.DiffSettings;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.database.base.jdbc.IDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.StubDatabaseLoader;
import ru.taximaxim.codekeeper.ui.settings.UISettings;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

public final class InitProjectFromSource implements IRunnableWithProgress {

    private final PgDbProject proj;
    private final DatabaseType dbType;
    private final boolean isInit;
    private final DbInfo dbInfo;
    private final File dumpPath;

    public InitProjectFromSource(PgDbProject proj, PageDb pageDb) {
        this.proj = proj;
        // cache UI values on the UI thread to avoid SWT "Invalid thread access"
        this.dbType = pageDb.getDbType();
        this.isInit = pageDb.isInit();
        this.dbInfo = pageDb.getDbInfo();
        this.dumpPath = pageDb.getDumpPath();
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + proj.getPathToProject()); //$NON-NLS-1$

            SubMonitor pm = SubMonitor.convert(monitor, Messages.initProjectFromSource_initializing_project, 75);

            initRepoFromSource(pm);

            monitor.done();
        } catch (IOException | CoreException ex) {
            throw new InvocationTargetException(ex, Messages.initProjectFromSource_ioexception_while_creating_project
                    .formatted(ex.getLocalizedMessage()));
        }
    }

    private void initRepoFromSource(SubMonitor pm) throws InterruptedException, CoreException, IOException {
        SubMonitor taskpm = pm.newChild(25);

        ILoader loader = createLoader(taskpm);
        IDatabase db = loader.loadAndAnalyze();

        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model);
        var provider = dbType.getDatabaseProvider();
        var settings = new UISettings(proj.getProject(), null, dbType);
        provider.getProjectUpdater(db, null, null, proj.getPathToProject(), settings).updateFull(false);
    }

    private ILoader createLoader(SubMonitor monitor) {
        IDatabaseProvider provider = dbType.getDatabaseProvider();
        if (!isInit) {
            return new StubDatabaseLoader(provider.createDatabase(), "Empty DB"); //$NON-NLS-1$
        }

        DiffSettings diffSettings = new DiffSettings(new UISettings(proj.getProject(), null, dbType),
                new UIMonitor(monitor));

        if (dbInfo != null) {
            return provider.getJdbcLoader(IDbInfoConnector.createConnector(dbInfo), diffSettings);
        }

        if (dumpPath != null) {
            return provider.getDumpLoader(dumpPath.toPath(), diffSettings);
        }

        throw new IllegalStateException(Messages.initProjectFromSource_init_request_but_no_schema_source);
    }
}
