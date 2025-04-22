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
package ru.taximaxim.codekeeper.cli;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import ru.taximaxim.codekeeper.core.utils.TempDir;

public abstract class ArgumentsProvider implements AutoCloseable {

    protected static final String STANDALONE = "pgcodekeeper_standalone_";

    protected final String resName;
    protected Path resFile;
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

    public Path getPredefinedResultFile() throws URISyntaxException, IOException {
        return getFile(FILES_POSTFIX.DIFF_SQL);
    }

    protected final Path getFile(FILES_POSTFIX postfix) throws URISyntaxException, IOException {
        return TestUtils.getPathToResource(this.getClass(), resName + postfix);
    }

    public Path getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile(STANDALONE, "");
        }

        return resFile;
    }

    public String getDiffFileContents() throws IOException {
        return new String(Files.readAllBytes(getDiffResultFile()), StandardCharsets.UTF_8);
    }

    public TempDir getParseResultDir() throws IOException {
        if (resDir == null){
            resDir = new TempDir(STANDALONE);
        }

        return resDir;
    }

    @Override
    public void close() {
        try {
            if (resFile != null && !Files.isDirectory(resFile)) {
                Files.deleteIfExists(resFile);
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