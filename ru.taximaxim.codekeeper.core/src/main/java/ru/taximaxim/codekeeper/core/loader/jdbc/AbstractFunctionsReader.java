/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class AbstractFunctionsReader extends JdbcReader {

    protected AbstractFunctionsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        AbstractPgFunction function = readFunction(res, schema);
        loader.setOwner(function, res.getLong("proowner"));
        loader.setComment(function, res);
        loader.setPrivileges(function, res.getString("aclarray"), schema.getName());
        loader.setAuthor(function, res);

        schema.addFunction(function);
    }

    protected abstract AbstractPgFunction readFunction(ResultSet res, AbstractSchema schema) throws SQLException;


    /**
     * Returns a list of pairs, each of which contains the name of the argument
     * and its full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
     */
    protected List<Pair<String, GenericColumn>> fillArguments(AbstractPgFunction f, ResultSet res) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String[] argModes = getColArray(res, "proargmodes");
        String[] argNames = getColArray(res, "proargnames");
        Long[] argTypeOids = getColArray(res, "proallargtypes");
        Long[] argTypes = argTypeOids != null ? argTypeOids : getColArray(res, "argtypes");

        // It will be used for sending the arguments of function to the namespaces
        // in launcher for correct analysis.
        List<Pair<String, GenericColumn>> argsQualifiedTypes = new ArrayList<>();

        for (int i = 0; argTypes.length > i; i++) {
            String aMode = argModes != null ? argModes[i] : "i";

            JdbcType returnType = loader.cachedTypesByOid.get(argTypes[i]);
            returnType.addTypeDepcy(f);

            if ("t".equals(aMode)) {
                String name = argNames[i];
                String type = returnType.getFullName();
                sb.append(PgDiffUtils.getQuotedName(name)).append(" ")
                .append(type).append(", ");
                f.addReturnsColumn(argNames[i], type);
                continue;
            }

            JdbcType argJdbcType = loader.cachedTypesByOid.get(argTypes[i]);
            String argName = argNames != null ? argNames[i] : null;

            // these require resetHash functionality for defaults
            Argument a = f.new PgArgument(ArgMode.of(aMode), argName, argJdbcType.getFullName());

            if (!"o".equals(aMode)) {
                argsQualifiedTypes.add(new Pair<>(argName, argJdbcType.getQualifiedName()));
            }

            f.addArgument(a);
        }

        if (DbObjType.FUNCTION == f.getStatementType() || DbObjType.AGGREGATE == f.getStatementType()) {
            // RETURN TYPE
            if (sb.length() != 0) {
                sb.setLength(sb.length() - 2);
                f.setReturns("TABLE(" + sb + ")");
            } else {
                JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
                String retType = returnType.getFullName();
                f.setReturns(res.getBoolean("proretset") ? "SETOF " + retType : retType);
                returnType.addTypeDepcy(f);
            }
        }

        return argsQualifiedTypes;
    }

    @Override
    protected String getClassId() {
        return "pg_proc";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.pronamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addSysSchemasCte(builder);
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.proname")
        .column("res.proowner::bigint")
        .column("res.prorettype::bigint")
        .column("res.proallargtypes::bigint[]")
        .column("res.proargmodes")
        .column("res.proargnames")
        .column("res.proacl::text AS aclarray")
        .column("res.proretset")
        .column("array(select pg_catalog.unnest(res.proargtypes))::bigint[] as argtypes")
        .from("pg_catalog.pg_proc res")
        .where("NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass AND dp.objid = res.oid AND dp.deptype = 'i')");

        if (SupportedVersion.VERSION_9_6.isLE(loader.version)) {
            builder.column("res.proparallel");
        }
    }
}
