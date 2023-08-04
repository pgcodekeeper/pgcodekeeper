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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.ErrorTypes;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MisplacedObjectException;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.AbstractExprWithNmspc;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.ValueExprWithNmspc;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsAbstractExprWithNmspc;
import ru.taximaxim.codekeeper.core.parsers.antlr.msexpr.MsValueExpr;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

/**
 * This class and all child classes contains statement, its contexts and
 * implementation of logic for launch the analysis of statement's contexts.
 */
public abstract class AbstractAnalysisLauncher {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractAnalysisLauncher.class);

    private final List<PgObjLocation> references = new ArrayList<>();

    protected PgStatementWithSearchPath stmt;
    protected final ParserRuleContext ctx;
    private final String location;

    private int offset;
    private int lineOffset;
    private int inLineOffset;

    protected AbstractAnalysisLauncher(PgStatementWithSearchPath stmt,
            ParserRuleContext ctx, String location) {
        this.stmt = stmt;
        this.ctx = ctx;
        this.location = location;
    }

    public PgStatementWithSearchPath getStmt() {
        return stmt;
    }

    public List<PgObjLocation> getReferences() {
        return Collections.unmodifiableList(references);
    }

    public void setOffset(Token codeStart) {
        offset = codeStart.getStartIndex();
        lineOffset = codeStart.getLine() - 1;
        inLineOffset = codeStart.getCharPositionInLine();
    }

    /**
     * Updates the saved statement to the twin found in the given db
     *
     * @param db
     *            database
     */
    public void updateStmt(PgDatabase db) {
        if (stmt.getDatabase() != db) {
            // statement came from another DB object, probably a library
            // for proper depcy processing, find its twin in the final DB object

            // twin implies the exact same object type, hence this is safe
            stmt = (PgStatementWithSearchPath) stmt.getTwin(db);
        }
    }

    public Set<GenericColumn> launchAnalyze(List<Object> errors, MetaContainer meta) {
        // Duplicated objects don't have parent, skip them
        if (stmt.getParent() == null) {
            return Collections.emptySet();
        }

        try {
            Set<PgObjLocation> locs = analyze(ctx, meta);
            Set<GenericColumn> depcies = new LinkedHashSet<>();
            EnumSet<DbObjType> disabledDepcies = getDisabledDepcies();
            for (PgObjLocation loc : locs) {
                if (!disabledDepcies.contains(loc.getType())) {
                    depcies.add(loc.getObj());
                }

                if (loc.getLineNumber() != 0) {
                    references.add(loc.copyWithOffset(offset, lineOffset, inLineOffset, location));
                }
            }
            return depcies;
        } catch (UnresolvedReferenceException ex) {
            Token t = ex.getErrorToken();
            if (t != null) {
                ErrorTypes errorType = ex instanceof MisplacedObjectException ? ErrorTypes.MISPLACEERROR : ErrorTypes.OTHER;
                AntlrError err = new AntlrError(t, location, t.getLine(),
                        t.getCharPositionInLine(), ex.getMessage(), errorType)
                        .copyWithOffset(offset, lineOffset, inLineOffset);
                LOG.warn(err.toString(), ex);
                errors.add(err);
            } else {
                LOG.warn(ex.toString(), ex);
                errors.add(location + ' ' + ex.getLocalizedMessage());
            }
        } catch (Exception ex) {
            LOG.error(ex.toString(), ex);
            errors.add(location + ' ' + ex);
        }

        return Collections.emptySet();
    }

    protected EnumSet<DbObjType> getDisabledDepcies() {
        return EnumSet.noneOf(DbObjType.class);
    }

    protected abstract Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta);

    protected <T extends ParserRuleContext> Set<PgObjLocation> analyze(
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    protected <T extends ParserRuleContext> Set<PgObjLocation> analyze(
            T ctx, MsAbstractExprWithNmspc<T> analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    protected Set<PgObjLocation> analyze(ExpressionContext ctx, MsValueExpr analyzer) {
        analyzer.analyze(ctx);
        return analyzer.getDepcies();
    }

    /**
     * Sets up namespace for Constraint/Index expr analysis
     *
     * @param ctx
     *            expression context to analyze
     * @param meta
     *            database metadata
     *
     * @return dependencies from child expression
     */
    protected Set<PgObjLocation> analyzeTableChildVex(VexContext ctx, MetaContainer meta) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String rawTableReference = table.getName();

        ValueExprWithNmspc valExptWithNmspc = new ValueExprWithNmspc(meta);
        valExptWithNmspc.addRawTableReference(
                new GenericColumn(schemaName, rawTableReference, DbObjType.TABLE));
        return analyze(ctx, valExptWithNmspc);
    }

    /**
     * Sets up namespace for Trigger/Rule expr/command analysis
     *
     * @param <T>
     *            analyzer type
     * @param ctx
     *            expression context to analyze
     * @param analyzer
     *            analyzer with database metadata
     *
     * @return dependencies from trigger/rule expression
     */
    protected <T extends ParserRuleContext> Set<PgObjLocation> analyzeTableChild (
            T ctx, AbstractExprWithNmspc<T> analyzer) {
        PgStatement table = stmt.getParent();
        String schemaName = table.getParent().getName();
        String tableName = table.getName();
        GenericColumn implicitTable = new GenericColumn(schemaName, tableName, DbObjType.TABLE);
        analyzer.addReference("new", implicitTable);
        analyzer.addReference("old", implicitTable);
        return analyze(ctx, analyzer);
    }
}
