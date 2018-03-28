package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public interface IStatement {
    String getName();
    DbObjType getStatementType();
    IStatement getParent();

    default DbObjNature getStatementNature() {
        return DbObjNature.USER;
    }
}