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
package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.utils.TempFile;

import ru.taximaxim.codekeeper.ui.UIConsts.CMD_VARS;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;

public final class RunScriptExternal implements Runnable {

    private final String script;
    private final String cmd;
    private final UiProgressReporter reporter;
    private final Runnable postStep;

    public RunScriptExternal(String script, UiProgressReporter reporter, String cmd, Runnable postStep) {
        this.script = script;
        this.cmd = cmd;
        this.reporter = reporter;
        this.postStep = postStep;
    }

    @Override
    public void run() {
        final StdStreamRedirector sr = new StdStreamRedirector(reporter);
        try (TempFile tempFile = new TempFile("tmp_migration_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
            File outFile = tempFile.get().toFile();
            try (PrintWriter writer = new PrintWriter(outFile, Consts.UTF_8)) {
                writer.write(script);
            }
            var command = cmd.replace(CMD_VARS.SCRIPT_PLACEHOLDER, outFile.getAbsolutePath()).split(" "); //$NON-NLS-1$

            ProcessBuilder pb = new ProcessBuilder(command);
            sr.launchAndRedirect(pb);
        } catch (IOException ex) {
            throw new IllegalStateException(ex.getLocalizedMessage(), ex);
        } finally {
            reporter.terminate();
            postStep.run();
        }
    }
}