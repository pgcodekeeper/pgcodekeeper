package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_ownerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

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
    public PgStatement getObject() {
        Owner_toContext owner = ctx.owner_to();

        if (db.getArguments().isIgnorePrivileges() || owner.name == null) {
            return null;
        }

        PgStatement st = null;

        if (ctx.OPERATOR() != null) {
            Target_operatorContext targetOperCtx = ctx.target_operator();
            Operator_nameContext operNameCtx = targetOperCtx.name;
            st = getSafe(
                    CreateOperator.getSchemaSafe(operNameCtx, db.getDefaultSchema(), db)::getOperator,
                    parseSignature(operNameCtx.operator.getText(), targetOperCtx),
                    operNameCtx.operator.getStart());
            setOwner(st, owner);
            return null;
        }


        List<IdentifierContext> ids = ctx.name.identifier();
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);

        if (ctx.SCHEMA() != null) {
            st = getSafe(db::getSchema, nameCtx);
            if (ApgdiffConsts.PUBLIC.equals(st.getName())
                    && "postgres".equals(owner.name.getText())) {
                return null;
            }
        } else {
            AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
            if (ctx.DOMAIN() != null) {
                st = getSafe(schema::getDomain, nameCtx);
            } else if (ctx.VIEW() != null) {
                st = getSafe(schema::getView, nameCtx);
            } else if (ctx.DICTIONARY() != null) {
                st = getSafe(schema::getFtsDictionary, nameCtx);
            } else if (ctx.CONFIGURATION() != null) {
                st = getSafe(schema::getFtsConfiguration, nameCtx);
            } else if (ctx.SEQUENCE() != null) {
                st = getSafe(schema::getSequence, nameCtx);
            } else if (ctx.TYPE() != null) {
                st = getSafe(schema::getType, nameCtx);
            } else if (ctx.PROCEDURE() != null || ctx.FUNCTION() != null
                    || ctx.AGGREGATE() != null) {
                st = getSafe(schema::getFunction, parseSignature(nameCtx.getText(),
                        ctx.function_args()), nameCtx.getStart());
            }
        }

        if (st != null) {
            setOwner(st, owner);
        }
        return null;
    }


    private void setOwner(PgStatement st, Owner_toContext owner) {
        if (overrides == null) {
            fillOwnerTo(owner, st);
        } else {
            StatementOverride override = overrides.get(st);
            if (override == null) {
                override = new StatementOverride();
                overrides.put(st, override);
            }

            override.setOwner(owner.name.getText());
        }
    }
}
