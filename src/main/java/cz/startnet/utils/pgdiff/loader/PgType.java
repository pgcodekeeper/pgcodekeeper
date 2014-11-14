package cz.startnet.utils.pgdiff.loader;

import java.util.HashMap;
import java.util.Map;

public class PgType{
    
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
        DATA_TYPE_ALIASES.put("timestamptz","timestamp with time zone");
    }
    
    private String typmodout;
    private String typeName;
    private String parentSchema;

    /** 
     * There are types, whose names begin from underscore: they are simple 
     * arrays and have 0 in typarray column. 
     * <br><br>
     * There are also vector types - their typarray column values are not 0, 
     * we do not convert those to simple arrays
     */
    public PgType(String typeName, String typelem, Long typarray, int typlen, String typmodout, String parentSchema) {
        this.typeName = DATA_TYPE_ALIASES.containsKey(typeName) ? DATA_TYPE_ALIASES.get(typeName) : typeName;
        this.typmodout = typmodout;
        this.parentSchema = parentSchema;
        
        if (typlen == -1 && typarray == 0L && !typelem.equals("-")){
            // TODO should we check whether typelem is in DATA_TYPE_ALIASES?
            this.typeName = typelem + "[]";
        }
    }
    
    /**
     * Returns type modifier output function name (typmodout of pg_type)
     */
    public String getTypmodout() {
        return typmodout;
    }
    
    /**
     * Returns type name. Can be either simple type name, or typename[]
     */
    public String getTypeName() {
        return typeName;
    }
    
    public String getParentSchema() {
        return parentSchema;
    }
}
