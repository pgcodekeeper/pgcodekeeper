package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_ownerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
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

        PgStatement st = null;

        if (ctx.OPERATOR() != null) {
            Target_operatorContext targetOperCtx = ctx.target_operator();
            Operator_nameContext operNameCtx = targetOperCtx.name;
            IdentifierContext schemaCtx = operNameCtx.schema_name;
            List<ParserRuleContext> ids = Arrays.asList(schemaCtx, operNameCtx);
            st = getSafe(AbstractSchema::getOperator, getSchemaSafe(ids),
                    parseSignature(operNameCtx.operator.getText(), targetOperCtx),
                    operNameCtx.operator.getStart());
            setOwner(st, owner);
            addFullObjReference(ids, DbObjType.OPERATOR, StatementActions.ALTER);
            return;
        }

        List<IdentifierContext> ids = ctx.name.identifier();
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);

        DbObjType type = null;
        if (ctx.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
            addReferenceOnSchema(nameCtx);
            if (ApgdiffConsts.PUBLIC.equals(st.getName())
                    && "postgres".equals(owner.name.getText())) {
                return;
            }
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
            } else if (ctx.PROCEDURE() != null || ctx.FUNCTION() != null) {
                st = getSafe(AbstractSchema::getFunction, schema, parseSignature(nameCtx.getText(),
                        ctx.function_args()), nameCtx.getStart());
                type = ctx.PROCEDURE() != null ? DbObjType.PROCEDURE : DbObjType.FUNCTION;
            }
        }

        if (st != null) {
            setOwner(st, owner);
        }

        if (type != null)  {
            addFullObjReference(ids, type, StatementActions.ALTER);
        }
    }


    private void setOwner(PgStatement st, Owner_toContext owner) {
        if (overrides == null) {
            fillOwnerTo(owner, st);
        } else {
            overrides.computeIfAbsent(st,
                    k -> new StatementOverride()).setOwner(owner.name.getText());
        }
    }
}
