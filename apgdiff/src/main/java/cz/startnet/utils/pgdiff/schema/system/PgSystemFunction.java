package cz.startnet.utils.pgdiff.schema.system;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement {

    private static final long serialVersionUID = -7905948011960006249L;

    private final List<Argument> signature = new ArrayList<>();

    /**
     * Order by for aggregate functions
     */
    private final List<Argument> orderBy = new ArrayList<>();

    /**
     * Function return type name, if equals table
     * {@link PgSystemStatement#columns columns} contains columns
     */
    private String returnType;
    private boolean setof;

    public PgSystemFunction(final String schema, final String name) {
        super(schema, name, DbObjType.FUNCTION);
    }

    public List<Argument> getSignature() {
        return signature;
    }

    public void addSignaturePart(final Argument arg) {
        signature.add(arg);
    }

    public boolean isSetof() {
        return setof;
    }

    public void setSetof(final boolean setof) {
        this.setof = setof;
    }

    public List<Argument> getOrderBy() {
        return orderBy;
    }

    public void addOrderByPart(final Argument type) {
        orderBy.add(type);
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
