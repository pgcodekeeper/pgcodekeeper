package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;

public class ProjectLoaderParser implements IRunnableWithProgress {
	
	final private String exePgdump, exeSvn; 
	
	final private PgDbProject props;
	
	final private String dumpPath;
	
	public ProjectLoaderParser(final IPreferenceStore mainPrefStore,
			final PgDbProject props,
			final String dumpPath) {
		this.exePgdump = mainPrefStore.getString(UIConsts.PREF_PGDUMP_EXE_PATH);
		this.exeSvn = mainPrefStore.getString(UIConsts.PREF_SVN_EXE_PATH);
		
		this.props = props;
		this.dumpPath = dumpPath;
	}

	@Override
	public void run(IProgressMonitor pm) throws InvocationTargetException,
			InterruptedException {
		try {
			SubMonitor subpm = SubMonitor.convert(pm, "Loading project", 100); // 0
			
			SubMonitor taskpm = subpm.newChild(20); // 20
			PgDatabase db = null;
			
			if(UIConsts.PROJ_SOURCE_TYPE_DUMP.equals(
					props.getString(UIConsts.PROJ_PREF_SOURCE))) {
				taskpm.setWorkRemaining(1).newChild(1).subTask("Loading dump");
				db = PgDumpLoader.loadDatabaseSchemaFromDump(
						dumpPath, props.getString(UIConsts.PROJ_PREF_ENCODING),
						false, false);
			} else {
				db = PgDumper.pgDump(exePgdump, props, taskpm);
			}
			
			subpm.newChild(10).subTask("DB model export"); // 30
			File dirSvn = props.getProjectSchemaDir();
			if(dirSvn.exists()) {
				Dir.deleteRecursive(dirSvn);
			}
			new ModelExporter(dirSvn.getAbsolutePath(), db,
					props.getString(UIConsts.PROJ_PREF_ENCODING)).export();

			SvnExec svn = new SvnExec(exeSvn, props);
			
			subpm.newChild(20).subTask("SVN current rev checkout"); // 50
			try(TempDir tmpDir = new TempDir(props.getProjectPath(),
					"tmp_svn_")) {
				File dirSvnTmp = tmpDir.get();
				
				svn.svnCo(dirSvnTmp);
				File dirSvnMeta = new File(dirSvn, ".svn");
				if(!new File(dirSvnTmp, ".svn").renameTo(dirSvnMeta)) {
					throw new IOException("Failed to move .svn dir!");
				}
			}
			
			subpm.newChild(20).subTask("SVN removing missing files"); // 70
			svn.svnRmMissing(dirSvn);
			
			subpm.newChild(10).subTask("SVN adding new files"); // 80
			svn.svnAddAll(dirSvn);

			subpm.newChild(20).subTask("SVN committing new revision"); // 100
			svn.svnCi(dirSvn, "new rev"); // TODO prompt for comment?

			pm.done();
		} catch(IOException ex) {
			throw new InvocationTargetException(ex,
					"IOException while creating project!");
		}
	}
}
