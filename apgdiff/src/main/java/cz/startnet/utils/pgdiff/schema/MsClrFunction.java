package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsClrFunction extends AbstractMsClrFunction {

    private String returns;
    private FuncTypes funcType = FuncTypes.SCALAR;

    public MsClrFunction(String name, String assembly, String assemblyClass,
            String assemblyMethod) {
        super(name, assembly, assemblyClass, assemblyMethod);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getFunctionFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsClrFunction newFunction;
        if (newCondition instanceof MsClrFunction) {
            newFunction = (MsClrFunction) newCondition;
        } else if (newCondition instanceof MsFunction) {
            isNeedDepcies.set(true);
            return true;
        } else {
            return false;
        }

        if (!compareUnalterable(newFunction)) {
            if (!getFuncType().equals(newFunction.getFuncType())) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newFunction.getFunctionFullSQL(false));
            }
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            newFunction.alterOwnerSQL(sb);
        }

        alterPrivileges(newFunction, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP FUNCTION " + getQualifiedName() + GO;
    }

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue,
            boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append(arg.getName()).append(' ').append(arg.getDataType());

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        String mode = arg.getMode();

        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(' ').append(mode);
        }

        return sbString.toString();
    }

    private String getFunctionFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER OFF").append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS OFF").append(GO).append('\n');
        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(" FUNCTION ");
        sbSQL.append(getQualifiedName()).append('(');
        sbSQL.append(arguments.stream().map(arg -> getDeclaration(arg, true, true))
                .collect(Collectors.joining(", ")));
        sbSQL.append(')');

        sbSQL.append("\nRETURNS ").append(getReturns());

        if (!options.isEmpty()) {
            sbSQL.append("\nWITH ").append(String.join(", ", options)).append('\n');
        }

        sbSQL.append("AS\nEXTERNAL NAME ");
        sbSQL.append(MsDiffUtils.quoteName(getAssembly())).append('.');
        sbSQL.append(MsDiffUtils.quoteName(getAssemblyClass())).append('.');
        sbSQL.append(MsDiffUtils.quoteName(getAssemblyMethod()));
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    public FuncTypes getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncTypes funcType) {
        this.funcType = funcType;
        resetHash();
    }

    /**
     * @return the returns
     */
    @Override
    public String getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(String returns) {
        this.returns = returns;
        resetHash();
    }

    @Override
    public boolean compareUnalterable(AbstractMsClrFunction func) {
        return func instanceof MsClrFunction && super.compareUnalterable(func)
                && Objects.equals(returns, func.getReturns())
                && Objects.equals(getFuncType(), ((MsClrFunction) func).getFuncType());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getReturns());
        hasher.put(getFuncType());
    }

    @Override
    protected AbstractMsClrFunction getFunctionCopy() {
        MsClrFunction func =  new MsClrFunction(getName(), getAssembly(),
                getAssemblyClass(), getAssemblyMethod());
        func.setFuncType(getFuncType());
        func.setReturns(getReturns());
        return func;
    }
}
