/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;

public class ZipLibrary extends CacheableLibrary {

    private Path sourcePath;

    ZipLibrary(AbstractLibrary parent, Path path, String project, DatabaseType dbType) {
        super(parent, FileUtils.getUnzippedFilePath(LibraryUtils.META_PATH, path),
                path.getFileName().toString(), path.toString(), project, dbType);
        this.sourcePath = path;
    }

    @Override
    protected void appendLibState(StringBuilder sb) {
        if (!exists()) {
            sb.append(" [not unzipped]"); //$NON-NLS-1$
        }
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(ProjectIcon.ZIP);
    }

    @Override
    protected void load() throws IOException {
        FileUtils.unzip(sourcePath, path);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
