package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;

public abstract class AbstractMsClrFunction extends AbstractFunction {

    protected final List<Argument> arguments = new ArrayList<>();
    protected final List<String> options = new ArrayList<>();
    private final String assembly;
    private final String assemblyClass;
    private final String assemblyMethod;

    public AbstractMsClrFunction(String name, String assembly, String assemblyClass,
            String assemblyMethod) {
        super(name);
        this.assembly = assembly;
        this.assemblyClass = assemblyClass;
        this.assemblyMethod = assemblyMethod;
    }

    protected abstract String getDeclaration(Argument arg,
            boolean includeDefaultValue, boolean includeArgName);

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void addOption(final String option) {
        options.add(option);
        resetHash();
    }

    public String getAssembly() {
        return assembly;
    }

    public String getAssemblyClass() {
        return assemblyClass;
    }

    public String getAssemblyMethod() {
        return assemblyMethod;
    }

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
     */
    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    /**
     * Compares two objects whether they are equal. If both objects are of the
     * same class but they equal just in whitespace in {@link #body}, they are
     * considered being equal.
     *
     * @param func                     object to be compared
     * @return true if {@code object} is PgFunction and the function code is
     *         the same when compared ignoring whitespace, otherwise returns
     *         false
     */
    public boolean compareUnalterable(AbstractMsClrFunction func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(assembly, func.getAssembly())
                    && Objects.equals(assemblyClass, func.getAssemblyClass())
                    && Objects.equals(assemblyMethod, func.getAssemblyMethod())
                    && arguments.equals(func.arguments)
                    && options.equals(func.options);
        }
        return equals;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractMsClrFunction && super.compare(obj)
                && compareUnalterable((AbstractMsClrFunction) obj);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(arguments);
        hasher.put(options);
        hasher.put(assembly);
        hasher.put(assemblyClass);
        hasher.put(assemblyMethod);
    }

    @Override
    public AbstractMsClrFunction shallowCopy() {
        AbstractMsClrFunction functionDst = getFunctionCopy();
        copyBaseFields(functionDst);
        functionDst.arguments.addAll(arguments);
        functionDst.options.addAll(options);
        return functionDst;
    }

    protected abstract AbstractMsClrFunction getFunctionCopy();
}
