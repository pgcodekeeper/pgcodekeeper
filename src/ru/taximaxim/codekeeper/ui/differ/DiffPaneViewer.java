package ru.taximaxim.codekeeper.ui.differ;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;

public class DiffPaneViewer extends Composite {

    private final TextMergeViewer diffPane;
    private DbSource dbSource;
    private DbSource dbTarget;
    private final boolean reverseSide;

    public void setDbSource(DbSource dbSource) {
        this.dbSource = dbSource;
    }

    public void setDbTarget(DbSource dbTarget) {
        this.dbTarget = dbTarget;
    }

    public DiffPaneViewer(Composite parent, int style, DbSource dbSource,
            DbSource dbTarget, boolean reverseSide) {
        super(parent, style);
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.reverseSide = reverseSide;

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

    public void setInput(Object value) {
        diffPane.setInput(value);
    }
    
    private class DiffPaneContentProvider implements IMergeViewerContentProvider {
        
        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public void dispose() {
        }

        @Override
        public boolean showAncestor(Object input) {
            return false;
        }

        @Override
        public void saveRightContent(Object input, byte[] bytes) {
        }

        @Override
        public void saveLeftContent(Object input, byte[] bytes) {
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
        public String getRightLabel(Object input) {
            return (reverseSide ? Messages.diffPartDescr_from : Messages.to)
                    + Messages.DiffPaneViewer_project;
        }

        @Override
        public Image getRightImage(Object input) {
            return null;
        }

        @Override
        public Object getRightContent(Object input) {
            TreeElement el = (TreeElement) input;
            if (el != null
                    && (el.getSide() == (reverseSide ? DiffSide.RIGHT : DiffSide.LEFT)
                    || el.getSide() == DiffSide.BOTH)) {
                return new Document(el.getPgStatement(dbSource.getDbObject()).getFullSQL());
            } else {
                return new Document();
            }
        }

        @Override
        public String getLeftLabel(Object input) {
            return (reverseSide ? Messages.to : Messages.diffPartDescr_from)
                    + Messages.database;
        }

        @Override
        public Image getLeftImage(Object input) {
            return null;
        }

        @Override
        public Object getLeftContent(Object input) {
            TreeElement el = (TreeElement) input;
            if (el != null
                    && (el.getSide() == (reverseSide ? DiffSide.LEFT: DiffSide.RIGHT)
                    || el.getSide() == DiffSide.BOTH)) {
                return new Document(el.getPgStatement(dbTarget.getDbObject()).getFullSQL());
            } else {
                return new Document();
            }
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
