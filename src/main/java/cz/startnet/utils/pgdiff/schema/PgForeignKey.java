package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PgForeignKey extends PgConstraint{
    
    private final List<GenericColumn> refs = new ArrayList<>();
    
    public PgForeignKey(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
    }

    public void addForeignColumn(GenericColumn referencedColumn) {
        refs.add(referencedColumn);
    }
    
    public List<GenericColumn> getRefs(){
        return Collections.unmodifiableList(refs);
    }
    
    @Override
    public PgForeignKey shallowCopy() {
        PgForeignKey foreignDst = new PgForeignKey(getName(), getRawStatement(), getSearchPath());
        foreignDst.setDefinition(getDefinition());
        foreignDst.setTableName(getTableName());
        foreignDst.setComment(getComment());
        foreignDst.refs.addAll(refs);
        return foreignDst;
    }
}
