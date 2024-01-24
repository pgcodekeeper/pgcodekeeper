/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.core.model.exporter.OverridesModelExporter;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class ProjectUpdater {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectUpdater.class);

    private final PgDatabase dbNew;
    private final PgDatabase dbOld;

    private final Collection<TreeElement> changedObjects;
    private final String encoding;
    private final Path dirExport;
    private final DatabaseType dbType;
    private final boolean overridesOnly;

    public ProjectUpdater(PgDatabase dbNew, DatabaseType dbType, String encoding, Path dirExport) {
        this(dbNew, null, null, dbType, encoding, dirExport, false);
    }

    public ProjectUpdater(PgDatabase dbNew, PgDatabase dbOld, Collection<TreeElement> changedObjects,
            DatabaseType dbType, String encoding, Path dirExport, boolean overridesOnly) {
        this.dbNew = dbNew;
        this.dbOld = dbOld;

        this.changedObjects = changedObjects;

        this.encoding = encoding;
        this.dirExport = dirExport;

        this.dbType = dbType;
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
                updatePartial(dirTmp);
            } catch (Exception ex) {
                caughtProcessingEx = true;

                LOG.error("Error while updating project!", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    LOG.error("Error while restoring backups after update error!", exRestore); //$NON-NLS-1$
                    IOException exNew = new IOException(Messages.ProjectUpdater_error_backup_restore, exRestore);
                    exNew.addSuppressed(ex);
                    throw exNew;
                }
                throw new IOException(
                        MessageFormat.format(Messages.ProjectUpdater_error_update, ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            if (caughtProcessingEx) {
                // exception & err msg are already formed in the inner catch
                throw ex;
            }
            throw new IOException(
                    MessageFormat.format(Messages.ProjectUpdater_error_no_tempdir, ex.getLocalizedMessage()), ex);
        }
    }

    private void updatePartial(Path dirTmp) throws IOException, PgCodekeeperException {
        if (overridesOnly) {
            updateFolder(dirTmp, WorkDirs.OVERRIDES);
            new OverridesModelExporter(dirExport, dbNew, dbOld, changedObjects, encoding, dbType).exportPartial();
            return;
        }

        for (String subdirName : WorkDirs.getDirectoryNames(dbType)) {
            updateFolder(dirTmp, subdirName);
        }

        AbstractModelExporter.exportPartial(dbType, dirExport, dbNew, dbOld, changedObjects, encoding);
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
                AbstractModelExporter.exportFull(dbType, dirExport, dbNew, encoding);
                if (projectOnly) {
                    restoreFolder(dirTmp, WorkDirs.OVERRIDES);
                }
            } catch (Exception ex) {
                caughtProcessingEx = true;

                LOG.error("Error while updating project! Trying to restore data from backup", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    LOG.error("Error while restoring backups after update error!", exRestore); //$NON-NLS-1$
                    IOException exNew = new IOException(Messages.ProjectUpdater_error_backup_restore, exRestore);
                    exNew.addSuppressed(ex);
                    throw exNew;
                }
                throw new IOException(
                        MessageFormat.format(Messages.ProjectUpdater_error_update, ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            if (caughtProcessingEx) {
                // exception & err msg are already formed in the inner catch
                throw ex;
            }
            throw new IOException(
                    MessageFormat.format(Messages.ProjectUpdater_error_no_tempdir, ex.getLocalizedMessage()), ex);
        }
    }

    private void safeCleanProjectDir(Path dirTmp) throws IOException {
        for (String subdirName : WorkDirs.getDirectoryNames(dbType)) {
            moveFolder(dirTmp, subdirName);
        }

        moveFolder(dirTmp, WorkDirs.OVERRIDES);
    }

    private void moveFolder(Path dirTmp, String folder) throws IOException {
        Path dirOld = dirExport.resolve(folder);
        if (Files.exists(dirOld)) {
            Files.move(dirOld, dirTmp.resolve(folder), StandardCopyOption.ATOMIC_MOVE);
        }
    }

    private void restoreProjectDir(Path dirTmp) throws IOException {
        for (String subdirName : WorkDirs.getDirectoryNames(dbType)) {
            restoreFolder(dirTmp, subdirName);
        }

        restoreFolder(dirTmp, WorkDirs.OVERRIDES);
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
