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
package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;

public abstract class CacheableLibrary extends AbstractLibrary {

    private final String libPath;
    private final String project;
    private final DatabaseType dbType;

    CacheableLibrary(AbstractLibrary parent, Path path, String name, String fullName,
            String project, DatabaseType dbType) {
        super(parent, path, name);
        this.libPath = fullName;
        this.project = project;
        this.dbType = dbType;
    }

    public void clear() throws IOException {
        clearAllChildren(children);
        children.clear();
        if (exists()) {
            FileUtils.deleteRecursive(getPath());
        }
    }

    public void refresh() throws IOException {
        children.clear();
        load();
        // do not refresh nested libs, they're not nested in UI tree
        new UiLibraryLoader(project, dbType, false, null).readLib(this, path.toString());
    }

    protected abstract void load() throws IOException;

    private void clearAllChildren(List<AbstractLibrary> children) throws IOException {
        for (AbstractLibrary child : children) {
            clearAllChildren(child.getChildren());
            if (child instanceof CacheableLibrary lib && lib.exists()) {
                FileUtils.deleteRecursive(lib.getPath());
            }
            if (child instanceof FileLibrary lib) {
                LibraryStorage.removeLibrary(lib.getPath().toString());
            }
        }
    }

    public boolean exists() {
        return Files.exists(getPath());
    }

    @Override
    public String getLibPath() {
        return libPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CacheableLibrary lib && super.equals(obj)) {
            return Objects.equals(libPath, lib.libPath);
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((libPath == null) ? 0 : libPath.hashCode());
        return result;
    }
}
