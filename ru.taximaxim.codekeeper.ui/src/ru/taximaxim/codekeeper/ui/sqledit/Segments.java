package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Objects;

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

    protected boolean compare(Object obj) {
        if (obj instanceof Segments) {
            Segments sg = (Segments) obj;
            return getOffset() == sg.getOffset()
                    && getLength() == sg.getLength()
                    && isDeleted() == sg.isDeleted()
                    && Objects.equals(name, sg.name)
                    && type == sg.type
                    && Objects.equals(action, sg.action);
        }
        return false;
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
    public final boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        return this.compare(obj);
    }
}
