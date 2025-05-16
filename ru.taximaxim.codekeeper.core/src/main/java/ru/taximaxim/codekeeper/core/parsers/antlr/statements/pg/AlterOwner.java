/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class AlterOwner extends PgParserAbstract {

    private final Alter_owner_statementContext ctx;
    private final Map<PgStatement, StatementOverride> overrides;

    public AlterOwner(Alter_owner_statementContext ctx, PgDatabase db, ISettings settings) {
        this(ctx, db, null, settings);
    }

    public AlterOwner(Alter_owner_statementContext ctx, PgDatabase db,
            Map<PgStatement, StatementOverride> overrides, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
        this.overrides = overrides;
    }

    @Override
    public void parseObject() {
        if (settings.isIgnorePrivileges()) {
            return;
        }

        IdentifierContext name = ctx.owner_to().user_name().identifier();
        if (name == null) {
            return;
        }

        var objCtx = ctx.owner_member_object();

        List<ParserRuleContext> ids;
        if (objCtx.name != null) {
            ids = getIdentifiers(objCtx.name);
        } else if (objCtx.OPERATOR() != null) {
            ids = getIdentifiers(objCtx.target_operator().name);
        } else {
            return;
        }

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);

        DbObjType type = null;
        PgStatement st = null;
        if (objCtx.SCHEMA() != null) {
            st = getSafe(PgDatabase::getSchema, db, nameCtx);
            type = DbObjType.SCHEMA;
        } else if (objCtx.WRAPPER() != null) {
            st = getSafe(PgDatabase::getForeignDW, db, nameCtx);
            type = DbObjType.FOREIGN_DATA_WRAPPER;
        } else if (objCtx.SERVER() != null) {
            st = getSafe(PgDatabase::getServer, db, nameCtx);
            type = DbObjType.SERVER;
        } else if (objCtx.EVENT() != null) {
            st = getSafe(PgDatabase::getEventTrigger, db, nameCtx);
            type = DbObjType.EVENT_TRIGGER;
        } else {
            PgSchema schema = getSchemaSafe(ids);
            if (objCtx.DOMAIN() != null) {
                st = getSafe(PgSchema::getDomain, schema, nameCtx);
                type = DbObjType.DOMAIN;
            } else if (objCtx.VIEW() != null) {
                st = getSafe(PgSchema::getView, schema, nameCtx);
                type = DbObjType.VIEW;
            } else if (objCtx.STATISTICS() != null) {
                st = getSafe(PgSchema::getStatistics, schema, nameCtx);
                type = DbObjType.STATISTICS;
            } else if (objCtx.DICTIONARY() != null) {
                st = getSafe(PgSchema::getFtsDictionary, schema, nameCtx);
                type = DbObjType.FTS_DICTIONARY;
            } else if (objCtx.CONFIGURATION() != null) {
                st = getSafe(PgSchema::getFtsConfiguration, schema, nameCtx);
                type = DbObjType.FTS_CONFIGURATION;
            } else if (objCtx.SEQUENCE() != null) {
                st = getSafe(PgSchema::getSequence, schema, nameCtx);
                type = DbObjType.SEQUENCE;
            } else if (objCtx.TYPE() != null) {
                st = getSafe(PgSchema::getType, schema, nameCtx);
                type = DbObjType.TYPE;
            } else if (objCtx.COLLATION() != null) {
                st = getSafe(PgSchema::getCollation, schema, nameCtx);
                type = DbObjType.COLLATION;
            } else if (objCtx.OPERATOR() != null) {
                st = getSafe(PgSchema::getOperator, schema,
                        parseOperatorSignature(nameCtx.getText(), objCtx.target_operator().operator_args()),
                        nameCtx.getStart());
                type = DbObjType.OPERATOR;
            } else if (objCtx.PROCEDURE() != null || objCtx.FUNCTION() != null || objCtx.AGGREGATE() != null) {
                st = getSafe(PgSchema::getFunction, schema, parseSignature(nameCtx.getText(),
                        objCtx.function_args()), nameCtx.getStart());
                if (objCtx.FUNCTION() != null) {
                    type = DbObjType.FUNCTION;
                } else if (objCtx.PROCEDURE() != null) {
                    type = DbObjType.PROCEDURE;
                } else {
                    type = DbObjType.AGGREGATE;
                }
            }
        }

        if (type != null) {
            if (type.in(DbObjType.FUNCTION, DbObjType.PROCEDURE, DbObjType.AGGREGATE)) {
                addObjReference(ids, type, ACTION_ALTER, parseArguments(objCtx.function_args()));
            } else {
                addObjReference(ids, type, ACTION_ALTER);
            }
        }

        if (st == null || (type == DbObjType.SCHEMA
                && Consts.PUBLIC.equals(nameCtx.getText()) && "postgres".equals(name.getText()))) {
            return;
        }

        setOwner(st, name);
    }

    private void setOwner(PgStatement st, IdentifierContext owner) {
        if (overrides == null) {
            fillOwnerTo(owner, st);
        } else {
            overrides.computeIfAbsent(st, k -> new StatementOverride()).setOwner(owner.getText());
        }
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = null;
        var objCtx = ctx.owner_member_object();
        if (objCtx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (objCtx.WRAPPER() != null) {
            type = DbObjType.FOREIGN_DATA_WRAPPER;
        } else if (objCtx.SERVER() != null) {
            type = DbObjType.SERVER;
        } else if (objCtx.EVENT() != null) {
            type = DbObjType.EVENT_TRIGGER;
        } else if (objCtx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (objCtx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (objCtx.DICTIONARY() != null) {
            type = DbObjType.FTS_DICTIONARY;
        } else if (objCtx.CONFIGURATION() != null) {
            type = DbObjType.FTS_CONFIGURATION;
        } else if (objCtx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (objCtx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (objCtx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (objCtx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else if (objCtx.AGGREGATE() != null) {
            type = DbObjType.AGGREGATE;
        } else if (objCtx.OPERATOR() != null) {
            type = DbObjType.OPERATOR;
        } else if (objCtx.COLLATION() != null) {
            type = DbObjType.COLLATION;
        } else {
            return null;
        }

        Target_operatorContext targetOperCtx;
        List<ParserRuleContext> ids;
        if (objCtx.name != null) {
            ids = getIdentifiers(objCtx.name);
        } else if ((targetOperCtx = objCtx.target_operator()) != null) {
            ids = getIdentifiers(targetOperCtx.name);
        } else {
            return null;
        }

        return getStrForStmtAction(ACTION_ALTER, type, ids);
    }
}
