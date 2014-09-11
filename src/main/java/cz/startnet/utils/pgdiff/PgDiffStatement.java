package cz.startnet.utils.pgdiff;

import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.schema.PgStatement;

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
    public enum DangerStatements {
        DROP_TABLE("DROP TABLE"),
        ALTER_COLUMN("ALTER COLUMN"),
        DROP_COLUMN("DROP COLUMN");
        
        private String statementPart;
        private DangerStatements(String value) {
            statementPart = value;
        }
        @Override
        public String toString() {
            return statementPart;
        }
    }
    
    public final DiffStatementType type;
    public final String objname;
    public final String statement;
    
    public PgDiffStatement(DiffStatementType type, PgStatement obj, String statement) {
        if (obj == null && type != DiffStatementType.OTHER){
            throw new IllegalArgumentException("null obj is only permitted when type is OTHER!");
        }
        this.type = type;
        this.objname = (obj == null) ? null : obj.getQualifiedName();
        this.statement = statement;
    }
    
    public boolean isStatementDanger(DangerStatements dst) {
        Pattern ptrn = Pattern.compile("^(.*" + dst + ".+)+$", Pattern.CASE_INSENSITIVE 
                | Pattern.DOTALL);
        return ptrn.matcher(statement).matches();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgDiffStatement) {
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
