package cz.startnet.utils.pgdiff.parsers.antlr.expr;

public interface TypesSetManually {
    String UNKNOWN = "unknown_unknown";
    String EMPTY = "empty";

    String COLUMN = "column";
    String FUNCTION_COLUMN = "functionCol";

    String QUALIFIED_ASTERISK = "qualifiedAsterisk";

    String BOOLEAN = "boolean";
    String INTEGER = "integer";
    String NUMERIC = "numeric";
    String DOUBLE = "double precision";
    String TEXT = "text";
    String NAME = "name";
    String XML = "xml";

    String DATE = "date";
    String TIMETZ = "time with time zone";
    String TIMESTAMPTZ = "timestamp with time zone";
    String TIME = "time without time zone";
    String TIMESTAMP = "timestamp without time zone";
}
