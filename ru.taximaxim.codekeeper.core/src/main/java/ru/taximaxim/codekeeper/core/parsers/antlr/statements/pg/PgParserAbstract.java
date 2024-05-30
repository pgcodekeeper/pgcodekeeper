/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.All_opContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Boolean_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Cast_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Column_operator_classContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Distributed_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_argsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_argumentsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Identifier_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Including_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Operator_argsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Operator_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Predefined_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_name_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.User_mapping_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.PgOperator;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Abstract Class contents common operations for parsing
 */
public abstract class PgParserAbstract extends ParserAbstract<PgDatabase> {

    protected PgParserAbstract(PgDatabase db) {
        super(db);
    }

    protected void fillSimpleColumns(ISimpleColumnContainer cont,
            List<Index_columnContext> cols, List<All_opContext> operators) {
        // we need this variable for take correct context from List
        int counter = 0;

        for (Index_columnContext col : cols) {
            SimpleColumn simpCol;
            var collate = col.column.collate_identifier();
            if (collate == null) {
                simpCol = new SimpleColumn(getFullCtxText(col.column));
            } else {
                simpCol = new SimpleColumn(getFullCtxText(col.column.vex()));
                simpCol.setCollation(getFullCtxText(collate.collation));
                addDepSafe((PgStatement) cont, getIdentifiers(collate.collation), DbObjType.COLLATION);
            }

            var opClass = col.operator_class;
            if (opClass != null) {
                simpCol.setOpClass(opClass.getText());

                // only for index
                var opClassParams = col.storage_parameters();
                if (opClassParams != null) {
                    for (var param : opClassParams.storage_parameter_option()) {
                        simpCol.addOpClassParam(param.storage_parameter_name().getText(), param.vex().getText());
                    }
                }
            }

            // only for constraint exclude
            if (operators != null) {
                simpCol.setOperator(operators.get(counter).getText());
                counter++;
            }

            addNullOrdering(simpCol, col);
            cont.addColumn(simpCol);
        }
    }

    private static void addNullOrdering(SimpleColumn sCol, Index_columnContext col) {
        var ordSpec = col.order_specification();
        if (ordSpec != null) {
            sCol.setDesc(ordSpec.DESC() != null);
        }

        var nullOrd = col.null_ordering();
        if (nullOrd == null) {
            return;
        }

        if (sCol.isDesc()) {
            if (nullOrd.LAST() != null) {
                sCol.setNullsOrdering(" NULLS LAST");
            }
        } else if (nullOrd.FIRST() != null) {
            sCol.setNullsOrdering(" NULLS FIRST");
        }
    }

    protected static void fillIncludingDepcy(Including_indexContext incl, PgStatement st, String schema, String table) {
        for (IdentifierContext inclCol : incl.identifier()) {
            st.addDep(new GenericColumn(schema, table, inclCol.getText(), DbObjType.COLUMN));
        }
    }

    protected void addTypeDepcy(Data_typeContext ctx, PgStatement st) {
        Schema_qualified_name_nontypeContext qname = ctx.predefined_type().schema_qualified_name_nontype();
        if (qname != null && qname.identifier() != null) {
            addDepSafe(st, getIdentifiers(qname), DbObjType.TYPE);
        }
    }

    /**
     * Fill owner
     *
     * @param owner parser context with owner
     * @param st    object
     */
    protected void fillOwnerTo(IdentifierContext owner, PgStatement st) {
        if (owner == null || db.getArguments().isIgnorePrivileges() || isRefMode()) {
            return;
        }
        st.setOwner(owner.getText());
    }

    protected boolean parseBoolean(Boolean_valueContext boolCtx) {
        String bool = boolCtx.character_string() != null
                ? unquoteQuotedString(boolCtx.character_string()).getFirst() : boolCtx.getText();
        bool = bool.toLowerCase(Locale.ROOT);
        switch (bool) {
        case "1":
        case "true":
        case "on":
        case "yes":
            return true;
        case "0":
        case "false":
        case "off":
        case "no":
            return false;
        default:
            // TODO throw instead?
            return false;
        }
    }

    public static Pair<String, Token> unquoteQuotedString(Character_stringContext ctx) {
        TerminalNode string = ctx.Character_String_Literal();
        if (string != null) {
            String text = string.getText();
            int start = text.indexOf('\'') + 1;

            Token t = string.getSymbol();
            CommonToken copy = new CommonToken(t);

            copy.setStartIndex(t.getStartIndex() + start);
            copy.setCharPositionInLine(t.getCharPositionInLine() + start);
            copy.setStopIndex(t.getStopIndex() - 1);

            return new Pair<>(PgDiffUtils.unquoteQuotedString(string.getText(), start), copy);
        }

        List<TerminalNode> dollarText = ctx.Text_between_Dollar();
        String s = dollarText.stream().map(TerminalNode::getText).collect(Collectors.joining());

        return new Pair<>(s, dollarText.get(0).getSymbol());
    }

    public static List<ParserRuleContext> getIdentifiers(Schema_qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(3);
        ids.add(qNameCtx.identifier());
        ids.addAll(qNameCtx.identifier_reserved());
        return ids;
    }

    public static List<ParserRuleContext> getIdentifiers(Schema_qualified_name_nontypeContext qNameNonTypeCtx) {
        List<ParserRuleContext> ids;
        Identifier_nontypeContext singleId = qNameNonTypeCtx.identifier_nontype();
        if (singleId != null) {
            ids = new ArrayList<>(1);
            ids.add(singleId);
        } else {
            ids = new ArrayList<>(2);
            ids.add(qNameNonTypeCtx.schema);
            ids.add(qNameNonTypeCtx.identifier_reserved_nontype());
        }
        return ids;
    }

