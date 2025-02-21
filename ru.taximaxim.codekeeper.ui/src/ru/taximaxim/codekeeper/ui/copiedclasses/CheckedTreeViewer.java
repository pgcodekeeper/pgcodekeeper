/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.copiedclasses;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;


/**
 * Modified copy of org.eclipse.ui.dialogs.ContainerCheckedTreeViewer.
 * <br>
 * CheckboxTreeViewer with special behaviour of the checked / gray state on
 * container (non-leaf) nodes:
 * The grayed state is used to visualize the checked state of its children.
 * Containers are checked and non-gray if all contained leafs are checked. The
 * container is grayed if some but not all leafs are checked.
 * @since 3.1
 */
public class CheckedTreeViewer extends CheckboxTreeViewer {

    /**
     * Constructor for CheckedTreeViewer.
     * @see CheckboxTreeViewer#CheckboxTreeViewer(Composite)
     */
    public CheckedTreeViewer(Composite parent) {
        super(parent);
        initViewer();
    }

    /**
     * Constructor for CheckedTreeViewer.
     * @see CheckboxTreeViewer#CheckboxTreeViewer(Composite,int)
     */
    public CheckedTreeViewer(Composite parent, int style) {
        super(parent, style);
        initViewer();
    }

    /**
     * Constructor for CheckedTreeViewer.
     * @see CheckboxTreeViewer#CheckboxTreeViewer(Tree)
     */
    public CheckedTreeViewer(Tree tree) {
        super(tree);
        initViewer();
    }

    private void initViewer() {
        setUseHashlookup(true);
        addCheckStateListener(event -> doCheckStateChanged(event.getElement()));
        addTreeListener(new ITreeViewerListener() {
            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                // no imp
            }

            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                Widget item = findItem(event.getElement());
                if (item instanceof TreeItem treeItem) {
                    initializeItem(treeItem);
                }
            }
        });
    }

    /**
     * Update element after a checkstate change.
     * @param element
     */
    protected void doCheckStateChanged(Object element) {
        Widget item = findItem(element);
        if (item instanceof TreeItem treeItem) {
            treeItem.setGrayed(false);
            updateChildrenItems(treeItem);
            updateParentItems(treeItem.getParentItem());
        }
    }

    /**
     * The item has expanded. Updates the checked state of its children.
     */
    private void initializeItem(TreeItem item) {
        if (item.getChecked() && !item.getGrayed()) {
            updateChildrenItems(item);
        }
    }

    /**
     * Updates the check state of all created children
     */
    private void updateChildrenItems(TreeItem parent) {
        boolean state = parent.getChecked();

        // do not implicitly check children, only uncheck
        if(state) {
            return;
        }

        Item[] children = getChildren(parent);

        for (Item element : children) {
            TreeItem curr = (TreeItem) element;
            if (curr.getData() != null
                    && ((curr.getChecked() != state) || curr.getGrayed())) {
                curr.setChecked(state);
                curr.setGrayed(false);
                updateChildrenItems(curr);
            }
        }
    }

    /**
     * Updates the check / gray state of all parent items
     */
    private void updateParentItems(TreeItem item) {
        if (item != null) {
            Item[] children = getChildren(item);
            boolean containsChecked = false;
            boolean containsUnchecked = false;
            for (Item element : children) {
                TreeItem curr = (TreeItem) element;
                containsChecked |= curr.getChecked();
                containsUnchecked |= (!curr.getChecked() || curr.getGrayed());
            }
            item.setChecked(containsChecked);
            item.setGrayed(containsChecked && containsUnchecked);
            updateParentItems(item.getParentItem());
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ICheckable#setChecked(java.lang.Object, boolean)
     */
    @Override
    public boolean setChecked(Object element, boolean state) {
        if (super.setChecked(element, state)) {
            doCheckStateChanged(element);
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.CheckboxTreeViewer#setCheckedElements(java.lang.Object[])
     */
    @Override
    public void setCheckedElements(Object[] elements) {
        super.setCheckedElements(elements);
        for (Object element : elements) {
            doCheckStateChanged(element);
        }
    }


    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.AbstractTreeViewer#setExpanded(org.eclipse.swt.widgets.Item, boolean)
     */
    @Override
    protected void setExpanded(Item item, boolean expand) {
        super.setExpanded(item, expand);
        if (expand && item instanceof TreeItem treeItem) {
            initializeItem(treeItem);
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.CheckboxTreeViewer#getCheckedElements()
     */
    @Override
    public Object[] getCheckedElements() {
        Object[] checked = super.getCheckedElements();
        // add all items that are children of a checked node but not created yet
        ArrayList<Object> result = new ArrayList<>();
        for (Object curr : checked) {
            result.add(curr);
            Widget item = findItem(curr);
            if (item != null) {
                Item[] children = getChildren(item);
                // check if contains the dummy node
                if (children.length == 1 && children[0].getData() == null) {
                    // not yet created
                    collectChildren(curr, result);
                }
            }
        }
        return result.toArray();
    }

    /**
     * Recursively add the filtered children of element to the result.
     * @param element
     * @param result
     */
    private void collectChildren(Object element, List<Object> result) {
        Object[] filteredChildren = getFilteredChildren(element);
        for (Object curr : filteredChildren) {
            result.add(curr);
            collectChildren(curr, result);
        }
    }

    @Override
    public boolean setSubtreeChecked(Object element, boolean state) {
        boolean rv = super.setSubtreeChecked(element, state);
        doCheckStateChanged(element);
        return rv;
    }
}
