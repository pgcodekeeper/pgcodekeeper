package cz.startnet.utils.pgdiff.schema;

import java.util.LinkedHashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemRelation extends PgSystemStatement {

    private static final long serialVersionUID = 8489271812962488959L;

    private final Map<String, String> columns = new LinkedHashMap<>();

    public PgSystemRelation(String schema, String name, DbObjType type) {
        super(schema, name, type);
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public void addColumn(String name, String type) {
        columns.put(name, type);
    }
}