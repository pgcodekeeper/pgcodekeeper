package ru.taximaxim.codekeeper.ui.parts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPage;

@SuppressWarnings("restriction")
abstract class DynamicE4View {

    private static final String METHOD = "getWorkbenchPart";
    
    protected DynamicE4View(MPart part, IWorkbenchPage page) {
        // FIXME workaround bug 443585 (E4PartWrapper created only on ACTIVATE)
        // this forces E4PartWrapper creation and puts it into context and TransientData
        try {
            Method m = WorkbenchPage.class.getDeclaredMethod(METHOD, MPart.class);
            boolean wasAccessible = m.isAccessible();
            try {
                m.setAccessible(true);
                
                // required by the call to be != null
                part.setObject(this);
                m.invoke(page, part);
            } finally {
                m.setAccessible(wasAccessible);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Reflection workaround call to getWorkbenchPart() failed!", ex); //$NON-NLS-1$
        }
        
        part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
    }
}
