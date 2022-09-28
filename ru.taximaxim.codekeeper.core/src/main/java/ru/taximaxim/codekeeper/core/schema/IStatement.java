package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public interface IStatement {
    String getName();
    DbObjType getStatementType();
    IStatement getParent();
    String getQualifiedName();
    String getComment();

    String getBareName();
}