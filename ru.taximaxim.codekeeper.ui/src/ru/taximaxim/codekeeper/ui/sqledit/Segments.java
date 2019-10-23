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

        String act = loc.getAction();
        if (act.contains("INSERT")) {
            act = "INSERT INTO " + act.substring(act.lastIndexOf('.') + 1);
        } else if (act.contains("DELETE")) {
            act = "DELETE FROM " + act.substring(act.lastIndexOf('.') + 1);
        }
        this.action = act;
    }

    public DbObjType getType() {
        return type;
    }

    @Override
    public String toString() {
        return action + ' ' + name;
    }
}
