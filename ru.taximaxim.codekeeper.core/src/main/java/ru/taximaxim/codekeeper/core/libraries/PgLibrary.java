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
package ru.taximaxim.codekeeper.core.libraries;

import java.util.Objects;

public class PgLibrary {

    private final String name;
    private final String path;
    private final boolean isIgnorePriv;
    private final String owner;

    public PgLibrary(String name, String path, boolean isIgnorePriv, String owner) {
        this.name = name;
        this.path = path;
        this.isIgnorePriv = isIgnorePriv;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isIgnorePriv() {
        return isIgnorePriv;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        if (!name.isBlank()) {
            return name;
        }

        return path;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PgLibrary)) {
            return false;
        }
        PgLibrary other = (PgLibrary) obj;
        return Objects.equals(getTitle(), other.getTitle());
    }
}