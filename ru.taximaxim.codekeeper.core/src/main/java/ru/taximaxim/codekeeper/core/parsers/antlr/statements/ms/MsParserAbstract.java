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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_with_orderContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Identity_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_includeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_whereContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.IStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintFk;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;

public abstract class MsParserAbstract extends ParserAbstract {

    protected MsParserAbstract(PgDatabase db) {
        super(db);
    }

    @Override
    protected DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    protected AbstractConstraint getMsPKConstraint(String schema, String table, String conName,
            Table_constraint_bodyContext body) {
        var constrPk = new MsConstraintPk(conName, body.PRIMARY() != null);
        var clusteredCtx = body.clustered();
        constrPk.setClustered(clusteredCtx != null && clusteredCtx.CLUSTERED() != null);
        var dataSpaceCtx = body.id();
        if (dataSpaceCtx != null) {
            constrPk.setDataSpace(dataSpaceCtx.getText());
        }

        fillColumns(constrPk, body.column_name_list_with_order().column_with_order(), schema, table);
        var optionsCtx = body.index_options();
        if (optionsCtx != null) {
            for (Index_optionContext option : optionsCtx.index_option()) {
                constrPk.addOption(option.key.getText(), getFullCtxText(option.index_option_value()));
            }
        }

        return constrPk;
    }

