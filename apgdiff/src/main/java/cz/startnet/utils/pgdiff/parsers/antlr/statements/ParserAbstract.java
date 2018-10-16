package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract {

    protected final PgDatabase db;

    public ParserAbstract(PgDatabase db) {
        this.db = db;
    }

    /**
     * Parse object from context and return it
     *
     * @return parsed object
     */
    public abstract PgStatement getObject();

    protected String getDefSchemaName() {
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
        PgFunction function = new PgFunction(name, null);
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
        PgOperator oper = new PgOperator(name, null);
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

    public static <T extends IStatement> T getSafe(Function <String, T> getter,
            ParserRuleContext ctx) {
        return getSafe(getter, ctx.getText(), ctx.getStart());
    }

    public static <T extends IStatement> T getSafe(Function <String, T> getter,
            String name, Token errToken) {
        T statement = getter.apply(name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + errToken.getText(), errToken);
        }
        return statement;
    }

    public AbstractSchema getSchemaSafe(List<? extends ParserRuleContext> ids, AbstractSchema defaultSchema) {
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        AbstractSchema foundSchema = schemaCtx == null ? defaultSchema : getSafe(db::getSchema, schemaCtx);
        if (foundSchema != null) {
            return foundSchema;
        }

        ParserRuleContext firstNameCtx = QNameParser.getFirstNameCtx(ids);
        throw new UnresolvedReferenceException("Schema not found for " +
                getFullCtxText(ids), firstNameCtx.start);
    }

    /**
     * Заполняет владельца
     * @param ctx контекст парсера с владельцем
     * @param st объект
     */
    protected void fillOwnerTo(Owner_toContext ctx, PgStatement st) {
        if (db.getArguments().isIgnorePrivileges()) {
            return;
        }
        if (ctx != null) {
            st.setOwner(ctx.name.getText());
        }
    }

    static void addTypeAsDepcy(Data_typeContext ctx, PgStatement st, String schema) {
        Schema_qualified_name_nontypeContext qname = ctx.predefined_type().schema_qualified_name_nontype();
        if (qname != null) {
            IdentifierContext schemaCtx = qname.identifier();
            String schemaName = schema;
            if (schemaCtx != null){
                schemaName = schemaCtx.getText();
                if ("pg_catalog".equals(schemaName)
                        || "information_schema".equals(schemaName)) {
                    return;
                }
            }

            st.addDep(new GenericColumn(schemaName, qname.identifier_nontype().getText(),
                    DbObjType.TYPE));
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
