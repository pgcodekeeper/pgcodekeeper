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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.IWorkbenchAdapter;

import ru.taximaxim.codekeeper.core.DatabaseType;

public class SQLEditorInput extends PlatformObject implements IURIEditorInput, IPersistableElement {

    private static final AtomicInteger TMP_INPUT_COUNTER = new AtomicInteger(1);

    public static SQLEditorInput newTmpInput() {
        int number = TMP_INPUT_COUNTER.getAndIncrement();
        return new SQLEditorInput(Paths.get("/pgCodeKeeper/new query " + number), //$NON-NLS-1$
                null, DatabaseType.PG, false, true);
    }

    private final Path path;
    private final DatabaseType dbType;
    private final boolean isTemp;
    private final boolean isReadOnly;
    private final String project;

    public SQLEditorInput(Path path, DatabaseType dbType, boolean isReadOnly) {
        this(path, null, dbType, isReadOnly);
    }

    public SQLEditorInput(Path path, String project, DatabaseType dbType, boolean isReadOnly) {
        this(path, project, dbType, isReadOnly, false);
    }

    SQLEditorInput(Path path, String project, DatabaseType dbType, boolean isReadOnly, boolean isTemp) {
        this.path = path;
        this.project = project;
        this.dbType = dbType;
        this.isReadOnly = isReadOnly;
        this.isTemp = isTemp;
    }

    @Override
    public boolean exists() {
        return Files.exists(path);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return PlatformUI.getWorkbench().getEditorRegistry().getImageDescriptor(getName());
    }

    @Override
    public String getName() {
        return path.getFileName().toString();
    }

    @Override
    public IPersistableElement getPersistable() {
        return this;
    }

    @Override
    public String getToolTipText() {
        return isTemp ? getNullFileStoreUri().getPath() : path.toString();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (adapter.isAssignableFrom(IWorkbenchAdapter.class)) {
            return adapter.cast(new IWorkbenchAdapter() {

                @Override
                public Object getParent(Object o) {
                    // TODO should (?) be a DirectoryLibrary, but no way to construct it here
                    return null;
                }

                @Override
                public String getLabel(Object o) {
                    return getName();
                }

                @Override
                public ImageDescriptor getImageDescriptor(Object object) {
                    return SQLEditorInput.this.getImageDescriptor();
                }

                @Override
                public Object[] getChildren(Object o) {
                    return new Object[0];
                }
            });
        }
        return super.getAdapter(adapter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof SQLEditorInput) {
            SQLEditorInput input = (SQLEditorInput) o;
            return Objects.equals(path, input.path)
                    && Objects.equals(project, input.project)
                    && dbType == input.getDbType()
                    && isTemp == input.isTemp
                    && isReadOnly == input.isReadOnly;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + (dbType.hashCode());
        result = prime * result + (isTemp ? itrue : ifalse);
        result = prime * result + (isReadOnly ? itrue : ifalse);
        return result;
    }

    @Override
    public URI getURI() {
        return isTemp ? getNullFileStoreUri() : path.toUri();
    }

    private URI getNullFileStoreUri() {
        try {
            String path = this.path.toString();
            // fix Windows paths for URI (otherwise leading \ is treated as relative path)
            if (!path.startsWith("/")) { //$NON-NLS-1$
                path = path.replace(File.separatorChar, '/');
            }
            if (!path.startsWith("/")) { //$NON-NLS-1$
                path = '/' + path;
            }
            return new URI(EFS.SCHEME_NULL, null, path, null);
        } catch (URISyntaxException e) {
            //should never happen
            throw new IllegalStateException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public String getFactoryId() {
        return SQLEditorInputFactory.ID;
    }

    @Override
    public void saveState(IMemento memento) {
        SQLEditorInputFactory.saveState(memento, this);
    }

    public Path getPath() {
        return path;
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    public boolean isTemp() {
        return isTemp;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public String getProject() {
        return project;
    }
}
