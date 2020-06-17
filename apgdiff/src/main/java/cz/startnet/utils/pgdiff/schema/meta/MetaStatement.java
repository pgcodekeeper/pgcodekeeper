package cz.startnet.utils.pgdiff.schema.meta;

import java.io.Serializable;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaStatement implements IStatement, Serializable {

    private static final long serialVersionUID = -3372437548966681543L;

    private final PgObjLocation object;
    private String comment = "";

    private transient MetaStatement parent;

    public MetaStatement(PgObjLocation object) {
        this.object = object;
    }

    public MetaStatement(GenericColumn column) {
        this(new PgObjLocation(column));
    }

    @Override
    public String getName() {
        return object.getObjName();
    }

    @Override
    public DbObjType getStatementType() {
        return object.getType();
    }

    public GenericColumn getGenericColumn() {
        return object.getObj();
    }

    public PgObjLocation getObject() {
        return object;
    }

    public void setParent(MetaStatement parent) {
        this.parent = parent;
    }

    @Override
    public MetaStatement getParent() {
        return parent;
    }

    public void addChild(MetaStatement st) {
        // subclasses may override if needed
    }

    public MetaStatement getChild(String name, DbObjType type) {
        // subclasses may override if needed
        return null;
    }

    @Override
    public String getQualifiedName() {
        return getGenericColumn().getQualifiedName();
    }

    public MetaStatement getCopy() {
        return new MetaStatement(object);
    }

    @Override
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getObjLength() {
        return object.getObjLength();
    }

    public int getOffset() {
        return object.getOffset();
    }

    public String getFilePath() {
        return object.getFilePath();
    }

    public int getLineNumber() {
        return object.getLineNumber();
    }
}
