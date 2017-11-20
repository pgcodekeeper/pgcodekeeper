package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class PgSystemStatement implements Serializable {

    private static final long serialVersionUID = -3372437548966681543L;

    private final String schema;
    private final String name;
    private final DbObjType type;

    public PgSystemStatement(String schema, String name, DbObjType type) {
        this.schema = schema;
        this.name = name;
        this.type = type;
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
}