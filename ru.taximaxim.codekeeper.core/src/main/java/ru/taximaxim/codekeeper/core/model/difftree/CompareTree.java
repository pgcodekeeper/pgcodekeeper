/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import static ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide.BOTH;
import static ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide.LEFT;
import static ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide.RIGHT;

import java.util.Comparator;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;

public class CompareTree implements Comparator<TreeElement> {

    private static final int LESS = -1;
    private static final int MORE = 1;

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
        }

        if (s1 == LEFT) {
            return LESS;
        }
        if (s2 == LEFT) {
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

        throw new IllegalStateException("Missing compare case");
    }

    /**
     * Сравнивает и возвращает порядок в списке типов объектов так как нужно
     */
    private int compareTypes(TreeElement o1, TreeElement o2) {
        return o1.getType().ordinal() - o2.getType().ordinal();
    }
}
