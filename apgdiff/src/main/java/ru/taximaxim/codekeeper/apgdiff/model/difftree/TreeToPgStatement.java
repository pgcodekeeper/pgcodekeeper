package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class TreeToPgStatement {

    private final PgDatabase dbSource, dbTarget;
    /**
     * Tree representation of user selected changes
     */
    private final TreeElement root;

    public TreeToPgStatement(PgDatabase dbSource, PgDatabase dbTarget,
            TreeElement root) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.root = root;
    }

    public List<PgStatement> apply() {
        List<PgStatement> dbFiltered = new ArrayList<>();
        List<TreeElement> filteredElements = new ArrayList<TreeElement>();
        getSelected(root, filteredElements);
        Collections.sort(filteredElements, new CompareTree());
        for (TreeElement el : filteredElements) {
            PgStatement st = null;
            switch (el.getSide()) {
            case LEFT:
                st = el.getPgStatement(dbSource);
                break;
            case RIGHT:
                st = el.getPgStatement(dbTarget);
            case BOTH:
                st = el.getPgStatement(dbTarget);
            }
            if (st != null) {
                dbFiltered.add(st);
            } else {
                new IllegalStateException(el.getName() + " " + el.getSide()
                        + " was null");
            }
        }
        return dbFiltered;
    }

    private void getSelected(TreeElement el, List<TreeElement> filtered) {
        // Если элемент или его дети не выбраны, его добавлять не нужно
        if (!el.isSelected()) {
            return;
        }
        filtered.add(el);

        for (TreeElement sub : el.getChildren()) {
            getSelected(sub, filtered);
        }
    }

    private static class CompareTree implements Comparator<TreeElement> {
        int less = -1;
        int bigger = 1;
        int equal = 0;

        @Override
        public int compare(TreeElement o1, TreeElement o2) {
            // типы равны
            int res = compareTypes(o1, o2);
            if (res == equal) {
                // стороны равны
                if (o1.getSide() == o2.getSide()) {
                    return equal;
                }
                // объект со стороной left всегда больше
                if (o1.getSide() == DiffSide.LEFT) {
                    return less;
                }
                if (o2.getSide() == DiffSide.LEFT) {
                    return bigger;
                }
                // далее если объект с правой стороной он больше
                if (o1.getSide() == DiffSide.RIGHT) {
                    return less;
                }
                if (o2.getSide() == DiffSide.RIGHT) {
                    return bigger;
                }
                // иначе нужно сравнить объекты both
                if (o1.getSide().ordinal() > o2.getSide().ordinal()) {
                    return bigger;
                } else {
                    return less;
                }
            }
            // типы различаются
            // стороны равны
            if (o1.getSide() == o2.getSide()) {
                return res;
            }
            // объект со стороной left всегда больше
            if (o1.getSide() == DiffSide.LEFT) {
                return less;
            }
            if (o2.getSide() == DiffSide.LEFT) {
                return bigger;
            }
            return res;
        }

        /**
         * Сравнивает и возвращает порядок в списке типов объектов так как нужно
         * 
         * @param o1
         * @param o2
         * @return
         */
        private int compareTypes(TreeElement o1, TreeElement o2) {
            if (o1.getType().ordinal() > o2.getType().ordinal()) {
                return less;
            } else if (o1.getType().ordinal() < o2.getType().ordinal()) {
                return bigger;
            } else {
                return equal;
            }
        }
    }
}
