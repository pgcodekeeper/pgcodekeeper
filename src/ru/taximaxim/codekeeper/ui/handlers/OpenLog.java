 
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.program.Program;

public class OpenLog extends E4HandlerWrapper {
    
    @Execute
    private void execute() {
        openExternalViewer();
    }
    
    public static void openExternalViewer() {
        Program.launch(Platform.getLogFileLocation().toFile().getAbsolutePath());
    }
}