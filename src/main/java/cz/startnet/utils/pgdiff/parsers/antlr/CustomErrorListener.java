package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomErrorListener implements ANTLRErrorListener {
    
    public static final CustomErrorListener INSTATANCE = new CustomErrorListener();
    public List<String> errors = new ArrayList<>();
    private Path path;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        Log.log(Log.LOG_ERROR, "AntLR Error:\n" +
                path +" line "+line+":"+charPositionInLine+" "+msg);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex,
            int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa,
            int startIndex, int stopIndex, BitSet conflictingAlts,
            ATNConfigSet configs) {
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa,
            int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
    }
    
    public void setPath(Path path) {
        this.path = path;
    }

    private CustomErrorListener() {}

}
