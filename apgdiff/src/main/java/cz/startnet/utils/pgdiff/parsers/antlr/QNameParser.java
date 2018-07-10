package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

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

    public static <T extends ParserRuleContext> String getSchemaName(List<T> ids, String defaultSchema) {
        ParserRuleContext schemaCtx = getSchemaNameCtx(ids);
        return schemaCtx == null ? defaultSchema : schemaCtx.getText();
    }

    public static <T extends ParserRuleContext> T getSchemaNameCtx(List<T> ids) {
        return ids.size() < 2 ? null : ids.get(0);
    }

    private static <T extends ParserRuleContext> String getLastId(List<T> ids, int i) {
        ParserRuleContext ctx = getLastIdCtx(ids, i);
        return ctx == null ? null : ctx.getText();
    }

    private static <T extends ParserRuleContext> T getLastIdCtx(List<T> ids, int i) {
        int n = ids.size() - i;
        return n < 0 ? null : ids.get(n);
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

    public String getSchemaName(String defaultSchema) {
        return getSchemaName(parts, defaultSchema);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
