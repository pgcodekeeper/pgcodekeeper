
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class About {
	@Execute
	public void execute(Shell parentShell) {
		MessageBox m = new MessageBox(parentShell, SWT.ICON_INFORMATION);
		m.setMessage("qweasd");
		m.open();
	}
}