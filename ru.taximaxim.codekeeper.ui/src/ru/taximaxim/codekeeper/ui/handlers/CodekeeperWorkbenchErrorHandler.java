/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.statushandlers.AbstractStatusAreaProvider;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.WorkbenchErrorHandler;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class CodekeeperWorkbenchErrorHandler extends WorkbenchErrorHandler {

    @Override
    protected void configureStatusDialog(final WorkbenchStatusDialogManager statusDialog) {
        statusDialog.setSupportAreaProvider(new StackTraceSupportArea(statusDialog));
    }

    private static final class StackTraceSupportArea extends AbstractStatusAreaProvider {

        private WorkbenchStatusDialogManager statusDialog;

        public StackTraceSupportArea(WorkbenchStatusDialogManager statusDialog) {
            this.statusDialog = statusDialog;
        }

        @Override
        public Control createSupportArea(Composite parent, StatusAdapter statusAdapter) {
            var composite = new Composite(parent, SWT.NONE);
            composite.setLayout(new GridLayout());
            Button btnCopy = new Button(composite, SWT.BORDER);
            btnCopy.setText(Messages.CodekeeperWorkbenchErrorHandler_copy_all);

            btnCopy.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    var sb = new StringBuilder();
                    for (var el : statusDialog.getStatusAdapters()) {
                        sb.append(getErrorMessage((StatusAdapter) el)).append(UIConsts._NL).append(UIConsts._NL);
                    }

                    var cb = new Clipboard(composite.getDisplay());
                    cb.setContents(new Object[] { sb.toString() }, new Transfer[] { TextTransfer.getInstance() });
                }

                private String getErrorMessage(StatusAdapter adapter) {
                    var status = adapter.getStatus();
                    var exception = status.getException();
                    if (null == exception) {
                        return status.getMessage();
                    }
                    return status.getMessage() + UIConsts._NL + exception.getLocalizedMessage();
                }
            });

            GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
            data.widthHint = new PixelConverter(parent).convertWidthInCharsToPixels(20);
            btnCopy.setLayoutData(data);
            return composite;
        }
    }
}