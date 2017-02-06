package ru.taximaxim.codekeeper.apgdiff.sql;

import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.COL_NAME_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.RESERVED_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.TYPE_FUNC_NAME_KEYWORD;
import static ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory.UNRESERVED_KEYWORD;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link #KEYWORDS} list maintenance:<br><br>
 * <ol>
 * <li>Copy code from
 * <a href='https://github.com/postgres/postgres/blob/REL9_6_STABLE/src/include/parser/kwlist.h'>
 * kwlist.h</a>, use your desired stable branch.</li>
 * <li>Paste it into {@link #addKeywords(Map)}, replacing the code there.</li>
 * <li>In pasted code, replace <code>PG_KEYWORD\(("\w+"), \w+, (\w+)\)</code> by
 * <code>keywords.put($1, new Keyword($1, $2));</code> using regular expressions.</li>
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

    /*
     * Regex search and replacement strings for kwlist.h -> Java transformation:
     *
     * PG_KEYWORD\(("\w+"), \w+, (\w+)\)
     * keywords.put($1, new Keyword($1, $2));
     */
    private static void addKeywords(Map<String, Keyword> keywords) {
        keywords.put("abort", new Keyword("abort", UNRESERVED_KEYWORD));
        keywords.put("absolute", new Keyword("absolute", UNRESERVED_KEYWORD));
        keywords.put("access", new Keyword("access", UNRESERVED_KEYWORD));
        keywords.put("action", new Keyword("action", UNRESERVED_KEYWORD));
        keywords.put("add", new Keyword("add", UNRESERVED_KEYWORD));
        keywords.put("admin", new Keyword("admin", UNRESERVED_KEYWORD));
        keywords.put("after", new Keyword("after", UNRESERVED_KEYWORD));
        keywords.put("aggregate", new Keyword("aggregate", UNRESERVED_KEYWORD));
        keywords.put("all", new Keyword("all", RESERVED_KEYWORD));
        keywords.put("also", new Keyword("also", UNRESERVED_KEYWORD));
        keywords.put("alter", new Keyword("alter", UNRESERVED_KEYWORD));
        keywords.put("always", new Keyword("always", UNRESERVED_KEYWORD));
        keywords.put("analyse", new Keyword("analyse", RESERVED_KEYWORD));        /* British spelling */
        keywords.put("analyze", new Keyword("analyze", RESERVED_KEYWORD));
        keywords.put("and", new Keyword("and", RESERVED_KEYWORD));
        keywords.put("any", new Keyword("any", RESERVED_KEYWORD));
        keywords.put("array", new Keyword("array", RESERVED_KEYWORD));
        keywords.put("as", new Keyword("as", RESERVED_KEYWORD));
        keywords.put("asc", new Keyword("asc", RESERVED_KEYWORD));
        keywords.put("assertion", new Keyword("assertion", UNRESERVED_KEYWORD));
        keywords.put("assignment", new Keyword("assignment", UNRESERVED_KEYWORD));
        keywords.put("asymmetric", new Keyword("asymmetric", RESERVED_KEYWORD));
        keywords.put("at", new Keyword("at", UNRESERVED_KEYWORD));
        keywords.put("attribute", new Keyword("attribute", UNRESERVED_KEYWORD));
        keywords.put("authorization", new Keyword("authorization", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("backward", new Keyword("backward", UNRESERVED_KEYWORD));
        keywords.put("before", new Keyword("before", UNRESERVED_KEYWORD));
        keywords.put("begin", new Keyword("begin", UNRESERVED_KEYWORD));
        keywords.put("between", new Keyword("between", COL_NAME_KEYWORD));
        keywords.put("bigint", new Keyword("bigint", COL_NAME_KEYWORD));
        keywords.put("binary", new Keyword("binary", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("bit", new Keyword("bit", COL_NAME_KEYWORD));
        keywords.put("boolean", new Keyword("boolean", COL_NAME_KEYWORD));
        keywords.put("both", new Keyword("both", RESERVED_KEYWORD));
        keywords.put("by", new Keyword("by", UNRESERVED_KEYWORD));
        keywords.put("cache", new Keyword("cache", UNRESERVED_KEYWORD));
        keywords.put("called", new Keyword("called", UNRESERVED_KEYWORD));
        keywords.put("cascade", new Keyword("cascade", UNRESERVED_KEYWORD));
        keywords.put("cascaded", new Keyword("cascaded", UNRESERVED_KEYWORD));
        keywords.put("case", new Keyword("case", RESERVED_KEYWORD));
        keywords.put("cast", new Keyword("cast", RESERVED_KEYWORD));
        keywords.put("catalog", new Keyword("catalog", UNRESERVED_KEYWORD));
        keywords.put("chain", new Keyword("chain", UNRESERVED_KEYWORD));
        keywords.put("char", new Keyword("char", COL_NAME_KEYWORD));
        keywords.put("character", new Keyword("character", COL_NAME_KEYWORD));
        keywords.put("characteristics", new Keyword("characteristics", UNRESERVED_KEYWORD));
        keywords.put("check", new Keyword("check", RESERVED_KEYWORD));
        keywords.put("checkpoint", new Keyword("checkpoint", UNRESERVED_KEYWORD));
        keywords.put("class", new Keyword("class", UNRESERVED_KEYWORD));
        keywords.put("close", new Keyword("close", UNRESERVED_KEYWORD));
        keywords.put("cluster", new Keyword("cluster", UNRESERVED_KEYWORD));
        keywords.put("coalesce", new Keyword("coalesce", COL_NAME_KEYWORD));
        keywords.put("collate", new Keyword("collate", RESERVED_KEYWORD));
        keywords.put("collation", new Keyword("collation", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("column", new Keyword("column", RESERVED_KEYWORD));
        keywords.put("comment", new Keyword("comment", UNRESERVED_KEYWORD));
        keywords.put("comments", new Keyword("comments", UNRESERVED_KEYWORD));
        keywords.put("commit", new Keyword("commit", UNRESERVED_KEYWORD));
        keywords.put("committed", new Keyword("committed", UNRESERVED_KEYWORD));
        keywords.put("concurrently", new Keyword("concurrently", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("configuration", new Keyword("configuration", UNRESERVED_KEYWORD));
        keywords.put("conflict", new Keyword("conflict", UNRESERVED_KEYWORD));
        keywords.put("connection", new Keyword("connection", UNRESERVED_KEYWORD));
        keywords.put("constraint", new Keyword("constraint", RESERVED_KEYWORD));
        keywords.put("constraints", new Keyword("constraints", UNRESERVED_KEYWORD));
        keywords.put("content", new Keyword("content", UNRESERVED_KEYWORD));
        keywords.put("continue", new Keyword("continue", UNRESERVED_KEYWORD));
        keywords.put("conversion", new Keyword("conversion", UNRESERVED_KEYWORD));
        keywords.put("copy", new Keyword("copy", UNRESERVED_KEYWORD));
        keywords.put("cost", new Keyword("cost", UNRESERVED_KEYWORD));
        keywords.put("create", new Keyword("create", RESERVED_KEYWORD));
        keywords.put("cross", new Keyword("cross", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("csv", new Keyword("csv", UNRESERVED_KEYWORD));
        keywords.put("cube", new Keyword("cube", UNRESERVED_KEYWORD));
        keywords.put("current", new Keyword("current", UNRESERVED_KEYWORD));
        keywords.put("current_catalog", new Keyword("current_catalog", RESERVED_KEYWORD));
        keywords.put("current_date", new Keyword("current_date", RESERVED_KEYWORD));
        keywords.put("current_role", new Keyword("current_role", RESERVED_KEYWORD));
        keywords.put("current_schema", new Keyword("current_schema", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("current_time", new Keyword("current_time", RESERVED_KEYWORD));
        keywords.put("current_timestamp", new Keyword("current_timestamp", RESERVED_KEYWORD));
        keywords.put("current_user", new Keyword("current_user", RESERVED_KEYWORD));
        keywords.put("cursor", new Keyword("cursor", UNRESERVED_KEYWORD));
        keywords.put("cycle", new Keyword("cycle", UNRESERVED_KEYWORD));
        keywords.put("data", new Keyword("data", UNRESERVED_KEYWORD));
        keywords.put("database", new Keyword("database", UNRESERVED_KEYWORD));
        keywords.put("day", new Keyword("day", UNRESERVED_KEYWORD));
        keywords.put("deallocate", new Keyword("deallocate", UNRESERVED_KEYWORD));
        keywords.put("dec", new Keyword("dec", COL_NAME_KEYWORD));
        keywords.put("decimal", new Keyword("decimal", COL_NAME_KEYWORD));
        keywords.put("declare", new Keyword("declare", UNRESERVED_KEYWORD));
        keywords.put("default", new Keyword("default", RESERVED_KEYWORD));
        keywords.put("defaults", new Keyword("defaults", UNRESERVED_KEYWORD));
        keywords.put("deferrable", new Keyword("deferrable", RESERVED_KEYWORD));
        keywords.put("deferred", new Keyword("deferred", UNRESERVED_KEYWORD));
        keywords.put("definer", new Keyword("definer", UNRESERVED_KEYWORD));
        keywords.put("delete", new Keyword("delete", UNRESERVED_KEYWORD));
        keywords.put("delimiter", new Keyword("delimiter", UNRESERVED_KEYWORD));
        keywords.put("delimiters", new Keyword("delimiters", UNRESERVED_KEYWORD));
        keywords.put("depends", new Keyword("depends", UNRESERVED_KEYWORD));
        keywords.put("desc", new Keyword("desc", RESERVED_KEYWORD));
        keywords.put("dictionary", new Keyword("dictionary", UNRESERVED_KEYWORD));
        keywords.put("disable", new Keyword("disable", UNRESERVED_KEYWORD));
        keywords.put("discard", new Keyword("discard", UNRESERVED_KEYWORD));
        keywords.put("distinct", new Keyword("distinct", RESERVED_KEYWORD));
        keywords.put("do", new Keyword("do", RESERVED_KEYWORD));
        keywords.put("document", new Keyword("document", UNRESERVED_KEYWORD));
        keywords.put("domain", new Keyword("domain", UNRESERVED_KEYWORD));
        keywords.put("double", new Keyword("double", UNRESERVED_KEYWORD));
        keywords.put("drop", new Keyword("drop", UNRESERVED_KEYWORD));
        keywords.put("each", new Keyword("each", UNRESERVED_KEYWORD));
        keywords.put("else", new Keyword("else", RESERVED_KEYWORD));
        keywords.put("enable", new Keyword("enable", UNRESERVED_KEYWORD));
        keywords.put("encoding", new Keyword("encoding", UNRESERVED_KEYWORD));
        keywords.put("encrypted", new Keyword("encrypted", UNRESERVED_KEYWORD));
        keywords.put("end", new Keyword("end", RESERVED_KEYWORD));
        keywords.put("enum", new Keyword("enum", UNRESERVED_KEYWORD));
        keywords.put("escape", new Keyword("escape", UNRESERVED_KEYWORD));
        keywords.put("event", new Keyword("event", UNRESERVED_KEYWORD));
        keywords.put("except", new Keyword("except", RESERVED_KEYWORD));
        keywords.put("exclude", new Keyword("exclude", UNRESERVED_KEYWORD));
        keywords.put("excluding", new Keyword("excluding", UNRESERVED_KEYWORD));
        keywords.put("exclusive", new Keyword("exclusive", UNRESERVED_KEYWORD));
        keywords.put("execute", new Keyword("execute", UNRESERVED_KEYWORD));
        keywords.put("exists", new Keyword("exists", COL_NAME_KEYWORD));
        keywords.put("explain", new Keyword("explain", UNRESERVED_KEYWORD));
        keywords.put("extension", new Keyword("extension", UNRESERVED_KEYWORD));
        keywords.put("external", new Keyword("external", UNRESERVED_KEYWORD));
        keywords.put("extract", new Keyword("extract", COL_NAME_KEYWORD));
        keywords.put("false", new Keyword("false", RESERVED_KEYWORD));
        keywords.put("family", new Keyword("family", UNRESERVED_KEYWORD));
        keywords.put("fetch", new Keyword("fetch", RESERVED_KEYWORD));
        keywords.put("filter", new Keyword("filter", UNRESERVED_KEYWORD));
        keywords.put("first", new Keyword("first", UNRESERVED_KEYWORD));
        keywords.put("float", new Keyword("float", COL_NAME_KEYWORD));
        keywords.put("following", new Keyword("following", UNRESERVED_KEYWORD));
        keywords.put("for", new Keyword("for", RESERVED_KEYWORD));
        keywords.put("force", new Keyword("force", UNRESERVED_KEYWORD));
        keywords.put("foreign", new Keyword("foreign", RESERVED_KEYWORD));
        keywords.put("forward", new Keyword("forward", UNRESERVED_KEYWORD));
        keywords.put("freeze", new Keyword("freeze", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("from", new Keyword("from", RESERVED_KEYWORD));
        keywords.put("full", new Keyword("full", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("function", new Keyword("function", UNRESERVED_KEYWORD));
        keywords.put("functions", new Keyword("functions", UNRESERVED_KEYWORD));
        keywords.put("global", new Keyword("global", UNRESERVED_KEYWORD));
        keywords.put("grant", new Keyword("grant", RESERVED_KEYWORD));
        keywords.put("granted", new Keyword("granted", UNRESERVED_KEYWORD));
        keywords.put("greatest", new Keyword("greatest", COL_NAME_KEYWORD));
        keywords.put("group", new Keyword("group", RESERVED_KEYWORD));
        keywords.put("grouping", new Keyword("grouping", COL_NAME_KEYWORD));
        keywords.put("handler", new Keyword("handler", UNRESERVED_KEYWORD));
        keywords.put("having", new Keyword("having", RESERVED_KEYWORD));
        keywords.put("header", new Keyword("header", UNRESERVED_KEYWORD));
        keywords.put("hold", new Keyword("hold", UNRESERVED_KEYWORD));
        keywords.put("hour", new Keyword("hour", UNRESERVED_KEYWORD));
        keywords.put("identity", new Keyword("identity", UNRESERVED_KEYWORD));
        keywords.put("if", new Keyword("if", UNRESERVED_KEYWORD));
        keywords.put("ilike", new Keyword("ilike", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("immediate", new Keyword("immediate", UNRESERVED_KEYWORD));
        keywords.put("immutable", new Keyword("immutable", UNRESERVED_KEYWORD));
        keywords.put("implicit", new Keyword("implicit", UNRESERVED_KEYWORD));
        keywords.put("import", new Keyword("import", UNRESERVED_KEYWORD));
        keywords.put("in", new Keyword("in", RESERVED_KEYWORD));
        keywords.put("including", new Keyword("including", UNRESERVED_KEYWORD));
        keywords.put("increment", new Keyword("increment", UNRESERVED_KEYWORD));
        keywords.put("index", new Keyword("index", UNRESERVED_KEYWORD));
        keywords.put("indexes", new Keyword("indexes", UNRESERVED_KEYWORD));
        keywords.put("inherit", new Keyword("inherit", UNRESERVED_KEYWORD));
        keywords.put("inherits", new Keyword("inherits", UNRESERVED_KEYWORD));
        keywords.put("initially", new Keyword("initially", RESERVED_KEYWORD));
        keywords.put("inline", new Keyword("inline", UNRESERVED_KEYWORD));
        keywords.put("inner", new Keyword("inner", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("inout", new Keyword("inout", COL_NAME_KEYWORD));
        keywords.put("input", new Keyword("input", UNRESERVED_KEYWORD));
        keywords.put("insensitive", new Keyword("insensitive", UNRESERVED_KEYWORD));
        keywords.put("insert", new Keyword("insert", UNRESERVED_KEYWORD));
        keywords.put("instead", new Keyword("instead", UNRESERVED_KEYWORD));
        keywords.put("int", new Keyword("int", COL_NAME_KEYWORD));
        keywords.put("integer", new Keyword("integer", COL_NAME_KEYWORD));
        keywords.put("intersect", new Keyword("intersect", RESERVED_KEYWORD));
        keywords.put("interval", new Keyword("interval", COL_NAME_KEYWORD));
        keywords.put("into", new Keyword("into", RESERVED_KEYWORD));
        keywords.put("invoker", new Keyword("invoker", UNRESERVED_KEYWORD));
        keywords.put("is", new Keyword("is", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("isnull", new Keyword("isnull", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("isolation", new Keyword("isolation", UNRESERVED_KEYWORD));
        keywords.put("join", new Keyword("join", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("key", new Keyword("key", UNRESERVED_KEYWORD));
        keywords.put("label", new Keyword("label", UNRESERVED_KEYWORD));
        keywords.put("language", new Keyword("language", UNRESERVED_KEYWORD));
        keywords.put("large", new Keyword("large", UNRESERVED_KEYWORD));
        keywords.put("last", new Keyword("last", UNRESERVED_KEYWORD));
        keywords.put("lateral", new Keyword("lateral", RESERVED_KEYWORD));
        keywords.put("leading", new Keyword("leading", RESERVED_KEYWORD));
        keywords.put("leakproof", new Keyword("leakproof", UNRESERVED_KEYWORD));
        keywords.put("least", new Keyword("least", COL_NAME_KEYWORD));
        keywords.put("left", new Keyword("left", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("level", new Keyword("level", UNRESERVED_KEYWORD));
        keywords.put("like", new Keyword("like", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("limit", new Keyword("limit", RESERVED_KEYWORD));
        keywords.put("listen", new Keyword("listen", UNRESERVED_KEYWORD));
        keywords.put("load", new Keyword("load", UNRESERVED_KEYWORD));
        keywords.put("local", new Keyword("local", UNRESERVED_KEYWORD));
        keywords.put("localtime", new Keyword("localtime", RESERVED_KEYWORD));
        keywords.put("localtimestamp", new Keyword("localtimestamp", RESERVED_KEYWORD));
        keywords.put("location", new Keyword("location", UNRESERVED_KEYWORD));
        keywords.put("lock", new Keyword("lock", UNRESERVED_KEYWORD));
        keywords.put("locked", new Keyword("locked", UNRESERVED_KEYWORD));
        keywords.put("logged", new Keyword("logged", UNRESERVED_KEYWORD));
        keywords.put("mapping", new Keyword("mapping", UNRESERVED_KEYWORD));
        keywords.put("match", new Keyword("match", UNRESERVED_KEYWORD));
        keywords.put("materialized", new Keyword("materialized", UNRESERVED_KEYWORD));
        keywords.put("maxvalue", new Keyword("maxvalue", UNRESERVED_KEYWORD));
        keywords.put("method", new Keyword("method", UNRESERVED_KEYWORD));
        keywords.put("minute", new Keyword("minute", UNRESERVED_KEYWORD));
        keywords.put("minvalue", new Keyword("minvalue", UNRESERVED_KEYWORD));
        keywords.put("mode", new Keyword("mode", UNRESERVED_KEYWORD));
        keywords.put("month", new Keyword("month", UNRESERVED_KEYWORD));
        keywords.put("move", new Keyword("move", UNRESERVED_KEYWORD));
        keywords.put("name", new Keyword("name", UNRESERVED_KEYWORD));
        keywords.put("names", new Keyword("names", UNRESERVED_KEYWORD));
        keywords.put("national", new Keyword("national", COL_NAME_KEYWORD));
        keywords.put("natural", new Keyword("natural", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("nchar", new Keyword("nchar", COL_NAME_KEYWORD));
        keywords.put("next", new Keyword("next", UNRESERVED_KEYWORD));
        keywords.put("no", new Keyword("no", UNRESERVED_KEYWORD));
        keywords.put("none", new Keyword("none", COL_NAME_KEYWORD));
        keywords.put("not", new Keyword("not", RESERVED_KEYWORD));
        keywords.put("nothing", new Keyword("nothing", UNRESERVED_KEYWORD));
        keywords.put("notify", new Keyword("notify", UNRESERVED_KEYWORD));
        keywords.put("notnull", new Keyword("notnull", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("nowait", new Keyword("nowait", UNRESERVED_KEYWORD));
        keywords.put("null", new Keyword("null", RESERVED_KEYWORD));
        keywords.put("nullif", new Keyword("nullif", COL_NAME_KEYWORD));
        keywords.put("nulls", new Keyword("nulls", UNRESERVED_KEYWORD));
        keywords.put("numeric", new Keyword("numeric", COL_NAME_KEYWORD));
        keywords.put("object", new Keyword("object", UNRESERVED_KEYWORD));
        keywords.put("of", new Keyword("of", UNRESERVED_KEYWORD));
        keywords.put("off", new Keyword("off", UNRESERVED_KEYWORD));
        keywords.put("offset", new Keyword("offset", RESERVED_KEYWORD));
        keywords.put("oids", new Keyword("oids", UNRESERVED_KEYWORD));
        keywords.put("on", new Keyword("on", RESERVED_KEYWORD));
        keywords.put("only", new Keyword("only", RESERVED_KEYWORD));
        keywords.put("operator", new Keyword("operator", UNRESERVED_KEYWORD));
        keywords.put("option", new Keyword("option", UNRESERVED_KEYWORD));
        keywords.put("options", new Keyword("options", UNRESERVED_KEYWORD));
        keywords.put("or", new Keyword("or", RESERVED_KEYWORD));
        keywords.put("order", new Keyword("order", RESERVED_KEYWORD));
        keywords.put("ordinality", new Keyword("ordinality", UNRESERVED_KEYWORD));
        keywords.put("out", new Keyword("out", COL_NAME_KEYWORD));
        keywords.put("outer", new Keyword("outer", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("over", new Keyword("over", UNRESERVED_KEYWORD));
        keywords.put("overlaps", new Keyword("overlaps", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("overlay", new Keyword("overlay", COL_NAME_KEYWORD));
        keywords.put("owned", new Keyword("owned", UNRESERVED_KEYWORD));
        keywords.put("owner", new Keyword("owner", UNRESERVED_KEYWORD));
        keywords.put("parallel", new Keyword("parallel", UNRESERVED_KEYWORD));
        keywords.put("parser", new Keyword("parser", UNRESERVED_KEYWORD));
        keywords.put("partial", new Keyword("partial", UNRESERVED_KEYWORD));
        keywords.put("partition", new Keyword("partition", UNRESERVED_KEYWORD));
        keywords.put("passing", new Keyword("passing", UNRESERVED_KEYWORD));
        keywords.put("password", new Keyword("password", UNRESERVED_KEYWORD));
        keywords.put("placing", new Keyword("placing", RESERVED_KEYWORD));
        keywords.put("plans", new Keyword("plans", UNRESERVED_KEYWORD));
        keywords.put("policy", new Keyword("policy", UNRESERVED_KEYWORD));
        keywords.put("position", new Keyword("position", COL_NAME_KEYWORD));
        keywords.put("preceding", new Keyword("preceding", UNRESERVED_KEYWORD));
        keywords.put("precision", new Keyword("precision", COL_NAME_KEYWORD));
        keywords.put("prepare", new Keyword("prepare", UNRESERVED_KEYWORD));
        keywords.put("prepared", new Keyword("prepared", UNRESERVED_KEYWORD));
        keywords.put("preserve", new Keyword("preserve", UNRESERVED_KEYWORD));
        keywords.put("primary", new Keyword("primary", RESERVED_KEYWORD));
        keywords.put("prior", new Keyword("prior", UNRESERVED_KEYWORD));
        keywords.put("privileges", new Keyword("privileges", UNRESERVED_KEYWORD));
        keywords.put("procedural", new Keyword("procedural", UNRESERVED_KEYWORD));
        keywords.put("procedure", new Keyword("procedure", UNRESERVED_KEYWORD));
        keywords.put("program", new Keyword("program", UNRESERVED_KEYWORD));
        keywords.put("quote", new Keyword("quote", UNRESERVED_KEYWORD));
        keywords.put("range", new Keyword("range", UNRESERVED_KEYWORD));
        keywords.put("read", new Keyword("read", UNRESERVED_KEYWORD));
        keywords.put("real", new Keyword("real", COL_NAME_KEYWORD));
        keywords.put("reassign", new Keyword("reassign", UNRESERVED_KEYWORD));
        keywords.put("recheck", new Keyword("recheck", UNRESERVED_KEYWORD));
        keywords.put("recursive", new Keyword("recursive", UNRESERVED_KEYWORD));
        keywords.put("ref", new Keyword("ref", UNRESERVED_KEYWORD));
        keywords.put("references", new Keyword("references", RESERVED_KEYWORD));
        keywords.put("refresh", new Keyword("refresh", UNRESERVED_KEYWORD));
        keywords.put("reindex", new Keyword("reindex", UNRESERVED_KEYWORD));
        keywords.put("relative", new Keyword("relative", UNRESERVED_KEYWORD));
        keywords.put("release", new Keyword("release", UNRESERVED_KEYWORD));
        keywords.put("rename", new Keyword("rename", UNRESERVED_KEYWORD));
        keywords.put("repeatable", new Keyword("repeatable", UNRESERVED_KEYWORD));
        keywords.put("replace", new Keyword("replace", UNRESERVED_KEYWORD));
        keywords.put("replica", new Keyword("replica", UNRESERVED_KEYWORD));
        keywords.put("reset", new Keyword("reset", UNRESERVED_KEYWORD));
        keywords.put("restart", new Keyword("restart", UNRESERVED_KEYWORD));
        keywords.put("restrict", new Keyword("restrict", UNRESERVED_KEYWORD));
        keywords.put("returning", new Keyword("returning", RESERVED_KEYWORD));
        keywords.put("returns", new Keyword("returns", UNRESERVED_KEYWORD));
        keywords.put("revoke", new Keyword("revoke", UNRESERVED_KEYWORD));
        keywords.put("right", new Keyword("right", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("role", new Keyword("role", UNRESERVED_KEYWORD));
        keywords.put("rollback", new Keyword("rollback", UNRESERVED_KEYWORD));
        keywords.put("rollup", new Keyword("rollup", UNRESERVED_KEYWORD));
        keywords.put("row", new Keyword("row", COL_NAME_KEYWORD));
        keywords.put("rows", new Keyword("rows", UNRESERVED_KEYWORD));
        keywords.put("rule", new Keyword("rule", UNRESERVED_KEYWORD));
        keywords.put("savepoint", new Keyword("savepoint", UNRESERVED_KEYWORD));
        keywords.put("schema", new Keyword("schema", UNRESERVED_KEYWORD));
        keywords.put("scroll", new Keyword("scroll", UNRESERVED_KEYWORD));
        keywords.put("search", new Keyword("search", UNRESERVED_KEYWORD));
        keywords.put("second", new Keyword("second", UNRESERVED_KEYWORD));
        keywords.put("security", new Keyword("security", UNRESERVED_KEYWORD));
        keywords.put("select", new Keyword("select", RESERVED_KEYWORD));
        keywords.put("sequence", new Keyword("sequence", UNRESERVED_KEYWORD));
        keywords.put("sequences", new Keyword("sequences", UNRESERVED_KEYWORD));
        keywords.put("serializable", new Keyword("serializable", UNRESERVED_KEYWORD));
        keywords.put("server", new Keyword("server", UNRESERVED_KEYWORD));
        keywords.put("session", new Keyword("session", UNRESERVED_KEYWORD));
        keywords.put("session_user", new Keyword("session_user", RESERVED_KEYWORD));
        keywords.put("set", new Keyword("set", UNRESERVED_KEYWORD));
        keywords.put("setof", new Keyword("setof", COL_NAME_KEYWORD));
        keywords.put("sets", new Keyword("sets", UNRESERVED_KEYWORD));
        keywords.put("share", new Keyword("share", UNRESERVED_KEYWORD));
        keywords.put("show", new Keyword("show", UNRESERVED_KEYWORD));
        keywords.put("similar", new Keyword("similar", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("simple", new Keyword("simple", UNRESERVED_KEYWORD));
        keywords.put("skip", new Keyword("skip", UNRESERVED_KEYWORD));
        keywords.put("smallint", new Keyword("smallint", COL_NAME_KEYWORD));
        keywords.put("snapshot", new Keyword("snapshot", UNRESERVED_KEYWORD));
        keywords.put("some", new Keyword("some", RESERVED_KEYWORD));
        keywords.put("sql", new Keyword("sql", UNRESERVED_KEYWORD));
        keywords.put("stable", new Keyword("stable", UNRESERVED_KEYWORD));
        keywords.put("standalone", new Keyword("standalone", UNRESERVED_KEYWORD));
        keywords.put("start", new Keyword("start", UNRESERVED_KEYWORD));
        keywords.put("statement", new Keyword("statement", UNRESERVED_KEYWORD));
        keywords.put("statistics", new Keyword("statistics", UNRESERVED_KEYWORD));
        keywords.put("stdin", new Keyword("stdin", UNRESERVED_KEYWORD));
        keywords.put("stdout", new Keyword("stdout", UNRESERVED_KEYWORD));
        keywords.put("storage", new Keyword("storage", UNRESERVED_KEYWORD));
        keywords.put("strict", new Keyword("strict", UNRESERVED_KEYWORD));
        keywords.put("strip", new Keyword("strip", UNRESERVED_KEYWORD));
        keywords.put("substring", new Keyword("substring", COL_NAME_KEYWORD));
        keywords.put("symmetric", new Keyword("symmetric", RESERVED_KEYWORD));
        keywords.put("sysid", new Keyword("sysid", UNRESERVED_KEYWORD));
        keywords.put("system", new Keyword("system", UNRESERVED_KEYWORD));
        keywords.put("table", new Keyword("table", RESERVED_KEYWORD));
        keywords.put("tables", new Keyword("tables", UNRESERVED_KEYWORD));
        keywords.put("tablesample", new Keyword("tablesample", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("tablespace", new Keyword("tablespace", UNRESERVED_KEYWORD));
        keywords.put("temp", new Keyword("temp", UNRESERVED_KEYWORD));
        keywords.put("template", new Keyword("template", UNRESERVED_KEYWORD));
        keywords.put("temporary", new Keyword("temporary", UNRESERVED_KEYWORD));
        keywords.put("text", new Keyword("text", UNRESERVED_KEYWORD));
        keywords.put("then", new Keyword("then", RESERVED_KEYWORD));
        keywords.put("time", new Keyword("time", COL_NAME_KEYWORD));
        keywords.put("timestamp", new Keyword("timestamp", COL_NAME_KEYWORD));
        keywords.put("to", new Keyword("to", RESERVED_KEYWORD));
        keywords.put("trailing", new Keyword("trailing", RESERVED_KEYWORD));
        keywords.put("transaction", new Keyword("transaction", UNRESERVED_KEYWORD));
        keywords.put("transform", new Keyword("transform", UNRESERVED_KEYWORD));
        keywords.put("treat", new Keyword("treat", COL_NAME_KEYWORD));
        keywords.put("trigger", new Keyword("trigger", UNRESERVED_KEYWORD));
        keywords.put("trim", new Keyword("trim", COL_NAME_KEYWORD));
        keywords.put("true", new Keyword("true", RESERVED_KEYWORD));
        keywords.put("truncate", new Keyword("truncate", UNRESERVED_KEYWORD));
        keywords.put("trusted", new Keyword("trusted", UNRESERVED_KEYWORD));
        keywords.put("type", new Keyword("type", UNRESERVED_KEYWORD));
        keywords.put("types", new Keyword("types", UNRESERVED_KEYWORD));
        keywords.put("unbounded", new Keyword("unbounded", UNRESERVED_KEYWORD));
        keywords.put("uncommitted", new Keyword("uncommitted", UNRESERVED_KEYWORD));
        keywords.put("unencrypted", new Keyword("unencrypted", UNRESERVED_KEYWORD));
        keywords.put("union", new Keyword("union", RESERVED_KEYWORD));
        keywords.put("unique", new Keyword("unique", RESERVED_KEYWORD));
        keywords.put("unknown", new Keyword("unknown", UNRESERVED_KEYWORD));
        keywords.put("unlisten", new Keyword("unlisten", UNRESERVED_KEYWORD));
        keywords.put("unlogged", new Keyword("unlogged", UNRESERVED_KEYWORD));
        keywords.put("until", new Keyword("until", UNRESERVED_KEYWORD));
        keywords.put("update", new Keyword("update", UNRESERVED_KEYWORD));
        keywords.put("user", new Keyword("user", RESERVED_KEYWORD));
        keywords.put("using", new Keyword("using", RESERVED_KEYWORD));
        keywords.put("vacuum", new Keyword("vacuum", UNRESERVED_KEYWORD));
        keywords.put("valid", new Keyword("valid", UNRESERVED_KEYWORD));
        keywords.put("validate", new Keyword("validate", UNRESERVED_KEYWORD));
        keywords.put("validator", new Keyword("validator", UNRESERVED_KEYWORD));
        keywords.put("value", new Keyword("value", UNRESERVED_KEYWORD));
        keywords.put("values", new Keyword("values", COL_NAME_KEYWORD));
        keywords.put("varchar", new Keyword("varchar", COL_NAME_KEYWORD));
        keywords.put("variadic", new Keyword("variadic", RESERVED_KEYWORD));
        keywords.put("varying", new Keyword("varying", UNRESERVED_KEYWORD));
        keywords.put("verbose", new Keyword("verbose", TYPE_FUNC_NAME_KEYWORD));
        keywords.put("version", new Keyword("version", UNRESERVED_KEYWORD));
        keywords.put("view", new Keyword("view", UNRESERVED_KEYWORD));
        keywords.put("views", new Keyword("views", UNRESERVED_KEYWORD));
        keywords.put("volatile", new Keyword("volatile", UNRESERVED_KEYWORD));
        keywords.put("when", new Keyword("when", RESERVED_KEYWORD));
        keywords.put("where", new Keyword("where", RESERVED_KEYWORD));
        keywords.put("whitespace", new Keyword("whitespace", UNRESERVED_KEYWORD));
        keywords.put("window", new Keyword("window", RESERVED_KEYWORD));
        keywords.put("with", new Keyword("with", RESERVED_KEYWORD));
        keywords.put("within", new Keyword("within", UNRESERVED_KEYWORD));
        keywords.put("without", new Keyword("without", UNRESERVED_KEYWORD));
        keywords.put("work", new Keyword("work", UNRESERVED_KEYWORD));
        keywords.put("wrapper", new Keyword("wrapper", UNRESERVED_KEYWORD));
        keywords.put("write", new Keyword("write", UNRESERVED_KEYWORD));
        keywords.put("xml", new Keyword("xml", UNRESERVED_KEYWORD));
        keywords.put("xmlattributes", new Keyword("xmlattributes", COL_NAME_KEYWORD));
        keywords.put("xmlconcat", new Keyword("xmlconcat", COL_NAME_KEYWORD));
        keywords.put("xmlelement", new Keyword("xmlelement", COL_NAME_KEYWORD));
        keywords.put("xmlexists", new Keyword("xmlexists", COL_NAME_KEYWORD));
        keywords.put("xmlforest", new Keyword("xmlforest", COL_NAME_KEYWORD));
        keywords.put("xmlparse", new Keyword("xmlparse", COL_NAME_KEYWORD));
        keywords.put("xmlpi", new Keyword("xmlpi", COL_NAME_KEYWORD));
        keywords.put("xmlroot", new Keyword("xmlroot", COL_NAME_KEYWORD));
        keywords.put("xmlserialize", new Keyword("xmlserialize", COL_NAME_KEYWORD));
        keywords.put("year", new Keyword("year", UNRESERVED_KEYWORD));
        keywords.put("yes", new Keyword("yes", UNRESERVED_KEYWORD));
        keywords.put("zone", new Keyword("zone", UNRESERVED_KEYWORD));
    }

    static {
        Map<String, Keyword> keywords = new HashMap<>();
        addKeywords(keywords);
        KEYWORDS = Collections.unmodifiableMap(keywords);
    }

    private final String keyword;
    private final KeywordCategory category;

    public Keyword(String keyword, KeywordCategory category) {
        this.keyword = keyword;
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public KeywordCategory getCategory() {
        return category;
    }
}
