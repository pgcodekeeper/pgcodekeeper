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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.FuncTypes;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.AbstractMsClrFunction;
import ru.taximaxim.codekeeper.core.schema.ms.MsClrFunction;
import ru.taximaxim.codekeeper.core.schema.ms.MsClrProcedure;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;

public class MsExtendedObjectsReader extends JdbcReader {

    public MsExtendedObjectsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        String funcType = res.getString("type");
        DbObjType type = "PC".equals(funcType) ? DbObjType.PROCEDURE : DbObjType.FUNCTION;
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, type));

        String assembly = res.getString("assembly");
        String assemblyClass = res.getString("assembly_class");
        String assemblyMethod = res.getString("assembly_method");

        AbstractMsClrFunction func;

        if (type == DbObjType.PROCEDURE) {
            func = new MsClrProcedure(name, assembly, assemblyClass, assemblyMethod);
        } else {
            MsClrFunction localFunc = new MsClrFunction(name, assembly, assemblyClass, assemblyMethod);

            if ("FT".equals(funcType)) {
                setReturns(localFunc, XmlReader.readXML(res.getString("cols")));
            } else {
                localFunc.setReturns(JdbcLoaderBase.getMsType(localFunc, res.getString("return_type_sh"),
                        res.getString("return_type"), res.getBoolean("return_type_ud"),
                        res.getInt("return_type_size"), res.getInt("return_type_pr"),
                        res.getInt("return_type_sc")));
            }

            if (res.getBoolean("null_on_null_input")) {
                localFunc.addOption("RETURNS NULL ON NULL INPUT");
            }

            func = localFunc;
        }

        func.addDep(new GenericColumn(assembly, DbObjType.ASSEMBLY));

        String executeAs = res.getString("execute_as");
        func.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));

        addArguments(func, XmlReader.readXML(res.getString("args")));

        String owner = res.getString("owner");
        loader.setOwner(func, owner);

        schema.addFunction(func);
        loader.setPrivileges(func, XmlReader.readXML(res.getString("acl")));
    }

    private void setReturns(MsClrFunction localFunc, List<XmlReader> cols) {
        List<String> columns = new ArrayList<>();
        for (XmlReader col : cols) {
            MsColumn column = new MsColumn(col.getString("name"));
            boolean isUserDefined = col.getBoolean("ud");
            if (!isUserDefined) {
                column.setCollation(col.getString("cn"));
            }
            column.setType(JdbcLoaderBase.getMsType(localFunc, col.getString("st"), col.getString("type"),
                    isUserDefined, col.getInt("size"), col.getInt("pr"), col.getInt("sc")));
            columns.add(column.getFullDefinition());
        }

        localFunc.setReturns("TABLE (\n" + String.join(",\n", columns) + ")");
        localFunc.setFuncType(FuncTypes.TABLE);
    }

    private void addArguments(AbstractMsClrFunction func, List<XmlReader> args) {
        for (XmlReader arg : args) {
            boolean isUserDefined = arg.getBoolean("ud");
            Argument argDst = new Argument(arg.getBoolean("ou") ? ArgMode.OUTPUT : ArgMode.IN,
                    arg.getString("name"), JdbcLoaderBase.getMsType(func, arg.getString("st"),
                            arg.getString("type"), isUserDefined, arg.getInt("size"),
                            arg.getInt("pr"), arg.getInt("sc")));

            if (arg.getBoolean("hd")) {
                String def = arg.getString("dv");
                String defValue;
                String baseType = arg.getString("bt");
                if (def == null) {
                    defValue = "NULL";
                } else if ("varbinary".equals(baseType) || "nvarchar".equals(baseType)
                        || "varchar".equals(baseType) ) {
                    defValue = 'N' + PgDiffUtils.quoteString(def);
                } else if ("bit".equals(baseType)) {
                    defValue = "1".equals(def) ? "True" : "False";
                } else if ("real".equals(baseType) || "float".equals(baseType)) {
                    defValue = Double.toString(Double.parseDouble(def));
                    if ("0.0".equals(defValue)) {
                        defValue = "0";
                    }
                } else {
                    defValue = def;
                }

                argDst.setDefaultExpression(defValue);
            }

            argDst.setReadOnly(arg.getBoolean("ro"));
            func.addArgument(argDst);
        }
    }

    @Override
    protected String getSchemaColumn() {
        return "res.schema_id";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsColumnsPart(builder);
        addMsArgsPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("res.type")
        .column("SCHEMA_NAME(usrt.schema_id) AS return_type_sh")
        .column("usrt.name AS return_type")
        .column("CASE WHEN ret_param.max_length>=0 AND usrt.name IN (N'nchar', N'nvarchar') THEN ret_param.max_length/2 ELSE ret_param.max_length END AS return_type_size")
        .column("usrt.precision AS return_type_pr")
        .column("usrt.scale AS return_type_sc")
        .column("usrt.is_user_defined AS return_type_ud")
        .column("am.null_on_null_input")
        .column("p2.name AS execute_as")
        .column("a.name AS assembly")
        .column("am.assembly_class")
        .column("am.assembly_method")
        .from("sys.objects res WITH (NOLOCK)")
        .join("JOIN sys.assembly_modules am WITH (NOLOCK) ON am.object_id=res.object_id")
        .join("JOIN sys.assemblies a WITH (NOLOCK) ON a.assembly_id=am.assembly_id")
        .join("LEFT JOIN sys.database_principals p2 WITH (NOLOCK) ON p2.principal_id=am.execute_as_principal_id")
        .join("LEFT JOIN sys.all_parameters ret_param WITH (NOLOCK) ON ret_param.object_id = res.object_id and ret_param.parameter_id = 0")
        .join("LEFT JOIN sys.types usrt WITH (NOLOCK) ON usrt.user_type_id = ret_param.user_type_id")
        .where("res.type IN ('PC', 'FT', 'FS')");
    }

    private void addMsColumnsPart(QueryBuilder builder) {
        String cols = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT\n"
                + "      c.name,\n"
                + "      c.column_id AS id,\n"
                + "      t.name AS type,\n"
                + "      SCHEMA_NAME(t.schema_id) AS st,\n"
                + "      CASE WHEN c.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,\n"
                + "      c.precision AS pr,\n"
                + "      c.scale AS sc,\n"
                + "      c.collation_name AS cn,\n"
                + "      t.is_user_defined AS ud\n"
                + "    FROM sys.columns as c WITH (NOLOCK)\n"
                + "    JOIN sys.types t WITH (NOLOCK) ON c.user_type_id = t.user_type_id\n"
                + "    WHERE c.object_id = res.object_id\n"
                + "  ) ccc ORDER BY ccc.id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") ccc (cols)";

        builder.column("ccc.cols");
        builder.join(cols);
    }

    private void addMsArgsPart(QueryBuilder builder) {
        String args = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT \n"
                + "      p.name,\n"
                + "      t.name AS type,\n"
                + "      SCHEMA_NAME(t.schema_id) AS st,\n"
                + "      TYPE_NAME(t.system_type_id) AS bt,\n"
                + "      CASE WHEN p.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN p.max_length/2 ELSE p.max_length END AS size,\n"
                + "      p.parameter_id AS id,\n"
                + "      p.precision AS pr,\n"
                + "      p.scale AS sc,\n"
                + "      t.is_user_defined AS ud,\n"
                + "      p.is_output AS ou,\n"
                + "      p.has_default_value AS hd,\n"
                + "      p.default_value AS dv,\n"
                + "      p.is_readonly AS ro\n"
                + "      FROM sys.objects so WITH (NOLOCK)\n"
                + "      JOIN sys.parameters p WITH (NOLOCK) ON so.object_id = p.object_id\n"
                + "      JOIN sys.types t WITH (NOLOCK) ON p.user_type_id = t.user_type_id\n"
                + "      WHERE p.parameter_id > 0 AND so.object_id = res.object_id \n"
                + "  ) cc ORDER BY cc.id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") cc (args)";

        builder.column("cc.args");
        builder.join(args);
    }
}
