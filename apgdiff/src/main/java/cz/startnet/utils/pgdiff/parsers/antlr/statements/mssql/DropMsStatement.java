package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
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
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Drop_statementsContext dropSt = ((Schema_dropContext) ctx).drop_statements();
        if (dropSt != null && dropSt.TABLE() != null) {
            loc.setWarning(DangerStatement.DROP_TABLE);
        }
        return loc;
    }

    @Override
    protected Pair<StatementActions, GenericColumn> fillDescrObj() {
        GenericColumn descrObj = null;
        if (ctx.drop_assembly() != null) {
            List<IdContext> ids = ctx.drop_assembly().id();
            descrObj = new GenericColumn(ids.size() != 1 ? "" : ids.get(0).getText(),
                    DbObjType.ASSEMBLY);
        } else if (ctx.drop_index() != null) {
            List<Drop_relational_or_xml_or_spatial_indexContext> indices = ctx
                    .drop_index().drop_relational_or_xml_or_spatial_index();
            String schemaName = "";
            String tblName = "";
            String objName = "";
            if (indices.size() == 1) {
                Drop_relational_or_xml_or_spatial_indexContext ind = indices.get(0);
                Qualified_nameContext tableIds = ind.qualified_name();
                schemaName = tableIds.schema.getText();
                tblName = tableIds.name.getText();
                objName = ind.index_name.getText();
            }
            descrObj = new GenericColumn(schemaName, tblName, objName, DbObjType.INDEX);
        } else if (ctx.drop_statements() != null) {
            descrObj = dropOtherStmt(ctx.drop_statements());
        }

        return descrObj != null ? new Pair<>(StatementActions.DROP, descrObj) : null;
    }

    private GenericColumn dropOtherStmt(Drop_statementsContext dropStmtCtx) {
        DbObjType type = null;

        if (dropStmtCtx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (dropStmtCtx.ROLE() != null) {
            type = DbObjType.ROLE;
        } else if (dropStmtCtx.USER() != null) {
            type = DbObjType.USER;
        }

        if (type != null) {
            List<Qualified_nameContext> qnames = dropStmtCtx.qualified_name();
            return new GenericColumn(qnames.size() != 1 ? "" : qnames.get(0).name.getText(), type);
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
        } else if (dropStmtCtx.TRIGGER() != null) {
            type = DbObjType.TRIGGER;
        }

        if (type != null) {
            List<Qualified_nameContext> qnames = dropStmtCtx.qualified_name();
            String schemaName = "";
            String objName = "";
            if (qnames.size() == 1) {
                schemaName = qnames.get(0).schema.getText();
                objName = qnames.get(0).name.getText();
            }
            return new GenericColumn(schemaName, objName, type);
        }

        return null;
    }
}