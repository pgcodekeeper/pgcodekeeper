package ru.taximaxim.codekeeper.cli;

import org.osgi.framework.BundleContext;

public class Utils {

    public static String getVersion() {
        BundleContext ctx = Activator.getContext();
        return ctx == null ? "error: no OSGI running" : ctx.getBundle().getVersion().toString(); //$NON-NLS-1$
    }

    private Utils() {
    }
}
