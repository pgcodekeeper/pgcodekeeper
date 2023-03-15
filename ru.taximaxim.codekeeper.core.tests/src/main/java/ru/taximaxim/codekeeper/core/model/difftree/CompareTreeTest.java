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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;

class CompareTreeTest {

    private static final int N = 1000;

    @Test
    void test() {
        List<TreeElement> list = new ArrayList<>(N * DiffSide.values().length * DbObjType.values().length);
        for (DiffSide side : DiffSide.values()) {
            for (DbObjType type : DbObjType.values()) {
                for (int i = 0; i < N; ++i) {
                    list.add(new TreeElement("testel_" + i, type, side));
                }
            }
        }

        Collections.shuffle(list);

        DiffSide prevSide = DiffSide.LEFT;
        DbObjType prevType = DbObjType.values()[DbObjType.values().length - 1];

        Collections.sort(list, new CompareTree());
        for (TreeElement el : list) {
            if (el.getSide() == DiffSide.LEFT
                    && prevSide != DiffSide.LEFT) {
                Assertions.fail("Side left is after another type");
            }

            int res = el.getType().ordinal() - prevType.ordinal();

            if (el.getSide() == DiffSide.RIGHT
                    && prevSide == DiffSide.BOTH
                    && res <= 0) {
                Assertions.fail("Side wrong");
            }
            if (el.getSide() == DiffSide.LEFT) {
                res = -res;
            }
            if (res < 0) {
                Assertions.fail("Element type is less than expected");
            }
            prevSide = el.getSide();
            prevType = el.getType();
        }
    }
}
