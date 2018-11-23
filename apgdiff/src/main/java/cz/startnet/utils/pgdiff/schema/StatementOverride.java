package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.List;

public class StatementOverride {
    private String owner;
    private final List<PgPrivilege> privileges = new ArrayList<>();

    public StatementOverride() {
    }

    public void addPrivilege(PgPrivilege privilege) {
        privileges.add(privilege);
    }

    public void addOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public List<PgPrivilege> getPrivileges() {
        return privileges;
    }
}
