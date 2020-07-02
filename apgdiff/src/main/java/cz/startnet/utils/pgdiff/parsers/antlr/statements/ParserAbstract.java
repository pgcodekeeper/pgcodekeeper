package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Id_tokenContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identifier_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.ArgMode;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
    protected static final String ACTION_COMMENT = "COMMENT";

    protected final PgDatabase db;

    private boolean refMode;
    protected String fileName;

    public ParserAbstract(PgDatabase db) {
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

    public static String parseSignature(String name, Function_argsContext argsContext) {
        AbstractPgFunction function = new PgFunction(name);
        fillFuncArgs(argsContext.function_arguments(), function);
        if (argsContext.agg_order() != null) {
            fillFuncArgs(argsContext.agg_order().function_arguments(), function);
        }
        return function.getSignature();
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

    protected PgObjLocation addObjReference(List<? extends ParserRuleContext> ids,
            DbObjType type, String action) {
        PgObjLocation loc = getLocation(ids, type, action, false, null);
        if (loc != null) {
            db.addReference(fileName, loc);
        }

        return loc;
    }

    private int getStart(ParserRuleContext ctx) {
        int start = ctx.start.getStartIndex();
        if (ctx instanceof IdentifierContext) {
            Id_tokenContext id = ((IdentifierContext) ctx).id_token();
            if (id != null && id.QuotedIdentifier() != null) {
                start++;
            }
        } else if (ctx instanceof IdContext && ((IdContext) ctx).SQUARE_BRACKET_ID() != null) {
            start++;
        }
        return start;
    }

    public <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, ParserRuleContext ctx) {
        return getSafe(getter, container, ctx.getText(), ctx.start);
    }

    public static <T extends IStatement, R extends IStatement> R getSafe(BiFunction<T, String, R> getter,
            T container, ParserRuleContext ctx, boolean refMode) {
        return getSafe(getter, container, ctx.getText(), ctx.getStart(), refMode);
    }

    public static <T extends IStatement, R extends IStatement> R getSafe(BiFunction<T, String, R> getter,
            T container, String name, Token errToken, boolean refMode) {
        if (refMode) {
            return null;
        }
        R statement = getter.apply(container, name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + name, errToken);
        }
        return statement;
    }

    public <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, String name, Token errToken) {
        return getSafe(getter, container, name, errToken, refMode);
    }

    protected void addSafe(PgStatement parent, PgStatement child,
            List<? extends ParserRuleContext> ids) {
        doSafe(PgStatement::addChild, parent, child);
        PgObjLocation loc = getLocation(ids, child.getStatementType(),
                ACTION_CREATE, false, null);
        if (loc != null) {
            child.setLocation(loc);
            db.addReference(fileName, loc);
        }

        // TODO move to beginning of the method later
        // TODO add to alter statements
        checkLocation(child, QNameParser.getFirstNameCtx(ids).getStart());
    }

    private void checkLocation(PgStatement statement, Token errToken) {
        if (isRefMode()) {
            return;
        }

        String filePath = ModelExporter.getRelativeFilePath(statement).toString();
        if (!fileName.endsWith(filePath) && isInProject(statement.isPostgres())) {
            throw new UnresolvedReferenceException(
                    MessageFormat.format(LOCATION_ERROR, statement.getBareName(), filePath),
                    errToken);
        }
    }

    private boolean isInProject(boolean isPostgres) {
        // exclude external directories
        Stream<String> dirs;
        if (isPostgres) {
            dirs = Arrays.stream(ApgdiffConsts.WORK_DIR_NAMES.values())
                    .map(e -> '/' + e.name() + '/');
        } else {
            dirs = Arrays.stream(ApgdiffConsts.MS_WORK_DIR_NAMES.values())
                    .map(e -> '/' + e.getDirName() + '/');
        }

        if (dirs.noneMatch(fileName::contains)) {
            return false;
        }

        // search project marker
        Path parent = Paths.get(fileName).getParent();
        while (parent != null) {
            if (Files.exists(parent.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                return true;
            }

            parent = parent.getParent();
        }

        return false;
    }

    private PgObjLocation getLocation(List<? extends ParserRuleContext> ids,
            DbObjType type, String action, boolean isDep, String signature) {
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        switch (type) {
        case CAST:
            throw new IllegalStateException("Unsupported type: CAST");
        case ASSEMBLY:
        case EXTENSION:
        case SCHEMA:
        case ROLE:
        case USER:
        case DATABASE:
            return new PgObjLocation(new GenericColumn(nameCtx.getText(), type),
                    action, getStart(nameCtx), nameCtx.start.getLine(), fileName);
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
            name+= signature;
        }
        switch (type) {
        case DOMAIN:
        case FTS_CONFIGURATION:
        case FTS_DICTIONARY:
        case FTS_PARSER:
        case FTS_TEMPLATE:
        case FUNCTION:
        case OPERATOR:
        case PROCEDURE:
        case AGGREGATE:
        case SEQUENCE:
        case TABLE:
        case TYPE:
        case VIEW:
        case INDEX:
            return new PgObjLocation(new GenericColumn(schemaName, name, type),
                    action, getStart(nameCtx), nameCtx.start.getLine(), fileName);
        case CONSTRAINT:
        case TRIGGER:
        case RULE:
        case POLICY:
        case COLUMN:
            return new PgObjLocation(new GenericColumn(schemaName,
                    QNameParser.getSecondName(ids), name, type), action,
                    getStart(nameCtx), nameCtx.start.getLine(), fileName);
        default:
            return null;
        }
    }

    protected PgObjLocation getCastLocation(Data_typeContext source, Data_typeContext target, String action) {
        PgObjLocation loc = new PgObjLocation(new GenericColumn(
                ICast.getSimpleName(getFullCtxText(source), getFullCtxText(target)), DbObjType.CAST),
                action, source.start.getStartIndex(), source.start.getLine(), fileName);
        loc.setLength(target.stop.getStopIndex() - source.start.getStartIndex() + 1);
        return loc;
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
        PgObjLocation loc = getLocation(ids, type, null, true, signature);
        if (loc != null && !ApgdiffUtils.isSystemSchema(loc.getSchema(), isPostgres)) {
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

        AbstractSchema schema = getSafe(PgDatabase::getSchema, db, schemaCtx);

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
        } else if (refMode) {
            return null;
        }

        throw new UnresolvedReferenceException(SCHEMA_ERROR + QNameParser.getFirstName(ids),
                QNameParser.getFirstNameCtx(ids).start);
    }

    /**
     * Заполняет владельца
     * @param ctx контекст парсера с владельцем
     * @param st объект
     */
    protected void fillOwnerTo(Owner_toContext ctx, PgStatement st) {
        if (db.getArguments().isIgnorePrivileges() || refMode) {
            return;
        }
        if (ctx != null && ctx.name != null) {
            st.setOwner(ctx.name.getText());
        }
    }

    protected void addPgTypeDepcy(Data_typeContext ctx, PgStatement st) {
        Schema_qualified_name_nontypeContext qname = ctx.predefined_type().schema_qualified_name_nontype();
        if (qname != null && qname.identifier() != null) {
            addDepSafe(st, Arrays.asList(qname.identifier(), qname.identifier_nontype()),
                    DbObjType.TYPE, true);
        }
    }

    protected void addMsTypeDepcy(cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext ctx,
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
            quotedOption = "toast."+ option;
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
        PgObjLocation loc = new PgObjLocation(
                act != null ? act : ctx.getStart().getText().toUpperCase(Locale.ROOT),
                        ctx, getFullCtxText(ctx));
        db.addReference(fileName, loc);
        return loc;
    }

    /**
     * Adds missing COMMENT/RULE refs for correct showing them in Outline.
     * (In the case of COMMENT : used for COLUMN comments and comments
     * for objects which undefined in DbObjType).
     */
    protected void addOutlineRefForCommentOrRule(String action, ParserRuleContext ctx) {
        db.addReference(fileName, new PgObjLocation(action, ctx, null));
    }

    /**
     * Returns action information which will later be used for showing in console,
     * in 'Outline' and in 'outline of Project explorer files'.
     */
    protected abstract String getStmtAction();

    /**
     * Used in general cases in {@link #getStmtAction()} for get action information.
     */
    protected String getStrForStmtAction(String action, DbObjType type,
            List<? extends ParserRuleContext> ids) {
        StringBuilder sb = new StringBuilder(action).append(' ').append(type).append(' ');
        for (ParserRuleContext id : ids) {
            if (id != null) {
                sb.append(id.getText()).append('.');
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
