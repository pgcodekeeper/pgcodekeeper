package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.File;
import java.io.IOException;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class ProjectUpdater {

    private final PgDatabase db;
    private final String encoding;
    private final File dirExport;

    public ProjectUpdater(PgDatabase db, PgDbProject proj) {
        this.db = db;

        this.encoding = proj.getPrefs().get(PROJ_PREF.ENCODING, "");
        this.dirExport = proj.getPathToProject().toFile();
    }

    public void update() throws IOException {
        try (TempDir tmp = new TempDir(dirExport.toPath(), "tmp-export")) { //$NON-NLS-1$
            File dirTmp = tmp.get();
            
            try {
                safeCleanProjectDir(dirTmp);
                new ModelExporter(dirExport, db, encoding).export();
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
