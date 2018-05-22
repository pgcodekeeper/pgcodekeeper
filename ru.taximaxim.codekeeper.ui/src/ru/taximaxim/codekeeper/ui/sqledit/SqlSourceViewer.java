package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.DefaultRangeIndicator;

public class SqlSourceViewer extends SourceViewer {

    private final IDocumentPartitioner partitioner = new SQLEditorCommonDocumentProvider()
            .createRecipePartitioner();

    public SqlSourceViewer(Composite parent, int style) {
        super(parent, new CompositeRuler(),
                SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.BORDER | style);
        setRangeIndicator(new DefaultRangeIndicator());
        configure(new SQLEditorSourceViewerConfiguration(EditorsUI
                .getSharedTextColors(), EditorsUI.getPreferenceStore(), null));

        getTextWidget().setFont(JFaceResources.getTextFont());
    }

    @Override
    protected void inputChanged(Object newInput, Object oldInput) {
        if (oldInput instanceof IDocumentExtension3) {
            IDocumentExtension3 doc = (IDocumentExtension3) oldInput;
            doc.setDocumentPartitioner(SQLEditorCommonDocumentProvider.SQL_PARTITIONING, null);
            partitioner.disconnect();
        }

        if (newInput instanceof IDocumentExtension3) {
            IDocumentExtension3 extension3 = (IDocumentExtension3) newInput;
            partitioner.connect((IDocument) newInput);
            extension3.setDocumentPartitioner(
                    SQLEditorCommonDocumentProvider.SQL_PARTITIONING, partitioner);
        }
        super.inputChanged(newInput, oldInput);
    }
}
