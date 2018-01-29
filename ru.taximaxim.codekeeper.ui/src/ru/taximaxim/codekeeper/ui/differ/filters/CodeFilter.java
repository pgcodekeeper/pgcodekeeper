package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;

/**
 * Contains information of code search
 *
 * @since 4.1.2.
 * @author galiev_mr
 *
 */
public class CodeFilter extends AbstractFilter {

    @Override
    public boolean find(TreeElement el, Set<TreeElement> elements,
            PgDatabase dbProject, PgDatabase dbRemote) {

        if (el.getSide() != DiffSide.RIGHT && checkSide(el, dbProject, elements)) {
            return true;
        }

        if (el.getSide() != DiffSide.LEFT) {
            return checkSide(el, dbRemote, elements);
        }

        return false;
    }

    private boolean checkSide(TreeElement el, PgDatabase db, Set<TreeElement> elements) {
        PgStatement statement = el.getPgStatement(db);
        if (statement != null) {
            if (checkCode(getCode(statement))) {
                return true;
            }

            if (DiffTableViewer.isSubElement(el)) {
                PgStatement parent = statement.getParent();
                if (parent != null) {
                    return checkCode(getCode(parent));
                }
            }

            if (DiffTableViewer.isContainer(el)) {
                return el.getChildren().stream().filter(elements::contains)
                        .map(e -> e.getPgStatement(db))
                        .anyMatch(s -> s != null && checkCode(getCode(s)));
            }
        }

        return false;
    }

    private String getCode(PgStatement statement) {
        return statement.getCreationSQL().toLowerCase();
    }
}
