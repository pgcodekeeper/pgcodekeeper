package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class CompareTreeTest {

    private static final int N = 1000;
    
    private List<TreeElement> list;
    
    @Before
    public void beforeTest() {
        list = new ArrayList<>(N * DiffSide.values().length * DbObjType.values().length);
        for (DiffSide side : DiffSide.values()) {
            for (DbObjType type : DbObjType.values()) {
                for (int i = 0; i < N; ++i) {
                    list.add(new TreeElement("testel_" + i, type, side));
                }
            }
        }
        Collections.shuffle(list);
    }

    @Test
    public void Test() {
        DiffSide prevSide = DiffSide.LEFT;
        DbObjType prevType = DbObjType.values()[DbObjType.values().length - 1];
        
        Collections.sort(list, new CompareTree());
        for (TreeElement el : list) {
            if (el.getSide() == DiffSide.LEFT
                    && prevSide != DiffSide.LEFT) {
                Assert.fail("Side left is after another type");
            }
            
            int res = el.getType().ordinal() - prevType.ordinal();

            if (el.getSide() == DiffSide.RIGHT
                    && prevSide == DiffSide.BOTH
                    && res <= 0) {
                Assert.fail("Side wrong");
            }
            if (el.getSide() == DiffSide.LEFT) {
                res = -res;  
            }
            if (res < 0) {
                Assert.fail("Element type is less than expected");
            }
            prevSide = el.getSide();
            prevType = el.getType();
        }
    }
}
