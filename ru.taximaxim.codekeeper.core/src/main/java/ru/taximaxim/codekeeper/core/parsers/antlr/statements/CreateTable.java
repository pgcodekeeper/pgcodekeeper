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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Col_labelContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_table_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_partitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Partition_byContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_oidContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_storage_parameterContext;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractRegularTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PartitionGpTable;
import ru.taximaxim.codekeeper.core.schema.PartitionPgTable;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.SimplePgTable;
import ru.taximaxim.codekeeper.core.schema.TypedPgTable;

public class CreateTable extends TableAbstract {
    private final Create_table_statementContext ctx;
    private final String tablespace;
    private final String accessMethod;
    private final String oids;
    private final CommonTokenStream stream;


    public CreateTable(Create_table_statementContext ctx, PgDatabase db,
            String tablespace, String accessMethod, String oids, CommonTokenStream stream) {
        super(db, stream);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.accessMethod = accessMethod;
        this.oids = oids;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String tableName = QNameParser.getFirstName(ids);
        String schemaName = getSchemaNameSafe(ids);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = defineTable(tableName, schemaName);
        addSafe(schema, table, ids);

        for (AbstractColumn col : table.getColumns()) {
            AbstractSequence seq = ((PgColumn) col).getSequence();
            if (seq != null) {
                seq.setParent(schema);
            }
        }
    }

    private AbstractTable defineTable(String tableName, String schemaName) {
        Define_tableContext tabCtx = ctx.define_table();
        Define_columnsContext colCtx = tabCtx.define_columns();
        Define_typeContext typeCtx = tabCtx.define_type();
        Define_partitionContext partCtx = tabCtx.define_partition();

        AbstractPgTable table;

        if (typeCtx != null) {
            table = defineType(typeCtx, tableName, schemaName);
        } else if (colCtx != null) {
            AbstractRegularTable abstractRegTable;
            if (ctx.partition_gp() != null) {
                abstractRegTable = new PartitionGpTable(tableName);
            } else {
                abstractRegTable = new SimplePgTable(tableName);
            }
            table = fillRegularTable(abstractRegTable);
            fillColumns(colCtx, table, schemaName, tablespace);
        } else {
            String partBound = ParserAbstract.getFullCtxText(partCtx.for_values_bound());
            table = fillRegularTable(new PartitionPgTable(tableName, partBound));
            fillTypeColumns(partCtx.list_of_type_column_def(), table, schemaName, tablespace);
            addInherit(table, getIdentifiers(partCtx.parent_table));
        }

        return table;
    }

    private TypedPgTable defineType(Define_typeContext typeCtx, String tableName,
            String schemaName) {
        Data_typeContext typeName = typeCtx.type_name;
        String ofType = getTypeName(typeName);
        TypedPgTable table = new TypedPgTable(tableName, ofType);
        fillTypeColumns(typeCtx.list_of_type_column_def(), table, schemaName, tablespace);
        addPgTypeDepcy(typeName, table);
        fillRegularTable(table);
        return table;
    }

    private AbstractRegularTable fillRegularTable(AbstractRegularTable table) {
        if (ctx.table_space() != null) {
            table.setTablespace(ctx.table_space().identifier().getText());
        } else if (tablespace != null) {
            table.setTablespace(tablespace);
        }

        table.setDistribution(parseDistribution(ctx.distributed_clause()));

        if (table instanceof PartitionGpTable) {
            var partitionGP = ctx.partition_gp();
            ((PartitionGpTable) table).setPartitionGpBound(getFullCtxText(partitionGP),
                    AntlrUtils.normalizeWhitespaceUnquoted(partitionGP, stream));
        }

        boolean explicitOids = false;
        Storage_parameter_oidContext storage = ctx.storage_parameter_oid();
        if (storage != null) {
            With_storage_parameterContext parameters = storage.with_storage_parameter();
            if (parameters != null) {
                parseOptions(parameters.storage_parameters().storage_parameter_option(), table);
            }
            if (storage.WITHOUT() != null) {
                table.setHasOids(false);
                explicitOids = true;
            } else if (storage.WITH() != null) {
                table.setHasOids(true);
                explicitOids = true;
            }
        }

        if (!explicitOids && oids != null) {
            table.setHasOids(true);
        }

        if (ctx.UNLOGGED() != null) {
            table.setLogged(false);
        }

        Partition_byContext part = ctx.partition_by();
        if (part != null) {
            table.setPartitionBy(ParserAbstract.getFullCtxText(part.partition_method()));

            // table access method for partitioned tables is not supported
        } else if (ctx.USING() != null) {
            table.setMethod(ctx.identifier().getText());
        } else if (accessMethod != null) {
            table.setMethod(accessMethod);
        }

        return table;
    }

    private void parseOptions(List<Storage_parameter_optionContext> options, AbstractRegularTable table){
        for (Storage_parameter_optionContext option : options){
            Storage_parameter_nameContext key = option.storage_parameter_name();
            List<Col_labelContext> optionIds = key.col_label();
            VexContext valueCtx = option.vex();
            String value = valueCtx == null ? "" : valueCtx.getText();
            String optionText = key.getText();
            if ("OIDS".equalsIgnoreCase(optionText)) {
                if ("TRUE".equalsIgnoreCase(value) || "'TRUE'".equalsIgnoreCase(value)) {
                    table.setHasOids(true);
                }
            } else if("toast".equals(QNameParser.getSecondName(optionIds))) {
                fillOptionParams(value, QNameParser.getFirstName(optionIds), true, table::addOption);
            } else {
                fillOptionParams(value, optionText, false, table::addOption);
            }
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, getIdentifiers(ctx.name));
    }
}
