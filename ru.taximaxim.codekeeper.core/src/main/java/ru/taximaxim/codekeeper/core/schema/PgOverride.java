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
package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgOverride {

    private final PgStatement newStatement;
    private final PgStatement oldStatement;

    public PgOverride(PgStatement newStatement, PgStatement oldStatement) {
        this.newStatement = newStatement;
        this.oldStatement = oldStatement;
    }

    public PgStatement getOldStatement() {
        return oldStatement;
    }

    public PgStatement getNewStatement() {
        return newStatement;
    }

    public String getName() {
        return newStatement.getName();
    }

    public DbObjType getType() {
        return newStatement.getStatementType();
    }

    public String getNewPath() {
        return getStatementPath(newStatement);
    }

    public String getOldPath() {
        return getStatementPath(oldStatement);
    }

    private String getStatementPath(PgStatement st) {
        PgObjLocation loc = st.getLocation();
        if (loc != null) {
            return loc.getFilePath();
        }
        if (st.isLib()) {
            return st.getLibName();
        }
        return null;
    }

    public PgObjLocation getNewLocation() {
        return newStatement.getLocation();
    }

    public PgObjLocation getOldLocation() {
        return oldStatement.getLocation();
    }
}
