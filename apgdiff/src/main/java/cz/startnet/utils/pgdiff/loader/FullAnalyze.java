package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.OperatorAnalysisLaincher;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.meta.MetaUtils;

public final class FullAnalyze {

    private final List<Object> errors;
    private final List<PgObjLocation> refs = new ArrayList<>();
    private final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    private final PgDatabase db;
    private final IDatabase metaDb;

    private FullAnalyze(PgDatabase db, IDatabase metaDb, List<Object> errors) {
        this.db = db;
        this.metaDb = metaDb;
        this.errors = errors;
    }

    public static void fullAnalyze(PgDatabase db, List<Object> errors)
            throws InterruptedException, IOException {
        fullAnalyze(db, MetaUtils.createTreeFromDb(db), errors);
    }

    public static void fullAnalyze(PgDatabase db, IDatabase metaDb, List<Object> errors)
            throws InterruptedException, IOException {
        new FullAnalyze(db, metaDb, errors).fullAnalyze();
    }

    private void fullAnalyze() throws InterruptedException, IOException {
        analyzeOperators();
        analyzeView(null);

        for (AbstractAnalysisLauncher l : db.getAnalysisLaunchers()) {
            if (l != null) {
                AntlrParser.submitAntlrTask(antlrTasks,
                        () -> l.launchAnalyze(errors, metaDb),
                        deps -> {
                            l.getStmt().addAllDeps(deps);
                            refs.addAll(l.getReferences());
                        });
            }
        }
        db.clearAnalysisLaunchers();
        AntlrParser.finishAntlr(antlrTasks);

        for (PgObjLocation ref : refs) {
            db.addReference(ref.getFilePath(), ref);
        }
    }

    public void analyzeView(IRelation rel) {
        List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();
        for (int i = 0; i < launchers.size(); ++i) {
            AbstractAnalysisLauncher l = launchers.get(i);
            if (l instanceof ViewAnalysisLauncher
                    && (rel == null
                    || (rel.getSchemaName().equals(l.getStmt().getSchemaName())
                            && rel.getName().equals(l.getStmt().getName())))) {
                // allow GC to reclaim context memory immediately
                // and protects from infinite recursion
                launchers.set(i, null);
                ((ViewAnalysisLauncher) l).setFullAnalyze(this);
                l.getStmt().addAllDeps(l.launchAnalyze(errors, metaDb));
                refs.addAll(l.getReferences());
            }
        }
    }

    private void analyzeOperators() {
        List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();
        for (int i = 0; i < launchers.size(); ++i) {
            AbstractAnalysisLauncher l = launchers.get(i);
            if (l instanceof OperatorAnalysisLaincher) {
                // allow GC to reclaim context memory immediately
                launchers.set(i, null);
                l.launchAnalyze(errors, metaDb);
            }
        }
    }
}
