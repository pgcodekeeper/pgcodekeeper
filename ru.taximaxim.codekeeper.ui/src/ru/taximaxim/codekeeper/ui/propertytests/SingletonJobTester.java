package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IEditorPart;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.job.SingletonEditorJob;

public abstract class SingletonJobTester extends PropertyTester {

    protected static String makeEvalProperty(String property) {
        return PLUGIN_ID.THIS + '.' + property;
    }

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        if (getProperty().equals(property)) {
            for (Job j : Job.getJobManager().find(SingletonEditorJob.class)) {
                SingletonEditorJob sJob = (SingletonEditorJob) j;
                if (getEvalProperty().equals(sJob.getEvalProperty()) && sJob.blocks((IEditorPart) receiver)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract String getProperty();

    public abstract String getEvalProperty();
}
