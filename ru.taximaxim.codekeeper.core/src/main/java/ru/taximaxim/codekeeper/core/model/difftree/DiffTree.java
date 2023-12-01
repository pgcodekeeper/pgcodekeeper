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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class DiffTree {

    public static TreeElement create(PgDatabase left, PgDatabase right) throws InterruptedException {
        return create(left, right, null);
    }

    public static TreeElement create(PgDatabase left, PgDatabase right, SubMonitor sMonitor) throws InterruptedException {
        return new DiffTree(sMonitor).createTree(left, right);
    }

    @Deprecated
    public static void addColumns(List<AbstractColumn> left, List<AbstractColumn> right,
            TreeElement parent, List<TreeElement> list) {
        for (AbstractColumn sLeft : left) {
            AbstractColumn foundRight = right.stream().filter(
                    sRight -> sLeft.getName().equals(sRight.getName()))
                    .findAny().orElse(null);

            if (!sLeft.equals(foundRight)) {
                TreeElement col = new TreeElement(sLeft, foundRight != null ? DiffSide.BOTH : DiffSide.LEFT);
                col.setParent(parent);
                list.add(col);
            }
        }

        for (AbstractColumn sRight : right) {
            if (left.stream().noneMatch(sLeft -> sRight.getName().equals(sLeft.getName()))) {
                TreeElement col = new TreeElement(sRight, DiffSide.RIGHT);
                col.setParent(parent);
                list.add(col);
            }
        }
    }

    public static Set<TreeElement> getTablesWithChangedColumns(
            PgDatabase oldDbFull, PgDatabase newDbFull, List<TreeElement> selected) {

        Set<TreeElement> tables = new HashSet<>();
        for (TreeElement el : selected) {
            if (el.getType() == DbObjType.TABLE) {
                List<TreeElement> columns = new ArrayList<>();
                DiffSide side = el.getSide();

                List<AbstractColumn> oldColumns;

                if (side == DiffSide.LEFT || side == DiffSide.BOTH) {
                    AbstractTable oldTbl = (AbstractTable) el.getPgStatement(oldDbFull);
                    oldColumns = oldTbl.getColumns();
                } else {
                    oldColumns = Collections.emptyList();
                }

                List<AbstractColumn> newColumns;
                if (side == DiffSide.RIGHT || side == DiffSide.BOTH) {
                    AbstractTable newTbl = (AbstractTable) el.getPgStatement(newDbFull);
                    newColumns = newTbl.getColumns();
                } else {
                    newColumns = Collections.emptyList();
                }

                addColumns(oldColumns, newColumns, el, columns);

                if (!columns.isEmpty()) {
                    tables.add(el);
                }
            }
        }

        return tables;
    }

    private final IProgressMonitor monitor;

    private DiffTree(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    public TreeElement createTree(PgDatabase left, PgDatabase right) throws InterruptedException {
        PgDiffUtils.checkCancelled(monitor);
        TreeElement db = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        addChildren(left, right, db);

        return db;
    }

    private void addChildren(PgStatement left, PgStatement right, TreeElement parent) throws InterruptedException {
        for (CompareResult res : compareStatements(left, right)) {
            PgDiffUtils.checkCancelled(monitor);
            TreeElement child = new TreeElement(res.getStatement(), res.getSide());
            parent.addChild(child);

            if (res.hasChildren()) {
                addChildren(res.getLeft(), res.getRight(), child);
            }
        }
    }

    /**
     * Compare lists and put elements onto appropriate sides.
     */
    private List<CompareResult> compareStatements(PgStatement left, PgStatement right) {
        List<CompareResult> rv = new ArrayList<>();

        // add LEFT and BOTH here
        // and RIGHT in a separate pass
        if (left != null) {
            left.getChildren().forEach(sLeft -> {
                PgStatement foundRight = null;
                if (right != null) {
                    foundRight = right.getChildren().filter(
                            sRight -> sLeft.getName().equals(sRight.getName())
                            && sLeft.getStatementType() == sRight.getStatementType())
                            .findAny().orElse(null);
                }

                if (foundRight == null) {
                    rv.add(new CompareResult(sLeft, null));
                } else if(!sLeft.equals(foundRight)) {
                    rv.add(new CompareResult(sLeft, foundRight));
                }
            });
        }

        if (right != null) {
            right.getChildren().forEach(sRight -> {
                if (left == null || left.getChildren().noneMatch(
                        sLeft -> sRight.getName().equals(sLeft.getName())
                        && sLeft.getStatementType() == sRight.getStatementType())) {
                    rv.add(new CompareResult(null, sRight));
                }
            });
        }

        return rv;
    }
}

class CompareResult {

    private final PgStatement left;
    private final PgStatement right;

    public PgStatement getLeft() {
        return left;
    }

    public PgStatement getRight() {
        return right;
    }

    public CompareResult(PgStatement left, PgStatement right) {
        this.left = left;
        this.right = right;
    }

    public DiffSide getSide() {
        if (left != null && right != null) {
            return DiffSide.BOTH;
        }
        if (left != null) {
            return DiffSide.LEFT;
        }
        if (right != null) {
            return DiffSide.RIGHT;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }

    public PgStatement getStatement() {
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }

    public boolean hasChildren() {
        if (left != null && left.hasChildren()) {
            return true;
        }

        return right != null && right.hasChildren();
    }
}
