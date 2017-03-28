package cz.startnet.utils.pgdiff.parsers.antlr;

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
        return ids.size() < 2 ? defaultSchema : ids.get(0).getText();
    }

    private static String getLastId(List<IdentifierContext> ids, int i) {
        int n = ids.size() - i;
        return n < 0 ? null : ids.get(n).getText();
    }

    private static IdentifierContext getLastIdCtx(List<IdentifierContext> ids, int i) {
        int n = ids.size() - i;
        return n < 0 ? null : ids.get(n);
    }

    private final List<IdentifierContext> parts;

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
