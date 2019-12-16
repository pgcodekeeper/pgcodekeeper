package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;

public abstract class AbstractMsFunction extends AbstractFunction
implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    private String firstPart;
    private String secondPart;

    public AbstractMsFunction(String name) {
        super(name);
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
        super.computeHash(hasher);
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction func) {
        if (func instanceof AbstractMsFunction && super.compareUnalterable(func)) {
            AbstractMsFunction newFunction = (AbstractMsFunction) func;
            return isAnsiNulls() == newFunction.isAnsiNulls()
                    && isQuotedIdentified() == newFunction.isQuotedIdentified()
                    && Objects.equals(getFirstPart(), newFunction.getFirstPart())
                    && Objects.equals(getSecondPart(), newFunction.getSecondPart());
        }

        return false;
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractMsFunction functionDst = (AbstractMsFunction) super.shallowCopy();
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        functionDst.setFirstPart(getFirstPart());
        functionDst.setSecondPart(getSecondPart());
        return functionDst;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
