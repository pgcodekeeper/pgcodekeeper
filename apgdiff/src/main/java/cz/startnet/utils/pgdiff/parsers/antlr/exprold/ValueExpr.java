package cz.startnet.utils.pgdiff.parsers.antlr.exprold;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_bracketsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cast_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comparison_modContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Datetime_overlapsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Extract_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Filter_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_boundContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.General_literalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Indirection_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_by_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_asteriskContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.String_value_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Type_coercionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Unsigned_value_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_bContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Window_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Xml_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ValueExpr extends AbstractExpr {

    public ValueExpr(String schema) {
        super(schema);
    }

    protected ValueExpr(AbstractExpr parent) {
        super(parent);
    }

    private List<Vex> addVexCtxtoList(List<Vex> l, List<VexContext> ctx) {
        int toAdd = ctx.size();
        if (toAdd != 0) {
            if (l == null) {
                l = new ArrayList<>(toAdd);
            }
            for (VexContext vexCtx : ctx) {
                l.add(new Vex(vexCtx));
            }
        }
        return l;
    }

    public void analyze(Vex vex) {
        Data_typeContext dataType = vex.dataType();
        @SuppressWarnings("unused")
        // TODO OpCtx user-operator reference
        Collate_identifierContext collate;
        Select_stmt_no_parensContext selectStmt;
        Datetime_overlapsContext overlaps;
        Value_expression_primaryContext primary;
        boolean doneWork = true;

        if (vex.castExpression() != null && dataType != null) {
            addTypeDepcy(dataType);

            Predefined_typeContext pType = dataType.predefined_type();
            Schema_qualified_name_nontypeContext customType = pType.schema_qualified_name_nontype();
            IdentifierContext typeSchema = customType == null ? null : customType.identifier();
            // TODO remove when tokens are refactored
            if (dataType.LEFT_BRACKET() == null && dataType.SETOF() == null && customType != null &&
                    (typeSchema == null || "pg_catalog".equals(typeSchema.getText()))) {
                // check simple built-in types for reg*** casts
                Value_expression_primaryContext castPrimary = vex.vex().get(0).primary();
                Unsigned_value_specificationContext value;
                General_literalContext literal;
                if (castPrimary != null
                        && (value = castPrimary.unsigned_value_specification()) != null
                        && (literal = value.general_literal()) != null
                        && literal.character_string() != null
                        && literal.character_string().Character_String_Literal() != null) {
                    regCast(PgDiffUtils.unquoteQuotedString(literal.getText()),
                            customType.getText());
                }
            }
        } else if ((collate = vex.collateIdentifier()) != null) {
            // TODO pending DbObjType.COLLATION
        } else if (vex.in() != null && vex.leftParen() != null && vex.rightParen() != null &&
                (selectStmt = vex.selectStmt()) != null) {
            new Select(this).analyze(selectStmt);
        } else if ((overlaps = vex.datetimeOverlaps()) != null) {
            for (VexContext v : overlaps.vex()) {
                analyze(new Vex(v));
            }
        } else if ((primary = vex.primary()) != null) {
            Select_stmt_no_parensContext subSelectStmt = primary.select_stmt_no_parens();
            Case_expressionContext caseExpr;
            Cast_specificationContext cast;
            Comparison_modContext compMod;
            Table_subqueryContext subquery;
            Function_callContext function;
            Schema_qualified_nameContext qname;
            Indirection_identifierContext indirection;
            @SuppressWarnings("unused")
            Qualified_asteriskContext ast;
            Array_expressionContext array;
            Type_coercionContext typeCoercion;
            List<Vex> subOperands = null;

            if (primary.LEFT_PAREN() != null && primary.RIGHT_PAREN() != null &&
                    subSelectStmt != null) {
                new Select(this).analyze(subSelectStmt);
            } else if ((caseExpr = primary.case_expression()) != null) {
                subOperands = addVexCtxtoList(subOperands, caseExpr.vex());
            } else if ((cast = primary.cast_specification()) != null) {
                analyze(new Vex(cast.vex()));
                addTypeDepcy(cast.data_type());
            } else if ((compMod = primary.comparison_mod()) != null) {
                VexContext compModVex = compMod.vex();
                if (compModVex != null) {
                    analyze(new Vex(compModVex));
                } else {
                    new Select(this).analyze(compMod.select_stmt_no_parens());
                }
            } else if (primary.EXISTS() != null &&
                    (subquery = primary.table_subquery()) != null) {
                new Select(this).analyze(subquery.select_stmt());
            } else if ((function = primary.function_call()) != null) {
                function(function);
            } else if ((qname = primary.schema_qualified_name()) != null) {
                addColumnDepcy(qname);
            } else if ((indirection = primary.indirection_identifier()) != null) {
                analyze(new Vex(indirection.vex()));
            } else if ((ast = primary.qualified_asterisk()) != null) {
                // TODO pending full analysis
            } else if ((array = primary.array_expression()) != null) {
                Array_bracketsContext arrayb = array.array_brackets();
                if (arrayb != null) {
                    subOperands = addVexCtxtoList(subOperands, arrayb.vex());
                } else {
                    new Select(this).analyze(array.array_query().table_subquery().select_stmt());
                }
            } else if ((typeCoercion = primary.type_coercion()) != null) {
                addTypeDepcy(typeCoercion.data_type());
            }

            if (subOperands != null) {
                for (Vex v : subOperands) {
                    analyze(v);
                }
            }
        } else {
            doneWork = false;
        }

        List<Vex> operands = vex.vex();
        if (!operands.isEmpty()) {
            for (Vex v : operands) {
                analyze(v);
            }
        } else if (!doneWork) {
            Log.log(Log.LOG_WARNING, "No alternative in Vex!");
        }
    }

    /**
     * @return function reference or null for internal functions
     */
    public GenericColumn function(Function_callContext function) {
        GenericColumn ret = null;
        List<Vex> args = null;

        Function_nameContext name = function.function_name();

        Extract_functionContext extract;
        String_value_functionContext string;
        Xml_functionContext xml;

        if (name != null){
            Data_typeContext type = name.data_type();
            Schema_qualified_name_nontypeContext funcNameCtx;
            if (type != null &&
                    (funcNameCtx = type.predefined_type().schema_qualified_name_nontype()) != null) {
                ret = addFunctionDepcy(funcNameCtx);

            }

            args = addVexCtxtoList(args, function.vex());

            Orderby_clauseContext orderBy = function.orderby_clause();
            if (orderBy != null) {
                orderBy(orderBy);
            }
            Filter_clauseContext filter = function.filter_clause();
            if (filter != null) {
                analyze(new Vex(filter.vex()));
            }
            Window_definitionContext window = function.window_definition();
            if (window != null) {
                window(window);
            }
        } else if ((extract = function.extract_function()) != null) {
            analyze(new Vex(extract.vex()));
        } else if ((string = function.string_value_function()) != null) {
            args = addVexCtxtoList(args, string.vex());

            Vex_bContext vexB = string.vex_b();
            if (vexB != null) {
                analyze(new Vex(vexB));
            }
        } else if ((xml = function.xml_function()) != null) {
            args = addVexCtxtoList(args, xml.vex());
        }

        if (args != null) {
            for (Vex v : args) {
                analyze(v);
            }
        }
        return ret;
    }

    public void orderBy(Orderby_clauseContext orderBy) {
        for (Sort_specifierContext sort : orderBy.sort_specifier_list().sort_specifier()) {
            analyze(new Vex(sort.vex()));
        }
    }

    public void window(Window_definitionContext window) {
        Partition_by_columnsContext partition = window.partition_by_columns();
        if (partition != null) {
            for (VexContext v : partition.vex()) {
                analyze(new Vex(v));
            }
        }

        Orderby_clauseContext orderBy = window.orderby_clause();
        if (orderBy != null) {
            orderBy(orderBy);
        }

        Frame_clauseContext frame = window.frame_clause();
        if (frame != null) {
            for (Frame_boundContext bound : frame.frame_bound()) {
                VexContext vex = bound.vex();
                if (vex != null) {
                    analyze(new Vex(vex));
                }
            }
        }
    }

    private void regCast(String s, String regcast) {
        DbObjType regcastType;
        switch (regcast) {
        case "regproc":
            regcastType = DbObjType.FUNCTION;
            break;
        case "regclass":
            regcastType = DbObjType.TABLE;
            break;
        case "regtype":
            regcastType = DbObjType.TYPE;
            break;

        case "regnamespace":
            addSchemaDepcy(new QNameParser(s).getIds());
            return;

        case "regprocedure":
            addFunctionSigDepcy(s);
            return;

        case "regoper":
        case "regoperator":
            // TODO pending DbObjType.OPERATOR
        default:
            return;
        }

        addObjectDepcy(new QNameParser(s).getIds(), regcastType);
    }
}
