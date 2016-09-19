package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.PlatformObject;

public class OpenProjectFromNavigator extends PlatformObject {

    private final IProject proj;

    public IProject getProject() {
        return proj;
    }

    public OpenProjectFromNavigator(IProject proj) {
        this.proj = proj;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (adapter.isAssignableFrom(IProject.class)) {
            return adapter.cast(proj);
        }
        return super.getAdapter(adapter);
    }
}
