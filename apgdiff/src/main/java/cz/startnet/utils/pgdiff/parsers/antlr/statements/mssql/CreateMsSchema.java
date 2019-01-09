package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.parsers.antlr.CustomTSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsSchema extends ParserAbstract {

    private final Create_schemaContext ctx;
    private final CustomTSQLParserListener listener;
    private final CommonTokenStream stream;

    public CreateMsSchema(Create_schemaContext ctx, PgDatabase db,
            CustomTSQLParserListener listener, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.listener = listener;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.schema_name;
        String name = nameCtx.getText();
        AbstractSchema schema = new MsSchema(name);
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            schema.setOwner(ctx.owner_name.getText());
        }

        addSafe(PgDatabase::addSchema, db, schema);
        fillObjDefinition(new PgObjLocation(nameCtx.getText(), DbObjType.SCHEMA),
                nameCtx, schema);

        if (ctx.schema_def != null) {
            try {
                listener.setDefaultSchema(name);
                for (Schema_definitionContext sd : ctx.schema_definition()) {
                    Sql_clausesContext clauses = sd.sql_clauses();
                    Batch_statementContext batchSt;
                    if (clauses != null) {
                        for (St_clauseContext st : clauses.st_clause()) {
                            listener.clause(st);
                        }
                    } else if ((batchSt = sd.batch_statement()) != null) {
                        listener.batchStatement(batchSt, stream);
                    }
                }
            } finally {
                listener.setDefaultSchema(null);
            }
        }
    }
}
