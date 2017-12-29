package cz.startnet.utils.pgdiff.schema.system;

import java.util.LinkedHashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemRelation extends PgSystemStatement {

    private static final long serialVersionUID = -3372437548966681543L;

    /**
     * Contains columns names and types
     */
    private final Map<String, String> columns = new LinkedHashMap<>();

    public PgSystemRelation(String name, DbObjType type) {
        super(name, type);
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public void addColumn(String name, String type) {
        columns.put(name, type);
    }
}