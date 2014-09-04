package ru.taximaxim.codekeeper.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import ru.taximaxim.codekeeper.ui.UIConsts.PART;
import ru.taximaxim.codekeeper.ui.UIConsts.PART_STACK;

public class DevtestPersp implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(false);
        
        IFolderLayout stack = layout.createFolder(PART_STACK.DEVTEST,
                IPageLayout.LEFT, 0.5f, layout.getEditorArea());
        
        stack.addView(PART.DEVTEST);
        layout.getViewLayout(PART.DEVTEST).setCloseable(false);
        
        stack.addView(PART.CTXP);
        layout.getViewLayout(PART.CTXP).setCloseable(false);
        
    }
}
