package ru.taximaxim.codekeeper.ui.builders;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;

import ru.taximaxim.codekeeper.ui.handlers.AddBuilder;

public class BuilderTester extends PropertyTester {

    private static final String IS_ENABLED = "isEnabled"; //$NON-NLS-1$

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        if (IS_ENABLED.equals(property)) {
            return AddBuilder.hasBuilder((IProject) receiver);
        }

        return false;
    }
}
