/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.msexpr;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.As_table_aliasContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Common_table_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.With_expressionContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * @author levsha_aa
 *
 * @param <T> analyzed expression, should be extension of ParserRuleContext or a rulectx wrapper class
 */
public abstract class MsAbstractExprWithNmspc<T> extends MsAbstractExpr {

    /**
     * The local namespace of this Select.<br>
     * String-Reference pairs keep track of external table aliases and
     * names.<br>
     * String-null pairs keep track of internal query names that have only the
     * Alias.
     */
    private final Map<String, GenericColumn> namespace = new HashMap<>();
    /**
     * Unaliased namespace keeps track of tables that have no Alias.<br>
     * It has to be separate since same-named unaliased tables from different
     * schemas can be used, requiring qualification.
     */
    private final Set<GenericColumn> unaliasedNamespace = new HashSet<>();
    /**
     * CTE names that current level of FROM has access to.
     */
    private final Set<String> cte = new HashSet<>();

    protected MsAbstractExprWithNmspc(String schema, MetaContainer meta) {
        super(schema, meta);
    }

    protected MsAbstractExprWithNmspc(MsAbstractExpr parent) {
        super(parent);
    }

    @Override
    protected MsAbstractExprWithNmspc<?> findCte(String cteName) {
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
            if (ref == null) {
                continue;
            }
            IRelation rel = findRelation(ref.schema, ref.table);
            if (rel == null) {
                continue;
            }

            Stream<Pair<String, String>> columns = rel.getRelationColumns();
            for (Pair<String, String> col : PgDiffUtils.sIter(columns)) {
                if (col.getFirst().equals(name)) {
                    return new Pair<>(rel, col);
                }
            }
        }
        return null;
    }

    /**
     * Clients may use this to setup pseudo-variable names before expression analysis.
     */
    public boolean addReference(String alias, GenericColumn object) {
        String aliasCi = alias.toLowerCase(Locale.ROOT);
        boolean exists = namespace.containsKey(aliasCi);
        if (exists) {
            log("Duplicate namespace entry: {}", aliasCi);
        } else {
            namespace.put(aliasCi, object);
        }
        return !exists;
    }

    public boolean addRawTableReference(GenericColumn qualifiedTable) {
        boolean exists = !unaliasedNamespace.add(qualifiedTable);
        if (exists) {
            log("Duplicate unaliased table: {} {}", qualifiedTable.schema, qualifiedTable.table);
        }
        return !exists;
    }

    protected GenericColumn addNameReference(Qualified_nameContext name, As_table_aliasContext alias) {
        String firstName = name.name.getText();

        boolean isCte = name.DOT().isEmpty() && hasCte(firstName);
        GenericColumn depcy = null;
        if (!isCte) {
            depcy = addObjectDepcy(name, DbObjType.TABLE);
        }

        if (alias != null) {
            if (depcy != null) {
                // add alias definition
                addVariable(depcy, alias.id());
            }
            String aliasName = alias.id().getText();
            addReference(aliasName, depcy);
        } else if (isCte) {
            addReference(firstName, null);
        } else {
            addRawTableReference(depcy);
        }

        return depcy;
    }

    protected void analyzeCte(With_expressionContext with) {
        for (Common_table_expressionContext withQuery : with.common_table_expression()) {
            new MsSelect(this).analyze(withQuery.select_statement());

            String withName = withQuery.id().getText();
            if (!cte.add(withName)) {
                log("Duplicate CTE " + withName);
            }
        }
    }

    public abstract List<String> analyze(T ruleCtx);
}
