 
package ru.taximaxim.codekeeper.ui.handlers;

import java.awt.Desktop;
import java.io.IOException;

import javax.inject.Named;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class OpenLog {
    
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
	    IPath path = Platform.getLogFileLocation();
	    try {
            Desktop.getDesktop().open(path.toFile());
        } catch (IOException | IllegalArgumentException e) {
            MessageBox mb = new MessageBox(shell, SWT.ERROR);
            mb.setMessage("Could not open log file at location:\n" + path.toFile());
            mb.open();
        }
	}
		
}