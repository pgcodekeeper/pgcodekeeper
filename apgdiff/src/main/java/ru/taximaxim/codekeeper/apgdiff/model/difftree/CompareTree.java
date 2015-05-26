package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.BOTH;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.LEFT;
import static ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide.RIGHT;

import java.util.Comparator;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class CompareTree implements Comparator<TreeElement> {
    
    private static final int LESS = -1;
    private static final int MORE = 1;

    public CompareTree() {
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
        return o1.getType().ordinal() - o2.getType().ordinal();
    }
}
