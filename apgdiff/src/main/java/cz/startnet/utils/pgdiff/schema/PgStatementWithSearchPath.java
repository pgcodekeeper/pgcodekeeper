package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

/**
 * The superclass for general pgsql statement with search_path. That is any but
 * SCHEMA and EXTENSION.
 *
 * @author Alexander Levsha
 */
public abstract class PgStatementWithSearchPath extends PgStatement implements ISearchPath {

    public PgStatementWithSearchPath(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public String getSearchPath() {
        return MessageFormat.format(ApgdiffConsts.SEARCH_PATH_PATTERN,
                PgDiffUtils.getQuotedName(getContainingSchema().getName()));
    }

    @Override
    public abstract PgSchema getContainingSchema();

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getContainingSchema().getParent();
    }
}
