package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_backward_compatible_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_relational_or_xml_or_spatial_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
                addObjReference(Arrays.asList(id), DbObjType.ASSEMBLY, ACTION_DROP);
            }
        } else if (ctx.drop_index() != null) {
            for (Drop_relational_or_xml_or_spatial_indexContext ind :
                ctx.drop_index().drop_relational_or_xml_or_spatial_index()) {
                Qualified_nameContext tableIds = ind.qualified_name();
                IdContext schemaCtx = tableIds.schema;
                IdContext nameCtx = ind.index_name;
                addObjReference(Arrays.asList(schemaCtx, nameCtx),
                        DbObjType.INDEX, ACTION_DROP);
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
                addObjReference(Arrays.asList(qname.name), type, ACTION_DROP);
            }
            return;
        } else if (ctx.TRIGGER() != null) {
            for (Qualified_nameContext qname : ctx.qualified_name()) {
                // TODO ref to table, need ctx
                addObjReference(Arrays.asList(qname.schema, null, qname.name),
                        DbObjType.TRIGGER, ACTION_DROP);
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
                List<ParserRuleContext> ids = Arrays.asList(qname.schema, qname.name);
                PgObjLocation ref = addObjReference(ids, type, ACTION_DROP);
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
    protected String getStmtAction() {
        DbObjType type = null;
        List<IdContext> ids = null;
        if (ctx.drop_assembly() != null) {
            ids = ctx.drop_assembly().id();
            type = DbObjType.ASSEMBLY;
        } else if (ctx.drop_index() != null) {
            Drop_indexContext dropIdxCtx = ctx.drop_index();
            List<Drop_relational_or_xml_or_spatial_indexContext> indicesRel = dropIdxCtx
                    .drop_relational_or_xml_or_spatial_index();
            if (indicesRel != null && !indicesRel.isEmpty() && indicesRel.size() == 1) {
                ids = Arrays.asList(indicesRel.get(0).index_name);
            } else {
                List<Drop_backward_compatible_indexContext> indicesBack = dropIdxCtx
                        .drop_backward_compatible_index();
                if (indicesBack != null && !indicesBack.isEmpty() && indicesBack.size() == 1) {
                    ids = Arrays.asList(indicesBack.get(0).index_name);
                } else {
                    ids = Collections.emptyList();
                }
            }
            type = DbObjType.INDEX;
        } else if (ctx.drop_statements() != null) {
            Pair<DbObjType, List<IdContext>> typeAndQName = dropStmt(ctx.drop_statements());
            if (typeAndQName != null) {
                type = typeAndQName.getFirst();
                ids = typeAndQName.getSecond();
            }
        }
        return type != null && ids != null ? getStrForStmtAction(ACTION_DROP, type, ids) : null;
    }

    private Pair<DbObjType, List<IdContext>> dropStmt(Drop_statementsContext dropStmtCtx) {
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
            return new Pair<>(type, qnames.size() == 1 ? qnames.get(0).id() : null);
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
            return new Pair<>(type, qnames.size() == 1 ? qnames.get(0).id() : null);
        }

        return null;
    }
}