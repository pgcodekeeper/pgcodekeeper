package ru.taximaxim.codekeeper.ui.comparetools;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;

public class SqlMergeViewer extends TextMergeViewer {

    public SqlMergeViewer(Composite parent, int style, CompareConfiguration conf) {
        super(parent, style, conf);
    }

    @Override
    protected void configureTextViewer(TextViewer textViewer) {
        // viewer configures itself
    }

    @Override
    protected SourceViewer createSourceViewer(Composite parent,
            int textOrientation) {
        return new SqlSourceViewer(parent, textOrientation);
    }
}
