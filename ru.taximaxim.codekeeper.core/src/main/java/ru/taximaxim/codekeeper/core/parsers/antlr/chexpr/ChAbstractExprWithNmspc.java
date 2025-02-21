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
package ru.taximaxim.codekeeper.core.parsers.antlr.chexpr;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alias_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Dml_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.With_queryContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class ChAbstractExprWithNmspc<T> extends ChAbstractExpr {

    /**
     * The local namespace of this Select.<br>
     * String-Reference pairs keep track of external table aliases and names.<br>
     * String-null pairs keep track of internal query names that have only the Alias.
     */
    private final Map<String, GenericColumn> namespace = new HashMap<>();
    /**
     * Unaliased namespace keeps track of tables that have no Alias.<br>
     * It has to be separate since same-named unaliased tables from different schemas can be used, requiring
     * qualification.
     */
    private final Set<GenericColumn> unaliasedNamespace = new HashSet<>();

    /**
     * CTE names that current level of FROM has access to.
     */
    private final Set<String> cte = new HashSet<>();

    /**
     * This variable is used to isolate references at current level.
     * We need it to not lose the dependencies in with_clauseContext
     */
    private final boolean isLocalScope;

    protected ChAbstractExprWithNmspc(String schema, MetaContainer meta) {
        super(schema, meta);
        this.isLocalScope = false;
    }

    protected ChAbstractExprWithNmspc(ChAbstractExpr parent, boolean isLocalScope) {
        super(parent);
        this.isLocalScope = isLocalScope;
    }

    @Override
    protected ChAbstractExprWithNmspc<?> findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    @Override
    protected Entry<String, GenericColumn> findReferenceRecursive(String schema, String name) {
        Entry<String, GenericColumn> ref = findReferenceInNmspc(schema, name);
        return ref == null ? super.findReferenceRecursive(schema, name) : ref;
    }

    private Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name) {
        boolean found;
        GenericColumn dereferenced = null;
        if (schema == null && namespace.containsKey(name)) {
            found = true;
            dereferenced = namespace.get(name);
        } else if (!unaliasedNamespace.isEmpty()) {
            // simple empty check to save some allocations
            // it will almost always be empty
            for (GenericColumn unaliased : unaliasedNamespace) {
                if (unaliased.table.equalsIgnoreCase(name) &&
                        (schema == null || unaliased.schema.equalsIgnoreCase(schema))) {
                    if (dereferenced == null) {
                        dereferenced = unaliased;
                        if (schema != null) {
                            // fully qualified, no ambiguity search needed
                            break;
                        }
                    } else {
                        log("Ambiguous reference: {}", name);
                    }
                }
            }
            found = dereferenced != null;
        } else {
            found = false;
        }

        return found ? new SimpleEntry<>(name, dereferenced) : null;
    }

    @Override
    protected void addReferenceInRootParent(Qualified_nameContext name, Alias_clauseContext alias, boolean isFrom) {
        if (isLocalScope || !hasParent()) {
            addNameReference(name, alias, isFrom);
        } else {
            super.addReferenceInRootParent(name, alias, isFrom);
        }
    }

    /**
     * Clients may use this to setup pseudo-variable names before expression
     * analysis.
     */
    private void addReference(String alias, GenericColumn object) {
        if (namespace.containsKey(alias)) {
            log(Consts.DUPLICATE_ALIASES, alias);
            return;
        }
        namespace.put(alias, object);
    }

    public void addReference(String alias) {
        addReference(alias, null);
    }

    public boolean addRawTableReference(GenericColumn qualifiedTable) {
        boolean exists = !unaliasedNamespace.add(qualifiedTable);
        if (exists) {
            log("Duplicate unaliased table: {} {}", qualifiedTable.schema, qualifiedTable.table);
        }
        return !exists;
    }

    @Override
    protected Pair<IRelation, Pair<String, String>> findColumn(String name) {
        Pair<IRelation, Pair<String, String>> ret = findColumn(name, namespace.values());
        if (ret == null) {
            ret = findColumn(name, unaliasedNamespace);
        }
        return ret != null ? ret : super.findColumn(name);
    }

    private Pair<IRelation, Pair<String, String>> findColumn(String name, Collection<GenericColumn> refs) {
        for (GenericColumn ref : refs) {
            if (ref != null) {
                IRelation rel = findRelation(ref.schema, ref.table);
                if (rel == null) {
                    continue;
                }

                Pair<IRelation, Pair<String, String>> pair = rel.getRelationColumns()
                        .filter(e -> e.getFirst().equals(name))
                        .findFirst().map(e -> new Pair<>(rel, e))
                        .orElse(null);
                if (pair != null) {
                    return pair;
                }
            }
        }
        return null;
    }

    protected void analyzeCte(With_clauseContext with) {
        if (with == null) {
            return;
        }

        for (With_queryContext withQuery : with.with_query()) {
            String withName = withQuery.name.getText();
            var expr = withQuery.expr();
            if (expr != null) {
                new ChValueExpr(this).analyze(expr);
            } else {
                Dml_stmtContext data = withQuery.dml_stmt();
                var select = data.select_stmt();
                if (select != null) {
                    new ChSelect(this).analyze(select);
                }
            }

            if (!cte.add(withName)) {
                log("Duplicate CTE " + withName);
            }
        }
    }

    private GenericColumn addNameReference(Qualified_nameContext name, Alias_clauseContext alias, boolean isFrom) {
        String firstName = QNameParser.getFirstName(name.identifier());
        boolean isCte = name.DOT().isEmpty() && hasCte(firstName);
        GenericColumn depcy = null;
        if (!isCte && isFrom) {
            depcy = addObjectDepcy(name, DbObjType.TABLE);
        }

        if (alias != null) {
            ParserRuleContext aliasCtx = getAliasCtx(alias);
            if (depcy != null) {
                // add alias definition
                addReference(depcy, aliasCtx, LocationType.VARIABLE);
            }
            addReference(aliasCtx.getText(), depcy);
        } else if (isCte) {
            addReference(firstName, null);
        } else {
            addRawTableReference(depcy);
        }

        return depcy;
    }

    protected ParserRuleContext getAliasCtx(Alias_clauseContext alias) {
        ParserRuleContext aliasCtx = alias.identifier();
        if (aliasCtx == null) {
            aliasCtx = alias.id_token();
        }
        return aliasCtx;
    }

    public abstract List<String> analyze(T ruleCtx);
}
