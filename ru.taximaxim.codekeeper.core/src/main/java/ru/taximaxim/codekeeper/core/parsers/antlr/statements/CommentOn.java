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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Cast_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Comment_member_objectContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Comment_on_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Target_operatorContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgCompositeType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgDomain;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgView;

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

        List<ParserRuleContext> ids = null;
        if (obj.target_operator() != null) {
            ids = getIdentifiers(obj.target_operator().name);
        } else if (obj.name != null) {
            ids = getIdentifiers(obj.name);
        } else if (obj.cast_name() != null) {
            ids = Arrays.asList(obj.cast_name());
        } else {
            ids = Arrays.asList(obj.identifier());
        }

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();

        // column (separately because of non-real columns)
        if (obj.COLUMN() != null) {
            addObjReference(ids, DbObjType.COLUMN, ACTION_COMMENT);

            if (isRefMode()) {
                return;
            }

            List<? extends ParserRuleContext> tableIds = ids.subList(0, 2);
            AbstractSchema schema = getSchemaSafe(tableIds);

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
                    PgCompositeType t = ((PgCompositeType) getSafe(AbstractSchema::getType, schema, tableCtx));
                    addObjReference(tableIds, DbObjType.TYPE, null);
                    t.getAttr(name).setComment(db.getArguments(), comment);
                } else {
                    addObjReference(tableIds, DbObjType.VIEW, null);
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
                addObjReference(tableIds, DbObjType.TABLE, null);
                column.setComment(db.getArguments(), comment);
            }
            return;
        }

        AbstractSchema schema = null;
        if (obj.table_name != null) {
            schema = getSchemaSafe(getIdentifiers(obj.table_name));
        } else if (obj.EXTENSION() == null && obj.SCHEMA() == null && obj.DATABASE() == null
                && obj.CAST() == null && obj.SERVER() == null
                && (obj.DATA() == null || obj.WRAPPER() == null) && obj.EVENT() == null) {
            schema = getSchemaSafe(ids);
        }

        PgStatement st;
        DbObjType type;
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
                    parseSignature(nameCtx.getText(), targetOperCtx),
                    nameCtx.getStart());
        } else if (obj.EXTENSION() != null) {
            type = DbObjType.EXTENSION;
            st = getSafe(PgDatabase::getExtension, db, nameCtx);
        } else if (obj.EVENT() != null) {
            type = DbObjType.EVENT_TRIGGER;
            st = getSafe(PgDatabase::getEventTrigger, db, nameCtx);
        } else if (obj.FOREIGN() != null && obj.DATA() != null && obj.WRAPPER() != null) {
            type = DbObjType.FOREIGN_DATA_WRAPPER;
            st = getSafe(PgDatabase::getForeignDW, db, nameCtx);
        } else if (obj.SERVER() != null) {
            type = DbObjType.SERVER;
            st = getSafe(PgDatabase::getServer, db, nameCtx);
        } else if (obj.CONSTRAINT() != null) {
            List<ParserRuleContext> parentIds = getIdentifiers(obj.table_name);
            ParserRuleContext parentCtx = QNameParser.getFirstNameCtx(parentIds);
            type = DbObjType.CONSTRAINT;
            if (obj.DOMAIN() != null) {
                addObjReference(parentIds, DbObjType.DOMAIN, null);
                PgDomain domain = getSafe(AbstractSchema::getDomain, schema, parentCtx);
                st = getSafe(PgDomain::getConstraint, domain, nameCtx);
            } else {
                addObjReference(parentIds, DbObjType.TABLE, null);
                PgStatementContainer table = getSafe(AbstractSchema::getStatementContainer, schema, parentCtx);
                st = getSafe(PgStatementContainer::getConstraint, table, nameCtx);
            }
            ids = Arrays.asList(QNameParser.getSchemaNameCtx(parentIds), parentCtx, nameCtx);
        } else if (obj.CAST() != null) {
            Cast_nameContext castNameCtx = obj.cast_name();
            st = getSafe(PgDatabase::getCast, db, getCastName(castNameCtx), castNameCtx.getStart());
            type = DbObjType.CAST;
        } else if (obj.DATABASE() != null) {
            st = db;
            type = DbObjType.DATABASE;
        } else if (obj.INDEX() != null) {
            type = DbObjType.INDEX;
            st = getSafe((sc, n) -> sc.getStatementContainers()
                .flatMap(c -> Stream.concat(c.getIndexes().stream(), c.getConstraints().stream()))
                .filter(s -> s.getName().equals(n))
                .collect(Collectors.reducing((a, b) -> b.getStatementType() == DbObjType.INDEX ? b : a))
                .orElse(null),
                    schema, nameCtx);
        } else if (obj.SCHEMA() != null && !Consts.PUBLIC.equals(name)) {
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
        } else if (obj.COLLATION() != null) {
            type = DbObjType.COLLATION;
            st = getSafe(AbstractSchema::getCollation, schema, nameCtx);
        } else if ((obj.TRIGGER() != null && obj.EVENT() == null)
                || obj.POLICY() != null || obj.RULE() != null) {
            List<ParserRuleContext> parentIds = getIdentifiers(obj.table_name);
            addObjReference(parentIds, DbObjType.TABLE, null);
            ParserRuleContext tableCtx = QNameParser.getFirstNameCtx(parentIds);
            ids = Arrays.asList(QNameParser.getSchemaNameCtx(parentIds), tableCtx, nameCtx);
            PgStatementContainer c = getSafe(AbstractSchema::getStatementContainer, schema, tableCtx);
            if (obj.POLICY() != null) {
                type = DbObjType.POLICY;
                st = getSafe(PgStatementContainer::getPolicy, c, nameCtx);
            } else if (obj.RULE() != null) {
                type = DbObjType.RULE;
                st = getSafe(PgStatementContainer::getRule, c, nameCtx);
            } else {
                type = DbObjType.TRIGGER;
                st = getSafe(PgStatementContainer::getTrigger, c, nameCtx);
            }
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
        } else {
            addOutlineRefForCommentOrRule(ACTION_COMMENT, ctx);
            return;
        }

        doSafe((s, c) -> s.setComment(db.getArguments(), c), st, comment);
        if (type == DbObjType.FUNCTION || type == DbObjType.PROCEDURE || type == DbObjType.AGGREGATE) {
            addObjReference(ids, type, ACTION_ALTER,
                    parseArguments(obj.function_args()));
        } else {
            addObjReference(ids, type, ACTION_COMMENT);
        }

    }

    @Override
    protected String getStmtAction() {
        return null;
    }
}
