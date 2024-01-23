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

import java.net.URI;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class UrlLibrary extends CacheableLibrary {

    UrlLibrary(AbstractLibrary parent, URI uri, String project, DatabaseType dbType) {
        super(parent, FileUtils.getLoadedFilePath(LibraryUtils.META_PATH, uri),
                FileUtils.getNameFromUri(uri), uri.toString(), project, dbType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (!exists()) {
            sb.append(" [not loaded]"); //$NON-NLS-1$
        }

        if (parent instanceof RootLibrary) {
            sb.append(CONCAT_STRING).append(getLibPath());
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONCLOUD);
    }
}
