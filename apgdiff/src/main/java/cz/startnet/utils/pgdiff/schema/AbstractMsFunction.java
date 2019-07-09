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
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof AbstractMsFunction && super.compare(obj)) {
            AbstractMsFunction func = (AbstractMsFunction) obj;
            return Objects.equals(getFirstPart(), func.getFirstPart())
                    && Objects.equals(getSecondPart(), func.getSecondPart())
                    && isQuotedIdentified() == func.isQuotedIdentified()
                    && isAnsiNulls() == func.isAnsiNulls();
        }

        return false;
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractMsFunction functionDst = getFunctionCopy();
        copyBaseFields(functionDst);
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        functionDst.setFirstPart(getFirstPart());
        functionDst.setSecondPart(getSecondPart());
        return functionDst;
    }

    protected abstract AbstractMsFunction getFunctionCopy();

    @Override
    public boolean isPostgres() {
        return false;
    }
}
