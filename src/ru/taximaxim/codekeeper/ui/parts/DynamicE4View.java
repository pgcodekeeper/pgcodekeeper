package ru.taximaxim.codekeeper.ui.parts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPage;

@SuppressWarnings("restriction")
abstract class DynamicE4View {

    protected DynamicE4View(MPart part, IWorkbenchPage page) {
        // FIXME workaround bug 443585 (TBD) (E4PartWrapper created only on ACTIVATE)
        // this forces E4PartWrapper creation and puts it into context and TransientData
        try {
            Method m = WorkbenchPage.class.getDeclaredMethod("getWorkbenchPart", MPart.class);
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
                    "Reflection workaround call to getWorkbenchPart() failed!", ex);
        }
        
        // TODO is removeOnHide still needed?
        // part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
    }
}
