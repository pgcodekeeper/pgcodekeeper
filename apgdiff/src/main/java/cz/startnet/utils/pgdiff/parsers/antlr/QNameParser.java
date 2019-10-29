package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;

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
                if (tree instanceof ParserRuleContext) {
                    children = ((ParserRuleContext) tree).children;
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
    private final List<AntlrError> errors;

    public List<T> getIds() {
        return Collections.unmodifiableList(parts);
    }

    public static QNameParser<IdentifierContext> parsePg(String schemaQualifiedName) {
        List<AntlrError> errors = new ArrayList<>();
        List<IdentifierContext> parts = AntlrParser
                .makeBasicParser(SQLParser.class, schemaQualifiedName, "qname: " + schemaQualifiedName, errors)
                .qname_parser()
                .schema_qualified_name()
                .identifier();
        return new QNameParser<>(parts, errors);
    }

    private QNameParser(List<T> parts, List<AntlrError> errors) {
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
