package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collation_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_collationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgCollation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateCollation extends ParserAbstract{
    private final Create_collationContext ctx;

    public CreateCollation(Create_collationContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Schema_qualified_nameContext nameCtx = ctx.name;
        PgCollation collation = new PgCollation( nameCtx.getText());

        for (Collation_optionContext body : ctx.collation_option()) {
            String res = null;
            Character_stringContext val = null;
            if (body.LOCALE() != null) {
                val = body.character_string();
                if(val == null) {
                    res = body.identifier().getText();
                } else {
                    res = val.getText();
                }
                collation.setLocale(res);
            } else if (body.LC_COLLATE() != null){
                val = body.character_string();
                res = null;
                if(val == null) {
                    res = body.identifier().getText();
                } else {
                    res = val.getText();
                }
                collation.setLcCollate(res);
            } else if (body.LC_CTYPE() != null){
                val = body.character_string();
                res = null;
                if(val == null) {
                    res = body.identifier().getText();
                } else {
                    res = val.getText();
                }
                collation.setLcCtype(res);
            } else if (body.PROVIDER() != null){
                val = body.character_string();
                res = null;
                if(val == null) {
                    res = body.identifier().getText();
                } else {
                    res = val.getText();
                }
                collation.setProvider(res);
            } else if (body.VERSION() != null){
                val = body.character_string();
                res = null;
                if(val == null) {
                    res = body.identifier().getText();
                } else {
                    res = val.getText();
                }
                collation.setVersion(res);
            }
            else if (body.DETERMINISTIC() != null){
                val = body.character_string();
                boolean deterministic = true;
                res = null;
                if(val == null) {
                    res = body.identifier().getText().toLowerCase();
                } else {
                    res = val.getText().toLowerCase();
                }
                if (res != null)
                {
                    switch (res){
                    case ("1"):
                        deterministic = true;
                    break;
                    case ("true"):
                        deterministic = true;
                    break;
                    case ("on"):
                        deterministic = true;
                    break;
                    default:
                        deterministic = false;
                        break;
                    }
                }
                collation.setDeterministic(deterministic);
            }
        }

        addSafe(db, collation, Arrays.asList(nameCtx));
    }
    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, ctx.name);
    }
}
