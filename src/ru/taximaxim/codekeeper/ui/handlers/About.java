
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.AddonExternalTools;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

public class About {
    @Execute
    private void execute(Shell parentShell) {
        String jGitVersion = "unknown";
        try {
            jGitVersion = new JGitExec().repoGetVersion();
        } catch (IOException e) {
        }
        String [] plugins = new String[]{
                "ru.taximaxim.codekeeper.mainapp", 
                "ru.taximaxim.codekeeper.ui", 
                "apgdiff", 
                "com.opcoach.e4.contextExplorer"};
        String [] versions = AddonExternalTools.getPluginsVersion(plugins);
        String message = String.format(
                "pgCodeKeeper version: %s\n\n" + 
                plugins[0] + " version: %s\n"
                + plugins[1] + " version: %s\n"
                + plugins[2] + " version: %s\n"
                + plugins[3] + " version: %s\n\n"
                + "pg_dump version: %s\n"
                + "jgit version: %s",
                UIConsts.VERSION,
                versions[0],
                versions[1],
                versions[2],
                versions[3],
                AddonExternalTools.getPgdumpVersion(),
                jGitVersion);
        
        new MessageDialog(parentShell, "About pgCodeKeeper...", null,
                message, MessageDialog.INFORMATION, new String[] { "Ok" }, 0) {

            @Override
            protected void setShellStyle(int newShellStyle) {
                super.setShellStyle(getShellStyle() | SWT.RESIZE);
            }
        }.open();
    }
}