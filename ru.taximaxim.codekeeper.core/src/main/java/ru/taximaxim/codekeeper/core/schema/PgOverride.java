package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgOverride {

    private final PgStatement newStatement;
    private final PgStatement oldStatement;

    public PgOverride(PgStatement newStatement, PgStatement oldStatement) {
        this.newStatement = newStatement;
        this.oldStatement = oldStatement;
    }

    public PgStatement getOldStatement() {
        return oldStatement;
    }

    public PgStatement getNewStatement() {
        return newStatement;
    }

    public String getName() {
        return newStatement.getName();
    }

    public DbObjType getType() {
        return newStatement.getStatementType();
    }

    public String getNewPath() {
        return getStatementPath(newStatement);
    }

    public String getOldPath() {
        return getStatementPath(oldStatement);
    }

    private String getStatementPath(PgStatement st) {
        PgObjLocation loc = st.getLocation();
        if (loc != null) {
            return loc.getFilePath();
        }
        if (st.isLib()) {
            return st.getLibName();
        }
        return null;
    }

    public PgObjLocation getNewLocation() {
        return newStatement.getLocation();
    }

    public PgObjLocation getOldLocation() {
        return oldStatement.getLocation();
    }
}
