package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;

abstract class ArgumentsProvider {

    protected static final String STANDALONE = "pgcodekeeper_standalone_";

    protected final String resName;
    protected File resFile;
    protected TempDir resDir;


    protected ArgumentsProvider() {
        this(null);
    }

    protected ArgumentsProvider(String resName) {
        this.resName = resName;
    }


    protected abstract String[] args() throws URISyntaxException, IOException;

    public String output() {
        return "";
    }

    public File getPredefinedResultFile() throws URISyntaxException, IOException {
        return getFile(FILES_POSTFIX.DIFF_SQL);
    }

    protected final File getFile(FILES_POSTFIX postfix) throws URISyntaxException, IOException {
        return ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource(resName + postfix));
    }

    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile(STANDALONE, "").toFile();
        }

        return resFile;
    }

    public TempDir getParseResultDir() throws IOException {
        if (resDir == null){
            resDir = new TempDir(STANDALONE);
        }

        return resDir;
    }

    public void close() {
        try {
            if (resFile != null && !resFile.isDirectory()){
                Files.deleteIfExists(resFile.toPath());
            }
        } catch (Exception e) {
            // do nothing
        }

        try {
            if (resDir != null) {
                resDir.close();
            }
        } catch (Exception e) {
            // do nothing
        }
    }
}