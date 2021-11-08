package ru.taximaxim.codekeeper.apgdiff.sql;

import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.COL_NAME_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.RESERVED_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.TYPE_FUNC_NAME_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.UNRESERVED_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.LabelCategory.AS_LABEL;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.LabelCategory.BARE_LABEL;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * {@link #KEYWORDS} list maintenance:<br><br>
 * <ol>
 * <li>Copy code from
 * <a href='https://github.com/postgres/postgres/blob/REL9_6_STABLE/src/include/parser/kwlist.h'>
 * kwlist.h</a>, use your desired stable branch.</li>
 * <li>Paste it into {@link #addKeywords(Map)}, replacing the code there.</li>
 * <li>In pasted code, replace <code>PG_KEYWORD\(("\w+"), \w+, (\w+), (\w+)\)</code> by
 * <code>addKw\(map, $1, $2, $3\);</code> using regular expressions.</li>
 * </ol>
 *
 * @author levsha_aa
 */
public class Keyword {

    public static final Map<String, Keyword> KEYWORDS;
    /**
     * <a href='https://github.com/postgres/postgres/blob/REL9_6_STABLE/src/include/common/keywords.h'>
     * keywords.h</a>
     */
    public enum KeywordCategory {
        UNRESERVED_KEYWORD, COL_NAME_KEYWORD, TYPE_FUNC_NAME_KEYWORD, RESERVED_KEYWORD
    }

    enum LabelCategory {
        BARE_LABEL, AS_LABEL
    }

    /*
     * Regex search and replacement strings for kwlist.h -> Java transformation:
     *
     * PG_KEYWORD\(("\w+"), \w+, (\w+), (\w+)\)
     * addKw\(map, $1, $2, $3\);
     */
    private static void addKeywords(Map<String, Keyword> map) {
        addKw(map, "abort", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "absolute", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "access", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "action", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "add", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "admin", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "after", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "aggregate", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "all", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "also", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "alter", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "always", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "analyse", RESERVED_KEYWORD, BARE_LABEL);        /* British spelling */
        addKw(map, "analyze", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "and", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "any", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "array", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "as", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "asc", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "asensitive", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "assertion", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "assignment", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "asymmetric", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "at", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "atomic", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "attach", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "attribute", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "authorization", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "backward", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "before", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "begin", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "between", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "bigint", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "binary", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "bit", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "boolean", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "both", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "breadth", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "by", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cache", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "call", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "called", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cascade", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cascaded", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "case", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cast", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "catalog", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "chain", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "char", COL_NAME_KEYWORD, AS_LABEL);
        addKw(map, "character", COL_NAME_KEYWORD, AS_LABEL);
        addKw(map, "characteristics", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "check", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "checkpoint", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "class", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "close", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cluster", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "coalesce", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "collate", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "collation", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "column", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "columns", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "comment", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "comments", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "commit", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "committed", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "compression", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "concurrently", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "configuration", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "conflict", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "connection", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "constraint", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "constraints", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "content", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "continue", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "conversion", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "copy", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cost", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "create", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "cross", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "csv", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cube", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_catalog", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_date", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_role", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_schema", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "current_time", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_timestamp", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "current_user", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cursor", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "cycle", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "data", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "database", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "day", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "deallocate", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "dec", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "decimal", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "declare", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "default", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "defaults", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "deferrable", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "deferred", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "definer", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "delete", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "delimiter", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "delimiters", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "depends", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "depth", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "desc", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "detach", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "dictionary", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "disable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "discard", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "distinct", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "do", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "document", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "domain", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "double", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "drop", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "each", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "else", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "enable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "encoding", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "encrypted", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "end", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "enum", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "escape", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "event", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "except", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "exclude", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "excluding", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "exclusive", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "execute", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "exists", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "explain", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "expression", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "extension", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "external", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "extract", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "false", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "family", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "fetch", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "filter", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "finalize", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "first", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "float", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "following", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "for", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "force", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "foreign", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "forward", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "freeze", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "from", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "full", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "function", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "functions", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "generated", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "global", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "grant", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "granted", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "greatest", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "group", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "grouping", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "groups", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "handler", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "having", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "header", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "hold", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "hour", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "identity", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "if", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "ilike", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "immediate", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "immutable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "implicit", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "import", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "in", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "include", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "including", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "increment", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "index", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "indexes", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "inherit", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "inherits", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "initially", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "inline", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "inner", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "inout", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "input", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "insensitive", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "insert", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "instead", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "int", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "integer", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "intersect", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "interval", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "into", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "invoker", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "is", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "isnull", TYPE_FUNC_NAME_KEYWORD, AS_LABEL);
        addKw(map, "isolation", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "join", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "key", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "label", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "language", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "large", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "last", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "lateral", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "leading", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "leakproof", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "least", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "left", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "level", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "like", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "limit", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "listen", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "load", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "local", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "localtime", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "localtimestamp", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "location", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "lock", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "locked", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "logged", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "mapping", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "match", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "materialized", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "maxvalue", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "method", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "minute", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "minvalue", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "mode", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "month", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "move", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "name", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "names", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "national", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "natural", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "nchar", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "new", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "next", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nfc", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nfd", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nfkc", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nfkd", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "no", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "none", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "normalize", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "normalized", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "not", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nothing", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "notify", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "notnull", TYPE_FUNC_NAME_KEYWORD, AS_LABEL);
        addKw(map, "nowait", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "null", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "nullif", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "nulls", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "numeric", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "object", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "of", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "off", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "offset", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "oids", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "old", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "on", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "only", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "operator", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "option", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "options", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "or", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "order", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "ordinality", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "others", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "out", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "outer", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "over", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "overlaps", TYPE_FUNC_NAME_KEYWORD, AS_LABEL);
        addKw(map, "overlay", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "overriding", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "owned", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "owner", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "parallel", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "parser", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "partial", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "partition", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "passing", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "password", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "placing", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "plans", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "policy", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "position", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "preceding", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "precision", COL_NAME_KEYWORD, AS_LABEL);
        addKw(map, "prepare", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "prepared", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "preserve", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "primary", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "prior", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "privileges", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "procedural", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "procedure", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "procedures", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "program", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "publication", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "quote", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "range", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "read", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "real", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "reassign", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "recheck", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "recursive", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "ref", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "references", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "referencing", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "refresh", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "reindex", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "relative", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "release", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "rename", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "repeatable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "replace", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "replica", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "reset", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "restart", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "restrict", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "return", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "returning", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "returns", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "revoke", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "right", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "role", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "rollback", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "rollup", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "routine", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "routines", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "row", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "rows", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "rule", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "savepoint", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "schema", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "schemas", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "scroll", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "search", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "second", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "security", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "select", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "sequence", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "sequences", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "serializable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "server", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "session", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "session_user", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "set", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "setof", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "sets", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "share", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "show", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "similar", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "simple", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "skip", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "smallint", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "snapshot", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "some", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "sql", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "stable", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "standalone", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "start", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "statement", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "statistics", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "stdin", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "stdout", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "storage", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "stored", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "strict", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "strip", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "subscription", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "substring", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "support", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "symmetric", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "sysid", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "system", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "table", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "tables", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "tablesample", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "tablespace", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "temp", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "template", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "temporary", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "text", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "then", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "ties", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "time", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "timestamp", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "to", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "trailing", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "transaction", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "transform", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "treat", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "trigger", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "trim", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "true", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "truncate", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "trusted", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "type", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "types", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "uescape", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "unbounded", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "uncommitted", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "unencrypted", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "union", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "unique", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "unknown", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "unlisten", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "unlogged", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "until", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "update", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "user", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "using", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "vacuum", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "valid", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "validate", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "validator", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "value", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "values", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "varchar", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "variadic", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "varying", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "verbose", TYPE_FUNC_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "version", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "view", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "views", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "volatile", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "when", RESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "where", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "whitespace", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "window", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "with", RESERVED_KEYWORD, AS_LABEL);
        addKw(map, "within", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "without", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "work", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "wrapper", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "write", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "xml", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "xmlattributes", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlconcat", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlelement", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlexists", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlforest", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlnamespaces", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlparse", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlpi", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlroot", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmlserialize", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "xmltable", COL_NAME_KEYWORD, BARE_LABEL);
        addKw(map, "year", UNRESERVED_KEYWORD, AS_LABEL);
        addKw(map, "yes", UNRESERVED_KEYWORD, BARE_LABEL);
        addKw(map, "zone", UNRESERVED_KEYWORD, BARE_LABEL);
    }

    private static void addKw(Map<String, Keyword> map, String kw,
            KeywordCategory keyword, LabelCategory label) {
        map.put(kw, new Keyword(kw, keyword, label));
    }

    static {
        Map<String, Keyword> keywords = new HashMap<>();
        addKeywords(keywords);
        KEYWORDS = Collections.unmodifiableMap(keywords);
    }

    private final String keyword;
    private final KeywordCategory category;
    private final LabelCategory labelCategory;

    public Keyword(String keyword, KeywordCategory category, LabelCategory labelCategory) {
        this.keyword = keyword;
        this.category = category;
        this.labelCategory = labelCategory;
    }

    public String getKeyword() {
        return keyword;
    }

    public KeywordCategory getCategory() {
        return category;
    }

    public LabelCategory getLabelCategory() {
        return labelCategory;
    }

    /*
     * ======== Service methods for parser maintenance ========
     * Use only to generate lexer token lists.
     * Do not call from project's code.
     */

    // SONAR-OFF
    public static void getAllTokensByGroups() {
        KeywordCategory[] prevCat = new KeywordCategory[1];
        char[] prevFirstLetter = new char[1];

        Arrays.stream(KeywordCategory.values())
        .flatMap(kc -> KEYWORDS.values().stream()
                .filter(k -> k.getCategory() == kc)
                .sorted(Comparator.comparing(Keyword::getKeyword)))
        .forEach(v -> {
            if (prevCat[0] != v.getCategory()) {
                System.out.println();
                System.out.println("    /*");
                System.out.println("    ==================================================");
                System.out.println("    " + v.getCategory());
                System.out.println("    ==================================================");
                System.out.println("    */");
                prevCat[0] = v.getCategory();
            }
            String k = v.getKeyword();
            String kUpper = k.toUpperCase(Locale.ROOT);
            char firstLetter = k.charAt(0);
            if (prevFirstLetter[0] != firstLetter) {
                System.out.println();
                prevFirstLetter[0] = firstLetter;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("    ").append(kUpper).append(':');
            for (int i = 0; i < k.length(); ++i){
                char ch = k.charAt(i);
                if (ch == '_'){
                    sb.append(" UNDERLINE ");
                } else {
                    sb.append(" [").append(ch).append(kUpper.charAt(i)).append(']');
                }
            }
            sb.append(";");
            System.out.println(sb);
        });
    }

    public static void getAllWordsByGroups() {
        Map<KeywordCategory, StringBuilder> map = new EnumMap<>(KeywordCategory.class);
        StringBuilder sbBare = new StringBuilder();
        KEYWORDS.values().stream()
        .sorted((v1,v2) -> v1.getKeyword().compareTo(v2.getKeyword()))
        .forEach(v -> {
            StringBuilder sb = map.get(v.getCategory());
            if (sb == null) {
                sb = new StringBuilder();
                map.put(v.getCategory(), sb);
            }
            sb.append("  | ").append(v.getKeyword().toUpperCase(Locale.ROOT)).append("\n");
            if (v.getLabelCategory() == BARE_LABEL) {
                sbBare.append("  | ").append(v.getKeyword().toUpperCase(Locale.ROOT)).append("\n");
            }
        });
        map.keySet().stream().sorted().forEach(k -> {
            System.out.println("==================================================");
            System.out.println(k);
            System.out.println("==================================================");
            System.out.println(map.get(k));
        });
        System.out.println(BARE_LABEL);
        System.out.println(sbBare);
    }
    // SONAR-ON
}
