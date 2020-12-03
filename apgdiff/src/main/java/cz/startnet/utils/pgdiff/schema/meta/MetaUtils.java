package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaUtils {

    public static MetaContainer createTreeFromDb(PgDatabase db) {
        MetaContainer tree = new MetaContainer();
        db.getDescendants()
        .map(MetaUtils::createMetaFromStatement)
        .forEach(tree::addStatement);

        if (!db.getArguments().isMsSql()) {
            MetaStorage.getSystemObjects(db.getPostgresVersion()).forEach(tree::addStatement);
        }
        return tree;
    }

    public static MetaContainer createTreeFromDefs(Stream<MetaStatement> defs,
            boolean addSystem, SupportedVersion version) {
        MetaContainer tree = new MetaContainer();
        defs.forEach(tree::addStatement);

        if (addSystem) {
            MetaStorage.getSystemObjects(version).forEach(tree::addStatement);
        }
        return tree;
    }

    public static MetaStatement createMetaFromStatement(PgStatement st) {
        DbObjType type = st.getStatementType();
        PgObjLocation loc = getLocation(st, type);
        MetaStatement meta;

        switch (type) {
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
        case TABLE:
        case VIEW:
            MetaRelation rel = new MetaRelation(loc);
            Stream<Pair<String, String>> columns = ((IRelation) st).getRelationColumns();
            if (columns != null) {
                rel.addColumns(columns.collect(Collectors.toList()));
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
        case COLLATION:
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

    public static void initializeView(MetaContainer meta, String schemaName,
            String name, List<? extends Pair<String, String>> columns) {
        IRelation rel = meta.findRelation(schemaName, name);
        if (rel instanceof MetaRelation) {
            ((MetaRelation) rel).addColumns(columns);
        }
    }

    private MetaUtils() {}
}
