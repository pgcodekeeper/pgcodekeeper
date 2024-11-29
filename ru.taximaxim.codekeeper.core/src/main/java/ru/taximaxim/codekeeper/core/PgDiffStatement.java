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
package ru.taximaxim.codekeeper.core;

import java.util.Collection;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

/**
 * A diff-script statement.
 * Statement equality is checked for object names only for DROP/CREATE statements
 * and for full statement text for OTHER statements.
 *
 * @author Alexander Levsha
 */
class PgDiffStatement {

    private final DiffStatementType type;
    private final String objname;
    private final Collection<SQLAction> statements;
    private final DbObjType statementType;

    public enum DiffStatementType {
        DROP, CREATE, OTHER
    }

    public PgDiffStatement(DiffStatementType type, PgStatement obj, Collection<SQLAction> statements) {
        if (obj == null && type != DiffStatementType.OTHER) {
            throw new IllegalArgumentException("null obj is only permitted when type is OTHER!");
        }
        this.type = type;
        this.objname = (obj == null) ? null : obj.getQualifiedName();
        this.statements = statements;
        this.statementType = (obj == null) ? null : obj.getStatementType();
    }

    public Collection<SQLAction> getStatements() {
        return statements;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgDiffStatement st) {
            if (st.type == DiffStatementType.OTHER) {
                return statements.equals(st.statements);
            }

            return type == st.type
                    && objname.equals(st.objname)
                    && statementType == st.statementType;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (type == DiffStatementType.OTHER) {
            result = prime * result + ((statements == null) ? 0 : statements.hashCode());
        } else {
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((objname == null) ? 0 : objname.hashCode());
            result = prime * result + ((statementType == null) ? 0 : statementType.hashCode());
        }
        return result;
    }
}
