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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.PgDiff;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.monitor.IMonitor;
import org.pgcodekeeper.core.schema.AbstractDatabase;
import org.pgcodekeeper.core.schema.PgStatement;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

public final class Differ implements IRunnableWithProgress {

    private final AbstractDatabase oldDb;
    private final AbstractDatabase newDb;
    private final TreeElement root;
    private final String timezone;
    private final DatabaseType dbType;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    private String diffDirect;

    private List<Entry<PgStatement, PgStatement>> additionalDepciesOldDb;
    private List<Entry<PgStatement, PgStatement>> additionalDepciesNewDb;


    public void setAdditionalDepciesOldDb(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesOldDb = additionalDepcies;
    }

    public void setAdditionalDepciesNewDb(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesNewDb = additionalDepcies;
    }

    public void addAdditionalDepciesOldDb(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        if (this.additionalDepciesOldDb == null) {
            setAdditionalDepciesOldDb(additionalDepcies);
        } else {
            this.additionalDepciesOldDb.addAll(additionalDepcies);
        }
    }

    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesOldDb() {
        return additionalDepciesOldDb;
    }

    public Differ(AbstractDatabase oldDb, AbstractDatabase newDb, TreeElement root,
            String timezone, IProject proj, Map<String, Boolean> oneTimePrefs, DatabaseType dbType) {
        this.oldDb = oldDb;
        this.newDb = newDb;
        this.root = root;
        this.timezone = timezone;
        this.dbType = dbType;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    public Differ(AbstractDatabase oldDb, AbstractDatabase newDb, TreeElement root,
            String timezone, IProject proj) {
        this(oldDb, newDb, root, timezone, proj, null, null);
    }

    public Job getDifferJob() {
        return new Job(Messages.differ_get_differ) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    Differ.this.run(monitor);
                } catch (InvocationTargetException e) {
                    return new Status(IStatus.ERROR, PLUGIN_ID.THIS,
                            Messages.error_in_the_project_modifier_thread, e);
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
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
    InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor, Messages.calculating_diff, 100); // 0

        Log.log(Log.LOG_INFO, "Diff from: " + oldDb.getName() //$NON-NLS-1$
        + " to: " + newDb.getName()); //$NON-NLS-1$

        pm.newChild(25).subTask(Messages.differ_direct_diff); // 75
        try {
            UISettings settings = new UISettings(proj, oneTimePrefs, dbType);
            diffDirect = new PgDiff(settings).diff(
                    root,
                    oldDb, newDb,
                    additionalDepciesOldDb, additionalDepciesNewDb, null);
        } catch (IOException e) {
            throw new InvocationTargetException(e, e.getLocalizedMessage());
        }

        IMonitor.checkCancelled(new UIMonitor(monitor));
        monitor.done();
    }
}
