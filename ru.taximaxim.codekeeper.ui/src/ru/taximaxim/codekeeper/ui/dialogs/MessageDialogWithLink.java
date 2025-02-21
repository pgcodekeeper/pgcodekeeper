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
package ru.taximaxim.codekeeper.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MessageDialogWithLink extends MessageDialog {

    private final String linkText;
    private final String link;

    public MessageDialogWithLink(Shell parentShell, String dialogTitle,
            String dialogMessage, int dialogImageType, String linkText, String link) {
        super(parentShell, dialogTitle, null, dialogMessage, dialogImageType, 0, IDialogConstants.OK_LABEL);
        this.linkText = linkText;
        this.link = link;
    }


    @Override
    protected Control createMessageArea(final Composite composite) {
        Image image = getImage();
        if (image != null) {
            imageLabel = new Label(composite, SWT.NULL);
            image.setBackground(imageLabel.getBackground());
            imageLabel.setImage(image);
            imageLabel.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
        }

        // Use Text control for message to allow copy
        if (message != null) {
            Text msg = new Text(composite, SWT.READ_ONLY | SWT.MULTI | SWT.WRAP);
            msg.setText(message);

            GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
            data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);

            msg.setLayoutData(data);
        }

        return composite;
    }

    @Override
    protected Control createCustomArea(Composite parent) {
        Composite panel = new Composite(parent, SWT.NONE);
        panel.setLayout(new GridLayout());

        Link linkHint = new Link(panel, SWT.WRAP);
        GridData gd = new GridData();
        gd.horizontalIndent = 60;
        linkHint.setLayoutData(gd);
        linkHint.setText(linkText + " <a>" + link + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
        linkHint.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Program.launch(link);
            }
        });

        return panel;
    }
}
