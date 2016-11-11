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
    private boolean isShow;
    private boolean isRegular;
    private boolean ignoreContent;
    // TODO db

    public IgnoredObject(String name, boolean isRegular, boolean ignoreContent) {
        this(name, false, isRegular, ignoreContent);
    }

    public IgnoredObject(String name, boolean isShow, boolean isRegular, boolean ignoreContent) {
        this.name = name;
        this.isShow = isShow;
        this.isRegular = isRegular;
        this.ignoreContent = ignoreContent;
        this.regex = isRegular ? Pattern.compile(
                name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE) : null;
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
        if (isRegular) {
            return regex.matcher(objName).find();
        } else {
            return name.equals(objName);
        }
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof IgnoredObject) {
            IgnoredObject other = (IgnoredObject) obj;
            eq = ignoreContent == other.ignoreContent
                    && isRegular == other.isRegular
                    && Objects.equals(name, other.name);
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

        if (PgDiffUtils.isValidId(name, true, true)) {
            sb.append(name);
        } else {
            sb.append(quoteWithDq(name) ? PgDiffUtils.quoteName(name) : PgDiffUtils.quoteString(name));
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