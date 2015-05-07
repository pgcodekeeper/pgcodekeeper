package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.BOTH;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.LEFT;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.RIGHT;

import java.util.Comparator;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CompareTree implements Comparator<TreeElement> {
    private static final int LESS = -1;
    private static final int BIGGER = 1;
    private PgDatabase oldDB;
    private PgDatabase newDB;

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
                return BIGGER;
            }
            if (res == 0) {
                if (s1 == RIGHT) {
                    return LESS;
                }
                if (s1 == BOTH) {
                    return BIGGER;
                }
            } else {
                return res;
            }
        }
        throw new IllegalStateException("Missing compare case");
    }

    /**
     * Сравнивает и возвращает порядок в списке типов объектов так как нужно
     * 
     * @param o1
     * @param o2
     * @return
     */
    private int compareTypes(TreeElement o1, TreeElement o2) {
        int res = o1.getType().ordinal() - o2.getType().ordinal();
        // TODO КОСТЫЛЬ ДЛЯ PRIMARY KEYS
        if (oldDB!= null
                && newDB != null
                && res == 0 
                && o1.getType() == DbObjType.CONSTRAINT) {
            PgConstraint const1 = getElement(o1);
            PgConstraint const2 = getElement(o2);
            if (const1.isPrimaryKeyConstraint() != const2.isPrimaryKeyConstraint()) {
                if (const1.isPrimaryKeyConstraint()) {
                    res = LESS;
                } else {
                    res = BIGGER;
                }
            }
        }
        //----------------КОСТЫЛЬ
        return res;
    }

    private PgConstraint getElement(TreeElement o1) {
        switch (o1.getSide()) {
        case BOTH:
        case LEFT:
            return (PgConstraint)o1.getPgStatement(oldDB);
        case RIGHT:
            return (PgConstraint)o1.getPgStatement(newDB);
        }
        return null;
    }
}