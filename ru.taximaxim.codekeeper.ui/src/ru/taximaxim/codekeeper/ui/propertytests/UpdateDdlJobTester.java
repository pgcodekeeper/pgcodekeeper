package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;

import ru.taximaxim.codekeeper.ui.sqledit.RollOnEditor;

public class UpdateDdlJobTester extends PropertyTester {
    private static final String IS_JOB_RUNNING = "isUpdateDdlRunning"; //$NON-NLS-1$

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        if (IS_JOB_RUNNING.equals(property)) {
            return ((RollOnEditor) receiver).isUpdateDdlJobInProcessing();
        }
        return false;
    }
}