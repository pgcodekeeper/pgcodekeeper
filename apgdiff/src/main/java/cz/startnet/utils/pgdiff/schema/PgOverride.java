package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgOverride {

    private final String name;
    private final DbObjType type;
    private final String newLocation;
    private final String newSql;
    private final String oldLocation;
    private final String oldSql;


    public PgOverride(PgStatement newSt, PgStatement oldSt) {
        name = newSt.getName();
        type = newSt.getStatementType();
        newLocation = newSt.getLocation();
        newSql = newSt.getCreationSQL();
        oldLocation = oldSt.getLocation();
        oldSql = oldSt.getCreationSQL();
    }

    public String getName() {
        return name;
    }

    public DbObjType getType() {
        return type;
    }

    public String getNewSql() {
        return newSql;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public String getOldSql() {
        return oldSql;
    }

    public String getOldLocation() {
        return oldLocation;
    }

    public boolean checkStatement(PgStatement st) {
        return name.equals(st.getName())
                && type.equals(st.getStatementType())
                && newLocation.equals(st.getLocation());
    }
}
