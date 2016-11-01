package ru.taximaxim.codekeeper.ui.antlr;

import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.BlackContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.FlagContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.Hide_ruleContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.Show_ruleContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.WhiteContext;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObject;

public class SQLIgnoreParserMainListener extends SQLIgnoreBaseListener {

    private final IgnoreObjectContainer ioc;

    public SQLIgnoreParserMainListener(IgnoreObjectContainer ioc) {
        this.ioc = ioc;
    }

    @Override
    public void exitBlack(BlackContext ctx) {
        ioc.setBlack(true);
    }

    @Override
    public void exitWhite(WhiteContext ctx) {
        ioc.setBlack(false);
    }

    @Override
    public void exitFlag(FlagContext ctx) {
        super.exitFlag(ctx);
    }

    @Override
    public void exitHide_rule(Hide_ruleContext ctx) {
        boolean isRegular = false, ignoreContent = false;
        for (FlagContext flag : ctx.rule_rest().flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            }
            if (flag.REGEX() != null) {
                isRegular = true;
            }
        }
        IgnoredObject ignoredObject = new IgnoredObject(ctx.rule_rest().obj.getText(), isRegular, ignoreContent);
        ioc.addIgnoredObject(ignoredObject);
    }

    @Override
    public void exitShow_rule(Show_ruleContext ctx) {
        boolean isRegular = false, ignoreContent = false;
        for (FlagContext flag : ctx.rule_rest().flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            }
            if (flag.REGEX() != null) {
                isRegular = true;
            }
        }
        IgnoredObject ignoredObject = new IgnoredObject(ctx.rule_rest().obj.getText(), isRegular, ignoreContent);
        ioc.addIgnoredObject(ignoredObject);
    }
}
