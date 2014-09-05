package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.compare.internal.MergeSourceViewer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceEditingEnvironment;
import org.eclipse.datatools.sqltools.sqlbuilder.views.source.SQLSourceViewerConfiguration;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.ISQLPartitions;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLCodeScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.sql.SQLPartitionScanner;
import org.eclipse.datatools.sqltools.sqleditor.internal.utils.SQLColorProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.ITextOperationTarget;
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
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.ChangeEncodingAction;
import org.eclipse.ui.texteditor.DefaultRangeIndicator;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;

public class SqlSourceViewer extends SourceViewer implements IMenuListener {
    
    private static final String[] GLOBAL_ACTIONS= {
        ActionFactory.UNDO.getId(),
        ActionFactory.REDO.getId(),
        ActionFactory.CUT.getId(),
        ActionFactory.COPY.getId(),
        ActionFactory.PASTE.getId(),
        ActionFactory.DELETE.getId(),
        ActionFactory.SELECT_ALL.getId(),
        ActionFactory.FIND.getId(),
        ITextEditorActionDefinitionIds.LINE_GOTO
    };
    private static final String[] TEXT_ACTIONS= {
        SqlSourceViewer.UNDO_ID,
        SqlSourceViewer.REDO_ID,
        SqlSourceViewer.CUT_ID,
        SqlSourceViewer.COPY_ID,
        SqlSourceViewer.PASTE_ID,
        SqlSourceViewer.DELETE_ID,
        SqlSourceViewer.SELECT_ALL_ID,
        SqlSourceViewer.FIND_ID,
        SqlSourceViewer.GOTO_LINE_ID
    };
    public static final String UNDO_ID= "undo"; //$NON-NLS-1$
    public static final String REDO_ID= "redo"; //$NON-NLS-1$
    public static final String CUT_ID= "cut"; //$NON-NLS-1$
    public static final String COPY_ID= "copy"; //$NON-NLS-1$
    public static final String PASTE_ID= "paste"; //$NON-NLS-1$
    public static final String DELETE_ID= "delete"; //$NON-NLS-1$
    public static final String SELECT_ALL_ID= "selectAll"; //$NON-NLS-1$
    public static final String FIND_ID= "find"; //$NON-NLS-1$
    public static final String GOTO_LINE_ID= "gotoLine"; //$NON-NLS-1$
    public static final String CHANGE_ENCODING_ID= "changeEncoding"; //$NON-NLS-1$

    private FastPartitioner _partitioner = new FastPartitioner(
            new SQLPartitionScanner(), SQLPartitionScanner.SQL_PARTITION_TYPES);

    private IHandlerActivation contentAssistHandlerActivation;
    private IHandlerService handlerService;
    private HashMap<String, IAction> fActions= new HashMap<>();
    
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
        
        handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
        MenuManager menu= new MenuManager();
        menu.setRemoveAllWhenShown(true);
        menu.addMenuListener(this);
        StyledText te= getSourceViewer().getTextWidget();
        te.setMenu(menu.createContextMenu(te));
        Menu menu1 = menu.createContextMenu(this.getControl());
        this.getControl().setMenu(menu1);
//        fContainer.registerContextMenu(menu, getSourceViewer());
        connectGlobalActions(this);
    }
    
    public void activateAutocomplete() {
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
    
public void menuAboutToShow(IMenuManager menu) {
        
        menu.add(new Separator("undo")); //$NON-NLS-1$
        addMenu(menu, UNDO_ID);
        addMenu(menu, REDO_ID);
        menu.add(new Separator("ccp")); //$NON-NLS-1$
        addMenu(menu, CUT_ID);
        addMenu(menu, COPY_ID);
        addMenu(menu, PASTE_ID);
        addMenu(menu, DELETE_ID);
        addMenu(menu, SELECT_ALL_ID);
        
        // update all actions
        // to get undo redo right
        updateActions();
}

private void addMenu(IMenuManager menu, String actionId) {
    IAction action= getAction(actionId);
    if (action != null)
        menu.add(action);
}

public IAction getAction(String actionId) {
    IAction action= (IAction) fActions.get(actionId);
    if (action == null) {
        action= createAction(actionId);
        if (action == null)
            return null;
        if (action instanceof SqlMergeViewerAction) {
            SqlMergeViewerAction mva = (SqlMergeViewerAction) action;
//            if (mva.isContentDependent())
//                getSourceViewer().addTextListener(this);
//            if (mva.isSelectionDependent())
//                getSourceViewer().addSelectionChangedListener(this);
            
//            Utilities.initAction(action, fResourceBundle, "action." + actionId + ".");           //$NON-NLS-1$ //$NON-NLS-2$
        }
        addAction(actionId, action);
            
    }
    if (action instanceof SqlMergeViewerAction) {
        SqlMergeViewerAction mva = (SqlMergeViewerAction) action;
        if (mva.isEditableDependent() && !getSourceViewer().isEditable())
            return null;
    }
    return action;
}

private void connectGlobalActions(final SqlSourceViewer part) {
    if (handlerService != null) {
        if (part != null)
            part.updateActions();
        part.getControl().getDisplay().asyncExec(new Runnable() {
            public void run() {
                for (int i= 0; i < GLOBAL_ACTIONS.length; i++) {
                    IAction action= null;
                    if (part != null) {
                        action= part.getAction(TEXT_ACTIONS[i]);
                    }
//                    fHandlerService.setGlobalActionHandler(GLOBAL_ACTIONS[i], action);
                    if (action != null) {
                        handlerService.activateHandler(action.getActionDefinitionId(), new ActionHandler(action));
                    }
                }
            }
        });
    }
}

/**
 * update all actions independent of their type
 *
 */
public void updateActions() {
    Iterator<IAction> e= fActions.values().iterator();
    while (e.hasNext()) {
        Object next = e.next();
        if (next instanceof SqlMergeViewerAction) {
            SqlMergeViewerAction action = (SqlMergeViewerAction) next;
            action.update();
        } else if (next instanceof FindReplaceAction) {
            FindReplaceAction action = (FindReplaceAction) next;
            action.update();
        } else if (next instanceof ChangeEncodingAction) {
            ChangeEncodingAction action = (ChangeEncodingAction) next;
            action.update();
        }
    }
}

private SourceViewer getSourceViewer() {
    return this;
}

public void addAction(String id, IAction action) {
    fActions.put(id, action);
}

protected IAction createAction(String actionId) {
    if (UNDO_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.UNDO, IWorkbenchCommandConstants.EDIT_UNDO, true, false, true);
    if (REDO_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.REDO, IWorkbenchCommandConstants.EDIT_REDO, true, false, true);
    if (CUT_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.CUT, IWorkbenchCommandConstants.EDIT_CUT, true, true, false);
    if (COPY_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.COPY, IWorkbenchCommandConstants.EDIT_COPY, false, true, false);
    if (PASTE_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.PASTE, IWorkbenchCommandConstants.EDIT_PASTE, true, false, false);
    if (DELETE_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.DELETE, IWorkbenchCommandConstants.EDIT_DELETE, true, false, false);
    if (SELECT_ALL_ID.equals(actionId))
        return new TextOperationAction(ITextOperationTarget.SELECT_ALL, IWorkbenchCommandConstants.EDIT_SELECT_ALL, false, false, false);
    return null;
}

class TextOperationAction extends SqlMergeViewerAction {
    
    private int fOperationCode;
    
    TextOperationAction(int operationCode, boolean mutable, boolean selection, boolean content) {
        this(operationCode, null, mutable, selection, content);
    }
    
    public TextOperationAction(int operationCode, String actionDefinitionId, boolean mutable, boolean selection, boolean content) {
        super(mutable, selection, content);
        if (actionDefinitionId != null)
            setActionDefinitionId(actionDefinitionId);
        fOperationCode= operationCode;
        update();
    }

    public void run() {
        if (isEnabled())
            getSourceViewer().doOperation(fOperationCode);
    }

    public boolean isEnabled() {
        return fOperationCode != -1 && getSourceViewer().canDoOperation(fOperationCode);
    }
    
    public void update() {
        setEnabled(isEnabled());
    }
}

public abstract class SqlMergeViewerAction extends Action implements IUpdate {
    
    private boolean fMutable;
    private boolean fSelection;
    private boolean fContent;
    
    public SqlMergeViewerAction(boolean mutable, boolean selection, boolean content) {
        fMutable= mutable;
        fSelection= selection;
        fContent= content;
    }

    public boolean isSelectionDependent() {
        return fSelection;
    }
    
    public boolean isContentDependent() {
        return fContent;
    }
    
    public boolean isEditableDependent() {
        return fMutable;
    }
    
    public void update() {
        // empty default implementation
    }
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
