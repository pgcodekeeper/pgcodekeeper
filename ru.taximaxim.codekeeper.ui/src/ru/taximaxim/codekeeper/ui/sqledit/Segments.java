package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.Position;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Segments extends Position {
    private String name;
    private DbObjType type;
    private StatementActions action;

    /**
     * Creates a new segment covering the given range.
     *
     * @param offset the offset of the segment
     * @param length the length of the segment
     */
    public Segments(PgObjLocation loc) {
        super(loc.getOffset(), loc.getObjLength());
        this.name = loc.getObjName();
        this.type = loc.getObjType();
        this.action = loc.getAction();
    }

    public DbObjType getType() {
        return type;
    }

    @Override
    public String toString() {
        return action.toString() + ' ' + name;
    }
}
