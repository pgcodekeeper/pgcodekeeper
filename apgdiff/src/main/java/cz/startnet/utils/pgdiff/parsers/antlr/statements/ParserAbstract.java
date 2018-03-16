package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Check_boolean_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        PgSchema s = db.getDefaultSchema();
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
        Interval interval = new Interval(ctx.getStart().getStartIndex(),
                ctx.getStop().getStopIndex());
        return ctx.getStart().getInputStream().getText(interval);
    }

    protected PgColumn getColumn(Table_column_definitionContext colCtx) {
        PgColumn col = new PgColumn(colCtx.column_name.getText());
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
            Argument arg = function.new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            function.addArgument(arg);
        }
        return function.getSignature();
    }

    public static void processTableActionConstraintExpr(Table_actionContext ctx,
            PgConstraint constr, PgDatabase dataBase) {
        Constr_bodyContext constrBodyCtx = ctx.tabl_constraint.constr_body();
        constr.setDefinition(getFullCtxText(constrBodyCtx));
        constr.setNotValid(ctx.not_valid != null);
        dataBase.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(constr, constrBodyCtx));
    }

    public static void fillArguments(Function_argsContext functionArgsContext,
            PgFunction function, String defSchemaName, PgDatabase dataBase) {
        for (Function_argumentsContext argument : functionArgsContext.function_arguments()) {
            Argument arg = function.new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            addTypeAsDepcy(argument.data_type(), function, defSchemaName);

            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(getFullCtxText(argument.function_def_value().def_value));

                if (dataBase != null) {
                    dataBase.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(function,
                            argument.function_def_value().def_value));
                }
            }

            function.addArgument(arg);
        }
    }

    protected PgConstraint parseDomainConstraint(Domain_constraintContext constr, String schemaName) {
        Check_boolean_expressionContext bool = constr.common_constraint().check_boolean_expression();
        if (bool != null) {
            String constrName = "";
            if (constr.name != null) {
                constrName = QNameParser.getFirstName(constr.name.identifier());
            }
            PgConstraint constraint = new PgConstraint(constrName,
                    getFullCtxText(constr));
            constraint.setDefinition(getFullCtxText(constr.common_constraint()));
            db.getContextsForAnalyze().add(new SimpleEntry<>(constraint, bool.expression));
            return constraint;
        }
        return null;
    }

    public static <T extends IStatement> T getSafe(Function <String, T> getter,
            IdentifierContext ctx) {
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

    public PgSchema getSchemaSafe(List<IdentifierContext> ids, PgSchema defaultSchema) {
        IdentifierContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        return schemaCtx == null ? defaultSchema : getSafe(db::getSchema, schemaCtx);
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
            boolean isToast, boolean forceQuote){
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
            if (forceQuote || !PgDiffUtils.isValidId(value, false, false)) {
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
}
