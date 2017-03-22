package ru.taximaxim.codekeeper.apgdiff;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * For thread pools that shouldn't prevent normal program shutdown.
 *
 * @author levsha_aa
 */
public class DaemonThreadFactory implements ThreadFactory {

    ThreadFactory defaultTf = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(Runnable r) {
        Thread t = defaultTf.newThread(r);
        t.setDaemon(true);
        return t;
    }
}