    protected void parseIndex(Index_restContext rest, AbstractIndex index, String schema, String table) {
        fillColumns(index, rest.index_sort().column_name_list_with_order().column_with_order(), null, null);
        Index_includeContext include = rest.index_include();
        if (include != null) {
            for (IdContext col : include.name_list_in_brackets().id()) {
                index.addInclude(col.getText());
                index.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
            }
        }
        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null) {
            index.setWhere(getFullCtxText(wherePart.where));
        }
        Index_optionsContext options = rest.index_options();
        if (options != null) {
            fillOptions(index, options.index_option());
        }
        IdContext tablespace = rest.id();
        if (tablespace != null) {
            index.setTablespace(MsDiffUtils.quoteName(tablespace.getText()));
        }
    }

    protected void fillOptions(IOptionContainer stmt, List<Index_optionContext> options) {
        for (Index_optionContext option : options) {
            String key = option.key.getText();
            String value = getFullCtxText(option.index_option_value());
            stmt.addOption(key, value);
        }
    }

    private void fillColumnConstraint(Column_optionContext option, MsColumn col, IStatementContainer stmt) {
        String constraintName = option.constraint != null ? option.constraint.getText() : null;
        var constraintCtx = option.column_constraint_body();
        var isTableConstr = stmt instanceof MsTable;
        if (constraintCtx.DEFAULT() != null) {
            col.setDefaultName(constraintName);
            ExpressionContext exp = constraintCtx.expression();
            col.setDefaultValue(getFullCtxText(exp));
            db.addAnalysisLauncher(
                    new MsExpressionAnalysisLauncher(!isTableConstr ? (MsType) stmt : col, exp, fileName));
        } else if (constraintCtx.PRIMARY() != null || constraintCtx.UNIQUE() != null) {
            if (constraintName == null && isTableConstr) {
                if (constraintCtx.PRIMARY() != null) {
                    constraintName = stmt.getName() + '_' + col.getName() + "_pkey";
                } else {
                    constraintName = stmt.getName() + '_' + col.getName() + "_key";
                }
            }

            var constrPk = new MsConstraintPk(constraintName, constraintCtx.PRIMARY() != null);
            var clusteredCtx = constraintCtx.clustered();
            constrPk.setClustered(clusteredCtx != null && clusteredCtx.CLUSTERED() != null);
            var dataSpaceCtx = constraintCtx.id();
            if (dataSpaceCtx != null) {
                constrPk.setDataSpace(dataSpaceCtx.getText());
            }
            var optionsCtx = constraintCtx.index_options();
            if (optionsCtx != null) {
                fillOptions(constrPk, optionsCtx.index_option());
            }
            var columns = constraintCtx.column_name_list_with_order();
            if (columns == null) {
                constrPk.addColumn(new SimpleColumn(col.getName()));
            } else {
                fillColumns(constrPk, columns.column_with_order(), null, null);
            }

            stmt.addChild(constrPk);
        } else if (constraintCtx.REFERENCES() != null) {
            if (constraintName == null) {
                constraintName = stmt.getName() + '_' + col.getName() + "_fkey";
            }

            var constrFk = new MsConstraintFk(constraintName);
            constrFk.addColumn(col.getName());
            Qualified_nameContext ref = constraintCtx.qualified_name();
            List<IdContext> ids = Arrays.asList(ref.schema, ref.name);
            String fSchemaName = getSchemaNameSafe(ids);
            String fTableName = QNameParser.getFirstName(ids);
            PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);
            GenericColumn fTable = loc.getObj();
            constrFk.addDep(fTable);
            constrFk.setForeignSchema(fSchemaName);
            constrFk.setForeignTable(fTableName);

            IdContext column = constraintCtx.id();
            if (column != null) {
                String colFk = column.getText();
                constrFk.addForeignColumn(colFk);
                constrFk.addDep(new GenericColumn(fSchemaName, fTableName, colFk, DbObjType.COLUMN));
            }
            var del = constraintCtx.on_delete();
            if (del != null) {
                if (del.CASCADE() != null) {
                    constrFk.setDelAction("CASCADE");
                } else if (del.NULL() != null) {
                    constrFk.setDelAction("SET NULL");
                } else if (del.DEFAULT() != null) {
                    constrFk.setDelAction("SET DEFAULT");
                }
            }
            var upd = constraintCtx.on_update();
            if (upd != null) {
                if (upd.CASCADE() != null) {
                    constrFk.setUpdAction("CASCADE");
                } else if (upd.NULL() != null) {
                    constrFk.setUpdAction("SET NULL");
                } else if (upd.DEFAULT() != null) {
                    constrFk.setUpdAction("SET DEFAULT");
                }
            }
            if (constraintCtx.not_for_replication() != null) {
                constrFk.setNotForRepl(true);
            }

            stmt.addChild(constrFk);
        } else if (constraintCtx.CHECK() != null) {
            if (constraintName == null && isTableConstr) {
                constraintName = stmt.getName() + '_' + col.getName() + "_check";
            }

            var constrCheck = new MsConstraintCheck(constraintName);
            constrCheck.setNotForRepl(constraintCtx.not_for_replication() != null);
            constrCheck.setExpression(getFullCtxText(constraintCtx.search_condition()));

            stmt.addChild(constrCheck);
        }
    }

    protected void fillColumnOption(Column_optionContext option, MsColumn col, IStatementContainer stmt) {
        if (option.SPARSE() != null) {
            col.setSparse(true);
        } else if (option.COLLATE() != null) {
            col.setCollation(getFullCtxText(option.collate));
        } else if (option.PERSISTED() != null) {
            col.setPersisted(true);
        } else if (option.ROWGUIDCOL() != null) {
            col.setRowGuidCol(true);
        } else if (option.IDENTITY() != null) {
            Identity_valueContext identity = option.identity_value();
            if (identity == null) {
                col.setIdentity("1", "1");
            } else {
                col.setIdentity(identity.seed.getText(), identity.increment.getText());
            }
            if (option.not_for_rep != null) {
                col.setNotForRep(true);
            }
        } else if (option.MASKED() != null) {
            col.setMaskingFunction(option.STRING().getText());
        } else if (option.NULL() != null) {
            col.setNullValue(option.NOT() == null);
        } else if (option.column_constraint_body() != null) {
            fillColumnConstraint(option, col, stmt);
        } else if (option.INDEX() != null) {
            var index = new MsIndex(option.index.getText());
            var isTableIndex = stmt instanceof MsTable;
            index.setClustered(option.clustered() != null && option.clustered().CLUSTERED() != null);

            if (option.index_sort() == null) {
                index.addColumn(new SimpleColumn(col.getName()));
            } else {
                fillColumns(index, option.index_sort().column_name_list_with_order().column_with_order(), null, null);
            }

            if (option.index_options() != null) {
                fillOptions(index, option.index_options().index_option());
            }

            if (option.file_group_name != null) {
                index.setTablespace(MsDiffUtils.quoteName(option.file_group_name.getText()));
            } else if (isTableIndex && ((MsTable) stmt).getTablespace() != null) {
                index.setTablespace(((MsTable) stmt).getTablespace());
            }

            if (option.index_where() != null) {
                index.setWhere(getFullCtxText(option.index_where().where));
            }
            stmt.addChild(index);
        }
    }

    protected void fillColumns(ISimpleColumnContainer stmt, List<Column_with_orderContext> cols, String schema,
            String table) {
        SimpleColumn simpCol;
        for (var col : cols) {
            var name = col.id().getText();
            simpCol = new SimpleColumn(name);
            var orderCtx = col.asc_desc();
            simpCol.setDesc(orderCtx != null && orderCtx.DESC() != null);
            stmt.addColumn(simpCol);
            if (schema != null && table != null) {
                ((PgStatement) stmt).addDep(new GenericColumn(schema, table, name, DbObjType.COLUMN));
            }
        }
    }

    protected void addTypeDepcy(Data_typeContext ctx, PgStatement st) {
        Qualified_nameContext qname = ctx.qualified_name();
        if (qname != null && qname.schema != null) {
            addDepSafe(st, Arrays.asList(qname.schema, qname.name), DbObjType.TYPE);
        }
    }

    protected List<ParserRuleContext> getIdentifiers(Qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(2);
        ParserRuleContext schemaRule = qNameCtx.schema;
        if (schemaRule != null) {
            ids.add(schemaRule);
        }
        ids.add(qNameCtx.name);
        return ids;
    }

}
