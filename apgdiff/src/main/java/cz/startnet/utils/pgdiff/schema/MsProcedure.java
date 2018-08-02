package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsProcedure extends PgStatementWithSearchPath {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    private final List<String> options = new ArrayList<>();
    private final List<Argument> arguments = new ArrayList<>();
    private String body;
    private boolean isForReplication;

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
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(quotedIdentified ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        sbSQL.append("CREATE OR ALTER PROCEDURE ");
        sbSQL.append(getQualifiedName()).append('\n');

        appendArguments(sbSQL);
        sbSQL.append('\n');
        if (!options.isEmpty()) {
            sbSQL.append(" WITH ").append(String.join(", ", options)).append('\n');
        }
        if (isForReplication()) {
            sbSQL.append("FOR REPLICATION\n");
        }
        sbSQL.append("AS\n");
        sbSQL.append(getBody());
        sbSQL.append(GO);

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    public StringBuilder appendArguments(StringBuilder sb) {
        int startLenght = sb.length();
        for (final Argument argument : getArguments()) {
            sb.append(getDeclaration(argument, true, true));
            sb.append(",\n");
        }

        if (sb.length() > startLenght) {
            sb.setLength(sb.length() - 2);
        }

        return sb;
    }

    @Override
    public String getDropSQL() {
        return "DROP PROCEDURE " + getQualifiedName() + GO;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)getParent();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsProcedure newFunction;
        if (newCondition instanceof MsProcedure) {
            newFunction = (MsProcedure)newCondition;
        } else {
            return false;
        }
        if (!checkForChanges(newFunction)) {
            sb.append(newFunction.getCreationSQL());
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            sb.append(newFunction.getOwnerSQL());
        }
        alterPrivileges(newFunction, sb);
        return sb.length() > startLength;
    }

    private boolean checkForChanges(MsProcedure func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(name, func.getName())
                    && arguments.equals(func.arguments)
                    && options.equals(func.options)
                    && Objects.equals(isForReplication, func.isForReplication)
                    && Objects.equals(body, func.getBody());
        }
        return equals;
    }


    @Override
    public MsProcedure shallowCopy() {
        MsProcedure proc = new MsProcedure(getBareName(), getRawStatement());
        proc.setBody(getBody());
        proc.setForReplication(isForReplication());

        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(),
                    argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            argDst.setVarying(argSrc.isVarying());
            proc.addArgument(argDst);
        }

        for (PgPrivilege priv : revokes) {
            proc.addPrivilege(priv);
        }

        for (PgPrivilege priv : grants) {
            proc.addPrivilege(priv);
        }

        for (String option: options) {
            proc.addOption(option);
        }

        proc.setOwner(getOwner());
        proc.deps.addAll(deps);
        proc.setAnsiNulls(isAnsiNulls());
        proc.setQuotedIdentified(isQuotedIdentified());
        return proc;
    }

    @Override
    public MsProcedure deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsProcedure) {
            MsProcedure func  = (MsProcedure) obj;
            return  checkForChanges(func)
                    && Objects.equals(owner, func.getOwner())
                    && Objects.equals(grants, func.grants)
                    && Objects.equals(revokes, func.revokes)
                    && Objects.equals(quotedIdentified, func.isQuotedIdentified())
                    && Objects.equals(ansiNulls, func.isAnsiNulls());
        }

        return false;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.putOrdered(arguments);
        hasher.put(options);
        hasher.put(body);
        hasher.put(isForReplication);
        hasher.put(name);
        hasher.put(owner);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
    }

    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void addOption(final String option) {
        options.add(option);
        resetHash();
    }

    public boolean isForReplication() {
        return isForReplication;
    }

    public void setForReplication(boolean isForReplication) {
        this.isForReplication = isForReplication;
        resetHash();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        resetHash();
    }

    public String getDeclaration(Argument arg, boolean includeDefaultValue,  boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        if (getName() != null && !getName().isEmpty() && includeArgName) {
            sbString.append(getName());
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
}
