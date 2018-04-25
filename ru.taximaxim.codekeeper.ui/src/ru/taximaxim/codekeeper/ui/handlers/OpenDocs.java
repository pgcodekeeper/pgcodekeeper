package ru.taximaxim.codekeeper.ui.handlers;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Log;

public class OpenDocs extends AbstractHandler {

    private static final String URL = "http://pgcodekeeper.readthedocs.io"; //$NON-NLS-1$

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser()
            .openURL(new URL(URL));
        } catch (PartInitException | MalformedURLException e) {
            Log.log(e);
        }

        return null;
    }
}
