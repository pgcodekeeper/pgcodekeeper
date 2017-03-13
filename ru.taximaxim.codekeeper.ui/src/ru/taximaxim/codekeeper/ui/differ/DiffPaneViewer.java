package ru.taximaxim.codekeeper.ui.differ;

import java.util.Collection;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;

public class DiffPaneViewer extends Composite {

    private final TextMergeViewer diffPane;
    private DbSource dbProject;
    private DbSource dbRemote;
    private final DiffSide projSide;
    private Collection<TreeElement> availableElements;

    public void setDbSources(DbSource dbProject, DbSource dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;
    }

    public DiffPaneViewer(Composite parent, int style, DiffSide projSide) {
        super(parent, style);
        this.projSide = projSide;

        CompareConfiguration conf = new CompareConfiguration();
        conf.setLeftEditable(false);
        conf.setRightEditable(false);

        setLayoutData(new GridData(GridData.FILL_BOTH));
        GridLayout filterLayout = new GridLayout();
        filterLayout.marginWidth = filterLayout.marginHeight = 0;
        setLayout(filterLayout);

        diffPane = new TextMergeViewer(this, SWT.BORDER, conf) {

            @Override
            protected void configureTextViewer(TextViewer textViewer) {
                // viewer configures itself
            }

            @Override
            protected SourceViewer createSourceViewer(Composite parent,
                    int textOrientation) {
                return new SqlSourceViewer(parent, textOrientation);
            }
        };
        diffPane.setContentProvider(new DiffPaneContentProvider());
        diffPane.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    public void setInput(TreeElement value, Collection<TreeElement> availableElements) {
        this.availableElements = availableElements;
        diffPane.setInput(value);
    }

    private class DiffPaneContentProvider implements IMergeViewerContentProvider {

        @Override
        public String getRightLabel(Object input) {
            return (projSide == DiffSide.LEFT ? Messages.to : Messages.diffPartDescr_from)
                    + Messages.DiffPaneViewer_project;
        }

        @Override
        public Object getRightContent(Object input) {
            return input != null ? new Document(getSql((TreeElement) input, true)) : null;
        }

        @Override
        public String getLeftLabel(Object input) {
            return (projSide == DiffSide.LEFT ? Messages.diffPartDescr_from : Messages.to)
                    + Messages.database;
        }

        @Override
        public Object getLeftContent(Object input) {
            return input != null ? new Document(getSql((TreeElement) input, false)) : null;
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
            if (el.getSide() == projSide == project || el.getSide() == DiffSide.BOTH) {
                DbSource db = project ? dbProject : dbRemote;
                return el.getPgStatement(db.getDbObject()).getFullSQL();
            } else {
                return null;
            }
        }

        @Override
        public boolean showAncestor(Object input) {
            return false;
        }

        @Override
        public void saveRightContent(Object input, byte[] bytes) {
            //no impl
        }

        @Override
        public void saveLeftContent(Object input, byte[] bytes) {
            //no impl
        }

        @Override
        public boolean isRightEditable(Object input) {
            return false;
        }

        @Override
        public boolean isLeftEditable(Object input) {
            return false;
        }

        @Override
        public Image getRightImage(Object input) {
            return null;
        }

        @Override
        public Image getLeftImage(Object input) {
            return null;
        }

        @Override
        public String getAncestorLabel(Object input) {
            return null;
        }

        @Override
        public Image getAncestorImage(Object input) {
            return null;
        }

        @Override
        public Object getAncestorContent(Object input) {
            return null;
        }
    }
}
