package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;

public final class QNameParser {

    public static String getFirstName(List<IdentifierContext> ids) {
        return getLastId(ids, 1);
    }

    public static String getSecondName(List<IdentifierContext> ids) {
        return getLastId(ids, 2);
    }

    public static String getThirdName(List<IdentifierContext> ids) {
        return getLastId(ids, 3);
    }

    public static IdentifierContext getFirstNameCtx(List<IdentifierContext> ids) {
        return getLastIdCtx(ids, 1);
    }

    public static IdentifierContext getSecondNameCtx(List<IdentifierContext> ids) {
        return getLastIdCtx(ids, 2);
    }

    public static IdentifierContext getThirdNameCtx(List<IdentifierContext> ids) {
        return getLastIdCtx(ids, 3);
    }

    public static String getSchemaName(List<IdentifierContext> ids, String defaultSchema) {
        IdentifierContext schemaCtx = getSchemaNameCtx(ids);
        return schemaCtx == null ? defaultSchema : schemaCtx.getText();
    }

    public static IdentifierContext getSchemaNameCtx(List<IdentifierContext> ids) {
        return ids.size() < 2 ? null : ids.get(0);
    }

    private static String getLastId(List<IdentifierContext> ids, int i) {
        IdentifierContext ctx = getLastIdCtx(ids, i);
        return ctx == null ? null : ctx.getText();
    }

    private static IdentifierContext getLastIdCtx(List<IdentifierContext> ids, int i) {
        int n = ids.size() - i;
        return n < 0 ? null : ids.get(n);
    }

    private final List<IdentifierContext> parts;

    public List<IdentifierContext> getIds() {
        return Collections.unmodifiableList(parts);
    }

    public QNameParser(String schemaQualifiedName) {
        this.parts = AntlrParser
                .makeBasicParser(SQLParser.class, schemaQualifiedName, "qname: " + schemaQualifiedName)
                .qname_parser()
                .schema_qualified_name()
                .identifier();
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
}
