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
        PgObjLocation loc = newStatement.getLocation();
        if (loc != null) {
            return loc.getFilePath();
        }

        if (newStatement.isLib()) {
            return newStatement.getLibName();
        }

        return null;
    }

    public String getOldPath() {
        PgObjLocation loc = oldStatement.getLocation();
        if (loc != null) {
            return loc.getFilePath();
        }
        if (oldStatement.isLib()) {
            return oldStatement.getLibName();
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
