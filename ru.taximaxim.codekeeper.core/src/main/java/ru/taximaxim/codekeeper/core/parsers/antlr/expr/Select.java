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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.After_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alias_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.From_itemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.From_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Groupby_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Grouping_elementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Grouping_element_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IndirectionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_varContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Orderby_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Perform_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_sublistContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_subqueryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Value_expression_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Values_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Values_valuesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Window_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_queryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.SelectOps;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.SelectStmt;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IConstraint;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class Select extends AbstractExprWithNmspc<Select_stmtContext> {

    private static final Logger LOG = LoggerFactory.getLogger(Select.class);

    /**
     * Flags for proper FROM (subquery) analysis.<br>
     * {@link #findReferenceInNmspc(String, String, String)} assumes that when {@link #inFrom} is set the FROM clause
     * of that query is analyzed and skips that namespace entirely unless {@link #lateralAllowed} is also set
     * (when analyzing a lateral FROM subquery or a function call).<br>
     * This assumes that {@link #from(From_itemContext)} is the first method to fill the namespace.<br>
     * Note: caller of {@link #from(From_itemContext)} is responsible for setting {@link #inFrom} flag.
     */
    private boolean inFrom;
    /**
     * @see #inFrom
     */
    private boolean lateralAllowed;

    public Select(MetaContainer db) {
        super(db);
    }

    protected Select(AbstractExpr parent) {
        super(parent);
    }

    @Override
    protected boolean namespaceAccessible() {
        return !inFrom || lateralAllowed;
    }

    @Override
    public List<ModPair<String, String>> analyze(Select_stmtContext ruleCtx) {
        return analyze(new SelectStmt(ruleCtx));
    }

    public List<ModPair<String, String>> analyze(Select_stmt_no_parensContext ruleCtx) {
        return analyze(new SelectStmt(ruleCtx));
    }

    public List<ModPair<String, String>> analyze(SelectStmt select) {
        return analyze(select, null);
    }

    protected List<ModPair<String, String>> analyze(SelectStmt select, With_queryContext recursiveCteCtx) {
        With_clauseContext with = select.withClause();
        if (with != null) {
            analyzeCte(with);
        }

        List<ModPair<String, String>> ret = selectOps(select.selectOps(), recursiveCteCtx);

        selectAfterOps(select.afterOps());

        return ret;
    }

    public List<ModPair<String, String>> analyze(Perform_stmtContext perform) {
        List<ModPair<String, String>> ret = perform(perform);

        Select_opsContext ops = perform.select_ops();
        if (ops != null) {
            new Select(this).selectOps(new SelectOps(ops));
        }
        selectAfterOps(perform.after_ops());
        return ret;
    }

    private List<ModPair<String, String>> perform(Perform_stmtContext perform) {
        // from defines the namespace so it goes before everything else
        if (perform.FROM() != null) {
            from(perform.from_item());
        }

        ValueExpr vex = new ValueExpr(this);
        List<ModPair<String, String>> ret = sublist(perform.select_list().select_sublist(), vex);

        if ((perform.set_qualifier() != null && perform.ON() != null)
                || perform.WHERE() != null || perform.HAVING() != null) {
            for (VexContext v : perform.vex()) {
                vex.analyze(new Vex(v));
            }
        }

        Groupby_clauseContext groupBy = perform.groupby_clause();
        if (groupBy != null) {
            groupBy(groupBy.grouping_element_list(), vex);
        }

        if (perform.WINDOW() != null) {
            for (Window_definitionContext window : perform.window_definition()) {
                vex.window(window);
            }
        }

        return ret;
    }

    private void selectAfterOps(List<After_opsContext> ops) {
        ValueExpr vex = new ValueExpr(this);

        for (After_opsContext after : ops) {
            VexContext vexCtx = after.vex();
            if (vexCtx != null) {
                vex.analyze(new Vex(vexCtx));
            }

            Orderby_clauseContext orderBy = after.orderby_clause();
            if (orderBy != null) {
                vex.orderBy(orderBy);
            }

            for (Schema_qualified_nameContext tableLock : after.schema_qualified_name()) {
                addRelationDepcy(PgParserAbstract.getIdentifiers(tableLock));
            }
        }
    }

    private List<ModPair<String, String>> selectOps(SelectOps selectOps) {
        return selectOps(selectOps, null);
    }

    private List<ModPair<String, String>> selectOps(SelectOps selectOps, With_queryContext recursiveCteCtx) {
        List<ModPair<String, String>> ret;
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext primary = selectOps.selectPrimary();

        if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new Select(this).selectOps(selectOps.selectOps(0));

            // when a recursive CTE is encountered, its SELECT is guaranteed
            // to have a "SelectOps" on top level
            //
            // WITH RECURSIVE a(b) AS (select1 UNION select2) SELECT a.b FROM a
            //
            // CTE analysis creates a new child namespace to recurse through SelectOps
            // and this is where we are now.
            // Since current namespace is independent of its parent and SelectOps operands
            // will be analyzed on further separate child namespaces
            // we can safely store "select1"s signature as a CTE on the current pseudo-namespace
            // so that it's visible to the recursive "select2" and doesn't pollute any other namespaces.
            //
            // Results of select1 (non-recursive part) analysis are used
            // as CTE by select2's (potentially recursive part) analysis.
            // This way types of recursive references in select2 will be known from select1.
            // Lastly select1 signature is used for the entire CTE.
            if (recursiveCteCtx != null) {
                addCteSignature(recursiveCteCtx, ret);
            }

            Select select = new Select(this);
            SelectOps ops = selectOps.selectOps(1);
            if (ops != null) {
                select.selectOps(ops);
            } else if (primary != null) {
                select.primary(primary);
            } else if (selectStmt != null) {
                select.analyze(selectStmt);
            } else {
                LOG.warn("No alternative in right part of SelectOps!");
            }
        } else if (primary != null) {
            ret = primary(primary);
        } else if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            ret = analyze(selectStmt);
        } else {
            LOG.warn("No alternative in SelectOps!");
            ret = Collections.emptyList();
        }
        return ret;
    }

    private List<ModPair<String, String>> primary(Select_primaryContext primary) {
        List<ModPair<String, String>> ret;
        Values_stmtContext values;
        if (primary.SELECT() != null) {
            // from defines the namespace so it goes before everything else
            if (primary.FROM() != null) {
                from(primary.from_item());
            }

            ValueExpr vex = new ValueExpr(this);

            Select_listContext list = primary.select_list();
            if (list != null) {
                ret = sublist(list.select_sublist(), vex);
            } else {
                ret = Collections.emptyList();
            }


            if ((primary.set_qualifier() != null && primary.ON() != null)
                    || primary.WHERE() != null || primary.HAVING() != null) {
                for (VexContext v : primary.vex()) {
                    vex.analyze(new Vex(v));
                }
            }

            Groupby_clauseContext groupBy = primary.groupby_clause();
            if (groupBy != null) {
                groupBy(groupBy.grouping_element_list(), vex);
            }

            if (primary.WINDOW() != null) {
                for (Window_definitionContext window : primary.window_definition()) {
                    vex.window(window);
                }
            }
        } else if (primary.TABLE() != null) {
            Schema_qualified_nameContext table = primary.schema_qualified_name();
            addNameReference(table, null);
            ret = new ArrayList<>();
            qualAster(PgParserAbstract.getIdentifiers(table), ret);
        } else if ((values = primary.values_stmt()) != null) {
            ret = new ArrayList<>();
            ValueExpr vex = new ValueExpr(this);
            for (Values_valuesContext vals : values.values_values()) {
                for (VexContext v : vals.vex()) {
                    ret.add(vex.analyze(new Vex(v)));
                }
            }
        } else {
            LOG.warn("No alternative in select_primary!");
            ret = Collections.emptyList();
        }
        return ret;
    }

    List<ModPair<String, String>> sublist(List<Select_sublistContext> sublist, ValueExpr vex) {
        List<ModPair<String, String>> ret = new ArrayList<>(sublist.size());
        for (Select_sublistContext target : sublist) {
            Vex selectSublistVex = new Vex(target.vex());
            // analyze all before parse asterisk
            ModPair<String, String> columnPair = vex.analyze(selectSublistVex);

            if (TypesSetManually.QUALIFIED_ASTERISK.equals(columnPair.getSecond())
                    && analyzeAster(selectSublistVex, ret)) {
                continue;
            }

            ParserRuleContext aliasCtx = target.col_label();
            if (aliasCtx == null) {
                aliasCtx = target.bare_col_label();
            }

            if (aliasCtx != null) {
                columnPair.setFirst(aliasCtx.getText());
            }

            ret.add(columnPair);
        }
        return ret;
    }

    private boolean analyzeAster(Vex vex, List<ModPair<String, String>> columns) {
        Value_expression_primaryContext primary = vex.primary();
        if (primary != null && primary.MULTIPLY() != null) {
            unqualAster(columns);
            return true;
        }

        if (primary != null) {
            Indirection_varContext ind = primary.indirection_var();
            if (ind != null) {
                return indirectionAsQualAster(ind, columns);
            }
        }

        return false;
    }

    private boolean indirectionAsQualAster(Indirection_varContext ctx, List<ModPair<String, String>> cols) {
        Indirection_listContext indList = ctx.indirection_list();
        if (indList == null || indList.MULTIPLY() == null) {
            // this shouldn't happen, crash hard
            throw new IllegalStateException("Qualified asterisk without the asterisk!");
        }

        ParserRuleContext id = ctx.identifier();
        if (id == null) {
            id = ctx.dollar_number();
        }

        List<IndirectionContext> ind = indList.indirection();
        switch (ind.size()) {
        case 0:
            return qualAster(Arrays.asList(id), cols);
        case 1:
            IndirectionContext second = ind.get(0);
            if (second.LEFT_BRACKET() == null) {
                return qualAster(Arrays.asList(id, second.col_label()), cols);
            }
            // cannot handle asterisk indirection from an array element
            //$FALL-THROUGH$
        default:
            // long indirections are unsupported
            return false;
        }
    }

    private void groupBy(Grouping_element_listContext list, ValueExpr vex) {
        ValueExpr child = new ValueExpr(this, new HashSet<>());

        for (Grouping_elementContext el : list.grouping_element()) {
            VexContext vexCtx = el.vex();
            Grouping_element_listContext sub;
            if (vexCtx != null) {
                child.analyze(new Vex(vexCtx));
            } else if ((sub = el.grouping_element_list()) != null) {
                groupingSet(sub, vex);
            }
        }

        // add dependencies to primary key
        for (PgObjLocation dep : child.getDepcies()) {
            vex.addDepcy(dep);
            addPrimaryKeyDepcy(dep, vex);
        }
    }

    private void addPrimaryKeyDepcy(PgObjLocation dep, ValueExpr vex) {
        if (dep.getType() != DbObjType.COLUMN) {
            return;
        }

        for (IConstraint con : meta.getConstraints(dep.getSchema(), dep.getTable())) {
            if (con.isPrimaryKey() && con.containsColumn(dep.getObjName())) {
                // implicit reference
                vex.addDepcy(new GenericColumn(con.getSchemaName(),
                        con.getTableName(), con.getName(), DbObjType.CONSTRAINT), null);
            }
        }
    }

    private void groupingSet(Grouping_element_listContext list, ValueExpr vex) {
        for (Grouping_elementContext el : list.grouping_element()) {
            VexContext vexCtx = el.vex();
            Grouping_element_listContext sub;
            if (vexCtx != null) {
                vex.analyze(new Vex(vexCtx));
            } else if ((sub = el.grouping_element_list()) != null) {
                groupingSet(sub, vex);
            }
        }
    }

    private static final Predicate<String> ANY = s -> true;

    private void unqualAster(List<ModPair<String, String>> cols) {
        for (GenericColumn gc : unaliasedNamespace) {
            addFilteredRelationColumnsDepcies(gc.schema, gc.table, ANY)
            .map(Pair::copyMod)
            .forEach(cols::add);
        }

        for (GenericColumn gc : namespace.values()) {
            if (gc != null) {
                addFilteredRelationColumnsDepcies(gc.schema, gc.table, ANY)
                .map(Pair::copyMod)
                .forEach(cols::add);
            }
        }

        complexNamespace.values().stream()
        .flatMap(List::stream)
        .map(Pair::copyMod)
        .forEach(cols::add);
    }

    private boolean qualAster(List<? extends ParserRuleContext> ids, List<ModPair<String, String>> cols) {
        ParserRuleContext schemaCtx = QNameParser.getSecondNameCtx(ids);
        String schema = schemaCtx == null ? null : schemaCtx.getText();
        ParserRuleContext relationCtx = QNameParser.getFirstNameCtx(ids);
        String relation = relationCtx.getText();

        Entry<String, GenericColumn> ref = findReference(schema, relation, null);
        if (ref == null) {
            LOG.warn("Asterisk qualification not found: {}.{}", schema, relation);
            return false;
        }
        GenericColumn relationGc = ref.getValue();
        if (relationGc != null) {
            if  (schemaCtx != null) {
                addDepcy(new GenericColumn(relationGc.schema, DbObjType.SCHEMA), schemaCtx);
            }

            if (relationGc.getObjName().equals(relation)) {
                addDepcy(relationGc, relationCtx);
            } else {
                addAliasReference(relationGc, relationCtx);
            }

            addFilteredRelationColumnsDepcies(relationGc.schema, relationGc.table, ANY)
            .map(Pair::copyMod)
            .forEach(cols::add);
            return true;
        }
        List<Pair<String, String>> complexNsp = findReferenceComplex(relation);
        if (complexNsp != null) {
            complexNsp.stream()
            .map(Pair::copyMod)
            .forEach(cols::add);
            return true;
        }
        LOG.warn("Complex not found: {}", relation);
        return false;
    }

    void from(List<From_itemContext> items) {
        boolean oldFrom = inFrom;
        try {
            inFrom = true;
            for (From_itemContext fromItem : items) {
                from(fromItem);
            }
        } finally {
            inFrom = oldFrom;
        }
    }

    private void from(From_itemContext fromItem) {
        From_primaryContext primary;

        if (fromItem.LEFT_PAREN() != null && fromItem.RIGHT_PAREN() != null) {
            Alias_clauseContext joinAlias = fromItem.alias_clause();
            if (joinAlias != null) {
                // we simplify this case by analyzing joined ranges in an isolated scope
                // this way we get dependencies and don't pollute this scope with names hidden by the join alias
                // the only name this form of FROM clause exposes is the join alias

                // consequence of this method: no way to connect column references with the tables inside the join
                // that would require analyzing the table schemas and actually "performing" the join
                Select fromProcessor = new Select(this);
                fromProcessor.inFrom = true;
                fromProcessor.from(fromItem.from_item(0));
                addReference(joinAlias.alias.getText(), null);
            } else {
                from(fromItem.from_item(0));
            }
        } else if (fromItem.JOIN() != null) {
            from(fromItem.from_item(0));
            from(fromItem.from_item(1));

            if (fromItem.ON() != null) {
                VexContext joinOn = fromItem.vex();
                boolean oldLateral = lateralAllowed;
                // technically incorrect simplification
                // joinOn expr only does not have access to anything in this FROM
                // except JOIN operand subtrees
                // but since we're not doing expression validity checks
                // we pretend that joinOn has access to everything
                // that a usual LATERAL expr has access to
                // this greatly simplifies analysis logic here
                try {
                    lateralAllowed = true;
                    ValueExpr vexOn = new ValueExpr(this);
                    vexOn.analyze(new Vex(joinOn));
                } finally {
                    lateralAllowed = oldLateral;
                }
            }
        } else if ((primary = fromItem.from_primary()) != null) {
            Alias_clauseContext alias = primary.alias_clause();
            List<Function_callContext> functions = primary.function_call();
            Schema_qualified_nameContext table;
            Table_subqueryContext subquery;

            if (!functions.isEmpty()) {
                functions.forEach(e -> function(e, primary.alias));
            } else if ((table = primary.schema_qualified_name()) != null) {
                addNameReference(table, alias);
                if (primary.TABLESAMPLE() != null) {
                    ValueExpr vex = new ValueExpr(this);
                    for (VexContext v : primary.vex()) {
                        vex.analyze(new Vex(v));
                    }
                }
            } else if ((subquery = primary.table_subquery()) != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = primary.LATERAL() != null;
                    List<ModPair<String, String>> columnList = new Select(this).analyze(subquery.select_stmt());

                    String tableSubQueryAlias = alias.alias.getText();
                    addReference(tableSubQueryAlias, null);
                    complexNamespace.put(tableSubQueryAlias, new ArrayList<>(columnList));
                } finally {
                    lateralAllowed = oldLateral;
                }
            } else {
                LOG.warn("No alternative in from_primary!");
            }
        } else {
            LOG.warn("No alternative in from_item!");
        }
    }

    private void function(Function_callContext function, IdentifierContext alias) {
        boolean oldLateral = lateralAllowed;
        try {
            lateralAllowed = true;
            ValueExpr vexFunc = new ValueExpr(this);
            Pair<String, String> func = vexFunc.function(function);
            if (func.getFirst() != null) {
                String funcAlias = alias == null ? func.getFirst(): alias.getText();
                addReference(funcAlias, null);
                complexNamespace.put(funcAlias,
                        Arrays.asList(new Pair<>(funcAlias, func.getSecond())));
            }
        } finally {
            lateralAllowed = oldLateral;
        }
    }
}