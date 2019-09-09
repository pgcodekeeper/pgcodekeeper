package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_relational_or_xml_or_spatial_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DropMsStatement extends ParserAbstract {

    private final Schema_dropContext ctx;

    public DropMsStatement(Schema_dropContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.drop_assembly() != null) {
            for (IdContext id : ctx.drop_assembly().id()) {
                addObjReference(Arrays.asList(id), DbObjType.ASSEMBLY, StatementActions.DROP);
            }
        } else if (ctx.drop_index() != null) {
            for (Drop_relational_or_xml_or_spatial_indexContext ind :
                ctx.drop_index().drop_relational_or_xml_or_spatial_index()) {
                Qualified_nameContext tableIds = ind.qualified_name();
                IdContext schemaCtx = tableIds.schema;
                IdContext parentCtx = tableIds.name;
                IdContext nameCtx = ind.index_name;
                addObjReference(Arrays.asList(schemaCtx, parentCtx, nameCtx),
                        DbObjType.INDEX, StatementActions.DROP);
            }
        } else if (ctx.drop_statements() != null) {
            drop(ctx.drop_statements());
        }
    }

    private void drop(Drop_statementsContext ctx) {
        DbObjType type = null;
        if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.ROLE() != null) {
            type = DbObjType.ROLE;
        } else if (ctx.USER() != null) {
            type = DbObjType.USER;
        }

        if (type != null) {
            for (Qualified_nameContext qname : ctx.qualified_name()) {
                addObjReference(Arrays.asList(qname.name), type, StatementActions.DROP);
            }
            return;
        } else if (ctx.TRIGGER() != null) {
            for (Qualified_nameContext qname : ctx.qualified_name()) {
                // TODO ref to table, need ctx
                addObjReference(Arrays.asList(qname.schema, null, qname.name),
                        DbObjType.TRIGGER, StatementActions.DROP);
            }
            return;
        }

        if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null || ctx.PROC() != null) {
            type = DbObjType.PROCEDURE;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        }

        if (type != null) {
            for (Qualified_nameContext qname : ctx.qualified_name()) {
                List<IdContext> ids = Arrays.asList(qname.schema, qname.name);
                PgObjLocation ref = addObjReference(ids, type, StatementActions.DROP);
                if (type == DbObjType.TABLE) {
                    ref.setWarning(DangerStatement.DROP_TABLE);
                }
            }
        }
    }

    @Override
    protected QueryLocation fillQueryLocation(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        QueryLocation loc = super.fillQueryLocation(ctx, tokenStream);
        Drop_statementsContext dropSt = ((Schema_dropContext) ctx).drop_statements();
        if (dropSt != null && dropSt.TABLE() != null) {
            loc.setWarning(DangerStatement.DROP_TABLE);
        }
        return loc;
    }

    @Override
    protected void fillDescrObj() {
        action = StatementActions.DROP;
        if (ctx.drop_assembly() != null) {
            StringBuilder sb = new StringBuilder();
            for (IdContext id : ctx.drop_assembly().id()) {
                sb.append(id.getText()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            descrObj = new GenericColumn(sb.toString(), DbObjType.ASSEMBLY);
        } else if (ctx.drop_index() != null) {
            StringBuilder sb = new StringBuilder();
            for (Drop_relational_or_xml_or_spatial_indexContext ind :
                ctx.drop_index().drop_relational_or_xml_or_spatial_index()) {
                Qualified_nameContext tableIds = ind.qualified_name();
                sb.append(tableIds.schema.getText())
                .append('.').append(tableIds.name)
                .append('.').append(ind.index_name)
                .append(", ");
            }
            sb.setLength(sb.length() - 2);
            descrObj = new GenericColumn(sb.toString(), DbObjType.INDEX);
        } else if (ctx.drop_statements() != null) {
            dropOtherStmt(ctx.drop_statements());
        }
    }

    private void dropOtherStmt(Drop_statementsContext dropStmtCtx) {
        DbObjType type = null;
        if (dropStmtCtx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (dropStmtCtx.ROLE() != null) {
            type = DbObjType.ROLE;
        } else if (dropStmtCtx.USER() != null) {
            type = DbObjType.USER;
        }

        if (type != null) {
            StringBuilder sb = new StringBuilder();
            for (Qualified_nameContext qname : dropStmtCtx.qualified_name()) {
                sb.append(qname.name.getText()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            descrObj = new GenericColumn(sb.toString(), type);
            return;
        } else if (dropStmtCtx.TRIGGER() != null) {
            StringBuilder sb = new StringBuilder();
            for (Qualified_nameContext qname : dropStmtCtx.qualified_name()) {
                sb.append(qname.schema.getText()).append('.')
                .append(qname.name.getText()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            descrObj = new GenericColumn(sb.toString(), DbObjType.TRIGGER);
            return;
        }

        if (dropStmtCtx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (dropStmtCtx.PROCEDURE() != null || dropStmtCtx.PROC() != null) {
            type = DbObjType.PROCEDURE;
        } else if (dropStmtCtx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (dropStmtCtx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (dropStmtCtx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (dropStmtCtx.VIEW() != null) {
            type = DbObjType.VIEW;
        }

        if (type != null) {
            StringBuilder sb = new StringBuilder();
            for (Qualified_nameContext qname : dropStmtCtx.qualified_name()) {
                sb.append(qname.schema.getText()).append('.')
                .append(qname.name.getText()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            descrObj = new GenericColumn(sb.toString(), type);
        }
    }
}