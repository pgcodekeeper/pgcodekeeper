package ru.taximaxim.codekeeper.ui.dialogs;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Transport;

import org.junit.Test;

public class MailSenderTest {

    @Test
    public void testMailSender() throws MessagingException, IOException {
        final Thread th = Thread.currentThread();
        final ClassLoader cl = th.getContextClassLoader();

        // when running under Maven, Tycho replaces Context CL with its own
        // that isn't OSGi aware or simply cannot load SMTPTransport for some other reason
        // for some other reason javax.mail tries to use Context CL to load Transports
        // the end result is this piece of magic that makes it all work

        // NOTE: with no Tycho running, the Context CL is OSGi aware (some Equinox impl)
        //       and everything works fine (including production builds)

        // see also https://bugs.eclipse.org/bugs/show_bug.cgi?id=485926

        th.setContextClassLoader(Transport.class.getClassLoader());
        try {
            FeedBackDialog.sendMail("unittest@example.com", "Unit Test Mail",
                    "Testing mail sender", "Unit McTester", true, true);
        } finally {
            th.setContextClassLoader(cl);
        }
    }
}
