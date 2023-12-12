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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.IStatementContainer;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;

public class MsTypesReader extends JdbcReader {

    public MsTypesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema)
            throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.TYPE));

        MsType type = new MsType(name);
        String baseType = res.getString("base_type");
        String assembly = res.getString("assembly_class");
        if (assembly != null) {
            type.setAssemblyName(assembly);
            type.setAssemblyClass(res.getString("assembly_class"));
            type.addDep(new GenericColumn(assembly, DbObjType.ASSEMBLY));
        } else if (baseType != null) {
            type.setBaseType(JdbcLoaderBase.getMsType(type, null, baseType, false, res.getInt("size"),
                    res.getInt("precision"), res.getInt("scale")));
            type.setNotNull(!res.getBoolean("is_nullable"));
        } else {
            addColumns(res, schema, type);
            addIndices(type, XmlReader.readXML(res.getString("indices")));
            addChecks(type, XmlReader.readXML(res.getString("checks")));
            type.setMemoryOptimized(res.getBoolean("is_memory_optimized"));
        }

        schema.addType(type);
        loader.setOwner(type, res.getString("owner"));
        loader.setPrivileges(type, XmlReader.readXML(res.getString("acl")));
    }

    private void addColumns(ResultSet res, AbstractSchema schema, MsType type)
            throws XmlReaderException, SQLException {
        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            // pass the 'type' to the method for extract type depcy from column
            // object since it is temporary
            AbstractColumn column = MsTablesReader.getColumn(col, schema, loader, type);
            type.addChild(column);
            // extract type depcy from column object since it is temporary
            // (column also has depcy that is not related to the analysis)
            type.addAllDeps(column.getDeps());
        }
    }

    private void addIndices(IStatementContainer type, List<XmlReader> indices) throws XmlReaderException {
        for (XmlReader index : indices) {
            boolean isPrimaryKey = index.getBoolean("pk");
            boolean isUniqueConstraint = index.getBoolean("uc");
            boolean isClustered = index.getBoolean("cl");
            int bucketCount = index.getInt("bc");
            String filter = index.getString("def");
            var cols = XmlReader.readXML(index.getString("cols"));

            if (isPrimaryKey || isUniqueConstraint) {
                var constrPk = new MsConstraintPk(null, isPrimaryKey);
                constrPk.setClustered(isClustered);
                fillColumns(constrPk, cols);
                if (index.getBoolean("dk")) {
                    constrPk.addOption("IGNORE_DUP_KEY", "ON");
                } else if (bucketCount > 0) {
                    constrPk.addOption("BUCKET_COUNT", Integer.toString(bucketCount));
                }
                type.addChild(constrPk);
            } else {
                var idx = new MsIndex(index.getString("name"));
                idx.setClustered(isClustered);
                fillColumns(idx, cols);
                if (filter != null) {
                    // broken in dump
                    idx.setWhere(filter);
                }
                if (bucketCount > 0) {
                    idx.addOption("BUCKET_COUNT", Integer.toString(bucketCount));
                }
                type.addChild(idx);
            }
        }
    }

    private void fillColumns(ISimpleColumnContainer stmt, List<XmlReader> cols) {
        for (XmlReader col : cols) {
            String colName = col.getString("name");
            var simpCol = new SimpleColumn(colName);
            simpCol.setDesc(col.getBoolean("is_desc"));
            stmt.addColumn(simpCol);
        }
    }

    private void addChecks(IStatementContainer type, List<XmlReader> checks) {
        for (XmlReader check : checks) {
            var constrCh = new MsConstraintCheck(null);
            constrCh.setExpression(check.getString("def"));
            type.addChild(constrCh);
        }
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("a.name AS assembly")
        .column("ay.assembly_class")
        .column("res.is_nullable")
        .column("basetypes.name AS base_type")
        .column("CASE WHEN basetypes.name IN (N'nchar', N'nvarchar') AND res.max_length >= 0 THEN res.max_length/2 ELSE res.max_length END AS size")
        .column("res.precision")
        .column("res.scale")
        .column("ttt.is_memory_optimized")
        .from("sys.types res WITH (NOLOCK)")
        .join("LEFT JOIN sys.types basetypes WITH (NOLOCK) ON res.system_type_id=basetypes.system_type_id AND basetypes.system_type_id=basetypes.user_type_id")
        .join("LEFT JOIN sys.assembly_types ay WITH (NOLOCK) ON ay.user_type_id=res.user_type_id")
        .join("LEFT JOIN sys.assemblies a WITH (NOLOCK) ON a.assembly_id=ay.assembly_id")
        .join("LEFT JOIN sys.table_types ttt WITH (NOLOCK) ON ttt.user_type_id=res.user_type_id")
        .where("res.is_user_defined=1");

        // after join ttt
        addMsConstraintsPart(builder);
        addMsColumnsPart(builder);
        addMsIndicesPart(builder);
    }

    @Override
    protected void addMsPriviligesPart(QueryBuilder builder) {
        String acl = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT  \n"
                + "      perm.state_desc AS sd,\n"
                + "      perm.permission_name AS pn,\n"
                + "      roleprinc.name AS r\n"
                + "    FROM sys.database_principals roleprinc WITH (NOLOCK)\n"
                + "    JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id\n"
                + "    WHERE major_id = res.user_type_id AND perm.class = 6\n"
                + "  ) aa \n"
                + "  FOR XML RAW, ROOT\n"
                + ") aa (acl)";

        builder.column("aa.acl");
        builder.join(acl);
    }

    private void addMsConstraintsPart(QueryBuilder builder) {
        String checks = "CROSS APPLY ( \n"
                + "  SELECT c.definition AS def\n"
                + "  FROM sys.check_constraints c WITH (NOLOCK)\n"
                + "  WHERE c.parent_object_id=ttt.type_table_object_id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") ch (checks)";

        builder.column("ch.checks");
        builder.join(checks);
    }

    private void addMsColumnsPart(QueryBuilder builder) {
        String cols = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT\n"
                + "      c.name,\n"
                + "      c.column_id AS id,\n"
                + "      ss.name AS st,\n"
                + "      usrt.name AS type,\n"
                + "      usrt.is_user_defined AS ud,\n"
                + "      CASE WHEN c.max_length >= 0 AND baset.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,\n"
                + "      c.precision AS pr,\n"
                + "      c.scale AS sc,\n"
                + "      c.collation_name AS cn,\n"
                + "      object_definition(c.default_object_id) AS dv,\n"
                + "      c.is_nullable AS nl,\n"
                + "      c.is_identity AS ii,\n"
                + "      ic.seed_value AS s,\n"
                + "      ic.increment_value AS i,\n"
                + "      ic.is_not_for_replication AS nfr,\n"
                + "      c.is_rowguidcol AS rgc,\n"
                + "      cc.is_persisted AS ps,\n"
                + "      cc.definition AS def\n"
                + "    FROM sys.all_columns c WITH (NOLOCK)\n"
                + "    LEFT OUTER JOIN sys.computed_columns cc WITH (NOLOCK) ON cc.object_id = c.object_id AND cc.column_id = c.column_id\n"
                + "    LEFT OUTER JOIN sys.identity_columns ic WITH (NOLOCK) ON ic.object_id = c.object_id AND ic.column_id = c.column_id\n"
                + "    LEFT OUTER JOIN sys.types usrt WITH (NOLOCK) ON usrt.user_type_id = c.user_type_id\n"
                + "    LEFT OUTER JOIN sys.schemas ss WITH (NOLOCK) ON ss.schema_id = usrt.schema_id\n"
                + "    LEFT OUTER JOIN sys.types baset WITH (NOLOCK) ON (baset.user_type_id = c.system_type_id AND baset.user_type_id = baset.system_type_id)\n"
                + "      OR (baset.system_type_id = c.system_type_id AND baset.user_type_id = c.user_type_id AND baset.is_user_defined = 0 AND baset.is_assembly_type = 1)\n"
                + "    WHERE ttt.type_table_object_id=c.object_id\n"
                + "  ) cc ORDER BY cc.id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") cc (cols)";

        builder.column("cc.cols");
        builder.join(cols);
    }

    private void addMsIndicesPart(QueryBuilder builder) {
        String indices = "CROSS APPLY ( \n"
                + "  SELECT * FROM (\n"
                + "    SELECT\n"
                + "      si.name,\n"
                + "      si.is_primary_key AS pk,\n"
                + "      si.is_unique_constraint AS uc,\n"
                + "      si.ignore_dup_key AS dk,\n"
                + "      INDEXPROPERTY(si.object_id, si.name, 'IsClustered') AS cl,\n"
                + "      hi.bucket_count AS bc,\n"
                + "      ccc.cols,\n"
                + "      si.filter_definition AS def\n"
                + "    FROM sys.indexes AS si WITH (NOLOCK)\n"
                + "    LEFT JOIN sys.objects o WITH (NOLOCK) ON si.object_id = o.object_id\n"
                + "    LEFT JOIN sys.hash_indexes hi WITH (NOLOCK) ON hi.object_id = si.object_id AND hi.index_id = si.index_id\n"
                + "    CROSS APPLY ( \n"
                + "      SELECT * FROM (\n"
                + "        SELECT\n"
                + "          c.index_column_id AS id,\n"
                + "          sc.name,\n"
                + "          c.is_descending_key AS is_desc\n"
                + "        FROM sys.index_columns c WITH (NOLOCK)\n"
                + "        JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id\n"
                + "        WHERE c.object_id = si.object_id AND c.index_id = si.index_id\n"
                + "      ) cc ORDER BY cc.id\n"
                + "      FOR XML RAW, ROOT\n"
                + "    ) ccc (cols)\n"
                + "    WHERE si.object_id=ttt.type_table_object_id AND si.index_id > 0 AND si.is_hypothetical = 0\n"
                + "  ) ii  \n"
                + "  FOR XML RAW, ROOT\n"
                + ") ii (indices)";

        builder.column("ii.indices");
        builder.join(indices);
    }

    @Override
    protected String getSchemaColumn() {
        return "res.schema_id";
    }
}
