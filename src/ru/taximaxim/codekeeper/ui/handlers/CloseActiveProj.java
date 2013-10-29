 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class CloseActiveProj {
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_PART)
			MPart part,
			EPartService partSrv) {
		if(part.getElementId().equals(UIConsts.PROJ_PART_DESCR_ID)) {
			partSrv.hidePart(part);
		}
	}
}