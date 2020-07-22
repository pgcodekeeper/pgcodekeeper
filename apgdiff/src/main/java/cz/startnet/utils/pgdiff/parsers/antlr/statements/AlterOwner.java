package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_ownerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterOwner extends ParserAbstract {

    private final Alter_ownerContext ctx;
    private final Map<PgStatement, StatementOverride> overrides;

    public AlterOwner(Alter_ownerContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public AlterOwner(Alter_ownerContext ctx, PgDatabase db,
            Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
    }

    @Override
    public void parseObject() {
        Owner_toContext owner = ctx.owner_to();

        if (db.getArguments().isIgnorePrivileges() || owner.name == null) {
            return;
        }

        List<ParserRuleContext> ids;
        if (ctx.OPERATOR() != null) {
            ids = getIdentifiers(ctx.target_operator().name);
        } else {
            ids = getIdentifiers(ctx.name);
        }

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);

        DbObjType type = null;
        PgStatement st = null;
        if (ctx.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
            type = DbObjType.SCHEMA;
        } else {
            AbstractSchema schema = getSchemaSafe(ids);
            if (ctx.DOMAIN() != null) {
                st = getSafe(AbstractSchema::getDomain, schema, nameCtx);
                type = DbObjType.DOMAIN;
            } else if (ctx.VIEW() != null) {
                st = getSafe(AbstractSchema::getView, schema, nameCtx);
                type = DbObjType.VIEW;
            } else if (ctx.DICTIONARY() != null) {
                st = getSafe(AbstractSchema::getFtsDictionary, schema, nameCtx);
                type = DbObjType.FTS_DICTIONARY;
            } else if (ctx.CONFIGURATION() != null) {
                st = getSafe(AbstractSchema::getFtsConfiguration, schema, nameCtx);
                type = DbObjType.FTS_CONFIGURATION;
            } else if (ctx.SEQUENCE() != null) {
                st = getSafe(AbstractSchema::getSequence, schema, nameCtx);
                type = DbObjType.SEQUENCE;
            } else if (ctx.TYPE() != null) {
                st = getSafe(AbstractSchema::getType, schema, nameCtx);
                type = DbObjType.TYPE;
            } else if (ctx.OPERATOR() != null) {
                st = getSafe(AbstractSchema::getOperator, schema,
                        parseSignature(nameCtx.getText(), ctx.target_operator()),
                        nameCtx.getStart());
                type = DbObjType.OPERATOR;
            } else if (ctx.PROCEDURE() != null || ctx.FUNCTION() != null || ctx.AGGREGATE() != null) {
                st = getSafe(AbstractSchema::getFunction, schema, parseSignature(nameCtx.getText(),
                        ctx.function_args()), nameCtx.getStart());
                if (ctx.FUNCTION() != null) {
                    type = DbObjType.FUNCTION;
                } else if (ctx.PROCEDURE() != null) {
                    type = DbObjType.PROCEDURE;
                } else {
                    type = DbObjType.AGGREGATE;
                }
            }
        }

        if (type != null)  {
            addObjReference(ids, type, ACTION_ALTER);
        }

        if (st == null || (type == DbObjType.SCHEMA
                && ApgdiffConsts.PUBLIC.equals(nameCtx.getText())
                && "postgres".equals(owner.name.getText()))) {
            return;
        }

        setOwner(st, owner);
    }

    private void setOwner(PgStatement st, Owner_toContext owner) {
        if (overrides == null) {
            fillOwnerTo(owner, st);
        } else {
            overrides.computeIfAbsent(st,
                    k -> new StatementOverride()).setOwner(owner.name.getText());
        }
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = null;
        if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (ctx.DICTIONARY() != null) {
            type = DbObjType.FTS_DICTIONARY;
        } else if (ctx.CONFIGURATION() != null) {
            type = DbObjType.FTS_CONFIGURATION;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else if (ctx.AGGREGATE() != null) {
            type = DbObjType.AGGREGATE;
        } else if (ctx.OPERATOR() != null) {
            type = DbObjType.OPERATOR;
        } else {
            return null;
        }

        Target_operatorContext targetOperCtx;
        List<ParserRuleContext> ids;
        if (ctx.name != null) {
            ids = getIdentifiers(ctx.name);
        } else if ((targetOperCtx = ctx.target_operator()) != null) {
            ids = getIdentifiers(targetOperCtx.name);
        } else {
            return null;
        }

        return getStrForStmtAction(ACTION_ALTER, type, ids);
    }
}
