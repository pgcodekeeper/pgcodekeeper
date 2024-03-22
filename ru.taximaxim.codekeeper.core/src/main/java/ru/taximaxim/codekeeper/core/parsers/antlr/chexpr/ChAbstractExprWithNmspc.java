/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.CtesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Dml_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Named_queryContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

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

    protected ChAbstractExprWithNmspc(String schema, MetaContainer meta) {
        super(schema, meta);
    }

    protected ChAbstractExprWithNmspc(ChAbstractExpr parent) {
        super(parent);
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

    protected Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name) {
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

    protected void analyzeCte(CtesContext with) {
        for (Named_queryContext withQuery : with.named_query()) {
            String withName = withQuery.name.getText();

            Dml_stmtContext data = withQuery.dml_stmt();
            var select = data.select_stmt();
            // TODO add other later
            if (select != null) {
                new ChSelect(this).analyze(select);
            }

            if (!cte.add(withName)) {
                log("Duplicate CTE " + withName);
            }
        }
    }

    public abstract List<String> analyze(T ruleCtx);
}
