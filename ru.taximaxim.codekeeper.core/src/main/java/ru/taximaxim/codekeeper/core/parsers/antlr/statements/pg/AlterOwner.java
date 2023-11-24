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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_owner_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Target_operatorContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;

public class AlterOwner extends ParserAbstract {

    private final Alter_owner_statementContext ctx;
    private final Map<PgStatement, StatementOverride> overrides;

    public AlterOwner(Alter_owner_statementContext ctx, PgDatabase db) {
        this(ctx, db, null);
    }

    public AlterOwner(Alter_owner_statementContext ctx, PgDatabase db,
            Map<PgStatement, StatementOverride> overrides) {
        super(db);
        this.ctx = ctx;
        this.overrides = overrides;
    }

    @Override
    public void parseObject() {
        if (db.getArguments().isIgnorePrivileges()) {
            return;
        }

        IdentifierContext name = ctx.owner_to().user_name().identifier();
        if (name == null) {
            return;
        }

        List<ParserRuleContext> ids;
        if (ctx.OPERATOR() != null) {
            ids = getIdentifiers(ctx.target_operator().name);
        } else {
            ids = getIdentifiers(ctx.name);
        }

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);

        DbObjType type = null;
        PgStatement st = null;
        if (ctx.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
            type = DbObjType.SCHEMA;
        } else if (ctx.FOREIGN() != null && ctx.DATA() != null && ctx.WRAPPER() != null) {
            st = getSafe(PgDatabase::getForeignDW, db, nameCtx);
            type = DbObjType.FOREIGN_DATA_WRAPPER;
        } else if (ctx.SERVER() != null) {
            st = getSafe(PgDatabase::getServer, db, nameCtx);
            type = DbObjType.SERVER;
        } else if (ctx.EVENT() != null) {
            st = getSafe(PgDatabase::getEventTrigger, db, nameCtx);
            type = DbObjType.EVENT_TRIGGER;
        } else {
            AbstractSchema schema = getSchemaSafe(ids);
            if (ctx.DOMAIN() != null) {
                st = getSafe(AbstractSchema::getDomain, schema, nameCtx);
                type = DbObjType.DOMAIN;
            } else if (ctx.VIEW() != null) {
                st = getSafe(AbstractSchema::getView, schema, nameCtx);
                type = DbObjType.VIEW;
            } else if (ctx.DICTIONARY() != null) {
                st = getSafe(AbstractSchema::getFtsDictionary, schema, nameCtx);
                type = DbObjType.FTS_DICTIONARY;
            } else if (ctx.CONFIGURATION() != null) {
                st = getSafe(AbstractSchema::getFtsConfiguration, schema, nameCtx);
                type = DbObjType.FTS_CONFIGURATION;
            } else if (ctx.SEQUENCE() != null) {
                st = getSafe(AbstractSchema::getSequence, schema, nameCtx);
                type = DbObjType.SEQUENCE;
            } else if (ctx.TYPE() != null) {
                st = getSafe(AbstractSchema::getType, schema, nameCtx);
                type = DbObjType.TYPE;
            } else if (ctx.COLLATION() != null) {
                st = getSafe(AbstractSchema::getCollation, schema, nameCtx);
                type = DbObjType.COLLATION;
            } else if (ctx.OPERATOR() != null) {
                st = getSafe(AbstractSchema::getOperator, schema,
                        parseSignature(nameCtx.getText(), ctx.target_operator()),
                        nameCtx.getStart());
                type = DbObjType.OPERATOR;
            } else if (ctx.PROCEDURE() != null || ctx.FUNCTION() != null || ctx.AGGREGATE() != null) {
                st = getSafe(AbstractSchema::getFunction, schema, parseSignature(nameCtx.getText(),
                        ctx.function_args()), nameCtx.getStart());
                if (ctx.FUNCTION() != null) {
                    type = DbObjType.FUNCTION;
                } else if (ctx.PROCEDURE() != null) {
                    type = DbObjType.PROCEDURE;
                } else {
                    type = DbObjType.AGGREGATE;
                }
            }
        }

        if (type != null) {
            if (type == DbObjType.FUNCTION || type == DbObjType.PROCEDURE || type == DbObjType.AGGREGATE) {
                addObjReference(ids, type, ACTION_ALTER,
                        parseArguments(ctx.function_args()));
            } else {
                addObjReference(ids, type, ACTION_ALTER);
            }
        }

        if (st == null || (type == DbObjType.SCHEMA
                && Consts.PUBLIC.equals(nameCtx.getText())
                && "postgres".equals(name.getText()))) {
            return;
        }

        setOwner(st, name);
    }

    private void setOwner(PgStatement st, IdentifierContext owner) {
        if (overrides == null) {
            fillOwnerTo(owner, st);
        } else {
            overrides.computeIfAbsent(st,
                    k -> new StatementOverride())
                .setOwner(owner.getText());
        }
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = null;
        if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.FOREIGN() != null && ctx.DATA() != null && ctx.WRAPPER() != null) {
            type = DbObjType.FOREIGN_DATA_WRAPPER;
        } else if (ctx.SERVER() != null) {
            type = DbObjType.SERVER;
        } else if (ctx.EVENT() != null) {
            type = DbObjType.EVENT_TRIGGER;
        } else if (ctx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (ctx.DICTIONARY() != null) {
            type = DbObjType.FTS_DICTIONARY;
        } else if (ctx.CONFIGURATION() != null) {
            type = DbObjType.FTS_CONFIGURATION;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else if (ctx.AGGREGATE() != null) {
            type = DbObjType.AGGREGATE;
        } else if (ctx.OPERATOR() != null) {
            type = DbObjType.OPERATOR;
        } else if (ctx.COLLATION() != null) {
            type = DbObjType.COLLATION;
        } else {
            return null;
        }

        Target_operatorContext targetOperCtx;
        List<ParserRuleContext> ids;
        if (ctx.name != null) {
            ids = getIdentifiers(ctx.name);
        } else if ((targetOperCtx = ctx.target_operator()) != null) {
            ids = getIdentifiers(targetOperCtx.name);
        } else {
            return null;
        }

        return getStrForStmtAction(ACTION_ALTER, type, ids);
    }
}
