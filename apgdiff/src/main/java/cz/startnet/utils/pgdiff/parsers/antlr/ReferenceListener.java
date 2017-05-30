package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * This class only fills 2 lists Definition and Reference for objects in file
 * @author botov_av
 *
 */
public class ReferenceListener extends SQLParserBaseListener {

    private String defSchema = ApgdiffConsts.PUBLIC;
    private final String filePath;
    private final Map<String, List<PgObjLocation>> definitions;
    private final Map<String, List<PgObjLocation>> references;
    private final List<FunctionBodyContainer> funcBodies = new ArrayList<>();
    private final IProgressMonitor monitor;

    public ReferenceListener(PgDatabase db, String filePath, IProgressMonitor monitor) {
        this.definitions = db.getObjDefinitions();
        this.references = db.getObjReferences();
        this.monitor = monitor;
        this.filePath = filePath;
    }

    private void safeParseStatement(Consumer<ParserRuleContext> c, ParserRuleContext ctx) {
        try {
            PgDiffUtils.checkCancelled(monitor);
            c.accept(ctx);
        } catch (InterruptedException ex) {
            throw new MonitorCancelledRuntimeException();
        }
    }

    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        safeParseStatement(e -> createTable(ctx), ctx);
    }

    @Override
    public void exitCreate_index_statement(Create_index_statementContext ctx) {
        safeParseStatement(e -> createIndex(ctx), ctx);
    }

    @Override
    public void exitCreate_extension_statement(Create_extension_statementContext ctx) {
        safeParseStatement(e -> createExtension(ctx), ctx);
    }

    @Override
    public void exitCreate_trigger_statement(Create_trigger_statementContext ctx) {
        safeParseStatement(e -> createTrigger(ctx), ctx);
    }

    @Override
    public void exitCreate_domain_statement(Create_domain_statementContext ctx) {
        safeParseStatement(e -> createDomain(ctx), ctx);
    }

    @Override
    public void exitCreate_type_statement(Create_type_statementContext ctx) {
        safeParseStatement(e -> createType(ctx), ctx);
    }

    @Override
    public void exitCreate_rewrite_statement(Create_rewrite_statementContext ctx) {
        safeParseStatement(e -> createRewrite(ctx), ctx);
    }

    @Override
    public void exitCreate_function_statement(Create_function_statementContext ctx) {
        safeParseStatement(e -> createFunction(ctx), ctx);
    }

    @Override
    public void exitCreate_sequence_statement(Create_sequence_statementContext ctx) {
        safeParseStatement(e -> createSequence(ctx), ctx);
    }

    @Override
    public void exitCreate_schema_statement(Create_schema_statementContext ctx) {
        safeParseStatement(e -> createSchema(ctx), ctx);
    }

    @Override
    public void exitCreate_view_statement(Create_view_statementContext ctx) {
        safeParseStatement(e -> createView(ctx), ctx);
    }

    @Override
    public void exitComment_on_statement(Comment_on_statementContext ctx) {
        safeParseStatement(e -> commentOn(ctx), ctx);
    }

    @Override
    public void exitSet_statement(Set_statementContext ctx) {
        safeParseStatement(e -> createSet(ctx), ctx);
    }

    @Override
    public void exitRule_common(Rule_commonContext ctx) {
        safeParseStatement(e -> createRule(ctx), ctx);
    }

    @Override
    public void exitAlter_function_statement(Alter_function_statementContext ctx) {
        safeParseStatement(e -> alterFunction(ctx), ctx);
    }

    @Override
    public void exitAlter_schema_statement(Alter_schema_statementContext ctx) {
        safeParseStatement(e -> alterSchema(ctx), ctx);
    }

    @Override
    public void exitAlter_table_statement(Alter_table_statementContext ctx) {
        safeParseStatement(e -> alterTable(ctx), ctx);
    }

    @Override
    public void exitAlter_sequence_statement(Alter_sequence_statementContext ctx) {
        safeParseStatement(e -> alterSequence(ctx), ctx);
    }

    @Override
    public void exitAlter_view_statement(Alter_view_statementContext ctx) {
        safeParseStatement(e -> alterView(ctx), ctx);
    }

    @Override
    public void exitAlter_domain_statement(Alter_domain_statementContext ctx) {
        safeParseStatement(e -> alterDomain(ctx), ctx);
    }

    @Override
    public void exitAlter_type_statement(Alter_type_statementContext ctx) {
        safeParseStatement(e -> alterType(ctx), ctx);
    }

    @Override
    public void exitDrop_statements(Drop_statementsContext ctx) {
        safeParseStatement(e -> drop(ctx), ctx);
    }

    @Override
    public void exitDrop_trigger_statement(Drop_trigger_statementContext ctx) {
        safeParseStatement(e -> dropTrigger(ctx), ctx);
    }

    @Override
    public void exitDrop_function_statement(Drop_function_statementContext ctx) {
        safeParseStatement(e -> dropFunction(ctx), ctx);
    }

    private String getDefSchemaName() {
        return defSchema;
    }

    public void createTable(Create_table_statementContext ctx){
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        for (Table_column_defContext colCtx : ctx.table_col_def) {
            getConstraint(colCtx);
        }

        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.TABLE,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createIndex(Create_index_statementContext ctx){
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, name,
                DbObjType.TABLE, StatementActions.NONE,
                ctx.table_name.getStart().getStartIndex(), 0,
                ctx.table_name.getStart().getLine());
        if (name != null) {
            fillObjDefinition(schemaName, name,
                    DbObjType.INDEX,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
        }
    }

    public void createExtension(Create_extension_statementContext ctx) {
        if (ctx.schema_with_name() != null) {
            addObjReference(null,
                    QNameParser.getFirstName(ctx.schema_with_name().name.identifier()),
                    DbObjType.SCHEMA, StatementActions.NONE,
                    ctx.schema_with_name().name.getStart().getStartIndex(), 0,
                    ctx.schema_with_name().name.getStart().getLine());
        }
        fillObjDefinition(null, QNameParser.getFirstName(ctx.name.identifier()),
                DbObjType.EXTENSION,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }


    public void createTrigger(Create_trigger_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, ParserAbstract.getFullCtxText(ctx.tabl_name),
                DbObjType.TABLE, StatementActions.NONE,
                ctx.tabl_name.getStart().getStartIndex(), 0,
                ctx.tabl_name.getStart().getLine());

        List<IdentifierContext> funcIds = ctx.func_name.schema_qualified_name().identifier();
        String funcName = QNameParser.getFirstName(funcIds);
        String funcSchema = QNameParser.getSchemaName(funcIds, getDefSchemaName());
        int offset = 0;
        // TODO proper qualified name splitting for every reference
        if (funcIds.size() > 1) {
            offset = funcSchema.length() + 1;
            addObjReference(null, funcSchema,
                    DbObjType.SCHEMA, StatementActions.NONE,
                    ctx.func_name.getStart().getStartIndex(), 0,
                    ctx.func_name.getStart().getLine());
        }
        addObjReference(funcSchema, funcName + "()",
                DbObjType.FUNCTION, StatementActions.NONE,
                ctx.func_name.getStart().getStartIndex()+ offset, funcName.length(),
                ctx.func_name.schema_qualified_name().getStart().getLine());

        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.TRIGGER,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createDomain(Create_domain_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, ParserAbstract.getFullCtxText(ctx.dat_type),
                DbObjType.TYPE, StatementActions.NONE,
                ctx.dat_type.getStart().getStartIndex(), 0,
                ctx.dat_type.getStart().getLine());
        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.DOMAIN,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createType(Create_type_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.TYPE,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createRewrite(Create_rewrite_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, ParserAbstract.getFullCtxText(ctx.table_name),
                DbObjType.TABLE, StatementActions.NONE,
                ctx.table_name.getStart().getStartIndex(), 0,
                ctx.table_name.getStart().getLine());
        // TODO process references in statements/expressions
        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.RULE,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createFunction(Create_function_statementContext ctx) {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgFunction function = new PgFunction(QNameParser.getFirstName(ids),
                ParserAbstract.getFullCtxText(ctx.getParent()));
        ParserAbstract.fillArguments(ctx.function_parameters().function_args(), function,
                getDefSchemaName());
        funcBodies.add(new FunctionBodyContainer(filePath,
                ctx.funct_body.getStart().getStartIndex(), ctx.funct_body.getStart().getLine(),
                ParserAbstract.getFullCtxText(ctx.funct_body)));

        fillObjDefinition(schemaName, function.getSignature(),
                DbObjType.FUNCTION,
                ctx.function_parameters().name.getStart().getStartIndex(), function.getBareName().length(),
                ctx.function_parameters().name.getStart().getLine());
    }

    public void createSequence(Create_sequence_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.SEQUENCE,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void createSchema(Create_schema_statementContext ctx) {
        String name = QNameParser.getFirstName(ctx.name.identifier());
        if (name != null) {
            fillObjDefinition(null, name,
                    DbObjType.SCHEMA,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
        }
    }

    public void createView(Create_view_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        fillObjDefinition(schemaName, QNameParser.getFirstName(ids),
                DbObjType.VIEW,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void commentOn(Comment_on_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String comment = "";
        if (ctx.comment_text != null) {
            comment = ctx.comment_text.getText();
        }
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        // function

        if (ctx.FUNCTION() != null) {
            PgFunction func = new PgFunction(name, null);
            ParserAbstract.fillArguments(ctx.function_args(), func, getDefSchemaName());
            name = func.getSignature();
            addObjReference(schemaName, name,
                    DbObjType.FUNCTION, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), func.getBareName().length(),
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.FUNCTION,
                    comment);
            // column
        } else if (ctx.COLUMN() != null) {
            String tableName = QNameParser.getSecondName(ids);
            if (schemaName.equals(tableName)) {
                schemaName = getDefSchemaName();
            }
            addObjReference(schemaName, tableName,
                    DbObjType.TABLE, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            //            setCommentToDefinition(schemaName, tableName, DbObjType.TABLE,
            //                    comment);
            // extension
        } else if (ctx.EXTENSION() != null) {
            addObjReference(null, name,
                    DbObjType.EXTENSION,
                    StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.EXTENSION,
                    comment);
            // constraint
        } else if (ctx.CONSTRAINT() != null) {
            // trigger
        } else if (ctx.TRIGGER() != null) {
            addObjReference(null, name,
                    DbObjType.TRIGGER, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.TRIGGER,
                    comment);
            // rule
        } else if (ctx.RULE() != null) {
            addObjReference(null, name,
                    DbObjType.RULE, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.RULE,
                    comment);
            // database
        } else if (ctx.DATABASE() != null) {
            // index
        } else if (ctx.INDEX() != null) {
            String tableName = QNameParser.getFirstName(ctx.name.identifier());
            if (schemaName.equals(tableName)) {
                schemaName = getDefSchemaName();
            }
            addObjReference(null, name,
                    DbObjType.INDEX, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.INDEX,
                    comment);
            // schema
        } else if (ctx.SCHEMA() != null) {
            addObjReference(null, name,
                    DbObjType.SCHEMA, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.SCHEMA,
                    comment);
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            addObjReference(schemaName, name,
                    DbObjType.SEQUENCE, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.SEQUENCE,
                    comment);
            // table
        } else if (ctx.TABLE() != null) {
            addObjReference(schemaName, name,
                    DbObjType.TABLE, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name,
                    DbObjType.TABLE,
                    comment);
            // view
        } else if (ctx.VIEW() != null) {
            addObjReference(schemaName, name,
                    DbObjType.VIEW, StatementActions.COMMENT,
                    ctx.name.getStart().getStartIndex(), 0,
                    ctx.name.getStart().getLine());
            setCommentToDefinition(name, DbObjType.VIEW, comment);
        }
    }

    public void createSet(Set_statementContext ctx) {
        if (ctx.config_param != null && "search_path".equalsIgnoreCase(ctx.config_param.getText())) {
            for (Set_statement_valueContext value : ctx.config_param_val) {
                addObjReference(null, value.getText(),
                        DbObjType.SCHEMA, StatementActions.NONE,
                        value.getStart().getStartIndex(), 0,
                        value.getStart().getLine());
                defSchema = value.getText();
                break;
            }
        }
    }

    public void createRule(Rule_commonContext ctx) {
        DbObjType type = null;
        List<Schema_qualified_nameContext> obj_name = new ArrayList<>();
        if (ctx.body_rule.body_rules_rest().obj_name != null) {
            obj_name = ctx.body_rule.body_rules_rest().obj_name.name;
        } else if (ctx.body_rule.on_table() != null) {
            type = DbObjType.TABLE;
            obj_name = ctx.body_rule.on_table().obj_name.name;
        } else if (ctx.body_rule.on_sequence() != null) {
            type = DbObjType.SEQUENCE;
            obj_name = ctx.body_rule.on_sequence().obj_name.name;
        } else if (ctx.body_rule.on_database() != null) {
            type = DbObjType.DATABASE;
            obj_name = ctx.body_rule.on_database().obj_name.name;
        } else if (ctx.body_rule.on_datawrapper_server_lang() != null) {
            obj_name = ctx.body_rule.on_datawrapper_server_lang().obj_name.name;
        } else if (ctx.body_rule.on_function() != null) {
            type = DbObjType.FUNCTION;
            for (Function_parametersContext functparam : ctx.body_rule.on_function().obj_name) {
                PgFunction func = new PgFunction(
                        QNameParser.getFirstName(functparam.name.identifier()), null);
                ParserAbstract.fillArguments(functparam.function_args(), func, getDefSchemaName());
                addObjReference(getDefSchemaName(), func.getSignature(),
                        DbObjType.FUNCTION, StatementActions.NONE,
                        functparam.name.getStart().getStartIndex(), func.getBareName().length(),
                        functparam.name.getStart().getLine());
            }
        } else if (ctx.body_rule.on_large_object() != null) {
            obj_name = ctx.body_rule.on_large_object().obj_name.name;
        } else if (ctx.body_rule.on_schema() != null) {
            type = DbObjType.SCHEMA;
            obj_name = ctx.body_rule.on_schema().obj_name.name;
        } else if (ctx.body_rule.on_tablespace() != null) {
            obj_name = ctx.body_rule.on_tablespace().obj_name.name;
        }

        for (Schema_qualified_nameContext name : obj_name) {
            addToDB(name, type);
        }
    }

    private void addToDB(Schema_qualified_nameContext name, DbObjType type) {
        if (type == null) {
            return;
        }
        List<IdentifierContext> ids = name.identifier();
        String firstPart = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        switch (type) {
        case TABLE:
            addObjReference(schemaName, firstPart, type,
                    StatementActions.NONE,
                    name.getStart().getStartIndex(), 0,
                    name.getStart().getLine());
            return;
        case SCHEMA:
            schemaName = null;
            break;
        default:
            break;
        }
        addObjReference(schemaName, firstPart, type,
                StatementActions.NONE,
                name.getStart().getStartIndex(), 0,
                name.getStart().getLine());
    }

    public void alterFunction(Alter_function_statementContext ctx) {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgFunction function = new PgFunction(QNameParser.getFirstName(ids),
                ParserAbstract.getFullCtxText(ctx.getParent()));
        ParserAbstract.fillArguments(ctx.function_parameters().function_args(), function,
                getDefSchemaName());
        addObjReference(schemaName, function.getSignature(),
                DbObjType.FUNCTION, StatementActions.ALTER,
                ctx.function_parameters().name.getStart().getStartIndex(), function.getBareName().length(),
                ctx.function_parameters().name.getStart().getLine());
    }

    public void alterSchema(Alter_schema_statementContext ctx) {
        addObjReference(null, QNameParser.getFirstName(ctx.schema_with_name().name.identifier()),
                DbObjType.SCHEMA, StatementActions.ALTER,
                ctx.schema_with_name().name.getStart().getStartIndex(), 0,
                ctx.schema_with_name().name.getStart().getLine());
    }

    public void alterTable(Alter_table_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        for (Table_actionContext tablAction : ctx.table_action()) {

            if (tablAction.owner_to() != null) {
                addObjReference(schemaName, name,
                        DbObjType.TABLE, StatementActions.ALTER,
                        ctx.name.getStart().getStartIndex(), 0,
                        ctx.name.getStart().getLine());
            } else {
                addObjReference(schemaName, name,
                        DbObjType.TABLE, StatementActions.ALTER,
                        ctx.name.getStart().getStartIndex(), 0,
                        ctx.name.getStart().getLine());
            }
            if (tablAction.tabl_constraint != null) {
                getTableConstraint(tablAction.tabl_constraint);
            }
        }
    }

    public void alterSequence(Alter_sequence_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && seqbody.col_name != null) {
                List<IdentifierContext> idsColname = seqbody.col_name.identifier();
                String tableName = QNameParser.getSecondName(idsColname);
                String schName = QNameParser.getSchemaName(idsColname, getDefSchemaName());
                int offset = 0;
                if (tableName.equals(schName)) {
                    schName = schemaName;
                } else {
                    offset = schName.length() + 1;
                    addObjReference(null, schName,
                            DbObjType.SCHEMA, StatementActions.NONE,
                            seqbody.col_name.getStart().getStartIndex(), 0,
                            seqbody.col_name.getStart().getLine());
                }
                addObjReference(schName, tableName,
                        DbObjType.TABLE, StatementActions.NONE,
                        seqbody.col_name.getStart().getStartIndex() + offset, 0,
                        seqbody.col_name.getStart().getLine());
            }
        }
        addObjReference(schemaName, QNameParser.getFirstName(ids),
                DbObjType.SEQUENCE, StatementActions.ALTER,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void alterView(Alter_view_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();

        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, QNameParser.getFirstName(ids),
                DbObjType.VIEW, StatementActions.ALTER,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void alterDomain(Alter_domain_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, QNameParser.getFirstName(ids),
                DbObjType.DOMAIN, StatementActions.ALTER,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void alterType(Alter_type_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        addObjReference(schemaName, QNameParser.getFirstName(ids),
                DbObjType.TYPE, StatementActions.ALTER,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());
    }

    public void drop(Drop_statementsContext ctx) {
        DbObjType type = null;
        if (ctx.DATABASE()!= null) {
            type = DbObjType.DATABASE;
        } else if (ctx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (ctx.EXTENSION() != null) {
            type = DbObjType.EXTENSION;
        } else if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (ctx.INDEX() != null) {
            type = DbObjType.INDEX;
        } else if (ctx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        }

        for (Schema_qualified_nameContext objName :
            ctx.if_exist_names_restrict_cascade().names_references().name) {
            List<IdentifierContext> ids = objName.identifier();
            String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());

            int offset=0;
            if (ids.size() > 1) {
                offset = schemaName.length() + 1;
                addObjReference(null, schemaName,
                        DbObjType.SCHEMA, StatementActions.NONE,
                        objName.getStart().getStartIndex(), 0,
                        objName.getStart().getLine());
            }
            addObjReference(schemaName, QNameParser.getFirstName(ids), type,
                    StatementActions.DROP,
                    objName.getStart().getStartIndex()+ offset, 0,
                    objName.getStart().getLine());
        }
    }

    public void dropTrigger(Drop_trigger_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());

        int offset = schemaName.length() + 1;
        addObjReference(null, schemaName,
                DbObjType.SCHEMA, StatementActions.NONE,
                ctx.name.getStart().getStartIndex(), 0,
                ctx.name.getStart().getLine());

        addObjReference(schemaName, QNameParser.getFirstName(ids),
                DbObjType.TRIGGER, StatementActions.DROP,
                ctx.name.getStart().getStartIndex()+ offset, 0,
                ctx.name.getStart().getLine());
    }

    public void dropFunction(Drop_function_statementContext ctx) {
        Schema_qualified_nameContext nameCtx = ctx.function_parameters().name;
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());

        int offset = 0;
        if (ids.size() > 1) {
            offset = schemaName.length() + 1;
            addObjReference(null, schemaName,
                    DbObjType.SCHEMA, StatementActions.NONE,
                    nameCtx.getStart().getStartIndex(), 0,
                    nameCtx.getStart().getLine());
        }
        PgFunction func = new PgFunction(QNameParser.getFirstName(ids), "");
        ParserAbstract.fillArguments(ctx.function_parameters().function_args(), func,
                getDefSchemaName());
        addObjReference(schemaName, func.getSignature(),
                DbObjType.FUNCTION, StatementActions.DROP,
                nameCtx.getStart().getStartIndex()+ offset, func.getBareName().length(),
                nameCtx.getStart().getLine());
    }


    /**
     * Add object with start position to db object location List
     *
     * @param obj
     * @param startIndex
     * @param LineNumber
     */
    private void fillObjDefinition(String schemaName, String objName, DbObjType objType,
            int startIndex, int nameLength, int lineNumber) {
        PgObjLocation loc = new PgObjLocation(schemaName, objName, null,
                startIndex, filePath, lineNumber);
        if (objType == DbObjType.FUNCTION) {
            loc.setObjNameLength(nameLength);
        }
        loc.setAction(StatementActions.CREATE);
        loc.setObjType(objType);
        List<PgObjLocation> defs = definitions.get(filePath);
        if (defs == null) {
            defs = new ArrayList<>();
            definitions.put(filePath, defs);
        }
        defs.add(loc);
        List<PgObjLocation> refs = references.get(filePath);
        if (refs == null) {
            refs = new ArrayList<>();
            references.put(filePath, refs);
        }
        refs.add(loc);
    }

    private PgObjLocation addObjReference(String schemaName, String objName, DbObjType objType,
            StatementActions action, int startIndex, int nameLength, int lineNumber) {
        PgObjLocation loc = new PgObjLocation(schemaName, objName, null,
                startIndex, filePath, lineNumber).setAction(action);
        if (objType == DbObjType.FUNCTION) {
            loc.setObjNameLength(nameLength);
        }
        loc.setObjType(objType);
        List<PgObjLocation> refs = references.get(filePath);
        if (refs == null) {
            refs = new ArrayList<>();
            references.put(filePath, refs);
        }
        refs.add(loc);
        return loc;
    }

    private void setCommentToDefinition(String objName, DbObjType objType, String comment) {
        for (List<PgObjLocation> locs: definitions.values()) {
            for (PgObjLocation loc : locs) {
                if (loc.getObjName().equals(objName) && loc.getObjType().equals(objType)) {
                    loc.setComment(comment);
                }
            }
        }
    }

    private void getConstraint(Table_column_defContext colCtx) {
        if (colCtx.tabl_constraint != null) {
            getTableConstraint(colCtx.tabl_constraint);
        }
    }

    private void getTableConstraint(Constraint_commonContext ctx) {
        if (ctx.constr_body().FOREIGN() != null) {
            Table_referencesContext tblRef = ctx.constr_body().table_references();
            List<IdentifierContext> ids = tblRef.reftable.identifier();
            String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
            int count = 0;
            if (ids.size() > 1) {
                count += schemaName.length() + 1;
                addObjReference(null, schemaName,
                        DbObjType.SCHEMA, StatementActions.NONE,
                        tblRef.reftable.getStart().getStartIndex(), 0,
                        tblRef.reftable.getStart().getLine());
            }
            addObjReference(schemaName, QNameParser.getFirstName(ids),
                    DbObjType.TABLE, StatementActions.NONE,
                    tblRef.reftable.getStart().getStartIndex() + count, 0,
                    tblRef.reftable.getStart().getLine());
        }
    }

    public List<FunctionBodyContainer> getFunctionBodies() {
        return funcBodies;
    }
}
