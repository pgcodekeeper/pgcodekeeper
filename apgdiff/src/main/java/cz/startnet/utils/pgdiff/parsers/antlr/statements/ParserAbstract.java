package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identifier_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.StatementBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract {

    protected final PgDatabase db;

    private List<StatementBodyContainer> statementBodies;
    private boolean refMode;
    private String fileName;
    private String defaultSchema;

    public ParserAbstract(PgDatabase db) {
        this.db = db;
    }

    public void parseObject(String fileName, String defaultSchema,
            boolean refMode, List<StatementBodyContainer> statementBodies) {
        this.fileName = fileName;
        this.defaultSchema = defaultSchema;
        this.refMode = refMode;
        this.statementBodies = statementBodies;
        parseObject();
    }

    protected boolean isRefMode() {
        return refMode;
    }

    protected void addStatementBody(ParserRuleContext ctx) {
        // if not refMode FullAnalyze must find all dependencies
        if (/*refMode && */statementBodies != null) {
            statementBodies.add(new StatementBodyContainer(fileName, ctx));
        }
    }

    /**
     * Parse object from context
     */
    public abstract void parseObject();

    protected String getDefSchemaName() {
        if (defaultSchema != null) {
            return defaultSchema;
        }
        AbstractSchema s = db.getDefaultSchema();
        return s == null ? null : s.getName();
    }

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

    protected AbstractColumn getColumn(Table_column_definitionContext colCtx) {
        AbstractColumn col = new PgColumn(colCtx.column_name.getText());
        col.setType(getFullCtxText(colCtx.datatype));
        addTypeAsDepcy(colCtx.datatype, col, getDefSchemaName());
        if (colCtx.collate_name != null) {
            col.setCollation(getFullCtxText(colCtx.collate_name.collation));
        }
        return col;
    }

    public static String parseSignature(String name, Function_argsContext argsContext) {
        PgFunction function = new PgFunction(name);
        for (Function_argumentsContext argument : argsContext.function_arguments()) {
            String type = getFullCtxText(argument.argtype_data);

            // function identity types from pg_dbo_timestamp extension have
            // names qualified by pg_catalog schema, delete them to have
            // equal signatures in project and in extension
            Schema_qualified_name_nontypeContext sqnn = argument.argtype_data.predefined_type().schema_qualified_name_nontype();
            if (sqnn != null) {
                IdentifierContext schema = sqnn.schema;
                if (schema != null && "pg_catalog".equals(schema.getText())) {
                    type = type.substring("pg_catalog.".length());
                }
            }

            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null, type);
            function.addArgument(arg);
        }
        return function.getSignature();
    }

    public static String parseSignature(String name, Target_operatorContext targerOperCtx) {
        PgOperator oper = new PgOperator(name);
        oper.setLeftArg(getOperArg(targerOperCtx.left_type));
        oper.setRightArg(getOperArg(targerOperCtx.right_type));
        return oper.getSignature();
    }

    private static String getOperArg(Data_typeContext typeCtx) {
        String argType = null;
        if (typeCtx != null) {
            argType = getFullCtxText(typeCtx);
            // operator identity types from pg_dbo_timestamp extension have
            // names qualified by pg_catalog schema, delete them to have
            // equal signatures in project and in extension
            Schema_qualified_name_nontypeContext sqnn = typeCtx.predefined_type().schema_qualified_name_nontype();
            if (sqnn != null) {
                IdentifierContext schema = sqnn.schema;
                if (schema != null && "pg_catalog".equals(schema.getText())) {
                    argType = argType.substring("pg_catalog.".length());
                }
            }
        }

        return argType;
    }

    protected void addReferenceOnSchema(ParserRuleContext schemaCtx) {
        if (schemaCtx != null) {
            addObjReference(new PgObjLocation(schemaCtx.getText(), DbObjType.SCHEMA),
                    StatementActions.NONE, schemaCtx);
        }
    }

    protected PgObjLocation addObjReference(ParserRuleContext name, DbObjType type,
            StatementActions action) {
        return addObjReference(new PgObjLocation(name.getText(), type), action, name);
    }

    protected PgObjLocation addObjReference(PgObjLocation loc, StatementActions action,
            ParserRuleContext nameCtx) {
        loc.setOffset(getStart(nameCtx));
        loc.setLine(nameCtx.start.getLine());
        loc.setFilePath(fileName);
        loc.setAction(action);
        db.getObjReferences().computeIfAbsent(fileName, k -> new ArrayList<>()).add(loc);
        return loc;
    }

    protected PgObjLocation addFullObjReference(List<? extends ParserRuleContext> ids, DbObjType type,
            StatementActions action) {
        addReferenceOnSchema(QNameParser.getSchemaNameCtx(ids));
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        return addObjReference(new PgObjLocation(QNameParser.getSchemaName(ids, getDefSchemaName()),
                nameCtx.getText(), type), action,nameCtx);
    }

    protected PgObjLocation addFullObjReference(IdContext schemaCtx, IdContext name, DbObjType type,
            StatementActions action) {
        addReferenceOnSchema(schemaCtx);
        return addObjReference((new PgObjLocation(schemaCtx != null ? schemaCtx.getText()
                : getDefSchemaName(), name.getText(), type)), action, name);
    }

    protected void fillObjDefinition(PgObjLocation loc, ParserRuleContext nameCtx, PgStatement st) {
        loc.setOffset(getStart(nameCtx));
        loc.setLine(nameCtx.start.getLine());
        loc.setFilePath(fileName);
        loc.setAction(StatementActions.CREATE);
        st.setLocation(loc);
        db.getObjDefinitions().computeIfAbsent(fileName, k -> new ArrayList<>()).add(loc);
        db.getObjReferences().computeIfAbsent(fileName, k -> new ArrayList<>()).add(loc);
    }

    private int getStart(ParserRuleContext ctx) {
        int start = ctx.start.getStartIndex();
        if (ctx instanceof IdentifierContext && ((IdentifierContext) ctx).QuotedIdentifier() != null
                || ctx instanceof IdContext && ((IdContext) ctx).SQUARE_BRACKET_ID() != null) {
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
        if (container == null) {
            return null;
        }
        R statement = getter.apply(container, name);
        if (statement == null && !refMode) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + errToken.getText(), errToken);
        }
        return statement;
    }

    public <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, String name, Token errToken) {
        return getSafe(getter, container, name, errToken, refMode);
    }

    protected <U extends PgStatement> void addSafe(BiConsumer<AbstractSchema, U> adder,
            AbstractSchema parent, U child, List<? extends ParserRuleContext> ids) {
        addSafe(adder, parent, child);
        addReferenceOnSchema(QNameParser.getSchemaNameCtx(ids));
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        PgObjLocation loc = new PgObjLocation(
                QNameParser.getSchemaName(ids, getDefSchemaName()),
                nameCtx.getText(), child.getStatementType());
        fillObjDefinition(loc, nameCtx, child);
    }

    protected <T extends IStatement, U extends PgStatement> void addSafe(BiConsumer<T, U> adder,
            T parent, U child, IdContext nameCtx) {
        addSafe(adder, parent, child);
        PgObjLocation loc = new PgObjLocation(nameCtx.getText(), child.getStatementType());
        fillObjDefinition(loc, nameCtx, child);
    }

    protected <T extends IStatement, U extends PgStatement> void addSafe(BiConsumer<T, U> adder,
            T parent, U child, IdContext schemaCtx, IdContext parentCtx, IdContext nameCtx) {
        addSafe(adder, parent, child);
        PgObjLocation loc = new PgObjLocation(schemaCtx != null ? schemaCtx.getText()
                : getDefSchemaName(), parentCtx.getText(), nameCtx.getText(), child.getStatementType());
        fillObjDefinition(loc, nameCtx, child);
    }

    protected <T extends IStatement, U extends IStatement> void addSafe(BiConsumer<T, U> adder,
            T parent, U child) {
        if (!refMode && parent != null) {
            adder.accept(parent, child);
        }
    }

    protected <T extends IStatement, U extends Object> void setSafe(BiConsumer<T, U> adder,
            T statement, U object) {
        if (!refMode) {
            adder.accept(statement, object);
        }
    }

    protected void addDepSafe(PgStatement st, List<IdentifierContext> ids, DbObjType type) {
        addReferenceOnSchema(QNameParser.getSchemaNameCtx(ids));
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);
        PgObjLocation loc = new PgObjLocation(QNameParser.getSchemaName(ids, getDefSchemaName()),
                nameCtx.getText(), type);
        addDepSafe(st, loc, nameCtx);
    }

    protected void addDepSafe(PgStatement st, PgObjLocation loc, ParserRuleContext nameCtx) {
        loc.setOffset(getStart(nameCtx));
        loc.setLine(nameCtx.start.getLine());
        loc.setFilePath(fileName);
        if (!refMode) {
            st.addDep(loc);
        }
        db.getObjReferences().computeIfAbsent(fileName, k -> new ArrayList<>()).add(loc);
    }

    protected AbstractSchema getSchemaSafe(List<? extends ParserRuleContext> ids) {
        return getSchemaSafe(ids, db.getSchema(getDefSchemaName()));
    }

    protected AbstractSchema getSchemaSafe(List<? extends ParserRuleContext> ids, AbstractSchema defaultSchema) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        AbstractSchema foundSchema = schemaCtx == null ? defaultSchema :
            getSafe(PgDatabase::getSchema, db, schemaCtx);
        if (foundSchema != null || refMode) {
            return foundSchema;
        }

        ParserRuleContext firstNameCtx = QNameParser.getFirstNameCtx(ids);
        throw new UnresolvedReferenceException("Schema not found for " +
                getFullCtxText(ids), firstNameCtx.start);
    }

    protected void setCommentToDefinition(PgObjLocation ref, String comment) {
        db.getObjDefinitions().values().stream().flatMap(List::stream)
        .filter(ref::compare).forEach(def -> def.setComment(comment));
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

    protected void addTypeAsDepcy(Data_typeContext ctx, PgStatement st, String schema) {
        Schema_qualified_name_nontypeContext qname = ctx.predefined_type().schema_qualified_name_nontype();
        if (qname != null) {
            IdentifierContext schemaCtx = qname.identifier();
            String schemaName = schema;
            if (schemaCtx != null) {
                schemaName = schemaCtx.getText();
                if ("pg_catalog".equals(schemaName)
                        || "information_schema".equals(schemaName)) {
                    return;
                }
            }

            addReferenceOnSchema(schemaCtx);
            Identifier_nontypeContext name = qname.identifier_nontype();
            PgObjLocation loc = new PgObjLocation(schemaName, name.getText(), DbObjType.TYPE);
            addDepSafe(st, loc, name);
        }
    }

    protected void addTypeAsDepcy(cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext ctx,
            PgStatement st) {
        Qualified_nameContext qname = ctx.qualified_name();
        if (qname != null) {
            IdContext schemaCtx = qname.schema;
            if (schemaCtx != null) {
                String schemaName = schemaCtx.getText();
                if (!"sys".equals(schemaName)) {
                    addReferenceOnSchema(schemaCtx);
                    IdContext name = qname.name;
                    PgObjLocation loc = new PgObjLocation(schemaName, name.getText(), DbObjType.TYPE);
                    addDepSafe(st, loc, name);
                }
            }
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
}
