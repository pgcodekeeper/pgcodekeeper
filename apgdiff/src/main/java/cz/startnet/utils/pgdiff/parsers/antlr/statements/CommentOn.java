package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_member_objectContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractPgTable;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CommentOn extends ParserAbstract {

    private final Comment_on_statementContext ctx;

    public CommentOn(Comment_on_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Character_stringContext str = ctx.character_string();
        String comment = str == null ? null : str.getText();
        Comment_member_objectContext obj = ctx.comment_member_object();

        List<? extends ParserRuleContext> ids = null;
        if (obj.target_operator() != null) {
            Operator_nameContext operCtx = obj.target_operator().name;
            ids = Arrays.asList(operCtx.schema_name, operCtx.operator);
        } else if (obj.name != null) {
            ids = obj.name.identifier();
        } else {
            ids = Arrays.asList(obj.identifier());
        }

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();

        DbObjType type = null;

        // column (separately because of schema qualification)
        // otherwise schema reference is considered unresolved
        if (obj.COLUMN() != null) {
            if (isRefMode()) {
                return;
            }
            ParserRuleContext schemaCtx = QNameParser.getThirdNameCtx(ids);
            getSchemaNameSafe(ids);
            if (schemaCtx == null) {
                throw new UnresolvedReferenceException(
                        "Schema name is missing for commented column!", nameCtx.getStart());
            }

            AbstractSchema schema = getSafe(PgDatabase::getSchema, db, schemaCtx);
            ParserRuleContext tableCtx = QNameParser.getSecondNameCtx(ids);
            if (tableCtx == null) {
                throw new UnresolvedReferenceException(
                        "Table name is missing for commented column!", nameCtx.getStart());
            }
            String tableName = tableCtx.getText();
            AbstractPgTable table = (AbstractPgTable) schema.getTable(tableName);
            if (table == null) {
                PgView view = (PgView) schema.getView(tableName);
                if (view == null) {
                    PgType t = ((PgType) getSafe(AbstractSchema::getType, schema, tableCtx));
                    t.getAttr(name).setComment(db.getArguments(), comment);
                } else {
                    view.addColumnComment(db.getArguments(), name, comment);
                }
            } else {
                PgColumn column;
                if (table.getInherits().isEmpty()) {
                    column = (PgColumn) getSafe(AbstractTable::getColumn, table, nameCtx);
                } else {
                    String colName = nameCtx.getText();
                    column = (PgColumn) table.getColumn(colName);
                    if (column == null) {
                        column = new PgColumn(colName);
                        column.setInherit(true);
                        table.addColumn(column);
                    }
                }
                column.setComment(db.getArguments(), comment);
            }
            return;
        }

        PgStatement st = null;
        AbstractSchema schema = null;
        if (obj.table_name != null) {
            schema = getSchemaSafe(obj.table_name.identifier());
        } else if (obj.EXTENSION() == null && obj.SCHEMA() == null && obj.DATABASE() == null) {
            schema = getSchemaSafe(ids);
        }

        if (obj.function_args() != null && obj.ROUTINE() == null) {
            if (obj.PROCEDURE() != null) {
                type = DbObjType.PROCEDURE;
            } else if (obj.FUNCTION() != null) {
                type = DbObjType.FUNCTION;
            } else {
                type = DbObjType.AGGREGATE;
            }
            st = getSafe(AbstractSchema::getFunction, schema,
                    parseSignature(name, obj.function_args()), nameCtx.getStart());
        } else if (obj.OPERATOR() != null) {
            type = DbObjType.OPERATOR;
            Target_operatorContext targetOperCtx = obj.target_operator();
            st = getSafe(AbstractSchema::getOperator, schema,
                    parseSignature(targetOperCtx.name.operator.getText(),
                            targetOperCtx), targetOperCtx.getStart());
        } else if (obj.EXTENSION() != null) {
            type = DbObjType.EXTENSION;
            st = getSafe(PgDatabase::getExtension, db, nameCtx);
        } else if (obj.CONSTRAINT() != null) {
            List<IdentifierContext> parentIds = obj.table_name.identifier();
            IStatementContainer table = getSafe(AbstractSchema::getStatementContainer,
                    schema, QNameParser.getFirstNameCtx(parentIds));
            addObjReference(parentIds, DbObjType.TABLE, StatementActions.NONE);
            type = DbObjType.CONSTRAINT;
            ids = Arrays.asList(QNameParser.getSchemaNameCtx(parentIds),
                    QNameParser.getFirstNameCtx(parentIds), nameCtx);
            if (table == null) {
                PgDomain domain = getSafe(AbstractSchema::getDomain, schema, nameCtx);
                st = getSafe(PgDomain::getConstraint, domain, nameCtx);
            } else {
                st = getSafe(IStatementContainer::getConstraint, table, nameCtx);
            }
        } else if (obj.TRIGGER() != null && obj.EVENT() == null) {
            type = DbObjType.TRIGGER;
            List<IdentifierContext> parentIds = obj.table_name.identifier();
            addObjReference(parentIds, DbObjType.TABLE, StatementActions.NONE);
            ids = Arrays.asList(QNameParser.getSchemaNameCtx(parentIds),
                    QNameParser.getFirstNameCtx(parentIds), nameCtx);
            IStatementContainer c = getSafe(AbstractSchema::getStatementContainer, schema,
                    QNameParser.getFirstNameCtx(parentIds));
            st = getSafe(IStatementContainer::getTrigger, c, nameCtx);
        } else if (obj.DATABASE() != null) {
            st = db;
            type = DbObjType.DATABASE;
        } else if (obj.INDEX() != null) {

            PgStatement commentOn = getSafe((sc,n) -> sc.getStatementContainers()
                    .flatMap(c -> Stream.concat(c.getIndexes().stream(), c.getConstraints().stream()))
                    .filter(s -> s.getName().equals(n))
                    .collect(Collectors.reducing((a,b) -> b.getStatementType() == DbObjType.INDEX ? b : a))
                    .orElse(null),
                    schema, nameCtx);

            doSafe((s,c) -> s.setComment(db.getArguments(), c), commentOn, comment);

        } else if (obj.SCHEMA() != null && !ApgdiffConsts.PUBLIC.equals(name)) {
            type = DbObjType.SCHEMA;
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
        } else if (obj.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
            st = getSafe(AbstractSchema::getSequence, schema, nameCtx);
        } else if (obj.TABLE() != null) {
            type = DbObjType.TABLE;
            st = getSafe(AbstractSchema::getTable, schema, nameCtx);
        } else if (obj.VIEW() != null) {
            type = DbObjType.VIEW;
            st = getSafe(AbstractSchema::getView, schema, nameCtx);
        } else if (obj.TYPE() != null) {
            type = DbObjType.TYPE;
            st = getSafe(AbstractSchema::getType, schema, nameCtx);
        } else if (obj.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
            st = getSafe(AbstractSchema::getDomain, schema, nameCtx);
        } else if (obj.RULE() != null) {
            type = DbObjType.RULE;
            List<IdentifierContext> parentIds = obj.table_name.identifier();
            addObjReference(parentIds, DbObjType.TABLE, StatementActions.NONE);
            ids = Arrays.asList(QNameParser.getSchemaNameCtx(parentIds),
                    QNameParser.getFirstNameCtx(parentIds), nameCtx);
            IStatementContainer c = getSafe(AbstractSchema::getStatementContainer, schema,
                    QNameParser.getFirstNameCtx(obj.table_name.identifier()));
            st = getSafe(IStatementContainer::getRule, c, nameCtx);
        } else if (obj.CONFIGURATION() != null) {
            type = DbObjType.FTS_CONFIGURATION;
            st = getSafe(AbstractSchema::getFtsConfiguration, schema, nameCtx);
        } else if (obj.DICTIONARY() != null) {
            type = DbObjType.FTS_DICTIONARY;
            st = getSafe(AbstractSchema::getFtsDictionary, schema, nameCtx);
        } else if (obj.PARSER() != null) {
            type = DbObjType.FTS_PARSER;
            st = getSafe(AbstractSchema::getFtsParser, schema, nameCtx);
        } else if (obj.TEMPLATE() != null) {
            type = DbObjType.FTS_TEMPLATE;
            st = getSafe(AbstractSchema::getFtsTemplate, schema, nameCtx);
        }

        if (type != null) {
            doSafe((s,c) -> s.setComment(db.getArguments(), c), st, comment);
            PgObjLocation ref = addObjReference(ids, type, StatementActions.COMMENT);

            db.getObjDefinitions().values().stream().flatMap(Set::stream)
            .filter(ref::compare).forEach(def -> def.setComment(comment));
        }
    }
}