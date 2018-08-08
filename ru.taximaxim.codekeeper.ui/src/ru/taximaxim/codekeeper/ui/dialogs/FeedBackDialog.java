package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
import org.osgi.framework.Bundle;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class FeedBackDialog extends Dialog {

    private static final String URL = "http://license-service.chelny.taximaxim.ru/feedback"; //$NON-NLS-1$
    private static final String TEXT_PLAIN = "text/plain"; //$NON-NLS-1$
    private static final String POST_SUBJECT = "subject"; //$NON-NLS-1$
    private static final String POST_EMAIL = "email"; //$NON-NLS-1$
    private static final String POST_BODY = "body"; //$NON-NLS-1$
    private static final String POST_FILES = "files"; //$NON-NLS-1$
    private static final String STATUS_OK = "{\"status\":\"ok\"}"; //$NON-NLS-1$
    private static final Pattern PATTERN_WS = Pattern.compile("[\\s]"); //$NON-NLS-1$

    private Text txtSubject;
    private Text emailFrom;
    private Text txtMessage;
    private Button btnCheckLog;

    public FeedBackDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void setShellStyle(int newShellStyle) {
        super.setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
        setBlockOnOpen(false);
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
        GridData gd = new GridData(GridData.FILL_BOTH);
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
                    txtSubject.getText(), btnCheckLog.getSelection(), null);
            super.okPressed();

            MessageBox mb = new MessageBox(getParentShell(), SWT.ICON_INFORMATION);
            mb.setText(Messages.FeedBackDialog_feedback_sent);
            mb.setMessage(Messages.FeedBackDialog_thank_you);
            mb.open();
        } catch (IOException mex) {
            Log.log(mex);
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.FeedBackDialog_could_not_send);
            mb.setMessage(MessageFormat.format(Messages.FeedBackDialog_failure_instruction, mex.getLocalizedMessage()));
            mb.open();
        }
    }

    /**
     * Send feedback
     *
     * @param emailFrom - email
     * @param txtMessage - feedback message
     * @param subject - feedback subject
     * @param appendLog - if true append log file to mail
     * @param params - optional params
     * @throws IOException - error sending feedback
     */
    public static void sendMail(String emailFrom, String txtMessage, String subject,
            boolean appendLog, Map<String, String> params) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            HttpPost uploadFile = new HttpPost(URL);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            StringBuilder sbMessage = new StringBuilder();
            sbMessage.append(txtMessage);
            sbMessage.append("\n\n------pgCodeKeeper configuration--------\n"); //$NON-NLS-1$
            appendCodeKeeperPluginsInformation(sbMessage);

            ContentType utf = ContentType.create(TEXT_PLAIN, StandardCharsets.UTF_8);
            builder.addTextBody(POST_SUBJECT, subject, utf);
            builder.addTextBody(POST_EMAIL, emailFrom, utf);
            builder.addTextBody(POST_BODY, sbMessage.toString(), utf);
            if (params!= null) {
                params.forEach((k, v) -> builder.addTextBody(k, v, utf));
            }

            if (appendLog) {
                Path log = Platform.getLogFileLocation().toFile().toPath();
                byte[] logBytes;
                try {
                    logBytes = Files.readAllBytes(log);
                } catch (NoSuchFileException ex) {
                    logBytes = ex.toString().getBytes(StandardCharsets.UTF_8);
                }
                builder.addBinaryBody(POST_FILES, logBytes,
                        ContentType.APPLICATION_OCTET_STREAM,
                        log.getFileName().toString());
            }
            HttpEntity multipart = builder.build();

            uploadFile.setEntity(multipart);
            try (CloseableHttpResponse response = httpClient.execute(uploadFile);) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity == null) {
                    throw new IOException(MessageFormat.format(
                            Messages.FeedBackDialog_bad_response, response.toString()));
                }

                String entity = EntityUtils.toString(responseEntity);
                if (!STATUS_OK.equals(PATTERN_WS.matcher(entity).replaceAll(""))) { //$NON-NLS-1$
                    throw new IOException(MessageFormat.format(
                            Messages.FeedBackDialog_bad_response, entity));
                }
            }
        }
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    private static StringBuilder appendCodeKeeperPluginsInformation(StringBuilder sb) {
        Bundle codeKeeperBundle = Activator.getContext().getBundle();
        sb.append(codeKeeperBundle.getSymbolicName()).append(' ').append(codeKeeperBundle.getVersion()).append('\n');

        codeKeeperBundle = ru.taximaxim.codekeeper.apgdiff.Activator.getContext().getBundle();
        sb.append(codeKeeperBundle.getSymbolicName()).append(' ').append(codeKeeperBundle.getVersion()).append('\n');

        codeKeeperBundle = ru.taximaxim.codekeeper.mainapp.Activator.getDefault().getBundle();
        sb.append(codeKeeperBundle.getSymbolicName()).append(' ').append(codeKeeperBundle.getVersion()).append('\n');
        return sb;
    }
}
