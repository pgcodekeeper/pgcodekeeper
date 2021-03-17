package ru.taximaxim.codekeeper.apgdiff.model.graph;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class PrintObj {
    private final PgStatement statement;
    private final PgStatement parentSt;
    private final int indent;
    private final int hiddenObj;

    public PrintObj(PgStatement statement, PgStatement parentSt, int indent, int hiddenObj) {
        this.statement = statement;
        this.parentSt = parentSt;
        this.indent = indent;
        this.hiddenObj = hiddenObj;
    }

    public PgStatement getStatement() {
        return statement;
    }

    public PgStatement getParentSt() {
        return parentSt;
    }

    public int getIndent() {
        return indent;
    }

    public int getHiddenObj() {
        return hiddenObj;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((statement == null) ? 0 : statement.hashCode());
        result = prime * result + indent;
        result = prime * result + ((parentSt == null) ? 0 : parentSt.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PrintObj other = (PrintObj) obj;
        if (statement == null) {
            if (other.statement != null) {
                return false;
            }
        } else if (!statement.equals(other.statement)) {
            return false;
        }
        if (indent != other.indent) {
            return false;
        }
        if (parentSt == null) {
            if (other.parentSt != null) {
                return false;
            }
        } else if (!parentSt.equals(other.parentSt)) {
            return false;
        }
        return true;
    }
}
