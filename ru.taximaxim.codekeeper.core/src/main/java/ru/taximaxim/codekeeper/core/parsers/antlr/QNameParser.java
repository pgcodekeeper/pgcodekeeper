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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.ChParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;

public final class QNameParser<T extends ParserRuleContext> {

    public static <T extends ParserRuleContext> String getFirstName(List<T> ids) {
        return getLastId(ids, 1);
    }

    public static <T extends ParserRuleContext> String getSecondName(List<T> ids) {
        return getLastId(ids, 2);
    }

    public static <T extends ParserRuleContext> String getThirdName(List<T> ids) {
        return getLastId(ids, 3);
    }

    public static <T extends ParserRuleContext> T getFirstNameCtx(List<T> ids) {
        return getLastIdCtx(ids, 1);
    }

    public static <T extends ParserRuleContext> T getSecondNameCtx(List<T> ids) {
        return getLastIdCtx(ids, 2);
    }

    public static <T extends ParserRuleContext> T getThirdNameCtx(List<T> ids) {
        return getLastIdCtx(ids, 3);
    }

    public static <T extends ParserRuleContext> String getSchemaName(List<T> ids) {
        ParserRuleContext schemaCtx = getSchemaNameCtx(ids);
        return schemaCtx == null ? null : getText(schemaCtx);
    }

    public static <T extends ParserRuleContext> T getSchemaNameCtx(List<T> ids) {
        return ids.size() < 2 ? null : ids.get(0);
    }

    private static <T extends ParserRuleContext> String getLastId(List<T> ids, int i) {
        ParserRuleContext ctx = getLastIdCtx(ids, i);
        return ctx == null ? null : getText(ctx);
    }

    private static <T extends ParserRuleContext> T getLastIdCtx(List<T> ids, int i) {
        int n = ids.size() - i;
        return n < 0 ? null : ids.get(n);
    }

    private static String getText(ParserRuleContext ctx) {
        List<ParseTree> children = ctx.children;
        while (children != null) {
            if (children.size() == 1) {
                ParseTree tree = children.get(0);
                if (tree instanceof ParserRuleContext ruleCtx) {
                    children = ruleCtx.children;
                } else if (tree instanceof TerminalNode) {
                    return tree.getText();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return ctx.getText();
    }

    private final List<T> parts;
    private final List<Object> errors;

    public List<T> getIds() {
        return Collections.unmodifiableList(parts);
    }

    public static QNameParser<ParserRuleContext> parsePg(String schemaQualifiedName) {
        List<Object> errors = new ArrayList<>();
        List<ParserRuleContext> parts = PgParserAbstract.getIdentifiers(AntlrParser
                .makeBasicParser(SQLParser.class, schemaQualifiedName, "qname: " + schemaQualifiedName, errors)
                .qname_parser()
                .schema_qualified_name());
        return new QNameParser<>(parts, errors);
    }

    public static QNameParser<ParserRuleContext> parseCh(String schemaQualifiedName) {
        List<Object> errors = new ArrayList<>();
        List<ParserRuleContext> parts = ChParserAbstract.getIdentifiers(AntlrParser
                .makeBasicParser(CHParser.class, schemaQualifiedName, "qname: " + schemaQualifiedName, errors)
                .qname_parser()
                .qualified_name());
        return new QNameParser<>(parts, errors);
    }

    public static QNameParser<ParserRuleContext> parsePgOperator(String schemaQualifiedName) {
        List<Object> errors = new ArrayList<>();
        List<ParserRuleContext> parts = PgParserAbstract.getIdentifiers(AntlrParser
                .makeBasicParser(SQLParser.class, schemaQualifiedName, "qname: " + schemaQualifiedName, errors)
                .operator_args_parser()
                .operator_name());
        return new QNameParser<>(parts, errors);
    }

    private QNameParser(List<T> parts, List<Object> errors) {
        this.errors = errors;
        this.parts = parts;
    }

    public String getFirstName() {
        return getFirstName(parts);
    }

    public String getSecondName() {
        return getSecondName(parts);
    }

    public String getThirdName() {
        return getThirdName(parts);
    }

    public String getSchemaName() {
        return getSchemaName(parts);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
