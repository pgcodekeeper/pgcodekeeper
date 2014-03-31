
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.AddonExternalTools;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;

public class About {
    @Execute
    private void execute(Shell parentShell) {
        MessageBox m = new MessageBox(parentShell, SWT.ICON_INFORMATION);
        m.setText("About pgCodeKeeper...");
        String jGitVersion = "unknown";
        try {
            jGitVersion = new JGitExec().repoGetVersion();
        } catch (IOException e) {
        } 
        m.setMessage(String.format(
                "pgCodeKeeper version %s\n\n"
                + "svn version: %s\n"
                + "pg_dump version: %s\n"
                + "jgit version: %s",
                UIConsts.VERSION,
                AddonExternalTools.getSvnVersion(),
                AddonExternalTools.getPgdumpVersion(),
                jGitVersion));
        m.open();
    }
}