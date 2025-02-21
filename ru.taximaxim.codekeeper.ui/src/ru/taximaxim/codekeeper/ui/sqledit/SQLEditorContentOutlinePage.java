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
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.stream.Stream;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class SQLEditorContentOutlinePage extends ContentOutlinePage {

    private final SQLEditor sqlEditor;
    private boolean filterDangerous;
    private boolean sortStatements;

    private Composite fParent;
    private StackLayout fStackLayout;
    private Composite fOutlinePage;
    private Control fStatusPage;

    public SQLEditorContentOutlinePage(SQLEditor sqlEditor) {
        this.sqlEditor = sqlEditor;
    }

    public void externalRefresh() {
        updateVisiblePage();
        getControl().redraw();
        Viewer v = getTreeViewer();
        if (v != null) {
            v.refresh();
        }
    }

    @Override
    public void createControl(Composite parent) {
        fParent = new Composite(parent, SWT.NONE);
        fStackLayout = new StackLayout();
        fParent.setLayout(fStackLayout);
        fOutlinePage = new Composite(fParent, SWT.NONE);
        fOutlinePage.setLayout(new FillLayout());
        super.createControl(fOutlinePage);
        getTreeViewer().setContentProvider(new OutlineContentProvider());
        getTreeViewer().setLabelProvider(new LabelProvider() {

            @Override
            public Image getImage(Object element) {
                if (element instanceof Segments seg) {
                    DbObjType type = seg.getType();
                    return type != null ? Activator.getDbObjImage(type)
                            : Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE);
                }
                return super.getImage(element);
            }
        });
        getTreeViewer().addSelectionChangedListener(this);
        fStatusPage = createStatusPage(fParent);
        updateVisiblePage();

        // argument doesn't matter
        getTreeViewer().setInput(sqlEditor);
    }

    @Override
    public Control getControl() {
        return fParent;
    }

    private Control createStatusPage(Composite parent) {
        final Link link = new Link(parent, SWT.NONE);
        link.setText(Messages.SQLEditorContentOutlinePage_disabled_by_option);
        link.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(
                        link.getShell(), PREF_PAGE.SQL_EDITOR, null, null);

                if (dialog.open() == IDialogConstants.OK_ID) {
                    sqlEditor.refreshParser();
                }
            }
        });

        return link;
    }

    private void updateVisiblePage() {
        if (fStackLayout == null) {
            return;
        }
        if (sqlEditor.isLargeFile()) {
            if (fStackLayout.topControl != fStatusPage) {
                fStackLayout.topControl = fStatusPage;
                fParent.layout();
            }
        } else if (fStackLayout.topControl != fOutlinePage) {
            fStackLayout.topControl = fOutlinePage;
            fParent.layout();
        }
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        super.selectionChanged(event);

        ISelection selection = event.getSelection();
        if (selection.isEmpty()) {
            sqlEditor.resetHighlightRange();
        } else {
            Segments segment = (Segments) ((IStructuredSelection) selection)
                    .getFirstElement();
            int start = segment.getOffset();
            int length = segment.getLength();
            try {
                sqlEditor.setHighlightRange(start, length, true);
                sqlEditor.selectAndReveal(start, length);
            } catch (IllegalArgumentException x) {
                sqlEditor.resetHighlightRange();
            }
        }
    }

    @Override
    public void setActionBars(IActionBars actionBars) {
        super.setActionBars(actionBars);

        Action sortAction = new Action(Messages.SQLEditorContentOutlinePage_sort_alphabetically,
                IAction.AS_CHECK_BOX) {

            @Override
            public void run() {
                setState(!sortStatements);
            }

            private void setState(boolean state) {
                sortStatements = state;
                setChecked(state);
                getTreeViewer().refresh(false);
            }
        };

        sortAction.setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.SORT));

        Action hideAction = new Action(Messages.SQLEditorContentOutlinePage_hide_non_dangerous,
                IAction.AS_CHECK_BOX) {

            @Override
            public void run() {
                setState(!filterDangerous);
            }

            private void setState(boolean state) {
                filterDangerous = state;
                setChecked(state);
                getTreeViewer().refresh(false);
            }
        };

        hideAction.setImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.ALERT));

        actionBars.getToolBarManager().add(sortAction);
        actionBars.getToolBarManager().add(hideAction);
    }

    @Override
    public void dispose() {
        super.dispose();
        filterDangerous = false;
        sortStatements = false;
    }

    private class OutlineContentProvider implements ITreeContentProvider {

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // no impl
        }

        @Override
        public Object[] getElements(Object inputElement) {
            Stream<PgObjLocation> stream = sqlEditor.getParser().getObjsForEditor(
                    sqlEditor.getEditorInput()).stream()
                    .filter(e -> e.getAction() != null)
                    .filter(loc -> loc.getObjLength() >= 0); // broken context

            if (filterDangerous) {
                stream = stream.filter(PgObjLocation::isDanger);
            }
            if (sortStatements) {
                stream = stream.sorted((a,b) -> a.getObjName().compareTo(b.getObjName()));
            } else {
                stream = stream.sorted((a,b) -> Integer.compare(a.getOffset(), b.getOffset()));
            }

            return stream.map(Segments::new).toArray();
        }

        @Override
        public Object[] getChildren(Object parentElement) {
            return null;
        }

        @Override
        public Object getParent(Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(Object element) {
            return false;
        }
    }
}