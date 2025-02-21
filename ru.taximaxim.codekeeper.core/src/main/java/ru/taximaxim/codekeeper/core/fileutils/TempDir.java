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
package ru.taximaxim.codekeeper.core.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Wrapper for creation and automatic recursive deletion of a temp directory.
 * Intended for try-with-resources.
 *
 * @author Alexander Levsha
 */
public class TempDir implements AutoCloseable {

    private final Path dir;

    public TempDir(String prefix) throws IOException {
        this.dir = Files.createTempDirectory(prefix);
    }

    public TempDir(Path dir, String prefix) throws IOException {
        this.dir = Files.createTempDirectory(dir, prefix);
    }

    public Path get() {
        return dir;
    }

    @Override
    public void close() throws IOException {
        FileUtils.deleteRecursive(dir);
    }
}
