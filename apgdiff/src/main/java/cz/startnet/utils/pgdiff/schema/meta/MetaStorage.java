package cz.startnet.utils.pgdiff.schema.meta;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
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
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 4042839050043504459L;

    private static final String OTHER_LOCATION = "other_location";

    private final ConcurrentMap<String, Set<MetaStatement>> definitions = new ConcurrentHashMap<>();
    private transient volatile MetaDatabase tree;

    public MetaStorage() {}

    public MetaStorage(PgDatabase db) {
        concat(db);
    }

    public void remove(String path) {
        tree = null;
        definitions.remove(path);
    }

    public void append(PgDatabase db, boolean clear) {
        append(createStorage(db, clear), clear);
    }

    public void append(MetaStorage storage, boolean clear) {
        tree = null;
        if (clear) {
            definitions.clear();
        }
        storage.definitions.forEach((k, v) -> definitions.merge(k, v, (v1, v2) -> {
            v1.addAll(v2);
            return v1;
        }));
    }

    public static MetaDatabase createFullDb(PgDatabase db) {
        return createStorage(db, true).getTree();
    }

    private static MetaStorage createStorage(PgDatabase db, boolean addSystem) {
        MetaStorage meta = new MetaStorage(db);
        if (addSystem && !db.getArguments().isMsSql()) {
            meta.concat(PgSystemStorage.getObjectsFromResources(db.getPostgresVersion()));
        }
        return meta;
    }

    public MetaDatabase getTree() {
        if (tree == null) {
            tree = new MetaDatabase();

            definitions.values().stream()
            .flatMap(Collection::stream)
            .sorted((o1, o2) -> o1.getStatementType().compareTo(o2.getStatementType()))
            .forEach(e -> addChildToTree(e.getCopy()));
        }

        return tree;
    }

    private void concat(PgSystemStorage db) {
        tree = null;
        db.getDescendants().forEach(this::addChild);
    }

    private void concat(PgDatabase db) {
        tree = null;
        db.getDescendants().forEach(this::addChild);
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
            IFunction funcion = (IFunction) st;
            MetaFunction func = new MetaFunction(gc);
            funcion.getReturnsColumns().forEach(func::addReturnsColumn);
            funcion.getArguments().forEach(func::addArgument);
            func.setReturns(funcion.getReturns());
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
            PgObjLocation loc = ((PgStatement) st).getLocation();
            if (loc != null) {
                path = loc.getFilePath();
            }
        }

        definitions.computeIfAbsent(path, k -> new LinkedHashSet<>()).add(meta);
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
