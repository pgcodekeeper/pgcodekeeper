package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collation_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_collation_statementContext;
import cz.startnet.utils.pgdiff.schema.PgCollation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateCollation extends ParserAbstract {
    private final Create_collation_statementContext ctx;

    public CreateCollation(Create_collation_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgCollation collation = new PgCollation(QNameParser.getFirstName(ids));

        for (Collation_optionContext body : ctx.collation_option()) {
            if (body.LOCALE() != null) {
                collation.setLocale(getValue(body));
            } else if (body.LC_COLLATE() != null) {
                collation.setLcCollate(getValue(body));
            } else if (body.LC_CTYPE() != null) {
                collation.setLcCtype(getValue(body));
            } else if (body.PROVIDER() != null) {
                collation.setProvider(getValue(body));
            } else if (body.VERSION() != null) {
                collation.setVersion(getValue(body));
            } else if (body.DETERMINISTIC() != null) {
                String res = body.boolean_value().getText().toLowerCase(Locale.ROOT);
                switch (res) {
                case ("1"):
                case ("true"):
                case ("on"):
                    break;
                default:
                    collation.setDeterministic(false);
                    break;
                }

            }
        }
        addSafe(getSchemaSafe(ids), collation, ids);
    }

    private String getValue(Collation_optionContext body) {
        Character_stringContext val = body.character_string();
        if (val == null) {
            return body.identifier().getText();
        }
        return val.getText();

    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, ctx.name);
    }
}
