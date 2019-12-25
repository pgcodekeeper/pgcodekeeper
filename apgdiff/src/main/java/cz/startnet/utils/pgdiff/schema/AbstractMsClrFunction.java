package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;

public abstract class AbstractMsClrFunction extends AbstractFunction {

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

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction function) {
        if (function instanceof AbstractMsClrFunction && super.compareUnalterable(function)) {
            AbstractMsClrFunction func = (AbstractMsClrFunction) function;
            return Objects.equals(assembly, func.getAssembly())
                    && Objects.equals(assemblyClass, func.getAssemblyClass())
                    && Objects.equals(assemblyMethod, func.getAssemblyMethod())
                    && options.equals(func.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(options);
        hasher.put(assembly);
        hasher.put(assemblyClass);
        hasher.put(assemblyMethod);
    }

    @Override
    public AbstractMsClrFunction shallowCopy() {
        AbstractMsClrFunction functionDst = (AbstractMsClrFunction) super.shallowCopy();
        functionDst.options.addAll(options);
        return functionDst;
    }
}
