package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsProcedure extends AbstractFunction implements SourceStatement {

    private String firstPart;
    private String secondPart;

    public MsProcedure(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getProcedureFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    private String getProcedureFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        if (!isCLR()) {
            appendSourceStatement(isCreate, sbSQL);
            sbSQL.append(GO);

            return sbSQL.toString();
        }

        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(" PROCEDURE ");
        sbSQL.append(getQualifiedName()).append('\n');

        if (!arguments.isEmpty()) {
            sbSQL.append(arguments.stream().map(arg -> getDeclaration(arg, true, true))
                    .collect(Collectors.joining(",\n"))).append('\n');
        }
        if (!options.isEmpty()) {
            sbSQL.append("WITH ").append(String.join(", ", options)).append('\n');
        }
        if (isForReplication()) {
            sbSQL.append("FOR REPLICATION\n");
        }
        sbSQL.append("AS\n");
        sbSQL.append(getBody());
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP PROCEDURE " + getQualifiedName() + GO;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsProcedure newProcedure;
        if (newCondition instanceof MsProcedure) {
            newProcedure = (MsProcedure)newCondition;
        } else {
            return false;
        }

        if (!checkForChanges(newProcedure)
                || !Objects.equals(getFirstPart(), newProcedure.getFirstPart())
                || !Objects.equals(getSecondPart(), newProcedure.getSecondPart())) {
            if (isCLR() != newProcedure.isCLR()) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newProcedure.getProcedureFullSQL(false));
            }
        }

        if (!Objects.equals(getOwner(), newProcedure.getOwner())) {
            sb.append(newProcedure.getOwnerSQL());
        }

        alterPrivileges(newProcedure, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String name = arg.getName();
        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(name);
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        if (arg.isVarying()) {
            sbString.append(" VARYING");
        }

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        String mode = arg.getMode();
        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(' ');
            sbString.append(mode);
        }

        if (arg.isReadOnly()) {
            sbString.append(" READONLY");
        }

        return sbString.toString();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsProcedure && super.compare(obj)) {
            MsProcedure proc = (MsProcedure) obj;
            return Objects.equals(getFirstPart(), proc.getFirstPart())
                    && Objects.equals(getSecondPart(), proc.getSecondPart());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
    }

    @Override
    protected AbstractFunction getFunctionCopy() {
        MsProcedure proc = new MsProcedure(getName(), getRawStatement());
        proc.setFirstPart(getFirstPart());
        proc.setSecondPart(getSecondPart());
        return proc;
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }
}
