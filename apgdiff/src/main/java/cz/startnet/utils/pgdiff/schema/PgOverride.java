package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgOverride {

    private final String name;
    private final DbObjType type;
    private final String newLocation;
    private final String oldLocation;

    public PgOverride(PgStatement st, String oldLocation) {
        this(st.getName(), st.getStatementType(), st.getLocation(), oldLocation);
    }

    public PgOverride(String name, DbObjType type, String newLocation, String oldLocation) {
        this.name = name;
        this.type = type;
        this.newLocation = newLocation;
        this.oldLocation = oldLocation;
    }

    public String getName() {
        return name;
    }

    public DbObjType getType() {
        return type;
    }

    public String getNewLocation() {
        return newLocation;
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
