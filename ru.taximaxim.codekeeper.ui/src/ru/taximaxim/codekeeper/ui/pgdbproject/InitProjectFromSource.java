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
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.UIProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class InitProjectFromSource implements IRunnableWithProgress {

    private final DbSource src;
    private final PgDbProject proj;

    public InitProjectFromSource(PgDbProject proj, DbSource src) {
        this.proj = proj;
        this.src = src;
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + proj.getPathToProject()); //$NON-NLS-1$

            SubMonitor pm = SubMonitor.convert(monitor,
                    Messages.initProjectFromSource_initializing_project, 75);

            initRepoFromSource(pm);

            monitor.done();
        } catch (IOException | CoreException ex) {
            throw new InvocationTargetException(ex, MessageFormat.format(
                    Messages.initProjectFromSource_ioexception_while_creating_project,
                    ex.getLocalizedMessage()));
        }
    }

    /**
     * clean repository, generate new file structure, preserve and fix repo
     * metadata, repo rm/add, commit new revision
     */
    private void initRepoFromSource(SubMonitor pm) throws InterruptedException,
    CoreException, IOException {
        SubMonitor taskpm = pm.newChild(25); // 50

        AbstractDatabase db = src.get(taskpm);
        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model); // 75
        new UIProjectUpdater(db, proj).updateFull(false);
    }
}
