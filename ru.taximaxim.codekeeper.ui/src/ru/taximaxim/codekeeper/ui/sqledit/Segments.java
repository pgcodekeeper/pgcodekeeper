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

import org.eclipse.jface.text.Position;
import org.pgcodekeeper.core.model.difftree.DbObjType;
import org.pgcodekeeper.core.schema.PgObjLocation;

public class Segments extends Position {

    private final String name;
    private final DbObjType type;
    private final String action;

    /**
     * Creates a new segment covering the given range.
     *
     * @param offset the offset of the segment
     * @param length the length of the segment
     */
    public Segments(PgObjLocation loc) {
        super(loc.getOffset(), loc.getObjLength());
        this.name = loc.getObjName();
        this.type = loc.getType();
        this.action = loc.getAction();
    }

    public DbObjType getType() {
        return type;
    }

    @Override
    public String toString() {
        return action + ' ' + name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hashCode(action);
        result = prime * result + Objects.hashCode(name);
        result = prime * result + Objects.hashCode(type);
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
        Segments other = (Segments) obj;
        return Objects.equals(action, other.action)
                && Objects.equals(name, other.name) && type == other.type;
    }
}
