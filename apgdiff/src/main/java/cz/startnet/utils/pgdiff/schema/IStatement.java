package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public interface IStatement {
    DbObjType getStatementType();
}