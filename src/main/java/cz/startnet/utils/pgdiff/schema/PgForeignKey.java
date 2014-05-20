package cz.startnet.utils.pgdiff.schema;

import java.util.HashMap;

public class PgForeignKey extends PgConstraint{
    
    private final HashMap<PgColumn, GenericColumn> refer = new HashMap<PgColumn, GenericColumn>(5);
    
    public PgForeignKey(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
    }

    public void setForeignColumn(PgColumn column, GenericColumn referredColumn) {
        refer.put(column, referredColumn);
    }
    
    public HashMap<PgColumn, GenericColumn> getForeigns(){
        return refer;
    }
    
    @Override
    public PgForeignKey shallowCopy() {
        PgForeignKey foreignDst = new PgForeignKey(getName(), getRawStatement(), getSearchPath());
        foreignDst.setDefinition(getDefinition());
        foreignDst.setTableName(getTableName());
        foreignDst.setComment(getComment());
        foreignDst.refer.putAll(refer);
        return foreignDst;
    }
}
