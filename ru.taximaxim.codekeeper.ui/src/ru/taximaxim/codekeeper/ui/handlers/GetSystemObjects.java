/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.IOException;
import java.io.Serializable;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.AbstractJdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcSystemLoader;
import ru.taximaxim.codekeeper.core.schema.meta.MetaStorage;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfoJdbcConnector;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class GetSystemObjects extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart part = HandlerUtil.getActiveEditor(event);
        if (part instanceof ProjectEditorDiffer differ) {
            Object db = differ.getCurrentDb();
            if (db instanceof DbInfo info && info.getDbType() == DatabaseType.PG) {
                FileDialog fd = new FileDialog(HandlerUtil.getActiveShell(event), SWT.SAVE);
                fd.setText(Messages.GetSystemObjects_save_dialog_title);
                fd.setFileName(MetaStorage.FILE_NAME + info.getDbName() + ".ser"); //$NON-NLS-1$
                String select = fd.open();
                if (select != null) {
                    AbstractJdbcConnector jdbcConnector = new DbInfoJdbcConnector(info);
                    try {
                        Serializable storage = new JdbcSystemLoader(jdbcConnector, Consts.UTC,
                                SubMonitor.convert(new NullProgressMonitor())).getStorageFromJdbc();

                        Utils.serialize(select, storage);

                        MessageBox mb = new MessageBox(HandlerUtil.getActiveShell(event), SWT.ICON_INFORMATION);
                        mb.setText(Messages.GetSystemObjects_save_success_title);
                        mb.setMessage(Messages.GetSystemObjects_save_success_message);
                        mb.open();
                    } catch (IOException | InterruptedException e) {
                        ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public boolean isEnabled() {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        return editor instanceof ProjectEditorDiffer;
    }
}