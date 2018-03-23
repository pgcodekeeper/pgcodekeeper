package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;

import cz.startnet.utils.pgdiff.schema.IStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class PgSystemStatement implements IStatement, Serializable {

    private static final long serialVersionUID = -3372437548966681543L;

    protected final String name;
    protected final DbObjType type;
    protected PgSystemStatement parent;

    public PgSystemStatement(String name, DbObjType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DbObjType getStatementType() {
        return type;
    }

    public void setParent(PgSystemStatement parent) {
        this.parent = parent;
    }

    @Override
    public PgSystemStatement getParent() {
        return parent;
    }
}