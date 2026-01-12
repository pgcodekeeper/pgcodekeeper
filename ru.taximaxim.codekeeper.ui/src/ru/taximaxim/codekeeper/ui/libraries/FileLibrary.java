/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.pgcodekeeper.core.DatabaseType;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public class FileLibrary extends AbstractLibrary implements IStorage {

    private final String project;
    private final DatabaseType dbType;

    FileLibrary(AbstractLibrary parent, Path path, String project, DatabaseType dbType) {
        super(parent, path);
        this.project = project;
        this.dbType = dbType;
        LibraryStorage.addLibrary(this);
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    public String getProject() {
        return project;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Image getImage() {
        return Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE);
    }

    @Override
    public InputStream getContents() throws CoreException {
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, PLUGIN_ID.THIS, e.getLocalizedMessage(), e));
        }
    }

    @Override
    public IPath getFullPath() {
        return new org.eclipse.core.runtime.Path(path.toString()).makeAbsolute();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof FileLibrary lib && super.equals(obj)) {
            return dbType == lib.getDbType()
                    && Objects.equals(project, lib.project);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (dbType.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }
}
