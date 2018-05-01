package ru.taximaxim.codekeeper.ui.comparetools;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import cz.startnet.utils.pgdiff.schema.PgOverride;
import ru.taximaxim.codekeeper.ui.sqledit.SqlSourceViewer;

public class CompareInput extends CompareEditorInput {

    private static final String TITLE = "Compare (''{0}'' - ''{1}'')"; //$NON-NLS-1$

    private final CompareItem left;
    private final CompareItem right;

    public CompareInput(PgOverride override) {
        super(new CompareConfiguration());

        String oldPath = override.getOldLocation();
        String newPath = override.getNewLocation();

        left = getContent(oldPath);
        right = getContent(newPath);

        getCompareConfiguration().setLeftLabel(oldPath);
        getCompareConfiguration().setRightLabel(newPath);

        setTitle(MessageFormat.format(TITLE, oldPath, newPath));
    }

    @Override
    public Viewer findContentViewer(Viewer oldViewer, ICompareInput input, Composite parent) {
        CompareConfiguration conf = getCompareConfiguration();
        TextMergeViewer diffPane = new TextMergeViewer(parent, SWT.BORDER, conf) {

            @Override
            protected void configureTextViewer(TextViewer textViewer) {
                // viewer configure yourself
            }

            @Override
            protected SourceViewer createSourceViewer(Composite parent,
                    int textOrientation) {
                return new SqlSourceViewer(parent, textOrientation);
            }
        };

        diffPane.setContentProvider(new DiffContentProvider(conf));
        return diffPane;
    }

    private CompareItem getContent(String path) {
        if (path.startsWith("jdbc:")) { //$NON-NLS-1$
            return new CompareItem(path, "JDBC content is not available"); //$NON-NLS-1$
        }

        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            content = "File not found"; //$NON-NLS-1$
        }
        return new CompareItem(path, content);
    }

    @Override
    protected Object prepareInput(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        return new DiffNode(null, Differencer.CHANGE, null, left, right);
    }
}
