package ru.taximaxim.codekeeper.apgdiff.model.graph;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class PrintObj {
    private final PgStatement actualSt;
    private final PgStatement previousSt;
    private final int indent;
    private final int hiddenObj;

    public PrintObj(PgStatement actualSt, PgStatement previousSt, int indent, int hiddenObj) {
        this.actualSt = actualSt;
        this.previousSt = previousSt;
        this.indent = indent;
        this.hiddenObj = hiddenObj;
    }

    public PgStatement getActualStSt() {
        return actualSt;
    }

    public PgStatement getPreviousSt() {
        return previousSt;
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
        result = prime * result + ((actualSt == null) ? 0 : actualSt.hashCode());
        result = prime * result + indent;
        result = prime * result + ((previousSt == null) ? 0 : previousSt.hashCode());
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
        if (actualSt == null) {
            if (other.actualSt != null) {
                return false;
            }
        } else if (!actualSt.equals(other.actualSt)) {
            return false;
        }
        if (indent != other.indent) {
            return false;
        }
        if (previousSt == null) {
            if (other.previousSt != null) {
                return false;
            }
        } else if (!previousSt.equals(other.previousSt)) {
            return false;
        }
        return true;
    }
}
