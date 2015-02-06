package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartialExportTestFileVisitor extends SimpleFileVisitor<Path>{
    private Path pathToBeCompared;
    private Path pathToCompareTo;
    private Path pathFullExported;
    
    private List<String> modifiedFiles;
    private List<String> newFiles;
    private List<String> deletedFiles; 
    private boolean isInSource;
    
    public PartialExportTestFileVisitor(Path pathToBeCompared, Path pathToCompareTo, Path pathFullExported, 
            LinkedList<String> modifiedFiles, LinkedList<String> newFiles, LinkedList<String> deletedFiles, 
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
        File file2 = new File(pathToCompareTo.toFile(),pathToBeCompared.relativize(file1).toString());
        
        String relativeFilePath = pathToBeCompared.relativize(file1).toString();
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
        
        if (file2.exists() && !Arrays.equals(computeChecksum(file1), computeChecksum(file2.toPath()))){
            if (!modifiedFiles.contains(relativeFilePath)){
                fail(isInSource() + "Source and target files differ, but this file is "
                        + "not in list of modified objects: " + relativeFilePath);
            }
            modifiedFiles.remove(relativeFilePath);
            File file = (File) (isInSource ? file2 : file1.toFile());
            File fileNewFull = new File(pathFullExported.toFile(), relativeFilePath);
            
            if (!fileNewFull.exists() || fileNewFull.isDirectory()){
                fail(isInSource() + "Source and target files differ, but same file in newFull "
                        + "does not exist or a directory: " + relativeFilePath);
            }
            if(!Arrays.equals(computeChecksum(file.toPath()), computeChecksum(fileNewFull.toPath()))){
                fail(isInSource() + "Files differ, and partial file differ with newFull: " + 
                        relativeFilePath);
            }
        }
        return FileVisitResult.CONTINUE;
    }
    
    private String isInSource(){
        return "Walking " + (isInSource ? "full export" : "partial export") + " directory: ";
    }
    
    private byte[] computeChecksum(Path filename) throws IOException {
        try(InputStream fis = new FileInputStream(filename.toFile())){

            byte[] buffer = new byte[1024];
            MessageDigest complete = null;
            try {
                complete = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                fail("No MD5 checksum method available");
            }
            int numRead;
    
            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    complete.update(buffer, 0, numRead);
                }
            } while (numRead != -1);
    
            return complete.digest();
        }
    }
}