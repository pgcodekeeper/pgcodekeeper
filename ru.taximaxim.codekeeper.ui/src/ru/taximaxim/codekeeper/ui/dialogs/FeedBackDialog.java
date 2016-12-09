package ru.taximaxim.codekeeper.ui.dialogs;

import java.text.MessageFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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

    private static final String EMAIL_TO = "codekeeper@chelny.taximaxim.ru"; //$NON-NLS-1$
    private static final String LOG_FILE_NAME = "codekeeper.log"; //$NON-NLS-1$
    private static final String MAIL_HOST = "mail.chelny.taximaxim.ru"; //$NON-NLS-1$
    private static final String MAIL_PORT = "587"; //$NON-NLS-1$
    private static final String MAIL_HOST_PROP = "mail.smtp.host"; //$NON-NLS-1$
    private static final String MAIL_PORT_PROP = "mail.smtp.port"; //$NON-NLS-1$
    private static final String MAIL_AUTH_PROP = "mail.smtp.auth"; //$NON-NLS-1$
    private static final String MAIL_TLS_PROP = "mail.smtp.starttls.enable"; //$NON-NLS-1$
    private static final String MAIL_USER = "pgcodekeeper-feedback@chelny.taximaxim.ru"; //$NON-NLS-1$
    private static final String MAIL_PASS = "***REMOVED***"; //$NON-NLS-1$

    private Text userName;
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

        new Label(container, SWT.NONE).setText(Messages.name);

        userName = new Text(container, SWT.BORDER);
        userName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

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
        if (txtMessage.getText().isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.FeedBackDialog_emty_msg);
            mb.setMessage(Messages.FeedBackDialog_enter_msg);
            mb.open();
            return;
        }

        try {
            sendMail(emailFrom.getText(), txtMessage.getText(), userName.getText(),
                    btnCheckLog.getSelection(), false);
            super.okPressed();

            MessageBox mb = new MessageBox(getParentShell(), SWT.ICON_INFORMATION);
            mb.setText(Messages.FeedBackDialog_feedback_sent);
            mb.setMessage(Messages.FeedBackDialog_thank_you);
            mb.open();
        } catch (AddressException ae) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.FeedBackDialog_invalid_address);
            mb.setMessage(Messages.FeedBackDialog_enter_email);
            mb.open();
        } catch (MessagingException mex) {
            Log.log(mex);
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR);
            mb.setText(Messages.FeedBackDialog_could_not_send);
            mb.setMessage(MessageFormat.format(Messages.FeedBackDialog_failure_instruction, mex.getLocalizedMessage()));
            mb.open();
        }
    }

    static void sendMail(String emailFrom, String txtMessage, String user, boolean appendLog, boolean mailDebug)
            throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty(MAIL_HOST_PROP, MAIL_HOST);
        properties.setProperty(MAIL_PORT_PROP, MAIL_PORT);
        properties.setProperty(MAIL_AUTH_PROP, Boolean.TRUE.toString());
        properties.setProperty(MAIL_TLS_PROP, Boolean.TRUE.toString());
        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MAIL_USER, MAIL_PASS);
            }
        });

        if (mailDebug) {
            session.setDebug(true);
        }

        MimeMessage message = new MimeMessage(session);

        InternetAddress internetAddress = new InternetAddress(emailFrom);
        internetAddress.validate();
        message.setFrom(internetAddress);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_TO));
        message.setSubject(Messages.FeedBackDialog_feedback_subject);

        Multipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();

        StringBuilder sbText = new StringBuilder();
        sbText.append(txtMessage);
        if (!user.isEmpty()) {
            sbText.append(Messages.FeedBackDialog_best_regards).append(user);
        }

        sbText.append("\n\n------pgCodeKeeper configuration--------\n"); //$NON-NLS-1$
        appendCodeKeeperPluginsInformation(sbText);

        messageBodyPart.setText(sbText.toString());
        multipart.addBodyPart(messageBodyPart);

        if (appendLog) {
            // TODO check file size
            // see ByteArrayDataSource
            BodyPart fileAttachBodyPart = new MimeBodyPart();
            String filename = Platform.getLogFileLocation().toOSString();
            DataSource source = new FileDataSource(filename);
            fileAttachBodyPart.setDataHandler(new DataHandler(source));
            fileAttachBodyPart.setFileName(LOG_FILE_NAME);

            multipart.addBodyPart(fileAttachBodyPart);
        }

        message.setContent(multipart);
        Transport.send(message);
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
