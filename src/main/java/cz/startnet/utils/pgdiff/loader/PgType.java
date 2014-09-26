package cz.startnet.utils.pgdiff.loader;

import java.util.HashMap;
import java.util.Map;

public class PgType{
    
    final private static Map<String, String> DATA_TYPE_ALIASES = new HashMap<String, String>(){
        {
            put("int8","bigint");
            put("serial8","bigserial");
            put("varbit","bit varying");
            put("bool","boolean");
            put("char","character");
            put("varchar","character varying");
            put("float8","double precision");
            put("int","integer");
            put("int4","integer");
            put("float4","real");
            put("int2","smallint");
            put("serial2","smallserial");
            put("serial4","serial");
            put("timetz","time with time zone");
            put("timestamptz","timestamp with time zone");
        }
    };
    
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
        this.typeName = typeName;
        this.typmodout = typmodout;
        this.parentSchema = parentSchema;
        
        if (DATA_TYPE_ALIASES.containsKey(typeName)){
            this.typeName = DATA_TYPE_ALIASES.get(typeName);   
        }else if (this.typeName.equals("bigserial")){
            this.typeName = "bigint";
        }else if (this.typeName.equals("serial")){
            this.typeName = "integer";
        }
        
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
