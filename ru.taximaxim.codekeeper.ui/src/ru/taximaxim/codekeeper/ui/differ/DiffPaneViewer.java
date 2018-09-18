package ru.taximaxim.codekeeper.ui.differ;

import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.UIConsts;
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
        // add initial input in order to avoid problems when disposing the viewer later
        resetInput();
    }

    public void setInput(TreeElement el, Collection<TreeElement> availableElements) {
        this.availableElements = availableElements;
        if (el != null) {
            diffPane.setInput(new DiffNode(new CompareItem(Messages.database, getSql(el, false)),
                    new CompareItem(Messages.DiffPaneViewer_project, getSql(el, true))));
        } else {
            resetInput();
        }
    }


    private void resetInput() {
        diffPane.setInput(new DiffNode(new CompareItem(Messages.database, ""), //$NON-NLS-1$
                new CompareItem(Messages.DiffPaneViewer_project, ""))); //$NON-NLS-1$
    }

    private String getSql(TreeElement el, boolean project) {
        String elSql = getElementSql(el, project);
        if (elSql != null && availableElements != null && el.hasChildren()
                && DiffTableViewer.isContainer(el)) {
            StringBuilder sb = new StringBuilder(elSql);
            for (TreeElement child : el.getChildren()) {
                if (availableElements.contains(child)) {
                    String childSql = getElementSql(child, project);
                    if (childSql != null) {
                        sb.append(UIConsts._NL).append(UIConsts._NL).append(childSql);
                    }
                }
            }
            return sb.toString();
        } else {
            return elSql;
        }
    }

    private String getElementSql(TreeElement el, boolean project) {
        if (el.getSide() == DiffSide.LEFT == project || el.getSide() == DiffSide.BOTH) {
            DbSource db = project ? dbProject : dbRemote;
            PgStatement st = el.getPgStatement(db.getDbObject());
            if (st.getStatementType() == DbObjType.ASSEMBLY) {
                return ((MsAssembly)st).getPreview();
            }
            return st.getFullSQL();
        } else {
            return null;
        }
    }
}
