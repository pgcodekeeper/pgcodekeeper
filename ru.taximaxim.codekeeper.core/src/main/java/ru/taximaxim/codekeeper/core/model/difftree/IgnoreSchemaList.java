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
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject.AddStatus;

public class IgnoreSchemaList implements IIgnoreList {

    private final List<IgnoredObject> rules = new ArrayList<>();

    // black list (show all, hide some) by default
    private boolean isShow = true;

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
        rules.add(rule);
    }

    public boolean getNameStatus(String schema) {
        for (IgnoredObject rule : rules) {
            if (rule.match(schema)) {
                AddStatus newStatus = rule.getAddStatus();
                switch (newStatus) {
                case ADD, ADD_SUBTREE:
                    return true;
                case SKIP, SKIP_SUBTREE:
                    return false;
                }
            }
        }
        return isShow;
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
