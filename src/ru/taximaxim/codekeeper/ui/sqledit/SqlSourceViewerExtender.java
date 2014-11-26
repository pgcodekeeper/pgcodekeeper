package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.ChangeEncodingAction;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.ResourceAction;

/**
 * Используется для создания самостоятельного объекта SqlSourceViewerExtender
 * имеет менюшку и поддержку клавиш ctrl+z
 * Для предоставления вьювера например как просмотрщик для TextMergeViewer 
 * используйте класс SQLSourceViewer!
 */
public class SqlSourceViewerExtender extends SqlSourceViewer implements
        IMenuListener, ITextListener, ISelectionChangedListener {

    private static final String[] TEXT_ACTIONS = {
            SqlSourceViewerExtender.UNDO_ID,
            SqlSourceViewerExtender.REDO_ID,
            /*
            SqlSourceViewerExtender.CUT_ID,
            SqlSourceViewerExtender.COPY_ID,
            SqlSourceViewerExtender.PASTE_ID,
            SqlSourceViewerExtender.DELETE_ID,
            SqlSourceViewerExtender.SELECT_ALL_ID,
            */
            SqlSourceViewerExtender.FIND_ID,
            SqlSourceViewerExtender.GOTO_LINE_ID
            };
    public static final String UNDO_ID = "undo"; //$NON-NLS-1$
    public static final String REDO_ID = "redo"; //$NON-NLS-1$
    public static final String CUT_ID = "cut"; //$NON-NLS-1$
    public static final String COPY_ID = "copy"; //$NON-NLS-1$
    public static final String PASTE_ID = "paste"; //$NON-NLS-1$
    public static final String DELETE_ID = "delete"; //$NON-NLS-1$
    public static final String SELECT_ALL_ID = "selectAll"; //$NON-NLS-1$
    public static final String FIND_ID = "find"; //$NON-NLS-1$
    public static final String GOTO_LINE_ID = "gotoLine"; //$NON-NLS-1$
    public static final String CHANGE_ENCODING_ID = "changeEncoding"; //$NON-NLS-1$

    private IHandlerActivation contentAssistHandlerActivation;
    private IHandlerService handlerService;
    private Map<String, IAction> fActions = new HashMap<>();
    private List<IHandlerActivation> fActionHandlers = new ArrayList<>();

    public SqlSourceViewerExtender(Composite parent, int style) {
        super(parent, style);
        parent.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                freeObjects();
            }
        });

        handlerService = (IHandlerService) PlatformUI.getWorkbench()
                .getService(IHandlerService.class);

        MenuManager menu = new MenuManager();
        menu.setRemoveAllWhenShown(true);
        menu.addMenuListener(this);
        this.getTextWidget().setMenu(menu.createContextMenu(this.getTextWidget()));
        contributeFindAction();
        connectGlobalActions();
    }

    private void freeObjects() {
        if (handlerService != null) {
            if (contentAssistHandlerActivation != null) {
                handlerService.deactivateHandler(contentAssistHandlerActivation);
            }
            clearHandlers();
        }
    }

    private void clearHandlers() {
        handlerService.deactivateHandlers(fActionHandlers);
        fActionHandlers.clear();
    }

    public void activateAutocomplete() {
        IHandler caHandler = new AbstractHandler() {

            @Override
            public Object execute(ExecutionEvent event) throws ExecutionException {
                SqlSourceViewerExtender.this.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
                return null;
            }
        };
        if (contentAssistHandlerActivation != null) {
            handlerService.deactivateHandler(contentAssistHandlerActivation);
        }
        contentAssistHandlerActivation = handlerService.activateHandler(
                ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS,
                caHandler);
    }

    @Override
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
        // menu.add(new Separator("edit")); //$NON-NLS-1$
        // addMenu(menu, CHANGE_ENCODING_ID);
        menu.add(new Separator("find")); //$NON-NLS-1$
        addMenu(menu, FIND_ID);

        // update all actions
        // to get undo redo right
        updateActions();
    }

    private void contributeFindAction() {
        IAction action = new FindReplaceAction(
                getResourceBundle(),
                "Editor.FindReplace.", this.getControl().getShell(), getFindReplaceTarget()); //$NON-NLS-1$
        action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_FIND_AND_REPLACE);
        this.addAction(SqlSourceViewerExtender.FIND_ID, action);
    }

    /**
     * Используется для перевода пунктов меню
     * @return Бандл с переводом пунктов меню
     */
    private ResourceBundle getResourceBundle() {
        return ResourceBundle
                .getBundle("org.eclipse.compare.contentmergeviewer.TextMergeViewerResources"); //$NON-NLS-1$
    }

    /*
     * private void contributeGotoLineAction(SqlSourceViewerExtender viewer) {
     * IAction action = new GotoLineAction((ITextEditor)
     * viewer.getAdapter(ITextEditor.class));
     * action.setActionDefinitionId(ITextEditorActionDefinitionIds.LINE_GOTO);
     * viewer.addAction(SqlSourceViewerExtender.GOTO_LINE_ID, action); }
     * 
     * private void contributeChangeEncodingAction(SqlSourceViewerExtender
     * viewer) { IAction action = new
     * ChangeEncodingAction(getTextEditorAdapter());
     * viewer.addAction(SqlSourceViewerExtender.CHANGE_ENCODING_ID, action); }
     */
    private void addMenu(IMenuManager menu, String actionId) {
        IAction action = getAction(actionId);
        if (action != null)
            menu.add(action);
    }

    private IAction getAction(String actionId) {
        IAction action = fActions.get(actionId);
        if (action == null) {
            action = createAction(actionId);
            if (action == null)
                return null;
            if (action instanceof SqlViewerAction) {
                initAction(action, getResourceBundle(),
                        "action." + actionId + "."); //$NON-NLS-1$ //$NON-NLS-2$
            }
            addAction(actionId, action);

        }
        if (action instanceof SqlViewerAction) {
            SqlViewerAction mva = (SqlViewerAction) action;
            if (mva.isEditableDependent() && !this.isEditable())
                return null;
        }
        return action;
    }

    private void connectGlobalActions() {
        if (handlerService != null) {
            updateActions();
            clearHandlers();
            this.getControl().getDisplay().asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    for (String actionName : TEXT_ACTIONS) {
                        IAction action = null;
                        action = getAction(actionName);
                        if (action != null) {
                            fActionHandlers.add(handlerService.activateHandler(
                                    action.getActionDefinitionId(),
                                    new ActionHandler(action)));
                        }
                    }
                }
            });
        }
    }

    @Override
    public void textChanged(TextEvent event) {
        Iterator<IAction> e = fActions.values().iterator();
        while (e.hasNext()) {
            Object next = e.next();
            if (next instanceof SqlViewerAction) {
                SqlViewerAction action = (SqlViewerAction) next;
                if (action.isContentDependent())
                    action.update();
            }
        }
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        Iterator<IAction> e = fActions.values().iterator();
        while (e.hasNext()) {
            Object next = e.next();
            if (next instanceof SqlViewerAction) {
                SqlViewerAction action = (SqlViewerAction) next;
                if (action.isSelectionDependent())
                    action.update();
            }
        }
    }

    /**
     * update all actions independent of their type
     *
     */
    private void updateActions() {
        Iterator<IAction> e = fActions.values().iterator();
        while (e.hasNext()) {
            Object next = e.next();
            if (next instanceof SqlViewerAction) {
                SqlViewerAction action = (SqlViewerAction) next;
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

    private void addAction(String id, IAction action) {
        fActions.put(id, action);
    }

    protected IAction createAction(String actionId) {
        switch (actionId) {
        case UNDO_ID:
            return new TextOperationAction(ITextOperationTarget.UNDO,
                    IWorkbenchCommandConstants.EDIT_UNDO, true, false, true);
        case REDO_ID:
            return new TextOperationAction(ITextOperationTarget.REDO,
                    IWorkbenchCommandConstants.EDIT_REDO, true, false, true);
        case CUT_ID:
            return new TextOperationAction(ITextOperationTarget.CUT,
                    IWorkbenchCommandConstants.EDIT_CUT, true, true, false);
        case COPY_ID:
            return new TextOperationAction(ITextOperationTarget.COPY,
                    IWorkbenchCommandConstants.EDIT_COPY, false, true, false);
        case PASTE_ID:
            return new TextOperationAction(ITextOperationTarget.PASTE,
                    IWorkbenchCommandConstants.EDIT_PASTE, true, false, false);
        case DELETE_ID:
            return new TextOperationAction(ITextOperationTarget.DELETE,
                    IWorkbenchCommandConstants.EDIT_DELETE, true, false, false);
        case SELECT_ALL_ID:
            return new TextOperationAction(ITextOperationTarget.SELECT_ALL,
                    IWorkbenchCommandConstants.EDIT_SELECT_ALL, false, false,
                    false);
        default:
            return null;
        }
    }

    class TextOperationAction extends SqlViewerAction {

        private int fOperationCode;

        TextOperationAction(int operationCode, boolean mutable,
                boolean selection, boolean content) {
            this(operationCode, null, mutable, selection, content);
        }

        public TextOperationAction(int operationCode,
                String actionDefinitionId, boolean mutable, boolean selection,
                boolean content) {
            super(mutable, selection, content);
            if (actionDefinitionId != null)
                setActionDefinitionId(actionDefinitionId);
            fOperationCode = operationCode;
            update();
        }

        @Override
        public void run() {
            if (isEnabled())
                getSourceViewer().doOperation(fOperationCode);
        }

        @Override
        public boolean isEnabled() {
            return fOperationCode != -1
                    && getSourceViewer().canDoOperation(fOperationCode);
        }

        @Override
        public void update() {
            setEnabled(isEnabled());
        }
    }

    private abstract class SqlViewerAction extends Action implements IUpdate {

        private boolean fMutable;
        private boolean fSelection;
        private boolean fContent;

        public SqlViewerAction(boolean mutable, boolean selection,
                boolean content) {
            fMutable = mutable;
            fSelection = selection;
            fContent = content;
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

        @Override
        public void update() {
        }
    }

    /**
     * Initialize the given Action from a ResourceBundle.
     */
    private static void initAction(IAction a, ResourceBundle bundle,
            String prefix) {
        ResourceAction ra = new ResourceAction(bundle, prefix){};
        a.setText(ra.getText());
        a.setToolTipText(ra.getToolTipText());
        a.setDescription(ra.getDescription());
        a.setImageDescriptor(ra.getImageDescriptor());
    }
}
