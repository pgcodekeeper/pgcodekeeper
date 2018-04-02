package cz.startnet.utils.pgdiff.parsers.antlr.expr;

public interface TypesSetManually {
    String UNKNOWN = "unknown_unknown";
    String EMPTY = "empty";
    String UNKNOWN_ARRAY = "unknown[]";

    String COLUMN = "column";
    String FUNCTION_COLUMN = "functionCol";

    String QUALIFIED_ASTERISK = "qualifiedAsterisk";

    String BOOLEAN = "boolean";
    String INTEGER = "integer";
    String NUMERIC = "numeric";
    String TEXT = "text";
}
