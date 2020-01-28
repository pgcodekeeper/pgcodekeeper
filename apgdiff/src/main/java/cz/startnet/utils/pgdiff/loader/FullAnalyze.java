package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;

public final class FullAnalyze {

    private final List<Object> errors;
    private final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    private final PgDatabase db;

    private FullAnalyze(PgDatabase db, List<Object> errors) {
        this.db = db;
        this.errors = errors;
    }

    public static void fullAnalyze(PgDatabase db, List<Object> errors)
            throws InterruptedException, IOException {
        new FullAnalyze(db, errors).fullAnalyze();
    }

    public void fullAnalyze() throws InterruptedException, IOException {
        analyzeView(null);

        for (AbstractAnalysisLauncher l : db.getAnalysisLaunchers()) {
            if (l != null) {
                AntlrParser.submitAntlrTask(antlrTasks,
                        () -> l.launchAnalyze(errors),
                        deps -> l.getStmt().addAllDeps(deps));
            }
        }
        db.clearAnalysisLaunchers();
        AntlrParser.finishAntlr(antlrTasks);
    }

    public void analyzeView(PgView st) {
        List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();
        for (int i = 0; i < launchers.size(); ++i) {
            AbstractAnalysisLauncher l = launchers.get(i);
            if (l instanceof ViewAnalysisLauncher
                    && (st == null || st.equals(l.getStmt()))) {
                // allow GC to reclaim context memory immediately
                // and protects from infinite recursion
                launchers.set(i, null);
                ((ViewAnalysisLauncher) l).setFullAnalyze(this);
                l.getStmt().addAllDeps(l.launchAnalyze(errors));
            }
        }
    }
}
