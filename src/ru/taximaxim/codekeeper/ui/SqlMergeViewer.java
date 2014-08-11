package ru.taximaxim.codekeeper.ui;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceViewerConfiguration;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.ISQLPartitions;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLPartitionScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class SqlMergeViewer extends TextMergeViewer {
    
    public SqlMergeViewer( Composite parent, int style, CompareConfiguration configuration ) {
        super( parent, style, configuration );
    }
 
    @Override
    protected void configureTextViewer( TextViewer textViewer ) {
 
        if( textViewer instanceof ISourceViewer ) {
            ((SourceViewer) textViewer).configure(new SQLSourceViewerConfiguration() {

                @Override
                public IPresentationReconciler getPresentationReconciler(
                        ISourceViewer sourceViewer) {
                    return super.getPresentationReconciler(sourceViewer);
                }
            });
        }
    }
 
    @Override
    protected SourceViewer createSourceViewer( Composite parent, int textOrientation ) {
 
        int style = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL;
          CompositeRuler ruler = new CompositeRuler();
          ruler.addDecorator(0, new LineNumberRulerColumn());
        return new SourceViewer( parent, ruler, null, false, textOrientation | style ) {
            @Override
            public void setDocument( IDocument doc) {
 
                SQLPartitionScanner sqlPartitionSanner = new SQLPartitionScanner();
                if(doc instanceof IDocumentExtension3)
                {
                IDocumentExtension3 extension3 = (IDocumentExtension3) doc;
                FastPartitioner _partitioner = new FastPartitioner(sqlPartitionSanner, new String[]
                {
                SQLPartitionScanner.SQL_CODE,
                SQLPartitionScanner.SQL_COMMENT,
                SQLPartitionScanner.SQL_MULTILINE_COMMENT,
                SQLPartitionScanner.SQL_STRING,
                SQLPartitionScanner.SQL_DOUBLE_QUOTES_IDENTIFIER
                });
                _partitioner.connect(doc);
                extension3.setDocumentPartitioner(ISQLPartitions.SQL_PARTITIONING, _partitioner);
                }
                super.setDocument(doc);
            }
        };
    }
}
