package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class FeedBackDialog extends Dialog {

    private static final String STATUS_OK = "{\"status\":\"ok\"}"; //$NON-NLS-1$

    private Text txtSubject;
    private Text emailFrom;
    private Text txtMessage;
    private Button btnCheckLog;

    public FeedBackDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.FeedBackDialog_feedback);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.FeedBackDialog_subject);

        txtSubject = new Text(container, SWT.BORDER);
        txtSubject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(container, SWT.NONE).setText(Messages.e_mail);

        emailFrom = new Text(container, SWT.BORDER);
        emailFrom.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(container, SWT.NONE).setText(Messages.feedback_message);

        txtMessage = new Text(container, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.heightHint = new PixelConverter(container).convertHeightInCharsToPixels(8);
        txtMessage.setLayoutData(gd);

        new Label(container, SWT.NONE);

        btnCheckLog = new Button(container, SWT.CHECK);
        btnCheckLog.setText(Messages.add_log);

        return container;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);

        getButton(IDialogConstants.OK_ID).setText(Messages.FeedBackDialog_send);
    }

    @Override
    protected Point getInitialSize() {
        Point size = super.getInitialSize();
        return new Point(Math.max(size.x, 450), Math.max(size.y, 300));
    }

    @Override
    protected void okPressed() {
        if (txtMessage.getText().isEmpty() || emailFrom.getText().isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.FeedBackDialog_empty_fields_title);
            mb.setMessage(Messages.FeedBackDialog_empty_fields_message);
            mb.open();
            return;
        }

        try {
            sendMail(emailFrom.getText(), txtMessage.getText(),
                    txtSubject.getText(), btnCheckLog.getSelection());
            super.okPressed();
        } catch (IOException mex) {
            Log.log(mex);
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.FeedBackDialog_could_not_send);
            mb.setMessage(MessageFormat.format(Messages.FeedBackDialog_failure_instruction, mex.getLocalizedMessage()));
            mb.open();
        }
    }

    private void sendMail(String emailFrom, String txtMessage, String subject,
            boolean appendLog) throws IOException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            HttpPost uploadFile = new HttpPost("http://license-service.chelny.taximaxim.ru/feedback"); //$NON-NLS-1$
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            ContentType utf = ContentType.create("text/plain", Consts.UTF_8); //$NON-NLS-1$
            builder.addTextBody("subject", subject, utf); //$NON-NLS-1$
            builder.addTextBody("email", emailFrom, utf); //$NON-NLS-1$
            builder.addTextBody("body", txtMessage, utf); //$NON-NLS-1$

            if (appendLog) {
                File log = Platform.getLogFileLocation().toFile();
                builder.addBinaryBody("files", new FileInputStream(log), //$NON-NLS-1$
                        ContentType.APPLICATION_OCTET_STREAM,
                        log.getName());
            }
            HttpEntity multipart = builder.build();

            uploadFile.setEntity(multipart);
            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(responseEntity.getContent()));) {
                if (STATUS_OK.equals(br.readLine())) {
                    MessageBox mb = new MessageBox(getParentShell(), SWT.ICON_INFORMATION);
                    mb.setText(Messages.FeedBackDialog_feedback_sent);
                    mb.setMessage(Messages.FeedBackDialog_thank_you);
                    mb.open();
                } else {
                    throw new IOException("Server return error code"); //$NON-NLS-1$
                }
            }
        }
    }
}
