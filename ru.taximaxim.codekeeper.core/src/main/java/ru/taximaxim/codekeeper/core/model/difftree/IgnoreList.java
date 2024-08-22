/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.model.difftree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject.AddStatus;

public class IgnoreList implements IIgnoreList {

    private final List<IgnoredObject> rules = new ArrayList<>();

    // black list (show all, hide some) by default
    private boolean isShow = true;

    @Override
    public boolean isShow() {
        return isShow;
    }

    @Override
    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    public List<IgnoredObject> getList() {
        return Collections.unmodifiableList(rules);
    }

    public void clearList() {
        rules.clear();
    }

    @Override
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

    public AddStatus getNameStatus(TreeElement el, boolean inAddSubtree, String... dbNames) {
        AddStatus status = null;
        for (IgnoredObject rule : rules) {
            if (rule.match(el, dbNames)) {
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

        if (status != null) {
            return status;
        }

        return inAddSubtree || isShow ? AddStatus.ADD : AddStatus.SKIP;
    }

    public String getListCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(isShow ? "SHOW ALL\n" : "HIDE ALL\n");
        for (IgnoredObject rule : rules) {
            rule.appendRuleCode(sb, true).append('\n');
        }
        return sb.toString();
    }
}
