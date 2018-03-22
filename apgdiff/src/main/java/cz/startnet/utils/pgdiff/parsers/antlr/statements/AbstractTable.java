package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Common_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.List_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_unique_prkeyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractTable extends ParserAbstract {

    public AbstractTable(PgDatabase db) {
        super(db);
    }

    protected void fillTypeColumns(List_of_type_column_defContext columns,
            PgTable table, String schemaName) {
        if (columns == null) {
            return;
        }
        for (Table_of_type_column_defContext colCtx : columns.table_col_def) {
            if (colCtx.tabl_constraint != null) {
                addTableConstraint(colCtx.tabl_constraint, table);
            } else if (colCtx.table_of_type_column_definition() != null) {
                Table_of_type_column_definitionContext column = colCtx.table_of_type_column_definition();
                addColumn(column.column_name.getText(), column.colmn_constraint, table);
            }
        }
    }

    protected void addTableConstraint(Constraint_commonContext tblConstrCtx,
            PgTable table) {
        PgConstraint constrBlank = createTableConstraintBlank(tblConstrCtx);
        processTableConstraintBlank(tblConstrCtx, constrBlank, db);
        table.addConstraint(constrBlank);
    }

    private void addTableConstraint(Constraint_commonContext ctx,
            PgColumn col, PgTable table) {

        Constr_bodyContext body = ctx.constr_body();
        Common_constraintContext comConstr = body.common_constraint();
        Table_unique_prkeyContext prkey = body.table_unique_prkey();
        PgConstraint constr = null;
        String colName = col.getName();

        VexContext def = body.default_expr;
        if (def != null) {
            col.setDefaultValue(getFullCtxText(def));
            db.getContextsForAnalyze().add(new SimpleEntry<>(col, def));
        } else if (comConstr != null && comConstr.null_value != null) {
            col.setNullValue(comConstr.null_false == null);
        } else if (ctx.constr_body().table_references() != null) {
            Table_referencesContext tblRef = ctx.constr_body().table_references();
            List<IdentifierContext> ids = tblRef.reftable.identifier();
            String refTableName = QNameParser.getFirstName(ids);
            String refSchemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
            GenericColumn ftable = new GenericColumn(refSchemaName, refTableName, DbObjType.TABLE);
            String constrName = ctx.constraint_name == null ?
                    table.getName() + '_' + colName + "_fkey" : ctx.constraint_name.getText();

            constr = new PgConstraint(constrName, getFullCtxText(ctx));
            constr.setForeignTable(ftable);

            String fColumn = null;

            List<Schema_qualified_nameContext> colNames = tblRef.column_references().names_references().name;
            if (colNames.size() == 1) {
                fColumn = getFullCtxText(colNames.get(0));
            } else {
                throw new UnresolvedReferenceException(
                        "The number of columns in the source and the key assignment does not match",
                        tblRef.reftable.start);
            }

            constr.addDep(ftable);
            constr.addForeignColumn(fColumn);
            constr.addDep(new GenericColumn(refSchemaName, refTableName, colName, DbObjType.COLUMN));
            constr.setDefinition("FOREIGN KEY ("
                    + PgDiffUtils.getQuotedName(colName)
                    + ") REFERENCES " + PgDiffUtils.getQuotedName(ftable.table)
                    + '(' + PgDiffUtils.getQuotedName(fColumn) +')');
        } else if (prkey != null) {
            String genName = prkey.PRIMARY() == null ?
                    table.getName() + '_' + colName + "_key"
                    : table.getName() + "_pkey";

            String constrName = ctx.constraint_name == null ? genName : ctx.constraint_name.getText();
            constr = new PgConstraint(constrName, getFullCtxText(ctx));

            if (prkey.PRIMARY() != null) {
                constr.setUnique(false);
                constr.setPrimaryKey(true);
                constr.setDefinition("PRIMARY KEY (" + PgDiffUtils.getQuotedName(colName) + ')');
                col.setNullValue(false);
            } else {
                constr.setUnique(true);
                constr.setPrimaryKey(false);
                constr.setDefinition("UNIQUE (" + PgDiffUtils.getQuotedName(colName) + ')');
            }

            constr.addColumn(colName);
        } else if (comConstr != null && comConstr.check_boolean_expression() != null) {
            String genName = table.getName() + '_' + col.getName() + "_check";
            String constrName = ctx.constraint_name == null ? genName : ctx.constraint_name.getText();
            constr = new PgConstraint(constrName, getFullCtxText(ctx));
            VexContext expCtx = comConstr.check_boolean_expression().expression;
            constr.setDefinition("CHECK ((" + getFullCtxText(expCtx) + "))");
            db.getContextsForAnalyze().add(new SimpleEntry<>(constr, expCtx));
        }

        if (constr != null) {
            table.addConstraint(constr);
        }
    }

    protected void addColumn(String columnName, Data_typeContext datatype,
            Collate_identifierContext collate, List<Constraint_commonContext> constraints,
            Define_foreign_optionsContext options, PgTable table) {
        PgColumn col = new PgColumn(columnName);
        if (datatype != null) {
            col.setType(getFullCtxText(datatype));
            addTypeAsDepcy(datatype, col, getDefSchemaName());
        }
        if (collate != null) {
            col.setCollation(getFullCtxText(collate.collation));
        }
        for (Constraint_commonContext column_constraint : constraints) {
            addTableConstraint(column_constraint, col, table);
        }
        if (options != null) {
            for (Foreign_optionContext option : options.foreign_option()) {
                String value = option.value == null ? "" : option.value.getText();
                fillOptionParams(value, option.name.getText(), false, col::addForeignOption);
            }
        }
        table.addColumn(col);
    }

    protected void addColumn(String columnName, Data_typeContext datatype,
            Collate_identifierContext collate, List<Constraint_commonContext> constraints,
            PgTable table) {
        addColumn(columnName, datatype, collate, constraints, null, table);
    }

    protected void addColumn(String columnName, List<Constraint_commonContext> constraints,
            PgTable table) {
        addColumn(columnName, null, null, constraints, table);
    }

    protected void addInherit(PgTable table, List<IdentifierContext> idsInh) {
        String inhSchemaName = QNameParser.getSchemaName(idsInh, null);
        String inhTableName = QNameParser.getFirstName(idsInh);
        table.addInherits(inhSchemaName, inhTableName);
        GenericColumn gc = new GenericColumn(
                inhSchemaName == null ? getDefSchemaName() : inhSchemaName,
                        inhTableName, DbObjType.TABLE);
        table.addDep(gc);
    }

    protected static PgConstraint createTableConstraintBlank(Constraint_commonContext ctx) {
        String constrName = ctx.constraint_name == null ? "" : ctx.constraint_name.getText();
        return new PgConstraint(constrName, getFullCtxText(ctx));
    }

    protected static void processTableConstraintBlank(Constraint_commonContext ctx,
            PgConstraint constrBlank, PgDatabase db) {
        Constr_bodyContext constrBody = ctx.constr_body();

        if (constrBody.FOREIGN() != null) {
            Table_referencesContext tblRef = constrBody.table_references();

            List<IdentifierContext> ids = tblRef.reftable.identifier();
            String refTableName = QNameParser.getFirstName(ids);

            PgSchema s = db.getDefaultSchema();
            String defSchemaName = s == null ? null : s.getName();

            String refSchemaName = QNameParser.getSchemaName(ids, defSchemaName);
            GenericColumn ftable = new GenericColumn(refSchemaName, refTableName, DbObjType.TABLE);
            constrBlank.setForeignTable(ftable);
            constrBlank.addDep(ftable);

            for (Schema_qualified_nameContext name : tblRef.column_references().names_references().name) {
                String colName = QNameParser.getFirstName(name.identifier());
                constrBlank.addForeignColumn(colName);
                constrBlank.addDep(new GenericColumn(refSchemaName, refTableName, colName, DbObjType.COLUMN));
            }
        }

        Table_unique_prkeyContext tableUniquePrkey =  constrBody.table_unique_prkey();
        if (tableUniquePrkey != null) {
            setPrimaryUniq(tableUniquePrkey, constrBlank);
        }

        constrBlank.setDefinition(getFullCtxText(constrBody));
        db.getContextsForAnalyze().add(new SimpleEntry<>(constrBlank, constrBody));
    }

    /**
     * Вычитать PrimaryKey или Unique со списком колонок
     */
    private static void setPrimaryUniq(Table_unique_prkeyContext ctx,
            PgConstraint constr) {
        constr.setUnique(ctx.UNIQUE() != null);
        constr.setPrimaryKey(ctx.PRIMARY() != null);
        for (Schema_qualified_nameContext name : ctx.column_references()
                .names_references().name) {
            constr.addColumn(QNameParser.getFirstName(name.identifier()));
        }
    }
}
