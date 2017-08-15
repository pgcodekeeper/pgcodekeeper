package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;

import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class ChangesJobTester extends PropertyTester {

    private static final String IS_JOB_RUNNING = "isGetChangesRunning";

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        if (IS_JOB_RUNNING.equals(property)) {
            return ((ProjectEditorDiffer) receiver).isGetChangesJobInProcessing();
        }
        return false;
    }

}
