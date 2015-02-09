package cz.startnet.utils.pgdiff.parsers.antlr;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.General_literalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;


public class GeneralLiteralSearch extends SQLParserBaseListener {
    
    private String seqName="";
    private General_literalContext ctx;
    private boolean found = false;

    @Override
    public void enterGeneral_literal(General_literalContext ctx) {
        seqName = ctx.getText();
        this.ctx = ctx;
    }

    @Override
    public void enterPredefined_type(Predefined_typeContext ctx) {
        if (ctx.REGCLASS() != null) {
            found = true;
        }
    }

    public String getSeqName() {
        return seqName.substring(1, seqName.length() - 1);
    }

    public General_literalContext getContext() {
        return ctx;
    }

    public boolean isFound() {
        return found;
    }
}