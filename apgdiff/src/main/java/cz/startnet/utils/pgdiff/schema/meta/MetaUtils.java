package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.IConstraint;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IOperator;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaUtils {

    public static IDatabase createTreeFromDb(PgDatabase db) {
        MetaDatabase tree = new MetaDatabase();
        db.getDescendants()
        .map(MetaUtils::createMetaFromStatement)
        .forEach(e -> addChild(tree, e));

        if (!db.getArguments().isMsSql()) {
            appendSystemObjects(tree, db.getPostgresVersion());
        }
        return tree;
    }

    public static IDatabase createTreeFromDefs(Stream<MetaStatement> defs,
            boolean addSystem, SupportedVersion version) {
        MetaDatabase tree = new MetaDatabase();
        defs
        .sorted((o1, o2) -> o1.getStatementType().compareTo(o2.getStatementType()))
        .forEach(e -> addChild(tree, e.getCopy()));

        if (addSystem) {
            appendSystemObjects(tree, version);
        }
        return tree;
    }

    private static void appendSystemObjects(MetaDatabase tree, SupportedVersion version) {
        MetaDatabase systemStorage = MetaStorage.getObjectsFromResources(version);
        if (systemStorage != null) {
            systemStorage.getSchemas().forEach(tree::addChild);
            systemStorage.getCasts().forEach(tree::addChild);
        }
    }

    public static void addChild(MetaDatabase tree, MetaStatement st) {
        GenericColumn gc = st.getGenericColumn();
        DbObjType type = gc.type;
        switch (type) {
        case CAST:
        case SCHEMA:
            tree.addChild(st);
            break;
        case AGGREGATE:
        case FUNCTION:
        case OPERATOR:
        case PROCEDURE:
        case SEQUENCE:
        case TABLE:
        case TYPE:
        case VIEW:
            MetaSchema schema = tree.getSchema(gc.schema);
            if (schema != null) {
                schema.addChild(st);
            }
            break;
        case CONSTRAINT:
            schema = tree.getSchema(gc.schema);
            if (schema != null) {
                MetaStatementContainer container = schema.getStatementContainer(gc.table);
                if (container != null) {
                    container.addChild(st);
                }
            }
            break;
        default :
            break;
        }
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

        String commnent = st.getComment();
        if (commnent != null) {
            meta.setComment(commnent);
        }

        return meta;
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
            gc = new GenericColumn(st.getParent().getParent().getName(), st.getName(), type);
            break;
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
        case POLICY:
            IStatement parent = st.getParent();
            gc = new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
            break;
        default:
            throw new IllegalArgumentException("Unsupported type " + type);
        }

        return new PgObjLocation(gc);
    }

    public static Map<String, List<MetaStatement>> getObjDefinitions(PgDatabase db) {
        Map<String, List<MetaStatement>> definitions = new HashMap<>();

        db.getDescendants().forEach(st -> {
            PgObjLocation loc = st.getLocation();
            if (loc != null) {
                String filePath = loc.getFilePath();
                if (filePath != null) {
                    definitions.computeIfAbsent(filePath, k -> new ArrayList<>())
                    .add(MetaUtils.createMetaFromStatement(st));
                }
            }
        });

        return definitions;
    }

    public static void initializeView(IDatabase db, String schemaName,
            String name, List<? extends Pair<String, String>> columns) {
        ISchema schema = db.getSchema(schemaName);
        if (schema != null) {
            IRelation rel = schema.getRelation(name);
            if (rel instanceof MetaRelation) {
                MetaRelation meta = (MetaRelation) rel;
                columns.forEach(col -> meta.addColumn(col.getFirst(), col.getSecond()));
                meta.setInitialized(true);
            }
        }
    }

    private MetaUtils() {}
}
