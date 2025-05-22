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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.CodeUnitToken;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_args_parserContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Operator_args_parserContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_name_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.schema.meta.MetaCompositeType;
import ru.taximaxim.codekeeper.core.utils.ModPair;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class AbstractExpr {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractExpr.class);

    protected static final String NONAME = "?column?";

    // TODO get current postgresql version.
    // Need to get version. I already got it from JdbcLoader(READER)
    // and put it to the 'PgDatabase' as currentPostgreSqlVersion,
    // but I couldn't get it from PgDumpLoader(WRITER), that's why for
    // cases with 'PgDumpLoader(WRITER)' the version was hard-coded in 'PgDatabase'.
    protected final MetaContainer meta;
    private final AbstractExpr parent;
    private final Set<PgObjLocation> depcies;

    private FullAnalyze fullAnalyze;

    public Set<PgObjLocation> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    protected AbstractExpr(MetaContainer meta) {
        parent = null;
        depcies = new LinkedHashSet<>();
        this.meta = meta;
    }

    protected AbstractExpr(AbstractExpr parent) {
        this(parent, parent.depcies);
    }

    protected AbstractExpr(AbstractExpr parent, Set<PgObjLocation> depcies) {
        this.parent = parent;
        this.depcies = depcies;
        this.meta = parent.meta;
        this.fullAnalyze = parent.fullAnalyze;
    }

    public void setFullAnaLyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    protected List<Pair<String, String>> findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
    }

    protected boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    /**
     * @param schema optional schema qualification of name, may be null
     * @param name alias of the referenced object
     * @param column optional referenced column alias, may be null
     * @return a pair of (Alias, Dealiased name) where Alias is the given name.
     *          Dealiased name can be null if the name is internal to the query
     *          and is not a reference to external table.<br>
     *          null if the name is not found
     */
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        return parent == null ? null : parent.findReference(schema, name, column);
    }

    /**
     * @param name alias of the referenced object
     * @return a pair of (Alias, ColumnsList) where Alias is the given name.
     *          ColumnsList list of columns as pair 'columnName-columnType' of the internal query.<br>
     */
    protected List<Pair<String, String>> findReferenceComplex(String name) {
        return parent == null ? null : parent.findReferenceComplex(name);
    }

    protected Pair<IRelation, Pair<String, String>> findColumn(String name) {
        return parent == null ? null : parent.findColumn(name);
    }

    protected Pair<String, String> findColumnInComplex(String name) {
        return parent == null ? null : parent.findColumnInComplex(name);
    }

    protected GenericColumn addRelationDepcy(List<ParserRuleContext> ids) {
        return addDepcy(ids, DbObjType.TABLE, null);
    }

    protected GenericColumn addDepcy(List<ParserRuleContext> ids, DbObjType type, Token start) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();

        if (schemaCtx == null) {
            return new GenericColumn(Consts.PG_CATALOG, name, type);
        }
        String schemaName = schemaCtx.getText();
        GenericColumn depcy = new GenericColumn(schemaName, name, type);
        addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), schemaCtx, start);
        addDepcy(depcy, nameCtx, start);
        return depcy;
    }

    protected GenericColumn addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();
        if (typeName == null) {
            return new GenericColumn(Consts.PG_CATALOG, PgParserAbstract.getTypeName(type),
                    DbObjType.TYPE);
        }
        return addTypeDepcy(typeName);
    }

    protected GenericColumn addTypeDepcy(Schema_qualified_name_nontypeContext typeName) {
        return addDepcy(PgParserAbstract.getIdentifiers(typeName), DbObjType.TYPE, null);
    }

    protected void addDepcy(GenericColumn depcy, ParserRuleContext ctx) {
        addDepcy(depcy, ctx, null);
    }

    protected void addDepcy(GenericColumn depcy, ParserRuleContext ctx, Token start) {
        if (!Utils.isPgSystemSchema(depcy.schema)) {
            PgObjLocation loc = new PgObjLocation.Builder()
                    .setObject(depcy)
                    .setCtx(ctx)
                    .build();
            if (start instanceof CodeUnitToken codeUnitStart) {
                loc = loc.copyWithOffset(codeUnitStart.getCodeUnitStart(),
                        codeUnitStart.getLine() - 1, codeUnitStart.getCodeUnitPositionInLine(), null);
            }

            depcies.add(loc);
        }
    }

    protected void addAliasReference(GenericColumn depcy, ParserRuleContext ctx) {
        depcies.add(new PgObjLocation.Builder()
                .setObject(depcy)
                .setCtx(ctx)
                .setLocationType(LocationType.LOCAL_REF)
                .setAlias(ctx.getText())
                .build());
    }

    protected void addVariable(GenericColumn depcy, ParserRuleContext ctx) {
        depcies.add(new PgObjLocation.Builder()
                .setObject(depcy)
                .setCtx(ctx)
                .setLocationType(LocationType.VARIABLE)
                .setAlias(ctx.getText())
                .build());
    }

    protected void addDepcy(PgObjLocation loc) {
        if (!Utils.isPgSystemSchema(loc.getSchema())) {
            depcies.add(loc);
        }
    }

    /**
     * @return column with its type
     */
    protected ModPair<String, String> processColumn(List<? extends ParserRuleContext> ids) {
        if (ids.size() == 1) {
            return processTablelessColumn(ids.get(0));
        }

        String columnName = QNameParser.getFirstName(ids);
        ParserRuleContext columnParentCtx = QNameParser.getSecondNameCtx(ids);
        String columnParent = columnParentCtx.getText();
        ParserRuleContext schemaNameCtx = QNameParser.getThirdNameCtx(ids);
        String schemaName = schemaNameCtx == null ? null : schemaNameCtx.getText();

        String columnType = TypesSetManually.COLUMN;
        Entry<String, GenericColumn> ref = findReference(schemaName, columnParent, columnName);
        List<Pair<String, String>> refComplex;
        if (ref != null) {
            GenericColumn referencedTable = ref.getValue();
            if (referencedTable != null) {
                if (schemaNameCtx != null) {
                    addDepcy(new GenericColumn(referencedTable.schema, DbObjType.SCHEMA), schemaNameCtx);
                }

                if (referencedTable.getObjName().equals(columnParent)) {
                    addDepcy(referencedTable, columnParentCtx);
                } else {
                    addAliasReference(referencedTable, columnParentCtx);
                }

                columnType = addFilteredColumnDepcy(
                        referencedTable.schema, referencedTable.table, columnName);
            } else if ((refComplex = findReferenceComplex(columnParent)) != null) {
                columnType = refComplex.stream()
                        .filter(entry -> columnName.equals(entry.getFirst()))
                        .map(Pair::getSecond)
                        .findAny()
                        .orElseGet(() -> {
                            log("Column {} not found in complex {}", columnName, columnParent);
                            return TypesSetManually.COLUMN;
                        });
            } else {
                log("Complex not found: {}", columnParent);
            }
        } else {
            log("Unknown column reference: {} {} {}", schemaName, columnParent, columnName);
        }

        return new ModPair<>(columnName, columnType);
    }

    /**
     * Add a dependency only from the column of the user object. Always return its type.
     *
     * @param schemaName
     *            object schema
     * @param relationName
     *            user or system object which contains column 'colName'
     * @param colName
     *            dependency from this column will be added
     * @return column type
     */
    protected String addFilteredColumnDepcy(String schemaName, String relationName, String colName) {
        Stream<Pair<String, String>> columns = addFilteredRelationColumnsDepcies(
                schemaName, relationName, col -> col.equals(colName));
        // handle system columns; look for relation anyway for a potential 'not found' warning
        // do not use the stream nor add the depcy though
        switch (colName) {
        case "oid", "tableoid":
            return "oid";
        case "xmin", "xmax":
            return "xid";
        case "cmin", "cmax":
            return "cid";
        case "ctid":
            return "tid";
        default:
            break;
        }

        return columns.findAny().map(Pair::getSecond).orElseGet(() -> {
            log("Column {} not found in relation {}", colName, relationName);
            return TypesSetManually.COLUMN;
        });
    }

    /**
     * Terminal operation must be called on the returned stream for depcy addition to take effect! <br>
     * <br>
     * Returns a stream of relation columns filtered with the given predicate. When this stream is terminated, and if
     * the relation is a user relation, side-effect depcy-addition is performed for all columns satisfying the
     * predicate. <br>
     * If a short-circuiting operation is used to terminate the stream then only some column depcies will be added. <br>
     * <br>
     * This ugly solution was chosen because all others lead to any of the following:<br>
     * <ul>
     * <li>code duplicaton</li>
     * <li>depcy addition/relation search logic leaking into other classes</li>
     * <li>inefficient filtering on the hot path (predicate matching a single column)</li>
     * <li>and/or other performance/allocation inefficiencies</li>
     * </ul>
     *
     * @param schemaName
     * @param relationName
     * @param colNamePredicate
     *
     * @return column stream with attached depcy-addition peek-step; empty stream if no relation found
     */
    protected Stream<Pair<String, String>> addFilteredRelationColumnsDepcies(String schemaName,
            String relationName, Predicate<String> colNamePredicate) {
        IRelation relation = findRelation(schemaName, relationName);
        if (relation == null) {
            log("Relation not found: {}.{}", schemaName, relationName);
            return Stream.empty();
        }

        Stream<Pair<String, String>> columns = relation.getRelationColumns();
        if (DbObjType.VIEW == relation.getStatementType() && columns == null) {
            analyzeViewColumns(relation);
            columns = relation.getRelationColumns();

            if (columns == null) {
                return Stream.empty();
            }
        }

        Stream<Pair<String, String>> cols = columns
                .filter(col -> colNamePredicate.test(col.getFirst()));

        String relSchemaName = relation.getSchemaName();
        if (Utils.isPgSystemSchema(relSchemaName)) {
            return cols;
        }

        // hack
        return cols.peek(col -> addDepcy(new GenericColumn(relSchemaName,
                relation.getName(), col.getFirst(), DbObjType.COLUMN), null));
    }

    protected void analyzeViewColumns(IRelation rel) {
        if (fullAnalyze != null) {
            fullAnalyze.analyzeView(rel);
        }
    }

    protected ModPair<String, String> processTablelessColumn(ParserRuleContext id) {
        String name = id.getText();
        Pair<String, String> col = findColumnInComplex(name);
        if (col == null) {
            Pair<IRelation, Pair<String, String>> relCol = findColumn(name);
            if (relCol == null) {
                log("Tableless column not resolved: {}", name);
                return new ModPair<>(name, TypesSetManually.COLUMN);
            }
            IRelation rel = relCol.getFirst();
            col = relCol.getSecond();
            addDepcy(new GenericColumn(rel.getSchemaName(), rel.getName(),
                    col.getFirst(), DbObjType.COLUMN), id);
        }
        return col.copyMod();
    }

    protected void addColumnsDepcies(Schema_qualified_nameContext table,
            List<Indirection_identifierContext> columns) {
        List<ParserRuleContext> ids = PgParserAbstract.getIdentifiers(table);
        String schemaName = QNameParser.getSchemaName(ids);
        String tableName = QNameParser.getFirstName(ids);
        for (Indirection_identifierContext col : columns) {
            // only column name
            addFilteredColumnDepcy(schemaName, tableName, col.identifier().getText());
        }
    }

    protected void addFunctionDepcy(IFunction function, ParserRuleContext ctx) {
        addDepcy(new GenericColumn(function.getSchemaName(), function.getName(),
                function.getStatementType()), ctx);
    }

    /**
     * Use only in contexts where function can be pinpointed only by its name.
     * Such as ::regproc casts.
     */

    protected void addFunctionDepcyNotOverloaded(List<ParserRuleContext> ids, Token start, DbObjType type) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx == null) {
            return;
        }

        String schemaName = schemaCtx.getText();
        if (Utils.isPgSystemSchema(schemaName)) {
            return;
        }
        addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), schemaCtx, start);

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();

        Collection<? extends IStatement> availableStatements =
                type == DbObjType.OPERATOR ? availableOperators(schemaName) : availableFunctions(schemaName);

        for (IStatement statement : availableStatements) {
            if (statement.getBareName().equals(name)) {
                addDepcy(new GenericColumn(schemaName, statement.getName(), type), nameCtx, start);
                break;
            }
        }
    }

    protected void addFunctionSigDepcy(String signature, Token start, DbObjType type) {
        var parser = AntlrParser.createSQLParser(signature, "signature parser", null, start);

        List<ParserRuleContext> ids;
        UnaryOperator<String> fullNameOperator;
        if (type == DbObjType.OPERATOR) {
            Operator_args_parserContext sig = parser.operator_args_parser();
            ids = PgParserAbstract.getIdentifiers(sig.operator_name());
            fullNameOperator = name -> PgParserAbstract.parseOperatorSignature(name, sig.operator_args());
        } else {
            Function_args_parserContext sig = parser.function_args_parser();
            ids = PgParserAbstract.getIdentifiers(sig.schema_qualified_name());
            fullNameOperator = name -> PgParserAbstract.parseSignature(name, sig.function_args());
        }

        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx == null) {
            return;
        }

        String schemaName = schemaCtx.getText();
        if (Utils.isPgSystemSchema(schemaName)) {
            return;
        }
        addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), schemaCtx, start);

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();
        String fullName = fullNameOperator.apply(name);
        addDepcy(new GenericColumn(schemaName, fullName, type), nameCtx, start);
    }

    protected void addSchemaDepcy(List<ParserRuleContext> ids, Token start) {
        ParserRuleContext ctx = QNameParser.getFirstNameCtx(ids);
        addDepcy(new GenericColumn(ctx.getText(), DbObjType.SCHEMA), ctx, start);
    }

    protected Collection<IFunction> availableFunctions(String schemaName) {
        return meta.availableFunctions(getSchemaName(schemaName));
    }

    protected Collection<IOperator> availableOperators(String schemaName) {
        return meta.availableOperators(getSchemaName(schemaName));
    }

    protected IRelation findRelation(String schemaName, String relationName) {
        return meta.findRelation(getSchemaName(schemaName), relationName);
    }

    protected MetaCompositeType findType(String schemaName, String typeName) {
        return meta.findType(getSchemaName(schemaName), typeName);
    }

    private String getSchemaName(String schemaName) {
        return schemaName == null ? Consts.PG_CATALOG : schemaName;
    }

    protected void log(String msg, Object... args) {
        LOG.trace(msg, args);
    }
}
