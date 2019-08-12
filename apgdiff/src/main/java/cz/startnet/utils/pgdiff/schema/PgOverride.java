package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        return newStatement.getLocation().getFilePath();
    }

    public String getOldPath() {
        return oldStatement.getLocation().getFilePath();
    }

    public PgObjLocation getNewLocation() {
        return newStatement.getLocation();
    }

    public PgObjLocation getOldLocation() {
        return oldStatement.getLocation();
    }
}
