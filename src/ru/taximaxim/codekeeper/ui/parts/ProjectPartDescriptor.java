package ru.taximaxim.codekeeper.ui.parts;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class ProjectPartDescriptor {
	
	private PgDbProject proj;
	
	@PostConstruct
	public void postConstruct(Composite parent, MPart part) throws IOException {
		proj = new PgDbProject(part.getPersistedState()
				.get(UIConsts.PROJ_PART_PERSISTED_ID));
		proj.load();
		
		part.setLabel(proj.getProjectName());
		
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy");
	}
	
	@Focus
	public void onFocus() {
	}
}
