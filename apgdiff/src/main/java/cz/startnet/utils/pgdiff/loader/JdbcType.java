package cz.startnet.utils.pgdiff.loader;

import java.util.HashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class JdbcType{

    private static final Map<String, String> DATA_TYPE_ALIASES = new HashMap<>();
    static {
        DATA_TYPE_ALIASES.put("int8","bigint");
        DATA_TYPE_ALIASES.put("serial8","bigserial");
        DATA_TYPE_ALIASES.put("varbit","bit varying");
        DATA_TYPE_ALIASES.put("bool","boolean");
        DATA_TYPE_ALIASES.put("char","character");
        DATA_TYPE_ALIASES.put("varchar","character varying");
        DATA_TYPE_ALIASES.put("float8","double precision");
        DATA_TYPE_ALIASES.put("int","integer");
        DATA_TYPE_ALIASES.put("int4","integer");
        DATA_TYPE_ALIASES.put("float4","real");
        DATA_TYPE_ALIASES.put("int2","smallint");
        DATA_TYPE_ALIASES.put("serial2","smallserial");
        DATA_TYPE_ALIASES.put("serial4","serial");
        DATA_TYPE_ALIASES.put("bigserial","bigint");
        DATA_TYPE_ALIASES.put("serial","integer");
        DATA_TYPE_ALIASES.put("timetz","time with time zone");
        DATA_TYPE_ALIASES.put("time","time without time zone");
        DATA_TYPE_ALIASES.put("timestamptz","timestamp with time zone");
        DATA_TYPE_ALIASES.put("timestamp","timestamp without time zone");
        DATA_TYPE_ALIASES.put("bpchar","character");
    }

    private final long oid;
    private final String typeName;
    private final String parentSchema;
    private final boolean isArrayType;

    /**
     * There are types, which names begin from underscore: they are simple
     * arrays and have 0 in typarray column.
     * <br><br>
     * There are also vector types - their typarray column values are not 0,
     * we do not convert those to simple arrays
     */
    public JdbcType(long oid, String typeName, String typelem, long typarray, String parentSchema) {
        this.oid = oid;
        this.parentSchema = parentSchema;
        this.isArrayType = typarray == 0L && typelem != null;

        String mainTypeName = typeName;
        if (isArrayType){
            mainTypeName = typelem;
        }
        String typeNameAlias = DATA_TYPE_ALIASES.get(mainTypeName);
        this.typeName = typeNameAlias == null ? mainTypeName : typeNameAlias;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getParentSchema() {
        return parentSchema;
    }

    public String getSchemaQualifiedName(String targetSchemaName) {
        if ("pg_catalog".equals(parentSchema)) {
            return typeName;
        } else {
            String qname = PgDiffUtils.getQuotedName(typeName);
            if (!targetSchemaName.equals(parentSchema)) {
                qname = PgDiffUtils.getQuotedName(targetSchemaName) + '.' + qname;
            }
            return qname;
        }
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
        if (!JdbcLoader.isBuiltin(oid)) {
            st.addDep(new GenericColumn(parentSchema, typeName, DbObjType.TYPE));
        }
    }
}
