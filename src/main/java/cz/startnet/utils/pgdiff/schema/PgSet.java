package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;

/**
 * This is a support class for comment objects, it doesn't have name and should 
 * not be used in objects database 
 */
// TODO refactor, this shouldn't extend PgStatement and isn't really needed
@Deprecated
public class PgSet extends PgStatement {
    
    private String param;
    private List<String> values = new ArrayList<>();

    public PgSet(String rawStatement) {
        super("", rawStatement);
    }
    
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
        resetHash();
    }
    
    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }
    
    public void addValue(String value) {
        values.add(value);
        resetHash();
    }
    
    public void addAllValues(List<String> valueList) {
        values.addAll(valueList);
        resetHash();
    }

    @Override
    public String getCreationSQL() {
        return getRawStatement();
    }

    @Override
    public String getDropSQL() {
        return null;
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        return false;
    }

    @Override
    public PgStatement shallowCopy() {
        PgSet set = new PgSet(getRawStatement());
        set.setParam(getParam());
        set.addAllValues(getValues());
        return set;
    }

    @Override
    public PgStatement deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgSet) {
            PgSet set = (PgSet)obj;
            return set.getParam().equals(getParam()) 
                    && set.getValues().equals(getValues());
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgSet) {
            return compare((PgSet)obj);
        }
        return false;
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getValues() == null) ? 0 : getValues().hashCode());
        return result;
    }

    @Override
    public DbObjType getStatementType() {
        // TODO Auto-generated method stub
        return null;
    }
}
