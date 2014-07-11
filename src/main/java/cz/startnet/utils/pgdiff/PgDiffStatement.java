package cz.startnet.utils.pgdiff;


/**
 * A diff-script statement.
 * Statement equality is checked for object names only for DROP/CREATE statements
 * and for full statement text for OTHER statements.
 * 
 * @author Alexander Levsha
 */
public class PgDiffStatement {

    public enum DiffStatementType {
        DROP, CREATE, OTHER
    }
    
    public final DiffStatementType type;
    public final String objname;
    public final String statement;
    
    public PgDiffStatement(DiffStatementType type, String objname, String statement) {
        this.type = type;
        this.objname = objname;
        this.statement = statement;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof PgDiffStatement) {
            PgDiffStatement st = (PgDiffStatement) obj;
            
            if (st.type == DiffStatementType.OTHER) {
                eq = statement.equals(st.statement);
            } else {
                eq = type == st.type
                        && objname.equals(st.objname);
            }
        }
        
        return eq;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (type == DiffStatementType.OTHER) {
            result = prime * result + ((statement == null) ? 0 : statement.hashCode());
        } else {
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((objname == null) ? 0 : objname.hashCode());
        }
        return result;
    }
}
