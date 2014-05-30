package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

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
    public String getCreationSQL() {
        return new StringBuilder(definition.length() + 16)
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
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + (revoke ? 1231 : 1237);
        return result;
    }
}
