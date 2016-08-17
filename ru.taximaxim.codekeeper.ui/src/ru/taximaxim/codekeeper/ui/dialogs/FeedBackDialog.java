package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class FeedBackDialog extends Dialog {

    private String emailTo = "codekeeper@chelny.taximaxim.ru";

    final static String LOG_FILE_NAME = "codeKeeper.log";
    final static String MAIL_HOST = "mail.chelny.taximaxim.ru";

    private Text userName;
    private Text emailFrom;
    private Text txtSubject;
    private Text txtMessage;
    private Button btnCheckLog;

    /**
     * Create the dialog.
     * @param parentShell
     */
    public FeedBackDialog(Shell parentShell) {
        super(parentShell);
    }

    /**
     * Create contents of the dialog.
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout(4, false));

        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setText(Messages.name);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        userName = new Text(container, SWT.BORDER);
        userName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblNewLabel_1 = new Label(container, SWT.NONE);
        lblNewLabel_1.setText(Messages.e_mail);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        emailFrom = new Text(container, SWT.BORDER);
        emailFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblNewLabel_2 = new Label(container, SWT.NONE);
        lblNewLabel_2.setText(Messages.subject);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        txtSubject = new Text(container, SWT.BORDER);
        txtSubject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblNewLabel_3 = new Label(container, SWT.NONE);
        lblNewLabel_3.setText(Messages.feedback_message);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        txtMessage = new Text(container, SWT.BORDER | SWT.MULTI);
        GridData gd_text_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_text_3.heightHint = 72;
        txtMessage.setLayoutData(gd_text_3);

        btnCheckLog = new Button(container, SWT.CHECK);
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        Label lblNewLabel_4 = new Label(container, SWT.NONE);
        lblNewLabel_4.setText(Messages.add_log);

        return container;
    }

    /**
     * Create contents of the button bar.
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "Отправить", true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

    @Override
    protected void okPressed() {
        if (txtMessage == null || "".equals(txtMessage.getText())){
            MessageDialog.openWarning(getParentShell(), "Feedback", "Text message is empty!");
        }
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", MAIL_HOST);

        Session session = Session.getDefaultInstance(properties);

        try{

            Multipart multipart = new MimeMultipart();
            MimeMessage message = new MimeMessage(session);

            InternetAddress internetAddress = new InternetAddress(emailFrom.getText());
            internetAddress.validate();
            message.setFrom(internetAddress);

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));

            message.setSubject(txtSubject.getText());
            StringBuffer sbText = new StringBuffer();
            sbText.append(txtMessage.getText());
            if (userName != null && !"".equals(userName.getText())){
                sbText.append("\n\n").append("Best Regards\n").append(userName.getText());
            }

            sbText.append("\n------CodeKeeper configuration--------\n").
            append(getCodeKeeperPluginsInformation()).append("\n");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(sbText.toString());
            multipart.addBodyPart(messageBodyPart);

            if (btnCheckLog.getSelection()){
                BodyPart fileAttachBodyPart = new MimeBodyPart();
                String filename = Platform.getLogFileLocation().toOSString();
                DataSource source = new FileDataSource(filename);
                fileAttachBodyPart.setDataHandler(new DataHandler(source));
                fileAttachBodyPart.setFileName(LOG_FILE_NAME);

                BodyPart configBodyPart = new MimeBodyPart();
                configBodyPart.setText(getCodeKeeperPluginsInformation());

                multipart.addBodyPart(fileAttachBodyPart);
            }
            message.setContent(multipart);

            Transport.send(message);
            Log.log(Log.LOG_INFO, Messages.feedback_message_sent_successfull);
        } catch (AddressException ae){
            MessageDialog.openWarning(getParentShell(), "Feedback", "E-mail address incorrect!");
            return;
        } catch (MessagingException mex) {
            Log.log(Log.LOG_ERROR, Messages.feedback_message_sent_successfull, mex);
            return;
        }
        super.okPressed();
    }

    private String getCodeKeeperPluginsInformation(){
        StringBuffer sb = new StringBuffer();
        Bundle codeKeeperBundle = Activator.getContext().getBundle();
        sb.append(codeKeeperBundle.getSymbolicName()).append(" ").append(codeKeeperBundle.getVersion()).append("\n");
        codeKeeperBundle = ru.taximaxim.codekeeper.apgdiff.Activator.getContext().getBundle();
        sb.append(codeKeeperBundle.getSymbolicName()).append(" ").append(codeKeeperBundle.getVersion()).append("\n");
        codeKeeperBundle = Platform.getBundle("ru.taximaxim.codekeeper.mainapp");
        sb.append(codeKeeperBundle.getSymbolicName()).append(" ").append(codeKeeperBundle.getVersion()).append("\n");
        return sb.toString();
    }

}
