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
 * Wrapper for creation and auto deletion of a temp file.
 * Intended for try-with-resources.
 *
 * @author Alexander Levsha
 */
public class TempFile implements AutoCloseable {

    private final Path f;

    public TempFile(String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(prefix, suffix);
    }

    public TempFile(Path dir, String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(dir, prefix, suffix);
    }

    public Path get() {
        return f;
    }

    @Override
    public void close() throws IOException {
        FileUtils.removeReadOnly(f);
    }
}
