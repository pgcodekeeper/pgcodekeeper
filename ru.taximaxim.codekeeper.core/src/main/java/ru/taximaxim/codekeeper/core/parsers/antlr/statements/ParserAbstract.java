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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MisplacedObjectException;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.IStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract<S extends AbstractDatabase> {

    private static final String SCHEMA_ERROR = "Object must be schema qualified: ";
    private static final String LOCATION_ERROR  = "The object {0} must be defined in the file: {1}";

    protected static final String ACTION_CREATE = "CREATE";
    protected static final String ACTION_ALTER = "ALTER";
    protected static final String ACTION_DROP = "DROP";
    protected static final String ACTION_UPDATE = "UPDATE";
    protected static final String ACTION_INSERT = "INSERT";
    protected static final String ACTION_DELETE = "DELETE";
    protected static final String ACTION_MERGE = "MERGE";
    protected static final String ACTION_COMMENT = "COMMENT";

    protected final S db;

    private boolean refMode;
    protected String fileName;

    protected ParserAbstract(S db) {
        this.db = db;
    }

    public void parseObject(String fileName, ParserListenerMode mode, ParserRuleContext ctx) {
        this.fileName = fileName;
        refMode = ParserListenerMode.REF == mode;
        if (ParserListenerMode.SCRIPT == mode) {
            fillQueryLocation(ctx);
        } else {
            parseObject();
        }
    }

    protected boolean isRefMode() {
        return refMode;
    }

    /**
     * Parse object from context
     */
    public abstract void parseObject();

    /**
     * Extracts raw text from context
     *
     * @param ctx
     *            context
     * @return raw string
     */
    public static String getFullCtxText(ParserRuleContext ctx) {
        return getFullCtxText(ctx, ctx);
    }

    /**
     * Extracts raw text from list of IdentifierContext
     *
     * @param ids list of IdentifierContext
     *            context
     * @return raw string
     */
    public static String getFullCtxText(List<? extends ParserRuleContext> ids) {
        return getFullCtxText(ids.get(0), ids.get(ids.size() - 1));
    }

    public static String getFullCtxText(ParserRuleContext start, ParserRuleContext end) {
        return getFullCtxText(start.getStart(), end.getStop());
    }

    public static String getFullCtxText(Token start, Token end) {
        if (start.getStartIndex() > end.getStopIndex()) {
            // broken ctx
            return "";
        }
        return start.getInputStream().getText(
                Interval.of(start.getStartIndex(), end.getStopIndex()));
    }

    public static String getHiddenLeftCtxText(ParserRuleContext ctx, CommonTokenStream stream) {
        List<Token> startTokens = stream.getHiddenTokensToLeft(ctx.getStart().getTokenIndex());
        if (startTokens != null) {
            return ctx.getStart().getInputStream().getText(Interval.of(
                    startTokens.get(0).getStartIndex(),
                    ctx.getStart().getStartIndex() - 1));
        }

        return "";
    }

    public static String getFullCtxTextWithHidden(ParserRuleContext ctx, CommonTokenStream stream) {
        List<Token> startTokens = stream.getHiddenTokensToLeft(ctx.getStart().getTokenIndex());
        List<Token> stopTokens = stream.getHiddenTokensToRight(ctx.getStop().getTokenIndex());
        Token start = startTokens != null ? startTokens.get(0) : ctx.getStart();
        Token stop = stopTokens != null ? stopTokens.get(stopTokens.size() - 1) : ctx.getStop();
        return getFullCtxText(start, stop);
    }

    public static String getExpressionText(ParserRuleContext def, CommonTokenStream stream) {
        String expression = getFullCtxText(def);
        String whitespace = getHiddenLeftCtxText(def, stream);
        int newline = whitespace.indexOf('\n');
        return newline != -1 ? (whitespace.substring(newline) + expression) : expression;
    }

    public static ArgMode parseArgMode(ParserRuleContext mode) {
        if (mode == null) {
            return ArgMode.IN;
        }

        return ArgMode.of(mode.getText());
    }

    protected PgObjLocation addObjReference(List<? extends ParserRuleContext> ids,
            DbObjType type, String action, String signature) {
        PgObjLocation loc = getLocation(ids, type, action, false, signature, LocationType.REFERENCE);
        if (loc != null) {
            db.addReference(fileName, loc);
        }

        return loc;
    }

    protected PgObjLocation addObjReference(List<? extends ParserRuleContext> ids,
            DbObjType type, String action) {
        return addObjReference(ids, type, action, null);
    }

    public <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, ParserRuleContext ctx) {
        return getSafe(getter, container, ctx.getText(), ctx.start);
    }

    public <T extends IStatement, R extends IStatement> R getSafe(BiFunction<T, String, R> getter,
            T container, String name, Token errToken) {
        if (isRefMode()) {
            return null;
        }
        R statement = getter.apply(container, name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + name, errToken);
        }

        checkLocation((PgStatement) statement, errToken);

        return statement;
    }

    protected void addSafe(IStatementContainer parent, PgStatement child,
            List<? extends ParserRuleContext> ids) {
        addSafe(parent, child, ids, null);
    }

    protected void addSafe(IStatementContainer parent, PgStatement child,
            List<? extends ParserRuleContext> ids, String signature){
        doSafe(IStatementContainer::addChild, parent, child);
        PgObjLocation loc = getLocation(ids, child.getStatementType(),
                ACTION_CREATE, false, signature, LocationType.DEFINITION);
        if (loc != null) {
            child.setLocation(loc);
            db.addReference(fileName, loc);
        }

        // TODO move to beginning of the method later
        checkLocation(child, QNameParser.getFirstNameCtx(ids).getStart());
    }

    private void checkLocation(PgStatement statement, Token errToken) {
        if (isRefMode() || fileName == null) {
            return;
        }

        String filePath = AbstractModelExporter.getRelativeFilePath(statement).toString();
        if (!PgDiffUtils.endsWithIgnoreCase(fileName, filePath)
                && isInProject(statement.getDbType())) {
            throw new MisplacedObjectException(MessageFormat.format(LOCATION_ERROR,
                    statement.getBareName(), filePath), errToken);
        }
    }

    private boolean isInProject(DatabaseType dbType) {
        List<String> dirs = WorkDirs.getDirectoryNames(dbType);
        Path parent = Paths.get(fileName).toAbsolutePath().getParent();
        while (true) {
            Path folder = parent.getFileName();
            parent = parent.getParent();

            // file name for root is null
            if (folder == null || parent == null) {
                return false;
            }

            // if we find the project directory, then we check the marker at the level above
            if (dirs.contains(folder.toString())
                    && Files.exists(parent.resolve(Consts.FILENAME_WORKING_DIR_MARKER))) {
                return true;
            }
        }
    }

    protected PgObjLocation getLocation(List<? extends ParserRuleContext> ids,
            DbObjType type, String action, boolean isDep, String signature,
            LocationType locationType) {
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        switch (type) {
        case CAST:
        case USER_MAPPING:
            throw new IllegalStateException();
        case ASSEMBLY:
        case EXTENSION:
        case EVENT_TRIGGER:
        case FOREIGN_DATA_WRAPPER:
        case SERVER:
        case SCHEMA:
        case ROLE:
        case USER:
        case DATABASE:
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(nameCtx.getText(), type));
        default:
            break;
        }

        if (db instanceof ChDatabase && type == DbObjType.FUNCTION) {
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(nameCtx.getText(), type));
        }

        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        String schemaName;
        if (schemaCtx != null) {
            addObjReference(Arrays.asList(schemaCtx), DbObjType.SCHEMA, null);
            schemaName = schemaCtx.getText();
        } else if (refMode && !isDep) {
            schemaName = null;
        } else if (refMode || isDep) {
            return null;
        } else {
            throw new UnresolvedReferenceException(SCHEMA_ERROR + getFullCtxText(nameCtx),
                    nameCtx.getStart());
        }

        String name = nameCtx.getText();
        if (signature != null) {
            name = PgDiffUtils.getQuotedName(name) + signature;
        }
        switch (type) {
        case DOMAIN:
        case FTS_CONFIGURATION:
        case FTS_DICTIONARY:
        case FTS_PARSER:
        case FTS_TEMPLATE:
        case OPERATOR:
        case SEQUENCE:
        case TABLE:
        case TYPE:
        case VIEW:
        case INDEX:
        case COLLATION:
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(schemaName, name, type));
        case CONSTRAINT:
        case TRIGGER:
        case RULE:
        case POLICY:
        case COLUMN:
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(schemaName, QNameParser.getSecondName(ids), name, type));
        default:
            return null;
        }
    }

    protected PgObjLocation buildLocation(ParserRuleContext nameCtx, String action, LocationType locationType,
            GenericColumn object) {
        return new PgObjLocation.Builder()
                .setFilePath(fileName)
                .setCtx(nameCtx)
                .setObject(object)
                .setAction(action)
                .setLocationType(locationType)
                .build();
    }

    protected <T extends IStatement, U extends Object> void doSafe(BiConsumer<T, U> adder,
            T statement, U object) {
        if (!refMode) {
            adder.accept(statement, object);
        }
    }

    protected void addDepSafe(PgStatement st, List<? extends ParserRuleContext> ids, DbObjType type) {
        addDepSafe(st, ids, type, null);
    }

    protected void addDepSafe(PgStatement st, List<? extends ParserRuleContext> ids, DbObjType type, String signature) {
        PgObjLocation loc = getLocation(ids, type, null, true, signature, LocationType.REFERENCE);
        if (loc != null && !Utils.isSystemSchema(loc.getSchema(), getDbType())) {
            if (!refMode) {
                st.addDep(loc.getObj());
            }
            db.addReference(fileName, loc);
        }
    }

    protected final DatabaseType getDbType() {
        return db.getDbType();
    }

    protected AbstractSchema getSchemaSafe(List<? extends ParserRuleContext> ids) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);

        if (schemaCtx == null) {
            if (refMode) {
                return null;
            }
            throw new UnresolvedReferenceException(SCHEMA_ERROR + QNameParser.getFirstName(ids),
                    QNameParser.getFirstNameCtx(ids).start);
        }

        AbstractSchema schema = db.getSchema(schemaCtx.getText());

        if (schema != null || refMode) {
            return schema;
        }

        ParserRuleContext firstNameCtx = QNameParser.getFirstNameCtx(ids);
        throw new UnresolvedReferenceException("Schema not found for " +
                getFullCtxText(ids), firstNameCtx.start);
    }

    protected String getSchemaNameSafe(List<? extends ParserRuleContext> ids) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx != null) {
            return schemaCtx.getText();
        }
        if (refMode) {
            return null;
        }

        throw new UnresolvedReferenceException(SCHEMA_ERROR + QNameParser.getFirstName(ids),
                QNameParser.getFirstNameCtx(ids).start);
    }

    public static void fillOptionParams(String[] options, BiConsumer <String, String> c,
            boolean isToast, boolean forceQuote, boolean isQuoted) {
        for (String pair : options) {
            int sep = pair.indexOf('=');
            String option;
            String value;
            if (sep == -1) {
                option = pair;
                value = "";
            } else {
                option = pair.substring(0, sep);
                value = pair.substring(sep + 1);
            }
            if (!isQuoted && (forceQuote || !PgDiffUtils.isValidId(value, false, false))) {
                // only quote non-ids, do not quote columns
                // pg_dump behavior
                value = PgDiffUtils.quoteString(value);
            }
            fillOptionParams(value, option, isToast, c);
        }
    }

    public static void fillOptionParams(String value, String option, boolean isToast,
            BiConsumer<String, String> c) {
        String quotedOption = PgDiffUtils.getQuotedName(option);
        if (isToast) {
            quotedOption = "toast." + quotedOption;
        }
        c.accept(quotedOption, value);
    }

    /**
     * Fills the 'PgObjLocation'-object with action information, query of statement
     * and it's position in the script from statement context, and then puts
     * filled 'PgObjLocation'-object to the storage of queries.
     */
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        String act = getStmtAction();
        PgObjLocation loc = new PgObjLocation.Builder()
                .setAction(act != null ? act : ctx.getStart().getText().toUpperCase(Locale.ROOT))
                .setSql(getFullCtxText(ctx))
                .setCtx(ctx)
                .build();

        db.addReference(fileName, loc);
        return loc;
    }

    /**
     * Adds missing COMMENT/RULE refs for correct showing them in Outline.
     * (In the case of COMMENT : used for COLUMN comments and comments
     * for objects which undefined in DbObjType).
     */
    protected void addOutlineRefForCommentOrRule(String action, ParserRuleContext ctx) {
        PgObjLocation loc = new PgObjLocation.Builder()
                .setAction(action)
                .setCtx(ctx)
                .build();
        db.addReference(fileName, loc);
    }

    protected static String getStrForStmtAction(String action, DbObjType type, ParseTree id) {
        return getStrForStmtAction(action, type, List.of(id));
    }

    /**
     * Used in general cases in {@link #getStmtAction()} for get action information.
     */
    protected static String getStrForStmtAction(String action, DbObjType type, List<? extends ParseTree> ids) {
        StringBuilder sb = new StringBuilder();
        sb.append(action).append(' ').append(type.getTypeName()).append(' ');
        sb.append(ids.stream().map(ParseTree::getText).collect(Collectors.joining(".")));
        return sb.toString();
    }

    /**
     * Returns action information which will later be used for showing in console,
     * in 'Outline' and in 'outline of Project explorer files'.
     */
    protected abstract String getStmtAction();
}
