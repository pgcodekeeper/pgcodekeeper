package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject.AddStatus;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class TreeFlattener {

    private boolean onlySelected;
    private boolean onlyEdits;
    private PgDatabase dbSource, dbTarget;
    private IgnoreList ignoreList;

    private final List<TreeElement> result = new ArrayList<>();
    private final Deque<TreeElement> addSubtreeRoots = new ArrayDeque<>();

    /**
     * Sets {@link #onlySelected} setting true.
     */
    public TreeFlattener onlySelected() {
        onlySelected = true;
        return this;
    }

    public TreeFlattener onlySelected(boolean onlySelected) {
        this.onlySelected = onlySelected;
        return this;
    }

    public TreeFlattener onlyEdits(PgDatabase dbSource, PgDatabase dbTarget) {
        onlyEdits = dbSource != null && dbTarget != null;
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        return this;
    }

    public TreeFlattener useIgnoreList(IgnoreList ignoreList) {
        this.ignoreList = ignoreList;
        return this;
    }

    public List<TreeElement> flatten(TreeElement root) {
        result.clear();
        addSubtreeRoots.clear();
        recurse(root);
        return result;
    }

    private void recurse(TreeElement el) {
        AddStatus status = ignoreList == null ? AddStatus.ADD
                : ignoreList.getNameStatus(el.getName(), !addSubtreeRoots.isEmpty());
        if (status == AddStatus.SKIP_SUBTREE) {
            return;
        }

        if (status == AddStatus.ADD_SUBTREE) {
            addSubtreeRoots.push(el);
        }
        for (TreeElement sub : el.getChildren()) {
            recurse(sub);
        }
        if (status == AddStatus.ADD_SUBTREE) {
            addSubtreeRoots.pop();
        }

        if ((status == AddStatus.ADD || status == AddStatus.ADD_SUBTREE) &&
                (!onlySelected || el.isSelected()) &&
                (!onlyEdits || el.getSide() != DiffSide.BOTH ||
                !el.getPgStatement(dbSource).compare(el.getPgStatement(dbTarget)))) {
            result.add(el);
        }
    }
}
