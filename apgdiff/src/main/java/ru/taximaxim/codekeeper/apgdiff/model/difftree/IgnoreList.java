package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject.AddStatus;

public class IgnoreList {

    private final List<IgnoredObject> rules = new ArrayList<>();

    // black list (show all, hide some) by default
    private boolean isShow = true;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public List<IgnoredObject> getList() {
        return Collections.unmodifiableList(rules);
    }

    public void clearList() {
        rules.clear();
    }

    public void add(IgnoredObject rule) {
        IgnoredObject existing = findSameMatchingRule(rule);
        if (existing != null) {
            if (existing.isIgnoreContent() != rule.isIgnoreContent()) {
                if (!existing.isIgnoreContent()) {
                    // existing rule is narrow (nocontent), use new wider rule
                    existing.setIgnoreContent(true);
                    existing.setShow(rule.isShow());
                }
            } else {
                // from same-width alternatives choose a hiding one
                existing.setShow(existing.isShow() && rule.isShow());
            }
        } else {
            // add new
            rules.add(rule);
        }
    }

    private IgnoredObject findSameMatchingRule(IgnoredObject rule) {
        for (IgnoredObject match : rules) {
            if (match.hasSameMatchingCondition(rule)) {
                return match;
            }
        }
        return null;
    }

    public void addAll(Collection<IgnoredObject> collection) {
        for (IgnoredObject rule : collection) {
            add(rule);
        }
    }

    public AddStatus getNameStatus(String name, DbObjType type, boolean inAddSubtree) {
        return getNameStatus(name, type, inAddSubtree, (String[]) null);
    }

    public AddStatus getNameStatus(String name, DbObjType type, boolean inAddSubtree, String... dbNames) {
        AddStatus status = null;
        for (IgnoredObject rule : rules) {
            if (rule.match(name, type, dbNames)) {
                AddStatus newStatus = rule.getAddStatus();
                if (status == null) {
                    status = newStatus;
                } else if ((status == AddStatus.ADD || status == AddStatus.SKIP) &&
                        (newStatus == AddStatus.ADD_SUBTREE || newStatus == AddStatus.SKIP_SUBTREE)){
                    // use wider rule
                    status = newStatus;
                } else if (status == AddStatus.ADD && newStatus == AddStatus.SKIP ||
                        status == AddStatus.ADD_SUBTREE && newStatus == AddStatus.SKIP_SUBTREE) {
                    // use hiding rule
                    status = newStatus;
                }
            }
        }
        return status != null ? status : (inAddSubtree || isShow ? AddStatus.ADD : AddStatus.SKIP);
    }

    public String getListCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(isShow ? "SHOW ALL\n" : "HIDE ALL\n");
        for (IgnoredObject rule : rules) {
            rule.appendRuleCode(sb).append('\n');
        }
        return sb.toString();
    }
}
