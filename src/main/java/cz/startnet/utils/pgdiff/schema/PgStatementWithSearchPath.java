package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

/**
 * The superclass for general pgsql statement with search_path.
 * That is any but SCHEMA and EXTENSION.
 * 
 * @author Alexander Levsha
 */
public abstract class PgStatementWithSearchPath extends PgStatement {
    
	public PgStatementWithSearchPath(String name, String rawStatement) {
		super(name, rawStatement);
	}
    
    public String getSearchPath() {
        return MessageFormat.format(ApgdiffConsts.SEARCH_PATH_PATTERN, getContainerSchema().getName());
    }
    
    abstract public PgSchema getContainerSchema();
}
