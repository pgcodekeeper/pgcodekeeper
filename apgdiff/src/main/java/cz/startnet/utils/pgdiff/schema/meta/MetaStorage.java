package cz.startnet.utils.pgdiff.schema.meta;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.IConstraint;
import cz.startnet.utils.pgdiff.schema.IDatabase;
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

    private static final long serialVersionUID = 7284212113839712191L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedVersion, MetaStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<MetaStatement> definitions = new ArrayList<>();

    public static IDatabase createTreeFromDb(PgDatabase db) {
        MetaStorage meta = new MetaStorage();
        db.getDescendants().map(MetaStorage::createMetaFromStatement).forEach(meta::addMetaChild);
        return meta.getTree(db.getArguments().isMsSql(), db.getPostgresVersion());
    }

    public static IDatabase createTreeFromDefs(Stream<MetaStatement> defs,
            boolean isMsSql, SupportedVersion version) {
        MetaStorage meta = new MetaStorage();
        defs.forEach(meta.definitions::add);
        return meta.getTree(isMsSql, version);
    }

    private IDatabase getTree(boolean isMsSql, SupportedVersion version) {
        if (!isMsSql) {
            MetaStorage systemStorage = getObjectsFromResources(version);
            if (systemStorage != null) {
                definitions.addAll(systemStorage.definitions);
            }
        }

        MetaDatabase tree = new MetaDatabase();
        definitions.stream()
        .sorted((o1, o2) -> o1.getStatementType().compareTo(o2.getStatementType()))
        .forEach(e -> addChildToTree(tree, e.getCopy()));

        return tree;
    }

    public void addMetaChild(MetaStatement meta) {
        definitions.add(meta);
    }

    public static MetaStatement createMetaFromStatement(PgStatement st) {
        DbObjType type = st.getStatementType();
        PgObjLocation loc = getLocation(st, type);
        MetaStatement meta;

        switch (type) {
        case SCHEMA:
            meta = new MetaSchema(loc);
            break;
        case CAST:
            ICast cast = (ICast) st;
            meta = new MetaCast(cast.getSource(), cast.getTarget(), cast.getContext(), loc);
            break;
        case OPERATOR:
            IOperator operator = (IOperator) st;
            MetaOperator oper = new MetaOperator(loc);
            oper.setLeftArg(operator.getLeftArg());
            oper.setRightArg(operator.getRightArg());
            oper.setReturns(operator.getReturns());
            meta = oper;
            break;
        case AGGREGATE:
        case FUNCTION:
        case PROCEDURE:
            IFunction funcion = (IFunction) st;
            MetaFunction func = new MetaFunction(loc);
            funcion.getReturnsColumns().forEach(func::addReturnsColumn);
            funcion.getArguments().forEach(func::addArgument);
            func.setReturns(funcion.getReturns());
            meta = func;
            break;
        case CONSTRAINT:
            MetaConstraint con = new MetaConstraint(loc);
            con.setPrimaryKey(((IConstraint) st).isPrimaryKey());
            con.setUnique(((IConstraint) st).isUnique());
            ((IConstraint) st).getColumns().forEach(con::addColumn);
            meta = con;
            break;
        case SEQUENCE:
            MetaRelation rel = new MetaRelation(loc);
            ((IRelation) st).getRelationColumns().forEach(p -> rel.addColumn(p.getFirst(), p.getSecond()));
            meta = rel;
            break;
        case TABLE:
        case VIEW:
            rel = new MetaStatementContainer(loc);
            Stream<Pair<String, String>> columns = ((IRelation) st).getRelationColumns();
            if (columns != null) {
                columns.forEach(p -> rel.addColumn(p.getFirst(), p.getSecond()));
                rel.setInitialized(true);
            }
            meta = rel;
            break;
        default:
            meta = new MetaStatement(loc);
            break;
        }

        return meta;
    }

    private void addChildToTree(MetaDatabase tree, MetaStatement st) {
        GenericColumn gc = st.getGenericColumn();
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
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
            tree.getSchema(gc.schema).getStatementContainer(gc.table).addChild(st);
            break;
        case INDEX:
            MetaSchema schema = tree.getSchema(gc.schema);
            schema.getStatementContainers().map(c -> c.getChild(gc.table, DbObjType.INDEX))
            .filter(Objects::nonNull).findAny().ifPresent(e -> e.addChild(st));
            break;
        default :
            throw new IllegalArgumentException("Unsupported type " + type);
        }
    }

    private static PgObjLocation getLocation(PgStatement st, DbObjType type) {
        PgObjLocation loc = st.getLocation();
        // some children may have a parental location
        if (loc != null && loc.getType() == type) {
            return loc;
        }
        GenericColumn gc;
        switch (type) {
        case CAST:
        case SCHEMA:
        case EXTENSION:
        case ROLE:
        case USER:
        case ASSEMBLY:
            gc = new GenericColumn(st.getName(), type);
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
            gc = new GenericColumn(st.getParent().getName(), st.getBareName(), type);
            break;
        case INDEX:
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
            IStatement parent = st.getParent();
            gc = new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
            break;
        default:
            throw new IllegalArgumentException("Unsupported type " + type);
        }

        return new PgObjLocation(gc);
    }

    private static MetaStorage getObjectsFromResources(SupportedVersion ver) {
        SupportedVersion version;
        if (!SupportedVersion.VERSION_9_5.isLE(ver.getVersion())) {
            version = SupportedVersion.VERSION_9_5;
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
