/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrTask;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AggregateAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.OperatorAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.schema.meta.MetaUtils;

public final class FullAnalyze {

    private final List<Object> errors;
    private final List<PgObjLocation> refs = new ArrayList<>();
    private final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    private final AbstractDatabase db;
    private final MetaContainer meta;

    private FullAnalyze(AbstractDatabase db, MetaContainer meta, List<Object> errors) {
        this.db = db;
        this.meta = meta;
        this.errors = errors;
    }

    public static void fullAnalyze(AbstractDatabase db, List<Object> errors)
            throws InterruptedException, IOException {
        fullAnalyze(db, MetaUtils.createTreeFromDb(db), errors);
    }

    public static void fullAnalyze(AbstractDatabase db, MetaContainer metaDb, List<Object> errors)
            throws InterruptedException, IOException {
        new FullAnalyze(db, metaDb, errors).fullAnalyze();
    }

    private void fullAnalyze() throws InterruptedException, IOException {
        analyzeOperators();
        analyzeAggregate();
        analyzeView(null);

        for (AbstractAnalysisLauncher l : db.getAnalysisLaunchers()) {
            if (l != null) {
                AntlrParser.submitAntlrTask(antlrTasks,
                        () -> l.launchAnalyze(errors, meta),
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
            if (l instanceof ViewAnalysisLauncher v
                    && (rel == null
                    || (rel.getSchemaName().equals(l.getSchemaName())
                            && rel.getName().equals(l.getStmt().getName())))) {
                // allow GC to reclaim context memory immediately
                // and protects from infinite recursion
                launchers.set(i, null);
                v.setFullAnalyze(this);
                l.getStmt().addAllDeps(l.launchAnalyze(errors, meta));
                refs.addAll(l.getReferences());
            }
        }
    }

    private void analyzeOperators() {
        List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();
        for (int i = 0; i < launchers.size(); ++i) {
            AbstractAnalysisLauncher l = launchers.get(i);
            if (l instanceof OperatorAnalysisLauncher) {
                // allow GC to reclaim context memory immediately
                launchers.set(i, null);
                l.launchAnalyze(errors, meta);
            }
        }
    }

    private void analyzeAggregate() {
        List<AbstractAnalysisLauncher> launchers = db.getAnalysisLaunchers();
        for (int i = 0; i < launchers.size(); ++i) {
            AbstractAnalysisLauncher l = launchers.get(i);
            if (l instanceof AggregateAnalysisLauncher) {
                // allow GC to reclaim context memory immediately
                launchers.set(i, null);
                l.launchAnalyze(errors, meta);
            }
        }
    }
}
