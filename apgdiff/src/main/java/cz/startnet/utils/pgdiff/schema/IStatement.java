package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public interface IStatement {
    String getName();
    DbObjType getStatementType();
    IStatement getParent();
    String getQualifiedName();
    String getComment();

    default String getBareName() {
        return getName();
    }
}