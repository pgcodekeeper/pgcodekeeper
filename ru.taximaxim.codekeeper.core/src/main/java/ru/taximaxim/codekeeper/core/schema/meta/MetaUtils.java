/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.IConstraint;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.utils.Pair;

public final class MetaUtils {

    public static MetaContainer createTreeFromDb(AbstractDatabase db) {
        MetaContainer tree = new MetaContainer();
        db.getDescendants()
        .map(MetaUtils::createMetaFromStatement)
        .forEach(tree::addStatement);

        if (db.getDbType() == DatabaseType.PG) {
            MetaStorage.getSystemObjects(db.getVersion()).forEach(tree::addStatement);
        }
        return tree;
    }

    public static MetaContainer createTreeFromDefs(Stream<MetaStatement> defs,
            DatabaseType dbType, SupportedVersion version) {
        MetaContainer tree = new MetaContainer();
        defs.forEach(tree::addStatement);

        if (dbType == DatabaseType.PG) {
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
            MetaFunction func = new MetaFunction(loc, st.getBareName());
            funcion.getReturnsColumns().forEach(func::addReturnsColumn);
            funcion.getArguments().forEach(func::addArgument);
            func.setReturns(funcion.getReturns());
            meta = func;
            break;
        case CONSTRAINT:
            MetaConstraint con = new MetaConstraint(loc);
            con.setPrimaryKey(((IConstraint) st).isPrimaryKey());
            ((IConstraint) st).getColumns().forEach(con::addColumn);
            meta = con;
            break;
        case SEQUENCE:
        case TABLE:
        case DICTIONARY:
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
        case USER_MAPPING:
        case SCHEMA:
        case EXTENSION:
        case EVENT_TRIGGER:
        case FOREIGN_DATA_WRAPPER:
        case SERVER:
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
        case OPERATOR:
        case PROCEDURE:
        case SEQUENCE:
        case TABLE:
        case DICTIONARY:
        case TYPE:
        case VIEW:
            gc = new GenericColumn(st.getParent().getName(), st.getName(), type);
            break;
        case INDEX:
            gc = new GenericColumn(st.getParent().getParent().getName(), st.getName(), type);
            break;
        case CONSTRAINT:
        case RULE:
        case TRIGGER:
            IStatement parent = st.getParent();
            gc = new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
            break;
        case POLICY:
            if (st.getDbType() == DatabaseType.CH) {
                gc = new GenericColumn(st.getName(), type);
            } else {
                parent = st.getParent();
                gc = new GenericColumn(parent.getParent().getName(), parent.getName(), st.getName(), type);
            }
            break;
        case FUNCTION:
            if (st.getDbType() == DatabaseType.CH) {
                gc = new GenericColumn(st.getName(), type);
            } else {
                gc = new GenericColumn(st.getParent().getName(), st.getName(), type);
            }
            break;
        default:
            throw new IllegalArgumentException("Unsupported type " + type);
        }

        return new PgObjLocation.Builder()
                .setObject(gc)
                .setLocationType(LocationType.DEFINITION)
                .build();
    }

    public static Map<String, List<MetaStatement>> getObjDefinitions(AbstractDatabase db) {
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
