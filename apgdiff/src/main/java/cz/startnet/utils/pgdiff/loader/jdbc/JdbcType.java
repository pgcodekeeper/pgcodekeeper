package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class JdbcType{

    private static final Map<String, String> DATA_TYPE_ALIASES;
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
    private final boolean isPgCatalog;

    /**
     * There are types, which names begin from underscore: they are simple
     * arrays and have 0 in typarray column.
     * <br><br>
     * There are also vector types - their typarray column values are not 0,
     * we do not convert those to simple arrays
     */
    public JdbcType(long oid, String typeName, long typelem, long typarray, String parentSchema,
            String elemname) {
        this.oid = oid;
        this.parentSchema = parentSchema;
        this.isArrayType = typarray == 0L && typelem != 0L;
        this.typeName = isArrayType ? elemname : typeName;
        this.isPgCatalog = "pg_catalog".equals(parentSchema);
    }

    public String getSchemaQualifiedName(String targetSchemaName) {
        if (isPgCatalog) {
            String dealias = DATA_TYPE_ALIASES.get(typeName);
            return dealias == null ? PgDiffUtils.getQuotedName(typeName) : dealias;
        }

        String qname = PgDiffUtils.getQuotedName(typeName);
        if (!targetSchemaName.equals(parentSchema)) {
            qname = PgDiffUtils.getQuotedName(parentSchema) + '.' + qname;
        }
        return qname;
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

    public void addTypeDepcy(PgStatement st) {
        if (!JdbcLoaderBase.isBuiltin(oid)
                && !isPgCatalog
                && !"information_schema".equals(parentSchema)) {
            st.addDep(new GenericColumn(parentSchema, typeName, DbObjType.TYPE));
        }
    }
}
