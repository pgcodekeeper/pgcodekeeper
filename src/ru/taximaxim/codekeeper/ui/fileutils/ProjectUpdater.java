package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class ProjectUpdater {

    private final PgDatabase dbNew;
    private final PgDatabase dbOld;
    
    private final List<TreeElement> changedObjects;
    private final String encoding;
    private final File dirExport;

    /**
     * dbOld, changedObjects are necessary only for partial update
     */
    public ProjectUpdater(PgDatabase dbNew, PgDatabase dbOld, List<TreeElement> changedObjects, PgDbProject proj) {
        this.dbNew = dbNew;
        this.dbOld = dbOld;
        
        this.changedObjects = changedObjects;
        
        this.encoding = proj.getPrefs().get(PROJ_PREF.ENCODING, ""); //$NON-NLS-1$
        this.dirExport = proj.getPathToProject().toFile();
    }

    public void updatePartial() throws IOException {
        if (dbOld == null){
            throw new IOException("Old database should not be null for partial update.");
        }
        try (TempDir tmp = new TempDir(dirExport.toPath(), "tmp-export")) { //$NON-NLS-1$
            File dirTmp = tmp.get();
            
            try {
                for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
                    final Path sourcePath = Paths.get(dirExport.getCanonicalPath(), subdirName.toString());
                    final Path targetPath = Paths.get(dirTmp.getCanonicalPath(), subdirName.toString());
                    
                    Files.walkFileTree(sourcePath,new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(final Path dir,
                                final BasicFileAttributes attrs) throws IOException {
                            Files.createDirectories(targetPath.resolve(sourcePath
                                    .relativize(dir)));
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(final Path file,
                                final BasicFileAttributes attrs) throws IOException {
                            Files.copy(file,
                                    targetPath.resolve(sourcePath.relativize(file)));
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
                
                new ModelExporter(dirExport, dbNew, dbOld, changedObjects, encoding).exportPartial();
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR, "Error while updating project!" , ex);
            
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
                throw new IOException(Messages.ProjectUpdater_error_update, ex);
            }
        } catch (IOException ex) {
            throw new IOException(Messages.ProjectUpdater_error_no_tempdir, ex);
        }
    }
    
    public void updateFull() throws IOException {
        try (TempDir tmp = new TempDir(dirExport.toPath(), "tmp-export")) { //$NON-NLS-1$
            File dirTmp = tmp.get();
            
            try {
                safeCleanProjectDir(dirTmp);
                new ModelExporter(dirExport, dbNew, encoding).exportFull();
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR, "Error while updating project!" //$NON-NLS-1$
                        + " Trying to restore data from backup", ex); //$NON-NLS-1$
            
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
                throw new IOException(Messages.ProjectUpdater_error_update, ex);
            }
        } catch (IOException ex) {
            throw new IOException(Messages.ProjectUpdater_error_no_tempdir, ex);
        }
    }

    private void safeCleanProjectDir(File dirTmp) throws IOException {
        for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
            String sSubdirName = subdirName.toString();
            File dirOld = new File(dirExport, sSubdirName);
            if (dirOld.exists()) {
                Dir.moveDirAtomic(dirOld, new File(dirTmp, sSubdirName));
            }
        }
    }
    
    private void restoreProjectDir(File dirTmp) throws IOException {
        for (WORK_DIR_NAMES subdirName : WORK_DIR_NAMES.values()) {
            String sSubdirName = subdirName.toString();
            File subDir = new File(dirExport, sSubdirName);
            File subDirTemp = new File(dirTmp, sSubdirName);

            if (subDirTemp.exists()) {
                if (subDir.exists()) {
                    Dir.deleteRecursive(subDir);
                }
                Dir.moveDirAtomic(subDirTemp, subDir);
            }
        }
    }
}
