package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_foreign_table_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_partitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_serverContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractForeignTable;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PartitionForeignPgTable;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.SimpleForeignPgTable;

public class CreateForeignTable extends TableAbstract {

    private final Create_foreign_table_statementContext ctx;

    public CreateForeignTable(Create_foreign_table_statementContext ctx, PgDatabase db, CommonTokenStream stream) {
        super(db, stream);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String tableName = QNameParser.getFirstName(ids);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = defineTable(tableName, getSchemaNameSafe(ids));
        addSafe(schema, table, ids);

        for (AbstractColumn col : table.getColumns()) {
            AbstractSequence seq = ((PgColumn) col).getSequence();
            if (seq != null) {
                seq.setParent(schema);
            }
        }
    }

    private AbstractTable defineTable(String tableName, String schemaName) {
        Define_serverContext srvCtx = ctx.define_server();
        IdentifierContext srvName = srvCtx.identifier();
        Define_columnsContext colCtx = ctx.define_columns();
        Define_partitionContext partCtx = ctx.define_partition();

        AbstractPgTable table;

        if (colCtx != null) {
            table = fillForeignTable(srvCtx, new SimpleForeignPgTable(
                    tableName, srvName.getText()));
            fillColumns(colCtx, table, schemaName, null);
        } else {
            String partBound = ParserAbstract.getFullCtxText(partCtx.for_values_bound());
            table = fillForeignTable(srvCtx, new PartitionForeignPgTable(
                    tableName, srvName.getText(), partBound));

            fillTypeColumns(partCtx.list_of_type_column_def(), table, schemaName, null);
            addInherit(table, getIdentifiers(partCtx.parent_table));
        }
        addDepSafe(table, Arrays.asList(srvName), DbObjType.SERVER, true);

        return table;
    }

    private AbstractForeignTable fillForeignTable(Define_serverContext server, AbstractForeignTable table) {
        Define_foreign_optionsContext options = server.define_foreign_options();
        if (options != null){
            for (Foreign_optionContext option : options.foreign_option()) {
                Character_stringContext opt = option.character_string();
                String value = opt == null ? null : opt.getText();
                fillOptionParams(value, option.col_label().getText(), false, table::addOption);
            }
        }
        return table;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, getIdentifiers(ctx.name));
    }
}
