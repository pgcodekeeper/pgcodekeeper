package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;

public class Dir {

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     * 
     * @param f Directory
     * @throws IOException
     */
    public static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        ReadOnlyFileRemover.remove(f.toPath());
    }

    public static void cleanApgdiffTempDir(File outDir) {
        for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES
                .values()) {
            File subDir = new File(outDir, subdirName
                    + ApgdiffConsts.suffixSafeCopy);
            if (subDir.exists()) {
                try {
                    deleteRecursive(subDir);
                } catch (IOException e) {
                    Log.log(Log.LOG_ERROR,
                            "Error while trying clean temp directory: "
                                    + subDir.toPath(), e);
                }
            }
        }
    }

    /**
     * Safe Apgdiff WorkDirNames in folders Temp
     * 
     * @param outDir
     *            Directory to safe Apgdiff Workdirectories
     * @throws IOException
     *             Occurs when delete fails
     */
    public static void safeCleanApgdiffDir(File outDir) throws IOException {
        for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES
                .values()) {
            moveDir(new File(outDir, subdirName.toString()),
                    new File(outDir, subdirName
                            + ApgdiffConsts.suffixSafeCopy));
        }
    }

    /**
     * Trying to restore Apgdiff Work Directories from Temp directory
     * 
     * @param outDir
     *            Directory to restore (Warning: Apgdiff Work Directories will
     *            be cleaned)
     */
    public static void restoreApgdiffDir(File outDir) {
        for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES
                .values()) {
            File subDir = new File(outDir, subdirName.toString());
            File subDirTemp = new File(outDir, subdirName
                    + ApgdiffConsts.suffixSafeCopy);
            if (subDirTemp.exists()) {
                try {
                    moveDir(subDirTemp, subDir);
                } catch (IOException e) {
                    Log.log(Log.LOG_ERROR,
                            "Errors occurs while restore from backup directory"
                                    + subDirTemp.toPath(), e);
                }
            }
        }
    }
    
    private static void moveDir(File source, File destination)
            throws IOException {
        if (destination.exists()) {
            deleteRecursive(destination);
        }
        if (source.exists()) {
            Files.move(source.toPath(), destination.toPath(), new CopyOption[] {
                StandardCopyOption.ATOMIC_MOVE
            });
        }
    }

}
