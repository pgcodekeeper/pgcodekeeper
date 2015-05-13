package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.BOTH;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.LEFT;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.RIGHT;

import java.util.Comparator;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CompareTree implements Comparator<TreeElement> {
    
    private static final int LESS = -1;
    private static final int MORE = 1;
    
    private final PgDatabase oldDB;
    private final PgDatabase newDB;

    public CompareTree(PgDatabase oldDbFull, PgDatabase newDbFull) {
        this.oldDB = oldDbFull;
        this.newDB = newDbFull;
    }

    @Override
    public int compare(TreeElement o1, TreeElement o2) {
        DiffSide s1 = o1.getSide();
        DiffSide s2 = o2.getSide();
        int res = compareTypes(o1, o2);
        if (s1 == s2) {
            if (s1 == LEFT) {
                return -res;
            } else {
                return res;
            }
        } else {
            if (s1 == LEFT && s2 != LEFT) {
                return LESS;
            }
            if (s2 == LEFT && s1 != LEFT) {
                return MORE;
            }
            if (res == 0) {
                if (s1 == RIGHT) {
                    return LESS;
                }
                if (s1 == BOTH) {
                    return MORE;
                }
            } else {
                return res;
            }
        }
        throw new IllegalStateException("Missing compare case");
    }

    /**
     * Сравнивает и возвращает порядок в списке типов объектов так как нужно
     */
    private int compareTypes(TreeElement o1, TreeElement o2) {
        int res = o1.getType().ordinal() - o2.getType().ordinal();
        
        // TODO КОСТЫЛЬ ДЛЯ PRIMARY KEYS
        if (oldDB!= null && newDB != null
                && res == 0 
                && o1.getType() == DbObjType.CONSTRAINT) {
            boolean isPkey1 = ((PgConstraint) getStatement(o1)).isPrimaryKeyConstraint();
            boolean isPkey2 = ((PgConstraint) getStatement(o2)).isPrimaryKeyConstraint();
            if (isPkey1 != isPkey2) {
                res = isPkey1 ? LESS : MORE;
            }
        }
        //----------------КОСТЫЛЬ
        return res;
    }

    private PgStatement getStatement(TreeElement o1) {
        switch (o1.getSide()) {
        case BOTH:
        case LEFT:
            return o1.getPgStatement(oldDB);
        case RIGHT:
            return o1.getPgStatement(newDB);
        }
        return null;
    }
}