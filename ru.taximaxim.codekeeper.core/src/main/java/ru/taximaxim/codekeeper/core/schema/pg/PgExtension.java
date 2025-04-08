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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Stores extension information.
 *
 * @author Alexander Levsha
 */
public final class PgExtension extends PgStatement {

    private String schema;
    private boolean relocatable;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.EXTENSION;
    }

    public PgExtension(String name) {
        super(name);
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(final String schema) {
        this.schema = schema;
        resetHash();
    }

    public void setRelocatable(boolean relocatable) {
        this.relocatable = relocatable;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) parent;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE EXTENSION ");
        appendIfNotExists(sbSQL, script.getSettings());
        sbSQL.append(getQualifiedName());

        if (schema != null && !schema.isEmpty()) {
            sbSQL.append(" SCHEMA ");
            sbSQL.append(schema);
        }

        script.addStatement(sbSQL);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgExtension newExt = (PgExtension) newCondition;
        boolean isNeedDepcies = false;
        if (!Objects.equals(newExt.schema, getSchema())) {
            if (!relocatable) {
                return ObjectState.RECREATE;
            }
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER EXTENSION ")
            .append(PgDiffUtils.getQuotedName(name))
            .append(" SET SCHEMA ")
            .append(newExt.getSchema());
            script.addStatement(sql);
            isNeedDepcies = true;
        }
        // TODO ALTER EXTENSION UPDATE TO ?

        appendAlterComments(newExt, script);
        return getObjectState(isNeedDepcies, script, startSize);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgExtension ext && super.compare(obj)) {
            return Objects.equals(schema, ext.schema);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(schema);
    }

    @Override
    public PgExtension shallowCopy() {
        PgExtension extDst = new PgExtension(name);
        copyBaseFields(extDst);
        extDst.setSchema(schema);
        return extDst;
    }
}
