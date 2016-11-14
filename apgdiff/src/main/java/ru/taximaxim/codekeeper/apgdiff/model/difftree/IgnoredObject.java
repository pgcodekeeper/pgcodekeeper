package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.Objects;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class IgnoredObject {

    public enum AddStatus {
        ADD, ADD_SUBTREE, SKIP, SKIP_SUBTREE
    }

    private final String name;
    private final Pattern regex;
    private final String dbRegexStr;
    private final Pattern dbRegex;
    private boolean isShow;
    private boolean isRegular;
    private boolean ignoreContent;

    public IgnoredObject(String name, boolean isRegular, boolean ignoreContent) {
        this(name, null, false, isRegular, ignoreContent);
    }

    public IgnoredObject(String name, String dbRegex, boolean isShow, boolean isRegular,
            boolean ignoreContent) {
        this.name = name;
        this.isShow = isShow;
        this.isRegular = isRegular;
        this.ignoreContent = ignoreContent;
        this.regex = isRegular ? Pattern.compile(name) : null;
        this.dbRegexStr = dbRegex;
        this.dbRegex = dbRegex == null ? null : Pattern.compile(dbRegex);
    }

    public String getName() {
        return name;
    }

    public boolean isShow() {
        return isShow;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public boolean isIgnoreContent() {
        return ignoreContent;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public void setRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public void setIgnoreContent(boolean ignoreContent) {
        this.ignoreContent = ignoreContent;
    }

    public boolean match(String objName) {
        return match(objName, (String[]) null);
    }

    public boolean match(String objName, String... dbNames) {
        boolean matches;
        if (isRegular) {
            matches = regex.matcher(objName).find();
        } else {
            matches = name.equals(objName);
        }
        if (matches && dbRegex != null) {
            if (dbNames != null && dbNames.length != 0) {
                boolean foundDbMatch = false;
                for (String dbName : dbNames) {
                    if (dbName != null && dbRegex.matcher(dbName).find()) {
                        foundDbMatch = true;
                        break;
                    }
                }
                matches &= foundDbMatch;
            } else {
                matches = false;
            }
        }
        return matches;
    }

    boolean hasSameMatchingCondition(IgnoredObject rule) {
        return Objects.equals(name, rule.name) && Objects.equals(dbRegexStr, rule.dbRegexStr);
    }

    public AddStatus getAddStatus() {
        if (isShow) {
            return ignoreContent ? AddStatus.ADD_SUBTREE : AddStatus.ADD;
        } else {
            return ignoreContent ? AddStatus.SKIP_SUBTREE : AddStatus.SKIP;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + (ignoreContent ? itrue : ifalse);
        result = prime * result + (isRegular ? itrue : ifalse);
        result = prime * result + (isShow ? itrue : ifalse);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((dbRegexStr == null) ? 0 : dbRegexStr.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof IgnoredObject) {
            IgnoredObject other = (IgnoredObject) obj;
            eq = ignoreContent == other.ignoreContent
                    && isRegular == other.isRegular
                    && isShow == other.isShow
                    && Objects.equals(name, other.name)
                    && Objects.equals(dbRegexStr, other.dbRegexStr);
        }
        return eq;
    }


    @Override
    public String toString() {
        return appendRuleCode(new StringBuilder()).toString();
    }

    StringBuilder appendRuleCode(StringBuilder sb) {
        sb.append(isShow ? "SHOW " : "HIDE ");
        if (isRegular || ignoreContent) {
            if (ignoreContent) {
                sb.append("CONTENT");
                if (isRegular) {
                    sb.append(',');
                }
            }
            if (isRegular) {
                sb.append("REGEX");
            }
        } else {
            sb.append("NONE");
        }
        sb.append(' ');

        appendId(name, sb);
        if (dbRegex != null) {
            sb.append(" db=");
            appendId(dbRegexStr, sb);
        }
        return sb;
    }

    private static StringBuilder appendId(String id, StringBuilder sb) {
        if (PgDiffUtils.isValidId(id, true, true)) {
            sb.append(id);
        } else {
            sb.append(quoteWithDq(id) ? PgDiffUtils.quoteName(id) : PgDiffUtils.quoteString(id));
        }
        return sb;
    }

    private static boolean quoteWithDq(String str) {
        int dq = 0, sq = 0;
        for (int i = 0; i < str.length(); ++i) {
            switch (str.charAt(i)) {
            case '\'': ++sq; break;
            case '"' : ++dq; break;
            }
        }
        return sq > dq;
    }
}