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
package ru.taximaxim.codekeeper.core.model.exporter;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

public class PartialExportTestFileVisitor extends SimpleFileVisitor<Path> {

    private final Path pathToBeCompared;
    private final Path pathToCompareTo;

    private final Map<String, String> modifiedFiles;
    private final List<String> newFiles;
    private final List<String> deletedFiles;
    private final boolean isInSource;

    public PartialExportTestFileVisitor(Path pathToBeCompared, Path pathToCompareTo,
            Map<String, String> modifiedFiles, List<String> newFiles, List<String> deletedFiles,
            boolean isInSource) {
        this.pathToBeCompared = pathToBeCompared;
        this.pathToCompareTo = pathToCompareTo;

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
    public FileVisitResult visitFile(Path file1, BasicFileAttributes attrs) throws IOException {
        String relativeFilePath = pathToBeCompared.relativize(file1).toString().replace('\\', '/');
        File file2 = new File(pathToCompareTo.toFile(), relativeFilePath);

        if (!file2.exists() && isInSource) {
            if (!deletedFiles.contains(relativeFilePath)) {
                fail(isInSource() + "file is missing but not in deleted list: " + relativeFilePath);
            }
            deletedFiles.remove(relativeFilePath);
        }
        if (!file2.exists() && !isInSource) {
            if (!newFiles.contains(relativeFilePath)) {
                fail(isInSource() + "file is missing but not in new list: " + relativeFilePath);
            }
            newFiles.remove(relativeFilePath);
        }
        if (file2.isDirectory()) {
            fail(isInSource() + "file is a directory: " + relativeFilePath);
        }

        if (file2.exists() && !Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2.toPath()))) {
            if (!modifiedFiles.containsKey(relativeFilePath)) {
                fail(isInSource() + "Source and target files differ, but this file is "
                        + "not in list of modified objects: " + relativeFilePath);
            }
            String hash = modifiedFiles.remove(relativeFilePath);
            File file = isInSource ? file2 : file1.toFile();
            String partialFile = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

            Assertions.assertEquals(
                    hash,
                    PgDiffUtils.md5(partialFile), "Files differ, and partial file has unexpected hash"
                            + "\nPartial file:\n" + partialFile);
        }
        return FileVisitResult.CONTINUE;
    }

    private String isInSource() {
        return "Walking " + (isInSource ? "full export" : "partial export") + " directory: ";
    }
}