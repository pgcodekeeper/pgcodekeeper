 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class LoadProj {
	@Execute
	public void execute(
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell,
			EPartService partService, EModelService model, MApplication app,
			IEventBroker events) throws IOException {
		DirectoryDialog dialog = new DirectoryDialog(shell);
		String path = dialog.open();
		if(path != null) {
			PgDbProject proj = new PgDbProject(path);
			load(proj, partService, model, app, events);
		}
	}
	
	public static void load(PgDbProject proj, EPartService partService,
			EModelService model, MApplication app, IEventBroker events) throws IOException {
		for(MPart existingPart : partService.getParts()) {
			String partProjId = existingPart.getPersistedState().get(
					UIConsts.PROJ_PART_PERSISTED_ID);
			if(partProjId != null && !partProjId.isEmpty()
					&& new File(partProjId).equals(proj.getProjectDirFile())) {
				partService.hidePart(existingPart);
				break;
			}
		}
		
		if(!proj.getProjectPropsFile().isFile()) {
			throw new FileNotFoundException(
					proj.getProjectPropsFile().getAbsolutePath());
		}
		
		MPart part = partService.createPart(UIConsts.PROJ_PART_DESCR_ID);
		part.getPersistedState().put(UIConsts.PROJ_PART_PERSISTED_ID,
				proj.getProjectDir());
		part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		
		((MPartStack) model.find(UIConsts.PROJ_PART_STACK_ID, app))
			.getChildren().add(part);
		partService.activate(part);
	}
}