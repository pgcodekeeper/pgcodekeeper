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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alias_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Merge_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Update_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_queryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.SelectStmt;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class AbstractExprWithNmspc<T extends ParserRuleContext> extends AbstractExpr {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractExprWithNmspc.class);

    private static final String FUNC_ARGS_KEY = "\\_SPECIAL_CONTAINER_FOR_PRIMITIVE_VARS\\";

    /**
     * The local namespace of this Select.<br>
     * String-Reference pairs keep track of external table aliases and
     * names.<br>
     * String-null pairs keep track of internal query names that have only the
     * Alias.
     */
    protected final Map<String, GenericColumn> namespace = new LinkedHashMap<>();
    /**
     * Unaliased namespace keeps track of tables that have no Alias.<br>
     * It has to be separate since same-named unaliased tables from different
     * schemas can be used, requiring qualification.
     */
    protected final Set<GenericColumn> unaliasedNamespace = new LinkedHashSet<>();
    /**
     * Column alias' are in a separate sets (per table) since they have two
     * values as the Key. This is not a Map because we don't connect column
     * aliases with their columns.<br>
     * Columns of non-dereferenceable objects are aliases by default and need
     * not to be added to this set.
     */
    // TODO Necessary to allow aliases for columns of 'SELECT'.
    // In other words, it necessary have to think, how to make it
    // to work with such expressions:
    // SELECT (SELECT a.a) FROM (SELECT 1, 2, 3) a(a, b, c)
    // SELECT (SELECT a.a) FROM (SELECT 1 z, 2 x, 3 c) a(a, b, c)
    // SELECT (SELECT a.z) FROM (SELECT 1 z, 2 x, 3 c) a
    private final Map<String, Set<String>> columnAliases = new HashMap<>();
    /**
     * CTEs that current level of FROM has access to stored as their names and signatures.
     */
    private final Map<String, List<Pair<String, String>>> cte = new HashMap<>();

    /**
     * Non-table from items stored as their aliases and signatures.
     */
    protected final Map<String, List<Pair<String, String>>> complexNamespace = new LinkedHashMap<>();

    protected AbstractExprWithNmspc(MetaContainer meta) {
        super(meta);
    }

    protected AbstractExprWithNmspc(AbstractExpr parent) {
        super(parent);
    }

    @Override
    protected List<Pair<String, String>> findCte(String cteName) {
        List<Pair<String, String>> pairs = cte.get(cteName);
        return pairs != null ? pairs : super.findCte(cteName);
    }

    protected boolean namespaceAccessible() {
        return true;
    }

    @Override
    protected List<Pair<String, String>> findReferenceComplex(String name) {
        List<Pair<String, String>> ret = null;
        if (namespaceAccessible()) {
            ret = complexNamespace.get(name);
        }
        return ret != null ? ret : super.findReferenceComplex(name);
    }

    @Override
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        if (!namespaceAccessible()) {
            return super.findReference(schema, name, column);
        }

        boolean found = false;
        GenericColumn dereferenced = null;
        if (schema == null && namespace.containsKey(name)) {
            found = true;
            dereferenced = namespace.get(name);
        } else if (!unaliasedNamespace.isEmpty()) {
            // simple empty check to save some allocations
            // it will almost always be empty
            for (GenericColumn unaliased : unaliasedNamespace) {
                if (unaliased.table.equals(name) &&
                        (schema == null || unaliased.schema.equals(schema))) {
                    if (dereferenced == null) {
                        dereferenced = unaliased;
                        if (schema != null) {
                            // fully qualified, no ambiguity search needed
                            break;
                        }
                    } else {
                        LOG.warn(Messages.AbstractExprWithNmspc_log_ambiguos_ref, name);
                    }
                }
            }
            found = dereferenced != null;
        }

        if (!found) {
            return super.findReference(schema, name, column);
        }

        // column aliases imply there must be a corresponding table alias
        // so we may defer their lookup until here

        // also, if we cannot dereference an existing name it's safe to assume
        // all its columns are aliases
        // this saves a lookup and extra space in columnAliases
        if (column != null && dereferenced != null) {
            Set<String> columns = columnAliases.get(name);
            if (columns != null && columns.contains(column)) {
                dereferenced = null;
            }
        }

        return new SimpleEntry<>(name, dereferenced);
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
            if (DbObjType.VIEW == rel.getStatementType() && columns == null) {
                analyzeViewColumns(rel);
                columns = rel.getRelationColumns();

                if (columns == null) {
                    return null;
                }
            }

            for (Pair<String, String> col : PgDiffUtils.sIter(columns)) {
                if (col.getFirst().equals(name)) {
                    return new Pair<>(rel, col);
                }
            }
        }
        return null;
    }

    @Override
    protected Pair<String, String> findColumnInComplex(String name) {
        for (List<Pair<String, String>> compl : complexNamespace.values()) {
            for (Pair<String, String> col : compl) {
                if (col.getFirst().equals(name)) {
                    return col;
                }
            }
        }
        return super.findColumnInComplex(name);
    }

    /**
     * Declares a variable in the current namespace.
     * Variables of relation types are declared as references, rest are treated as primitives.
     *
     * @param alias var alias (required)
     * @param name var name (optional, may be null)
     * @param argType var type
     */
    public void declareNamespaceVar(String alias, String name, GenericColumn argType) {
        if (Consts.PG_CATALOG.equals(argType.schema)) {
            String type = argType.table.toLowerCase(Locale.ROOT);

            int firstParen = type.indexOf('(');
            if (firstParen != -1) {
                type = type.substring(0, firstParen);
            }

            int firstBracket = type.indexOf('[');
            if (firstBracket != -1) {
                type = type.substring(0, firstBracket);
            }

            if (Consts.SYS_TYPES.contains(type.trim())) {
                addVarToPrims(alias, name, argType.table);
                return;
            }
        }

        IRelation rel = findRelation(argType.schema, argType.table);
        if (rel != null) {
            GenericColumn ref = new GenericColumn(rel.getSchemaName(), rel.getName(), rel.getStatementType());
            addReference(alias, ref);
            if (name != null) {
                addReference(name, ref);
            }
        } else {
            // treat all non-relations (custom types etc) as primitives for now
            // this is in line with current behavior when, e.g., selecting from tables
            // (the composite type's qualified name will be taken as is)
            addVarToPrims(alias, name, argType.getQualifiedName());
        }
    }

    private void addVarToPrims(String alias, String name, String argType) {
        addNamespaceVariable(new Pair<>(alias, argType));
        if (name != null) {
            addNamespaceVariable(new Pair<>(name, argType));
        }
    }

    /**
     * Adds a "free-standing" variable (e.g. a non-table function parameter)
     * into a special complexNamespace container.
     */
    public void addNamespaceVariable(Pair<String, String> variable) {
        complexNamespace.computeIfAbsent(FUNC_ARGS_KEY, k -> new ArrayList<>()).add(variable);
    }

    /**
     * Clients may use this to setup pseudo-variable names before expression analysis.
     */
    public boolean addReference(String alias, GenericColumn object) {
        boolean exists = namespace.containsKey(alias);
        if (exists) {
            LOG.warn(Consts.DUPLICATE_ALIASES, alias);
        } else {
            namespace.put(alias, object);
        }
        return !exists;
    }

    public boolean addRawTableReference(GenericColumn qualifiedTable) {
        boolean exists = !unaliasedNamespace.add(qualifiedTable);
        if (exists) {
            LOG.warn(Messages.AbstractExprWithNmspc_log_dupl_unaliased_table, qualifiedTable.schema, qualifiedTable.table);
        }
        return !exists;
    }

    protected boolean addColumnReference(String alias, String column) {
        Set<String> columns = columnAliases.computeIfAbsent(alias, k -> new HashSet<>());
        boolean exists = !columns.add(column);
        if (exists) {
            LOG.warn(Messages.AbstractExprWithNmspc_log_dupl_col_alias, alias, column);
        }
        return !exists;
    }

    protected void addNameReference(Schema_qualified_nameContext name, Alias_clauseContext alias) {
        if (alias == null) {
            addNameReference(name, null, null);
        } else {
            addNameReference(name, alias.alias, alias.column_alias);
        }
    }

    protected void addNameReference(Schema_qualified_nameContext name, IdentifierContext alias,
            List<IdentifierContext> columnAliases) {
        List<ParserRuleContext> ids = PgParserAbstract.getIdentifiers(name);
        String firstName = QNameParser.getFirstName(ids);

        List<Pair<String, String>> cteList = null;
        if (ids.size() == 1) {
            cteList = findCte(firstName);
        }
        GenericColumn depcy = null;
        if (cteList == null) {
            depcy = addRelationDepcy(ids);
        }

        if (alias != null) {
            if (depcy != null) {
                // add alias definition
                addVariable(depcy, alias);
            }
            String aliasName = alias.getText();
            boolean added = addReference(aliasName, depcy);
            if (!added && cteList == null && columnAliases != null && !columnAliases.isEmpty()) {
                for (IdentifierContext columnAlias : columnAliases) {
                    addColumnReference(aliasName, columnAlias.getText());
                }
            } else if (cteList != null) {
                complexNamespace.put(aliasName, cteList);
            }
        } else if (cteList != null) {
            addReference(firstName, null);
            complexNamespace.put(firstName, cteList);
        } else {
            addRawTableReference(depcy);
        }
    }

    protected void analyzeCte(With_clauseContext with) {
        for (With_queryContext withQuery : with.with_query()) {
            String withName = withQuery.query_name.getText();

            Data_statementContext data = withQuery.data_statement();
            Select_stmtContext withSelect = data.select_stmt();
            Delete_stmt_for_psqlContext delete;
            Insert_stmt_for_psqlContext insert;
            Update_stmt_for_psqlContext update;
            Merge_stmt_for_psqlContext merge;

            List<ModPair<String, String>> pairs;
            if (withSelect != null) {
                pairs = new Select(this).analyze(new SelectStmt(withSelect), withQuery);
            } else if ((delete = data.delete_stmt_for_psql()) != null) {
                pairs = new Delete(this).analyze(delete);
            } else if ((insert = data.insert_stmt_for_psql()) != null) {
                pairs = new Insert(this).analyze(insert);
            } else if ((update = data.update_stmt_for_psql()) != null) {
                pairs = new Update(this).analyze(update);
            } else if ((merge = data.merge_stmt_for_psql()) != null) {
                pairs = new Merge(this).analyze(merge);
            } else {
                LOG.warn(Messages.AbstractExprWithNmspc_log_not_alternative);
                continue;
            }

            if (addCteSignature(withQuery, pairs)) {
                LOG.warn(Messages.AbstractExprWithNmspc_log_dupl_cte, withName);
            }
        }
    }

    /**
     * Renames entries in the signature list according to the CTE signature.
     */
    protected boolean addCteSignature(With_queryContext withQuery, List<ModPair<String, String>> resultTypes) {
        String withName = withQuery.query_name.getText();
        List<IdentifierContext> paramNamesIdentifers = withQuery.column_name;
        for (int i = 0; i < paramNamesIdentifers.size(); ++i) {
            if (i >= resultTypes.size()) {
                LOG.warn(Messages.AbstractExprWithNmspc_log_cte_contains_cols, withName);
                break;
            }
            resultTypes.get(i).setFirst(paramNamesIdentifers.get(i).getText());
        }
        List<Pair<String, String>> unmodifiable = resultTypes.stream()
                .map(Pair::copy)
                .toList();
        return cte.put(withName, unmodifiable) != null;
    }

    public abstract List<ModPair<String, String>> analyze(T ruleCtx);
}
