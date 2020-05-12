package cz.startnet.utils.pgdiff.schema.meta;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.IConstraint;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IOperator;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 4042839050043504459L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final String OTHER_LOCATION = "other_location";

    private static final ConcurrentMap<SupportedVersion, MetaStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final ConcurrentMap<String, Set<MetaStatement>> definitions = new ConcurrentHashMap<>();
    private transient volatile MetaDatabase tree;

    public MetaStorage() {}

    public MetaStorage(PgDatabase db) {
        db.getDescendants().forEach(this::addChild);
    }

    public void remove(String path) {
        tree = null;
        definitions.remove(path);
    }

    public void append(PgDatabase db, boolean clear) {
        append(createStorageFromDb(db, clear), clear);
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

    public static MetaDatabase createMetaFromDb(PgDatabase db) {
        return createStorageFromDb(db, true).getTree();
    }

    private static MetaStorage createStorageFromDb(PgDatabase db, boolean addSystem) {
        MetaStorage meta = new MetaStorage(db);
        if (addSystem && !db.getArguments().isMsSql()) {
            meta.append(getObjectsFromResources(db.getPostgresVersion()), false);
        }
        return meta;
    }

    public MetaDatabase getTree() {
        MetaDatabase temp = tree;
        if (temp == null) {
            synchronized (this) {
                temp = tree;
                if (temp == null) {
                    temp = new MetaDatabase();
                    tree = temp;

                    definitions.values().stream()
                    .flatMap(Collection::stream)
                    .sorted((o1, o2) -> o1.getStatementType().compareTo(o2.getStatementType()))
                    .forEach(e -> addChildToTree(e.getCopy()));
                }
            }
        }

        return tree;
    }

    public void addMetaChild(MetaStatement meta) {
        addMetaChild(meta, OTHER_LOCATION);
    }

    public void addMetaChild(MetaStatement meta, String location) {
        definitions.computeIfAbsent(location, k -> new LinkedHashSet<>()).add(meta);
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
        case OPERATOR:
            IOperator operator = (IOperator) st;
            MetaOperator oper = new MetaOperator(gc);
            oper.setLeftArg(operator.getLeftArg());
            oper.setRightArg(operator.getRightArg());
            oper.setReturns(operator.getReturns());
            meta = oper;
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

    private static MetaStorage getObjectsFromResources(SupportedVersion ver) {
        SupportedVersion version;
        if (!SupportedVersion.VERSION_12.isLE(ver.getVersion())) {
            version = SupportedVersion.VERSION_12;
        } else {
            version = ver;
        }

        MetaStorage systemStorage = STORAGE_CACHE.get(version);
        if (systemStorage != null) {
            return systemStorage;
        }

        try {
            String path = ApgdiffUtils.getFileFromOsgiRes(MetaStorage.class.getResource(
                    FILE_NAME + version + ".ser")).toString();
            Object object = ApgdiffUtils.deserialize(path);

            if (object instanceof MetaStorage) {
                systemStorage = (MetaStorage) object;
                MetaStorage other = STORAGE_CACHE.putIfAbsent(version, systemStorage);
                return other == null ? systemStorage : other;
            }
        } catch (URISyntaxException | IOException e) {
            Log.log(Log.LOG_ERROR, "Error while reading systems objects from resources");
        }

        return null;
    }
}
