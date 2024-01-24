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

import org.eclipse.jface.text.IRegion;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class SQLEditorMyRegion implements IRegion {

    private final PgObjLocation pgObjLocation;
    private final String comment;

    public SQLEditorMyRegion(PgObjLocation pgObjLocation, String comment) {
        this.pgObjLocation = pgObjLocation;
        this.comment = comment;
    }

    @Override
    public int getLength() {
        return pgObjLocation.getObjLength();
    }

    @Override
    public int getOffset() {
        return pgObjLocation.getOffset();
    }

    public PgObjLocation getPgObjLocation() {
        return pgObjLocation;
    }

    public String getComment() {
        return comment;
    }
}
