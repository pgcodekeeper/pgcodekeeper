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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.swt.graphics.Image;

public abstract class AbstractLibrary {

    protected static final String CONCAT_STRING = " - ";  //$NON-NLS-1$

    protected final AbstractLibrary parent;
    protected final Path path;
    protected final String name;
    protected final List<AbstractLibrary> children = new ArrayList<>();

    AbstractLibrary(AbstractLibrary parent, Path path) {
        this(parent, path, path.getFileName().toString());
    }

    AbstractLibrary(AbstractLibrary parent, Path path, String name) {
        this.parent = parent;
        this.path = path;
        this.name = name;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    private void addChild(AbstractLibrary child) {
        children.add(child);
    }

    public AbstractLibrary getParent() {
        return parent;
    }

    public List<AbstractLibrary> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public abstract Image getImage();

    public String getDescription() {
        return getDescriptionRecursive() + CONCAT_STRING + getPath();
    }

    protected String getDescriptionRecursive() {
        return parent == null ? getName() : (parent.getDescriptionRecursive() + '/' + getName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);

        if (parent instanceof RootLibrary) {
            sb.append(CONCAT_STRING).append(getLibPath());
        }

        return sb.toString();
    }

    public String getLibPath() {
        return path.toString();
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractLibrary) {
            AbstractLibrary lib = (AbstractLibrary) obj;
            return Objects.equals(path, lib.path)
                    && Objects.equals(name, lib.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
