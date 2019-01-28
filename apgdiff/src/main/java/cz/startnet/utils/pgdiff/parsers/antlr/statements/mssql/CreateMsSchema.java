package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.parsers.antlr.CustomTSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
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
        if (ctx.schema_def != null) {
            try {
                listener.setDefaultSchema(name);
                for (Schema_definitionContext sd : ctx.schema_definition()) {
                    St_clauseContext clause = sd.st_clause();
                    Create_or_alter_viewContext viewSt;
                    if (clause != null) {
                        listener.clause(clause);
                    } else if ((viewSt = sd.create_or_alter_view()) != null) {
                        listener.schemaViewStatement(viewSt, stream);
                    }
                }
            } finally {
                listener.setDefaultSchema(null);
            }
        }
    }
}
