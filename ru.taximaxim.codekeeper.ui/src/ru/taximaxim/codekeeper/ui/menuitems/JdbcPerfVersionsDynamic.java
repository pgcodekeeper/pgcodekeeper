package ru.taximaxim.codekeeper.ui.menuitems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class JdbcPerfVersionsDynamic extends ContributionItem {

    @Override
    public void fill(Menu menu, int index) {
        SupportedVersion[] versions = SupportedVersion.values();
        for (int i = 0; i < versions.length; ++i) {
            new ActionContributionItem(new JdbcPerfAction(versions[i]))
            .fill(menu, index + i);
        }
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    private static class JdbcPerfAction extends Action {

        private final SupportedVersion version;

        public JdbcPerfAction(SupportedVersion version) {
            super(version.getText());
            this.version = version;
        }

        @Override
        public void run() {
            try {
                Path p = Files.createTempFile(Messages.ImprovePerformanceJdbcLoader_performance_helpers + '_', ".sql"); //$NON-NLS-1$
                Files.write(p, JdbcQueries.getHelperFunctions(version).getBytes());
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
                        new FileStoreEditorInput(EFS.getLocalFileSystem().fromLocalFile(p.toFile())), EDITOR.SQL);
            } catch (PartInitException | IOException e) {
                ExceptionNotifier.notifyDefault(Messages.JdbcPerfVersionsDynamic_jdbc_helper_error, e);
            }
        }
    }
}
