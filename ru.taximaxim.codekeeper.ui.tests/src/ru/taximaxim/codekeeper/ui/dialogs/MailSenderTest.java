package ru.taximaxim.codekeeper.ui.dialogs;

import javax.mail.MessagingException;

import org.junit.Test;

public class MailSenderTest {

    @Test
    public void testMailSender() throws MessagingException {
        FeedBackDialog.sendMail("unittest@example.com", "Testing mail sender", "Unit McTester", true, true);
    }
}
