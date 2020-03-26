package cz.startnet.utils.pgdiff.schema.meta;

import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaDB {

    private final MetaStatement database;

    private MetaDB() {
        database = new MetaStatement("meta_db", DbObjType.DATABASE);
    }

    public static MetaDB create(PgDatabase db) {
        MetaDB meta = new MetaDB();
        db.getDescendants().forEach(meta::addChild);
        return meta;
    }

    public static MetaDB create(PgSystemStorage db) {
        MetaDB meta = new MetaDB();
        db.getDescendants().forEach(meta::addChild);
        return meta;
    }

    private void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        MetaStatement meta = new MetaStatement(st.getName(), type);
        if (st instanceof IRelation) {
            ((IRelation) st).getRelationColumns().forEach(meta::addColumn);
        } else if (st instanceof IFunction) {
            ((IFunction) st).getReturnsColumns().forEach((k, v) -> meta.addColumn(new Pair<>(k, v)));
            ((IFunction) st).getArguments().forEach(meta::addArgument);
        }

        if (st instanceof PgStatement) {
            meta.setLocation(((PgStatement) st).getLocation());
        }

        switch (type) {
        case SCHEMA:
        case EXTENSION:
        case ROLE:
        case USER:
        case ASSEMBLY:
            database.addChild(meta);
            break;
        case AGGREGATE:
        case DOMAIN:
        case FTS_CONFIGURATION:
        case FTS_DICTIONARY:
        case FTS_PARSER:
        case FTS_TEMPLATE:
        case FUNCTION:
        case OPERATOR:
        case PROCEDURE:
        case SEQUENCE:
        case TABLE:
        case TYPE:
        case VIEW:
            MetaStatement schema = database.getChild(st.getParent().getName(), DbObjType.SCHEMA);
            schema.addChild(meta);
            break;
        case CONSTRAINT:
        case COLUMN:
        case INDEX:
        case RULE:
        case TRIGGER:
            IStatement par = st.getParent();
            IStatement sch = par.getParent();
            MetaStatement metaParent = database.getChild(sch.getName(), DbObjType.SCHEMA).getChild(par.getName(), par.getStatementType());
            metaParent.addChild(meta);
            break;
        default:
            throw new IllegalArgumentException("Unsupported type " + type);
        }
    }

    public void concat(MetaDB db) {
        for (MetaStatement meta : db.database.getChildren()) {
            database.addChild(meta.getCopy());
        }
    }
}
