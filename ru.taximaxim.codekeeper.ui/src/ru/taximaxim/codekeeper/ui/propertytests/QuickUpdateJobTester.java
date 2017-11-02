package ru.taximaxim.codekeeper.ui.propertytests;

public class QuickUpdateJobTester extends SingletonJobTester {

    private static final String PROP = "isQuickUpdateRunning"; //$NON-NLS-1$
    public static final String EVAL_PROP = makeEvalProperty(PROP);

    @Override
    public String getProperty() {
        return PROP;
    }

    @Override
    public String getEvalProperty() {
        return EVAL_PROP;
    }
}