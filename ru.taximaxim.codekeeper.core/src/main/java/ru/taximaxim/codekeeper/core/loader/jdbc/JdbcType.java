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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class JdbcType{

    public static final Map<String, String> DATA_TYPE_ALIASES;
    static {
        Map<String, String> aliases = new HashMap<>();

        // format_type.c, format_type_internal function
        aliases.put("bit","bit");
        aliases.put("bool","boolean");
        aliases.put("bpchar","character");
        aliases.put("float4","real");
        aliases.put("float8","double precision");
        aliases.put("int2","smallint");
        aliases.put("int4","integer");
        aliases.put("int8","bigint");
        aliases.put("numeric","numeric");
        aliases.put("interval","interval");
        aliases.put("time","time without time zone");
        aliases.put("timetz","time with time zone");
        aliases.put("timestamp","timestamp without time zone");
        aliases.put("timestamptz","timestamp with time zone");
        aliases.put("varbit","bit varying");
        aliases.put("varchar","character varying");

        DATA_TYPE_ALIASES = Collections.unmodifiableMap(aliases);
    }

    private final long oid;
    private final String typeName;
    private final String parentSchema;
    private final boolean isArrayType;
    private final long lastSysOid;

    /**
     * There are types, which names begin from underscore: they are simple
     * arrays and have 0 in typarray column.
     * <br><br>
     * There are also vector types - their typarray column values are not 0,
     * we do not convert those to simple arrays
     */
    public JdbcType(long oid, String typeName, long typelem, long typarray, String parentSchema,
            String elemname, long lastSysOid) {
        this.oid = oid;
        this.parentSchema = parentSchema;
        this.isArrayType = typarray == 0L && typelem != 0L;
        this.typeName = isArrayType ? elemname : typeName;
        this.lastSysOid = lastSysOid;
    }

    public String getSchemaQualifiedName(String targetSchemaName) {
        if (Consts.PG_CATALOG.equals(parentSchema)) {
            String dealias = DATA_TYPE_ALIASES.get(typeName);
            return dealias == null ? PgDiffUtils.getQuotedName(typeName) : dealias;
        }

        String qname = PgDiffUtils.getQuotedName(typeName);
        if (!targetSchemaName.equals(parentSchema)) {
            qname = PgDiffUtils.getQuotedName(parentSchema) + '.' + qname;
        }
        return qname;
    }

    public String getSchemaQualifiedName() {
        return getSchemaQualifiedName("");
    }

    /**
     * Returns the name of this type. If the type's schema name
     * differs from targetSchemaName, the returned type name is schema-qualified.
     * If this type is of array type, appends "[]" to the end.
     */
    public String getFullName(String targetSchemaName){
        String schemaQualName = getSchemaQualifiedName(targetSchemaName);
        return isArrayType ? schemaQualName + "[]" : schemaQualName;
    }

    public String getFullName() {
        return getFullName("");
    }

    /**
     *  Returns the GenericColumn which contains type's schema name and type's name.
     */
    public GenericColumn getQualifiedName() {
        if (Consts.PG_CATALOG.equals(parentSchema)) {
            String dealias = DATA_TYPE_ALIASES.get(typeName);
            return new GenericColumn(parentSchema, dealias == null ? typeName : dealias,
                    DbObjType.TYPE);
        }
        return new GenericColumn(parentSchema, typeName, DbObjType.TYPE);
    }

    public void addTypeDepcy(PgStatement st) {
        if (oid > lastSysOid && !Utils.isPgSystemSchema(parentSchema)) {
            st.addDep(new GenericColumn(parentSchema, typeName, DbObjType.TYPE));
        }
    }
}
