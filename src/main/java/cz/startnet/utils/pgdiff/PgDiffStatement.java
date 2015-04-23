package cz.startnet.utils.pgdiff;

import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import cz.startnet.utils.pgdiff.schema.PgStatement;

/**
 * A diff-script statement.
 * Statement equality is checked for object names only for DROP/CREATE statements
 * and for full statement text for OTHER statements.
 * 
 * @author Alexander Levsha
 */
class PgDiffStatement {

    final DiffStatementType type;
    final String objname;
    final String statement;
    final DbObjType statementType;
    
    public enum DiffStatementType {
        DROP, CREATE, OTHER
    }
    
    private static final String ALTER_TABLE_PATTERN =
            "^ALTER[\\s]+TABLE[\\s]+"
            + "(IF[\\s]+EXISTS[\\s]+)?"
            + "(ONLY[\\s]+)?"
            + "([\\w]+[\\s]+)"
            + "(\\*[\\s]+)?";
    
    public enum DangerStatement {
        
        DROP_TABLE("^DROP[\\s]+TABLE.+"),
        
        ALTER_COLUMN(ALTER_TABLE_PATTERN
                // match ALTER [ COLUMN ] column_name [ SET DATA ] TYPE data_type
                + "ALTER[\\s]+(COLUMN[\\s]+)?([\\w]+[\\s]+)"
                + "(SET[\\s]+DATA[\\s]+)?(TYPE).+"),
                
        DROP_COLUMN(ALTER_TABLE_PATTERN
                // match 'DROP COLUMN' or 'DROP column_name'
                // but *not* 'DROP CONSTRAINT constraint_name'
                + "DROP[\\s]+(?!CONSTRAINT[\\s]+)([\\w]+).*");
        
        private final Pattern regex;
        
        private DangerStatement(String regex) {
            this.regex = Pattern.compile(regex,
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        }
        
        public Pattern getRegex() {
            return regex;
        }
    }
    
    public PgDiffStatement(DiffStatementType type, PgStatement obj, String statement) {
        if (obj == null && type != DiffStatementType.OTHER){
            throw new IllegalArgumentException("null obj is only permitted when type is OTHER!");
        }
        this.type = type;
        this.objname = (obj == null) ? null : obj.getQualifiedName();
        this.statement = statement;
        this.statementType = (obj == null) ? null : obj.getStatementType();
    }
    
    public boolean isDangerStatement(DangerStatement dst) {
        return dst.getRegex().matcher(statement).matches();
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
                        && objname.equals(st.objname)
                        && statementType == st.statementType;
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
            result = prime * result + ((statementType == null) ? 0 : statementType.hashCode());
        }
        return result;
    }
}
 