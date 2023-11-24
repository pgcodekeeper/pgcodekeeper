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
package ru.taximaxim.codekeeper.ui.differ;

import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.compare.structuremergeviewer.DiffNode;
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
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.comparetools.CompareItem;
import ru.taximaxim.codekeeper.ui.comparetools.SqlMergeViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DiffPaneViewer extends Composite {

    private final TextMergeViewer diffPane;
    private DbSource dbProject;
    private DbSource dbRemote;
    private Collection<TreeElement> availableElements;

    public void setDbSources(DbSource dbProject, DbSource dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }

    public DiffPaneViewer(Composite parent, int style) {
        super(parent, style);

        setLayoutData(new GridData(GridData.FILL_BOTH));
        GridLayout filterLayout = new GridLayout();
        filterLayout.marginWidth = filterLayout.marginHeight = 0;
        setLayout(filterLayout);

        CompareConfiguration conf = new CompareConfiguration() {

            @Override
            public boolean isMirrored() {
                return false;
            }
        };

        conf.setLeftLabel(Messages.database);
        conf.setRightLabel(Messages.DiffPaneViewer_project);

        diffPane = new SqlMergeViewer(this, SWT.BORDER, conf);
        diffPane.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    public void setInput(TreeElement el, Collection<TreeElement> availableElements) {
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
        if (elSql == null || availableElements == null || !el.hasChildren() || !DiffTableViewer.isContainer(el)
                || Activator.getDefault().getPreferenceStore().getBoolean(PG_EDIT_PREF.SHOW_FULL_CODE)) {
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

        String result = isFormatted ? st.getFullFormattedSQL() : st.getFullSQL();
        if (!DiffTableViewer.isContainer(el)
                || !Activator.getDefault().getPreferenceStore().getBoolean(PG_EDIT_PREF.SHOW_FULL_CODE)) {
            return result;
        }

        StringBuilder sb = new StringBuilder(result);
        st.getChildren().forEach(c -> sb.append(UIConsts._NL).append(UIConsts._NL)
                .append(isFormatted ? c.getFullFormattedSQL() : c.getFullSQL()));
        return sb.toString();
    }
}
