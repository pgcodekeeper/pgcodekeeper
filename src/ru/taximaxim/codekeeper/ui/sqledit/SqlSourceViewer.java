package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceEditingEnvironment;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceViewerConfiguration;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.ISQLPartitions;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLCodeScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLPartitionScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.utils.SQLColorProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.contentassist.IContentAssistant;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.DefaultRangeIndicator;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

public class SqlSourceViewer extends SourceViewer {

    private FastPartitioner _partitioner = new FastPartitioner(
            new SQLPartitionScanner(), SQLPartitionScanner.SQL_PARTITION_TYPES);

    private IHandlerActivation contentAssistHandlerActivation;
    private IHandlerService handlerService;
    
    public SqlSourceViewer(Composite parent, int style) {
        super(parent, new CompositeRuler(), 
                SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.BORDER | style);
        
        SQLSourceEditingEnvironment.connect();
        parent.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                SQLSourceEditingEnvironment.disconnect();
                if (handlerService != null
                        && contentAssistHandlerActivation != null) {
                    handlerService.deactivateHandler(contentAssistHandlerActivation);
                }
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
            @Override
            protected IContentAssistant createAndInitContentAssistant() {
                // TODO переопределить метод, расширить класс SQLPartitionScanner
                // добавить выражения для постгресс и будет полная поддержка автоввода
                // пока только базовая некоторых выражений
                return super.createAndInitContentAssistant();
            }
        });
        
        this.getTextWidget().setFont(JFaceResources.getTextFont());
    }
    
    public void activateAutocomplete() {
        handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
        final SqlSourceViewer sqlEditor = this;
        IHandler cahandler = new AbstractHandler() {

        @Override
        public Object execute(ExecutionEvent event)
                throws org.eclipse.core.commands.ExecutionException {
            sqlEditor.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
            return null;
        }
        };
        if (contentAssistHandlerActivation != null) {
            handlerService.deactivateHandler(contentAssistHandlerActivation);
        }
        contentAssistHandlerActivation = handlerService.activateHandler(
                ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS,
        cahandler);
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
