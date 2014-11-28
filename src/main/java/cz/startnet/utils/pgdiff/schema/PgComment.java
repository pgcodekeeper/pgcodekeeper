package cz.startnet.utils.pgdiff.schema;
/**
 * This is a support class for comment objects, it doesn't have name and should 
 * not be used in objects database 
 */
public class PgComment extends PgStatement {
 
    private String comment;
    private String objName;
    
    public PgComment(String rawStatement) {
        super("", rawStatement);
    }
    
    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
        resetHash();
    }
    
    public void setComment(String comment) {
        this.comment = comment;
        resetHash();
    }
    
    public String getComment() {
        return comment;
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
        PgComment comm = new PgComment(getRawStatement());
        comm.setComment(getComment());
        comm.setObjName(getObjName());
        return comm;
    }

    @Override
    public PgStatement deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgComment) {
            PgComment comment = (PgComment)obj;
            return comment.getObjName().equals(getObjName()) 
                    && comment.getComment().equals(getComment());
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PgComment) {
            return compare((PgComment)obj);
        }
        return false;
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((objName == null) ? 0 : objName.hashCode());
        return result;
    }
}
