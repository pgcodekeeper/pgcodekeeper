package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class CustomErrorListener implements ANTLRErrorListener {
    
    public static final CustomErrorListener INSTATANCE = new CustomErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
//        if (!REPORT_SYNTAX_ERRORS) {
//            return;
//        }

        String sourceName = recognizer.getInputStream().getSourceName();
        if (sourceName !=null && !sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }

        System.err.println(sourceName+"line "+line+":"+charPositionInLine+" "+msg);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex,
            int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa,
            int startIndex, int stopIndex, BitSet conflictingAlts,
            ATNConfigSet configs) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa,
            int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // TODO Auto-generated method stub

    }

    private CustomErrorListener() {}
}
