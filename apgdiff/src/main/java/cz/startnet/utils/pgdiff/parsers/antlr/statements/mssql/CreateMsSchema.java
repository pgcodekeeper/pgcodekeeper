package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.parsers.antlr.CustomTSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

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

        addSafe(PgDatabase::addSchema, db, schema, nameCtx);
        /* FIXME
        if (ctx.schema_def != null) {
            try {
                listener.setDefaultSchema(name);
                for (Schema_definitionContext sd : ctx.schema_definition()) {
                    St_clauseContext clause = sd.st_clause();
                    Batch_statement_no_schemaContext batchSt;
                    if (clause != null) {
                        listener.clause(clause);
                    } else if ((batchSt = sd.batch_statement_no_schema()) != null) {
                        listener.batchStatementNoSchema(batchSt, stream);
                    }
                }
            } finally {
                listener.setDefaultSchema(null);
            }
        }
         */
    }
}
