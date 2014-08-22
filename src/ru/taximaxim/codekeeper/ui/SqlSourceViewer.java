package ru.taximaxim.codekeeper.ui;

import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceEditingEnvironment;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceViewerConfiguration;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.ISQLPartitions;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLCodeScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLPartitionScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.utils.SQLColorProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.DefaultRangeIndicator;

public class SqlSourceViewer extends SourceViewer {

    private FastPartitioner _partitioner = new FastPartitioner(
            new SQLPartitionScanner(), SQLPartitionScanner.SQL_PARTITION_TYPES);
    
    public SqlSourceViewer(Composite parent, int style) {
        super(parent, new CompositeRuler(), 
                SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.BORDER | style);
        
        SQLSourceEditingEnvironment.connect();
        parent.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                SQLSourceEditingEnvironment.disconnect();
            }
        });
        
        this.setRangeIndicator(new DefaultRangeIndicator());
        this.configure(new SQLSourceViewerConfiguration() {
            
            @Override
            public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
                return SQLPartitionScanner.SQL_PARTITION_TYPES;
            }
            
            @Override
            public IPresentationReconciler getPresentationReconciler(
                    ISourceViewer sourceViewer) {
                SQLColorProvider colorProvider = new SQLColorProvider();
                SQLCodeScanner scanner = new SQLCodeScanner(colorProvider);
                scanner.setSQLSyntax(new SqlPostgresSyntax());
                
                PresentationReconciler reconciler = new PresentationReconciler();
                reconciler.setDocumentPartitioning(SQLPartitionScanner.SQL_PARTITIONING);
                
                for(String token : SQLPartitionScanner.SQL_PARTITION_TYPES) {
                    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
                    reconciler.setDamager(dr, token);
                    reconciler.setRepairer(dr, token);
                }
                
                return reconciler;
            }
        });
        
        this.getTextWidget().setFont(JFaceResources.getTextFont());
    }
    
    public void addLineNumbers() {
        LineNumberRulerColumn decorator = new LineNumberRulerColumn();
        decorator.setFont(JFaceResources.getTextFont());
        decorator.setForeground(this.getControl().getDisplay().getSystemColor(SWT.COLOR_GRAY));
        ((CompositeRuler) this.getVerticalRuler()).addDecorator(0, decorator);
    }

    @Override
    protected void inputChanged(Object newInput, Object oldInput) {
        if (oldInput instanceof IDocumentExtension3) {
            IDocumentExtension3 doc = (IDocumentExtension3) oldInput;
            doc.setDocumentPartitioner(ISQLPartitions.SQL_PARTITIONING, null);
            _partitioner.disconnect();
        }
        
        if (newInput instanceof IDocumentExtension3) {
            IDocumentExtension3 extension3 = (IDocumentExtension3) newInput;
            _partitioner.connect((IDocument) newInput);
            extension3.setDocumentPartitioner(
                    ISQLPartitions.SQL_PARTITIONING, _partitioner);
        }
        super.inputChanged(newInput, oldInput);
    }
}
