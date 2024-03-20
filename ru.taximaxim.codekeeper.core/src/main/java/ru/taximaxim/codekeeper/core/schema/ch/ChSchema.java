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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChSchema extends AbstractSchema {

    private String engine = "Atomic";

    public ChSchema(String name) {
        super(name);
    }

    public void setEngine(String engine) {
        this.engine = engine;
        resetHash();
    }

    public String getEngine() {
        return engine;
    }

    @Override
    public String getCreationSQL() {
        var sb = new StringBuilder();
        sb.append("CREATE DATABASE ").append(getQualifiedName()).append("\nENGINE = ").append(engine);
        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(getComment());
        }
        sb.append(getSeparator());
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        if (!compare(newCondition)) {
            isNeedDepcies.set(true);
            return true;
        }
        return false;
    }

    @Override
    public String getDropSQL(boolean generateExists) {
        final StringBuilder sb = new StringBuilder();
        sb.append("DROP DATABASE ");
        if (generateExists) {
            sb.append("IF EXISTS ");
        }
        appendFullName(sb);
        sb.append(getSeparator());
        return sb.toString();
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        var schema = new ChSchema(name);
        schema.setEngine(engine);
        return schema;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(engine);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChSchema)) {
            return false;
        }
        var schema = (ChSchema) obj;
        return super.compare(schema)
                && Objects.equals(engine, schema.getEngine());
    }

    @Override
    public void appendComments(StringBuilder sb) {
        // no impl
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }
}
