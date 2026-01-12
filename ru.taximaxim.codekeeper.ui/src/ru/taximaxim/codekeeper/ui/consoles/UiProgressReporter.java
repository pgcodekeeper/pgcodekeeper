/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.consoles;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.pgcodekeeper.core.reporter.IProgressReporter;

import ru.taximaxim.codekeeper.ui.ITextErrorReporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.VIEW;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.views.ResultSetView;

public class UiProgressReporter implements IProgressReporter {

    private final CodekeeperConsole console;
    private final ITextErrorReporter errorReporter;
    private final int offset;
    private final String dbName;

    public UiProgressReporter(IProgressMonitor monitor, ITextErrorReporter errorReporter) {
        this(monitor, errorReporter, 0, null);
    }

    public UiProgressReporter(IProgressMonitor monitor, ITextErrorReporter errorReporter,
            int offset, String dbName) {
        IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
        console = CodekeeperConsole.createInstance(monitor, dbName);
        manager.addConsoles(new IConsole[] { console });
        this.errorReporter = errorReporter;
        this.offset = offset;
        this.dbName = dbName;
    }

    /**
     * Initial, write one error message and terminate console
     */
    public static void writeSingleError(String error) {
        try (UiProgressReporter reporter = new UiProgressReporter(new NullProgressMonitor(), null)) {
            reporter.writeError(error);
        }
    }

    @Override
    public void writeMessage(String message) {
        console.write(message);
    }

    @Override
    public void writeWarning(String message) {
        console.writeWarning(Messages.UiProgressReporter_warning + message);
    }

    @Override
    public void writeError(String message) {
        console.writeError(message);
    }

    @Override
    public void writeDbName() {
        console.write("Execute script on " + dbName); //$NON-NLS-1$
    }

    @Override
    public void terminate() {
        console.terminate();
    }

    @Override
    public void showData(String query, List<List<Object>> results) {
        UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            try {
                ResultSetView viewPart = (ResultSetView) page.showView(VIEW.RESULT_SET_VIEW);
                viewPart.addData(query, results);
            } catch (PartInitException e) {
                Log.log(e);
            }
        });

    }

    @Override
    public void reportErrorLocation(int start, int length) {
        if (errorReporter != null) {
            errorReporter.setErrorPosition(offset + start, length);
        }
    }
}