    public static List<ParserRuleContext> getIdentifiers(Operator_nameContext operQNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(2);
        ids.add(operQNameCtx.schema_name);
        ids.add(operQNameCtx.operator);
        return ids;
    }

    public static String getTypeName(Data_typeContext datatype) {
        String full = getFullCtxText(datatype);
        Predefined_typeContext typeCtx = datatype.predefined_type();

        String type = getFullCtxText(typeCtx);
        if (type.startsWith("\"")) {
            return full;
        }

        String newType = convertAlias(type);
        if (!Objects.equals(type, newType)) {
            return full.replace(type, newType);
        }

        return full;
    }

    private static String convertAlias(String type) {
        String alias = type.toLowerCase(Locale.ROOT);

        switch (alias) {
        case "int8": return "bigint";
        case "bool": return "boolean";
        case "float8": return "double precision";
        case "int":
        case "int4": return "integer";
        case "float4": return "real";
        case "int2": return "smallint";
        default: break;
        }

        if (PgDiffUtils.startsWithId(alias, "varbit", 0)) {
            return "bit varying" + type.substring("varbit".length());
        }

        if (PgDiffUtils.startsWithId(alias, "varchar", 0)) {
            return "character varying" + type.substring("varchar".length());
        }

        if (PgDiffUtils.startsWithId(alias, "char", 0)) {
            return "character" + type.substring("char".length());
        }

        if (PgDiffUtils.startsWithId(alias, "decimal", 0)) {
            return "numeric" + type.substring("decimal".length());
        }

        if (PgDiffUtils.startsWithId(alias, "timetz", 0)) {
            return "time" + type.substring("timetz".length()) + " with time zone";
        }

        if (PgDiffUtils.startsWithId(alias, "timestamptz", 0)) {
            return "timestamp" + type.substring("timestamptz".length()) + " with time zone";
        }

        return type;
    }

    public static String parseOperatorSignature(String name, Operator_argsContext operatorArgsCtx) {
        PgOperator oper = new PgOperator(name);
        Data_typeContext leftType = null;
        Data_typeContext rightType = null;
        if (operatorArgsCtx != null) {
            leftType = operatorArgsCtx.left_type;
            rightType = operatorArgsCtx.right_type;
        }

        oper.setLeftArg(leftType == null ? null : getTypeName(leftType));
        oper.setRightArg(rightType == null ? null : getTypeName(rightType));
        return oper.getSignature();
    }

    public String parseArguments(Function_argsContext argsContext) {
        return parseSignature(null, argsContext);
    }

    public static String parseSignature(String name, Function_argsContext argsContext) {
        AbstractPgFunction function = new PgFunction(name == null ? "noname" : name);
        fillFuncArgs(argsContext.function_arguments(), function);
        if (argsContext.agg_order() != null) {
            fillFuncArgs(argsContext.agg_order().function_arguments(), function);
        }
        String signature = function.getSignature();
        if (name == null) {
            signature = signature.substring("noname".length());
        }
        return signature;
    }

    private static void fillFuncArgs(List<Function_argumentsContext> argsCtx, AbstractPgFunction function) {
        for (Function_argumentsContext argument : argsCtx) {
            String type = getTypeName(argument.data_type());
            Identifier_nontypeContext name = argument.identifier_nontype();
            function.addArgument(
                    new Argument(parseArgMode(argument.argmode()), name != null ? name.getText() : null, type));
        }
    }

    // for greenplum
    protected String parseDistribution(Distributed_clauseContext dist) {
        if (dist == null) {
            return null;
        }

        StringBuilder distribution = new StringBuilder();
        distribution.append("DISTRIBUTED ");
        if (dist.BY() != null) {
            distribution.append("BY (");
            for (Column_operator_classContext column_op_class : dist.column_operator_class()) {
                distribution.append(column_op_class.identifier().getText());
                Schema_qualified_nameContext opClassCtx = column_op_class.schema_qualified_name();
                if (opClassCtx != null) {
                    distribution.append(" ").append(opClassCtx.getText());
                }
                distribution.append(", ");
            }
            distribution.setLength(distribution.length() - 2);
            distribution.append(")");
        } else if (dist.RANDOMLY() != null) {
            distribution.append("RANDOMLY");
        } else {
            distribution.append("REPLICATED");
        }
        return distribution.toString();
    }

    @Override
    protected PgObjLocation getLocation(List<? extends ParserRuleContext> ids, DbObjType type, String action,
            boolean isDep, String signature, LocationType locationType) {
        if (type == DbObjType.CAST) {
            ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(getCastName((Cast_nameContext) nameCtx), DbObjType.CAST));
        }

        if (type == DbObjType.USER_MAPPING) {
            ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
            return buildLocation(nameCtx, action, locationType,
                    new GenericColumn(getUserMappingName((User_mapping_nameContext) nameCtx), DbObjType.USER_MAPPING));
        }

        return super.getLocation(ids, type, action, isDep, signature, locationType);
    }

    protected String getCastName(Cast_nameContext nameCtx) {
        return ICast.getSimpleName(getFullCtxText(nameCtx.source), getFullCtxText(nameCtx.target));
    }

    protected String getUserMappingName(User_mapping_nameContext nameCtx) {
        return (nameCtx.user_name() != null ? nameCtx.user_name().getText() : nameCtx.USER().getText()) + " SERVER "
                + nameCtx.identifier().getText();
    }

    @Override
    protected PgSchema getSchemaSafe(List<? extends ParserRuleContext> ids) {
        return (PgSchema) super.getSchemaSafe(ids);
    }
}
