package cz.startnet.utils.pgdiff.schema.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.IConstraint;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementLocation;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 4042839050043504459L;

    private static final String OTHER_LOCATION = "other_location";

    private final ConcurrentMap<String, List<MetaStatement>> definitions = new ConcurrentHashMap<>();
    private transient MetaDatabase tree;


    public void concat(PgSystemStorage db) {
        tree = null;
        db.getDescendants().forEach(this::addChild);
    }

    public void concat(PgDatabase db) {
        tree = null;
        db.getDescendants().forEach(this::addChild);
    }

    public void replace(PgDatabase db, String path) {
        tree = null;
        definitions.remove(path);
        concat(db);
    }

    public static MetaStorage create(PgDatabase db) {
        MetaStorage meta = new MetaStorage();
        db.getDescendants().forEach(meta::addChild);
        return meta;
    }

    public static MetaDatabase createFullDb(PgDatabase db) {
        MetaStorage meta = create(db);
        if (!db.getArguments().isMsSql()) {
            meta.concat(PgSystemStorage.getObjectsFromResources(db.getPostgresVersion()));
        }
        return meta.getTree();
    }

    public MetaDatabase getTree() {
        if (tree == null) {
            tree = new MetaDatabase();

            definitions.values().stream()
            .flatMap(Collection::stream)
            .sorted((o1, o2) -> o1.getStatementType().compareTo(o2.getStatementType()))
            .forEach(this::addChildToTree);
        }

        return tree;
    }

    private void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        GenericColumn gc = createGenericColumn(st, type);
        MetaStatement meta;

        switch (type) {
        case SCHEMA:
            meta = new MetaSchema(gc);
            break;
        case CAST:
            ICast cast = (ICast) st;
            meta = new MetaCast(cast.getSource(), cast.getTarget(), cast.getContext());
            break;
        case AGGREGATE:
        case FUNCTION:
        case PROCEDURE:
            MetaFunction func = new MetaFunction(gc);
            ((IFunction) st).getReturnsColumns().forEach(func::addReturnsColumn);
            ((IFunction) st).getArguments().forEach(func::addArgument);
            meta = func;
            break;
        case CONSTRAINT:
            MetaConstraint con = new MetaConstraint(gc);
            con.setPrimaryKey(((IConstraint) st).isPrimaryKey());
            con.setUnique(((IConstraint) st).isUnique());
            ((IConstraint) st).getColumns().forEach(con::addColumn);
            meta = con;
            break;
        case SEQUENCE:
            MetaRelation rel = new MetaRelation(gc);
            ((IRelation) st).getRelationColumns().forEach(p -> rel.addColumn(p.getFirst(), p.getSecond()));
            meta = rel;
            break;
        case TABLE:
        case VIEW:
            rel = new MetaStatementContainer(gc);
            Stream<Pair<String, String>> columns = ((IRelation) st).getRelationColumns();
            if (columns != null) {
                columns.forEach(p -> rel.addColumn(p.getFirst(), p.getSecond()));
                rel.setInitialized(true);
            }
            meta = rel;
            break;
        default:
            meta = new MetaStatement(gc);
            break;
        }

        String path = OTHER_LOCATION;
        if (st instanceof PgStatement) {
            StatementLocation loc = ((PgStatement) st).getLocation();
            if (loc != null) {
                path = loc.getFilePath();
            }
        }

        definitions.computeIfAbsent(path, k -> new ArrayList<>()).add(meta);
    }

    private void addChildToTree(MetaStatement st) {
        GenericColumn gc = st.getObject();
        DbObjType type = gc.type;
        switch (type) {
        case CAST:
        case SCHEMA:
        case EXTENSION:
        case ROLE:
        case USER:
        case ASSEMBLY:
            tree.addChild(st);
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
            tree.getSchema(gc.schema).addChild(st);
            break;
        case INDEX:
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
            tree.getSchema(gc.schema).getStatementContainer(gc.table).addChild(st);
            break;
        default :
            throw new IllegalArgumentException("Unsupported type " + type);
        }
    }

    private GenericColumn createGenericColumn(IStatement st, DbObjType type) {
        switch (type) {
        case CAST:
        case SCHEMA:
        case EXTENSION:
        case ROLE:
        case USER:
        case ASSEMBLY:
            return new GenericColumn(st.getName(), type);
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
            return new GenericColumn(st.getParent().getName(), st.getBareName(), type);
        case INDEX:
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
            IStatement parent = st.getParent();
            return new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
        default:
            throw new IllegalArgumentException("Unsupported type " + type);
        }
    }
}
