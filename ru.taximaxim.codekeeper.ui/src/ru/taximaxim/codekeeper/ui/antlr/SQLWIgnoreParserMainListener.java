package ru.taximaxim.codekeeper.ui.antlr;

import ru.taximaxim.codekeeper.ui.antlr.SQLWIgnoreParser.BlackContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLWIgnoreParser.FlagContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLWIgnoreParser.Hide_ruleContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLWIgnoreParser.Show_ruleContext;
import ru.taximaxim.codekeeper.ui.antlr.SQLWIgnoreParser.WhiteContext;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObject;

public class SQLWIgnoreParserMainListener extends SQLWIgnoreBaseListener {

    private IgnoreObjectContainer ioc;

    public SQLWIgnoreParserMainListener(IgnoreObjectContainer ioc) {
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

        //QNameParser.getf 
        //ctx.identifier().getText();

        boolean isRegular = false, ignoreContent = false;
        for (FlagContext flag : ctx.flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            }
            if (flag.REGEX() != null) {
                isRegular = true;
            }
        }
        IgnoredObject ignoredObject = new IgnoredObject(ctx.identifier().getText(), isRegular, ignoreContent);
        ioc.addIgnoredObject(ignoredObject);
    }

    @Override
    public void exitShow_rule(Show_ruleContext ctx) {
        boolean isRegular = false, ignoreContent = false;
        for (FlagContext flag : ctx.flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            }
            if (flag.REGEX() != null) {
                isRegular = true;
            }
        }
        IgnoredObject ignoredObject = new IgnoredObject(ctx.identifier().getText(), isRegular, ignoreContent);
        ioc.addIgnoredObject(ignoredObject);
    }

}
