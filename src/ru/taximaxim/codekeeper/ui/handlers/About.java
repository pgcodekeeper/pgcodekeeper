
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.AddonExternalTools;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class About {
    @Execute
    private void execute(Shell parentShell) {
        MessageBox m = new MessageBox(parentShell, SWT.ICON_INFORMATION);
        m.setText("About pgCodeKeeper...");
        m.setMessage(String.format(
                "pgCodeKeeper version %s\n\n"
                + "svn version: %s\n"
                + "pg_dump version: %s\n"
                + "jgit version: %s",
                UIConsts.VERSION,
                AddonExternalTools.getSvnVersion(),
                AddonExternalTools.getPgdumpVersion(),
                AddonExternalTools.getJGitVersion()));
        m.open();
    }
}