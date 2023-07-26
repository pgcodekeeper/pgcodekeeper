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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.MS_WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Boolean_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Cast_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Column_operator_classContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Distributed_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Function_argsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Function_argumentsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Identifier_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Including_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Operator_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Predefined_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Target_operatorContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.User_mapping_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Identity_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MisplacedObjectException;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.MsColumn;
import ru.taximaxim.codekeeper.core.schema.MsType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgFunction;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.PgOperator;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract {

    protected static final String SCHEMA_ERROR = "Object must be schema qualified: ";
    protected static final String LOCATION_ERROR  = "The object {0} must be defined in the file: {1}";

    protected static final String ACTION_CREATE = "CREATE";
    protected static final String ACTION_ALTER = "ALTER";
    protected static final String ACTION_DROP = "DROP";
    protected static final String ACTION_UPDATE = "UPDATE";
    protected static final String ACTION_INSERT = "INSERT";
    protected static final String ACTION_DELETE = "DELETE";
    protected static final String ACTION_MERGE = "MERGE";
    protected static final String ACTION_COMMENT = "COMMENT";

    protected final PgDatabase db;

    private boolean refMode;
    protected String fileName;

    protected ParserAbstract(PgDatabase db) {
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

    public static String getTypeName(Data_typeContext datatype) {
        String full = getFullCtxText(datatype);
        Predefined_typeContext typeCtx = datatype.predefined_type();

        String type = getFullCtxText(typeCtx);
        if (type.startsWith("\"")) {
            return full;
        }

        String newType = convertAlias(type);
        if (!Objects.equals(type, newType)) {
            return full.replace(type, newType);
        }

        return full;
    }

    public static String getExpressionText(VexContext def, CommonTokenStream stream) {
        String expression = getFullCtxText(def);
        String whitespace = getHiddenLeftCtxText(def, stream);
        int newline = whitespace.indexOf('\n');
        return newline != -1 ? (whitespace.substring(newline) + expression) : expression;
    }

    private static String convertAlias(String type) {
        String alias = type.toLowerCase(Locale.ROOT);

        switch (alias) {
        case "int8": return "bigint";
        case "bool": return "boolean";
        case "float8": return "double precision";
        case "int":
        case "int4": return "integer";
        case "float4": return "real";
        case "int2": return "smallint";
        default: break;
        }

        if (PgDiffUtils.startsWithId(alias, "varbit", 0)) {
            return "bit varying" + type.substring("varbit".length());
        }

        if (PgDiffUtils.startsWithId(alias, "varchar", 0)) {
            return "character varying" + type.substring("varchar".length());
        }

        if (PgDiffUtils.startsWithId(alias, "char", 0)) {
            return "character" + type.substring("char".length());
        }

        if (PgDiffUtils.startsWithId(alias, "decimal", 0)) {
            return "numeric" + type.substring("decimal".length());
        }

        if (PgDiffUtils.startsWithId(alias, "timetz", 0)) {
            return "time" + type.substring("timetz".length()) + " with time zone";
        }

        if (PgDiffUtils.startsWithId(alias, "timestamptz", 0)) {
            return "timestamp" + type.substring("timestamptz".length()) + " with time zone";
        }

        return type;
    }

    public static String parseArguments(Function_argsContext argsContext) {
        return parseSignature(null, argsContext);
    }

    public static String parseSignature(String name, Function_argsContext argsContext) {
        AbstractPgFunction function = new PgFunction(name == null ? "noname" : name);
        fillFuncArgs(argsContext.function_arguments(), function);
        if (argsContext.agg_order() != null) {
            fillFuncArgs(argsContext.agg_order().function_arguments(), function);
        }
        String signature = function.getSignature();
        if (name == null) {
            signature = signature.substring("noname".length());
        }
        return signature;
    }

    private static void fillFuncArgs(List<Function_argumentsContext> argsCtx, AbstractPgFunction function) {
        for (Function_argumentsContext argument : argsCtx) {
            String type = getTypeName(argument.data_type());
            Identifier_nontypeContext name = argument.identifier_nontype();
            function.addArgument(new Argument(parseArgMode(argument.argmode()),
                    name != null ? name.getText() : null, type));
        }
    }

    public static String parseSignature(String name, Target_operatorContext targerOperCtx) {
        PgOperator oper = new PgOperator(name);
        oper.setLeftArg(targerOperCtx.left_type == null ? null
                : getTypeName(targerOperCtx.left_type));
        oper.setRightArg(targerOperCtx.right_type == null ? null
                : getTypeName(targerOperCtx.right_type));
        return oper.getSignature();
    }

    public static ArgMode parseArgMode(ParserRuleContext mode) {
        if (mode == null) {
            return ArgMode.IN;
        }

        return ArgMode.of(mode.getText());
    }

    public static Pair<String, Token> unquoteQuotedString(Character_stringContext ctx) {
        TerminalNode string = ctx.Character_String_Literal();
        if (string != null) {
            String text = string.getText();
            int start = text.indexOf('\'') + 1;

            Token t = string.getSymbol();
            CommonToken copy = new CommonToken(t);

            copy.setStartIndex(t.getStartIndex() + start);
            copy.setCharPositionInLine(t.getCharPositionInLine() + start);
            copy.setStopIndex(t.getStopIndex() - 1);

            return new Pair<>(PgDiffUtils.unquoteQuotedString(string.getText(), start), copy);
        }

        List<TerminalNode> dollarText = ctx.Text_between_Dollar();
        String s = dollarText.stream().map(TerminalNode::getText).collect(Collectors.joining());

        return new Pair<>(s, dollarText.get(0).getSymbol());
    }

    public static boolean parseBoolean(Boolean_valueContext boolCtx) {
        String bool = boolCtx.character_string() != null
                ? unquoteQuotedString(boolCtx.character_string()).getFirst() : boolCtx.getText();
        bool = bool.toLowerCase(Locale.ROOT);
        switch (bool) {
        case "1":
        case "true":
        case "on":
        case "yes":
            return true;
        case "0":
        case "false":
        case "off":
        case "no":
            return false;
        default:
            // TODO throw instead?
            return false;
        }
    }

    public static List<ParserRuleContext> getIdentifiers(Schema_qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(3);
        ids.add(qNameCtx.identifier());
        ids.addAll(qNameCtx.identifier_reserved());
        return ids;
    }

    public static List<ParserRuleContext> getIdentifiers(Schema_qualified_name_nontypeContext qNameNonTypeCtx) {
        List<ParserRuleContext> ids;
        Identifier_nontypeContext singleId = qNameNonTypeCtx.identifier_nontype();
        if (singleId != null) {
            ids = new ArrayList<>(1);
            ids.add(singleId);
        } else {
            ids = new ArrayList<>(2);
            ids.add(qNameNonTypeCtx.schema);
            ids.add(qNameNonTypeCtx.identifier_reserved_nontype());
        }
        return ids;
    }

    public static List<ParserRuleContext> getIdentifiers(Operator_nameContext operQNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(2);
        ids.add(operQNameCtx.schema_name);
        ids.add(operQNameCtx.operator);
        return ids;
    }

    public static List<ParserRuleContext> getIdentifiers(Qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(2);
        ParserRuleContext schemaRule = qNameCtx.schema;
        if (schemaRule != null) {
            ids.add(schemaRule);
        }
        ids.add(qNameCtx.name);
        return ids;
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

    protected void addSafe(PgStatement parent, PgStatement child,
            List<? extends ParserRuleContext> ids) {
        addSafe(parent, child, ids, null);
    }

    protected void addSafe(PgStatement parent, PgStatement child,
            List<? extends ParserRuleContext> ids, String signature){
        doSafe(PgStatement::addChild, parent, child);
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
                && isInProject(statement.isPostgres())) {
            throw new MisplacedObjectException(MessageFormat.format(LOCATION_ERROR,
                    statement.getBareName(), filePath), errToken);
        }
    }

    private boolean isInProject(boolean isPostgres) {
        // collect working directories
        List<String> dirs;
        if (isPostgres) {
            dirs = Arrays.stream(Consts.WORK_DIR_NAMES.values())
                    .map(WORK_DIR_NAMES::name).collect(Collectors.toList());
        } else {
            dirs = Arrays.stream(Consts.MS_WORK_DIR_NAMES.values())
                    .map(MS_WORK_DIR_NAMES::getDirName).collect(Collectors.toList());
        }

        Path parent = Paths.get(fileName).getParent();
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

    private PgObjLocation getLocation(List<? extends ParserRuleContext> ids,
            DbObjType type, String action, boolean isDep, String signature,
            LocationType locationType) {
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        switch (type) {
        case CAST:
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(getCastName((Cast_nameContext) nameCtx), DbObjType.CAST));
        case USER_MAPPING:
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(getUserMappingName((User_mapping_nameContext) nameCtx), DbObjType.USER_MAPPING));
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

    private PgObjLocation buildLocation(ParserRuleContext nameCtx, String action, LocationType locationType,
            GenericColumn object) {
        return new PgObjLocation.Builder()
                .setFilePath(fileName)
                .setCtx(nameCtx)
                .setObject(object)
                .setAction(action)
                .setLocationType(locationType)
                .build();
    }

    protected String getCastName(Cast_nameContext nameCtx) {
        return ICast.getSimpleName(getFullCtxText(nameCtx.source), getFullCtxText(nameCtx.target));
    }

    protected String getUserMappingName(User_mapping_nameContext nameCtx) {
        return (nameCtx.user_name() != null ? nameCtx.user_name().getText() : nameCtx.USER().getText())
                + " SERVER " + nameCtx.identifier().getText();
    }

    protected <T extends IStatement, U extends Object> void doSafe(BiConsumer<T, U> adder,
            T statement, U object) {
        if (!refMode) {
            adder.accept(statement, object);
        }
    }

    protected void addDepSafe(PgStatement st, List<? extends ParserRuleContext> ids,
            DbObjType type, boolean isPostgres) {
        addDepSafe(st, ids, type, isPostgres, null);
    }

    protected void addDepSafe(PgStatement st, List<? extends ParserRuleContext> ids,
            DbObjType type, boolean isPostgres, String signature) {
        PgObjLocation loc = getLocation(ids, type, null, true, signature, LocationType.REFERENCE);
        if (loc != null && !Utils.isSystemSchema(loc.getSchema(), isPostgres)) {
            if (!refMode) {
                st.addDep(loc.getObj());
            }
            db.addReference(fileName, loc);
        }
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

    /**
     * Fill owner
     *
     * @param owner
     *            parser context with owner
     * @param st
     *            object
     */
    protected void fillOwnerTo(IdentifierContext owner, PgStatement st) {
        if (owner == null || db.getArguments().isIgnorePrivileges() || refMode) {
            return;
        }
        st.setOwner(owner.getText());
    }

    protected void addPgTypeDepcy(Data_typeContext ctx, PgStatement st) {
        Schema_qualified_name_nontypeContext qname = ctx.predefined_type().schema_qualified_name_nontype();
        if (qname != null && qname.identifier() != null) {
            addDepSafe(st, getIdentifiers(qname), DbObjType.TYPE, true);
        }
    }

    protected void addMsTypeDepcy(ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Data_typeContext ctx,
            PgStatement st) {
        Qualified_nameContext qname = ctx.qualified_name();
        if (qname != null && qname.schema != null) {
            addDepSafe(st, Arrays.asList(qname.schema, qname.name), DbObjType.TYPE, false);
        }
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

    static void fillIncludingDepcy(Including_indexContext incl, PgStatement st,
            String schema, String table) {
        for (IdentifierContext inclCol : incl.identifier()) {
            st.addDep(new GenericColumn(schema, table, inclCol.getText(), DbObjType.COLUMN));
        }
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

    /**
     * Returns action information which will later be used for showing in console,
     * in 'Outline' and in 'outline of Project explorer files'.
     */
    protected abstract String getStmtAction();

    /**
     * Used in general cases in {@link #getStmtAction()} for get action information.
     */
    protected static String getStrForStmtAction(String action, DbObjType type, List<? extends ParserRuleContext> ids) {
        StringBuilder sb = new StringBuilder();
        for (ParserRuleContext id : ids) {
            if (id != null) {
                sb.append(id.getText()).append('.');
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return getStrForStmtAction(action, type, sb.toString());
    }

    protected static String getStrForStmtAction(String action, DbObjType type, ParseTree id) {
        return getStrForStmtAction(action, type, id.getText());
    }

    protected static String getStrForStmtAction(String action, DbObjType type, String id) {
        String objType;
        switch (type) {
        case FTS_CONFIGURATION:
            objType = "TEXT SEARCH CONFIGURATION";
            break;
        case FTS_DICTIONARY:
            objType = "TEXT SEARCH DICTIONARY";
            break;
        case FTS_TEMPLATE:
            objType = "TEXT SEARCH TEMPLATE";
            break;
        case FTS_PARSER:
            objType = "TEXT SEARCH PARSER";
            break;
        case FOREIGN_DATA_WRAPPER:
            objType = "FOREIGN DATA WRAPPER";
            break;
        case USER_MAPPING:
            objType = "USER MAPPING";
            break;
        default:
            objType = type.name();
            break;
        }
        return action + ' ' + objType + ' ' + id;
    }

    protected void fillMsColumnOption(Column_optionContext option, MsColumn col, MsType type) {
        if (option.SPARSE() != null) {
            col.setSparse(true);
        } else if (option.COLLATE() != null) {
            col.setCollation(getFullCtxText(option.collate));
        } else if (option.PERSISTED() != null) {
            col.setPersisted(true);
        } else if (option.ROWGUIDCOL() != null) {
            col.setRowGuidCol(true);
        } else if (option.IDENTITY() != null) {
            Identity_valueContext identity = option.identity_value();
            if (identity == null) {
                col.setIdentity("1", "1");
            } else {
                col.setIdentity(identity.seed.getText(), identity.increment.getText());
            }

            if (option.not_for_rep != null) {
                col.setNotForRep(true);
            }
        } else if (option.MASKED() != null) {
            col.setMaskingFunction(option.STRING().getText());
        } else if (option.NULL() != null) {
            col.setNullValue(option.NOT() == null);
        } else if (option.DEFAULT() != null) {
            if (option.id() != null) {
                col.setDefaultName(option.id().getText());
            }
            ExpressionContext exp = option.expression();
            col.setDefaultValue(getFullCtxText(exp));
            db.addAnalysisLauncher(new MsExpressionAnalysisLauncher(type != null ? type : col, exp, fileName));
        }
    }

    // for greenplum
    protected String parseDistribution(Distributed_clauseContext dist) {
        if (dist == null) {
            return null;
        }

        StringBuilder distribution = new StringBuilder();
        distribution.append("DISTRIBUTED ");
        if (dist.BY() != null) {
            distribution.append("BY (");
            for (Column_operator_classContext column_op_class : dist.column_operator_class()) {
                distribution.append(column_op_class.identifier().getText());
                Schema_qualified_nameContext opClassCtx = column_op_class.schema_qualified_name();
                if (opClassCtx != null) {
                    distribution.append(" ").append(opClassCtx.getText());
                }
                distribution.append(", ");
            }
            distribution.setLength(distribution.length() - 2);
            distribution.append(")");
        } else if (dist.RANDOMLY() != null) {
            distribution.append("RANDOMLY");
        } else {
            distribution.append("REPLICATED");
        }
        return distribution.toString();
    }
}
