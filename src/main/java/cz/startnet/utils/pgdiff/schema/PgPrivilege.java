package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;

public class PgPrivilege extends PgStatement {
    
    private final boolean revoke;
    private final String definition;
    
    public boolean isRevoke() {
        return revoke;
    }
    
    public String getDefinition() {
        return definition;
    }
    
    public PgPrivilege(boolean revoke, String definition, String rawStatement) {
        super(null, rawStatement);
        
        this.revoke = revoke;
        this.definition = definition;
    }
    
    @Override
    public DbObjType getStatementType() {
        return null;
    }
    
    @Override
    public String getCreationSQL() {
        return new StringBuilder()
                .append(revoke? "REVOKE" : "GRANT")
                .append(' ')
                .append(definition)
                .append(';')
                .toString();
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
    public PgPrivilege deepCopy() {
        return shallowCopy();
    }
    
    @Override
    public PgPrivilege shallowCopy() {
        return new PgPrivilege(isRevoke(), getDefinition(), getRawStatement());
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgPrivilege){
            PgPrivilege priv = (PgPrivilege) obj;
            eq = revoke == priv.isRevoke()
                    && Objects.equals(definition, priv.getDefinition());
        }
        
        return eq;
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + (revoke ? itrue : ifalse);
        return result;
    }
}
