package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.Parser;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.General_literalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Name_or_func_callsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
     * Add object with start position to db object location List
     * 
     * @param obj
     * @param startIndex
     */
    protected void fillObjDefinition(String schemaName, PgStatement obj,
            int startIndex) {
        PgObjLocation loc = null;
        switch (obj.getStatementType()) {
        case FUNCTION:
            PgFunction func = (PgFunction) obj;
            loc = new PgObjLocation(schemaName,
                    func.getSignature(), null, startIndex,
                    filePath);
            loc.setObjNameLength(func.getBareName().length());
            break;
        default:
            loc = new PgObjLocation(schemaName, obj.getBareName(), null,
                    startIndex, filePath);
        }
        loc.setObjType(obj.getStatementType());
        db.addObjDefinition(loc);
        db.addObjReference(loc);
    }
    
    protected void addObjReference(String schemaName, String objName, DbObjType objType, int startIndex, int nameLength) {
        PgObjLocation loc = new PgObjLocation(schemaName, objName, null,
                startIndex, filePath);
        if (objType == DbObjType.FUNCTION) {
            loc.setObjNameLength(nameLength);
        }
        loc.setObjType(objType);
        db.addObjReference(loc);
    }
    
    protected void setCommentToDefinition(String schemaName, String objName,
            DbObjType objType, String comment) {
        for (PgObjLocation loc : db.getObjDefinitions()) {
            if (loc.getObjName().equals(objName)
                    && loc.getObjType().equals(objType)) {
                loc.setComment(comment);
            }
        }
    }

    /**
     * Extracts raw text from context
     * 
     * @param ctx
     *            context
     * @return raw string
     */
    protected String getFullCtxText(ParserRuleContext ctx) {
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

    protected String getName(Schema_qualified_nameContext name) {
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
    protected String removeQuotes(IdentifierContext name) {
        String identifier = name.getText();
        String unquotedName = ParserUtils.splitNames(identifier)[0];
        
        return (identifier.startsWith("\"")) ? unquotedName : unquotedName.toLowerCase();
    }

    protected String getSchemaName(Schema_qualified_nameContext name) {
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

    protected String getTableName(Schema_qualified_nameContext name) {
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
        case 1:
            return removeQuotes(name.identifier(0));
            // qualified table name on 1 position
        case 2:
            return removeQuotes(name.identifier(1));
        }
        return null;
    }

    protected PgColumn getColumn(Table_column_definitionContext colCtx, List<String> sequences) {
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
                } else if (column_constraint.constr_body().default_expr_data != null) {
                    col.setDefaultValue(getFullCtxText(column_constraint
                            .constr_body().default_expr_data));
                }

                if (column_constraint.constr_body().null_value != null) {
                    if (column_constraint.constr_body().null_false != null) {
                        col.setNullValue(false);
                    } else {
                        col.setNullValue(true);
                    }
                }
            }
            if (colCtx.datatype != null) {
//                col.setType(getFullCtxText(colCtx.datatype));
                col.setType(getWrongColumn(getFullCtxText(colCtx)));
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
    private String getWrongColumn(String fullCtxText) {
        Parser par = new Parser(fullCtxText);
        par.parseIdentifier();
        PgColumn col = new PgColumn("");
        col.parseDefinition(par.getRest(), new StringBuilder(1));
        return col.getType();
    }

    protected String getSequence(Value_expressionContext default_expr) {
        SeqName name = new SeqName();
        new ParseTreeWalker().walk(name, default_expr);
        return name.getSeqName();
    }
    
    class SeqName extends SQLParserBaseListener {
        private String seqName;
        @Override
        public void enterName_or_func_calls(Name_or_func_callsContext ctx) {
         if (getName(ctx.schema_qualified_name()).equals("nextval")) {
             GeneralLiteralSearch seq = new GeneralLiteralSearch();
             new ParseTreeWalker().walk(seq, ctx);
             seqName = seq.getSeqName();
             if (seqName != null &&
                     !seqName.isEmpty()) {
                 addObjReference(getDefSchemaName(), seqName, DbObjType.SEQUENCE,
                         seq.getContext().getStart().getStartIndex() + 1, 0);
             }
         }
        }
        public String getSeqName() {
            return seqName;
        }
    }
    
    class GeneralLiteralSearch extends SQLParserBaseListener {
        private String seqName;
        private General_literalContext ctx;
        @Override
       public void enterGeneral_literal(General_literalContext ctx) {
            seqName = ctx.getText();
            this.ctx = ctx;
       }
        public String getSeqName() {
            return seqName.substring(1, seqName.length() - 1);
        }
        public General_literalContext getContext() {
            return ctx;
        }
    }

    protected void fillArguments(Function_argsContext function_argsContext,
            PgFunction function) {
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
            }
            if (argument.arg_mode != null) {
                arg.setMode(argument.arg_mode.getText());
            }
            function.addArgument(arg);
        }
    }

    protected List<PgConstraint> getConstraint(Table_column_defContext colCtx) {
        List<PgConstraint> result = new ArrayList<>();
        if (colCtx.tabl_constraint != null) {
            result.add(getTableConstraint(colCtx.tabl_constraint));
        }
        // колоночные констрайнты добавляются в тип колонки, особенности апгдиффа
        /*else {
            for (Constraint_commonContext column_constraint : colCtx
                    .table_column_definition().colmn_constraint) {
                getColumnConstraint(column_constraint, result);
            }
        }*/
        return result;
    }

    protected PgConstraint getTableConstraint(Constraint_commonContext ctx) {
        String constrName = ctx.constraint_name == null ? "" : removeQuotes(ctx.constraint_name);
        PgConstraint constr = new PgConstraint(constrName, getFullCtxText(ctx), db.getDefSearchPath());
        
        if (ctx.constr_body().FOREIGN() != null) {
            constr = new PgForeignKey(constrName, "", db.getDefSearchPath());

            Table_referencesContext tblRef = ctx.constr_body().table_references();

            String tableName = getName(tblRef.reftable);
            String schemaName = getSchemaName(tblRef.reftable);
            if (schemaName == null) {
                schemaName = db.getDefaultSchema().getName();
            }
            for (Schema_qualified_nameContext name : tblRef.column_references().names_references().name) {
                ((PgForeignKey)constr).addForeignColumn(
                        new GenericColumn(schemaName, tableName, getName(name)));
            }
        }
        constr.setDefinition(getFullCtxText(ctx.constr_body()));
        return constr;
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

    private void getColumnConstraint(
            Constraint_commonContext column_constraint,
            List<PgConstraint> result) {
        PgConstraint constr = null;
        // skip null and def values, it parsed to column def
        if (column_constraint.constr_body().null_value != null
                || column_constraint.constr_body().default_expr != null
                || column_constraint.constr_body().default_expr_data != null) {
            return;
        }
        constr = getTableConstraint(column_constraint);
        result.add(constr);
    }
}
