package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectUpdater {

    private final PgDatabase dbNew;
    private final PgDatabase dbOld;

    private final Collection<TreeElement> changedObjects;
    private final String encoding;
    private final Path dirExport;

    /**
     * dbOld, changedObjects are necessary only for partial update
     * @throws CoreException
     */
    public ProjectUpdater(PgDatabase dbNew, PgDatabase dbOld, Collection<TreeElement> checked, PgDbProject proj) throws CoreException {
        this.dbNew = dbNew;
        this.dbOld = dbOld;

        this.changedObjects = checked;

        this.encoding = proj.getProjectCharset();
        this.dirExport = proj.getPathToProject();
    }

    public void updatePartial() throws IOException {
        Log.log(Log.LOG_INFO, "Project updater: started partial"); //$NON-NLS-1$
        if (dbOld == null){
            throw new IOException(Messages.ProjectUpdater_old_db_null);
        }

        boolean caughtProcessingEx = false;
        try (TempDir tmp = new TempDir(dirExport, "tmp-export")) { //$NON-NLS-1$
            Path dirTmp = tmp.get();

            try {
                for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
                    final Path sourcePath = dirExport.resolve(subdirName.toString());
                    if (Files.exists(sourcePath)) {
                        continue;
                    }
                    final Path targetPath = dirTmp.resolve(subdirName.toString());

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

                new ModelExporter(dirExport.toFile(), dbNew, dbOld, changedObjects, encoding)
                .exportPartial();
            } catch (Exception ex) {
                caughtProcessingEx = true;

                Log.log(Log.LOG_ERROR, "Error while updating project!", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    Log.log(Log.LOG_ERROR,
                            "Error while restoring backups after update error!", //$NON-NLS-1$
                            exRestore);
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

    public void updateFull() throws IOException {
        Log.log(Log.LOG_INFO, "Project updater: started full"); //$NON-NLS-1$
        boolean caughtProcessingEx = false;
        try (TempDir tmp = new TempDir(dirExport, "tmp-export")) { //$NON-NLS-1$
            Path dirTmp = tmp.get();

            try {
                safeCleanProjectDir(dirTmp);
                new ModelExporter(dirExport.toFile(), dbNew, encoding).exportFull();
            } catch (Exception ex) {
                caughtProcessingEx = true;

                Log.log(Log.LOG_ERROR,
                        "Error while updating project! Trying to restore data from backup", ex); //$NON-NLS-1$

                try {
                    restoreProjectDir(dirTmp);
                } catch (Exception exRestore) {
                    Log.log(Log.LOG_ERROR,
                            "Error while restoring backups after update error!", //$NON-NLS-1$
                            exRestore);
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
        for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
            String sSubdirName = subdirName.toString();
            Path dirOld = dirExport.resolve(sSubdirName);
            if (Files.exists(dirOld)) {
                Files.move(dirOld, dirTmp.resolve(sSubdirName), StandardCopyOption.ATOMIC_MOVE);
            }
        }
    }

    private void restoreProjectDir(Path dirTmp) throws IOException {
        for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
            String sSubdirName = subdirName.toString();
            Path subDir = dirExport.resolve(sSubdirName);
            Path subDirTemp = dirTmp.resolve(sSubdirName);

            if (Files.exists(subDirTemp)) {
                if (Files.exists(subDir)) {
                    FileUtils.deleteRecursive(subDir);
                }
                Files.move(subDirTemp, subDir, StandardCopyOption.ATOMIC_MOVE);
            }
        }
    }
}
