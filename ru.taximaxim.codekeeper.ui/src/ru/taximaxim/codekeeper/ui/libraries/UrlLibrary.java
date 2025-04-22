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
import java.net.URI;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.utils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;

public class UrlLibrary extends CacheableLibrary {

    private URI uri;

    UrlLibrary(AbstractLibrary parent, URI uri, String project, DatabaseType dbType) {
        super(parent, FileUtils.getLoadedFilePath(LibraryUtils.META_PATH, uri),
                FileUtils.getNameFromUri(uri), uri.toString(), project, dbType);
        this.uri = uri;
    }

    @Override
    protected void appendLibState(StringBuilder sb) {
        if (!exists()) {
            sb.append(" [not loaded]"); //$NON-NLS-1$
        }
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(ProjectIcon.CLOUD);
    }

    @Override
    protected void load() throws IOException {
        FileUtils.loadURI(uri, name, path);
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
