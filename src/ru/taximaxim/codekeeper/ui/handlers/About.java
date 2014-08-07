
package ru.taximaxim.codekeeper.ui.handlers;

import java.util.List;
import java.util.Map;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.addons.AddonExternalTools;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class About {
    @Execute
    private void execute(Shell parentShell) {
        Map<String, List<String>> versions = Activator.getPluginVersions();
        
        String message = String.format(
                Messages.about_pgcodekeeper_version
                + Messages.about_version
                + Messages.about_version_n
                + Messages.about_version_n
                + Messages.about_pg_dump_version,
                
                versions.get(PLUGIN_ID.MAINAPP).get(0),
                
                PLUGIN_ID.THIS,
                versions.get(PLUGIN_ID.THIS).get(0),
                
                PLUGIN_ID.APGDIFF,
                versions.get(PLUGIN_ID.APGDIFF).get(0),
                
                PLUGIN_ID.JGIT,
                versions.get(PLUGIN_ID.JGIT).get(0),
                
                AddonExternalTools.getPgdumpVersion());
        
        MessageDialog.open(MessageDialog.INFORMATION, parentShell,
                Messages.about_about_pgcodekeeper, message, SWT.RESIZE);
    }
}