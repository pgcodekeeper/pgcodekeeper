package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class NewProjCreator implements IRunnableWithProgress {
	
	final private PgDbProject props;
	
	final private String dumpPath;
	
	public NewProjCreator(final PgDbProject props,
			final String dumpPath) {
		this.props = props;
		this.dumpPath = dumpPath;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		
		// TODO implement dump parsing, svn init etc
		
		try {
			props.save(); // TODO move/make appropriate
		} catch(IOException ex) {
			throw new InvocationTargetException(ex,
					"Error while saving project PreferenceStore!");
		}
	}
}
