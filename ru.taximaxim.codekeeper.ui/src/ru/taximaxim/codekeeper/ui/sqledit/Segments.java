package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.Position;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Segments extends Position {

    private final String name;
    private final DbObjType type;
    private final String action;

    /**
     * Creates a new segment covering the given range.
     *
     * @param offset the offset of the segment
     * @param length the length of the segment
     */
    public Segments(PgObjLocation loc) {
        super(loc.getOffset(), loc.getObjLength());
        this.name = loc.getObjName();
        this.type = loc.getType();
        this.action = loc.getAction();
    }

    public DbObjType getType() {
        return type;
    }

    @Override
    public String toString() {
        return action + ' ' + name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Segments other = (Segments) obj;
        if (action == null && other.action != null) {
            return false;
        } else if (!action.equals(other.action)) {
            return false;
        }
        if (name == null && other.name != null) {
            return false;
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }
}
