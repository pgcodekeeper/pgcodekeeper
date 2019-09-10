package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Id_tokenContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Script_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Script_transactionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.StatementBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_xml_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Transaction_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
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
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract {

    protected static final String SCHEMA_ERROR = "Object must be schema qualified: ";

    protected final PgDatabase db;

    private List<StatementBodyContainer> statementBodies;
    private boolean refMode;
    private String fileName;

    protected StatementActions action;
    protected GenericColumn descrObj;

    public ParserAbstract(PgDatabase db) {
        this.db = db;
    }

    public void parseObject(String fileName, ParserListenerMode mode,
            List<StatementBodyContainer> statementBodies, ParserRuleContext ctx,
            CommonTokenStream tokenStream) {
        this.fileName = fileName;
        this.refMode = ParserListenerMode.REF == mode;
        this.statementBodies = statementBodies;
        if (ParserListenerMode.SCRIPT == mode) {
            fillDescrObj();
            fillQueryLocation(ctx, tokenStream);
        } else {
            parseObject();
        }
    }

    protected boolean isRefMode() {
        return refMode;
    }

    protected void addStatementBody(ParserRuleContext ctx) {
        if (statementBodies != null) {
            statementBodies.add(new StatementBodyContainer(fileName, ctx));
        }
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

    protected AbstractColumn getColumn(Table_column_definitionContext colCtx) {
        AbstractColumn col = new PgColumn(colCtx.column_name.getText());
        col.setType(getTypeName(colCtx.datatype));
        addPgTypeDepcy(colCtx.datatype, col);
        if (colCtx.collate_name != null) {
            col.setCollation(getFullCtxText(colCtx.collate_name.collation));
        }
        return col;
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
            String type = getTypeName(argument.argtype_data);
            function.addArgument(new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null, type));
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

    protected PgObjLocation addObjReference(List<? extends ParserRuleContext> ids,
            DbObjType type, StatementActions action) {
        PgObjLocation loc = getLocation(ids, type, action, false, null);
        if (loc != null) {
            db.getObjReferences().computeIfAbsent(fileName, k -> new HashSet<>()).add(loc);
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
                    + errToken.getText(), errToken);
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
                StatementActions.CREATE, false, null);
        if (loc != null) {
            child.setLocation(loc);
            db.getObjDefinitions().computeIfAbsent(fileName, k -> new HashSet<>()).add(loc);
            db.getObjReferences().computeIfAbsent(fileName, k -> new HashSet<>()).add(loc);
        }
    }

    private PgObjLocation getLocation(List<? extends ParserRuleContext> ids,
            DbObjType type, StatementActions action, boolean isDep, String signature) {
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        switch (type) {
        case ASSEMBLY:
        case EXTENSION:
        case SCHEMA:
        case ROLE:
        case USER:
        case DATABASE:
            return new PgObjLocation(new GenericColumn(nameCtx.getText(), type),
                    action.name(), getStart(nameCtx), nameCtx.start.getLine(), fileName);
        default:
            break;
        }

        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        String schemaName;
        if (schemaCtx != null) {
            addObjReference(Arrays.asList(schemaCtx), DbObjType.SCHEMA, StatementActions.NONE);
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
            return new PgObjLocation(new GenericColumn(schemaName, name, type),
                    action.name(), getStart(nameCtx), nameCtx.start.getLine(), fileName);
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
        case COLUMN:
            return new PgObjLocation(new GenericColumn(schemaName,
                    QNameParser.getSecondName(ids), name, type), action.name(),
                    getStart(nameCtx), nameCtx.start.getLine(), fileName);
        default:
            return null;
        }
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
        PgObjLocation loc = getLocation(ids, type, StatementActions.NONE, true, signature);
        if (loc != null && !ApgdiffUtils.isSystemSchema(loc.getSchema(), isPostgres)) {
            if (!refMode) {
                st.addDep(loc.getGenericColumn());
            }
            db.getObjReferences().computeIfAbsent(fileName, k -> new HashSet<>()).add(loc);
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
     * Fills the GenericColumn object which will be used for getting the action
     * string of described statement.
     */
    protected void fillDescrObj() {
        // implemented where its necessary
    }

    /**
     * Fills the 'QueryLocation'-object with query of statement and it's position
     * in the script from statement context, and then puts filled 'QueryLocation'-object
     * to the batch.
     */
    protected QueryLocation fillQueryLocation(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        QueryLocation loc = new QueryLocation(getStmtAction(ctx, tokenStream), ctx, getFullCtxText(ctx));
        db.addToBatch(loc);
        return loc;
    }

    protected String getStmtAction(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        return descrObj == null ? ctx.getStart().getText().toUpperCase(Locale.ROOT)
                : new StringBuilder().append(action.name())
                .append(' ').append(descrObj.type)
                .append(' ').append(descrObj.getQualifiedName()).toString();
    }

    public static String getPgStmtAction(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        if (ctx instanceof StatementContext) {
            StatementContext stmtCtx = (StatementContext) ctx;
            Script_statementContext scriptCtx;
            Script_transactionContext transactionCtx;
            if ((scriptCtx = stmtCtx.script_statement()) != null
                    && (transactionCtx = scriptCtx.script_transaction()) != null
                    && transactionCtx.START() != null) {
                return "START TRANSACTION";
            }
        } else if (ctx instanceof Data_statementContext) {
            Data_statementContext data = (Data_statementContext) ctx;
            if (data.select_stmt() != null) {
                return "SELECT";
            } else if (data.insert_stmt_for_psql() != null) {
                return "INSERT";
            } else if (data.delete_stmt_for_psql() != null) {
                return "DELETE";
            }
            return ctx.getStart().getText().toUpperCase(Locale.ROOT);
        } else if (ctx instanceof Schema_createContext) {
            Schema_createContext createCtx = (Schema_createContext) ctx;
            int descrWordsCount = 0;
            if (createCtx.create_language_statement() != null) {
                return "CREATE LANGUAGE";
            } else if (createCtx.create_transform_statement() != null) {
                return "CREATE TRANSFORM";
            } else if (createCtx.create_table_as_statement() != null) {
                return "CREATE TABLE";
            } else if (createCtx.create_conversion_statement() != null) {
                return "CREATE CONVERSION";
            } else if (createCtx.create_event_trigger() != null
                    || createCtx.create_user_mapping() != null
                    || createCtx.create_access_method() != null
                    || createCtx.create_operator_family_statement() != null
                    || createCtx.create_operator_class_statement() != null
                    || createCtx.security_label() != null) {
                descrWordsCount = 3;
            } else if (createCtx.schema_import() != null
                    || createCtx.create_foreign_data_wrapper() != null) {
                descrWordsCount = 4;
            } else {
                descrWordsCount = 2;
            }
            return getActionDescription(tokenStream, ctx, descrWordsCount);
        } else if (ctx instanceof Schema_alterContext) {
            Schema_alterContext alterCtx = (Schema_alterContext) ctx;
            int descrWordsCount = 0;
            if (alterCtx.alter_language_statement() != null) {
                return "ALTER LANGUAGE";
            } else if (alterCtx.alter_foreign_data_wrapper() != null) {
                descrWordsCount = 4;
            } else if (alterCtx.alter_default_privileges() != null
                    || alterCtx.alter_event_trigger() != null
                    || alterCtx.alter_user_mapping() != null
                    || alterCtx.alter_operator_family_statement() != null
                    || alterCtx.alter_operator_class_statement() != null) {
                descrWordsCount = 3;
            } else {
                descrWordsCount = 2;
            }
            return getActionDescription(tokenStream, ctx, descrWordsCount);
        }
        return ctx.getStart().getText().toUpperCase(Locale.ROOT);
    }

    public static String getMsStmtAction(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        if (ctx instanceof Another_statementContext) {
            Another_statementContext ast = (Another_statementContext) ctx;
            Transaction_statementContext transactionCtx;
            if ((transactionCtx = ast.transaction_statement()) != null
                    && transactionCtx.BEGIN() != null) {
                return "BEGIN TRANSACTION";
            }
            return ctx.getStart().getText().toUpperCase(Locale.ROOT);
        } else if (ctx instanceof Dml_clauseContext) {
            Dml_clauseContext dml = (Dml_clauseContext) ctx;
            if (dml.merge_statement() != null) {
                return "MERGE";
            } else if (dml.delete_statement() != null) {
                return "DELETE";
            } else if (dml.insert_statement() != null) {
                return "INSERT";
            } else if (dml.select_statement() != null) {
                return "SELECT";
            }
            return ctx.getStart().getText().toUpperCase(Locale.ROOT);
        } else if (ctx instanceof cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext) {
            cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext createCtx
            = (cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext) ctx;
            Create_xml_indexContext xmlIdxCtx;
            int descrWordsCount = 2;
            if (createCtx.create_application_role() != null
                    || createCtx.create_asymmetric_key() != null
                    || createCtx.create_cryptographic_provider() != null
                    || createCtx.create_event_notification() != null
                    || createCtx.create_external_library() != null
                    || createCtx.create_external_table() != null
                    || createCtx.create_fulltext_catalog() != null
                    || createCtx.create_fulltext_index() != null
                    || createCtx.create_fulltext_stoplist() != null
                    || createCtx.create_key() != null
                    || createCtx.create_message_type() != null
                    || createCtx.create_or_alter_broker_priority() != null
                    || createCtx.create_or_alter_event_session() != null
                    || createCtx.create_or_alter_resource_pool() != null
                    || createCtx.create_partition_function() != null
                    || createCtx.create_partition_scheme() != null
                    || createCtx.create_security_policy() != null
                    || createCtx.create_server_audit() != null
                    || createCtx.create_server_role() != null
                    || createCtx.create_workload_group() != null
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null
                    && xmlIdxCtx.PRIMARY() == null)) {
                descrWordsCount = 3;
            } else if (createCtx.create_column_encryption_key() != null
                    || createCtx.create_column_master_key() != null
                    || createCtx.create_database_encryption_key() != null
                    || createCtx.create_database_scoped_credential() != null
                    || createCtx.create_external_resource_pool() != null
                    || createCtx.create_master_key_sql_server() != null
                    || createCtx.create_remote_service_binding() != null
                    || createCtx.create_search_property_list() != null
                    || createCtx.create_selective_index() != null
                    || createCtx.create_server_audit_specification() != null
                    || createCtx.create_xml_schema_collection() != null
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null
                    && xmlIdxCtx.PRIMARY() != null)) {
                descrWordsCount = 4;
            }
            return getActionDescription(tokenStream, ctx, descrWordsCount);
        } else if (ctx instanceof cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext) {
            cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext alterCtx
            = (cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext) ctx;
            int descrWordsCount = 0;
            if (alterCtx.alter_asymmetric_key() != null
                    || alterCtx.alter_application_role() != null
                    || alterCtx.alter_availability_group() != null
                    || alterCtx.alter_cryptographic_provider() != null
                    || alterCtx.alter_external_library() != null
                    || alterCtx.alter_fulltext_catalog() != null
                    || alterCtx.alter_fulltext_index() != null
                    || alterCtx.alter_fulltext_stoplist() != null
                    || alterCtx.alter_master_key_sql_server() != null
                    || alterCtx.alter_message_type() != null
                    || alterCtx.alter_partition_function() != null
                    || alterCtx.alter_partition_scheme() != null
                    || alterCtx.alter_resource_governor() != null
                    || alterCtx.alter_security_policy() != null
                    || alterCtx.alter_server_audit() != null
                    || alterCtx.alter_server_configuration() != null
                    || alterCtx.alter_server_role() != null
                    || alterCtx.alter_server_role_pdw() != null
                    || alterCtx.alter_symmetric_key() != null
                    || alterCtx.alter_workload_group() != null
                    || alterCtx.create_or_alter_broker_priority() != null
                    || alterCtx.create_or_alter_event_session() != null
                    || alterCtx.create_or_alter_resource_pool() != null
                    || alterCtx.create_symmetric_key() != null) {
                descrWordsCount = 3;
            } else if (alterCtx.alter_column_encryption_key() != null
                    || alterCtx.alter_database_encryption_key() != null
                    || alterCtx.alter_database_scoped_credential() != null
                    || alterCtx.alter_external_data_source() != null
                    || alterCtx.alter_external_resource_pool() != null
                    || alterCtx.alter_remote_service_binding() != null
                    || alterCtx.alter_search_property_list() != null
                    || alterCtx.alter_server_audit_specification() != null
                    || alterCtx.alter_service_master_key() != null
                    || alterCtx.alter_xml_schema_collection() != null) {
                descrWordsCount = 4;
            } else {
                descrWordsCount = 2;
            }
            return getActionDescription(tokenStream, ctx, descrWordsCount);
        }
        return ctx.getStart().getText().toUpperCase(Locale.ROOT);
    }

    private static String getActionDescription(CommonTokenStream tokenStream, ParserRuleContext ctx,
            int descrWordsCount) {
        List<Token> tokens = tokenStream.getTokens(ctx.getStart().getTokenIndex(),
                ctx.getStop().getTokenIndex());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < descrWordsCount; i++) {
            sb.append(tokens.get(i).getText()).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
