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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Objects;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class SegmentsWithParent extends Segments implements IAdaptable {

    private final IFile parentFile;

    public SegmentsWithParent(PgObjLocation loc, IFile parentFile) {
        super(loc);
        this.parentFile = parentFile;
    }

    public IFile getParentFile() {
        return parentFile;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (adapter.isAssignableFrom(IFile.class)) {
            return adapter.cast(parentFile);
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hashCode(parentFile);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SegmentsWithParent other = (SegmentsWithParent) obj;
        return Objects.equals(parentFile, other.parentFile);
    }
}
