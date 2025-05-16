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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Drop_backward_compatible_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Drop_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Drop_statementsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_dropContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.core.utils.Pair;

public final class DropMsStatement extends MsParserAbstract {

    private final Schema_dropContext ctx;

    public DropMsStatement(Schema_dropContext ctx, MsDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.drop_assembly() != null) {
            for (IdContext id : ctx.drop_assembly().name_list().id()) {
                addObjReference(Arrays.asList(id), DbObjType.ASSEMBLY, ACTION_DROP);
            }
        } else if (ctx.drop_index() != null) {
            for (Index_nameContext ind : ctx.drop_index().index_name()) {
                Qualified_nameContext tableIds = ind.qualified_name();
                IdContext schemaCtx = tableIds.schema;
                IdContext nameCtx = ind.id();
                addObjReference(Arrays.asList(schemaCtx, tableIds.name),
                        DbObjType.TABLE, null);
                addObjReference(Arrays.asList(schemaCtx, nameCtx),
                        DbObjType.INDEX, ACTION_DROP);
            }
        } else if (ctx.drop_statements() != null) {
            drop(ctx.drop_statements());
        }
    }

    private void drop(Drop_statementsContext ctx) {
        DbObjType type = null;
        if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.ROLE() != null) {
            type = DbObjType.ROLE;
        } else if (ctx.USER() != null) {
            type = DbObjType.USER;
        }

        if (type != null) {
            for (Qualified_nameContext qname : ctx.names_references().name) {
                addObjReference(Arrays.asList(qname.name), type, ACTION_DROP);
            }
            return;
        }

        if (ctx.TRIGGER() != null) {
            for (Qualified_nameContext qname : ctx.names_references().name) {
                // TODO ref to table, need ctx
                addObjReference(Arrays.asList(qname.schema, null, qname.name),
                        DbObjType.TRIGGER, ACTION_DROP);
            }
            return;
        }

        if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null || ctx.PROC() != null) {
            type = DbObjType.PROCEDURE;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        }

        if (type != null) {
            for (Qualified_nameContext qname : ctx.names_references().name) {
                List<ParserRuleContext> ids = Arrays.asList(qname.schema, qname.name);
                PgObjLocation ref = addObjReference(ids, type, ACTION_DROP);
                if (type == DbObjType.TABLE) {
                    ref.setWarning(DangerStatement.DROP_TABLE);
                }
            }
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Drop_statementsContext dropSt = ((Schema_dropContext) ctx).drop_statements();
        if (dropSt != null && dropSt.TABLE() != null) {
            loc.setWarning(DangerStatement.DROP_TABLE);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = null;
        List<IdContext> ids = null;
        if (ctx.drop_assembly() != null) {
            ids = ctx.drop_assembly().name_list().id();
            type = DbObjType.ASSEMBLY;
        } else if (ctx.drop_index() != null) {
            Drop_indexContext dropIdxCtx = ctx.drop_index();
            List<Index_nameContext> indicesRel = dropIdxCtx.index_name();
            if (indicesRel != null && !indicesRel.isEmpty() && indicesRel.size() == 1) {
                ids = Arrays.asList(indicesRel.get(0).id());
            } else {
                List<Drop_backward_compatible_indexContext> indicesBack = dropIdxCtx
                        .drop_backward_compatible_index();
                if (indicesBack != null && !indicesBack.isEmpty() && indicesBack.size() == 1) {
                    ids = Arrays.asList(indicesBack.get(0).index);
                } else {
                    ids = Collections.emptyList();
                }
            }
            type = DbObjType.INDEX;
        } else if (ctx.drop_statements() != null) {
            Pair<DbObjType, List<IdContext>> typeAndQName = dropStmt(ctx.drop_statements());
            if (typeAndQName != null) {
                type = typeAndQName.getFirst();
                ids = typeAndQName.getSecond();
            }
        }
        return type != null && ids != null ? getStrForStmtAction(ACTION_DROP, type, ids) : null;
    }

    private Pair<DbObjType, List<IdContext>> dropStmt(Drop_statementsContext dropStmtCtx) {
        DbObjType type = null;

        if (dropStmtCtx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (dropStmtCtx.ROLE() != null) {
            type = DbObjType.ROLE;
        } else if (dropStmtCtx.USER() != null) {
            type = DbObjType.USER;
        } else if (dropStmtCtx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (dropStmtCtx.PROCEDURE() != null || dropStmtCtx.PROC() != null) {
            type = DbObjType.PROCEDURE;
        } else if (dropStmtCtx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (dropStmtCtx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (dropStmtCtx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (dropStmtCtx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (dropStmtCtx.TRIGGER() != null) {
            type = DbObjType.TRIGGER;
        }

        if (type != null) {
            List<Qualified_nameContext> qnames = dropStmtCtx.names_references().name;
            return new Pair<>(type, qnames.size() == 1 ? qnames.get(0).id() : null);
        }

        return null;
    }
}