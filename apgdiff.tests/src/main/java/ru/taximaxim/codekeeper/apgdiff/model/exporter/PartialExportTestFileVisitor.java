package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class PartialExportTestFileVisitor extends SimpleFileVisitor<Path>{
    private final Path pathToBeCompared;
    private final Path pathToCompareTo;
    private final Path pathFullExported;

    private final Map<String, String> modifiedFiles;
    private final List<String> newFiles;
    private final List<String> deletedFiles;
    private final boolean isInSource;

    public PartialExportTestFileVisitor(Path pathToBeCompared, Path pathToCompareTo, Path pathFullExported,
            Map<String, String> modifiedFiles, LinkedList<String> newFiles, LinkedList<String> deletedFiles,
            boolean isInSource) {
        super();
        this.pathToBeCompared = pathToBeCompared;
        this.pathToCompareTo = pathToCompareTo;
        this.pathFullExported = pathFullExported;

        this.modifiedFiles = modifiedFiles;
        this.newFiles = newFiles;
        this.deletedFiles = deletedFiles;
        this.isInSource = isInSource;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file1, BasicFileAttributes attrs) throws IOException{
        String relativeFilePath = pathToBeCompared.relativize(file1).toString();
        File file2 = new File(pathToCompareTo.toFile(), relativeFilePath);

        if (!file2.exists() && isInSource){
            if (!deletedFiles.contains(relativeFilePath)){
                fail(isInSource() + "file is missing but not in deleted list: " + relativeFilePath);
            }
            deletedFiles.remove(relativeFilePath);
        }
        if (!file2.exists() && !isInSource){
            if (!newFiles.contains(relativeFilePath)){
                fail(isInSource() + "file is missing but not in new list: " + relativeFilePath);
            }
            newFiles.remove(relativeFilePath);
        }
        if (file2.exists() && file2.isDirectory()){
            fail(isInSource() + "file is a directory: " + relativeFilePath);
        }

        if (file2.exists() && !Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2.toPath()))){
            if (!modifiedFiles.containsKey(relativeFilePath)){
                fail(isInSource() + "Source and target files differ, but this file is "
                        + "not in list of modified objects: " + relativeFilePath);
            }
            String hash = modifiedFiles.remove(relativeFilePath);

            File file = isInSource ? file2 : file1.toFile();
            File fileNewFull = new File(pathFullExported.toFile(), relativeFilePath);

            if (!fileNewFull.isFile()){
                fail(isInSource() + "Source and target files differ, but same file in newFull "
                        + "does not exist or a directory: " + relativeFilePath);
            }

            Assert.assertEquals("Files differ, and partial file has unexpected hash",
                    hash,
                    PgDiffUtils.md5(new String(Files.readAllBytes(file.toPath()), PartialExporterTest.UTF_8)));
        }
        return FileVisitResult.CONTINUE;
    }

    private String isInSource(){
        return "Walking " + (isInSource ? "full export" : "partial export") + " directory: ";
    }
}