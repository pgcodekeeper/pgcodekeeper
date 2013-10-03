 
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

public class Exit {
	@Execute
	public void execute(Shell shell) {
		shell.close();
	}
}