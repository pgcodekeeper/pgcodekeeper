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
package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.pgcodekeeper.core.api.PgCodeKeeperApi;
import org.pgcodekeeper.core.database.api.schema.*;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.settings.DiffSettings;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

public final class Differ implements IRunnableWithProgress {

    private final IDatabase oldDb;
    private final IDatabase newDb;
    private final TreeElement root;
    private final String timezone;
    private final DatabaseType dbType;
    private final DiffSettings diffSettings;

    private String diffDirect;

    public Differ(IDatabase oldDb, IDatabase newDb, TreeElement root, String timezone, IProject proj,
            Map<String, Object> oneTimePrefs, DatabaseType dbType, DiffSettings diffSettings) {
        this.oldDb = oldDb;
        this.newDb = newDb;
        this.root = root;
        this.timezone = timezone;
        this.dbType = dbType;
        this.diffSettings = diffSettings;
    }

    public Job getDifferJob() {
        return new Job(Messages.differ_get_differ) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    Differ.this.run(monitor);
                } catch (InvocationTargetException e) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.error_in_the_project_modifier_thread, e);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
    }

    public String getDiffDirect() {
        if (diffDirect == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffDirect;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        Log.log(Log.LOG_INFO, Messages.Differ_diff.formatted(oldDb.getName(), newDb.getName()));
        UIMonitor uiMonitor = new UIMonitor(monitor);

        try {
            diffSettings.setMonitor(uiMonitor);
            diffDirect = PgCodeKeeperApi.diff(dbType.getDatabaseProvider(), oldDb, newDb, diffSettings, root);
        } catch (IOException e) {
            throw new InvocationTargetException(e, e.getLocalizedMessage());
        }

        monitor.done();
    }
}
