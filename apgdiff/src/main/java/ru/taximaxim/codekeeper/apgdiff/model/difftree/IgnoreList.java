package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject.AddStatus;

public class IgnoreList {

    private final Map<String, IgnoredObject> literalRules = new LinkedHashMap<>();
    private final List<IgnoredObject> regexRules = new ArrayList<>();

    // black list (show all, hide some) by default
    private boolean isShow = true;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
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
            if (rule.isRegular()) {
                regexRules.add(rule);
            } else {
                literalRules.put(rule.getName(), rule);
            }
        }
    }

    private IgnoredObject findSameMatchingRule(IgnoredObject rule) {
        if (rule.isRegular()) {
            for (IgnoredObject regex : regexRules) {
                if (regex.getName().equals(rule.getName())) {
                    return regex;
                }
            }
            return null;
        } else {
            return literalRules.get(rule.getName());
        }
    }

    public void addAll(Collection<IgnoredObject> collection) {
        for (IgnoredObject rule : collection) {
            add(rule);
        }
    }

    public AddStatus getNameStatus(String name, boolean inAddSubtree) {
        AddStatus status = null;
        IgnoredObject rule = literalRules.get(name);
        if (rule != null) {
            status = rule.getAddStatus();
        }
        for (IgnoredObject regexRule : regexRules) {
            if (regexRule.match(name)) {
                AddStatus newStatus = regexRule.getAddStatus();
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
        for (IgnoredObject rule : literalRules.values()) {
            rule.appendRuleCode(sb).append('\n');
        }
        for (IgnoredObject rule : regexRules) {
            rule.appendRuleCode(sb).append('\n');
        }
        return sb.toString();
    }

    public LinkedList<IgnoredObject> copyToList() {
        LinkedList<IgnoredObject> list = new LinkedList<>();
        list.addAll(literalRules.values());
        list.addAll(regexRules);
        return list;
    }

    public void addAllFromPath(Path listFile) throws IOException {
        new IgnoreParser(this).parse(Files.newInputStream(listFile), listFile.toString());
    }
}
