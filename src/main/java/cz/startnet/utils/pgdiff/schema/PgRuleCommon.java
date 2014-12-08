package cz.startnet.utils.pgdiff.schema;
/**
 * This is a support class for comment objects, it doesn't have name and should 
 * not be used in objects database 
 */
public class PgRuleCommon extends PgStatement {
    
    private String objName;
    private String body;
    private boolean revoke= false;
    

    public PgRuleCommon(String rawStatement) {
        super("", rawStatement);
    }
    
    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
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
    public PgStatement shallowCopy() {
        PgRuleCommon revoke = new PgRuleCommon(getRawStatement());
        revoke.setObjName(getObjName());
        revoke.setRevoke(isRevoke());
        revoke.setBody(getBody());
        return null;
    }

    @Override
    public PgStatement deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgRuleCommon) {
            PgRuleCommon revoke = (PgRuleCommon)obj;
            return revoke.getObjName().equals(getObjName()) 
                    && revoke.isRevoke() == isRevoke()
                    && revoke.getBody().equals(getBody());
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgRuleCommon) {
            return compare((PgRuleCommon)obj);
        }
        return false;
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjName() == null) ? 0 : getObjName().hashCode());
        result = prime * result + (isRevoke() ? 1231 : 1237);
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        return result;
    }

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
