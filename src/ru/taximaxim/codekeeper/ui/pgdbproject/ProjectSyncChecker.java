package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;

public class ProjectSyncChecker implements IRunnableWithProgress {
	
	final private String exePgdump;
	
	final private PgDbProject proj;
	
	final private String dumpPath;
	
	private boolean finished;
	
	private String diff;
	
	public ProjectSyncChecker(IPreferenceStore mainPrefStore, PgDbProject proj,
			String dumpPath) {
		this.exePgdump = mainPrefStore.getString(UIConsts.PREF_PGDUMP_EXE_PATH);
		
		this.proj = proj;
		this.dumpPath = dumpPath;
	}
	
	public String getDiff() {
		if(!finished) {
			throw new IllegalStateException("Runnable has not yet finished!"
					+ " needsSync is undefined!");
		}
		
		return diff;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		SubMonitor pm = SubMonitor.convert(monitor, "Checking project sync",
				100); // 0

		SubMonitor taskpm = pm.newChild(33); // 33
		PgDatabase db = null;
		
		if(UIConsts.PROJ_SOURCE_TYPE_DUMP.equals(
				proj.getString(UIConsts.PROJ_PREF_SOURCE))) {
			taskpm.setWorkRemaining(1).newChild(1).subTask("Loading dump");
			
			db = PgDumpLoader.loadDatabaseSchemaFromDump(dumpPath,
					proj.getString(UIConsts.PROJ_PREF_ENCODING), false, false);
		} else {
			try {
				db = PgDumper.pgDump(exePgdump, proj, taskpm);
			} catch(IOException ex) {
				throw new InvocationTargetException(ex,
						"IOException while checking sync!");
			}	
		}
		
		pm.newChild(33).subTask("Loading project"); // 66
		PgDatabase dbProj = PgDumpLoader.loadDatabaseSchemaFromDirTree(
				proj.getProjectSchemaDir().getAbsolutePath(), 
				proj.getString(UIConsts.PROJ_PREF_ENCODING), false, false);
		
		pm.newChild(34).subTask("Comparing schemas"); // 100
		PgDiffArguments args = new PgDiffArguments();
		ByteArrayOutputStream diffOut = new ByteArrayOutputStream(1024);
		PrintWriter writer = new PrintWriter(diffOut, true);
		
		PgDiff.diffDatabaseSchemas(writer, args, dbProj, db);
		
		diff = diffOut.toString().trim();
		finished = true;
		
		monitor.done();
	}
}
