package ru.taximaxim.codekeeper.ui.differ;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.copiedclasses.CheckedTreeViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DiffTreeViewer extends Composite {

    private TreeElement tree;
    private final CheckedTreeViewer viewer;

    private final Button btnDebugView;

    public DiffTreeViewer(Composite parent, int style) {
        super(parent, style);

        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);

        viewer = new CheckedTreeViewer(this);
        viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

        viewer.setContentProvider(new DiffTreeContentProvider());
        viewer.setLabelProvider(new StyledCellLabelProvider() {

            @Override
            public void update(ViewerCell cell) {
                provideTreeCellLabelDecorations(cell);
                super.update(cell);
            }
        });
        viewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                TreePath path = ((TreeSelection) event.getSelection()).getPaths()[0];
                viewer.setExpandedState(path, !viewer.getExpandedState(path));
                viewer.refresh();
            }
        });

        MenuManager menuMgr = new MenuManager();
        menuMgr.add(new Action(Messages.diffTreeViewer_select_subtree) {
            @Override
            public void run() {
                TreeElement el = (TreeElement) ((TreeSelection) viewer.getSelection())
                        .getFirstElement();
                viewer.setSubtreeChecked(el, true);
            }
        });
        menuMgr.add(new Action(Messages.diffTreeViewer_deselect_subtree) {
            @Override
            public void run() {
                TreeElement el = (TreeElement) ((TreeSelection) viewer.getSelection())
                        .getFirstElement();
                viewer.setSubtreeChecked(el, false);
            }
        });
        menuMgr.add(new Separator());
        menuMgr.add(new Action(Messages.diffTreeViewer_expand_subtree) {
            @Override
            public void run() {
                TreePath path = ((TreeSelection) viewer.getSelection()).getPaths()[0];
                viewer.expandToLevel(path, TreeViewer.ALL_LEVELS);
            }
        });
        menuMgr.add(new Action(Messages.diffTreeViewer_collapse_subtree) {
            @Override
            public void run() {
                TreePath path = ((TreeSelection) viewer.getSelection()).getPaths()[0];
                viewer.collapseToLevel(path, TreeViewer.ALL_LEVELS);
            }
        });
        menuMgr.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(IMenuManager manager) {
                boolean enable = !viewer.getSelection().isEmpty();
                for(IContributionItem item : manager.getItems()) {
                    if(item instanceof ActionContributionItem) {
                        ((ActionContributionItem) item).getAction().setEnabled(enable);
                    }
                }
            }
        });

        viewer.getControl().setMenu(menuMgr.createContextMenu(viewer.getControl()));

        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(5, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);

        Button btnSelectAll = new Button(contButtons, SWT.PUSH);
        btnSelectAll.setText(Messages.select_all);
        btnSelectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeElement root = (TreeElement) viewer.getInput();
                if(root != null) {
                    for(TreeElement sub : root.getChildren()) {
                        viewer.setSubtreeChecked(sub, true);
                    }
                }
            }
        });

        Button btnSelectNone = new Button(contButtons, SWT.PUSH);
        btnSelectNone.setText(Messages.select_none);
        btnSelectNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeElement root = (TreeElement) viewer.getInput();
                if(root != null) {
                    for(TreeElement sub : root.getChildren()) {
                        viewer.setSubtreeChecked(sub, false);
                    }
                }
            }
        });

        Button btnExpandAll = new Button(contButtons, SWT.PUSH);
        btnExpandAll.setText(Messages.diffTreeViewer_expand_all);
        btnExpandAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.expandAll();
            }
        });

        Button btnCollapseAll = new Button(contButtons, SWT.PUSH);
        btnCollapseAll.setText(Messages.diffTreeViewer_collapse_all);
        btnCollapseAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.collapseAll();
            }
        });

        btnDebugView = new Button(contButtons, SWT.CHECK);
        btnDebugView.setText(Messages.diffTreeViewer_debug_view);
        btnDebugView.setLayoutData(new GridData(
                GridData.HORIZONTAL_ALIGN_END | GridData.FILL_HORIZONTAL));
        btnDebugView.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.refresh();
            }
        });
    }

    private void provideTreeCellLabelDecorations(ViewerCell cell) {
        TreeElement el = (TreeElement) cell.getElement();
        List<StyleRange> styles = new ArrayList<>();

        Image icon = Activator.getDbObjImage(el.getType());
        String name = el.getName();

        if(btnDebugView.getSelection()) {
            cell.setText(String.format("%s:%s:%s", //$NON-NLS-1$
                    el.getType(), name, el.getSide()));
        } else {
            StringBuilder label = new StringBuilder(name);

            if(el.getType() == DbObjType.DATABASE
                    || el.getType() == DbObjType.SCHEMA
                    || el.getType() == DbObjType.TABLE) {
                label.append(" (") //$NON-NLS-1$
                .append(el.countChildren())
                .append(") [") //$NON-NLS-1$
                .append(el.countDescendants())
                .append(']');

                TextStyle styleGray = new TextStyle();
                styleGray.foreground = getDisplay().getSystemColor(
                        SWT.COLOR_GRAY);

                StyleRange styleCount = new StyleRange(styleGray);
                styleCount.start = name.length();
                styleCount.length = label.length() - name.length();

                styles.add(styleCount);
            }

            cell.setText(label.toString());
        }

        cell.setStyleRanges(styles.toArray(new StyleRange[styles.size()]));
        cell.setImage(icon);
    }

    public void setTreeInput(TreeElement tree) {
        this.tree = tree;
        viewer.setInput(tree);
    }

    public TreeElement getTreeInput() {
        return tree;
    }
}

class DiffTreeContentProvider implements ITreeContentProvider {

    @Override
    public boolean hasChildren(Object element) {
        return ((TreeElement) element).hasChildren();
    }

    @Override
    public Object getParent(Object element) {
        return ((TreeElement) element).getParent();
    }

    @Override
    public Object[] getElements(Object inputElement) {
        return ((TreeElement) inputElement).getChildren().toArray();
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        return getElements(parentElement);
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }
}