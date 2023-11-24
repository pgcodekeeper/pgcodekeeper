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

import java.util.Arrays;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_with_orderContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_includeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_sortContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_whereContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Name_list_in_bracketsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintFk;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;

public abstract class MsTableAbstract extends ParserAbstract {

    protected MsTableAbstract(PgDatabase db) {
        super(db);
    }

    protected AbstractConstraint getMsConstraint(Table_constraintContext conCtx,
            String schema, String table) {
        String conName = conCtx.id() == null ? "" : conCtx.id().getText();
        Table_constraint_bodyContext body = conCtx.table_constraint_body();
        if (body.REFERENCES() != null) {
            return getMsFKConstraint(schema, table, conName, body);
        }
        if (body.PRIMARY() != null || body.UNIQUE() != null) {
            return getMsPKConstraint(schema, table, conName, body);
        }
        if (body.CHECK() != null) {
            return getMsCheckConstraint(conName, body);
        }

        return null;
    }

    private AbstractConstraint getMsFKConstraint(String schema, String table, String conName,
            Table_constraint_bodyContext body) {
        var constrFk = new MsConstraintFk(conName);

        var cols = body.fk;
        for (var col : cols.id()) {
            constrFk.addColumn(col.getText());
            constrFk.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
        }

        Qualified_nameContext ref = body.qualified_name();
        List<IdContext> ids = Arrays.asList(ref.schema, ref.name);
        PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);
        constrFk.addDep(loc.getObj());


        Name_list_in_bracketsContext columns = body.pk;
        String fSchemaName = getSchemaNameSafe(ids);
        String fTableName = ref.name.getText();
        constrFk.setForeignSchema(fSchemaName);
        constrFk.setForeignTable(fTableName);
        if (columns != null) {
            for (IdContext column : columns.id()) {
                String fCol = column.getText();
                constrFk.addForeignColumn(fCol);
                constrFk.addDep(new GenericColumn(fSchemaName, fTableName, fCol, DbObjType.COLUMN));
            }
        }

        var del = body.on_delete();
        if (del != null) {
            if (del.CASCADE() != null) {
                constrFk.setDelAction("CASCADE");
            } else if (del.NULL() != null) {
                constrFk.setDelAction("SET NULL");
            } else if (del.DEFAULT() != null) {
                constrFk.setDelAction("SET DEFAULT");
            }
        }

        var upd = body.on_update();
        if (upd != null) {
            if (upd.CASCADE() != null) {
                constrFk.setUpdAction("CASCADE");
            } else if (upd.NULL() != null) {
                constrFk.setUpdAction("SET NULL");
            } else if (upd.DEFAULT() != null) {
                constrFk.setUpdAction("SET DEFAULT");
            }
        }

        if (body.not_for_replication() != null) {
            constrFk.setNotForRepl(true);
        }

        return constrFk;
    }

    private AbstractConstraint getMsPKConstraint(String schema, String table, String conName,
            Table_constraint_bodyContext body) {
        var constrPk = new MsConstraintPk(conName, body.PRIMARY() != null);
        var clusteredCtx = body.clustered();
        constrPk.setClustered(clusteredCtx != null && clusteredCtx.CLUSTERED() != null);
        var dataSpaceCtx = body.id();
        if (dataSpaceCtx != null) {
            constrPk.setDataSpace(dataSpaceCtx.getText());
        }
        for (var columnWithOrder : body.column_name_list_with_order().column_with_order()) {
            String colName = columnWithOrder.id().getText();
            var order = columnWithOrder.asc_desc();
            boolean isDesc = order != null && order.DESC() != null;
            SimpleColumn col = new SimpleColumn(colName);
            col.setDesc(isDesc);
            constrPk.addColumn(colName, col);
            constrPk.addDep(new GenericColumn(schema, table, colName, DbObjType.COLUMN));
        }
        var optionsCtx = body.index_options();
        if (optionsCtx != null) {
            for (Index_optionContext option : optionsCtx.index_option()) {
                constrPk.addOption(option.key.getText(), getFullCtxText(option.index_option_value()));
            }
        }

        return constrPk;
    }

    private AbstractConstraint getMsCheckConstraint(String conName, Table_constraint_bodyContext body) {
        var constrCheck = new MsConstraintCheck(conName);
        constrCheck.setNotForRepl(body.not_for_replication() != null);
        constrCheck.setExpression(getFullCtxText(body.search_condition()));
        return constrCheck;
    }

    protected void parseIndex(Index_restContext rest, AbstractIndex ind, String schema, String table) {
        Index_sortContext sort = rest.index_sort();
        for (Column_with_orderContext col : sort.column_name_list_with_order().column_with_order()) {
            IdContext colCtx = col.id();
            ind.addColumn(colCtx.getText());
            ind.addDep(new GenericColumn(schema, table, colCtx.getText(), DbObjType.COLUMN));
        }

        ind.setDefinition(getFullCtxText(sort));

        Index_includeContext include = rest.index_include();
        if (include != null) {
            for (IdContext col : include.name_list_in_brackets().id()) {
                ind.addInclude(col.getText());
                ind.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
            }
        }

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getFullCtxText(wherePart.where));
        }

        Index_optionsContext options = rest.index_options();
        if (options != null) {
            for (Index_optionContext option : options.index_option()) {
                String key = option.key.getText();
                if (!key.equalsIgnoreCase("ONLINE")) {
                    String value = option.index_option_value().getText();
                    ind.addOption(key, value);
                }
            }
        }

        IdContext tablespace = rest.id();
        if (tablespace != null) {
            ind.setTablespace(tablespace.getText());
        }
    }
}
