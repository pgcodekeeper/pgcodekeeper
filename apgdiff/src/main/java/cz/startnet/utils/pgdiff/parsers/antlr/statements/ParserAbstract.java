package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.GeneralLiteralSearch;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Name_or_func_callsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_unique_prkeyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class ParserAbstract {
    protected final PgDatabase db;
    protected final Path filePath;

    public ParserAbstract(PgDatabase db, Path filePath) {
        this.db = db;
        this.filePath = filePath;
    }

    /**
     * Parse object from context and return it
     * 
     * @return parsed object
     */
    public abstract PgStatement getObject();

    protected String getDefSchemaName() {
        return db.getDefaultSchema().getName();
    }

    /**
     * Extracts raw text from context
     * 
     * @param ctx
     *            context
     * @return raw string
     */
    public static String getFullCtxText(ParserRuleContext ctx) {
        Interval interval = new Interval(ctx.start.getStartIndex(),
                ctx.stop.getStopIndex());
        return ctx.start.getInputStream().getText(interval);
    }

    /**
     * Get list schema qualified names in string
     * @param ctx list Schema_qualified_name
     * @return List of strings
     */
    protected List<String> getNames(List<Schema_qualified_nameContext> ctx) {
        List<String> result = new ArrayList<>();
        for (Schema_qualified_nameContext name : ctx) {
            result.add(name.getText());
        }
        return result;
    }

    public static String getName(Schema_qualified_nameContext name) {
        int i = 0;
        if (name == null) {
            return null;
        }
        while (name.identifier(i + 1) != null) {
            i++;
        }
        return removeQuotes(name.identifier(i));
    }
    
    /**
     * Remove quotes from identifier
     * @param name identifier context
     * @return string name without quotes
     */
    public static String removeQuotes(IdentifierContext name) {
        String identifier = name.getText();
        // FIXME single identifier doesn't require splitNames
        String unquotedName = PgDiffUtils.splitNames(identifier)[0];
        
        return (identifier.charAt(0) == '"') ? unquotedName : unquotedName.toLowerCase();
    }

    public static String getSchemaName(Schema_qualified_nameContext name) {
        int i = 0;
        if (name == null) {
            return null;
        }
        while (name.identifier(i + 1) != null) {
            i++;
        }
        switch (i) {
        case 1:
        case 2:
            return removeQuotes(name.identifier(0));
        default:
            return null;
        }
    }

    public static String getTableName(Schema_qualified_nameContext name) {
        int i = 0;
        if (name == null) {
            return null;
        }
        while (name.identifier(i + 1) != null) {
            i++;
        }
        // i points on name
        switch (i) {
            // its only name
        case 0:
            return null;
            // may be unqualified table or schema name
            // TODO case for schema(0).table(1) ?
        case 1:
            return removeQuotes(name.identifier(0));
            // qualified table name on 1 position
        case 2:
            return removeQuotes(name.identifier(1));
        }
        return null;
    }

    protected PgColumn getColumn(Table_column_definitionContext colCtx,
            List<String> sequences, Map<String, GenericColumn> defaultFucntions) {
        PgColumn col = null;
        if (colCtx.column_name != null) {
            col = new PgColumn(removeQuotes(colCtx.column_name));
            for (Constraint_commonContext column_constraint : colCtx.colmn_constraint) {
                if (column_constraint.constr_body().default_expr != null) {
                    col.setDefaultValue(getFullCtxText(column_constraint.constr_body().default_expr));
                    String sequence = getSequence(column_constraint.constr_body().default_expr);
                    if (sequence != null) {
                        sequences.add(sequence);
                    }
                    GenericColumn func = getFunctionCall(column_constraint.constr_body().default_expr);
                    if (func != null) {
                        defaultFucntions.put(colCtx.column_name.getText(), func);
                    }
                } else if (column_constraint.constr_body().default_expr_data != null) {
                    col.setDefaultValue(getFullCtxText(column_constraint
                            .constr_body().default_expr_data));
                }

                if (column_constraint.constr_body().common_constraint() != null) {
                    if (column_constraint.constr_body().common_constraint().null_value != null) {
                        col.setNullValue(column_constraint.constr_body()
                                .common_constraint().null_false == null);
                    }
                }
            }
            if (colCtx.datatype != null) {
                col.setType(getWrongColumn(colCtx));
            }
        }

        return col;
    }
    /**
     * Made only for compatibility with apgdiff 
     * Should be removed after refactor!
     * @param fullCtxText
     * @return type of column
     */
    private String getWrongColumn(Table_column_definitionContext colCtx) {
        ColumnDefinition cd = new ColumnDefinition();
        ParseTreeWalker.DEFAULT.walk(cd, colCtx);
        
        PgColumn col = new PgColumn("");
        col.parseDefinition(getFullCtxText(colCtx.datatype) + " " + cd.getDefinition(), new StringBuilder(1));
        return col.getType();
    }

    private static class ColumnDefinition extends SQLParserBaseListener {
        StringBuilder sb = new StringBuilder();
        @Override
        public void exitCollate_identifier(Collate_identifierContext ctx) {
            sb.append(getFullCtxText(ctx)).append(" ");
        }
        @Override
        public void exitWith_options(With_optionsContext ctx) {
            sb.append(getFullCtxText(ctx)).append(" ");
        }
        @Override
        public void exitConstraint_common(Constraint_commonContext ctx) {
            sb.append(getFullCtxText(ctx)).append(" ");
        }
        public String getDefinition() {
            if (sb.length() > 0) {
                // удалить последний пробел
                sb.setLength(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
    }

    protected String getSequence(Value_expressionContext default_expr) {
        SeqNameListener name = new SeqNameListener();
        ParseTreeWalker.DEFAULT.walk(name, default_expr);
        return name.getSeqName();
    }
    
    private static class SeqNameListener extends SQLParserBaseListener {
        
        private String seqName;
        
        @Override
        public void enterName_or_func_calls(Name_or_func_callsContext ctx) {
            GeneralLiteralSearch seq = new GeneralLiteralSearch();
            ParseTreeWalker.DEFAULT.walk(seq, ctx);
            if (seq.isFound()) {
                seqName = seq.getSeqName();
            }
        }
        public String getSeqName() {
            return seqName;
        }
    }
    
    protected GenericColumn getFunctionCall(Value_expressionContext ctx) {
        FunctionSearcher fs = new FunctionSearcher();
        ParseTreeWalker.DEFAULT.walk(fs, ctx);
        if (fs.getValue() == null) {
            return null;
        }
        return new GenericColumn(getSchemaName(fs.getValue()),
                getName(fs.getValue()), null);
    }
    
    public static class FunctionSearcher extends SQLParserBaseListener {
        private Schema_qualified_nameContext value; 
        @Override
        public void enterName_or_func_calls(Name_or_func_callsContext ctx) {
            String name = getName(ctx.schema_qualified_name());
            if (ctx.function_calls_paren() != null
                    && !name.equals("nextval")
                    && value == null) {
                value = ctx.schema_qualified_name();
            }
        }
        public Schema_qualified_nameContext getValue() {
            return value;
        }
    }
    
    public static void fillArguments(Function_argsContext function_argsContext,
            PgFunction function, String defSchemaName) {
        for (Function_argumentsContext argument : function_argsContext
                .function_arguments()) {
            PgFunction.Argument arg = new PgFunction.Argument();
            if (argument.argname != null) {
                arg.setName(removeQuotes(argument.argname));
            }
            if (argument.argtype_data != null) {
                arg.setDataType(getFullCtxText(argument.argtype_data));
            } else if (argument.argtype_expres != null) {
                arg.setDataType(getFullCtxText(argument.argtype_expres));
            }
            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(getFullCtxText(argument
                        .function_def_value().def_value));
                for (GenericColumn objName : parseDefValues(argument
                        .function_def_value().def_value, defSchemaName)) {
                    arg.addDefaultObject(objName);
                }
            }
            if (argument.arg_mode != null) {
                arg.setMode(argument.arg_mode.getText());
            }
            function.addArgument(arg);
        }
    }
    
    private static List<GenericColumn> parseDefValues(ParserRuleContext defExpression,
            final String defSchemaName) {
        final List<GenericColumn> funcSignature = new ArrayList<>();
        new ParseTreeWalker().walk(new SQLParserBaseListener() {
            @Override
            public void exitName_or_func_calls(Name_or_func_callsContext ctx) {
                if (ctx.function_calls_paren() == null) {
                    return;
                }
                Schema_qualified_nameContext name = ctx.schema_qualified_name();
                String objName = getName(name);
                String schemaName = getSchemaName(name);
                if (schemaName == null) {
                    schemaName = defSchemaName;
                }
                funcSignature.add(new GenericColumn(schemaName, objName, null));
            }
        }, defExpression);
        return funcSignature;
    }

    protected List<PgConstraint> getConstraint(Table_column_defContext colCtx,
            String scmName, String tblName) {
        List<PgConstraint> result = new ArrayList<>();
        // колоночные констрайнты добавляются в тип колонки, особенности апгдиффа
        if (colCtx.tabl_constraint != null) {
            result.add(getTableConstraint(colCtx.tabl_constraint, scmName, tblName));
        }
        return result;
    }

    protected PgConstraint getTableConstraint(Constraint_commonContext ctx,
            String scmName, String tblName) {
        String constrName = ctx.constraint_name == null ? "" : removeQuotes(ctx.constraint_name);
        PgConstraint constr = new PgConstraint(constrName, getFullCtxText(ctx));
        
        if (ctx.constr_body().FOREIGN() != null) {
            Table_referencesContext tblRef = ctx.constr_body().table_references();

            String tableName = getName(tblRef.reftable);
            String schemaName = getSchemaName(tblRef.reftable);
            if (schemaName == null) {
                schemaName = db.getDefaultSchema().getName();
            } 
            for (Schema_qualified_nameContext name : tblRef.column_references().names_references().name) {
                constr.addForeignColumn(
                        new GenericColumn(schemaName, tableName, getName(name)));
            }
        }
        if (ctx.constr_body().table_unique_prkey() != null) {
            setPrimaryUniq(ctx.constr_body().table_unique_prkey(), constr, scmName, tblName);
        }
        constr.setDefinition(getFullCtxText(ctx.constr_body()));
        return constr;
    }
    
    /**
     * Вычитать PrimaryKey или Unique со списком колонок
     */
    private void setPrimaryUniq(Table_unique_prkeyContext ctx,
            PgConstraint constr, String scmName, String tblName) {
        constr.setUnique(ctx.UNIQUE() != null);
        constr.setPrimaryKey(ctx.PRIMARY() != null);
        for (Schema_qualified_nameContext name : ctx.column_references()
                .names_references().name) {
            constr.addColumn(new GenericColumn(scmName, tblName, getName(name)));
        }
    }
    
    protected void logError(String object, String name) {
        Log.log(Log.LOG_ERROR, new StringBuilder(0).append("Cannot find ")
                .append(object).append(" in database: ").append(name)
                .toString());
    }
    
    protected void logSkipedObject(String schema, String object, String name) {
        Log.log(Log.LOG_ERROR,
                new StringBuilder(0).append("Cannot find schema ")
                        .append(schema).append(" in database. ")
                        .append("Thats why ").append(object).append(" ")
                        .append(name).append("will be skipped").toString());
    }

    protected PgConstraint parseDomainConstraint(Domain_constraintContext constr) {
        if (constr.common_constraint().check_boolean_expression() != null) {
            String constr_name = "";
            if (constr.name != null) {
                constr_name = getName(constr.name);
            }
            PgConstraint constraint = new PgConstraint(constr_name,
                    getFullCtxText(constr));            
            constraint.setDefinition(getFullCtxText(constr.common_constraint()));
            return constraint;
        }
        return null;
    }
    /**
     * Извлекает правильное значение для максимального значения сиквенса
     */
    public static String getMaxValue(long inc, String maxValue) {
        if (maxValue == null) {
            return null;
        }
        long max = Long.parseLong(maxValue);
        if ((inc > 0 && max == Long.MAX_VALUE)
                || (inc < 0 && max == -1)) {
            return null;
        }
        return maxValue;
    }
    
    /**
     * Извлекает правильное значение для минимального значения сиквенса
     */
    public static String getMinValue(long inc, String minValue) {
        if (minValue == null) {
            return null;
        }
        long min = Long.parseLong(minValue);
        if ((inc > 0 && min == 1)
                || (inc < 0 && min == -Long.MAX_VALUE)) {
            return null;
        }
        return minValue;
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
            st.setOwner(removeQuotes(ctx.name));
        }
    }
}
