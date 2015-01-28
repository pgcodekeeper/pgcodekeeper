package cz.startnet.utils.pgdiff.parsers.antlr;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.General_literalContext;


public class GeneralLiteralSearch extends SQLParserBaseListener {
    private String seqName;
    private General_literalContext ctx;
    @Override
   public void enterGeneral_literal(General_literalContext ctx) {
        seqName = ctx.getText();
        this.ctx = ctx;
   }
    public String getSeqName() {
        return seqName.substring(1, seqName.length() - 1);
    }
    public General_literalContext getContext() {
        return ctx;
    }
}