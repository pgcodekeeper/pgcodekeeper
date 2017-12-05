package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemStatement implements Serializable {

    private static final long serialVersionUID = -3372437548966681543L;

    /**
     * Contains object schema name, null for schemas
     */
    private final String schema;
    private final String name;
    private final DbObjType type;

    /**
     * Contains columns names and types
     */
    private final Map<String, String> columns = new LinkedHashMap<>();

    public PgSystemStatement(String schema, String name, DbObjType type) {
        this.schema = schema;
        this.name = name;
        this.type = type;
    }

    /**
     * Create object with type equals schema by given name
     *
     * @param schemaName Schema name
     */
    public PgSystemStatement(String schemaName) {
        this.schema = null;
        this.name = schemaName;
        this.type = DbObjType.SCHEMA;
    }


    public String getName() {
        return name;
    }

    public String getSchema() {
        return schema;
    }

    public DbObjType getType() {
        return type;
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public void addColumn(String name, String type) {
        columns.put(name, type);
    }
}