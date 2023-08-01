/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.fileutils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.model.exporter.MsModelExporter;
import ru.taximaxim.codekeeper.core.model.exporter.OverridesModelExporter;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class ProjectUpdater {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectUpdater.class);

    private final PgDatabase dbNew;
    private final PgDatabase dbOld;

    private final Collection<TreeElement> changedObjects;
    private final String encoding;
    private final Path dirExport;
    private final boolean isMsSql;
    private final boolean overridesOnly;

    public ProjectUpdater(PgDatabase dbNew, boolean isMsSql, String encoding, Path dirExport) {
        this(dbNew, null, null, isMsSql, encoding, dirExport, false);
    }

    public ProjectUpdater(PgDatabase dbNew, PgDatabase dbOld, Collection<TreeElement> changedObjects,
            boolean isMsSql, String encoding, Path dirExport, boolean overridesOnly) {
        this.dbNew = dbNew;
        this.dbOld = dbOld;

        this.changedObjects = changedObjects;

        this.encoding = encoding;
        this.dirExport = dirExport;

        this.isMsSql = isMsSql;
        this.overridesOnly = overridesOnly;
    }

    public void updatePartial() throws IOException {

        LOG.info("Project updater: started partial"); //$NON-NLS-1$
        if (dbOld == null){
            throw new IOException(Messages.ProjectUpdater_old_db_null);
        }

        boolean caughtProcessingEx = false;
        try (TempDir tmp = new TempDir(dirExport, "tmp-export")) { //$NON-NLS-1$
            Path dirTmp = tmp.get();

            try {
                AbstractModelExporter exporter;
                if (overridesOnly) {
                    updateFolder(dirTmp, Consts.OVERRIDES_DIR);

                    exporter = new OverridesModelExporter(dirExport, dbNew, dbOld,
                            changedObjects, encoding, isMsSql);
                } else if (isMsSql) {
                    for (MS_WORK_DIR_NAMES subdir : MS_WORK_DIR_NAMES.values()) {
                        updateFolder(dirTmp, subdir.getDirName());
                    }

                    exporter = new MsModelExporter(dirExport, dbNew, dbOld,
                            changedObjects, encoding);
                } else {
                    for (WORK_DIR_NAMES subdir : WORK_DIR_NAMES.values()) {
                        updateFolder(dirTmp, subdir.toString());
                    }

                    exporter = new ModelExporter(dirExport, dbNew, dbOld,
                            changedObjects, encoding);
                }
                exporter.exportPartial();
            } catch (Exception ex) {
                caughtProcessingEx = true;

                LOG.error("Error while updating project!", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    LOG.error("Error while restoring backups after update error!", exRestore); //$NON-NLS-1$
                    IOException exNew = new IOException(
                            Messages.ProjectUpdater_error_backup_restore, exRestore);
                    exNew.addSuppressed(ex);
                    throw exNew;
                }
                throw new IOException(MessageFormat.format(
                        Messages.ProjectUpdater_error_update,
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            if (caughtProcessingEx) {
                // exception & err msg are already formed in the inner catch
                throw ex;
            }
            throw new IOException(MessageFormat.format(
                    Messages.ProjectUpdater_error_no_tempdir,
                    ex.getLocalizedMessage()), ex);
        }
    }

    private void updateFolder(Path dirTmp, String folder) throws IOException {
        final Path sourcePath = dirExport.resolve(folder);
        if (Files.exists(sourcePath)) {
            final Path targetPath = dirTmp.resolve(folder);

            Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Files.createDirectories(targetPath.resolve(sourcePath.relativize(dir)));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.copy(file, targetPath.resolve(sourcePath.relativize(file)));
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }

    public void updateFull(boolean projectOnly) throws IOException {
        LOG.info("Project updater: started full"); //$NON-NLS-1$
        boolean caughtProcessingEx = false;
        try (TempDir tmp = new TempDir(dirExport, "tmp-export")) { //$NON-NLS-1$
            Path dirTmp = tmp.get();

            try {
                safeCleanProjectDir(dirTmp);
                if (isMsSql) {
                    new MsModelExporter(dirExport, dbNew, encoding).exportFull();
                } else {
                    new ModelExporter(dirExport, dbNew, encoding).exportFull();
                }
                if (projectOnly) {
                    restoreFolder(dirTmp, Consts.OVERRIDES_DIR);
                }
            } catch (Exception ex) {
                caughtProcessingEx = true;

                LOG.error("Error while updating project! Trying to restore data from backup", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    LOG.error("Error while restoring backups after update error!", exRestore); //$NON-NLS-1$
                    IOException exNew = new IOException(
                            Messages.ProjectUpdater_error_backup_restore, exRestore);
                    exNew.addSuppressed(ex);
                    throw exNew;
                }
                throw new IOException(MessageFormat.format(
                        Messages.ProjectUpdater_error_update,
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            if (caughtProcessingEx) {
                // exception & err msg are already formed in the inner catch
                throw ex;
            }
            throw new IOException(MessageFormat.format(
                    Messages.ProjectUpdater_error_no_tempdir,
                    ex.getLocalizedMessage()), ex);
        }
    }

    private void safeCleanProjectDir(Path dirTmp) throws IOException {
        if (isMsSql) {
            for (MS_WORK_DIR_NAMES subdirName : MS_WORK_DIR_NAMES.values()) {
                moveFolder(dirTmp, subdirName.getDirName());
            }
        } else {
            for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
                moveFolder(dirTmp, subdirName.toString());
            }
        }

        moveFolder(dirTmp, Consts.OVERRIDES_DIR);
    }

    private void moveFolder(Path dirTmp, String folder) throws IOException {
        Path dirOld = dirExport.resolve(folder);
        if (Files.exists(dirOld)) {
            Files.move(dirOld, dirTmp.resolve(folder), StandardCopyOption.ATOMIC_MOVE);
        }
    }

    private void restoreProjectDir(Path dirTmp) throws IOException {
        if (isMsSql) {
            for (MS_WORK_DIR_NAMES subdirName : MS_WORK_DIR_NAMES.values()) {
                restoreFolder(dirTmp, subdirName.getDirName());
            }
        } else {
            for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
                restoreFolder(dirTmp, subdirName.toString());
            }
        }

        restoreFolder(dirTmp, Consts.OVERRIDES_DIR);
    }

    private void restoreFolder(Path dirTmp, String folder) throws IOException {
        Path subDir = dirExport.resolve(folder);
        Path subDirTemp = dirTmp.resolve(folder);

        if (Files.exists(subDirTemp)) {
            if (Files.exists(subDir)) {
                FileUtils.deleteRecursive(subDir);
            }
            Files.move(subDirTemp, subDir, StandardCopyOption.ATOMIC_MOVE);
        }
    }
}
