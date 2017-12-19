package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.List;
import java.util.Map.Entry;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyGraph {

    private final DirectedGraph<PgStatement, DefaultEdge> graph =
            new SimpleDirectedGraph<>(DefaultEdge.class);

    private final EdgeReversedGraph<PgStatement, DefaultEdge> reversedGraph =
            new EdgeReversedGraph<>(graph);

    /**
     * Направление связей в графе:<br>
     * зависящий объект → зависимость <br>
     * source → target
     */
    public DirectedGraph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }

    public EdgeReversedGraph<PgStatement, DefaultEdge> getReversedGraph(){
        return reversedGraph;
    }

    private final PgDatabase db;

    /**
     * Copied database, graph source.<br>
     * <b>Do not modify</b> any elements in this as it will break
     * HashSets/HashMaps and with them the generated graph.
     */
    public PgDatabase getDb(){
        return db;
    }

    public DepcyGraph(PgDatabase graphSrc) {
        db = graphSrc.deepCopy();
        create();
    }

    public DepcyGraph(PgDatabase graphSrc, boolean workWithDbCopy) {
        db = workWithDbCopy ? graphSrc.deepCopy() : graphSrc;
        create();
    }

    private void create() {
        graph.addVertex(db);

        // first pass: object tree
        for(PgSchema schema : db.getSchemas()) {
            graph.addVertex(schema);
            graph.addEdge(schema, db);

            for(PgFunction func : schema.getFunctions()) {
                graph.addVertex(func);
                graph.addEdge(func, schema);
            }

            for(PgSequence seq : schema.getSequences()) {
                graph.addVertex(seq);
                graph.addEdge(seq, schema);
            }

            for (PgType type : schema.getTypes()) {
                graph.addVertex(type);
                graph.addEdge(type, schema);
            }

            for (PgDomain domain : schema.getDomains()) {
                graph.addVertex(domain);
                graph.addEdge(domain, schema);
            }

            for(PgTable table : schema.getTables()) {
                graph.addVertex(table);
                graph.addEdge(table, schema);

                for(PgColumn col : table.getColumns()) {
                    graph.addVertex(col);
                    graph.addEdge(col, table);
                }

                for(PgIndex idx : table.getIndexes()) {
                    graph.addVertex(idx);
                    graph.addEdge(idx, table);
                }

                for (PgConstraint cons : table.getConstraints()) {
                    graph.addVertex(cons);
                    graph.addEdge(cons, table);
                }

                for (PgTrigger trg : table.getTriggers()) {
                    graph.addVertex(trg);
                    graph.addEdge(trg, table);
                }

                for (PgRule rule : table.getRules()) {
                    graph.addVertex(rule);
                    graph.addEdge(rule, table);
                }
            }

            for(PgView view : schema.getViews()) {
                graph.addVertex(view);
                graph.addEdge(view, schema);

                for (PgRule rule : view.getRules()) {
                    graph.addVertex(rule);
                    graph.addEdge(rule, view);
                }

                for (PgTrigger trigger : view.getTriggers()) {
                    graph.addVertex(trigger);
                    graph.addEdge(trigger, view);
                }
            }
        }
        for(PgExtension ext : db.getExtensions()) {
            graph.addVertex(ext);
            graph.addEdge(ext, db);
        }

        // second pass: dependency graph
        for(PgSchema schema : db.getSchemas()) {
            processDeps(schema);

            for(PgFunction func : schema.getFunctions()) {
                processDeps(func);
            }
            for(PgSequence seq : schema.getSequences()) {
                processDeps(seq);
            }
            for (PgType type : schema.getTypes()) {
                processDeps(type);
            }
            for (PgDomain domain : schema.getDomains()) {
                processDeps(domain);
            }
            for(PgTable table : schema.getTables()) {
                processDeps(table);

                for(PgColumn col : table.getColumns()) {
                    processDeps(col);
                }
                for(PgIndex idx : table.getIndexes()) {
                    processDeps(idx);
                }
                for (PgConstraint cons : table.getConstraints()) {
                    processDeps(cons);
                    createFkeyToUnique(cons);
                }
                for (PgTrigger trg : table.getTriggers()) {
                    processDeps(trg);
                }
                for (PgRule rule : table.getRules()) {
                    processDeps(rule);
                }
            }
            for(PgView view : schema.getViews()) {
                processDeps(view);

                for (PgRule rule : view.getRules()) {
                    processDeps(rule);
                }
                for (PgTrigger trg : view.getTriggers()) {
                    processDeps(trg);
                }
            }
        }
        for(PgExtension ext : db.getExtensions()) {
            processDeps(ext);
        }
    }

    private void processDeps(PgStatement st) {
        for (GenericColumn dep : st.getDeps()) {
            PgStatement depSt = dep.getStatement(db);
            if (depSt != null && !st.equals(depSt)) {
                graph.addEdge(st, depSt);
            }
        }
    }

    /**
     * The only way to find this depcy is to compare refcolumns against all existing unique
     * contraints/keys in reftable.
     * Unfortunately they might not exist at the stage where {@link PgStatement#getDeps()}
     * are populated so we have to defer their lookup until here.
     */
    private void createFkeyToUnique(PgConstraint con) {
        List<String> refs = con.getForeignColumns();
        GenericColumn refTable = con.getForeignTable();
        if (!refs.isEmpty() && refTable != null) {
            PgTable table = (PgTable) refTable.getStatement(db);
            if (table != null) {
                // TODO UNIQUE INDEX can be used here too
                for (PgConstraint refCon : table.getConstraints()) {
                    if ((refCon.isPrimaryKey() || refCon.isUnique()) && refs.equals(refCon.getColumns())) {
                        graph.addEdge(con, refCon);
                    }
                }
            }
        }
    }

    public void addCustomDepcies(List<Entry<PgStatement, PgStatement>> depcies) {
        for (Entry<PgStatement, PgStatement> depcy : depcies) {
            graph.addEdge(depcy.getKey(), depcy.getValue());
        }
    }
}