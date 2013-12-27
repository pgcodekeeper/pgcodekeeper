 
package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class Exit {
	@Execute
	private void execute(IWorkbench wb) {
		wb.close();
	}
}