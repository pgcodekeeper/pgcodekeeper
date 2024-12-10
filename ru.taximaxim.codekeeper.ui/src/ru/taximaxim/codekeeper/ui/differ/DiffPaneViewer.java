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
package ru.taximaxim.codekeeper.ui.differ;

import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ms.MsAssembly;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.comparetools.CompareItem;
import ru.taximaxim.codekeeper.ui.comparetools.SqlMergeViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefChangeAction;

public final class DiffPaneViewer extends Composite {

    // see ComparePreferencePage.SWAPPED
    private static final String PREF_SWAP = "org.eclipse.compare.Swapped";

    private final TextMergeViewer diffPane;
    private DbSource dbProject;
    private DbSource dbRemote;

    private TreeElement currentEl;
    private Collection<TreeElement> availableElements;

    private final IPreferenceStore store = Activator.getDefault().getPreferenceStore();

    private final PrefChangeAction swapAction;
    private final PrefChangeAction showFullCodeAction;

    public void setDbSources(DbSource dbProject, DbSource dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }

    public DiffPaneViewer(Composite parent) {
        super(parent, SWT.BORDER);

        setLayoutData(new GridData(GridData.FILL_BOTH));
        GridLayout filterLayout = new GridLayout();
        filterLayout.marginWidth = filterLayout.marginHeight = 0;
        setLayout(filterLayout);

        CompareConfiguration conf = new CompareConfiguration();
        conf.setLeftLabel(Messages.database);
        conf.setRightLabel(Messages.DiffPaneViewer_project);

        Composite container = new Composite(this, SWT.NONE);
        var gl = new GridLayout();
        gl.marginWidth = gl.marginHeight = 0;
        gl.marginBottom = -3;
        container.setLayout(gl);
        container.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));

        swapAction = new PrefChangeAction(Messages.DiffPaneViewer_btn_switch,
                PREF_SWAP, conf.getPreferenceStore(), container, ProjectIcon.SWITCH);

        showFullCodeAction = new PrefChangeAction(Messages.GeneralPrefPage_show_full_code,
                PG_EDIT_PREF.SHOW_FULL_CODE, store, container, ProjectIcon.SHOW_CHILDREN) {

            @Override
            public void refresh() {
                if (currentEl != null && currentEl.isContainer()) {
                    setInput(currentEl, availableElements);
                }
            }
        };

        var toolBar = new ToolBarManager();
        toolBar.add(swapAction);
        toolBar.add(showFullCodeAction);
        toolBar.createControl(container);

        diffPane = new SqlMergeViewer(this, SWT.NONE, conf);
        diffPane.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        diffPane.refresh(); // load labels
    }

    @Override
    public void dispose() {
        swapAction.dispose();
        showFullCodeAction.dispose();
        super.dispose();
    }

    public void setInput(TreeElement el, Collection<TreeElement> availableElements) {
        this.currentEl = el;
        this.availableElements = availableElements;
        if (el != null) {
            String contentsLeft = getSql(el, false, true);
            String contentsRight = getSql(el, true, true);
            if (contentsLeft != null && contentsRight != null
                    && contentsLeft.equals(contentsRight)) {
                contentsLeft = getSql(el, false, false);
                contentsRight = getSql(el, true, false);
            }
            diffPane.setInput(new DiffNode(new CompareItem(Messages.database, contentsLeft),
                    new CompareItem(Messages.DiffPaneViewer_project, contentsRight)));
        } else {
            diffPane.setInput(null);
        }
    }

    private String getSql(TreeElement el, boolean project, boolean format) {
        String elSql = getElementSql(el, project, format);
        if (elSql == null || availableElements == null || !el.hasChildren() || !el.isContainer()
                || store.getBoolean(PG_EDIT_PREF.SHOW_FULL_CODE)) {
            return elSql;
        }

        StringBuilder sb = new StringBuilder(elSql);
        for (TreeElement child : el.getChildren()) {
            if (availableElements.contains(child)) {
                String childSql = getElementSql(child, project, format);
                if (childSql != null) {
                    sb.append(UIConsts._NL).append(UIConsts._NL).append(childSql);
                }
            }
        }

        return sb.toString();
    }

    private String getElementSql(TreeElement el, boolean project, boolean isFormatted) {
        if ((el.getSide() == DiffSide.LEFT) != project && el.getSide() != DiffSide.BOTH) {
            return null;
        }

        DbSource db = project ? dbProject : dbRemote;
        PgStatement st = el.getPgStatement(db.getDbObject());
        if (st.getStatementType() == DbObjType.ASSEMBLY) {
            return ((MsAssembly) st).getPreview();
        }

        String sql = st.getSQL(isFormatted);
        if (!el.isContainer() || !store.getBoolean(PG_EDIT_PREF.SHOW_FULL_CODE)) {
            return sql;
        }

        StringBuilder sb = new StringBuilder(sql);
        st.getChildren().forEach(c -> sb.append(UIConsts._NL).append(UIConsts._NL).append(c.getSQL(isFormatted)));
        return sb.toString();
    }
}
