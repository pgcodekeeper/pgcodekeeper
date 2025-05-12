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
package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

public class Differ implements IRunnableWithProgress {

    private final AbstractDatabase sourceDbFull;
    private final AbstractDatabase targetDbFull;
    private final TreeElement root;
    private final boolean needTwoWay;
    private final String timezone;
    private final DatabaseType dbType;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    private String diffDirect;
    private String diffReverse;

    private List<Entry<PgStatement, PgStatement>> additionalDepciesSource;
    private List<Entry<PgStatement, PgStatement>> additionalDepciesTarget;


    public void setAdditionalDepciesSource(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesSource = additionalDepcies;
    }

    public void setAdditionalDepciesTarget(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesTarget = additionalDepcies;
    }

    public void addAdditionalDepciesSource(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        if (this.additionalDepciesSource == null) {
            setAdditionalDepciesSource(additionalDepcies);
        } else {
            this.additionalDepciesSource.addAll(additionalDepcies);
        }
    }

    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource() {
        return additionalDepciesSource;
    }

    public Differ(AbstractDatabase sourceDbFull, AbstractDatabase targetDbFull, TreeElement root,
            boolean needTwoWay, String timezone, DatabaseType dbType, IProject proj,
            Map<String, Boolean> oneTimePrefs) {
        this.sourceDbFull = sourceDbFull;
        this.targetDbFull = targetDbFull;
        this.root = root;
        this.needTwoWay = needTwoWay;
        this.timezone = timezone;
        this.dbType = dbType;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    public Differ(AbstractDatabase sourceDbFull, AbstractDatabase targetDbFull, TreeElement root,
            boolean needTwoWay, String timezone, DatabaseType dbType, IProject proj) {
        this(sourceDbFull, targetDbFull, root, needTwoWay, timezone, dbType, proj, null);
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

    public String getDiffReverse() {
        if (diffReverse == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffReverse;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
    InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor, Messages.calculating_diff, 100); // 0

        Log.log(Log.LOG_INFO, "Diff from: " + sourceDbFull.getName() //$NON-NLS-1$
        + " to: " + targetDbFull.getName()); //$NON-NLS-1$

        pm.newChild(25).subTask(Messages.differ_direct_diff); // 75
        try (Getter source = new Getter(sourceDbFull, proj, oneTimePrefs);
                Getter target = new Getter(targetDbFull, proj, oneTimePrefs)) {
            // forceUnixNewLines has no effect on diff operaiton, just pass true
            PgDiffArguments args =
                    DbSource.getPgDiffArgs(Consts.UTF_8, timezone, true, dbType, proj, oneTimePrefs);
            diffDirect = new PgDiff(args).diff(
                    root,
                    sourceDbFull, targetDbFull,
                    additionalDepciesSource, additionalDepciesTarget, null);

            if (needTwoWay) {
                Log.log(Log.LOG_INFO, "Diff from: " + targetDbFull.getName() //$NON-NLS-1$
                + " to: " + sourceDbFull.getName()); //$NON-NLS-1$

                pm.newChild(25).subTask(Messages.differ_reverse_diff); // 100
                diffReverse = new PgDiff(args).diff(
                        root.getRevertedCopy(),
                        targetDbFull, sourceDbFull,
                        additionalDepciesTarget, additionalDepciesSource, null);
            }
        } catch (IOException e) {
            throw new InvocationTargetException(e, e.getLocalizedMessage());
        }

        PgDiffUtils.checkCancelled(pm);
        monitor.done();
    }

    // TODO костыль, сохраняет текущие аргументы, подменяет их новыми, при закрытии возвращает старые аргументы
    private static final class Getter implements AutoCloseable {
        private final Consumer<PgDiffArguments> consumer;
        private final PgDiffArguments oldArgs;

        public Getter(AbstractDatabase db, IProject proj, Map<String, Boolean> oneTimePrefs) {
            oldArgs = db.getArguments();
            consumer = (db::setArguments);
            PgDiffArguments newArgs = oldArgs.copy();
            // применить параметры для генерации кода ко всем БД
            OverridablePrefs prefs = new OverridablePrefs(proj, oneTimePrefs);
            newArgs.setConcurrentlyMode(
                    prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY));
            newArgs.setConstraintNotValid(
                    prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID));
            newArgs.setUsingTypeCastOff(
                    !prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.USING_ON_OFF));
            newArgs.setGenerateExists(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.GENERATE_EXISTS));
            newArgs.setGenerateExistDoBlock(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK));
            newArgs.setCommentsToEnd(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.COMMENTS_TO_END));

            db.setArguments(newArgs);
        }

        @Override
        public void close() {
            consumer.accept(oldArgs);
        }
    }
}
