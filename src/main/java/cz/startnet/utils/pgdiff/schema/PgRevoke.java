package cz.startnet.utils.pgdiff.schema;
/**
 * This is a support class for comment objects, it doesn't have name and should 
 * not be used in objects database 
 */
public class PgRevoke extends PgStatement {
    
    private String objName;
    

    public PgRevoke(String rawStatement) {
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
        PgRevoke revoke = new PgRevoke(getRawStatement());
        revoke.setObjName(getObjName());
        return null;
    }

    @Override
    public PgStatement deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgRevoke) {
            PgRevoke revoke = (PgRevoke)obj;
            return revoke.getObjName().equals(getObjName());
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgRevoke) {
            return compare((PgRevoke)obj);
        }
        return false;
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjName() == null) ? 0 : getObjName().hashCode());
        return result;
    }
}
