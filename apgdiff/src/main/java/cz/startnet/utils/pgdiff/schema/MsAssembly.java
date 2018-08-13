package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsAssembly extends PgStatement {

    private final List<String> binaries = new ArrayList<>();
    private String permission = "SAFE";
    private boolean isVisible;

    public MsAssembly(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ASSEMBLY;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE ASSEMBLY ").append(MsDiffUtils.quoteName(name));
        if (owner != null) {
            sb.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }

        sb.append("\nFROM ").append(String.join(", ", binaries));
        sb.append("\nWITH PERMISSION_SET = ").append(permission);
        sb.append(GO);

        if (!isVisible) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = OFF").append(GO);
        }

        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP ASSEMBLY " + MsDiffUtils.quoteName(name) + " WITH NO DEPENDENTS" + GO;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsAssembly newAss;
        if (newCondition instanceof MsAssembly) {
            newAss = (MsAssembly)newCondition;
        } else {
            return false;
        }

        // https://docs.microsoft.com/ru-ru/sql/t-sql/statements/alter-assembly-transact-sql?view=sql-server-2016
        // TODO add/drop binary as file name. What is filename?
        if (!Objects.equals(newAss.getBinaries(), getBinaries())) {
            isNeedDepcies.set(true);
            return true;
        }


        if (!Objects.equals(getOwner(), newAss.getOwner())) {
            sb.append(newAss.getOwnerSQL());
        }

        if (newAss.isVisible() != isVisible()) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = ").append(newAss.isVisible() ? "ON" : "OFF").append(GO);
        }

        if (!Objects.equals(newAss.getPermission(), getPermission())) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH PERMISSION_SET = ").append(permission).append(GO);
        }

        return sb.length() > startLength;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(binaries);
        hasher.put(isVisible);
        hasher.put(permission);
    }

    @Override
    public MsAssembly shallowCopy() {
        MsAssembly assDst = new MsAssembly(getName(), getRawStatement());
        assDst.setPermission(getPermission());
        assDst.binaries.addAll(binaries);
        assDst.setOwner(getOwner());
        assDst.setVisible(isVisible());
        return assDst;
    }

    @Override
    public MsAssembly deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        return false;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(final String permission) {
        this.permission = permission;
        resetHash();
    }

    public List<String> getBinaries() {
        return Collections.unmodifiableList(binaries);
    }

    public void addBinary(final String binary) {
        binaries.add(binary);
        resetHash();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(final boolean isVisible) {
        this.isVisible = isVisible;
        resetHash();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
